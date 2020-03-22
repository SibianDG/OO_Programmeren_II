package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import gui.SplitsOpScherm;

public class StartUp extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        SplitsOpScherm grid = new SplitsOpScherm();
// grid is de root node 

        Scene scene = new Scene(grid, 300, 250);
        primaryStage.setScene(scene);

        primaryStage.setTitle("MijnString bewerken");
        primaryStage.show();

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}

