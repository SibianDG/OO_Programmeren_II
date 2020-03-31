/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domein.DierSoort;
import domein.DomeinController;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class DierenScherm extends GridPane
{
	@FXML
	private TextArea txaOverzicht;

	private final DomeinController dc;
	private final KnoppenPaneel knoppen;

	public DierenScherm(DomeinController dc)
	{
		this.dc = dc;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("DierenScherm.fxml"));
		loader.setRoot(this);
		loader.setController(this);
		try
		{
			loader.load();
		} catch (IOException ex)
		{
			System.out.println("Probleem met tonen DierenScherm");
		}
		toonOverzicht();
		knoppen = new KnoppenPaneel(this);
		this.add(knoppen, 0, 1);
	}

	protected void laadDierToevoegenScherm(DierSoort soort)
	{
		Stage stage = (Stage) this.getScene().getWindow();
		stage.setTitle(
				soort.equals(DierSoort.KAT) ? "Kat toevoegen" : "Hond toevoegen");
		Scene scene = new Scene(new DierToevoegenScherm(dc, soort, this));
		stage.setScene(scene);
		scene.getStylesheets().add("style.css");
	}

	protected final void toonOverzicht()
	{
		txaOverzicht.setText(dc.maakOverzicht());
	}
}
