package presentation;

	

	import java.awt.BorderLayout;
	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;

import dao.AdminJDBC;
import dao.GestionAdmin;
import dao.GestionPassenger;
import dao.PassengerJDBC;
import entities.Admin;
import entities.Passenger;

import java.awt.GridLayout;

	import javax.swing.BorderFactory;
	import javax.swing.JButton;
	import javax.swing.JLabel;
	import java.awt.Label;
	import java.awt.TextField;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
	import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
	import javax.swing.JComboBox;
	import javax.swing.JPasswordField;

	public class Reservation extends JFrame implements ActionListener{
		JPanel p1 = new JPanel();

		private JPanel contentPane;
		private JPasswordField passwordField;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Reservation frame = new Reservation();
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
		public Reservation() {
			setTitle("Reservation");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(200, 200, 1000, 351);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(0, 128, 128));
			contentPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,1),"Passanger's information"));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			Label label = new Label("First Name :");
			label.setForeground(new Color(255, 255, 255));
			label.setBounds(10, 26, 62, 22);
			contentPane.add(label);
			
			JTextField fName = new JTextField();
			System.out.println(fName.getText());
			fName.setBounds(175, 26, 261, 22);
			contentPane.add(fName);
			
			Label label_1 = new Label("Last Name :");
			label_1.setForeground(new Color(255, 255, 255));
			label_1.setBounds(614, 26, 62, 22);
			contentPane.add(label_1);
			
			JTextField lName = new JTextField();
			System.out.println(lName.getText());

			lName.setBounds(741, 26, 237, 22);
			contentPane.add(lName);
			
			JTextField passNum = new JTextField();
			passNum.setBounds(175, 72, 261, 22);
			contentPane.add(passNum);
			System.out.println(passNum.getText());

			Label label_2 = new Label("Passport Number :");
			label_2.setForeground(Color.WHITE);
			label_2.setBounds(10, 72, 103, 22);
			contentPane.add(label_2);
			
			JRadioButton genderWoman = new JRadioButton("woman");
			genderWoman.setBackground(new Color(0, 128, 128));
			genderWoman.setBounds(867, 71, 111, 23);
			contentPane.add(genderWoman);
			
			JRadioButton genderMan = new JRadioButton("Man");
			genderMan.setBackground(new Color(0, 128, 128));
			genderMan.setBounds(741, 72, 116, 23);
			contentPane.add(genderMan);
			
			Label label_1_1 = new Label("Gender :");
			label_1_1.setForeground(Color.WHITE);
			label_1_1.setBounds(612, 72, 62, 22);
			contentPane.add(label_1_1);
			
			Label label_2_1 = new Label("Nationalty :");
			label_2_1.setForeground(Color.WHITE);
			label_2_1.setBounds(10, 120, 96, 22);
			contentPane.add(label_2_1);
			
			Label label_2_2 = new Label("Role :");
			label_2_2.setForeground(Color.WHITE);
			label_2_2.setBounds(614, 120, 96, 22);
			contentPane.add(label_2_2);
			
			JComboBox nationality = new JComboBox(new String[] {"Tunisian"," Frensh"});
			nationality.setBounds(175, 120, 261, 22);
			contentPane.add(nationality);
			
			JTextField role = new JTextField();
			role.setBounds(741, 120, 237, 22);
			contentPane.add(role);
			System.out.println(role.getText());

			JButton b1 = new JButton("Reserver");
			b1.setBounds(290, 220, 172, 39);
			contentPane.add(b1);
			
			JButton btnAnnuler = new JButton("Annuler");
			btnAnnuler.setBounds(521, 220, 172, 39);
			contentPane.add(btnAnnuler);
			
			Label label_2_1_1 = new Label("Email :");
			label_2_1_1.setForeground(Color.WHITE);
			label_2_1_1.setBounds(10, 175, 96, 22);
			contentPane.add(label_2_1_1);
			
			JTextField email = new JTextField();
			email.setBounds(175, 175, 261, 22);
			contentPane.add(email);
			System.out.println(email.getText());

			Label label_2_1_1_1 = new Label("PassWord :");
			label_2_1_1_1.setForeground(Color.WHITE);
			label_2_1_1_1.setBounds(614, 175, 96, 22);
			contentPane.add(label_2_1_1_1);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(741, 175, 233, 20);
			contentPane.add(passwordField);
			btnAnnuler.addActionListener(this);
			b1.addMouseListener(new MouseAdapter() {
				@Override
				
				public void mouseClicked(MouseEvent e) {
					System.out.println("subscribe");
					GestionPassenger gPassenger =new PassengerJDBC();
					System.out.println("passss");
					System.out.println(passwordField.getSelectedText());
					System.out.println(passwordField.getText());
					if(genderMan.isSelected()) {
				    gPassenger.ajouterPassenger(new Passenger(passNum.getText(), genderMan.getText(), nationality.getSelectedItem().toString(), email.getText(), passwordField.getText()
				    		, "passenger", fName.getText(), lName.getText()) );}
					else if(genderWoman.isSelected()){
						gPassenger.ajouterPassenger(new Passenger(passNum.getText(), genderWoman.getText(), nationality.getSelectedItem().toString(), email.getText(), passwordField.getText()
					    		, "passenger", fName.getText(), lName.getText()) );
						
					}
				}
				@Override
				public void mouseEntered(MouseEvent e) {
			
				}
				@Override
				public void mouseExited(MouseEvent e) {
			
				}
			});
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton act = (JButton) e.getSource();
		

			
		}
	}



