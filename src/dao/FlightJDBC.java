package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
