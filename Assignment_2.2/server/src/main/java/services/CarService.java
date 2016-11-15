package services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.DecimalFormat;
import java.util.Calendar;

import entities.Car;

/**
 * 
 * @author Beniamin
 *
 */
public class CarService extends UnicastRemoteObject implements ICarService {

	private static final long serialVersionUID = 1L;

	public CarService() throws RemoteException {
		super();
	}

	public double computeTax(Car c) throws RemoteException {
		if (c.getEngineSize() <= 0) {
			throw new IllegalArgumentException("Engine capacity must be positive.");
		}
		int sum = 8;
		if (c.getEngineSize() > 1601)
			sum = 18;
		if (c.getEngineSize() > 2001)
			sum = 72;
		if (c.getEngineSize() > 2601)
			sum = 144;
		if (c.getEngineSize() > 3001)
			sum = 290;
		
		DecimalFormat df = new DecimalFormat("#.##");
		return Double.valueOf(df.format(c.getEngineSize() / 200.0 * sum));
	}

	public double comuteSellingPrice(Car car) throws IllegalArgumentException {
		if (car.getPrice() <= 0) {
			throw new IllegalArgumentException("The price of the car must be positive.");
		} else if (car.getYear() <= 1800) {
			throw new IllegalArgumentException("The year of the car must be greater than 1800 :D.");
		}

		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		double sellingPrice = car.getPrice() - (car.getPrice() / 7) * (currentYear - car.getYear());
		DecimalFormat df = new DecimalFormat("#.##");

		return Double.valueOf(df.format(sellingPrice));
	}
}
