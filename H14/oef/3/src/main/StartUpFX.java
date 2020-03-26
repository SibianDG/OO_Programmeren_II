package main;

import domein.Login;
import gui.RegistratieScherm;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartUpFX extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        Login login = new Login();
        RegistratieScherm vb = new RegistratieScherm(login);
// vb is de root node, breedte is 300, hoogte is 275

        Scene scene = new Scene(vb, 300, 275);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Registratie");
        primaryStage.show();

        primaryStage.setResizable(false);

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
