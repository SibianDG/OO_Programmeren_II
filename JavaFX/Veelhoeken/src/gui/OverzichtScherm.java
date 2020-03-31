package gui;

import domein.DomeinController;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class OverzichtScherm extends VBox {
    private DomeinController dc;
    private TextArea txaOverzicht;

    public OverzichtScherm(DomeinController dc) {
        this.dc = dc;
        buildGui();
    }

    private void buildGui(){
        Label lblTitel = new Label("Overzicht veelhoeken");
        lblTitel.getStyleClass().add("titel");
        txaOverzicht = new TextArea(dc.geefVeelhoeken());
        this.getChildren().addAll(lblTitel, txaOverzicht);
    }

    protected void update(){
        txaOverzicht.setText(dc.geefVeelhoeken());
    }
}
