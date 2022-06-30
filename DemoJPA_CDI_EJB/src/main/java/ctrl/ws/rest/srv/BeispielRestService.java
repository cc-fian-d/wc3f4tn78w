package ctrl.ws.rest.srv;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * https://localhost:9443/DemoJPA_CDI_EJB/api/v1/beispiele
 * 
 *
 */
@Path("beispiele")
public class BeispielRestService {

//	@GET
	@POST
	public String halloWelt() {
		return "Hier spricht der RestService";
	}
	
}
