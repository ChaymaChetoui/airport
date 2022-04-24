package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entities.Passenger;
import entities.User;

public class PassengerJDBC implements GestionPassenger {
private Connection connection=SingletonConnection.getConnection();
	
	@Override
	public void ajouterPassenger(Passenger e) {
		try {
			
			PreparedStatement ps=connection.prepareStatement("insert into user (id,email,password,role,firstName,lastName) values(?,?,?,?,?,?)");
		    ps.setInt(1, e.getId());
		    ps.setString(2, e.getEmail());
		    ps.setString(3, e.getPassword());
		    ps.setString(4, e.getRole());
		    ps.setString(5, e.getFirstName());
		    ps.setString(6, e.getLastName());

		    ps.executeUpdate();
		    
			PreparedStatement ps1=connection.prepareStatement("insert into passenger (id,passeportNumber,nationality,gender) values(LAST_INSERT_ID(),?,?,?)");
			//ps1.setInt(1, e.getId());
		    ps1.setString(1, e.getPasseportNumber());
		    ps1.setString(2, e.getNationality());
		    ps1.setString(3, e.getGender());
		    
		    ps1.executeUpdate();
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
	}

}

