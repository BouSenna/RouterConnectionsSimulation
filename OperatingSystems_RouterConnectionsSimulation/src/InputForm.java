import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InputForm {

	private JFrame frame;
	private JTextField ConnectiostextField;
	private JTextField DevicestextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputForm window = new InputForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InputForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 619);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Our Router's Connections Simulator");
		label.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 29));
		label.setBounds(106, 0, 767, 106);
		frame.getContentPane().add(label);
		
		JLabel lblWhatIsThe = new JLabel("What is the number of connections your router can accept?");
		lblWhatIsThe.setFont(new Font("Corbel", Font.PLAIN, 23));
		lblWhatIsThe.setBounds(50, 112, 568, 20);
		frame.getContentPane().add(lblWhatIsThe);
		
		JLabel lb2 = new JLabel("What is the number of devices that wishes to connect?");
		lb2.setFont(new Font("Corbel", Font.PLAIN, 23));
		lb2.setBounds(50, 188, 568, 20);
		frame.getContentPane().add(lb2);
		
		JLabel lb3 = new JLabel("Please, enter the names of the devices.");
		lb3.setFont(new Font("Corbel", Font.PLAIN, 23));
		lb3.setBounds(50, 260, 384, 20);
		frame.getContentPane().add(lb3);
		
		JLabel lb4 = new JLabel("Please, enter the types of the devices.");
		lb4.setFont(new Font("Corbel", Font.PLAIN, 23));
		lb4.setBounds(509, 260, 568, 20);
		frame.getContentPane().add(lb4);
		
		ConnectiostextField = new JTextField();
		ConnectiostextField.setBounds(72, 137, 344, 26);
		frame.getContentPane().add(ConnectiostextField);
		ConnectiostextField.setColumns(10);
		
		DevicestextField = new JTextField();
		DevicestextField.setColumns(10);
		DevicestextField.setBounds(72, 218, 344, 26);
		frame.getContentPane().add(DevicestextField);
		
		JTextArea Names_textArea = new JTextArea();
		Names_textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		Names_textArea.setBounds(72, 293, 344, 106);
		frame.getContentPane().add(Names_textArea);
		
		JTextArea TypestextArea = new JTextArea();
		TypestextArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		TypestextArea.setBounds(519, 293, 344, 106);
		frame.getContentPane().add(TypestextArea);
		
		JButton btnNewButton = new JButton("Start Simulation");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Router router = new Router(Integer.parseInt(ConnectiostextField.getText()));
				router.addDevices(Names_textArea.getText().split("\n"),
						TypestextArea.getText().split("\n"),
						Integer.parseInt(DevicestextField.getText()));
			}
		});
		btnNewButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 24));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(298, 440, 360, 65);
		frame.getContentPane().add(btnNewButton);
	
	}
}
