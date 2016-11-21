package communication;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import util.ReadPropertyFile;

/**
 * 
 * @author Beniamin Scridon
 * @since 11/21/2016
 */
public class RabbitmqCommunication {

	private ReadPropertyFile readPropertyFile;

	public RabbitmqCommunication() throws IOException {
		readPropertyFile = new ReadPropertyFile();
	}

	public void sendMessage(String message) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(readPropertyFile.getProperty("host"));

		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.basicPublish(readPropertyFile.getProperty("rabbitmq-exchange"), "", null, message.getBytes());
		System.out.println("-> Message Sent.");

		channel.close();
		connection.close();
	}
}
