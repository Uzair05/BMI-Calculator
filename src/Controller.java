import java.awt.event.*;

/**
 * This class is involved in creating the instance of View.java object and assigning commands and controls to its elements. <br>
 * Standards Derived from <a href="https://www.nhs.uk/common-health-questions/lifestyle/what-is-the-body-mass-index-bmi/" target="_blank">NHS</a><br>
 * @author <a href="https://Uzair05.github.io" target="_blank">Uzair Bin Asim</a>.
 * @since 31/12/2019
 * @version 1.2
 */
public class Controller{
	private View view;
	/**
	 * Constructor class.<br>Calls for assigns view instance to its own local instance.
	 * @param view Instance of Object View.java
	 */
	public Controller(View view) {
		this.view = view;
	}

	private ActionListener resultsListener;

	/**
	 * Assigns Controls and commands to elements in view instance.
	 */
	public void start() {
		this.resultsListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				if (isValid()) {
					view.setNotificationsLabel("*Notifications Bar*");
					view.setResultsString("Your BMI is: " + getResults() + ".\n" + getWarnings());
				}else {
					view.setNotificationsLabel("Values Must be Numeric decimals");
					view.getInputHeight().setText("");
					view.getInputWeight().setText("");
					view.getInputHeight().requestFocus();
				}
			}
		};
		this.view.getResultsButton().addActionListener(resultsListener);
	}

	private String getWarnings() {
		double BMI = this.getBMI();
		String s = "";
		if(BMI<18.5) {
			s="You are Underweight";
		}else if (BMI <= 24.9) {
			s = "You are normal";
		}else if(BMI<=29.9) {
			s="You are Overweight";
		}else{
			s="You are Obese";
			this.view.emergencyNotification("You are Obese.\nIt is suggested that you seek medical help.");
		}
		return s;
	}
	private String getResults() {
		String s = String.format("%.2f", this.getBMI());
		return s;
	}
	private boolean isValid() {
		boolean valid = true;
		if (this.view.getInputHeight().getText() == "") {
			valid = false;
		}
		if (this.view.getInputWeight().getText() == "") {
			valid = false;
		}

		try {
			Double.parseDouble(this.view.getInputHeight().getText());
			Double.parseDouble(this.view.getInputWeight().getText());
		}catch(Exception ex){
			valid = false;
		}

		return valid;
	}
	private double getBMI() {
		try{
			double height = Double.parseDouble(this.view.getInputHeight().getText());
			double weight = Double.parseDouble(this.view.getInputWeight().getText());
			double BMI = (double)(weight/(height*height));
			return BMI;
		}catch(Exception ex){
			return 0.0;
		}
	}
}
