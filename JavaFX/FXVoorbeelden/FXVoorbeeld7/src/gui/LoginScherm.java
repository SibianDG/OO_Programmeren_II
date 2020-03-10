package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import static javafx.scene.layout.GridPane.setHalignment;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LoginScherm extends GridPane {
// Dit attribuut hebben we in meerdere methoden nodig

    private Label lblMessage;
    private TextField txfUser;

    public LoginScherm() {
        // Aligneert grid in het midden        
        this.setAlignment(Pos.BOTTOM_LEFT);
// Vrije ruimte tussen kolommen        
        this.setHgap(10);
// Vrije ruimte tussen rijen        
        this.setVgap(10);

// Vrije ruimte rond de randen van de grid (boven, rechts, onder, links)        
        this.setPadding(new Insets(25, 25, 25, 25));

        Label lblTitle = new Label("Welcome");
        lblTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

// Bij GridPane kan in elke cel een component geplaatst worden
// Een component kan over meerdere rijen en/of kolommen geplaatst worden 
// De label wordt hier over 2 kolommen en 1 rij geplaatst        
        this.add(lblTitle, 0, 0, 2, 1);

        Label lblUserName = new Label("User Name:");
        this.add(lblUserName, 0, 1);

        txfUser = new TextField();
        this.add(txfUser, 1, 1);

        Label lblPassword = new Label("Password:");
        this.add(lblPassword, 0, 2);

        PasswordField pwfPassword = new PasswordField();
        this.add(pwfPassword, 1, 2);

        Tooltip tooltip = new Tooltip();
        tooltip.setText(
                "Your password must be\n"
                + "at least 8 characters in length\n"
        );
        pwfPassword.setTooltip(tooltip);

        Button btnSignIn = new Button("Sign in");
// We aligneren btnSignIn links
        setHalignment(btnSignIn, HPos.LEFT);
        this.add(btnSignIn, 0, 4);

        Button btnCancel = new Button("Cancel");
// We aligneren btnCancel rechts
        setHalignment(btnCancel, HPos.RIGHT);
        this.add(btnCancel, 1, 4);

        Hyperlink linkForgot = new Hyperlink("Forgot password");
        this.add(linkForgot, 0, 5, 2, 1);

        lblMessage = new Label();
        this.add(lblMessage, 1, 6);

// We koppelen een event handler aan de knop Sign In
// We gebruiker hiervoor method reference        
        btnSignIn.setOnAction(this::buttonPushed);

// We koppelen een event handler aan de knop Cancel
// We gebruiken hiervoor een lambda expressie
        btnCancel.setOnAction(evt -> lblMessage.setText("Cancel button pressed")
        );

// We koppelen een event handler aan de hyperlink
// We gebruiken hiervoor een anonieme innerklasse
        linkForgot.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent evt) {
                lblMessage.setText("Hyperlink clicked");
            }
        });

    }

    // Event-afhandeling: wat er moet gebeuren als we op de knop Sign in klikken
    private void buttonPushed(ActionEvent event) {
        lblMessage.setText("Sign in button pressed");

        //We bouwen een nieuw scherm op waarmee we een scene maken
        //Parameter 1: naam gebruiker (ingevuld op loginscherm), willen we tonen op volgend scherm
        //Parameter 2: this, volgend scherm krijgt het huidige scherm mee om gemakkelijk te kunnen terugkeren.
        VolgendScherm vs = new VolgendScherm(txfUser.getText(), this);
        Scene scene = new Scene(vs, 200, 50);
        Stage stage = (Stage) this.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
