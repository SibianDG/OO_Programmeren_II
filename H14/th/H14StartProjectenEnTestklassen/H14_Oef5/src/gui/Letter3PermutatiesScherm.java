package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import domein.MijnString;
import javafx.scene.layout.VBox;

public class Letter3PermutatiesScherm extends VBox
{
    private MijnString mijnString;
    private Label lblMessage,lblInvoer;
    private TextField txfInvoer;
    private Button btnToon;
    private TextArea txaArray, txaBuilder;
         
     public Letter3PermutatiesScherm()
     {
        this.setAlignment(Pos.CENTER_LEFT);       
        this.setSpacing(10);
        this.setPadding(new Insets(25, 25, 25, 25));
        
        lblInvoer = new Label("GEEF INVOERSTRING: ");
        txfInvoer = new TextField();
        btnToon = new Button("TOON");
        txaArray = new TextArea();
        
        txaBuilder = new TextArea();
        
        this.getChildren().addAll(lblInvoer,txfInvoer,btnToon,txaArray,txaBuilder);
        
        lblMessage = new Label("Gelieve een woord van 3 letters in te geven.");
        lblMessage.setVisible(false);
        this.getChildren().add(lblMessage);
        
        btnToon.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent evt)
            {
                MijnString mijnString = new MijnString(txfInvoer.getText());
                txaArray.setText(mijnString.geefAllePermutatiesVanDrieMetArray());
                txaBuilder.setText(mijnString.geefAllePermutatiesVanDrieMetStringBuilder());
             }
        });   
  }
     
    private void reset()
    {
        txaArray.setText("");
        txaBuilder.setText("");
    } 
}