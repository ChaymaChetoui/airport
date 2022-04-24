package presentation;


	

	import java.awt.BorderLayout;
	import java.awt.EventQueue;

	import javax.swing.ImageIcon;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import javax.swing.border.LineBorder;
	import javax.swing.text.JTextComponent;

import dao.GestionPassenger;
import dao.GestionUser;
import dao.UserJDBC;
import entities.User;

import java.awt.Color;
	import javax.swing.JTextField;
	import javax.swing.JPasswordField;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;

	import java.awt.Font;
	import java.awt.Rectangle;
	import javax.swing.SwingConstants;
	import java.awt.Image;
	import javax.swing.JCheckBox;
	import javax.swing.JButton;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;
	import java.awt.event.FocusAdapter;
	import java.awt.event.FocusEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent; 

	public class Login extends JFrame {

	protected static final JTextComponent Msg = null;
	private JPanel contentPane;
		private JTextField userTextField;
		private JPasswordField passwordField;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Login frame = new Login();
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
		public Login() {
			getContentPane().setBackground(new Color(0, 128, 128));
			setUndecorated(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 600, 400);
			contentPane = new JPanel();
			contentPane.setBounds(new Rectangle(0, 0, 20, 20));
			contentPane.setBackground(new Color(0,139,139));
			
			contentPane.setBorder(new LineBorder(new Color(0,0,128),2));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			panel.setBounds(334, 130, 209, 40);
			contentPane.add(panel);
			panel.setLayout(null);
			
			userTextField = new JTextField();
			userTextField.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if(userTextField.getText().equals("Username")) {
						userTextField.setText(""); 
					}else {
						userTextField.selectAll(); 
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(userTextField.getText().equals(""))
						userTextField.setText("username");
				}
			});
			userTextField.setFont(new Font("Arial", Font.BOLD, 13));
			userTextField.setText("Username");
			userTextField.setBounds(10, 10, 187, 19);
			panel.add(userTextField);
			userTextField.setColumns(10);
			
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.WHITE);
			panel_1.setBounds(334, 192, 209, 40);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			
			passwordField = new JPasswordField();
			passwordField.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if(passwordField.getText().equals("password")) {
					passwordField.setEchoChar('*');
					passwordField.setText("");}
					else {
						passwordField.selectAll(); 
					}
					
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(passwordField.getText().equals("")) {
						passwordField.setText("Password"); 
						passwordField.setEchoChar((char)0);
					}
				}
			});
			passwordField.setFont(new Font("Arial", Font.BOLD, 13));
			passwordField.setText("Password");
			passwordField.setEchoChar('*');
			passwordField.setBounds(10, 10, 188, 19);
			panel_1.add(passwordField);
			
			JLabel lblx = new JLabel(" X");
			lblx.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?","confirmation" , JOptionPane.YES_NO_OPTION)==0) {
						Login.this.dispose(); 
						
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
			lblx.setForeground(new Color(255, 255, 255));
			lblx.setHorizontalAlignment(SwingConstants.CENTER);
			lblx.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblx.setBounds(567, 0, 33, 48);
			contentPane.add(lblx);
			
			JLabel logo = new JLabel("Plane Station ");
			logo.setHorizontalAlignment(SwingConstants.CENTER);
			logo.setForeground(new Color(255, 255, 255));
			logo.setFont(new Font("Segoe UI Symbol", Font.ITALIC, 32));
			logo.setBounds(280, 30, 250, 90);
			contentPane.add(logo);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBounds(0, 0, 194, 400);
			contentPane.add(panel_3);
			
			JCheckBox showPassword = new JCheckBox("see password");
			showPassword.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getSource() == showPassword) {
			            if (showPassword.isSelected()) {
			                passwordField.setEchoChar((char) 0);
			            } else {
			                passwordField.setEchoChar('*');
			            }


			        }
				}
			});
			showPassword.setForeground(new Color(255, 255, 255));
			showPassword.setBackground(new Color(0, 139, 139));
			showPassword.setBounds(436, 253, 107, 21);
			contentPane.add(showPassword);
			
			JLabel userLabel = new JLabel("UserName :");
			userLabel.setForeground(new Color(224, 255, 255));
			userLabel.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
			userLabel.setBounds(221, 130, 107, 40);
			contentPane.add(userLabel);
			
			JLabel passwordLabel = new JLabel("Password :");
			passwordLabel.setForeground(new Color(224, 255, 255));
			passwordLabel.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 15));
			passwordLabel.setBounds(221, 192, 107, 40);
			contentPane.add(passwordLabel);
			
			JPanel panel_2 = new JPanel();
			panel_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try { GestionUser gestion = new UserJDBC();
						User user = gestion.rechercherParEmail(userTextField.getText());
					
				    	if(user!=null && user.getPassword().equals(passwordField.getText())) {
				    		
				    		 JOptionPane.showMessageDialog(null, "Login Successful");}
				    	else {
				    		JOptionPane.showMessageDialog(null, "Invalid Username or Password");}
				    	 
				    }catch(Exception e1) {
				    	System.out.println(e1);
				    }
				}
			});
			panel_2.setBackground(new Color(220, 220, 220));
			panel_2.setBounds(250, 305, 91, 40);
			contentPane.add(panel_2);
			
			JLabel lblNewLabel = new JLabel("Login");
			lblNewLabel.setForeground(new Color(0, 139, 139));
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
			panel_2.add(lblNewLabel);
			
			JPanel panel_2_1 = new JPanel();
			panel_2_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					 if (e.getSource() == panel_2_1) {
				            userTextField.setText("");
				            passwordField.setText("");
				        }
				}
			});
			panel_2_1.setBackground(new Color(220, 220, 220));
			panel_2_1.setBounds(386, 305, 91, 40);
			contentPane.add(panel_2_1);
			
			JLabel lblReset = new JLabel("Reset");
			lblReset.setForeground(new Color(0, 139, 139));
			lblReset.setFont(new Font("Arial", Font.BOLD, 18));
			panel_2_1.add(lblReset);
			
			JLabel lblLoginMessage = new JLabel("");
			lblLoginMessage.setForeground(new Color(255, 235, 205));
			lblLoginMessage.setFont(new Font("Arial", Font.PLAIN, 12));
			lblLoginMessage.setBounds(436, 369, 154, 21);
			contentPane.add(lblLoginMessage);
			
			setUndecorated(true); 
			logo.setVisible(true);
			setLocationRelativeTo(null); 


			
		}
	}


