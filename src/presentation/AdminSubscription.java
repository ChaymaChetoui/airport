package presentation;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.AdminJDBC;
import dao.GestionAdmin;
import entities.Admin;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPasswordField;

public class AdminSubscription extends JFrame {

	private JPanel contentPane;
	private JTextField setemail;
	private JTextField setrole;
	private JTextField setname;
	private JTextField setlname;
	private JPasswordField passwordField;
	TableModeleAdmin tm=new TableModeleAdmin();
	JTable tableau=new JTable(tm);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSubscription frame = new AdminSubscription();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminSubscription() {
		setUndecorated(true);
		setTitle("Admin Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titre = new JLabel("Admin Subscription");
		titre.setFont(new Font("Segoe UI Symbol", Font.ITALIC, 26));
		titre.setForeground(new Color(255, 255, 255));
		titre.setBounds(259, 2, 240, 36);
		contentPane.add(titre);
		
		JLabel email = new JLabel("Email :");
		email.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		email.setForeground(new Color(255, 255, 255));
		email.setBounds(238, 66, 67, 14);
		contentPane.add(email);
		
		setemail = new JTextField();
		setemail.setBounds(341, 65, 186, 20);
		contentPane.add(setemail);
		setemail.setColumns(10);
		
		JLabel password = new JLabel("Password :");
		password.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		password.setForeground(Color.WHITE);
		password.setBounds(238, 108, 93, 14);
		contentPane.add(password);
		
		JLabel role = new JLabel("Role :");
		role.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		role.setForeground(Color.WHITE);
		role.setBounds(244, 158, 67, 14);
		contentPane.add(role);
		
		setrole = new JTextField();
		setrole.setColumns(10);
		setrole.setBounds(341, 157, 186, 20);
		contentPane.add(setrole);
		
		JLabel fname = new JLabel("First Name :");
		fname.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		fname.setForeground(Color.WHITE);
		fname.setBounds(244, 205, 86, 14);
		contentPane.add(fname);
		
		setname = new JTextField();
		setname.setColumns(10);
		setname.setBounds(341, 204, 186, 20);
		contentPane.add(setname);
		
		JLabel lname = new JLabel("Last Name :");
		lname.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 13));
		lname.setForeground(Color.WHITE);
		lname.setBounds(244, 252, 86, 14);
		contentPane.add(lname);
		
		setlname = new JTextField();
		setlname.setColumns(10);
		setlname.setBounds(341, 251, 186, 20);
		contentPane.add(setlname);
		
		JButton btnSubscribe = new JButton("Subscribe");
		btnSubscribe.setForeground(new Color(0, 128, 128));
		btnSubscribe.setBounds(325, 325, 101, 36);
		contentPane.add(btnSubscribe);
		
		JLabel X = new JLabel("X");
		btnSubscribe.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				System.out.println("subscribe");
				GestionAdmin gAdmin =new AdminJDBC();
			    gAdmin.ajouterAdmin(new Admin(setemail.getText(), passwordField.getText(),
			    		"admin", setname.getText(),setlname.getText()));
			    
			    tm.charger(gAdmin.listeAdmin());
			}
			@Override
			public void mouseEntered(MouseEvent e) {
		
			}
			@Override
			public void mouseExited(MouseEvent e) {
		
			}
		});
	
		X.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?","confirmation" , JOptionPane.YES_NO_OPTION)==0) {
					AdminSubscription.this.dispose();
			}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
		X.setForeground(Color.BLUE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
		X.setForeground(Color.WHITE);
			}
		});
		X.setForeground(new Color(255, 255, 255));
		X.setHorizontalAlignment(SwingConstants.CENTER);
		X.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		X.setBounds(567, 0, 33, 48);
		contentPane.add(X);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 164, 411);
		contentPane.add(scrollPane);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(341, 106, 187, 23);
		contentPane.add(passwordField);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 410, 600, 290);
		contentPane.add(panel);
		
		  //En-têtes pour JTable 
        String[] columns = new String[] {
            "Id", "FirstName", "LastName", "Adresse"
        };
         
        //données pour JTable dans un tableau 2D
        Object[][] data = new Object[][] {
            
        };
 
        //crée un JTable avec des données
       
    
        JScrollPane scroll = new JScrollPane(tableau);
        tableau.setFillsViewportHeight(true);
 
        JLabel labelHead = new JLabel("Admin Table");
       
        labelHead.setHorizontalAlignment(SwingConstants.CENTER);
        labelHead.setFont(new Font("Arial", Font.BOLD, 17));
        labelHead.setForeground(new Color(0, 139, 139));
        panel.add(labelHead,BorderLayout.PAGE_START);
        
        GestionAdmin gestionA=new AdminJDBC();
        
        tm.charger(gestionA.listeAdmin());
        //JTable table = new JTable(gestionA.listeAdmin(), columns);
        //ajouter la table au frame
        panel.add(scroll,BorderLayout.CENTER);
        
 	 
			  
		   
       

        panel.setVisible(true);
    }
		}	
