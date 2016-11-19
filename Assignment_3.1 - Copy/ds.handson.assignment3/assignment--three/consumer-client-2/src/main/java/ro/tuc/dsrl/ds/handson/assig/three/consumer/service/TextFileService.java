package ro.tuc.dsrl.ds.handson.assig.three.consumer.service;

import java.io.PrintWriter;

import ro.tuc.dsrl.ds.handson.assig.three.producer.entities.DVD;

/**
 * 
 * @author Beniamin Scridon
 *
 */
public class TextFileService {

	private static int counter = 1;

	public TextFileService() {
	}

	public void writeFile(DVD dvd) {
		try {
			PrintWriter writer = new PrintWriter("text-files/Message" + counter + ".txt", "UTF-8");
			writer.println(dvd.getTitle() + "(" + dvd.getYear() + ")");
			writer.println(dvd.getPrice());
			writer.close();
			counter++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
