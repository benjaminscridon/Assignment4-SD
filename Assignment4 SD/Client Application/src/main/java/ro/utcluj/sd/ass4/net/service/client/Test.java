package ro.utcluj.sd.ass4.net.service.client;

import java.rmi.RemoteException;

public class Test {

	public static void main(String[] args) throws RemoteException {
		ClientServiceSoapProxy cp = new ClientServiceSoapProxy();
		
		PackageModel[] pkgs = cp.getAllPackagesByUserEmail("russ");
		
		System.out.println(pkgs);

	}

}
