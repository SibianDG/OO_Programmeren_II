package main;
	
import domein.TipCalculator;
import gui.TipCalculatorSchermController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception{

		TipCalculator dc = new TipCalculator();
		Scene scene = new Scene(new TipCalculatorSchermController(dc));
		primaryStage.setScene(scene);
		primaryStage.setTitle("TipCalculator");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
