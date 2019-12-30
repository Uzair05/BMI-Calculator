public class Main{
	public static void main(String[] args) {
		View view = new View();
		Controller control = new Controller(view);
		control.start();
	}
}