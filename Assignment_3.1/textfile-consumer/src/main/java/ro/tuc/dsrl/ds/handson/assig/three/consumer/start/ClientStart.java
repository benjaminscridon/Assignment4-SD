package ro.tuc.dsrl.ds.handson.assig.three.consumer.start;

import ro.tuc.dsrl.ds.handson.assig.three.consumer.connection.QueueServerConnection;
import ro.tuc.dsrl.ds.handson.assig.three.consumer.service.TextFileService;
import util.SerDes;

import java.io.IOException;

import entities.DVD;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems,
 *          http://dsrl.coned.utcluj.ro/
 * @Module: assignment-one-client
 * @Since: Sep 1, 2015
 * @Description: Starting point for the Consumer Client application. This
 *               application will run in an infinite loop and retrieve messages
 *               from the queue server and send e-mails with them as they come.
 */
public class ClientStart {

	private ClientStart() {
	}

	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("TextFile Consumer started...");
		QueueServerConnection queue = new QueueServerConnection("localhost", 8888);

		SerDes deserializer = new SerDes();
		TextFileService fileService = new TextFileService();
		String message;

		while (true) {
			try {
				message = queue.readMessage();
				DVD dvd = (DVD) deserializer.fromString(message);

				fileService.writeFile(dvd);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
