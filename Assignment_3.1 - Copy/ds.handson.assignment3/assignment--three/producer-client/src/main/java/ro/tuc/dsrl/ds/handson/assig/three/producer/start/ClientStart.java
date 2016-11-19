package ro.tuc.dsrl.ds.handson.assig.three.producer.start;

import ro.tuc.dsrl.ds.handson.assig.three.producer.connection.QueueServerConnection;
import ro.tuc.dsrl.ds.handson.assig.three.producer.entities.DVD;

import java.io.IOException;

/**
 * @Author: Technical University of Cluj-Napoca, Romania
 *          Distributed Systems, http://dsrl.coned.utcluj.ro/
 * @Module: assignment-one-client
 * @Since: Sep 1, 2015
 * @Description:
 *	Starting point for the Producer Client application. This
 *	application will send several messages to be inserted
 *  in the queue server (i.e. to be sent via email by a consumer).
 */
public class ClientStart {
	private static final String HOST = "localhost";
	private static final int PORT = 8888;

	private ClientStart() {
	}

	public static void main(String[] args) {
		QueueServerConnection queue = new QueueServerConnection(HOST, PORT);

		try {
			queue.writeMessage(new DVD("COME ALIVE",2016,9.99));
			queue.writeMessage(new DVD("ON THE SHORES",2015,7.99));
			queue.writeMessage(new DVD("TIDES",2016,7.99));
			queue.writeMessage(new DVD("THE UNDOING",2016,9.99));
			queue.writeMessage(new DVD("HAVE IT ALL",2016,11.99));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
