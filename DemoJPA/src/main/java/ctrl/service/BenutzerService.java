package ctrl.service;

import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
	private Benutzer injectedBenutzer;

	public List<Benutzer> holeAlleBenutzer() {
		return em.createQuery("SELECT b FROM Benutzer b", Benutzer.class).getResultList();
	}
	
	public List<Benutzer> findBenutzerByVorname(){
//		return em.createQuery("SELECT b FROM Benutzer b WHERE b.vorname LIKE '%a%'", Benutzer.class).getResultList();
		
		TypedQuery<Benutzer> tq = em.createNamedQuery(Benutzer.QUERY_FIND_BY_VORNAME, Benutzer.class);
		tq.setParameter(Benutzer.PARAMETER_FIND_BY_VORNAME, "%lia");	
		return tq.getResultList();
	}
	
	public List<Benutzer> findBenutzerByNachname(){
		TypedQuery<Benutzer> tq = em.createNamedQuery(Benutzer.QUERY_FIND_BY_NACHNAME, Benutzer.class);
		tq.setParameter(Benutzer.PARAMETER_FIND_BY_NACHNAME, "%ei%");	
		return tq.getResultList();
		
		
	}

	public String persistBenutzer() {
		System.out.println("persistBenutzer");
		System.out.println(injectedBenutzer.getClass());
		
		/**
		 * OOP ->>> PMO
		 */
		Benutzer toPersist = new Benutzer();
		toPersist.setPersonalnummer(injectedBenutzer.getPersonalnummer());
		toPersist.setVorname(injectedBenutzer.getVorname());
		toPersist.setNachname(injectedBenutzer.getNachname());
		
		try {
			ut.begin();
//			em.persist(new Benutzer(benutzer));
//			em.persist(benutzer.clone());
			em.persist(toPersist);
			ut.commit();
		} catch (Exception e) {
			System.out.println("EXCEPTION :" + e.getMessage());
		}
		return "success";
	}
}
