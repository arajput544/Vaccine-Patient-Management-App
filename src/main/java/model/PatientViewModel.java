package model;

public class PatientViewModel {
	    int id;
	    String name;
	    int vaccineId;
	    int vaccineName;
	    int vaccineDosesRequired;
	    int vaccineDosesLeft;
	    String firstDoseDate;
	    String secondDoseDate;
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
		public int getVaccineId() {
			return vaccineId;
		}
		public void setVaccineId(int vaccineId) {
			this.vaccineId = vaccineId;
		}
		public int getVaccineName() {
			return vaccineName;
		}
		public void setVaccineName(int vaccineName) {
			this.vaccineName = vaccineName;
		}
		public int getVaccineDosesRequired() {
			return vaccineDosesRequired;
		}
		public void setVaccineDosesRequired(int vaccineDosesRequired) {
			this.vaccineDosesRequired = vaccineDosesRequired;
		}
		public int getVaccineDosesLeft() {
			return vaccineDosesLeft;
		}
		public void setVaccineDosesLeft(int vaccineDosesLeft) {
			this.vaccineDosesLeft = vaccineDosesLeft;
		}
		public String getFirstDoseDate() {
			return firstDoseDate;
		}
		public void setFirstDoseDate(String firstDoseDate) {
			this.firstDoseDate = firstDoseDate;
		}
		public String getSecondDoseDate() {
			return secondDoseDate;
		}
		public void setSecondDoseDate(String secondDoseDate) {
			this.secondDoseDate = secondDoseDate;
		}
	    
	    

}
