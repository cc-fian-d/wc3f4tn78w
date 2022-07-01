package ctrl.ejb;

import java.io.Serializable;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import model.Autor;

@Singleton
//@Stateless
//@Stateful
@TransactionManagement(TransactionManagementType.CONTAINER)
@Startup
//@Transactional(value = TxType.REQUIRED)
public class AutorController implements Serializable {

	@PersistenceContext
	private EntityManager em;
	
	public AutorController() {
		System.out.println("EJB Init");
	}
	
	public void persistAutor(Autor autor) {
		em.persist(autor);
	}
	
	//@Transactional(value = TxType.REQUIRED)
	public Autor findAutor(int idx) {
		Autor a = em.find(Autor.class, idx);
		a.getBuecher().size();
		return a;
	}
}
