package gui;

import java.math.BigDecimal;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import domein.TipCalculator;

// Dit paneel zal het rootpaneel worden
// De hoofdlayout is een GridPane
// Deze klasse is dan ook een subklasse van GridPane
public class TipCalculatorScherm extends GridPane
{  
    private TextField txfAmount , txfTip, txfTotal;
    private Slider sldTipPercentage;
    private BigDecimal tipPercentage = new BigDecimal(0.15);

    private TipCalculator domeinController;

    public TipCalculatorScherm(TipCalculator dc)
    {
        this.domeinController = dc;
        buildGui();
    }
 
// GUI opbouwen    
    private void buildGui()
    {    
        setVgap(10);
        setHgap(10);
        setPadding(new Insets(10));     
        
        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
// In de eerste kolom worden alle componenten horizontaal rechts gealigneerd
        col1.setHalignment(HPos.RIGHT);
        col2.setHgrow(Priority.ALWAYS); 
        getColumnConstraints().addAll(col1, col2);

// Toevoegen aan bepaalde kolom en bepaalde rij in GridPane        
        add(new Label("Amount"),0,0);
        
        txfAmount = new TextField("Enter amount");
        add(txfAmount,1,0);

        Label lblTipPercentage = 
                new Label (String.format("%.0f%%", tipPercentage.multiply(new BigDecimal(100))));
        add(lblTipPercentage,0,1);
  
        sldTipPercentage = new Slider();
        sldTipPercentage.setMin(0.0);
        sldTipPercentage.setMax(30.0);
        sldTipPercentage.setValue(tipPercentage.doubleValue()*100);  
        add(sldTipPercentage,1,1);
 
        add(new Label ("Tip"),0,2);
        
        txfTip = new TextField();
        txfTip.setEditable(false);
        add(txfTip,1,2);

        add(new Label("Total"),0,3);
        
        txfTotal = new TextField ();
        txfTotal.setEditable(false);
        add(txfTotal,1,3);
  
        Button btnCalculate = new Button("Calculate");  
// De button neemt de maximale breedte in
        btnCalculate.setMaxWidth(Double.MAX_VALUE);
        add(btnCalculate,1,4);
// Event afhandeling          
        btnCalculate.setOnAction(this::calculateButtonPressed);

// Event handler wordt aangeroepen wanneer de slider andere waarde aangeeft 
// Event afhandeling met anonieme inner klasse
        sldTipPercentage.valueProperty().addListener(
            new ChangeListener<Number>()
            {
                @Override
                public void changed(ObservableValue<? extends Number> ov,
                        Number oldValue, Number newValue)
                {
                  tipPercentage = BigDecimal.valueOf(newValue.doubleValue()/100.0);            
                  lblTipPercentage.setText(String.format("%.0f%%", 
                          tipPercentage.multiply(new BigDecimal(100.0))));
                }
            }
        );
    }
    public void calculateButtonPressed(ActionEvent event)
    {
        try
        {
            BigDecimal amount = new BigDecimal(txfAmount.getText());
            domeinController.setAmount(amount);
            BigDecimal tip = domeinController.calculateTip(tipPercentage);
            txfTip.setText(String.format("%.2f", tip));
            txfTotal.setText(String.format("%.2f", amount.add(tip)));
        }
        catch (NumberFormatException ex)
        {
            txfAmount.setText("Enter amount");
            txfAmount.selectAll();
            txfAmount.requestFocus();
        }
        catch (IllegalArgumentException iex)
        {
            txfAmount.setText(iex.getMessage());
            txfAmount.selectAll();
            txfAmount.requestFocus();
        }
    }   
}
