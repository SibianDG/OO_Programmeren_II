package main;

import domein.DomeinController;
import gui.DierenScherm;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartUp2 extends Application {

    @Override
    public void start(Stage primaryStage)
    {
        DierenScherm ds = new DierenScherm(new DomeinController());
        Scene scene = new Scene(ds);

        scene.getStylesheets().add("style.css");

        primaryStage.setTitle("Katten en honden");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(primaryStage.getWidth());
        primaryStage.setMinHeight(primaryStage.getHeight());
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
