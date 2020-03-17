package gui;

import domein.EigenString;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Telscherm extends VBox
{
    private EigenString eigenString;
    private Label lblMessage,lblInvoer;
    private TextField txfInvoer;
    private TextArea txaResultaat;

    public Telscherm()
    {
        this.setAlignment(Pos.CENTER_LEFT);
        this.setSpacing(10);
        this.setPadding(new Insets(25, 25, 25, 25));

        lblInvoer = new Label("Geef een zin in en druk op \"Enter\": ");
        txfInvoer = new TextField();
        txaResultaat = new TextArea();

        //todo
        //eigenString.setTekst(txfInvoer.getText());
        //txaResultaat.setText(eigenString.telKaraktersVolgensSoort());

        this.getChildren().addAll(lblInvoer, txfInvoer, txaResultaat);

        lblMessage = new Label("Gelieve eerst een zin in te voeren");
        lblMessage.setVisible(false);
        this.getChildren().add(lblMessage);
    }

}
