package servlet;

import java.io.IOException;	
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.DbService;
import model.VaccinationEntry;

/**
 * Servlet implementation class NewDose
 */
@WebServlet("/NewDose")
public class NewDose extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewDose() {
        super();
        // TODO Auto-generated constructor stub
    }
    @SuppressWarnings("unchecked")
    private VaccinationEntry getEntry(String VaccineName) {
    	DbService dbservice = new DbService();
    	List<VaccinationEntry> entries = dbservice.getEntries();
		 
		 dbservice.close();
//    	List<VaccinationEntry> entries = (List<VaccinationEntry>) getServletContext().getAttribute("entries");
    	for(VaccinationEntry entry: entries)
    		if(entry.getName().equals(VaccineName)) return entry;
    	return null;
    }

	
    @SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	
		DbService dbservice = new DbService();
		 request.setAttribute( "entries",dbservice.getEntries() );
		 dbservice.close();
		request.getRequestDispatcher("/WEB-INF/NewDose.jsp").forward(request, response);
//		response.setContentType( "text/html" );
//		PrintWriter out = response.getWriter();
//		out.println( "<html><head><title>New Dose</title></head><body>" );
//		
//    	out.println("<form action='NewDose' method='post'>");
//    	out.println("<table border = 1px padding='1px'>");
//    	out.println("<tr>");
//    	out.println("<td>Vaccine</td>");
//    	out.println("<td>");
//    	out.println("<select name='VaccineDropDown'>");
//    	for(VaccinationEntry entry : entries) {
//    		out.println("<option value='"+ entry.getName() +"'>"+ entry.getName() +"</option>");
//    	}
//    	out.println("</td>");
//    	out.println("</tr>");
//    	out.println("<tr><td>New Doses Received</td>");
//    	out.println("<td><input type='text' name='dosesReceived'</td>");
//    	out.println("</tr>");
//    	out.println("<tr><td colspan='2'><button>Add</button></td></tr></table>");
//    	out.println("</form>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		VaccinationEntry entry = getEntry(request.getParameter("VaccineDropDown"));
		int id = entry.getId();
		entry.setDosesReceived(Integer.parseInt(request.getParameter("dosesReceived")));
		entry.setTotalDosesLeft(Integer.parseInt(request.getParameter("dosesReceived")));
		int dosereceived= entry.getdosesReceived();
		int totaldosesleft= entry.getTotalDosesLeft();
		
		DbService dbservice = new DbService();
		
		dbservice.addDose(entry, id, dosereceived, totaldosesleft);
		dbservice.close();
//		entry.setDosesReceived(Integer.parseInt(request.getParameter("dosesReceived")));
//		entry.setTotalDosesLeft(Integer.parseInt(request.getParameter("dosesReceived")));
		response.sendRedirect("Vaccination");
	}

}
