package gui;

import domein.Aannemer;
import domein.DomeinController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VerbouwingScherm extends VBox
{
    private final DomeinController dc;
    private String type;
    
    public VerbouwingScherm(DomeinController dc)
    {
        this.dc = dc;
        buildGui();
    }

    private void buildGui()
    {
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10));
        this.setSpacing(20);
        ComboBox<String> cboType = new ComboBox<>();
        cboType.setPromptText("Kies het type aannemer");
        String[] types = dc.geefTypesAannemers(); 
        ObservableList<String> items = 
            FXCollections.observableArrayList(types);
        cboType.setItems(items);
        TextField txfBasisPrijs = new TextField();
        txfBasisPrijs.setMaxWidth(150);
        Button btnBevestig = new Button("Bevestig");
        Label lblFoutboodschap = new Label();
        
        this.getChildren().addAll
            (new Label("De verbouwing kan beginnen..."), cboType,
             new Label("Basisprijs architect"), txfBasisPrijs, 
             btnBevestig, lblFoutboodschap);
        
        cboType.getSelectionModel().selectedItemProperty().addListener
        (
        	new ChangeListener<String>()
        	{
				@Override
				public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2)
				{
                 //   int index = cboType.getSelectionModel().getSelectedIndex();
                 //   type = types[index];
					type = arg2;
				}	
        	}
        );
        
        btnBevestig.setOnAction
        (
            new EventHandler<ActionEvent> ()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    try
                    {
                        double prijs = Double.parseDouble(txfBasisPrijs.getText());
                        Aannemer.setBasisPrijs(prijs);
                        if (type != null)
                            toonOfferteScherm();
                        else
                            lblFoutboodschap.setText
                                ("Gelieve een type aannemer te kiezen");
                    }
                    catch (NumberFormatException e)
                    {
                        lblFoutboodschap.setText
                            ("Gelieve een kommagetal in te voeren voor de basisprijs!");
                    }
                    catch (IllegalArgumentException e)
                    {
                        lblFoutboodschap.setText(e.getMessage());
                    }
                }
            }
        );
    }
    
    private void toonOfferteScherm()
    {
        Scene currentScene = this.getScene();
        Stage theStage = (Stage) currentScene.getWindow();
        theStage.setTitle("Offertes");
        OfferteScherm os = new OfferteScherm(dc, type);
        Scene newScene = new Scene(os, 600, 400);
        theStage.setScene(newScene);
    }
}
