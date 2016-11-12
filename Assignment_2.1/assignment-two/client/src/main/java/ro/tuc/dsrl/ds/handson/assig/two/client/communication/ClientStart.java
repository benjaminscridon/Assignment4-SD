package ro.tuc.dsrl.ds.handson.assig.two.client.communication;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import ro.tuc.dsrl.ds.handson.assig.two.common.entities.Car;
import ro.tuc.dsrl.ds.handson.assig.two.common.serviceinterfaces.ISellPriceService;
import ro.tuc.dsrl.ds.handson.assig.two.common.serviceinterfaces.ITaxService;
import ro.tuc.dsrl.ds.handson.assig.two.rpc.Naming;

import java.io.IOException;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems,
 *          http://dsrl.coned.utcluj.ro/
 * @Module: assignment-two-client
 * @Since: Sep 24, 2015
 * @Description: Starting point of the Client application.
 */
public class ClientStart {
	private static final Log LOGGER = LogFactory.getLog(ClientStart.class);

	private ClientStart() {
	}

	public static void main(String[] args) throws IOException {
		ITaxService taxService = null;
		ISellPriceService sellPriceService = null;
		try {
			taxService = Naming.lookup(ITaxService.class, ServerConnection.getInstance());

			System.out.println("Tax value: " + taxService.computeTax(new Car(2009, 2000)));
			// System.out.println(taxService.computeTax(new Car(2009, -100)));

			sellPriceService = Naming.lookup(ISellPriceService.class, ServerConnection.getInstance());
			Car car = new Car(2015, 2000, 8000);
			System.out.println("Selling price for car (" + car.toString() + ") is "
					+ sellPriceService.comuteSellingPrice(car) + "(€)");

			ServerConnection.getInstance().closeAll();

		} catch (Exception e) {
			LOGGER.error("", e);
			ServerConnection.getInstance().closeAll();
		}
	}
}
