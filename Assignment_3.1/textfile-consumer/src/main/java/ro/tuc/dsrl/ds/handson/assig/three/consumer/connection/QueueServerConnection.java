package ro.tuc.dsrl.ds.handson.assig.three.consumer.connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import ro.tuc.dsrl.ds.handson.assig.three.queue.communication.Message;

/**
 * @Author: Technical University of Cluj-Napoca, Romania
 *          Distributed Systems, http://dsrl.coned.utcluj.ro/
 * @Module: assignment-one-client
 * @Since: Sep 1, 2015
 * @Description:
 * 	Serves for the connection of the client with the queue server.
 * 	Provides one method which allows for requests to be sent to the server.
 * 	Requests are in form of Message. Please refer to Message class for further details.
 */
public class QueueServerConnection {
	private String host;
	private int port;

	public QueueServerConnection(String host, int port) {
		this.host = host;
		this.port = port;
	}

	/**
	 * Retrieves a message from the queue of the server, by sending a "READ" request to it.
	 * If the queue is empty, this method will hang until the queue will get a message. In
	 * other words, this method will wait for the server to provide a message.
	 *
	 * @return the message from the queue, sent by the server
	 * @throws IOException thrown if there is a problem with the connection
	 */
	public String readMessage() throws IOException {
		Socket clientSocket = new Socket(host, port);
		ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
		ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());
		outToServer.writeObject(new Message("READ-FROM-FILE_CONSUMER_Q",null));

		Message response;
		try {
			response = (Message)inFromServer.readObject();
		} catch (ClassNotFoundException e) {
			response = null;
			e.printStackTrace();
		}

		outToServer.close();
		inFromServer.close();
		clientSocket.close();

		if (response==null || !response.getType().equals("ACK")) return null;

		return response.getContent();
	}
}