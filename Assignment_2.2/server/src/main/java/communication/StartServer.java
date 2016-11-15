package communication;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import services.CarService;

/**
 * 
 * @author Beniamin Scridon
 *
 */
public class StartServer {
	public static int RMI_REGISTRY_PORT_NUMBER = 1009;

	public static void main(String[] args) throws AlreadyBoundException, IOException {
		Registry registry = LocateRegistry.createRegistry(RMI_REGISTRY_PORT_NUMBER);
		registry.bind("carservice", new CarService());
		System.out.println("Server is running...");
	}
}
