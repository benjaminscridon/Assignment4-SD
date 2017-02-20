package ro.utcluj.sd.assignment4.service;

import ro.utcluj.sd.assignment4.dto.PackageDTO;
import ro.utcluj.sd.assignment4.dto.UserDTO;

public class TestMain {
	public static void main(String[] args){
		PackageServiceBean p = new PackageServiceBean();
		UserDTO sender = new UserDTO();
		sender.setEmail("russ");
		sender.setFirstName("dasd");
		sender.setLastName("dasd");
		sender.setPassword("123456");
		
		UserDTO receiver = new UserDTO();
		receiver.setEmail("dasddddddaaad");
		receiver.setPassword("123456");

		PackageDTO pack = new PackageDTO();
		pack.setDescription("pppp");
		pack.setDestinationCity("pppp");
		pack.setName("pppp");
		pack.setReceiver(receiver);
		pack.setTacking(false);
		pack.setSenderCity("pppp");
		pack.setSender(sender);
		
		p.addPackage(pack);
	}
}
