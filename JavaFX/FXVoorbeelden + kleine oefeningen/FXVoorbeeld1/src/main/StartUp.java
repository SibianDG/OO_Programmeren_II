package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import gui.WelkomScherm;

// De hoofdklasse moet een subklasse van Application zijn
// Er is reeds code om het programma op te starten en een venster te maken 
public class StartUp extends Application
{

// We moeten de methode start overriden   
// Bij de methode start begint de uitvoering van de applicatie
// Een eerste Stage (het hoofdvenster) wordt meegegeven als argument
    @Override
    public void start(Stage primaryStage)
    {
        WelkomScherm root = new WelkomScherm();
        // We maken een Scene op basis van het hoofdpaneel en een gewenste grootte
        Scene scene = new Scene(root, 500, 300);

// We koppelen de Scene aan de Stage (het venster).        
        primaryStage.setScene(scene);

// We geven een titel aan het venster en tonen we het op het scherm.   
        primaryStage.setTitle("Welkom bij JavaFX");
        primaryStage.show();

    }

// In de methode main starten we onze Application op.
    public static void main(String[] args)
    {
        launch(args);
    }
}
