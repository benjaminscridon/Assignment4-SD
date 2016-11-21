package presentation;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import businesslogic.MessageService;
import entities.DVD;

/**
 * 
 * @author Beniamin Scridon
 * @since 11/21/2016
 */
public class AdministratorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MessageService messageService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("administrator.html");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DVD dvd = buildDVD(request);
		if (null == dvd) {
			response.sendRedirect("error-page.html");
			return;
		}

		try {
			getMessageService().sendMessage(dvd);
		} catch (TimeoutException | IOException exc ) {
			exc.printStackTrace();
			response.sendRedirect("error-page.html");
			return;
		}
		
		request.setAttribute("dvd", dvd);
		request.getRequestDispatcher("success.jsp").forward(request, response);
	}

	private DVD buildDVD(HttpServletRequest request) {
		String title = request.getParameter("title");
		String year = request.getParameter("year");
		String price = request.getParameter("price");

		DVD dvd = null;
		try {
			dvd = new DVD(title, Integer.parseInt(year), Double.parseDouble(price));
		} catch (java.lang.NumberFormatException ex) {
			return null;
		}
		return dvd;
	}

	private MessageService getMessageService() throws IOException {
		if (null == messageService) {
			messageService = new MessageService();
		}
		return messageService;
	}
}
