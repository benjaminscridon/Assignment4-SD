package controller;

import java.net.URL;
import java.rmi.Naming;
import java.util.ResourceBundle;
import communication.StartClient;
import entities.Car;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.ICarService;

/**
 * 
 * @author Beniamin Scridon
 *
 */
public class HomeController implements Initializable {

	@FXML
	private TextField yearField;
	@FXML
	private TextField engineSizeField;
	@FXML
	private TextField purchasingPriceField;
	@FXML
	private Label info;

	private ICarService carService;

	

	@FXML
	public void computeTax() {
		try {
			Car car = buildCar();
			if (null != car) {
				info.setText("Tax is " + getCarService().computeTax(car) + "(€).");
			}
		} catch (Exception e) {
			info.setText("Cannot compute tax of the car.");
		} 
	}

	@FXML
	public void computeSellingPrice() {
		try {
			Car car = buildCar();
			if (null != car) {
				info.setText("Selling price is " + getCarService().comuteSellingPrice(car) + "(€).");
			}
		} catch(IllegalArgumentException ex){
			info.setText("Invalid year.");
		} catch (Exception e) {
			info.setText("Cannot compute tax of the car.");
		}
	}

	private ICarService getCarService() {
		if(null == carService){
			try {
				carService = (ICarService) Naming.lookup(StartClient.RMI_REGISTRY_ADDRESS + "carservice");
			} catch (Exception e) {
				info.setText("Cannot identify the remote object.Check if the server is online.");
			}
		}
		return carService;
	}
	
	private Car buildCar() {
		try {
			int year = Integer.parseInt(yearField.getText());
			int engineSize = Integer.parseInt(engineSizeField.getText());
			double purchasingPrice = Double.parseDouble(purchasingPriceField.getText());

			return new Car(year, engineSize, purchasingPrice);
		} catch (java.lang.NumberFormatException ex) {
			info.setText("Invalid data.Please try again.");
			return null;
		}
	}
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}
