package gui;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DemoBorderPane extends Stage
{

    public DemoBorderPane()
    {
// Deze vierde demo toont de werking van een BorderPane
// Een BorderPane verdeelt zijn ruimte in vijf zones: top, bottom, left, 
// right en center
// De componenten in de zones top en bottom behouden hun gewenste hoogte en 
// groeien in de breedte
// De componenten in de zones left en right behouden hun gewenste breedte en 
// groeien in de hoogte
// De component in de zone center krijgt alle overgebleven ruimte

        BorderPane borderPane = new BorderPane();

// We maken 5 panelen aan met elk een andere achtergrondkleur
// Deze komen terecht in de zones top, bottom, center, left en right
        Pane top = new Pane();
   //     top.setPrefSize(900, 100);
        top.setPrefHeight(100);
        top.setStyle("-fx-background-color: rgb(255,0,0)");
        borderPane.setTop(top);

        Pane bottom = new Pane();
    //    bottom.setPrefSize(900, 100);
        bottom.setPrefHeight(100);
        bottom.setStyle("-fx-background-color: rgb(0,0,255)");
        borderPane.setBottom(bottom);

        Pane center = new Pane();
        center.setPrefSize(600, 400);
        center.setStyle("-fx-background-color: #FFFF00");
        borderPane.setCenter(center);

        Pane left = new Pane();
        left.setPrefWidth(200);
        left.setStyle("-fx-background-color: #000000");
        borderPane.setLeft(left);

        Pane right = new Pane();
        right.setPrefWidth(100);
        right.setStyle("-fx-background-color: #00FF00");
        borderPane.setRight(right);

        Scene scene = new Scene(borderPane);
        this.setScene(scene);

    }

}
