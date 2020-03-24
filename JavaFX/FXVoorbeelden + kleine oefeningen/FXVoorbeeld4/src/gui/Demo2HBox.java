package gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class Demo2HBox extends Stage
{
// Deze tweede demo van de HBox toont de werking van 
//springs om componenten uit elkaar te duwen
    
    public Demo2HBox()
    {
        HBox box = new HBox();
        box.setPadding(new Insets(10));
        box.setSpacing(10);

        Button btnDelete = new Button("Delete");
        Button btnCancel = new Button("Cancel");
        Button btnOk = new Button("OK");

// Door het aanmaken van een Region (lege component) en het instellen van de Hgrow
// op ALWAYS, zal deze spring (veer) de andere componenten uit elkaar lijken te duwen
        Region spring = new Region();
        HBox.setHgrow(spring, Priority.ALWAYS);

        box.getChildren().addAll(btnDelete, spring, btnCancel, btnOk);

        Scene scene = new Scene(box);
        this.setScene(scene);
        
    }
}
