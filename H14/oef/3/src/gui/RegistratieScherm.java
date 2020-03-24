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

    public RegistratieScherm()
    {
        buildGui();

    }


    private void txfGebruikersnaamAction(ActionEvent event){
        //wat moet er hier in?
    }

    private void txfWachtwoordAction(ActionEvent event){
        try {
            login = new Login(txfGebruikersnaam.getText(), txfWachtwoord.getText());
        } catch (IllegalArgumentException iae){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fout");
            alert.setContentText(iae.getMessage());
            alert.show();
        }
    }

    private void txfWachtwoord2Action(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Fout");
        try {
            // 2x new login?
            login = new Login(txfGebruikersnaam.getText(), txfWachtwoord.getText());
            if (!txfWachtwoord2.getText().equals(login.getWachtwoord())){
                alert.setContentText("Gelieve het wachtwoord correct te bevestigen.");
            } else {
                alert.setContentText("Alle ingevoerde gegevens werden aanvaard");
            }
        } catch (IllegalArgumentException iae){
            alert.setTitle("Fout");
            alert.setContentText(iae.getMessage());
            alert.show();
        }

        alert.show();
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
        txfWachtwoord.setOnAction(event -> txfWachtwoordAction(event));
        //txfWachtwoord.setOnAction(this::txfWachtwoordAction);
        txfWachtwoord2.setOnAction(event -> txfWachtwoord2Action(event));
        //txfWachtwoord2.setOnAction(this::txfWachtwoord2Action);


        this.getChildren().addAll(lblGebruikersnaam, txfGebruikersnaam, lblWachtwoord, txfWachtwoord, lblWachtwoord2, txfWachtwoord2);
    }
}
