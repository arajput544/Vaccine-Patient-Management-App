package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.PreparedStatement;

import model.PatientEntry;
import model.PatientViewModel;
import model.VaccinationEntry;

public class DbService {
	

		String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu117";
        String username = "cs3220stu117";
        String password = "v4q42hKUx7Xv";

	    private Connection connection;

	    public DbService()
	    {
	        try
	        {
	            connection = DriverManager.getConnection( url, username, password );
	        }
	        catch( SQLException e )
	        {
	            e.printStackTrace();
	        }
	    }

	    public void close()
	    {
	        if( connection != null )
	        {
	            try
	            {
	                connection.close();
	            }
	            catch( SQLException e )
	            {
	                e.printStackTrace();
	            }
	        }
	    }
		public List<VaccinationEntry> getEntries(){
	    	List<VaccinationEntry> entries = new ArrayList<VaccinationEntry>();

	        try
	        {
	            Statement stmt = connection.createStatement();
	            ResultSet rs = stmt.executeQuery( "select * from vaccines" );
	            while( rs.next() )
	            {
	                VaccinationEntry entry = new VaccinationEntry();
	                entry.setId( rs.getInt("id") );
	                System.out.println(rs.getInt("id"));
	                entry.setName( rs.getString( "vaccine" ) );
	                entry.setDosesRequired( rs.getInt( "doserequired" ) );
	                entry.setDaysBetweenDoses(rs.getInt("days_between_doses"));
	                entry.setDosesReceived(rs.getInt("total_doses_recieved"));
	                entry.setTotalDosesLeft(rs.getInt("total_doses_left"));
	                entries.add( entry );
	            }
	            stmt.close();
	        }
	        catch( SQLException e )
	        {
	            e.printStackTrace();
	        }

	        return entries;
	    	
	    
	    	
	    }
		public VaccinationEntry getEntry( int id )
	    {
			VaccinationEntry entry = new VaccinationEntry();
	        try
	        {
	            String sql = "select * from vaccines where id = ?";
	            PreparedStatement pstmt = connection.prepareStatement( sql );
	            pstmt.setInt( 1, id );
	            ResultSet rs = pstmt.executeQuery();
	            if( rs.next() )
	            {
	            	entry.setId( rs.getInt("id") );
//	                System.out.println(rs.getInt("id"));
	                entry.setName( rs.getString( "vaccine" ) );
	                entry.setDosesRequired( rs.getInt( "doserequired" ) );
	                entry.setDaysBetweenDoses(rs.getInt("days_between_doses"));
	                entry.setDosesReceived(rs.getInt("total_doses_recieved"));
	                entry.setTotalDosesLeft(rs.getInt("total_doses_left"));
	                
	            }
	            pstmt.close();
	        }
	        catch( SQLException e )
	        {
	            e.printStackTrace();
	        }
	        return entry;
	    }
		public void updateEntry(int id,String Vaccine,int doses,int daysbetweendoses) {
			try
	        {
	            String sql = "update vaccines set vaccine = ?, doserequired = ?, days_between_doses=? where id = ?";
	            PreparedStatement pstmt = connection.prepareStatement( sql );
	            pstmt.setString( 1, Vaccine );
	            pstmt.setInt( 2, doses );
	            pstmt.setInt(3,daysbetweendoses );
	            pstmt.setInt( 4, id );
	            pstmt.executeUpdate();
	            pstmt.close();
	        }
	        catch( SQLException e )
	        {
	            e.printStackTrace();
	        }
			
			
		}
		public void addEntry( String vaccine, int doserequired, int daysbetweendoses )
	    {
	        int id = 0;
	        try
	        {
	            String sql = "insert into vaccines (vaccine, doserequired,days_between_doses) values (?, ?,?)";
	            PreparedStatement pstmt = connection.prepareStatement( sql,
	                Statement.RETURN_GENERATED_KEYS );
	            pstmt.setString( 1, vaccine);
	            pstmt.setInt( 2, doserequired );
	            pstmt.setInt(3, daysbetweendoses);
	            pstmt.executeUpdate();
	            ResultSet rs = pstmt.getGeneratedKeys();
	            if( rs.next() ) id = rs.getInt( 1 );
	            pstmt.close();
	        }
	        catch( SQLException e )
	        {
	            e.printStackTrace();
	        }
//	        return id;
	    
	    }
		public void addDose(VaccinationEntry entry,int id,int dosesreceived, int totaldosesleft) {
			try
	        {
				String sql = "update vaccines set total_doses_recieved=?, total_doses_left=? where id = ?";
	            PreparedStatement pstmt = connection.prepareStatement( sql );
	            pstmt.setInt( 1, dosesreceived );
	            pstmt.setInt( 2, totaldosesleft);
	            pstmt.setInt(3,id);	           
	            pstmt.executeUpdate();
	            pstmt.close();
	            ResultSet rs = pstmt.executeQuery();
	            if( rs.next() )
	            {
	            	
	                entry.setDosesReceived(rs.getInt("total_doses_recieved"));
	                entry.setTotalDosesLeft(rs.getInt("total_doses_left"));
	                
	            }
	            pstmt.close();
	        }
	        catch( SQLException e )
	        {
	            e.printStackTrace();
	        }
			
			
		}
		public List<PatientEntry> getPList(){
			List<PatientEntry> plist = new ArrayList<PatientEntry>();

	        try
	        {
	            Statement stmt = connection.createStatement();
	            ResultSet rs = stmt.executeQuery( "select * from patients" );
	            while( rs.next() )
	            {
	                PatientEntry patient = new PatientEntry();
	                patient.setId( rs.getInt("pid") );
//	                System.out.println(rs.getInt("pid"));
	                patient.setName( rs.getString( "name" ) );
	                VaccinationEntry v1= new VaccinationEntry();
	                String Vaccine=rs.getString("vaccine");
	                v1.setName(Vaccine);
	                v1.setTotalDosesLeft(0);
	                patient.setVaccine(v1);
	                patient.setDate1(rs.getString("firstdose"));
	                patient.setDate2(rs.getString("seconddose"));
	                plist.add( patient );
	            }
	            stmt.close(); 
	        }
	        catch( SQLException e )
	        {
	            e.printStackTrace();
	        }

	        return plist;
	    	
	    
	    	
	    }
//		public List<PatientViewModel> getPatientViewList(){
//			List<PatientViewModel> pViewlist = new ArrayList<PatientViewModel>();
//
//	        try
//	        {
//	            Statement stmt = connection.createStatement();
//	            ResultSet rs = stmt.executeQuery( "select * from PatientViewModel" );
//	            while( rs.next() )
//	            {
//	                PatientViewModel patient = new PatientViewModel();
//	                patient.setId( rs.getInt("id") );
////	                System.out.println(rs.getInt("pid"));
//	                patient.setName( rs.getString( "name" ) );
//	                patient.setVaccineId(rs.getInt("vaccineid"));
//	                patient.setVaccineName(rs.getInt("vaccinename"));
//	                patient.setVaccineDosesRequired(rs.getInt("vaccineDosesRequired"));
//	                patient.setVaccineDosesLeft(rs.getInt("vaccineDosesLeft"));
//	                patient.setFirstDoseDate(rs.getString("firstDoseDate"));
//	                patient.setSecondDoseDate(rs.getString("secondDoseDate"));
//	                
//	            }
//	            stmt.close(); 
//	        }
//	        catch( SQLException e )
//	        {
//	            e.printStackTrace();
//	        }
//
//	        return plist;
//	    	
//	    
//	    	
//	    }
		
		
		public void addPatient(String name,VaccinationEntry entry ,String firstdose) {
			@SuppressWarnings("unused")
			int id = 0;
	        try
	        {
//	        	List<PatientEntry> plist= getPList();
//	        	PatientEntry patient =new PatientEntry();
//	        	patient.setName(name);
//	        	patient.setVaccine(entry);
//	        	patient.setDate1(firstdose);
//	        	plist.add(patient);
	        	String vaccinename= entry.getName();
	        	int totalDosesLeft= entry.getTotalDosesLeft();
	    		entry.setTotalDosesLeft(totalDosesLeft-1);
	    		System.out.println(totalDosesLeft);
	            String sql = "insert into patients (name, vaccine,firstdose) values (?, ?,?)";
	            PreparedStatement pstmt = connection.prepareStatement( sql,
	                Statement.RETURN_GENERATED_KEYS );
	            pstmt.setString( 1, name);	            
	            pstmt.setString( 2,  vaccinename);
	            pstmt.setString(3, firstdose);	            
	            pstmt.executeUpdate();
	            ResultSet rs = pstmt.getGeneratedKeys();
	            if( rs.next() ) id = rs.getInt( 1 );
	            pstmt.close();
	        }
	        catch( SQLException e )
	        {
	            e.printStackTrace();
	        }
//	        return id;
			
			
		}
//		public void addPatientViewModel(VaccinationEntry entry, String name, String firstdose) {
//			
//			try {
//	            Statement stmt = connection.createStatement();
//	            ResultSet rs = stmt.executeQuery("select p.id, concat(p.first_name, \" \", p.last_name) as name, p.vaccine_id AS vaccineID, v.name AS vaccine_name, v.doses_required, v.days_between_doses, p.first_dose_date, p.second_dose_date, v.doses_left from patients p join vaccines v on p.vaccine_id = v.id");
//	            while (rs.next()) {
//	                PatientViewModel entry = new PatientViewModel();
//	                entry.setId(rs.getInt("id"));
//	                entry.setName(rs.getString("name"));
//	                entry.setVaccineId(rs.getInt("vaccineID"));
//	                entry.setVaccineName(rs.getString("vaccine_name"));
//	                entry.setVaccineDosesRequired(rs.getInt("doses_required"));
//	                entry.setVaccineDosesLeft(rs.getInt("doses_left"));
//	                entry.setFirstDoseDate(rs.getString("first_dose_date"));
//	                entry.setSecondDoseDate(rs.getString("second_dose_date"));
//	                entries.add(entry);
//	            }
//	            stmt.close();
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//
//	        return entries;
//	    }
//			
//			
//		}
		public void getVaccine() {
			List<PatientEntry> Patients= getPList();
			try
	        {
	            Statement stmt = connection.createStatement();
	            ResultSet rs = stmt.executeQuery( "select total_doses_left,vaccine from vaccines" );
	            while( rs.next() )
	            {
	            	for(PatientEntry patient: Patients) {
	            		if(patient.getVaccine().getName().equals(rs.getString("vaccine"))) {
	            			patient.getVaccine().setTotalDosesLeft(rs.getInt("total_doses_left"));
	            			
	            		}
	            		
	    			}
	    			
	             
	            }
	            stmt.close(); 
	        }
	        catch( SQLException e )
	        {
	            e.printStackTrace();
	        }
			
			
		}
}