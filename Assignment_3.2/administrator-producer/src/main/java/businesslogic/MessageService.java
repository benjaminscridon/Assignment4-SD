package businesslogic;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeoutException;
import communication.RabbitmqCommunication;
import util.SerDes;

/**
 * 
 * @author Beniamin Scridon
 * @since 11/21/2016
 */
public class MessageService {

	private RabbitmqCommunication communication;
	private SerDes serializator;

	public MessageService() throws IOException {
		serializator = new SerDes();
		communication = new RabbitmqCommunication();
	}

	/**
	 * The method will send a message to all rabbitmq queues.
	 * 
	 * @throws IOException
	 * @throws TimeoutException 
	 */
	public void sendMessage(Object object) throws IOException, TimeoutException {
		String message = serializator.toString((Serializable) object);
		communication.sendMessage(message);
	}
}
