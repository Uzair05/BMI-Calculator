/**
 * This Class is the main client class.<br>Running this class allows the user to:<ol><li>Create Instance of View Object.</li><li>Assign view instance to instance of Controller Object.</li><li>Run Controller object to activate and display GUI.</li></ol>
 * @author <a href="https://Uzair05.github.io" target="_blank">Uzair Bin Asim</a>.
 * @since 31/12/2019
 * @version 1.2
 */
public class Main{
	/**
	 * Static Main
	 * @param args 
	 */
	public static void main(String[] args) {
		View view = new View();
		Controller control = new Controller(view);
		control.start();
	}
}