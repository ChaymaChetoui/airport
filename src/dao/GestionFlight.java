package dao;

import java.util.List;

import entities.Flight;

public interface GestionFlight {

	public void ajouterFlight(Flight flight);
	public List<Flight> listeFlights() ;
	public Flight rechercherParFlightNumber(int number);
}
