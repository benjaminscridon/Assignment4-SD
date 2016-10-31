package ro.ds.assignment.two.airline.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CallWebService {

	public static void main(String[] args) throws IOException, ParseException {
		String webServiceUrl="http://api.geonames.org/timezoneJSON?lat=41.881832&lng=-87.623177&username=beniamin.scridon";
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(httpGet(webServiceUrl));
		//System.out.println(json.get("sunrise") + "\n"+json.get("time"));
	}
	
	public static String httpGet(String urlStr) throws IOException {
		  URL url = new URL(urlStr);
		  HttpURLConnection conn =
		      (HttpURLConnection) url.openConnection();

		  if (conn.getResponseCode() != 200) {
		    throw new IOException(conn.getResponseMessage());
		  }

		  // Buffer the result into a string
		  BufferedReader rd = new BufferedReader(
		      new InputStreamReader(conn.getInputStream()));
		  StringBuilder sb = new StringBuilder();
		  String line;
		  while ((line = rd.readLine()) != null) {
			  System.out.println(line);
		    sb.append(line);
		  }
		  rd.close();

		  conn.disconnect();
		  return sb.toString();
		}
	
}
