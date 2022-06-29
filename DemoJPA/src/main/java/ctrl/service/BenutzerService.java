package ctrl.service;

import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import model.Benutzer;

@ApplicationScoped
@Named("benutzerservice")
public class BenutzerService {

	/**
	 * Es steht keine EJB zur Verfügung, also müssen wir auf BMT setzen.
	 * 
	 * JPA mit BMT - Beans Managed Transaction (User Managed Transaction)
	 * 
	 * EntityManager und UserTransaction
	 */
	@PersistenceContext
	private EntityManager em;

	@Resource
	private UserTransaction ut;

	@Inject
	private Benutzer benutzer;

	public List<Benutzer> holeAlleBenutzer() {
		return em.createQuery("SELECT b FROM Benutzer b", Benutzer.class).getResultList();
	}

	public String persistBenutzer() {
		System.out.println("persistBenutzer");
		System.out.println(benutzer.getClass());

		
		//model.Benutzer$Proxy$_$$_WeldClientProxy
		
		try {
			ut.begin();
			em.persist(benutzer);
			ut.commit();
		} catch (Exception e) {
			System.out.println("EXCEPTION :" + e.getMessage());
		}
		return "success";
	}
}
