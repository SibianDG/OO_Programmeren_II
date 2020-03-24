package gui2;

import java.util.Optional;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;


public class DemoEventSchermMetStop extends GridPane
{

    public DemoEventSchermMetStop()
    {

        Label lblBoodschap = new Label();

        Button[] buttons = new Button[4];
        for (int i = 0; i < buttons.length; i++)
        {
            buttons[i] = new Button(String.format("  %d  ", i + 1));
        }

        this.add(lblBoodschap, 0, 0, buttons.length, 1);
        Button btnStop = new Button("Stop");
        this.add(btnStop, 0, 2, buttons.length, 1);
        btnStop.setMaxWidth(Double.MAX_VALUE);

        for (int i = 0; i < buttons.length; i++)
        {
            this.add(buttons[i], i, 1);
        }

        this.setAlignment(Pos.CENTER);

        for (Button button : buttons)
        {
            button.setOnAction(new EventHandler<ActionEvent>()
            {

                @Override
                public void handle(ActionEvent event)
                {
                    lblBoodschap.setText(String.format("Geklikt op %s", ((Button) event.getSource()).getText().trim()));
                }

            });
        }

        btnStop.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Bevestig");
                alert.setContentText("Wil je de applicatie afsluiten?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK)
                {
                    System.out.println("We sluiten het venster en dus... ook de applicatie");
                    Platform.exit();
                } else // Cancel
                {
                    event.consume();
                }

            }

        });
    }

}
