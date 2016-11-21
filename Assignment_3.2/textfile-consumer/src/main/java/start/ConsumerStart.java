package start;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import communication.RabbitmqCommunication;

/**
 * 
 * @author Beniamin Scridon
 * @since 11/21/2016
 */
public class ConsumerStart {

	public static void main(String[] args) throws IOException, TimeoutException {
		new RabbitmqCommunication().consumeMessages();
	}
}
