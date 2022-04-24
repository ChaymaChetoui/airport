package presentation;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import dao.AdminJDBC;
import dao.AirportJDBC;
import dao.GestionAdmin;
import dao.GestionAirport;
import entities.Admin;
import entities.Airport;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class AirportSubscription extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AirportSubscription frame = new AirportSubscription();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void fillComboBox() {
		
	}

	/**
	 * Create the frame.
	 */
	public AirportSubscription() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new LineBorder(new Color(0, 128, 128), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("A\u00E9roport");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 33));
		lblNewLabel.setBounds(284, 10, 182, 49);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 150, 400);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("A\u00E9roport Name : ");
		lblNewLabel_1.setForeground(new Color(245, 245, 220));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(186, 108, 135, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Country :");
		lblNewLabel_1_1.setForeground(new Color(245, 245, 220));
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(186, 218, 135, 26);
		contentPane.add(lblNewLabel_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(186, 156, 355, 38);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 0, 335, 38);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox(new String[] {"Tunisia"," Frensh","Italie","Turkish"});
		comboBox.setBounds(186, 263, 360, 38);
		contentPane.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(47, 79, 79));
		panel_2.setForeground(new Color(0, 128, 128));
		panel_2.setBounds(326, 332, 120, 38);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Add");
		lblNewLabel_2.setFont(new Font("Serif", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 5, 100, 23);
		panel_2.add(lblNewLabel_2);
		
		
		
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				System.out.println("subscribe");
				GestionAirport gAirport =new AirportJDBC();
			    gAirport.ajouterAirport(new Airport(textField.getText(), comboBox.getSelectedItem().toString()	));
			
			}
			@Override
			public void mouseEntered(MouseEvent e) {
		
			}
			@Override
			public void mouseExited(MouseEvent e) {
		
			}
		});
		JLabel X = new JLabel("X");
		X.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?","confirmation" , JOptionPane.YES_NO_OPTION)==0) {
					AirportSubscription.this.dispose();
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
		X.setHorizontalAlignment(SwingConstants.CENTER);
		X.setForeground(Color.WHITE);
		X.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		X.setBounds(567, 0, 33, 48);
		contentPane.add(X);
	}
}
