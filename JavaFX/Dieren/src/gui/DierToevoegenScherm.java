package gui;

import domein.DierSoort;
import domein.DomeinController;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 * @author lvu621
 */
public class DierToevoegenScherm extends GridPane
{
    private Button btnOk, btnCancel;

    private String[] titelAttributen;
    private TextField[] txtAttributen;

    private DomeinController dc;
    private DierSoort dierSoort;
    private DierenScherm vorigScherm;

    public DierToevoegenScherm
            (DomeinController dc, DierSoort soort, DierenScherm vorigScherm)
    {
        this.dc = dc;
        this.vorigScherm = vorigScherm;
        this.dierSoort = soort;
        this.titelAttributen = dierSoort.getAttribuutNamen();

        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("DierToevoegenScherm.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try
        {
            loader.load();
        }
        catch (IOException ex)
        {
            throw new RuntimeException(ex);
        }
        initGUI();
    }

    private void initGUI()
    {
        setPadding(new Insets(10));
        setHgap(10);
        setVgap(10);

        txtAttributen = new TextField[titelAttributen.length];

        for (int rij = 0; rij < titelAttributen.length; rij++)
        {
            Label label = new Label(titelAttributen[rij]);
            label.setId("fancytext"); //CSS
            add(label, 0, rij);

            txtAttributen[rij] = new TextField();
            add(txtAttributen[rij], 1, rij);
        }

        btnOk = new Button();
        btnOk.setText("OK");
        btnOk.setMinSize(200, 70);
        btnOk.setOnAction
                (
                        new EventHandler()
                        {
                            @Override
                            public void handle(Event event)
                            {
                                drukOpOK();
                            }
                        }
                );
        add(btnOk, 0, titelAttributen.length);

        btnCancel = new Button();
        btnCancel.setText("Cancel");
        btnCancel.setMinSize(200, 70);
        btnCancel.setOnAction
                (
                        new EventHandler()
                        {
                            @Override
                            public void handle(Event event)
                            {
                                keerTerug();
                            }
                        }
                );
        add(btnCancel, 1, titelAttributen.length);
    }

    private void drukOpOK()
    {
        try
        {
            int gebjaar;
            switch (dierSoort)
            {
                case KAT:
                    gebjaar = Integer.parseInt(txtAttributen[0].getText());
                    dc.voegKatToe(gebjaar);
                    break;
                case HOND:
                    String naam = txtAttributen[0].getText();
                    gebjaar = Integer.parseInt(txtAttributen[1].getText());
                    dc.voegHondToe(naam, gebjaar);
                    break;
            }
            keerTerug();
        }
        catch (IllegalArgumentException e)
        {
            Alert a = new Alert(AlertType.ERROR);
            a.setTitle("Fout!");
            a.setHeaderText("Fout bij het toevoegen van een Dier!");
            a.setContentText(e.getMessage());
            a.showAndWait();
        }
    }

    private void keerTerug()
    {
        Stage stage = (Stage) this.getScene().getWindow();
        stage.setTitle("Katten en honden");
        stage.setScene(vorigScherm.getScene());
        vorigScherm.toonOverzicht();
    }
}
