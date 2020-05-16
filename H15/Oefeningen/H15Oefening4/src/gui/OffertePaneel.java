package gui;

import domein.DomeinController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class OffertePaneel extends GridPane
{
    private final DomeinController dc;
    private final TextField[] txfGegs = new TextField[3];
    private Label lblMelding;
    
    public OffertePaneel(DomeinController dc)
    {
        this.dc = dc;
        buildGui();
    }

    private void buildGui()
    {
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10));
        this.setHgap(5);
        this.setVgap(10);
        
        String[] labelTekst = {"naam bedrijf", "type bedrijf", "vraagprijs"};
        for (int i=0; i<txfGegs.length; i++)
        {
            txfGegs[i] = new TextField();
            txfGegs[i].setEditable(false);
            this.add(new Label(labelTekst[i]), 0, i);
            this.add(txfGegs[i], 1, i);
        }
        
        Button btnBevestig = new Button("Bevestig offerte");
        btnBevestig.setMaxWidth(Double.MAX_VALUE);
        this.add(btnBevestig, 0, txfGegs.length, 2, 1);
        
        btnBevestig.setOnAction
        (
            new EventHandler<ActionEvent> ()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    Alert a = new Alert(AlertType.INFORMATION);
                    a.setTitle(String.format
                        ("Offerte %s aanvaard!", txfGegs[1].getText()));
                    a.setHeaderText(String.format
                        ("Offerte van %s aangenomen", txfGegs[0].getText()));
                    a.setContentText(String.format
                        ("Je betaalt %s voor deze aannemer", txfGegs[2].getText()));
                    a.showAndWait();
                    Platform.exit();
                }                  
            }
        );
        
        lblMelding = new Label();
        this.add(lblMelding, 0, txfGegs.length + 1, 2, 1);
    }

    public void update(String type, int index)
    {
        String[] gegAannemer = dc.geefGegevensAannemer(type, index);
        for (int i=0; i<gegAannemer.length; i++)
            txfGegs[i].setText(gegAannemer[i]);
    }
    
    
}
