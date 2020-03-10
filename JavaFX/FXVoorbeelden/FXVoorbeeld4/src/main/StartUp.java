package main;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import gui.HoofdScherm;

// Dit voorbeeld demonstreert de werking van layout panelen

public class StartUp extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        
        HoofdScherm root = new HoofdScherm();
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Layout Demo's");
        primaryStage.show();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}
