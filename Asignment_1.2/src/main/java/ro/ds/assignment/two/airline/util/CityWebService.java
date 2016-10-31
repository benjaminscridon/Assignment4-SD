package ro.ds.assignment.two.airline.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import javax.json.stream.JsonParserFactory;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CityWebService {

	public  String findLocalTime(String name) throws JsonParseException, JsonProcessingException, IOException, ParseException {
		String webServiceUrl = "http://maps.google.com/maps/api/geocode/json?address="+name;

		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper
				.readTree(mapper.getJsonFactory()
				.createJsonParser(httpGet(webServiceUrl)));

		String latitude = ""+rootNode.findValue("lat");
		String longitude=""+rootNode.findValue("lng");
		
		
		String webServiceUrl2=
				"http://api.geonames.org/timezoneJSON?lat="+latitude+"&lng="+longitude+"&username=beniamin.scridon";
	
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(httpGet(webServiceUrl2));
	
		return ""+json.get("time");
	}

	public static String httpGet(String urlStr) throws IOException {
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}

		// Buffer the result into a string
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();

		conn.disconnect();
		return sb.toString();
	}
}
