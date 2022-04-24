package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		@Override
		public Passenger rechercherParId(int id) {
			Passenger passenger = null;
			try {
				PreparedStatement ps = connection.prepareStatement("select * from user where id = ?");
				ps.setInt(1, id);
				
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					
					passenger =new Passenger();
					passenger.setId(rs.getInt(1));
					passenger.setEmail(rs.getString(2));
					passenger.setPassword(rs.getString(3));
					passenger.setFirstName(rs.getString(4));
					passenger.setLastName(rs.getString(5));
					passenger.setRole(rs.getString(6));

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return passenger;
		}

		@Override
		public List<Passenger> listePassenger() {

			List<Passenger> liste = new ArrayList<Passenger>();
			try {
				PreparedStatement ps = connection.prepareStatement("select * from user");
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					liste.add(
							new Passenger(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));

				}

			} catch (SQLException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}
			return liste;
		}
		
		
		
	}



