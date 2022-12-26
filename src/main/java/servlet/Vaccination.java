package servlet;

import java.io.IOException;	
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.DbService;
import model.VaccinationEntry;
@WebServlet(urlPatterns = "/Vaccination", loadOnStartup = 1)
public class Vaccination extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    
    public Vaccination() {
        super();
        
    }	
    
    @SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	DbService dbService = new DbService();
//    	List<VaccinationEntry> Vaccines = new ArrayList<VaccinationEntry>();
//    	Vaccines =dbService.getEntries();
//    	System.out.println(dbService.getEntries().get(0).getName());
    	
        request.setAttribute( "entries",dbService.getEntries() );
//    	getServletContext().setAttribute("entries", dbService.getEntries());
        dbService.close();
        
		request.getRequestDispatcher("/WEB-INF/Vaccination.jsp").forward(request, response);

	
	
	
	}
}

