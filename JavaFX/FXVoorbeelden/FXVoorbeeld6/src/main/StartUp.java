package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import domein.TipCalculator;        //vervult de functie van domeinController
import gui.TipCalculatorScherm;

public class StartUp extends Application
{
// De methode start zet nu enkel de Scene en Stage op 
// De methode start maakt ook de domeincontroller aan en 
// geeft deze door aan het TipCalculatorScherm (ons hoofdpaneel root)  
    @Override
    public void start(Stage primaryStage) 
    {
        TipCalculator dc = new TipCalculator();
        TipCalculatorScherm root = new TipCalculatorScherm(dc);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TipCalculator");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
