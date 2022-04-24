package dao;

import entities.Airport;
import entities.Flight;
import entities.Passenger;
import entities.User;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import entities.Admin;

public class Test {
	public static void main(String[]args) {
//		 GestionAirport gestion = new AirportJDBC();
//	      gestion.ajouterAirport(new Airport( "carthage", "tunis"));
//	      gestion.ajouterAirport(new Airport( "habib bourguiba", "monastir"));
//	      
//	      GestionUser user1= new UserJDBC ();
//	      user1.ajouterUser(new User("chaymachetoui2821@gmail.com","123","admin","chayma","chetoui"));
//	      GestionPassenger gPass=new PassengerJDBC();
//	      gPass.ajouterPassenger(new Passenger("N1245", "féminin", "Tunisienne", "nn@gmail.com","123","passenger","nn","chetoui"));
//	      
//	      
	      //GestionAdmin gAdmin=new AdminJDBC();
//	      
		GestionFlight gFlight=new FlightJDBC();
		 GestionAirport gestion = new AirportJDBC();
		Airport a1= gestion.rechercherParAirportCode(1);
		Airport a2= gestion.rechercherParAirportCode(2);
		if(a1!=null)
		System.out.println(a1.getAirportName());
		else
			System.out.println("n'existe pas");
//		

		List<Airport> liste = gestion.listeAirports();
		//for (Airport airport : liste) {
			//System.out.println(airport.getAirportCode());}
		
		//gFlight.ajouterFlight(new Flight(new Time(12), new Time(12), 500, 700, a2, a1));
		//Flight f1=gFlight.rechercherParFlightNumber(4);
		//Flight f2=gFlight.rechercherParFlightNumber(3);
		
		GestionAdmin gAdmin =new AdminJDBC();
	      //gAdmin.ajouterAdmin(new Admin("fares@gmail.com", "123", "admin", "Fares","Fares"));
	      //gAdmin.ajouterAdmin(new Admin("chayma@gmail.com", "123", "admin", "Chayma","Chetoui"));

		List<Admin> listeA= gAdmin.listeAdmin();
		for (Admin admin : listeA) {
			System.out.println(admin.getId());
			
		}
		
		GestionPassenger gPass=new PassengerJDBC();
	      //gPass.ajouterPassenger(new Passenger("N1245", "féminin", "Tunisienne", "nn@gmail.com","123","passenger","nn","chetoui"));	      
	}

}
