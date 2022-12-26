 package servlet;
import model.PatientEntry;
import model.VaccinationEntry;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.DbService;

/**
 * Servlet implementation class ListPatient
 */
@WebServlet("/ListPatient")
public class ListPatient extends HttpServlet {
	private static final long serialVersionUID = 	1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPatient() {
        super();
        // TODO Auto-generated constructor stub
    }

    private PatientEntry getPatient(int id) {
    	DbService dbservice= new DbService();
    	List<PatientEntry> PatientList = dbservice.getPList();
    	dbservice.close();
    	for(PatientEntry patient: PatientList) {
    		if(patient.getId() == id ) return patient;
    	
    	}
		return null;
    	
    }
    @SuppressWarnings("unchecked")    
	private VaccinationEntry getEntry(String VaccineName) {
    	DbService dbservice= new DbService();
		List<VaccinationEntry> entries = dbservice.getEntries();
		dbservice.close();
    	for(VaccinationEntry entry: entries)
    		if(entry.getName().equals(VaccineName)) return entry;
    	return null;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		DbService dbservice=new DbService();
		List<PatientEntry> patients=dbservice.getPList();
		dbservice.getVaccine();
		for(PatientEntry patient: patients) {
			System.out.println(patient.getVaccine().getTotalDosesLeft());
		}
//		request.setAttribute("entries", dbservice.getEntries());
		List<VaccinationEntry> entries = dbservice.getEntries();
		
    	for(VaccinationEntry entry: entries) {
    		entry.getTotalDosesLeft();
    	}
    		
		
		request.setAttribute( "pList",dbservice.getPList());
		dbservice.close();
		
//		for(PatientEntry pt: PatientList ) {
//			System.out.println(pt.getId());
//			System.out.println(pt.getName());
//			System.out.println(pt.getVaccine());
//			
//		}
		request.getRequestDispatcher("/WEB-INF/ListPatient.jsp").forward(request, response);
		
		
		
	}

	
	@SuppressWarnings({ "unused", "unchecked" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DbService dbservice= new DbService();
		List<PatientEntry> PatientList = dbservice.getPList();
		VaccinationEntry v2 = getEntry(request.getParameter("vaccinename")); 
		LocalDate d= java.time.LocalDate.now();
		String s=String.valueOf(d);
		PatientEntry patient = getPatient(Integer.parseInt(request.getParameter("id")));
//		System.out.print(patient.getId());
//		System.out.print(patient.getName());
//		System.out.print(patient.getDate1());
//		System.out.print(patient.getVaccine());

		patient.setDate2(s);	
		int totalDosesLeft= v2.getTotalDosesLeft();
		v2.setTotalDosesLeft(totalDosesLeft-1);
		response.sendRedirect("ListPatient");
		return;		
		
		
	}

}
