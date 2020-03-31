package gui;

import domein.DomeinController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;


public class VeelhoekScherm extends BorderPane {

    private final DomeinController dc;
    private OverzichtScherm os;

    public VeelhoekScherm(DomeinController dc) {
        this.dc = dc;
        os = new OverzichtScherm(dc);
        buildGui();
    }

    private void buildGui(){

        MenuBar menuBar = new MenuBar();
        Menu actieMenu = new Menu("Acties");
        MenuItem overzichtMenuItem = new MenuItem("Overzicht");
        MenuItem voegToeMenuItem = new MenuItem("Voeg toe");
        menuBar.getMenus().add(actieMenu);
        actieMenu.getItems().addAll(overzichtMenuItem, voegToeMenuItem);

        this.setTop(menuBar);

        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("/images/veelhoeken.png")));
        this.setCenter(imageView);
        overzichtMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setCenter(os);
            }
        });
        voegToeMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setCenter(new VoegToeScherm(dc, VeelhoekScherm.this));
            }
        });
    }

    protected void toonOverzicht(){
        os.update();
        setCenter(os);
    }
}
