package ctrl.ws.rest.srv;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ctrl.AutorService;
import model.Autor;

/**
 * https://localhost:9443/DemoJPA_CDI_EJB/api/v1/beispiele
 * 
 * http://localhost:9080/DemoJPA_CDI_EJB/api/v1/beispiele
 *
 */
@Path("beispiele")
public class BeispielRestService {

	@Inject
	private AutorService as;
	
	@GET
	public String halloWeltGet() {
		return "Bitte keine GET anfragen an die REST-API stellen.";
	}
	
	@POST
	public String halloWeltPost() {
		return "Richtig, POST ist die Methode womit diese API arbeitet";
	}
	
	@POST
	@Path("message")
	public String halloWeltMessage(String message) {
		return "Hallo welt " + message;
	}
	
	@POST
	@Path("createautor")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String createAutor(Autor autor) {
		
		System.out.println(autor.getVorname());
		System.out.println(autor.getNachname());
		
		as.persistAutor(autor);
		
		return "success";
	}
	
	@POST
	@Path("readautor")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Autor readAutor() {
		return new Autor("Teste","RestApiService");

	}
	
}
