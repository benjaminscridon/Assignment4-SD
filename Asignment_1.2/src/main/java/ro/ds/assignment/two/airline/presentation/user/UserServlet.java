package ro.ds.assignment.two.airline.presentation.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ro.ds.assignment.two.airline.businesslogic.FlightService;
import ro.ds.assignment.two.airline.domain.Flight;

/**
 * @author Beniamin Scridon
 * @since Sunday,October 23,2016 
 */
public class UserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private FlightService flightService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<!DOCTYPE html>");
		out.print("<html lang=\"en\">");
		printHeader(out);
		printSearchForm(out);

		out.print("<div class =\"col-md-9\">");
		out.print("<table class=\"table table-hover\">");
		out.print("<thead>");
		out.print("<tr>");
		out.print("<th>Flight No</th>");
		out.print("<th>Departure City</th>");
		out.print("<th>Departure Date</th>");
		out.print("<th>Arrival City</th>");
		out.print("<th>Arrival Date</th>");
		out.print("</tr>");
		out.print("</thead>");

		flightService = new FlightService();
		out.print("<tbody>");

		  DateFormat dateFormat = new SimpleDateFormat("MMMM dd, YYYY");
		  DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
		
		for (Flight flight : flightService.getAllFlights()) {
			out.print(
					"<tr>" 
		            +	"<td>" + flight.getFlightNumber() + "</td>" 
		            
					+ 	"<td><a href=\"local-time?city=" + flight.getDepartureCity().getName() + "\"" +"class=\"city-label\">"+ flight.getDepartureCity().getName() + "</a></td>" 
					+ 	"<td> 	&#128197; " + dateFormat.format(flight.getDepartureDateTime()) 
					+ 			"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#128336; " + timeFormat.format(flight.getDepartureDateTime()) + "</td>"
					+ 	"<td><a href=\"local-time?city=" + flight.getArrivalCity().getName() + "\""+  " class=\"city-label\">" + flight.getArrivalCity().getName() + "</td>" 
					+ 	"<td> 	&#128197; " + dateFormat.format(flight.getArrivalDateTime()) 
					+ 			"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#128336; " + timeFormat.format(flight.getArrivalDateTime()) + "</td>"
					+ "</tr>");
		}

		out.print("</tbody></table></div></div></div>");
		printFooter(out);
		out.print("</html>");
		out.close();
	}

	private void printHeader(PrintWriter out) {
		out.print("<head>" + "<title>Flights</title>" + "<meta charset=\"utf-8\">"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"

				+ "<link rel=\"stylesheet\" href=\"resources/css/template.css\">"
				+ "<link rel=\"stylesheet\" href=\"resources/css/header.css\">"
				+ "<link rel=\"stylesheet\" href=\"resources/css/user.css\">"
				+ "<link rel=\"stylesheet\" href=\"resources/css/table.css\">"
				+ "<link rel=\"stylesheet\" href=\"resources/css/footer.css\">"
				+ "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" />"
				+ "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css\" />"

				+ "<script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js\"></script>"
				+ "<script type=\"text/javascript\" src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>"
				+ "<script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-1.11.3.min.js\"></script>"
				+ "<script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js\"></script>"
				+ "<script type=\"text/javascript\" src=\"resources/js/date-picker.js\"></script>"
				+ "</head>");
	}

	private void printSearchForm(PrintWriter out) {
		out.print("<body>" 
				//<!-- HEADER -->
				+ "<div class=\"header\">"
				
				+     "<span class=\"glyphicon glyphicon-home icon\"></span>" 
				+     "<span class=\"glyphicon glyphicon-plus icon\"></span>" 
				+	  "<span class=\"glyphicon glyphicon-search icon\"></span>" 
				+	  "<span class=\"glyphicon glyphicon-user icon\"></span>" 
				+     "<span class=\"glyphicon glyphicon-volume-up icon\"></span> "
				+ 	  "<span class=\"glyphicon glyphicon-pencil icon\"></span>" 
				+     "<span class=\"glyphicon glyphicon-envelope icon\"></span>" 
				+	  "<span class=\"glyphicon glyphicon-print icon\"></span>"
				+     "<span class=\"glyphicon glyphicon-plane icon\"></span>" 
				+	  "<span class=\"glyphicon glyphicon-lock icon\"></span>" 
				+ 	  "<span class=\"glyphicon glyphicon-signal icon\"></span>" 
				+	  "<span class=\"glyphicon glyphicon-star icon\"></span>" 
				+	  "<span class=\"glyphicon glyphicon-cog icon\"></span>" 
				+ "<form id=\"logoutForm\" action=\"logout\" method=\"POST\" class=\"logout-form\">"
				+"<span class=\"glyphicon glyphicon-log-out icon\" onclick=\"document.getElementById('logoutForm').submit()\"></span>"
			+"</form>"
				+ "</div>"
				
				+ "<div class=\"container-fluid\">" 
				+ "<div class=\"col-sm-3 sidenav\">" + "<div class=\"form\">"
				+ "<div class=\"thumbnail\">" + "<img src=\"resources/images/loupe.svg\" />" + "</div>"

				+ "<label class=\"control-label\"><span class=\"required\">*&nbsp;</span>Departure City</label>"
				+ "<input class=\"form-control\" type=\"text\"/>"

				+ "<div class=\"form-group\">"
				+ "<label class=\"control-label\" for=\"date\"><span class=\"required\">*&nbsp;</span>Departure Date</label> "
				+ "<input class=\"form-control\" id=\"date\" name=\"date\" placeholder=\"MM/DD/YYYY \"type=\"text\" />"
				+ "</div>"

				+ "<label class=\"control-label\"><span class=\"required\">*&nbsp;</span>Arrival City</label>"
				+ "<input class=\"form-control\" type=\"text\"/>"

				+ "<div class=\"form-group\">"
				+ "<label class=\"control-label\" for=\"date\">Return Date</label>"
				+ "<input class=\"form-control\" id=\"date\" name=\"date\" placeholder=\"MM/DD/YYYY\" type=\"text\" />"
				+ "</div>"

				+ "<button>Search</button>" + "</div>" + "</div>");
	}

	private void printFooter(PrintWriter out) {
		out.print(
				"<footer class=\"container-fluid\">"
						+ "<p>Copyright &#169; 2016 | Site built by Beniamin Scridon &#9992; &#9992; &#9992;</p>"
						+ "</footer>" + "</body>");
	}
}