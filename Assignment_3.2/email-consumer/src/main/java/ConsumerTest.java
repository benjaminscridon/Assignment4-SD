import java.io.IOException;

import com.rabbitmq.client.*;

import entities.DVD;

public class ConsumerTest {
	private static final String EXCHANGE_NAME = "dvds_exchange";
	private static final String HOST = "localhost";

	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(HOST);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		//channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
		//String queueName = channel.queueDeclare().getQueue();
		channel.queueBind("email", EXCHANGE_NAME, "");

		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				try {
					DVD dvd = (DVD) new Snippet().fromString(message);
					System.out.println(dvd.getTitle());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(" [x] Received '" + message + "'");
			}
		};
		channel.basicConsume("email", true, consumer);
	}
}
