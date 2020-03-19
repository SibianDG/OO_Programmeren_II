package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import domein.MijnString;

public class WartaalScherm extends GridPane
{
    private MijnString mijnString;
    private Label lblMessage,lblInvoer,lblLetter1,lblLetter2;
    private TextField txfInvoer, txfLetter1,txfLetter2, txfWartaal;
    private Button btnWartaal;

    public WartaalScherm()
     {
        this.setAlignment(Pos.CENTER);       
        this.setHgap(10);     
        this.setVgap(10);
        this.setPadding(new Insets(10, 10, 10, 10));
        
        lblInvoer = new Label("GEEF INVOERSTRING: ");
        txfInvoer = new TextField();
        lblLetter1 = new Label("1ste LETTER:");
        txfLetter1 = new TextField();
        txfLetter1.setMaxWidth(30);
        lblLetter2 = new Label("2de LETTER: ");
        txfLetter2 = new TextField();
        txfLetter2.setMaxWidth(30);
        btnWartaal = new Button("MAAK WARTAAL");
        txfWartaal = new TextField();
        txfWartaal.setEditable(false);
        
        this.add(lblInvoer,0,0,2,1);
        this.add(txfInvoer,0,1,2,1);
        this.add(lblLetter1,0,2);
        this.add(txfLetter1,1,2);
        this.add(lblLetter2,0,3);
        this.add(txfLetter2,1,3);
        this.add(btnWartaal, 0, 4);
        this.add(txfWartaal,0,5,2,1);
        
        lblMessage = new Label("Velden moeten ingevuld zijn.");
        lblMessage.setVisible(false);
        this.add(lblMessage, 0, 6);
        
        btnWartaal.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent evt)
            {
               MijnString mijnString = new MijnString(txfInvoer.getText());
               txfWartaal.setText(mijnString.maakWartaal(txfLetter1.getText().charAt(0), txfLetter2.getText().charAt(0)));
             }
        });
           
  }
     
    private void reset()
    {
       txfInvoer.setText("");
       txfLetter1.setText("");
       txfLetter2.setText("");
       txfWartaal.setText("");
    }
}
