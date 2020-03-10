package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class ActionEventAfhandeling implements EventHandler<ActionEvent>
{
    private final Label lblBoodschap;

    public ActionEventAfhandeling(Label lblBoodschap)
    {
        this.lblBoodschap = lblBoodschap;
    }

    @Override
    public void handle(ActionEvent event)
    {
        lblBoodschap.setText("Geklikt");
    }
}
