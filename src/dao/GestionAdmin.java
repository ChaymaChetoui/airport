package dao;

import java.util.List;

import entities.Admin;
import entities.User;

public interface GestionAdmin {
	public void ajouterAdmin(Admin e) ;
	public List<Admin> listeAdmin() ;
	public User rechercherParId(int id);
}
