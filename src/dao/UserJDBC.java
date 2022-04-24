package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Airport;
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
	@Override
	public User rechercherParId(int id) {
		User user = null;
		try {
			PreparedStatement ps = connection.prepareStatement("select * from user where id = ?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				user =new User();
				user.setId(rs.getInt(1));
				user.setEmail(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setFirstName(rs.getString(4));
				user.setLastName(rs.getString(5));
				user.setRole(rs.getString(6));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	@Override
	public User rechercherParEmail(String email) {
		User user = null;
		try {
			PreparedStatement ps = connection.prepareStatement("select * from user where email = ?");
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				user =new User();
				user.setId(rs.getInt(1));
				user.setEmail(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setFirstName(rs.getString(4));
				user.setLastName(rs.getString(5));
				user.setRole(rs.getString(6));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> listeUsers() {

		List<User> liste = new ArrayList<User>();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from user");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				liste.add(
						new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));

			}

		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}

}

