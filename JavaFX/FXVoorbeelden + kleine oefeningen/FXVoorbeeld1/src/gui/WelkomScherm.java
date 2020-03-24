package gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;

public class WelkomScherm extends Pane
{
    public WelkomScherm()
    {
// Eerste grafische component: een label        
        Label lblWelkom = new Label("Welkom bij JavaFX !");

// Tweede grafische component, een ImageView toont een Image op het scherm        
        ImageView ivImage = new ImageView(
                   new Image(getClass().getResourceAsStream("/images/bug.png"))
        );

// In dit voorbeeld gebruik we geen layout
// We geven de componenten een vaste positie mee
// Dit doen we met de methoden setLayoutX en setLayoutY        
        lblWelkom.setLayoutX(200);
        lblWelkom.setLayoutY(10);
        
        ivImage.setLayoutX(50);
        ivImage.setLayoutY(50);

// Alle componenten worden verzameld in ons paneel
        
// componenten toevoegen aan een paneel         
        this.getChildren().addAll(lblWelkom, ivImage);

    }
}
