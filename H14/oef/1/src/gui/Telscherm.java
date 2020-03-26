package gui;

import domein.EigenString;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
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
        lblMessage = new Label("Gelieve eerst een zin in te voeren");
        lblMessage.setVisible(false);
        txfInvoer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent evt) {
                try {
                    eigenString = new EigenString(txfInvoer.getText());
                    txaResultaat.appendText(eigenString.telKaraktersVolgensSoort());
                } catch (IllegalArgumentException iae){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Fout");
                    alert.setHeaderText(null);
                    alert.setContentText("Tekst moet ingevuld zijn.");
                    alert.showAndWait();
                }

            }
        });

        this.getChildren().addAll(lblInvoer, txfInvoer, txaResultaat, lblMessage);
    }

}
