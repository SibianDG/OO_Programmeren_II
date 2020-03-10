package main;

import gui.DemoEventScherm;
import gui.DemoEventSchermMetAnoniemeInnerKlassen;
import gui.DemoEventSchermMetBenoemdeInnerKlasse;
import gui2.DemoEventSchermControleSource;
import gui2.DemoEventSchermControleSourceZonderKopie;
import gui2.DemoEventSchermMetStop;
import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class StartUp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        //1. klasse scherm één klasse die eventhandler-interface implementeert
         //DemoEventScherm root = new DemoEventScherm();
        
        //2. klasse scherm met daarin benoemde innerklasse
        //DemoEventSchermMetBenoemdeInnerKlasse root = new DemoEventSchermMetBenoemdeInnerKlasse();
        
        //3. klasse scherm met anonieme innerklasse
        //DemoEventSchermMetAnoniemeInnerKlassen root = new DemoEventSchermMetAnoniemeInnerKlassen();
        
        //4. 
        //DemoEventSchermControleSource root = new DemoEventSchermControleSource();
        
        
        //5.
        //DemoEventSchermControleSourceZonderKopie root = new DemoEventSchermControleSourceZonderKopie();
        
        //6.
       DemoEventSchermMetStop root = new DemoEventSchermMetStop();
        
        Scene scene = new Scene(root,300,300);
        scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Eventafhandeling");
        primaryStage.show();
// hoort bij 3. versie 1  
//        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() 
//        {
//            @Override
//            public void handle(WindowEvent event)
//            {
//                System.out.println("We sluiten het venster en dus... ook de applicatie");
// hoort bij 3. versie 2               
//                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//                alert.setTitle("Bevestig");
//                alert.setContentText("Wil je de applicatie afsluiten?");
//                Optional<ButtonType> result = alert.showAndWait();
//                if (result.get() == ButtonType.OK)
//                {
//                    System.out.println("We sluiten het venster en dus... ook de applicatie");
//                 //   Platform.exit();
//                } else // Cancel
//                {
//                   event.consume();
//                }
//             
//            }
//        }
//        );
    }
    
     public static void main(String[] args)
    {
        launch(args);
    }
}
