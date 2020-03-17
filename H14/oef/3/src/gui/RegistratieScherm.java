package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class RegistratieScherm extends VBox
{
    private Label lblMessage,lblGebruikersnaam, lblWachtwoord, lblWachtwoord2;
    private TextField txfGebruikersnaam,txfWachtwoord, txfWachtwoord2;

    public RegistratieScherm()
    {
        this.setAlignment(Pos.CENTER_LEFT);
        this.setSpacing(10);
        this.setPadding(new Insets(25, 25, 25, 25));

        lblGebruikersnaam = new Label("Gebruikersnaam: ");
        txfGebruikersnaam = new TextField();
        lblWachtwoord = new Label("Wachtwoord: ");
        txfWachtwoord = new TextField();
        lblWachtwoord2 = new Label("Bevestig wachtwoord: ");
        txfWachtwoord2 = new TextField();

        this.getChildren().addAll(lblGebruikersnaam, txfGebruikersnaam, lblWachtwoord, txfWachtwoord, lblWachtwoord2, txfWachtwoord2);

        lblMessage = new Label("Gelieve eerst een zin in te voeren");
        lblMessage.setVisible(false);
        this.getChildren().add(lblMessage);

    }
    private void txfGebruikersnaamAction(ActionEvent event){

    }

    private void txfWachtwoordAction(ActionEvent event){

    }

    private void txfWachtwoord2Action(ActionEvent event){

    }

    private void buildGui(){

    }
}
