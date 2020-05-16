package gui;

import domein.DomeinController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

public class OfferteScherm extends BorderPane
{
    private final DomeinController dc;
    private final String type;
    
    public OfferteScherm
        (DomeinController dc, String type)
    {
        this.dc = dc;
        this.type = type;
        buildGui();
    }

    private void buildGui()
    {   
        ListView<String> lvAannemers = new ListView<>();
        
        String[] aannemers = dc.geefAannemersVanType(type);
        ObservableList<String> items = FXCollections.observableArrayList(aannemers);
        lvAannemers.setItems(items);
        
        OffertePaneel op = new OffertePaneel(dc);
        
        this.setLeft(lvAannemers);
        this.setCenter(op);
        
        lvAannemers.getSelectionModel().selectedItemProperty().addListener
        (
            new ChangeListener<String>()
            {
                @Override
                public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2)
                {
                    int index = lvAannemers.getSelectionModel().getSelectedIndex();
                    op.update(type, index);
                }        
            }
        );
    }   
}
