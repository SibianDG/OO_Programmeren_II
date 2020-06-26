package gui;

import domein.DomeinController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.event.*;

public class FilterKeuzeScherm extends HBox
{	
	private DomeinController dc;
	
	public FilterKeuzeScherm(DomeinController dc)
	{
		this.dc = dc;
		buildGui();
	}
	
	private void buildGui()
	{
		String kiesFilter = "Kies een kaart filter: ";
		Label lblKeuze = new Label(kiesFilter);
		lblKeuze.setFont(Font.font("Arial", 30));
		
		String[] filter = {"op kleur", "op punt"};
		
		ComboBox<String> cboCriteria = new ComboBox<>();
		ObservableList<String> lijstCriteria = FXCollections.observableArrayList(filter);
		cboCriteria.setItems(lijstCriteria);
		cboCriteria.setPromptText(kiesFilter);
		
		setPadding(new Insets(10));
        setAlignment(Pos.CENTER);
		
		this.getChildren().addAll(lblKeuze, cboCriteria);
		this.setSpacing(10);
		
		FilterKeuzeScherm huidgiFilterKeuzeScherm = this;
		
		
		cboCriteria.setOnAction(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
                KaartSelectieScherm root = new KaartSelectieScherm(cboCriteria.getSelectionModel().getSelectedIndex(), FilterKeuzeScherm, dc);
                Scene scene = new Scene(root, 640, 480);
                primaryStage.setScene(scene);
                primaryStage.setTitle("Filter kaarten");
                primaryStage.show();
				
			}

		})
		
		cboCriteria.getSelectionModel().getSelectedItem()
				
		cboCriteria.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
          public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//        	  if (newValue.equals("op kleur")) {
//				
//			} else {
//				
//			}
//              FilterKeuzeScherm root = new FilterKeuzeScherm(dc);
//              Scene scene = new Scene(root, 600, 200);
//              primaryStage.setScene(scene);
//              primaryStage.setTitle("Selecteer filer");
//              primaryStage.show();
//          }
      });
	}
}
