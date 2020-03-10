package gui2;

import gui.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class DemoEventSchermControleSource extends GridPane {
    
    public DemoEventSchermControleSource() {
        
        Label lblBoodschap = new Label();
        Button btnEen = new Button("  1  ");
        Button btnTwee = new Button("  2  ");
        Button btnDrie = new Button("  3  ");
        Button btnStop = new Button("Stop");
        
        this.add(lblBoodschap, 0, 0,3,1);
        this.add(btnEen, 0, 1);
        this.add(btnTwee, 1, 1);
        this.add(btnDrie, 2, 1);
        this.add(btnStop, 0, 2, 3, 1);
        btnStop.setMaxWidth(Double.MAX_VALUE);
        
        this.setAlignment(Pos.CENTER);
        
        btnEen.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                lblBoodschap.setText("Geklikt op 1.");
            }
            
        });
        
        btnTwee.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                lblBoodschap.setText("Geklikt op 2.");
            }
            
        });
        
        btnDrie.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                lblBoodschap.setText("Geklikt op 3.");
            }
            
        });
    }
    
}
