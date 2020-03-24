package gui;

import domein.DomeinController;
import domein.Veelhoek;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class VoegToeScherm {

    private ComboBox keuzeVeelhoek;
    private TextField txfLengte, txfBreedte, txfZijdeA, txfZijdeB, txfZijdeC;
    private Label lblFout;
    private DomeinController dc;
    private Label lblLengte, lblBreedte, lblZijdeA, lblZijdeB, lblZijdeC;
    private Button btnVoegToe;
    private VeelhoekScherm vs;

    public VoegToeScherm(DomeinController dc, VeelhoekScherm vs) {
        this.dc = dc;
        this.vs = vs;
    }

    private void buildGui(){

    }

    private void voegRechthoekToe(){

    }

    private void voegDriehoekToe(){

    }

    private void verwijderRechthoekVelden(){

    }

    private void verwijderDriehoekVelden(){

    }
}
