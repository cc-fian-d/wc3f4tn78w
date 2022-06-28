package ctrl;

public class Applikation {

	public static void main(String[] args) {
		Observable entertainer = new Observable();

		Observer harald = new Observer("harald");
		Observer hildegard = new Observer("hildegard");
		Observer waldtraud = new Observer("waldtraud");
		
		entertainer.addObserver(harald);
		entertainer.addObserver(hildegard);
		entertainer.addObserver(waldtraud);
		
		entertainer.setMessage("Kaffee ist fertig");
		System.out.println();
		entertainer.setMessage("Kuchen steht bereit");
		System.out.println();
		entertainer.removeObserver(harald);
		entertainer.setMessage("Die Bingotrommel läuft");
		System.out.println();
		entertainer.setMessage("B 4");
	}

}
