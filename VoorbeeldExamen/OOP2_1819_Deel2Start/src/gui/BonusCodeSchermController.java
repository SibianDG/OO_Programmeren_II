package gui;

import domein.DomeinController;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class BonusCodeSchermController extends GridPane
{

    @FXML
    private Label lblInvoer;
    @FXML
    private TextField txfEen;
    @FXML
    private TextField txfTwee;
    @FXML
    private Button btnControleer;
    @FXML
    private ComboBox<String> cmbKeuze;
    @FXML
    private Label lblReeks;

    @FXML
    private Label lblMessage;

    private DomeinController dc;
    private String gekozenItem;

    public BonusCodeSchermController(DomeinController dc)
    {
        this.dc = dc;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("BonusCodeScherm.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        try
        {
            loader.load();
        } catch (IOException ex)
        {
            throw new RuntimeException(ex);
        }

        cmbKeuze.setPromptText("Keuze?");
        cmbKeuze.setItems(FXCollections.observableArrayList("Een", "Reeks"));

    }

    @FXML
    private void btnControleer(ActionEvent event)
    {
        // TO DO
    }

    @FXML
    private void cmbKeuzeOnAction(ActionEvent event)
    {
        gekozenItem = cmbKeuze.getSelectionModel().getSelectedItem();
        setReeksZichtbaar(!gekozenItem.equals("Een"));
    }

    private void setReeksZichtbaar(boolean aanAf)
    {
        lblReeks.setVisible(aanAf);
        txfTwee.setVisible(aanAf);
    }

}
