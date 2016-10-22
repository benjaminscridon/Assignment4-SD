package ro.ds.assignment.two.airline.presentation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -8563395287326271570L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// super.doGet(req, resp); response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Flights</title></head>");
		out.println("<body>");
		out.println("<h1>Login Page Servlet Implementation</h1>");
		for (int i = 1; i <= 6; i++) {
			out.print("<h" + i + ">");
			out.print("Hello world.");
			out.println("</h" + i + ">");
		}

		out.println("</body></html>");
		out.close();

		//response.sendRedirect("login.html");

	}

}
