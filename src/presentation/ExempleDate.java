package presentation;


	import java.awt.FlowLayout;
	import java.text.DateFormat;
	import java.text.Format;
	import java.util.Date;

	import javax.swing.BoxLayout;
	import javax.swing.JFormattedTextField;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;

	public class ExempleDate {
	  public static void main(String args[]) {
	    JFrame frame = new JFrame("Date/Time Input");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    JLabel label;
	    JFormattedTextField input;
	    JPanel panel;

	    BoxLayout layout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
	    frame.setLayout(layout);

	    Format shortDate = DateFormat.getDateInstance(DateFormat.SHORT);
	    label = new JLabel("Short date:");
	    input = new JFormattedTextField(shortDate);
	    input.setValue(new Date());
	    input.setColumns(20);
	    
	    panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	    panel.add(label);
	    panel.add(input);
	    
	    frame.add(panel);
	    frame.pack();
	    frame.setVisible(true);
	  }
	}
