package gui;

import domein.TipCalculator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;

import javafx.scene.control.Slider;

import java.io.IOException;
import java.math.BigDecimal;

public class TipCalculatorSchermController extends GridPane {
	@FXML
	private Label lblTipPercentage;
	@FXML
	private TextField txfAmount;
	@FXML
	private TextField txfTip;
	@FXML
	private TextField txfTotal;
	@FXML
	private Slider sldTipPercentage;
	@FXML
	private Button btnCalculate;

	@FXML
	void btnCalculateOnAction(ActionEvent event) {
		try {
			BigDecimal amount = new BigDecimal(txfAmount.getText());
			domeincontroller.setAmount(amount);
			BigDecimal tip = domeincontroller.calculateTip(
					BigDecimal.valueOf(Math.floor(sldTipPercentage.getValue())/100)
			);
			txfTip.setText(String.format("%.2f", tip));
			txfTotal.setText(String.format("%.2f", amount.add(tip)));
		} catch (NumberFormatException nfe){
			txfAmount.setText("Enter amount");
			txfAmount.selectAll();
			txfAmount.requestFocus();
		} catch (IllegalArgumentException iae){
			txfAmount.setText(iae.getMessage());
			txfAmount.selectAll();
			txfAmount.requestFocus();
		}
	}

	private TipCalculator domeincontroller;
	public TipCalculatorSchermController(TipCalculator dc) {
		this.domeincontroller = dc;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("TipCalculatorScherm.fxml"));
		loader.setRoot(this);
		loader.setController(this);
		try {
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		sldTipPercentage.valueProperty().addListener(
				new ChangeListener<Number>() {
					@Override
					public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
						BigDecimal tipPercentage = BigDecimal.valueOf(newValue.intValue());
						lblTipPercentage.setText(String.format("%s%%", tipPercentage));
					}
				}
		);
	}

}
