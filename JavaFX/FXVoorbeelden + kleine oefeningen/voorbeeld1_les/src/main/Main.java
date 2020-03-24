package main;
	
import gui.WelkomScherm;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
	        WelkomScherm root = new WelkomScherm();
	        // We maken een Scene op basis van het hoofdpaneel en een gewenste grootte
	        Scene scene = new Scene(root, 500, 300);

			// We koppelen de Scene aan de Stage (het venster).        
			primaryStage.setScene(scene);
		
			// We geven een titel aan het venster en tonen we het op het scherm.   
	        primaryStage.setTitle("Welkom bij JavaFX");
	        primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
