package ctrl.svts;

import java.io.IOException;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import model.Benutzer;

/**
 * Servlet implementation class WorkWithJPA
 */
@WebServlet("/WriteWithJPA")
public class WriteWithJPA extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("before");
		
		
		String vorname = request.getParameter("v");
		String nachname = request.getParameter("n");
		
		if(vorname==null && nachname == null) {
			vorname = "Harald";
			nachname = "Feuerstein";
		}
		
		Benutzer b01 = new Benutzer();
		b01.setVorname(vorname);
		b01.setNachname(nachname);
		
		try {
			ut.begin();
			em.persist(b01);
			ut.commit();
		} catch (NotSupportedException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (RollbackException e) {
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			e.printStackTrace();
		}
		
		
		
		
		response.getWriter().println("after");
	}

}
