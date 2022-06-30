package ctrl.svts;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ctrl.AutorService;
import model.Autor;

/**
 * Servlet implementation class ReadFromJpaWithService
 */
@WebServlet("/ReadFromJpaWithService")
public class ReadFromJpaWithService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	AutorService as;
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		
		Autor a = as.holeAutor();
		
		htmlOpen(out);
		
		out.println(a.getVorname());
		out.println(a.getNachname());
		out.println(a.getBuecher());
			
		htmlClose(out);
	}

	
	/**
	 * Hilfsmethode zum erzeugen der Statischen HTML Elemente
	 */
	private void htmlOpen(PrintWriter out) {
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"ISO-8859-1\">");
		out.write("<style>\r\n"
				+ "h1 {color:red;}"
				+ "h2 {color:orange;}"
				+ "h3 {color:steelblue;}"
				+ "</style>");
		out.write("<title>Unser Servlet</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<h1>Lesen von JPA mit CDI und Service Klasse 01</h1>");
		out.flush();
	}

	/**
	 * Hilfsmethode zum erzeugen der Statischen HTML Elemente
	 */
	private void htmlClose(PrintWriter out) {
		out.write("</body>");
		out.write("</html>");
		out.flush();
	}
	
}
