package dao;

import java.util.List;

import entities.Airport;

public interface GestionAirport {
	public void ajouterAirport(Airport airport);
	public Airport rechercherParAirportCode(int code);
	public List<Airport> listeAirports();
}
