import java.rmi.RemoteException;

import ro.utcluj.sd.ass4.java.PackageDTO;
import ro.utcluj.sd.ass4.java.PackageServiceBeanProxy;

public class TstMAin {

	public static void main(String[] args) throws RemoteException {
		PackageServiceBeanProxy p = new PackageServiceBeanProxy();
		PackageDTO[] ps = p.getAllPackages();
		System.out.println(ps.length);
		ps = p.getPackagesByNameOrId("cuie", 1);

	}

}
