package gui;

import domein.Login;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class RegistratieScherm extends VBox
{
    private Label lblMessage,lblGebruikersnaam, lblWachtwoord, lblWachtwoord2;
    private TextField txfGebruikersnaam,txfWachtwoord, txfWachtwoord2;
    private Login login;

    public RegistratieScherm(Login login)
    {
        this.login = login;
        buildGui();
    }


    private void txfGebruikersnaamAction(ActionEvent event)
    {
        try
        {
            login.setGebruikersnaam(txfGebruikersnaam.getText());
            txfWachtwoord.requestFocus();
        }
        catch (IllegalArgumentException iae)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fout");
            alert.setHeaderText(null);
            alert.setContentText(iae.getMessage());
            alert.showAndWait();
            txfGebruikersnaam.selectAll();
        }
    }
    private void txfWachtwoordAction(ActionEvent event)
    {
        try
        {
            login.setWachtwoord(txfWachtwoord.getText());
            txfWachtwoord2.requestFocus();
        }
        catch (IllegalArgumentException iae)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fout");
            alert.setHeaderText(null);
            alert.setContentText(iae.getMessage());
            alert.showAndWait();
            txfWachtwoord.selectAll();
        }
    }
    private void txfWachtwoord2Action(ActionEvent event)
    {
        try
        {
            String invoer = txfWachtwoord2.getText();
            if (invoer == null || invoer.isEmpty())
                throw new IllegalArgumentException("Gelieve het wachtwoord te bevestigen");
            if (!invoer.equals(login.getWachtwoord()))
                throw new IllegalArgumentException("Gelieve het wachtwoord correct te bevestigen");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("OK");
            alert.setHeaderText(null);
            alert.setContentText("Alle ingevoerde gegevens worden aanvaard");
            alert.showAndWait();
        }
        catch (IllegalArgumentException iae)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fout");
            alert.setHeaderText(null);
            alert.setContentText(iae.getMessage());
            alert.showAndWait();
            txfWachtwoord2.selectAll();
        }
    }


    private void buildGui(){
        this.setAlignment(Pos.CENTER_LEFT);
        this.setSpacing(10);
        this.setPadding(new Insets(25, 25, 25, 25));

        lblGebruikersnaam = new Label("Gebruikersnaam: ");
        txfGebruikersnaam = new TextField();
        lblWachtwoord = new Label("Wachtwoord: ");
        txfWachtwoord = new TextField();
        lblWachtwoord2 = new Label("Bevestig wachtwoord: ");
        txfWachtwoord2 = new TextField();
        txfGebruikersnaam.setOnAction(event -> txfGebruikersnaamAction(event));
        txfWachtwoord.setOnAction(event -> txfWachtwoordAction(event));
        //txfWachtwoord.setOnAction(this::txfWachtwoordAction);
        txfWachtwoord2.setOnAction(event -> txfWachtwoord2Action(event));
        //txfWachtwoord2.setOnAction(this::txfWachtwoord2Action);


        this.getChildren().addAll(lblGebruikersnaam, txfGebruikersnaam, lblWachtwoord, txfWachtwoord, lblWachtwoord2, txfWachtwoord2);
    }
}
