package ro.tuc.dsrl.ds.handson.assig.two.server.services;

import java.text.DecimalFormat;
import java.util.Calendar;

import ro.tuc.dsrl.ds.handson.assig.two.common.entities.Car;
import ro.tuc.dsrl.ds.handson.assig.two.common.serviceinterfaces.ISellPriceService;

/**
 * 
 * @author Beniamin
 *
 */
public class SellPriceService implements ISellPriceService {

	@Override
	public double comuteSellingPrice(Car car) {
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
