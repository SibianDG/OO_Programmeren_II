 package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import gui.Letter3PermutatiesScherm;

public class StartUp extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        Letter3PermutatiesScherm vb = new Letter3PermutatiesScherm();
// vb is de root node

        Scene scene = new Scene(vb, 400, 500);
        primaryStage.setScene(scene);

        primaryStage.setTitle("MijnString bewerken");
        primaryStage.show();

        primaryStage.setResizable(false);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}

