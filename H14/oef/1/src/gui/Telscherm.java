package gui;

import domein.EigenString;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Telscherm extends VBox
{
    private EigenString eigenString;
    private Label lblInvoer;
    private TextField txfTekst;
    private TextArea txaResultaat;

    public Telscherm()
    {
        this.setAlignment(Pos.CENTER_LEFT);
        this.setSpacing(10);
        this.setPadding(new Insets(25, 25, 25, 25));

        lblInvoer = new Label("Geef een zin in en druk op \"Enter\": ");
        txfTekst = new TextField();
        txaResultaat = new TextArea();
        txaResultaat.setText(new EigenString(txfTekst.getText()).telKaraktersVolgensSoort());

        this.getChildren().addAll(lblInvoer, txfTekst,txaResultaat);

    }

    private void reset()
    {
        txfTekst.setText("");
        txaResultaat.setText("");
    }
}
