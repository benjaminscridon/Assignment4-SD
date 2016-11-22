package ro.tuc.dsrl.ds.handson.assig.three.producer.start;

import ro.tuc.dsrl.ds.handson.assig.three.producer.connection.QueueServerConnection;
import util.SerDes;

import java.io.IOException;

import entities.DVD;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems,
 *          http://dsrl.coned.utcluj.ro/
 * @Module: assignment-one-client
 * @Since: Sep 1, 2015
 * @Description: Starting point for the Producer Client application. This
 *               application will send several messages to be inserted in the
 *               queue server (i.e. to be sent via email by a consumer).
 */
public class ClientStart {
	private static final String HOST = "localhost";
	private static final int PORT = 8888;

	private ClientStart() {
	}

	public static void main(String[] args) {
		System.out.println("Producer started...");
		QueueServerConnection queue = new QueueServerConnection(HOST, PORT);

		try {
			SerDes serializer = new SerDes();

			System.out.println(
					"First DVD ->" + queue.writeMessage(serializer.toString(new DVD("Come Alive", 2015, 8.99))));
			System.out.println(
					"Second DVD ->" + queue.writeMessage(serializer.toString(new DVD("Have It All", 2016, 9.99))));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
