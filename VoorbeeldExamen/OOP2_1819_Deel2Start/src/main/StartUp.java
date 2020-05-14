package main;

import domein.DomeinController;
import gui.BonusCodeSchermController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class StartUp extends Application
{
    
    @Override
    public void start(Stage primaryStage) 
    {
       BonusCodeSchermController root = new BonusCodeSchermController(new DomeinController());
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("BonusCodeScherm");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        launch(args);
    }
    
}
