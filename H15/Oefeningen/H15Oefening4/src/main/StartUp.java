package main;
import domein.DomeinController;
import gui.VerbouwingScherm;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartUp extends Application
{
    
    @Override
    public void start(Stage primaryStage)
    {
        VerbouwingScherm vs = new VerbouwingScherm(new DomeinController());
        
        Scene scene = new Scene(vs, 400, 300);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Verbouwen is fun!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
