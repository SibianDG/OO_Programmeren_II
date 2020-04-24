package main;

import domein.DomeinController;
import gui.InvulSchermController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartUp extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        DomeinController dc=new DomeinController();
        InvulSchermController scherm=new InvulSchermController(dc);
        
        Scene scene=new Scene(scherm);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
