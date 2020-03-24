package gui;

import javafx.scene.control.TextField;
import domein.DomeinController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

// Dit paneel toont de details van de geselecteerde rekening
public class DetailPaneel extends GridPane
{
    private final DomeinController controller;

    private TextField txfRekeningNr;
    private TextField txfSaldo;
    private TextField txfHouder;
    private TextField txfBedrag;
    
    private int indexVanDeRekening;
    
    // Een DetailPaneel heeft een controller nodig
    // Deze komt binnen als invoer in de constructor
    public DetailPaneel(DomeinController controller)
    {
        this.controller = controller;
        buildGui();
    }
    
    private void buildGui()
    {
        Label lblRekeningNr, lblSaldo, lblHouder, lblBedrag;
        lblRekeningNr = new Label("Rekeningnr:");
        lblSaldo = new Label("Saldo:");
        lblHouder = new Label("Houder:");
        lblBedrag = new Label("Bedrag:");
        
        txfRekeningNr = new TextField();
        txfRekeningNr.setDisable(true);
        txfSaldo = new TextField();
        txfSaldo.setDisable(true);
        txfHouder = new TextField();
        txfHouder.setDisable(true);
        txfBedrag = new TextField();
        
        this.add(lblRekeningNr, 0, 1);
        this.add(txfRekeningNr, 1, 1);
        this.add(lblSaldo, 0, 2);
        this.add(txfSaldo, 1, 2);
        this.add(lblHouder, 0, 3);
        this.add(txfHouder, 1, 3);
        this.add(lblBedrag,0,4);
        this.add(txfBedrag,1,4);
        
        Font lettertype = new Font("Arial", 20);
        Label lblDetails = new Label("Details:");
        lblDetails.setFont(lettertype);
        this.add(lblDetails, 0, 0, 2, 1);
        
        this.setPadding(new Insets(10));
        this.setVgap(20);
        this.setHgap(10);
        
        txfRekeningNr.setEditable(false);
        txfHouder.setEditable(false);
        txfSaldo.setEditable(false);

        txfBedrag.setOnAction(event ->
                controller.stortOp(indexVanDeRekening, Integer.parseInt(txfBedrag.getText())));
        // TODO: 24/03/2020 Bedrag verwijnt niet opnieuw
    
    }

    public void update(){
        String[] gegevens = controller.geefRekeningInfo(indexVanDeRekening);
        txfRekeningNr.setText(gegevens[0]);
        txfSaldo.setText(gegevens[1]);
        txfHouder.setText(gegevens[2]);
    }

    public void setIndexVanDeRekening(int indexVanDeRekening) {
        this.indexVanDeRekening = indexVanDeRekening;
    }
}
