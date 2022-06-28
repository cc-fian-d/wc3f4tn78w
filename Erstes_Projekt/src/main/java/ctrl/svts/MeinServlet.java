package ctrl.svts;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Huhn;

/**
 * Servlet implementation class MeinServlet
 */
@WebServlet("/MeinServlet")
public class MeinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private Huhn huhn;//null
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Java SE die Kontrolle über die Erzeugung der Objekte liegt beim Entwickler.
//		huhn = new Huhn();
		
		//Java EE siehe zeile 21 @Inject
		//Die Kontrolle der Erzeugung der Objekte wird der CDI überlassen
		
		response.getWriter().println(huhn.toString());
		response.getWriter().println(huhn.getClass());
		response.getWriter().println(huhn.hashCode());
	}

}
