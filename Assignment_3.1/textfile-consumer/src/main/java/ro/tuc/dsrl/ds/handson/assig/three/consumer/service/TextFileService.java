package ro.tuc.dsrl.ds.handson.assig.three.consumer.service;

import java.io.PrintWriter;
import entities.DVD;

/**
 * 
 * @author Beniamin Scridon
 * @since 11/21/2016
 */
public class TextFileService {

	private static int counter = 1;

	public TextFileService() {
	}

	public void writeFile(DVD dvd) {
		try {
			PrintWriter writer = new PrintWriter("text-files/Message" + counter + ".txt", "UTF-8");
			writer.println("Title:" + dvd.getTitle());
			writer.println("Year:" + dvd.getYear());
			writer.print("Price:" + dvd.getPrice());
			writer.close();
			System.out.println("Message" + counter + ".txt file created successfully");
			counter++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
