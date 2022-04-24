package presentation;


	import javax.swing.*;

import dao.AdminJDBC;
import dao.GestionAdmin;
import dao.GestionPassenger;
import dao.PassengerJDBC;

import java.awt.*;
	public class PassengerVue {
		 public static void main(String[] args) {
			 TableModelePassenger tm=new TableModelePassenger();
				JTable tableau=new JTable(tm);

		        //crée un frame
		        final JFrame frame = new JFrame("Tableau Passanger");
		 
		        //En-têtes pour JTable 
		        String[] columns = new String[] {
		            "Id", "FirstName", "LastName", "Adresse","Nationality","Passeport Number","gender"
		        };
		         
		        //données pour JTable dans un tableau 2D
		        Object[][] data = new Object[][] {
		            
		        };
		 
		        //crée un JTable avec des données
		        JTable table = new JTable(data, columns);
		    
		        JScrollPane scroll = new JScrollPane(table);
		        table.setFillsViewportHeight(true);
		 
		        JLabel labelHead = new JLabel("Passenger Table");
		       
		        labelHead.setHorizontalAlignment(SwingConstants.CENTER);
		        labelHead.setFont(new Font("Arial", Font.BOLD, 17));
		        labelHead.setForeground(new Color(0, 139, 139));
		        frame.getContentPane().add(labelHead,BorderLayout.PAGE_START);
		        //ajouter la table au frame
		        frame.getContentPane().add(scroll,BorderLayout.CENTER);

		        GestionPassenger gestionP=new PassengerJDBC();
		        
		        tm.charger(gestionP.listePassenger());
		 
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setSize(500, 200);
		        frame.setVisible(true);
		    }
	}

