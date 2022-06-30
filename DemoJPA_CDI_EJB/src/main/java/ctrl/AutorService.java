package ctrl;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import model.Autor;

@ApplicationScoped
@Named("autorservice")
public class AutorService {

	@PersistenceContext
	private EntityManager em;

	@Resource
	private UserTransaction ut;
	

	public Autor holeAutor() {
		Autor a = em.createQuery("SELECT a FROM Autor a WHERE a.id = :id", Autor.class)
				.setParameter("id", 1)
				.getSingleResult();
		return a;
	}
}
