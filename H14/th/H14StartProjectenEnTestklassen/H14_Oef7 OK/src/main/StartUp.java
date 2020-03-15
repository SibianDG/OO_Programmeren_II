package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import gui.UnicodeScherm;

public class StartUp extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        UnicodeScherm root = new UnicodeScherm();
// root is de root node

        Scene scene = new Scene(root, 500, 200);
        primaryStage.setScene(scene);

        primaryStage.setTitle("MijnString bewerken");
        primaryStage.show();

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}

