package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SelectieInput extends GridPane
{
	private KaartOverzicht dlp;
	private int gekozenFilter;
	private FilterKeuzeScherm vorigScherm;
	private TextField txfSelectie;
	
	public SelectieInput(KaartOverzicht dlp, int gekozenFilter, FilterKeuzeScherm vorigScherm)
	{
		this.dlp = dlp;
		this.gekozenFilter = gekozenFilter;
		this.vorigScherm = vorigScherm;
		buildGui();
	}

	private void buildGui()
	{
		Label lblKeuze, lblSelectie;
		Button btnBevestig, btnAnnuleer, btnTerug;
		
		String keuzeTekst, selectieTekst = "";
		
		this.setHgap(10);
		this.setVgap(25);
		this.setAlignment(Pos.CENTER);
		
		lblKeuze = new Label();
		keuzeTekst = "Waarop wil je filteren: ";
		
		lblSelectie = new Label();
		
		switch (gekozenFilter)
		{
			case 0: keuzeTekst += "op kleur"; selectieTekst = "Kleur:"; break;
			case 1: keuzeTekst += "op punt"; selectieTekst = "Punt:"; break;
		}
		
		lblKeuze.setText(keuzeTekst);
		this.add(lblKeuze, 0, 0, 2, 1);
		txfSelectie = new TextField();
		this.add(txfSelectie, 3, 0, 2, 1);
		
		lblSelectie.setText(selectieTekst);
		this.add(lblSelectie, 1, 1);
				
		btnTerug = new Button("terug");
		btnTerug.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				kiesAnderCriterium();
				
			}
			
		});
		
		
		btnAnnuleer = new Button("Annuleer");
		btnAnnuleer.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				wisFilter();
				
			}
		});
		
		btnBevestig = new Button("Bevestig");
		btnBevestig.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				voerFilterUit();
				
			}
		});
		
		//this.add(child, columnIndex, rowIndex); alles nog toevoegen
	}	
	
	private void voerFilterUit() {
		dlp.updateLijst(gekozenFilter, txfSelectie.getText());
	}
	
	private void wisFilter() {
		txfSelectie.setText("");
		dlp.toonVolledigeLijst();
	}
	
	private void kiesAnderCriterium() {
        Stage stage = (Stage) this.getScene().getWindow();
        stage.setScene(vorigScherm.getScene());
		
	}
}
