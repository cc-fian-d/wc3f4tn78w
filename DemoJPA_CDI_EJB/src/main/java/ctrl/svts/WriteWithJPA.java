package ctrl.svts;

import java.io.IOException;
import java.time.LocalDate;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import model.Autor;
import model.Buch;

/**
 * Servlet implementation class WriteWithJPA
 */
@WebServlet("/WriteWithJPA")
public class WriteWithJPA extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	@Resource
	private UserTransaction ut;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().println("before");

		/**
		 * Erzeugen von Buch und Autor
		 */
		Autor a1 = new Autor("Twain", "Mark");
		Autor a2 = new Autor("Wilde", "Oscar");

		Buch b1 = new Buch("1201", LocalDate.now().minusYears(22), "Ich und mein Ich", "Wir");
		Buch b2 = new Buch("1202", LocalDate.now().minusYears(22), "Du und Du", "Ihr");
		Buch b3 = new Buch("1203", LocalDate.now().minusYears(22), "Sie und Sie", "Diese");
		Buch b4 = new Buch("1204", LocalDate.now().minusYears(22), "Java und die Inseln", "Inseln");
		Buch b5 = new Buch("1205", LocalDate.now().minusYears(22), "Kaffee kommt auch aus Java", "Kaffee");

		/**
		 * Verknüpfen von Autor und Buch
		 */
		a1.addBuecher(b1);
		a1.addBuecher(b2);
		a1.addBuecher(b3);
		
		a2.addBuecher(b4);
		a2.addBuecher(b5);

		try {
			ut.begin();
			
			em.persist(b1);
			
//			em.persist(a1);
//			em.persist(a2);
			
//			a1.addBuecher(b1);
//			a1.addBuecher(b2);
//			a1.addBuecher(b3);
//			a1.addBuecher(b4);
//			a1.addBuecher(b5);

//			em.persist(b1);
//			em.persist(b2);
//			em.persist(b3);
//			em.persist(b4);
//			em.persist(b5);

			ut.commit();
		} catch (Exception e) {
			response.getWriter().println(e);
		}

		response.getWriter().println("after");
	}

}
