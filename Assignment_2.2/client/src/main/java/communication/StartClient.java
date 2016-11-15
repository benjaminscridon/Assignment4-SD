package communication;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StartClient extends Application {
	
	public static String RMI_REGISTRY_ADDRESS = "rmi://localhost:1009/";

	@Override
	public void start(Stage primaryStage) throws IOException {
		primaryStage.setTitle("Client Application");
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/car.png")));
		
		BorderPane root = new BorderPane();
		AnchorPane clientView = FXMLLoader.load(getClass().getResource("/view/HomeView.fxml"));
		root.setCenter(clientView);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}