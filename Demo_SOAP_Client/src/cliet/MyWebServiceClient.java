package cliet;

import ctrl.Buch;
import ctrl.MyWebservice;
import ctrl.MyWebserviceService;

public class MyWebServiceClient {

	public static void main(String[] args) {
		MyWebserviceService service = new MyWebserviceService();

		MyWebservice port = service.getMyWebservicePort();
		
		String antwort = port.hello("Dies ist ein JAVA SE Client");
		
		System.out.println(antwort);
		
		port.longTimeCalculate();
		
		Buch b = port.holeBuch();
		
		System.out.println(b.getAutor());
		System.out.println(b.getTitel());
		
	}

}
