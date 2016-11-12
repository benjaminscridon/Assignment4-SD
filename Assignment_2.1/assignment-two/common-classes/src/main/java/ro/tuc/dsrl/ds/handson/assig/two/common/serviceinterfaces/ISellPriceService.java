package ro.tuc.dsrl.ds.handson.assig.two.common.serviceinterfaces;

import ro.tuc.dsrl.ds.handson.assig.two.common.entities.Car;

/**
 * 
 * @author Beniamin Scridon
 * @since 11/12/2016
 */
public interface ISellPriceService {
	/**
	 * Computes the selling price of the Car.
	 *
	 * @param c Car for which to compute selling price
	 * @return selling price for the car
	 */
	double comuteSellingPrice(Car c);
}
