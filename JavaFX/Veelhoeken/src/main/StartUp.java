package main;

import domein.DomeinController;
import gui.VeelhoekScherm;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartUp extends Application {

    @Override
    public void start(Stage primaryStage)
    {

        DomeinController dc = new DomeinController();
        VeelhoekScherm root = new VeelhoekScherm(dc);
        Scene scene = new Scene(root, 400, 400);
        scene.getStylesheets().add("style.css");

        primaryStage.setTitle("Veelhoekapplicatie");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
