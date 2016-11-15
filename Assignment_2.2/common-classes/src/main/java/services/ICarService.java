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
	
	double computeTax(Car car) throws RemoteException;
	double comuteSellingPrice(Car car) throws RemoteException ;
}
