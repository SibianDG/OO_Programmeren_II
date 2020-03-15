package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import gui.OmgekeerdeZinScherm;

public class StartUp extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        OmgekeerdeZinScherm vb = new OmgekeerdeZinScherm();
// vb is de root node, breedte is 300, hoogte is 275 

        Scene scene = new Scene(vb, 300, 275);
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
