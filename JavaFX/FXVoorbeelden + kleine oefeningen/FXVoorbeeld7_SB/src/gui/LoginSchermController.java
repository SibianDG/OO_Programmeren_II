package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.Optional;

import javafx.application.Platform;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class LoginSchermController extends GridPane
{
	@FXML
	private Button btnSignIn;
	@FXML
	private Button btnCancel;
	@FXML
	private TextField txfUsername;
	@FXML
	private PasswordField txfPassword;
	@FXML
	private Label lblMessage;

	
	public LoginSchermController()
	{
		super();
		try
        {
            FXMLLoader loader =
                new FXMLLoader(getClass().getResource("LoginScherm.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
	}
	// Event Listener on Button[#btnSignIn].onAction
	@FXML
	public void btnSignInAfhandeling(ActionEvent event) {
		if (txfUsername.getText().equals("") )
			lblMessage.setText("Uw username ontbreekt!");
		else
			if (txfPassword.getText().equals(""))
				lblMessage.setText("Uw paswoord ontbreekt!");
			else {
				VolgendSchermController vs = new VolgendSchermController(txfUsername.getText(), this);
				Scene scene = new Scene(vs, 300, 100);
				Stage stage = (Stage) this.getScene().getWindow();
				stage.setScene(scene);
				stage.show();
			}
	}
	// Event Listener on Button[#btnCancel].onAction
	@FXML
	public void btnCancelAfhandeling(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Bevestig");
        alert.setContentText("Wil je de applicatie afsluiten?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() != ButtonType.OK)
           event.consume();
        else
        	Platform.exit();
	}
}
