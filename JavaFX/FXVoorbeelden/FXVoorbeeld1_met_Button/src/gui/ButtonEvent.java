package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class ButtonEvent implements EventHandler<ActionEvent> {

    //functionele interface --> Interface met 1 methode
    @Override
    public void handle(ActionEvent event) {
        Alert popup = new Alert(Alert.AlertType.INFORMATION);
        popup.setTitle("Alert");
        popup.setHeaderText("Popup");
        popup.setContentText("Geklikt op button!");
        popup.showAndWait();
    }
}
