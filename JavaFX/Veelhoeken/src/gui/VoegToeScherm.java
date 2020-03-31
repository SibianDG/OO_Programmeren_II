package gui;

import domein.DomeinController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class VoegToeScherm extends VBox {

    private ComboBox<String> keuzeVeelhoek;
    private TextField txfLengte, txfBreedte, txfZijdeA, txfZijdeB, txfZijdeC;
    private Label lblFout;
    private DomeinController dc;
    private Label lblLengte, lblBreedte, lblZijdeA, lblZijdeB, lblZijdeC;
    private Button btnVoegToe;
    private VeelhoekScherm vs;

    public VoegToeScherm(DomeinController dc, VeelhoekScherm vs) {
        this.dc = dc;
        this.vs = vs;
        buildGui();
    }

    private void buildGui(){
        Label lblTitel = new Label("Overzicht veelhoeken");
        lblTitel.getStyleClass().add("titel");

        ObservableList<String> options = FXCollections.observableArrayList(
                "Rechthoek",
                "Driehoek"
        );
        keuzeVeelhoek = new ComboBox<>(options);
        keuzeVeelhoek.setPromptText("Maak uw keuze");

        this.getChildren().addAll(lblTitel, keuzeVeelhoek);

        keuzeVeelhoek.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {


                if (oldValue != null && oldValue.equals("Rechthoek")) {
                    verwijderRechthoekVelden();
                } else if (oldValue != null && oldValue.equals("Driehoek")) {
                    verwijderDriehoekVelden();
                }

                if (newValue.equals("Rechthoek")) {
                    voegRechthoekToe();
                } else if (newValue.equals("Driehoek")){
                    voegDriehoekToe();
                }
            }

        });
    }

    private void voegRechthoekToe(){
        lblLengte = new Label("Lengte:");
        txfLengte = new TextField();
        lblBreedte = new Label("Breedte:");
        txfBreedte = new TextField();
        btnVoegToe = new Button("Voeg toe");
        lblFout = new Label();
        btnVoegToe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String[] gegevens = new String[3];
                gegevens[0] = "4";
                gegevens[1] = txfBreedte.getText();
                System.out.println(txfBreedte.getText());
                gegevens[2] = txfLengte.getText();
                try {
                    lblFout.setText("");
                    dc.voegVeelhoekToe(gegevens);
                    vs.toonOverzicht();
                } catch (NumberFormatException ex) {
                    lblFout.setText("Vul getallen in");
                    txfLengte.requestFocus();
                } catch (IllegalArgumentException ex) {
                    lblFout.setText(ex.getMessage());
                    txfLengte.requestFocus();
                } catch (Exception ex){
                    lblFout.setText(ex.getMessage());
                    txfLengte.requestFocus();
                }
            }
        });
        lblFout.getStyleClass().add("fout");
        this.getChildren().addAll(lblLengte, txfLengte, lblBreedte, txfBreedte, btnVoegToe, lblFout);
    }

    private void voegDriehoekToe(){

        lblZijdeA = new Label("Zijde A:");
        txfZijdeA = new TextField();
        lblZijdeB = new Label("Zijde B:");
        txfZijdeB = new TextField();
        lblZijdeC = new Label("Zijde C:");
        txfZijdeC = new TextField();
        lblFout = new Label();
        btnVoegToe = new Button("Voeg toe");
        btnVoegToe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String[] gegevens = new String[4];
                gegevens[0] = "3";
                gegevens[1] = txfZijdeA.getText();
                gegevens[2] = txfZijdeB.getText();
                gegevens[3] = txfZijdeC.getText();
                try {
                    dc.voegVeelhoekToe(gegevens);
                    vs.toonOverzicht();
                } catch (NumberFormatException ex) {
                    lblFout.setText("Vul gehele getallen in");
                    txfZijdeA.requestFocus();
                } catch (IllegalArgumentException ex) {
                    lblFout.setText(ex.getMessage());
                    txfZijdeA.requestFocus();
                }
            }
        });
        lblFout.getStyleClass().add("fout");
        this.getChildren().addAll(lblZijdeA, txfZijdeA, lblZijdeB, txfZijdeB, lblZijdeC, txfZijdeC, btnVoegToe, lblFout);
    }

    private void verwijderRechthoekVelden(){
        this.getChildren().removeAll(lblLengte, txfLengte, lblBreedte, txfBreedte, btnVoegToe, lblFout);
    }

    private void verwijderDriehoekVelden(){
        this.getChildren().removeAll(lblZijdeA, txfZijdeA, lblZijdeB, txfZijdeB, lblZijdeC, txfZijdeC, btnVoegToe, lblFout);
    }
}
