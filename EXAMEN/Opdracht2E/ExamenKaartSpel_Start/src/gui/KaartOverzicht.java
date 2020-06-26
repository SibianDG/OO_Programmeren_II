package gui;

import java.util.Optional;

import domein.DomeinController;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class KaartOverzicht extends VBox
{
	private DomeinController dc;
	private ListView<String> lvKaarten;
	private Label lblFout;
	
	public KaartOverzicht(DomeinController dc)
	{
		this.dc = dc;
		buildGui();
	}

	private void buildGui()
	{
		this.setPadding(new Insets(20));
		
		Label lblKaartenLijst = new Label("Dit zijn de gefilterde kaarten");
		lvKaarten = new ListView<>();
		
		lvKaarten.getSelectionModel()
				.selectedItemProperty()
				.addListener(new ListViewLuisteraar());
		
		lblFout = new Label();
		
		toonVolledigeLijst();
		
		this.getChildren().addAll(lblKaartenLijst, lvKaarten, lblFout);
	}	
	
	public void toonVolledigeLijst()
	{
		lblFout.setText("");
		lvKaarten.setItems(null);
		String[] kaartenArray = dc.geefKaarten();
		ObservableList<String> lijst = FXCollections.observableArrayList(kaartenArray);
		lvKaarten.setItems(lijst);
	}
	
	public void updateLijst(int gekozenFilter, String filterTekst)
	{
		lblFout.setText("");
		lvKaarten.setItems(null);
		dc.filterOp(gekozenFilter, filterTekst);
		String[] kaartenArray = dc.geefGefilterdeKaarten();
		ObservableList<String> lijst = FXCollections.observableArrayList(kaartenArray);
		lvKaarten.setItems(lijst);
	}
	
	private void toonInfo(String[] info)
	{
     lvKaarten.setItems(FXCollections.observableArrayList(info));
	}
	
	private class ListViewLuisteraar implements InvalidationListener
	{
		@Override
		public void invalidated(Observable arg0)
		{
			int index = lvKaarten.getSelectionModel().getSelectedIndex();
			String[] info = dc.geefKaartOpIndex(index);
			toonInfo(info);
		}	
	}
}
