import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;

public class OutputForm {

	private JFrame frame;
	JTextArea output_textArea;
	
	public OutputForm() {
		initialize();	
		frame.setVisible(true);
				
	}
	
	public void addUpdates(String str) {
		output_textArea.append(str);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 901, 539);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Our Router's Connections Simulator");
		label.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 29));
		label.setBounds(86, 16, 767, 41);
		frame.getContentPane().add(label);
		
		JLabel lblConnectionBehaviourUpdates = new JLabel("Connection behaviour updates");
		lblConnectionBehaviourUpdates.setFont(new Font("Corbel", Font.PLAIN, 23));
		lblConnectionBehaviourUpdates.setBounds(278, 88, 309, 29);
		frame.getContentPane().add(lblConnectionBehaviourUpdates);
		
		output_textArea = new JTextArea();
		output_textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		output_textArea.setBounds(169, 125, 535, 308);
		frame.getContentPane().add(output_textArea);
	}
}
