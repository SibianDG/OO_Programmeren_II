package gui;

import domein.DomeinController;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;

public class VeelhoekScherm extends BorderPane {

    private DomeinController dc;
    private OverzichtScherm os;

    public VeelhoekScherm(DomeinController dc) {
        this.dc = dc;
        os = new OverzichtScherm();
        buildGui();
    }

    private void buildGui(){
        MenuBar menuBar = new MenuBar();
        Menu menu1 = new Menu("Overzicht");
        Menu menu2 = new Menu("Voeg Toe");
        menuBar.getMenus().add(menu1);
        menuBar.getMenus().add(menu2);
        this.getChildren().addAll(menuBar);
        this.setLeft(this);
    }

    protected void toonOverzicht(){

    }
}
