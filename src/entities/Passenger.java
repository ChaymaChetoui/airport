package entities;

public class Passenger extends User {
	private String passeportNumber;
	private String gender;
	private String nationality;

	public Passenger(String passeportNumber,String gender,String nationality,String email, String password, String role, String firstName, String lastName) {
		super(email, password, role, firstName, lastName);
		this.passeportNumber=passeportNumber;
		this.gender=gender;
		this.nationality=nationality;
		
	}

	public String getPasseportNumber() {
		return passeportNumber;
	}

	public void setPasseportNumber(String passeportNumber) {
		this.passeportNumber = passeportNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	
}
