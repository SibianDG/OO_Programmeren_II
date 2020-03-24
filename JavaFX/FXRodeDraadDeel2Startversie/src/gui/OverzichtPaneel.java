package gui;

import domein.DomeinController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class OverzichtPaneel extends GridPane {

    private ListView<String> listView;
    private DomeinController controller;
    private DetailPaneel details;

    public OverzichtPaneel(DomeinController controller, DetailPaneel details) {
        this.controller = controller;
        this.details = details;
        buildGui();
    }

    private void buildGui(){
        listView = new ListView<>();
        for (String string : controller.geefAlleRekeningen()){
            listView.getItems().add(string);
        }
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                details.setIndexVanDeRekening(listView.getSelectionModel().getSelectedIndex());
                details.update();
            }
        });
        this.add(listView, 0, 0, 2, 1);
    }
}
