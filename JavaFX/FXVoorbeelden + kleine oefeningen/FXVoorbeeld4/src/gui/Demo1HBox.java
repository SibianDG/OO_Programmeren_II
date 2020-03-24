package gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class Demo1HBox extends Stage
{
// Een HBox is een paneel dat zijn componenten horizontaal naast elkaar plaatst
// De eerste demo toont de werking van een HBox 
    public Demo1HBox()
    {
        HBox box = new HBox();

// Dit zorgt voor witruimte tussen de rand van het venster en de box
// Boven, rechts, onder en links krijgen allemaal dezelfde waarde 10
        box.setPadding(new Insets(10));

// Dit zorgt voor witruimte tussen de componenten in de box
        box.setSpacing(10);

        Label lblTitle = new Label("Title:");
        TextField txfTitle = new TextField();
        Button btnOk = new Button("OK");

// Door het instellen van de Hgrow op ALWAYS zal het txfTitle alle overgebleven ruimte opnemen
// Naast ALWAYS zijn er ook nog SOMETIMES (enkel als de componenten met ALWAYS niet alle ruimte
// nodig hadden) en NEVER (krijgt nooit extra ruimte toegewezen)
        HBox.setHgrow(txfTitle, Priority.ALWAYS);
// Merk op dat het configureren van de layout van een component gebeurt a.h.v. statische hulpmethoden
// uit de klasse van het paneel waarover het gaat (hier HBox)

        box.getChildren().addAll(lblTitle, txfTitle, btnOk);
        Scene scene = new Scene(box);
        this.setScene(scene);

    }
}
