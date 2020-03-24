package main;

import gui.LoginSchermController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class StartUp extends Application 
{
	@Override
	public void start(Stage primaryStage) 
	{
		try {
			LoginSchermController root = new LoginSchermController();
			Scene scene = new Scene(root,300,275);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
