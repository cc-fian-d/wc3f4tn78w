package ctrl.svts;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Benutzer;

/**
 * Servlet implementation class ReadWithJPA
 */
@WebServlet("/ReadWithJPA")
public class ReadWithJPA extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("before");
		
		int idx = 1;
		Benutzer b = null;
		do {
			b = em.find(Benutzer.class, idx);
			response.getWriter().println(b);
			idx++;
		}while(b!=null);

		
		response.getWriter().println("after");
	}

}
