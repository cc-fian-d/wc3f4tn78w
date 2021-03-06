package ctrl.cdicontainer;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transactional;
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
	 * 
	 * @return
	 */
	public Autor holeAutor() {
		return holeAutor(false);
	}

	/**
	 * 
	 * @param eager gibt an ob die B?cher auch geladen werden sollen.
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
		Autor a = em.createNamedQuery(Autor.QUERY_FIND_BY_ID, Autor.class).setParameter(Autor.PARAMETER_FIND_BY_ID, 2)
				.getSingleResult();
		return a;
	}

	public Autor holeAutorMitNamedQueryFetchBuch() {
		Autor a = em.createNamedQuery(Autor.QUERY_FIND_BY_ID_FETCH_BUCH, Autor.class)
				.setParameter(Autor.PARAMETER_FIND_BY_ID, 1).getSingleResult();
		return a;
	}

	public void persistAutor(Autor autor) {

		try {
			ut.begin();
			em.persist(autor);
			ut.commit();
		} catch (NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Autor findAutor(int idx) {
		Autor a = null;

		try {
			ut.begin();
			a = em.find(Autor.class, idx);
			a.getBuecher().size();
			ut.commit();
		} catch (Exception e) {

		}

		a.getBuecher().forEach(b -> b.setAutorBean(null));

		return a;
	}
}
