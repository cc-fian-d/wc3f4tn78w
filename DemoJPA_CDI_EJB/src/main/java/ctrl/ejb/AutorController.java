package ctrl.ejb;

import java.io.Serializable;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Autor;

@Singleton
//@Stateless
//@Stateful
@TransactionManagement(TransactionManagementType.CONTAINER)
@Startup
public class AutorController implements Serializable {

	@PersistenceContext
	private EntityManager em;
	
	public AutorController() {
		System.out.println("EJB Init");
	}
	
	public void persistAutor(Autor autor) {
		em.persist(autor);
	}
	
	public Autor findAutor(int idx) {
		return em.find(Autor.class, idx);
	}
}
