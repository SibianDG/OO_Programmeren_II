package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import gui.HoofdPaneel;
import domein.DomeinController;

public class StartUp extends Application
{
    @Override
    public void start(Stage stage)
    {
        DomeinController controller = new DomeinController();
        HoofdPaneel root = new HoofdPaneel(controller);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Rekeningen");
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
