package main;

import gui.LoginScherm2Controller;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class StartUp extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		try {
			LoginScherm2Controller root = new LoginScherm2Controller();
			Scene scene = new Scene(root,300,275);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Login");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
