package ctrl;

public class Observer {
	
	private String name;
	
	public Observer(String name) {
		this.name = name;
	}
	
	public void update(String message) {
		/**
		 * message pr�fen ob Politisch korrekt
		 */
		System.out.println(name + " hat " + message + " geh�rt");
	}
	
}
