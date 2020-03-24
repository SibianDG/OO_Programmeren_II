package gui;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class LabelScherm extends Pane
{
    public LabelScherm()
    {
//layout via algemene style voor label
        Label lblWelkom = new Label("Welkom bij JavaFX !");
        lblWelkom.setTranslateX(150);
        lblWelkom.setTranslateY(10);
        this.getChildren().add(lblWelkom);
        
//layout via class
        Label lblHoera = new Label("Hoera, ik zie er anders uit!");
        lblHoera.setTranslateX(150);
        lblHoera.setTranslateY(80);
        lblHoera.getStyleClass().add("hoera");
        this.getChildren().add(lblHoera);

//layout via id
        Label lblDerde = new Label("Derde variatie");
        lblDerde.setTranslateX(150);
        lblDerde.setTranslateY(150);
        lblDerde.setId("derde");
        this.getChildren().add(lblDerde);       
    }
}
