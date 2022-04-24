package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entities.User;

public class UserJDBC implements GestionUser {
private Connection connection=SingletonConnection.getConnection();
	
	@Override
	public void ajouterUser(User e) {
		try {
			PreparedStatement ps=connection.prepareStatement("insert into user (id,email,password,role,firstName,lastName) values(?,?,?,?,?,?)");
		    ps.setInt(1, e.getId());
		    ps.setString(2, e.getEmail());
		    ps.setString(3, e.getPassword());
		    ps.setString(4, e.getRole());
		    ps.setString(5, e.getFirstName());
		    ps.setString(6, e.getLastName());
		   
		    ps.executeUpdate();
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
	}

}

