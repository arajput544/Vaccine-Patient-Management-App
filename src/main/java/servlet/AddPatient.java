package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.DbService;
import model.PatientEntry;
import model.VaccinationEntry;

/**
 * Servlet implementation class AddPatient
 */
@WebServlet("/AddPatient")
public class AddPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPatient() {
        super();
        // TODO Auto-generated constructor stub
    }
//    private PatientEntry getPatient(int id) {
//    	List<PatientEntry> PatientList = (List<PatientEntry>) getServletContext().getAttribute("pList");
//    	for(PatientEntry patient: PatientList) {
//    		if(patient.getId() == id ) return patient;
//    	return null;
//    	}
//    	
//    }
    @SuppressWarnings("unchecked")    
	private VaccinationEntry getEntry(String VaccineName) {
    	DbService dbservice = new DbService();
    	List<VaccinationEntry> entries = dbservice.getEntries();
    	dbservice.close();
    	
    	for(VaccinationEntry entry: entries)
    		if(entry.getName().equals(VaccineName)) return entry;
    	return null;
    }


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		@SuppressWarnings("unchecked")
//		List<PatientEntry> PatientList= (List<PatientEntry>) getServletContext().getAttribute("pList");		
		DbService dbservice = new DbService();
    	request.setAttribute("entries", dbservice.getEntries());   
    	dbservice.close();		
		request.getRequestDispatcher("/WEB-INF/AddPatient.jsp").forward(request, response);
	}
	@SuppressWarnings({ "unused", "unchecked" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DbService dbservice = new DbService();
//    	List<VaccinationEntry> entries = dbservice.getEntries();
//    	request.setAttribute( "entries",dbservice.getEntries() );
    
    	
		VaccinationEntry entry = getEntry(request.getParameter("VaccineDropDown"));
		String name = request.getParameter("name");
//		String vaccinename=entry.getName();
		List<PatientEntry> PatientList = dbservice.getPList();	
		for(PatientEntry patient: PatientList) {
			if(patient.getName()=="name") {
				patient.setVaccine(entry);
			}
			
		}
		LocalDate d= java.time.LocalDate.now();
		String s=String.valueOf(d);		
//		PatientEntry v1= new PatientEntry();
//		v1.setDate1(s);
//		PatientList.add(v1);
//		int totalDosesLeft= entry.getTotalDosesLeft();
//		entry.setTotalDosesLeft(totalDosesLeft-1);
//		System.out.println(entry.getTotalDosesLeft());
		dbservice.addPatient(name, entry, s);
		dbservice.close();
		response.sendRedirect("ListPatient");
		
		
		
	}

}
