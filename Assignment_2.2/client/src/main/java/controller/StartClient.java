package controller;

import java.rmi.Naming;

import entities.Car;
import services.ICarService;

public class StartClient {
	private StartClient() {

	}
	// extends Application
	// {
	/*
	 * @Override public void start(Stage primaryStage) { try { BorderPane root =
	 * new BorderPane(); Scene scene = new Scene(root,400,400);
	 * //scene.getStylesheets().add(getClass().getResource("application.css").
	 * toExternalForm()); primaryStage.setScene(scene); primaryStage.show(); }
	 * catch(Exception e) { e.printStackTrace(); } }
	 * 
	 * public static void main(String[] args) { launch(args); }
	 */

	public static void main(String[] args) {

		try {
			ICarService carService = (ICarService) Naming.lookup("rmi://localhost:1009/carservice");
			Car car = new Car(2015, 2000, 8000);
			System.out.println(carService.computeTax(car));
			System.out.println(carService.comuteSellingPrice(car));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}