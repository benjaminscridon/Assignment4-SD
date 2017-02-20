package ro.utcluj.sd.ass4.net.service.login;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws RemoteException {
		//PackageModel[] packages = null;
		//ClientServiceSoapProxy clientService = new ClientServiceSoapProxy();

		/*try {
			packages = clientService.getAllPackagesByUserEmail("russ");
		} catch (Exception e) {
			System.out.println("error");
		}
		System.out.println(packages[0].getName());*/
		UserModel u  = new LoginServiceSoapProxy().getUser("russ", "pas");
		
		System.out.println(u.getEmail());
	}

}