package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class VolgendSchermController extends HBox {
    @FXML
    private Label lblWelkom;
    @FXML
    private Button btnTerug;

    private LoginSchermController loginSchermController;

    public VolgendSchermController(String naam, LoginSchermController loginSchermController) {
        this.loginSchermController = loginSchermController;
        try {
            FXMLLoader loader =
                    new FXMLLoader(getClass().getResource("VolgendScherm.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        lblWelkom.setText("Welkom " + naam);
    }

    @FXML
    public void btnTerugOnAction(ActionEvent event) {
        //GEEN NIEUWE LOGINSCONTROLLER MAKEN!
        Stage stage = (Stage) this.getScene().getWindow();
        stage.setScene(loginSchermController.getScene());
    }
}

