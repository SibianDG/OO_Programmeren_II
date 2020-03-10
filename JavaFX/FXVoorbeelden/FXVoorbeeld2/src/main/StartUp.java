package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import gui.LoginScherm;

public class StartUp extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        LoginScherm grid = new LoginScherm();
// grid is de root node, breedte is 300, hoogte is 275 

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);

        primaryStage.setTitle("JavaFX Welcome");
        primaryStage.show();

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}

