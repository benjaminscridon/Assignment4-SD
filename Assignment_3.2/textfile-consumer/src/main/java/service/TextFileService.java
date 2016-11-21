package service;

import java.io.PrintWriter;
import entities.DVD;

/**
 * 
 * @author Beniamin Scridon
 * @since 11/21/2016
 */
public class TextFileService {

	public TextFileService() {
	}

	public void writeFile(DVD dvd) {
		try {
			PrintWriter writer = new PrintWriter("text-files/" + dvd.getTitle() + ".txt", "UTF-8");
			writer.println("Title:" + dvd.getTitle());
			writer.println("Year:" + dvd.getYear());
			writer.print("Price:" + dvd.getPrice());
			writer.close();
			System.out.println(dvd.getTitle() + ".txt file created successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
