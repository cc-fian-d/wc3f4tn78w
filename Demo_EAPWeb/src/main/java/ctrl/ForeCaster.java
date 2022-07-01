package ctrl;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class ForeCaster {

	@WebMethod
	public void ping() {
		System.out.println("Pong");
	}
	
}
