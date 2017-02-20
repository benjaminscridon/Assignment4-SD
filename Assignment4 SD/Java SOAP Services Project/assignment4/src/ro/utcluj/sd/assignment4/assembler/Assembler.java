package ro.utcluj.sd.assignment4.assembler;

import java.util.ArrayList;
import java.util.List;

import ro.utcluj.sd.assignment4.dto.PackageDTO;
import ro.utcluj.sd.assignment4.dto.UserDTO;
import ro.utcluj.sd.assignment4.entities.Package;
import ro.utcluj.sd.assignment4.entities.RouteItem;
import ro.utcluj.sd.assignment4.entities.User;
import ro.utcluj.sd.assignment4.entities.UserType;

public class Assembler {
	public static PackageDTO packageToDTO(Package p) {
		PackageDTO dto = new PackageDTO();
		dto.setId(p.getId());
		dto.setDescription(p.getDescription());
		dto.setDestinationCity(p.getDestinationCity());
		dto.setName(p.getName());
		dto.setReceiver(Assembler.userToDTO(p.getReceiver()));
		dto.setSender(Assembler.userToDTO(p.getSender()));
		dto.setSenderCity(p.getSenderCity());
		dto.setTacking(p.isTacking());

		RouteItem[] ris = new RouteItem[p.getRoute().size()];
		if (p.getRoute() != null) {
			for (int i = 0; i < p.getRoute().size(); i++) {
				ris[i] = p.getRoute().get(i);
			}
		}
		dto.setRoute(ris);
		return dto;
	}

	public static Package dTOToPackage(PackageDTO p) {
		Package dto = new Package();
		dto.setId(p.getId());
		dto.setDescription(p.getDescription());
		dto.setDestinationCity(p.getDestinationCity());
		dto.setName(p.getName());
		dto.setReceiver(Assembler.dTOToUser(p.getReceiver()));
		dto.setSender(Assembler.dTOToUser(p.getSender()));
		dto.setSenderCity(p.getSenderCity());
		dto.setTacking(p.isTacking());

		List<RouteItem> ris = new ArrayList<>();
		if (p.getRoute() != null) {
			for (int i = 0; i < p.getRoute().length; i++) {
				ris.add(p.getRoute()[i]);
			}
		}
		dto.setRoute(ris);
		return dto;
	}

	public static UserDTO userToDTO(User u) {
		UserDTO dto = new UserDTO();
		dto.setId(u.getId());
		dto.setEmail(u.getEmail());
		dto.setFirstName(u.getFirstName());
		dto.setLastName(u.getLastName());
		dto.setPassword(u.getPassword());
		if (u.getUserType().equals(UserType.ADMIN)) {
			dto.setUserType(1);
		} else {
			dto.setUserType(0);
		}
		return dto;
	}

	public static User dTOToUser(UserDTO u) {
		User dto = new User();
		dto.setId(u.getId());
		dto.setEmail(u.getEmail());
		dto.setFirstName(u.getFirstName());
		dto.setLastName(u.getLastName());
		dto.setPassword(u.getPassword());
		if (u.getUserType() == 1) {
			dto.setUserType(UserType.ADMIN);
		} else {
			dto.setUserType(UserType.USER);
		}
		return dto;
	}
}
