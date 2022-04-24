package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Admin;
import entities.User;

public class AdminJDBC implements GestionAdmin{
private Connection connection=SingletonConnection.getConnection();
	
	@Override
	public void ajouterAdmin(Admin e) {
		try {
			
			PreparedStatement ps=connection.prepareStatement("insert into user (id,email,password,role,firstName,lastName) values(?,?,?,?,?,?)");
		    ps.setInt(1, e.getId());
		    ps.setString(2, e.getEmail());
		    ps.setString(3, e.getPassword());
		    ps.setString(4, "admin");
		    ps.setString(5, e.getFirstName());
		    ps.setString(6, e.getLastName());

		    ps.executeUpdate();
		    
			PreparedStatement ps1=connection.prepareStatement("insert into admin (id) values(LAST_INSERT_ID())");
			//ps1.setInt(1, e.getId());
		 
		    
		    ps1.executeUpdate();
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
}
	@Override
	public User rechercherParId(int id) {
		User user = null;
		try {
			PreparedStatement ps = connection.prepareStatement("select * from user  u join admin a on a.id=u.id where u.id = ?");
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
	public List<Admin> listeAdmin() {

		List<Admin> liste = new ArrayList<Admin>();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from user u join admin a on a.id=u.id");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				liste.add(
						new Admin(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));

			}

		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}
}
