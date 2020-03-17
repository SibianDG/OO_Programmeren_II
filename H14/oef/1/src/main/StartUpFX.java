package main;

import gui.Telscherm;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

class StartUp extends Application
{
    @Override
    public void start(Stage primaryStage)
    {

        Telscherm root = new Telscherm();

        Scene scene = new Scene(root, 500, 200);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Eigenstring tellen");
        primaryStage.show();

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}

