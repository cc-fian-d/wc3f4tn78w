package ctrl;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import model.Autor;

/**
 * CDI Managed BEAN
 */
@ApplicationScoped
@Named("autorservice")
public class AutorService {

	@PersistenceContext
	private EntityManager em;

	@Resource
	private UserTransaction ut;

	/**
	 * Lazy Loading Autor
	 * @return
	 */
	public Autor holeAutor() {
		return holeAutor(false);
	}
	
	/**
	 * 
	 * @param eager gibt an ob die Bücher auch geladen werden sollen.
	 * @return
	 */
	public Autor holeAutor(boolean eager) {
		Autor a = em.createQuery("SELECT a FROM Autor a WHERE a.id = :id", Autor.class).setParameter("id", 1)
				.getSingleResult();
		if (eager) {
			System.out.println(a.getBuecher().size());
		}

		return a;
	}
	
	public Autor holeAutorMitNamedQuery() {
		Autor a = em.createNamedQuery(Autor.QUERY_FIND_BY_ID, Autor.class)
				.setParameter(Autor.PARAMETER_FIND_BY_ID, 2).getSingleResult();
		return a;
	}
	
	public Autor holeAutorMitNamedQueryFetchBuch() {
		Autor a = em.createNamedQuery(Autor.QUERY_FIND_BY_ID_FETCH_BUCH, Autor.class)
				.setParameter(Autor.PARAMETER_FIND_BY_ID, 1).getSingleResult();
		return a;
	}
}
