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

@WebServlet("/EditEntry")
public class EditEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EditEntry() {
        super();
        
    }

	
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   	int id = Integer.parseInt(request.getParameter("id"));
    	request.setAttribute("id", id);
    	DbService dbService = new DbService();
        request.setAttribute( "entry", dbService.getEntry( id ) );
        dbService.close();
    		

    	request.getRequestDispatcher("/WEB-INF/EditEntry.jsp").forward(request, response);

    	
    	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String vaccine = request.getParameter("name");
		int doserequired=Integer.parseInt(request.getParameter("doses"));
		int days_between_doses = Integer.parseInt(request.getParameter("daysBetweenDoses"));
		DbService dbService = new DbService();
		dbService.updateEntry(id, vaccine, doserequired, days_between_doses);
		
//		VaccinationEntry entry = getEntry(Integer.parseInt(request.getParameter("id")));
//		entry.setName(request.getParameter("name"));
//		entry.setDosesRequired(Integer.parseInt(request.getParameter("doses")));
//		entry.setDaysBetweenDoses(Integer.parseInt(request.getParameter("daysBetweenDoses")));
		response.sendRedirect("Vaccination");
	}

}
