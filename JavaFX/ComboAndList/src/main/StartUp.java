package main;


import gui.ComboAndListController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartUp extends Application {

    @Override
    public void start(Stage primaryStage)
    {
        ComboAndListController comboAndList = new ComboAndListController();
        Scene scene = new Scene(comboAndList);

        primaryStage.setTitle("Combo and List");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(300);
        primaryStage.show();
    }
    public static void main(String[] args)
    {
        launch(args);
    }

}