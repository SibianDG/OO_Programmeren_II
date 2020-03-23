package gui;

import domein.DomeinController;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class BeheersKostenScherm extends VBox {

    private ComboBox<String> cboTitels;
    private Label lblUitleg;
    private Label lblKost;
    private TextArea txaUitleg;
    private TextField txfKost;
    private DomeinController dc;

    public BeheersKostenScherm(DomeinController controller) {
        this.dc = controller;
        buildGui();
    }

    private void buildGui(){
        cboTitels = new ComboBox<>();
        for (String x : dc.geefTitelsBeheersKosten()){
            cboTitels.getItems().add(x);
        }
        // TODO: 23/03/2020 combobox met index?
        //cboTitels.setOnAction(new KlasseDieOpComboBoxReageert(cboTitels, dc));
        lblUitleg = new Label("Uitleg:");
        txaUitleg = new TextArea();
        lblKost = new Label("Berheerskosten:");
        txfKost = new TextField();

        this.getChildren().addAll(cboTitels, lblUitleg,txaUitleg, lblKost, txfKost);
    }

    public void update(int gekozenRekeningIndex){
        txaUitleg.setText(dc.geefDetailsBeheerskost(gekozenRekeningIndex));
        txfKost.setText(String.format("De kost bedraagt €%.2f", dc.geefBeheerskostWaarde(gekozenRekeningIndex)));
    }
}
