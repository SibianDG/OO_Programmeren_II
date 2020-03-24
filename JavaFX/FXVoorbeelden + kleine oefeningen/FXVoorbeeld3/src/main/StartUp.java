package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import gui.LabelScherm;

public class StartUp extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        LabelScherm root = new LabelScherm();
        Scene scene = new Scene(root, 500, 250, Color.BLACK);

        scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());  
        primaryStage.setTitle("Welkom");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
