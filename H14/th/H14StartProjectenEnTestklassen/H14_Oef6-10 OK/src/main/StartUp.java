package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import gui.WartaalScherm;

public class StartUp extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        WartaalScherm grid = new WartaalScherm();
// grid is de root node

        Scene scene = new Scene(grid, 300, 250);
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

