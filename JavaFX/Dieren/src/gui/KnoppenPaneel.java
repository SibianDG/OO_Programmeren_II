/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domein.DierSoort;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author lvu621
 */
public class KnoppenPaneel extends GridPane
{
	@FXML
	private Button btnKatToevoegen;

	@FXML
	private Button btnHondToevoegen;

	private final DierenScherm hoofdScherm;

	public KnoppenPaneel(DierenScherm hoofdScherm)
	{
		this.hoofdScherm = hoofdScherm;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("KnoppenPaneel.fxml"));
		loader.setRoot(this);
		loader.setController(this);
		try
		{
			loader.load();
		} catch (IOException ex)
		{
			System.out.println("Probleem met tonen KnoppenPaneel");
		}


	}

	public void voegKatToe()
	{
		hoofdScherm.laadDierToevoegenScherm(DierSoort.KAT);
	}

	public void voegHondToe()
	{
		hoofdScherm.laadDierToevoegenScherm(DierSoort.HOND);
	}
}
