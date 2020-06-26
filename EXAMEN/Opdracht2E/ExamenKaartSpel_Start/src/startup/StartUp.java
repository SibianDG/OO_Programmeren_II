package startup;
	
import domein.DomeinController;
import gui.FilterKeuzeScherm;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class StartUp extends Application 
{
	@Override
	public void start(Stage primaryStage) 
	{
		DomeinController dc = new DomeinController();

        FilterKeuzeScherm root = new FilterKeuzeScherm(dc);
        Scene scene = new Scene(root, 600, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Selecteer filer");
        primaryStage.show();
		//open het startscherm FitlerKeuzeScherm, 
		//600 pixels breed, 200 pixels hoog
		
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
