package gui;

import domein.DomeinController;
import javafx.scene.layout.VBox;

public class KaartSelectieScherm extends VBox
{
	private int gekozenFilter;
	private FilterKeuzeScherm vorigScherm;
	private DomeinController dc;
	
	public KaartSelectieScherm(int gekozenFilter, FilterKeuzeScherm vorigScherm, DomeinController dc)
	{
		this.gekozenFilter = gekozenFilter;
		this.vorigScherm = vorigScherm;
		this.dc = dc;
		buildGui();
	}

	private void buildGui()
	{
		KaartOverzicht kaartOverzicht = new KaartOverzicht(dc);
		SelectieInput selectieInput = new SelectieInput(kaartOverzicht, gekozenFilter, vorigScherm);
		this.getChildren().addAll(kaartOverzicht, selectieInput);
	}
}
