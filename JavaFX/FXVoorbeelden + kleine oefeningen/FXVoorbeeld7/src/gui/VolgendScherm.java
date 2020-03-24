package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class VolgendScherm extends HBox {
    
    private Label lblWelkom;
    private Button btnTerug;
    private String inlognaam;
    private LoginScherm login;

    public VolgendScherm(String inlognaam, LoginScherm login) {
        this.inlognaam = inlognaam;
        this.login = login;
        buildGui();
    }

    private void buildGui() {
        lblWelkom = new Label("Welkom " + inlognaam);
        btnTerug = new Button("Terug");
        Region spring = new Region();
        HBox.setHgrow(spring, Priority.ALWAYS);
        this.getChildren().addAll(lblWelkom,spring,btnTerug);
        
        btnTerug.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage)(getScene().getWindow());
                stage.setScene(login.getScene());
            }
        });
    }    
}
