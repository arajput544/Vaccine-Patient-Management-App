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

@WebServlet("/NewVaccine")
public class NewVaccine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public NewVaccine() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		response.setContentType( "text/html" );
//		PrintWriter out = response.getWriter();
//		out.println( "<html><head><title>New Vaccine</title></head><body>" ); 
//    	out.println("<form action='NewVaccine' method='post'>");
//    	out.println("<table border = 1px padding='1px'>");
//    	out.println("<tr>");
//    	out.println("<td>Name:</td>");    	
//    	out.println("<td><input type='text' name='name'></td>");    	
//    	out.println("</tr>");
//    	out.println("<tr>");
//    	out.println("<tr><td>Doses Required:</td>");
//    	out.println("<td><select name='doses'>");
//    	out.println("<option value='1'>1</option>"
//    			+ 	"<option value='2'>2</option>"
//    			+ 	"</select></td></tr>");
//    	out.println("<tr><td>Days Between Doses:</td>");
//    	out.println("<td><input type='text' name='daysBetweenDoses'></td></tr>");
//    	out.println("<tr><td colspan='2'><button>Save</button></td></tr></table>");
//    	out.println("</form>");
		request.getRequestDispatcher("/WEB-INF/NewVaccine.jsp").forward(request, response);
	}

	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String vaccine = request.getParameter("name");
		int doserequired = Integer.parseInt(request.getParameter("doses"));
		int daysbetweendoses = Integer.parseInt(request.getParameter("daysBetweenDoses"));
		DbService dbService = new DbService();
        dbService.addEntry( vaccine, doserequired,daysbetweendoses );
        dbService.close();
		//		VaccinationEntry entry = new VaccinationEntry();
//		
//		List<VaccinationEntry> entries = (List<VaccinationEntry>) getServletContext().getAttribute("entries");	
//		entries.add(entry);
		
		response.sendRedirect("Vaccination");
	}

}
