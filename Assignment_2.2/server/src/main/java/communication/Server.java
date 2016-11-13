package communication;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import services.CarService;

public class Server {
	public static void main(String[] args) throws AlreadyBoundException, IOException {
		  Registry registry = LocateRegistry.createRegistry(1009);
          registry.bind("carservice", new CarService());
          System.out.println("Server is running...");
	}
}
