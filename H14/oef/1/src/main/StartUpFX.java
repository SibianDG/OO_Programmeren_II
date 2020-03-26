package main;

import gui.Telscherm;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class StartUpFX extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        Telscherm vb = new Telscherm();
// vb is de root node, breedte is 300, hoogte is 275

        Scene scene = new Scene(vb, 300, 275);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Tellen van de zin");
        primaryStage.show();

        primaryStage.setResizable(false);

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
