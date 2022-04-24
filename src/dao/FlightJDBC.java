package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import entities.Airport;
import entities.Flight;

public class FlightJDBC implements GestionFlight {

	private Connection connection = SingletonConnection.getConnection();

	@Override
	public void ajouterFlight(Flight flight) {
		try {

			PreparedStatement ps = connection.prepareStatement(
					"insert into flight (flightNumber,departureTime,arrivalTime,economyPrice,businessPrice,departure_airport_id,arrival_airport_id) values(?,?,?,?,?,?,?)");
			ps.setInt(1, flight.getFlightNumber());
			ps.setTime(2, flight.getDepartureTime());
			ps.setTime(3, flight.getArrivalTime());
			ps.setDouble(4, flight.getEconomyPrice());
			ps.setDouble(5, flight.getBusinessPrice());
			ps.setInt(6, flight.getDepartureAirport().getAirportCode());
			ps.setInt(7, flight.getArrivalAirport().getAirportCode());

			ps.executeUpdate();


		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	@Override
	public Flight rechercherParFlightNumber(int number) {
		Flight flight = null;
		try {
			PreparedStatement ps = connection.prepareStatement("select * from flight where flightNumber = ?");
			ps.setInt(1, number);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				flight=new Flight();
				GestionAirport gestion = new AirportJDBC();
				flight.setFlightNumber(rs.getInt(1));
				flight.setDepartureTime(rs.getTime(2));
				flight.setArrivalTime(rs.getTime(3));
				flight.setEconomyPrice(rs.getDouble(4));
				flight.setBusinessPrice(rs.getDouble(5));
				int idDeparture=rs.getInt(6);
				int idArrival=rs.getInt(7);
				Airport a1= gestion.rechercherParAirportCode(idDeparture);
				Airport a2= gestion.rechercherParAirportCode(idArrival);
				flight.setDepartureAirport(a1);
				flight.setArrivalAirport(a2);
				
				

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flight;
	}

	@Override
	public List<Flight> listeFlights() {

		List<Flight> liste = new ArrayList<Flight>();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from flight");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				GestionAirport gestion = new AirportJDBC();
				liste.add(new Flight(rs.getInt(1),rs.getTime(2) , rs.getTime(3), 
						rs.getDouble(4),rs.getDouble(5), 
						gestion.rechercherParAirportCode(rs.getInt(6)), gestion.rechercherParAirportCode(rs.getInt(7))));

			}

		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}

}

