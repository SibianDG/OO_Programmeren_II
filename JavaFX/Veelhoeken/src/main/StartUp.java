package main;

import domein.DomeinController;
import gui.VeelhoekScherm;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.ConsoleApplicatie;

public class StartUp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {

        DomeinController dc = new DomeinController();
        System.out.println("test");
        VeelhoekScherm vs = new VeelhoekScherm(dc);
        Scene scene = new Scene(vs, 400, 400);

        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setTitle("Welkom");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        /*ConsoleApplicatie consoleApplicatie = new ConsoleApplicatie(new DomeinController());
        consoleApplicatie.startApplicatie(); */
        launch(args);
    }
}
