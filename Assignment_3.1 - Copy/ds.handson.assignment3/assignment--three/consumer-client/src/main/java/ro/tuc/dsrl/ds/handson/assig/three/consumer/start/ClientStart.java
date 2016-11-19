package ro.tuc.dsrl.ds.handson.assig.three.consumer.start;

import ro.tuc.dsrl.ds.handson.assig.three.consumer.connection.QueueServerConnection;
import ro.tuc.dsrl.ds.handson.assig.three.consumer.service.MailService;
import ro.tuc.dsrl.ds.handson.assig.three.producer.entities.DVD;

import java.io.IOException;

/**
 * @Author: Technical University of Cluj-Napoca, Romania
 *          Distributed Systems, http://dsrl.coned.utcluj.ro/
 * @Module: assignment-one-client
 * @Since: Sep 1, 2015
 * @Description:
 *	Starting point for the Consumer Client application. This application
 *  will run in an infinite loop and retrieve messages from the queue server
 *  and send e-mails with them as they come.
 */
public class ClientStart {

	private ClientStart() {
	}

	public static void main(String[] args) {
		QueueServerConnection queue = new QueueServerConnection("localhost",8888);

		MailService mailService = new MailService("message.queue.test@gmail.com","isthisastrongpassword?");
		DVD dvd;

		while(true) {
			try {
				dvd =  queue.readMessage();
				System.out.println("Sending mail . . . "+dvd.toString());
				mailService.sendMail("message.queue.test@gmail.com","New album '" + dvd.getTitle() + "' release",dvd.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
