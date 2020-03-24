package gui;

import domein.DomeinController;
import javafx.scene.layout.BorderPane;

public class HoofdPaneel extends BorderPane
{
    private final DomeinController controller;

    public HoofdPaneel(DomeinController controller)
    {
        this.controller = controller;
        buildGui();
    }
    
    private void buildGui()
    {

        DetailPaneel dp = new DetailPaneel(controller);
        OverzichtPaneel op = new OverzichtPaneel(controller, dp);
        this.setLeft(op);
        this.setRight(dp);
    }
}
