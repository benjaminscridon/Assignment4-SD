package communication;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.concurrent.TimeoutException;
import com.rabbitmq.client.*;
import entities.DVD;
import service.MailService;
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
			
			private BufferedReader br;
			private MailService mailService = new MailService(readPropertyFile);

			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println("[x] Received '" + "'" + message + ".");

				DVD dvd = null;
				String subscriber;
				try {
					dvd = (DVD) new SerDes().fromString(new String(body, "UTF-8"));

					InputStream file = new FileInputStream("src/main/resources/subscribers.txt");
					InputStreamReader reader = new InputStreamReader(file, Charset.forName("UTF-8"));
					br = new BufferedReader(reader);

					while ((subscriber = br.readLine()) != null) {
						mailService.sendMail(subscriber, "New album release", dvd.toString());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
	}
}
