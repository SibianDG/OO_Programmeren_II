package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class DemoEventSchermMetAnoniemeInnerKlassen extends GridPane
{
    public DemoEventSchermMetAnoniemeInnerKlassen()
    {
        Label lblBoodschap = new Label();
        Button btnKlik = new Button("Klik");

        this.add(lblBoodschap, 0, 0);
        this.add(btnKlik, 0, 1);
        this.setAlignment(Pos.CENTER);

        btnKlik.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                lblBoodschap.setText("Joepie!");
            }
        });

        this.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                System.out.println("x = " + event.getSceneX());
                System.out.println("y = " + event.getSceneY());
            }
        });
    }
}
