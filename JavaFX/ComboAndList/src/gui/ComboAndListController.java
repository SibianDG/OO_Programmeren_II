package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ComboAndListController extends AnchorPane {

    @FXML
    private ComboBox<?> cmbCombo;

    @FXML
    private ListView<?> livListView;

    public ComboAndListController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("comboAndList.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    @FXML
    void cmbComboOnAction(ActionEvent event) {

    }

}