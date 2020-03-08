package examp_2009_fmi_pld;

public class Student {
	private String name;
	private String facultyNumber;
	private int yearOfRegistration;
	private String specialty;
	private String studyType;
	private int idLastDiigts;
	public Student(String facultyNumber) {
		this.facultyNumber = facultyNumber;
	}
	
	public void extractDataFromFacultyNumber(String facultyNumber) {
		this.name="no name assigned";
		this.facultyNumber = facultyNumber;
		
	}
	
	private void setYearOfRegistration() {
		this.yearOfRegistration = Integer.parseInt(facultyNumber.substring(0,2));
	}
	
	public int getYearOfRegistration() {
		return this.yearOfRegistration;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	private void setSpecialty() {
		
		switch(Integer.parseInt(facultyNumber.substring(3,5))) {
		case 1:
			specialty  ="Informatics";
			break;
		case 2:
			specialty = "Business Informatics";
			break;
		case 3:
			specialty = "Mathematics";
			break;
		case 4:
			specialty = "Math adn Informatics";
			break;
			default:
				specialty = "null";
				break;
		}
	}
	
	public String getSpecialty() {
		return this.specialty;
	}
	
	
	private void setStudyType() {
		switch(Integer.parseInt(facultyNumber.substring(6,7))) {
		case 1:
			studyType = "Regular";
			
			break;
			default:
				studyType = "Absent";
				break;
			
		}
	}
	
	public String getStudyType() {
		return this.studyType;
	}
	
	
	
	private void setIdNumber() {
		this.idLastDiigts = Integer.parseInt(facultyNumber.substring(7,10));
	}
	public int getIdNumber() {
		return this.idLastDiigts;
	}

	@Override
	public String toString() {
		return  this.facultyNumber+" "+this.idLastDiigts+" "+this.specialty+" "+this.studyType+" "+this.yearOfRegistration;
	}

}
