package ctrl.ws.rest.srv;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ctrl.ejb.AutorController;
import model.Autor;

@Path("ejb")
//@Stateless
public class BeispielRestServiceEJB {

	//@EJB
	@Inject
	private AutorController ac;
	
	@POST
	@Path("createautor")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String createAutor(Autor autor) {
		ac.persistAutor(autor);
		return "success";
	}
	
	@GET
	@Path("readautor/{index}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Autor readAutor(@PathParam("index") int idx) {
		return ac.findAutor(idx);
	}
	
}
