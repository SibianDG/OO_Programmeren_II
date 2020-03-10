package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import gui.MenuScherm;

public class StartUp extends Application
{
      
    @Override
    public void start(Stage primaryStage)
    {
        MenuScherm border = new MenuScherm();

        Scene scene = new Scene(border,600,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Menu demo");
        primaryStage.show();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}
