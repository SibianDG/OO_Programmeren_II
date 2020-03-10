package gui;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DemoFlowPane extends Stage
{

    public DemoFlowPane()
    {
// Deze derde demo toont de werking van een FlowPane
// Een horizontaal FlowPane plaatst zijn componenten van links naar rechts 
// en van boven naar onder
// Een verticaal FlowPane plaatst zijn componenten van boven naar onder 
// en van links naar rechts

        FlowPane flow = new FlowPane(Orientation.HORIZONTAL);
        flow.setPadding(new Insets(10));

// Dit zorgt voor witruimte tussen de kolommen
        flow.setHgap(10);

// Dit zorgt voor witruimte tussen de rijen
        flow.setVgap(10);

// Een Image stelt een afbeelding voor 
// Hier zie je hoe je een bestand uit je project kan inladen en gebruiken
        Image twitterEi = new Image(getClass().getResourceAsStream("/images/default.png"));

// Een ImageView toont een afbeelding op het scherm
// Hier voegen we vijf ImageViews toe die dezelfde afbeelding tonen
        for (int i = 0; i < 5; i++)
        {
            flow.getChildren().add(new ImageView(twitterEi));
        }

        Scene scene = new Scene(flow);
        this.setScene(scene);

    }
}
