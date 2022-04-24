package presentation;

	import java.awt.BorderLayout;
	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import javax.swing.border.LineBorder;

import dao.FlightJDBC;

import java.awt.Color;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;

	import java.awt.Font;
	import javax.swing.SwingConstants;
	import javax.swing.JTextField;
	import javax.swing.JComboBox;
	import javax.swing.JButton;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;

	public class FlightPage extends JFrame {

		private JPanel contentPane;
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;
		private JTextField textField_3;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						FlightPage frame = new FlightPage();
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
		public FlightPage() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 600, 400);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(0, 139, 139));
			setUndecorated(true); 
			contentPane.setBorder(new LineBorder(new Color(0, 128, 128), 2));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 117, 400);
			contentPane.add(panel);
			
			JLabel lblNewLabel = new JLabel("Flights ");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Bodoni MT", Font.BOLD, 35));
			lblNewLabel.setBounds(235, 28, 263, 46);
			contentPane.add(lblNewLabel);
			
			JLabel departureTime = new JLabel("departure Time: ");
			departureTime.setFont(new Font("Arial", Font.PLAIN, 12));
			departureTime.setForeground(new Color(248, 248, 255));
			departureTime.setBounds(127, 93, 95, 28);
			contentPane.add(departureTime);
			
			JLabel ArrivalTime = new JLabel("Arrival Time: ");
			ArrivalTime.setBackground(new Color(240, 240, 240));
			ArrivalTime.setForeground(new Color(248, 248, 255));
			ArrivalTime.setFont(new Font("Arial", Font.PLAIN, 12));
			ArrivalTime.setBounds(127, 137, 95, 28);
			contentPane.add(ArrivalTime);
			
			JLabel economy_price = new JLabel("Economy Price");
			economy_price.setForeground(new Color(248, 248, 255));
			economy_price.setFont(new Font("Arial", Font.PLAIN, 12));
			economy_price.setBounds(127, 175, 95, 28);
			contentPane.add(economy_price);
			
			JLabel BusinessPrice = new JLabel("business price");
			BusinessPrice.setForeground(new Color(248, 248, 255));
			BusinessPrice.setFont(new Font("Arial", Font.PLAIN, 12));
			BusinessPrice.setBounds(127, 213, 95, 28);
			contentPane.add(BusinessPrice);
			
			JLabel DepartureAirportId = new JLabel("departure airport id");
			DepartureAirportId.setForeground(new Color(248, 248, 255));
			DepartureAirportId.setFont(new Font("Arial", Font.PLAIN, 12));
			DepartureAirportId.setBounds(127, 251, 117, 28);
			contentPane.add(DepartureAirportId);
			
			JLabel ArrivalAirportId = new JLabel("arrival airport id");
			ArrivalAirportId.setForeground(new Color(248, 248, 255));
			ArrivalAirportId.setFont(new Font("Arial", Font.PLAIN, 12));
			ArrivalAirportId.setBounds(127, 300, 95, 28);
			contentPane.add(ArrivalAirportId);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(245, 93, 296, 28);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			
			textField = new JTextField();
			textField.setBounds(10, 0, 276, 28);
			panel_1.add(textField);
			textField.setColumns(10);
			
			JPanel panel2 = new JPanel();
			panel2.setBounds(245, 137, 296, 28);
			contentPane.add(panel2);
			panel2.setLayout(null);
			
			textField_1 = new JTextField();
			textField_1.setBounds(10, 0, 276, 28);
			textField_1.setColumns(10);
			panel2.add(textField_1);
			
			JPanel panel3 = new JPanel();
			panel3.setBounds(245, 175, 296, 28);
			contentPane.add(panel3);
			panel3.setLayout(null);
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(10, 0, 276, 28);
			panel3.add(textField_2);
			
			JPanel panel4 = new JPanel();
			panel4.setBounds(245, 213, 296, 28);
			contentPane.add(panel4);
			panel4.setLayout(null);
			
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(10, 0, 276, 28);
			panel4.add(textField_3);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(244, 255, 297, 28);
			contentPane.add(comboBox);
			
			JComboBox comboBox_1 = new JComboBox();
			comboBox_1.setBounds(244, 300, 297, 28);
			contentPane.add(comboBox_1);
			
			JButton btnNewButton = new JButton("Add");
			btnNewButton.setForeground(new Color(0, 139, 139));
			btnNewButton.setFont(new Font("Segoe UI Symbol", Font.BOLD, 24));
			btnNewButton.setBounds(446, 349, 95, 41);
			contentPane.add(btnNewButton);
			
			JLabel lblx = new JLabel(" X");
			lblx.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?","confirmation" , JOptionPane.YES_NO_OPTION)==0) {
						FlightPage.this.dispose(); 
						
					}
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					lblx.setForeground(Color.BLUE);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					lblx.setForeground(Color.WHITE);
				}
			});
			lblx.setHorizontalAlignment(SwingConstants.CENTER);
			lblx.setForeground(Color.WHITE);
			lblx.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblx.setBounds(567, 0, 33, 48);
			contentPane.add(lblx);
		}
	}

	


