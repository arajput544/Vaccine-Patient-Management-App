package model;

public class VaccinationEntry {
	static int idSeed = 1;
	private int id;
	private String name;
	private int dosesRequired;
	private int daysBetweenDoses;
	private int dosesReceived=0;
	private int totalDosesLeft;
	private int dosesGivenToPatients;
	
//	public VaccinationEntry() {
//		
//	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getDosesRequired() {
		return dosesRequired;
	}
	
	public void setDosesRequired(int dosesRequired) {
		this.dosesRequired = dosesRequired;
	}
	
	public int getDaysBetweenDoses() {
		return daysBetweenDoses;
	}
	
	public void setDaysBetweenDoses(int daysBetweenDoses) {
		this.daysBetweenDoses = daysBetweenDoses;
	}
	
	public int getdosesReceived() {
		return dosesReceived;
	}
	
	public void setDosesReceived(int dosesReceived) {
		this.dosesReceived += dosesReceived;
	}
	
	public int getTotalDosesLeft() {
		return totalDosesLeft;
	}
	
	public void setTotalDosesLeft(int totalDosesLeft) {
		this.totalDosesLeft += totalDosesLeft;
	}
	
	public int getDosesGivenToPatients() {
		return dosesGivenToPatients;
	}
	
	public void setDosesGivenToPatients(int dosesGivenToPatients) {
		this.dosesGivenToPatients += dosesGivenToPatients;
	}


}


