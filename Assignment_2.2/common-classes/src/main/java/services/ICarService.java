package services;

import java.rmi.Remote;
import java.rmi.RemoteException;
import entities.Car;

/**
 * 
 * @author Beniamin
 *
 */
public interface ICarService extends Remote {

	double computeTax(Car c) throws RemoteException;
	double comuteSellingPrice(Car c) throws RemoteException ;
	
}
