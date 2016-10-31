package ro.ds.assignment.two.airline.presentation.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonProcessingException;
import org.json.simple.parser.ParseException;

import ro.ds.assignment.two.airline.util.CityWebService;

/**
 * Servlet implementation class LocalTimeServlet
 */
public class LocalTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LocalTimeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String city = request.getParameter("city");
		System.out.println("City:"+city);
		
		if (city.length() != 0) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			out.print("<!DOCTYPE html>");
			out.print("<html lang=\"en\">");
			
			printHeader(out);
			try {
				printBody(out,city);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			printFooter(out);
		
			out.print("</html>");
			out.close();

			
		} else {
			response.getWriter().append("Error...").append(request.getContextPath());
		}
	}

	private void printHeader(PrintWriter out){
		out.print(
				"<head>"
				+ "<title>City Detail</title>"
				+ "<meta charset=\"utf-8\">"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"

				+ "<link rel=\"stylesheet\" href=\"resources/css/template.css\">"
				+ "<link rel=\"stylesheet\" href=\"resources/css/city-details.css\">"
				+ "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" />"
				+ "</head>"
				
				);
	}
	
	
	private void printBody(PrintWriter out,String city) throws JsonParseException, JsonProcessingException, IOException, ParseException{
		CityWebService service =new CityWebService();
		out.print(
				"<body>"
				+	"<div class=\"container-fluid\">"
				+		"<div class=\"row content\">"
				+			"<div class=\"col-sm-7 sidenav\">"	
				+				"<div class=\"form\">"
				+ 					"<h2>&#10162; Current time in " + city  + " is " + service.findLocalTime(city) +"</h1>"
						
				+"</div></div></div></div>"
				);
	}
	
	
	
	
	private void printFooter(PrintWriter out) {
		out.print(

				"<footer class=\"container-fluid footer\">"
						+ "<p>Copyright &#169; 2016 | Site built by Beniamin Scridon &#9992; &#9992; &#9992;</p>"
						+ "</footer>" + "</body>");
	}

}
