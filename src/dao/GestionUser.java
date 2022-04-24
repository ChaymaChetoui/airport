package dao;

import java.util.List;

import entities.User;

public interface GestionUser {
	public void ajouterUser(User e);
	public User rechercherParId(int id);
	public List<User> listeUsers();
	public User rechercherParEmail(String email);
}
