package ctrl;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class MyWebservice {

	@WebMethod(operationName = "calculate")
	public void doStuff() {
		System.out.println("doStuff");
	}
	
	
	@WebMethod
	public String hello(@WebParam(name = "message") String name) {
		System.out.println("Hallo " + name);
		return "Schoenen Tag noch :" + name;
	}
	
//	@WebMethod
	@Oneway
	public void longTimeCalculate() {
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Fertig");
	}
	
	@WebMethod
	public Buch holeBuch() {
		Buch b = new Buch();
		b.setAutor("Wolfgang Hohlbein");
		b.setTitel("Das Schwarze Auge");
		return b;
	}
}
