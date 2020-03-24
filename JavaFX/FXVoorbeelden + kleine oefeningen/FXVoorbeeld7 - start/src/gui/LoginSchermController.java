package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class LoginSchermController extends GridPane {

    @FXML
    private Button btnInloggen;

    @FXML
    private Button btnAnnuleer;

    @FXML
    private Label lblFoutBericht;

    @FXML
    private TextField txfGebruikersnaam;

    @FXML
    private PasswordField pwfWachtwoord;

    public LoginSchermController() {
        super();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScherm.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void btnAnnuleerAfhandeling(ActionEvent event) {

    }

    @FXML
    void btnInloggenAfhandeling(ActionEvent event) {

    }

}
