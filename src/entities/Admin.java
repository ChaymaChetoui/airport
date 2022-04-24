package entities;

public class Admin extends User{

	public Admin(String email, String password, String role, String firstName, String lastName) {
		super(email, password, role, firstName, lastName);
		// TODO Auto-generated constructor stub
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int id, String email, String password, String role, String firstName, String lastName) {
		super(id, email, password, role, firstName, lastName);
		// TODO Auto-generated constructor stub
	}
	

}
