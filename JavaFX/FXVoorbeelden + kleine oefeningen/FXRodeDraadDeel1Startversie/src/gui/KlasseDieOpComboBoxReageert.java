package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;

public class KlasseDieOpComboBoxReageert implements EventHandler<ActionEvent> {

    private ComboBox cboTitels;
    private BeheersKostenScherm bks;

    public KlasseDieOpComboBoxReageert(ComboBox cboTitels, BeheersKostenScherm bks) {
        this.cboTitels = cboTitels;
        this.bks = bks;
    }

    @Override
    public void handle(ActionEvent event) {
        bks.update(cboTitels.getSelectionModel().getSelectedIndex());
    }
}
