package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class DemoEventScherm extends GridPane
{
    public DemoEventScherm()
    {
        Label lblBoodschap = new Label();
        Button btnKlik = new Button("Klik");

        this.add(lblBoodschap, 0, 0);
        this.add(btnKlik, 0, 1);

        this.setAlignment(Pos.CENTER);

        ActionEventAfhandeling eafh = new ActionEventAfhandeling(lblBoodschap);
        btnKlik.setOnAction(eafh);
        
        MouseEventAfhandeling mafh = new MouseEventAfhandeling();
        this.setOnMouseClicked(mafh);
    }

}
