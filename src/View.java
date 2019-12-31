import java.awt.*;
import javax.swing.*;
/**
 * This class allows for the creation and setup of the GUI and its layout.
 * @author <a href="https://Uzair05.github.io" target="_blank">Uzair Bin Asim</a>.
 * @since 31/12/2019
 * @version 1.2
 * 
 * <div>
 * 	Icons made by <a href="https://www.flaticon.com/authors/freepik" title="Freepik">Freepik</a> 
 * from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a>
 * </div>
 * 
 */
public class View{
	/**
	 * Constructor Class.<br>
	 * Calls for {@code this.start()} to allow building and setup of GUI.
	 */
	public View(){
		this.start();
	}
	
	private JFrame frame;
	private JPanel panel;
	private JPanel[] functionPanel = new JPanel[3];
	private JTextField input_weight = new JTextField();
	private JTextField input_height = new JTextField();
	private JLabel label_weight = new JLabel("Enter Your Weight in kg");
	private JLabel label_height = new JLabel("Enter Your Height in meters");
	private JTextArea output_results = new JTextArea();
	private JButton results_button = new JButton("Results");
	private JLabel notifications = new JLabel("*Notifications Bar*");
	private ImageIcon icon = new ImageIcon("./Icons/medical-kit.png");
	
	private void start() {
		frame = new JFrame();
		frame.setTitle("BMI Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 250);
		frame.add(this.mainPanel(), BorderLayout.CENTER);
		frame.setLocationRelativeTo(null); 
		/*Add menu Bar*/
		frame.setVisible(true);
	}
	private JPanel mainPanel() {
		this.panel=new JPanel();
		this.panel.setLayout(new GridLayout(3,1));
		this.panel.add(this.function1());
		this.panel.add(this.function2());
		this.panel.add(this.function3());
		this.panel.setBackground(Color.pink);
		return this.panel;
	}
	private JPanel function1() {
		this.functionPanel[0] = new JPanel();
		this.functionPanel[0].setBackground(Color.orange);
		this.functionPanel[0].setLayout(new GridLayout(2,2));
		this.functionPanel[0].add(this.input_weight);
		this.functionPanel[0].add(this.label_weight);
		this.functionPanel[0].add(this.input_height);
		this.functionPanel[0].add(this.label_height);
		return this.functionPanel[0];
	}
	private JPanel function2() {
		this.functionPanel[1] = new JPanel();
		this.functionPanel[1].setBackground(Color.pink);
		this.output_results.setEditable(false);
		this.output_results.setBackground(Color.yellow);
		this.functionPanel[1].setLayout(new GridLayout(2,1));
		this.functionPanel[1].add(this.output_results);
		this.functionPanel[1].add(this.results_button);
		return this.functionPanel[1];
	}
	private JPanel function3() {
		this.functionPanel[2] = new JPanel();
		this.functionPanel[2].setBackground(Color.pink);
		this.functionPanel[2].add(this.notifications, BorderLayout.CENTER);
		return this.functionPanel[2];
	}
	


	
	
	
	
	/**
	 * This Method deals with the display of pop ups concerning Medical Emergencies.
	 * @param s Input string holding the value of the emergency message.
	 */
	public void emergencyNotification(String s) {
		JOptionPane.showMessageDialog(
				this.frame,
				s,
				"Medical Suggestion",
				JOptionPane.INFORMATION_MESSAGE,
				this.icon
				);
	}
	/**
	 * This Method deals with setting the notification label.
	 * @param s Input string holding the value of the message.
	 */
	public void setNotificationsLabel(String s) {
		this.notifications.setText(s);
	}
	/**
	 * This method returns the JButton which allows the user to submit his details.
	 * @return {@code this.results_button} The JButton in the GUI.
	 */
	public JButton getResultsButton() {
		return this.results_button;
	}
	/**
	 * This method is concerned with setting the results label to the desired Text.
	 * @param s Input string holding the value of the message.
	 */
	public void setResultsString(String s) {
		this.output_results.setText(s);
	}
	/**
	 * This method returns the JTextField which allows the user to input his details.
	 * @return {@code this.input_weight} The JTextField in the GUI which allows user to input their weight.
	 */
	public JTextField getInputWeight() {
		return this.input_weight;
	}
	/**
	 * This method returns the JTextField which allows the user to input his details.
	 * @return {@code this.input_height} The JTextField in the GUI which allows user to input their height.
	 */
	public JTextField getInputHeight() {
		return this.input_height;
	}
}