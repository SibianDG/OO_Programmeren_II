package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class WelkomScherm extends Pane 
{
	public WelkomScherm() 
	{
		Label lblWelkom = new Label("Welkom bij JavaFX");
		lblWelkom.setLayoutX(200);
		lblWelkom.setLayoutY(10);
		
		ImageView image = new ImageView
				(new Image(getClass().getResourceAsStream("/images/bug.png")));
		image.setLayoutX(50);
		image.setLayoutY(50);
		
		Button btnKlik = new Button("Klik hier!");
		//btnKlik.setOnAction(new ButtonEvent());
		//btnKlik.setOnAction(new ButtonEvent2());
		btnKlik.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert popup = new Alert(Alert.AlertType.INFORMATION);
				popup.setTitle("Alert");
				popup.setHeaderText("Popup");
				popup.setContentText("Geklikt op button!");
				popup.showAndWait();
			}
		});
		btnKlik.setLayoutX(400);
		btnKlik.setLayoutY(250);
		
		this.getChildren().addAll(lblWelkom,image,btnKlik);
	} //einde constructor

	/*
	private class ButtonEvent2 implements EventHandler<ActionEvent> {

		//functionele interface --> Interface met 1 methode
		@Override
		public void handle(ActionEvent event) {
			Alert popup = new Alert(Alert.AlertType.INFORMATION);
			popup.setTitle("Alert");
			popup.setHeaderText("Popup");
			popup.setContentText("Geklikt op button!");
			popup.showAndWait();
		}
	}

	 */

} //einde klasse
