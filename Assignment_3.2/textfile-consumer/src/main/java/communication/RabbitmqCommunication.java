package communication;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import com.rabbitmq.client.*;
import entities.DVD;
import service.TextFileService;
import util.ReadPropertyFile;
import util.SerDes;

/**
 * 
 * @author Beniamin Scridon
 * @since 11/21/2016
 */
public class RabbitmqCommunication {

	private Channel channel;
	private ReadPropertyFile readPropertyFile;

	public RabbitmqCommunication() throws IOException, TimeoutException {
		readPropertyFile = new ReadPropertyFile();

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(readPropertyFile.getProperty("host"));

		Connection connection = factory.newConnection();
		channel = connection.createChannel();
	}

	public void consumeMessages() throws IOException {
		System.out.println("-> Waiting for messages.");
		channel.basicConsume(readPropertyFile.getProperty("queue"), true, getConsumer());
	}

	private Consumer getConsumer() {
		return new DefaultConsumer(channel) {
			private TextFileService fileService = new TextFileService();

			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println("[x] Received '" + "'" + message + ".");

				DVD dvd = null;
				try {
					dvd = (DVD) new SerDes().fromString(new String(body, "UTF-8"));
					fileService.writeFile(dvd);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
	}
}
