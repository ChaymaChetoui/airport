package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Airport;

public class AirportJDBC implements GestionAirport {
	private Connection connection = SingletonConnection.getConnection();

	@Override
	public void ajouterAirport(Airport e) {
		try {
			PreparedStatement ps = connection
					.prepareStatement("insert into airport (airportCode,airportName,country) values(?,?,?)");
			ps.setInt(1, e.getAirportCode());
			ps.setString(2, e.getAirportName());
			ps.setString(3, e.getCountry());
			System.out.println("ps ps" + e.getAirportCode());
			ps.executeUpdate();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public Airport rechercherParAirportCode(int code) {
		Airport airport = null;
		try {
			PreparedStatement ps = connection.prepareStatement("select * from airport where airportCode = ?");
			ps.setInt(1, code);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				airport =new Airport();
				airport.setAirportCode(rs.getInt(1));
				airport.setAirportName(rs.getString(2));
				airport.setCountry(rs.getString(3));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return airport;
	}

	@Override
	public List<Airport> listeAirports() {

		List<Airport> liste = new ArrayList<Airport>();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from airport");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				liste.add(
						new Airport(rs.getInt(1), rs.getString(2), rs.getString(3)));

			}

		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}

}

/*
 * @Override /*public List<Airport> rechercherParMC(String mc) {
 * List<Etudiant>liste=new ArrayList<Etudiant>(); try { PreparedStatement
 * ps=connection.prepareStatement("select * from etudiant where nom like ?");
 * ps.setString(1, "%"+mc+"%"); ResultSet rs=ps.executeQuery(); while(rs.next())
 * { liste.add(new Etudiant(rs.getInt(1), rs.getString(2), rs.getString(3),
 * rs.getString(4),rs.getString(5)));
 * 
 * }
 * 
 * } catch (SQLException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } return liste; }
 * 
 * @Override public List<Etudiant> listeDesEtudiants() { List<Etudiant>liste=new
 * ArrayList<Etudiant>(); try { PreparedStatement
 * ps=connection.prepareStatement("select * from etudiant"); ResultSet
 * rs=ps.executeQuery(); while(rs.next()) { liste.add(new Etudiant(rs.getInt(1),
 * rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5)));
 * 
 * }
 * 
 * } catch (SQLException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } return liste;
 * 
 * }
 * 
 * @Override public void supprimerEtudiant(int id) { try { PreparedStatement
 * ps=connection.prepareStatement("delete from etudiant where id=?");
 * ps.setInt(1, id);
 * 
 * ps.executeUpdate();
 * 
 * } catch (SQLException e1) { // TODO Auto-generated catch block
 * e1.printStackTrace(); }
 * 
 * } }
 */
