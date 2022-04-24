package dao;

import java.util.List;

import entities.Admin;
import entities.Passenger;
import entities.User;

public interface GestionPassenger {
	public void ajouterPassenger(Passenger e);
	public Passenger rechercherParId(int id);
	public List<Passenger> listePassenger();
	
}
