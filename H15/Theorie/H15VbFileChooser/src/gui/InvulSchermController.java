package gui;

import domein.DomeinController;
import java.io.File;
import java.io.IOException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 */
public class InvulSchermController extends GridPane
{
    @FXML
    private TextArea txaTekst;
    @FXML
    private Button btnBewaar;
    @FXML
    private Button btnHaalTekstOp;
    @FXML
    private Button btnReset;

    private DomeinController dc;

    public InvulSchermController(DomeinController dc)
    {
        this.dc = dc;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("InvulScherm.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try
        {
            loader.load();
        } catch (IOException ex)
        {
            throw new RuntimeException(ex);
        }
    }

    @FXML
    private void btnBewaarOnAction(ActionEvent event)
    {
        FileChooser fileChooser = new FileChooser();

        //fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        // OF :
        fileChooser.setInitialDirectory(new File("c:\\"));
        // OF : 1. Path bestandLocatie =  Paths.get(System.getProperty("user.home")); 
       
        // EN : 2. fileChooser.setInitialDirectory(bestandLocatie.toFile());
 
        File gekozenBestand = fileChooser.showSaveDialog(null);
      
        String input = txaTekst.getText();
        if (input != null && !input.equals(""))
            dc.bewaarTekst(txaTekst.getText(), gekozenBestand);
    }

    @FXML
    private void btnHaalTekstOp(ActionEvent event)
    {
        FileChooser fileChooser = new FileChooser();
        File gekozenBestand = fileChooser.showOpenDialog(null);
        String tekst = dc.haalTekstOp(gekozenBestand);
        txaTekst.setText(tekst);
    }

    @FXML
    private void btnResetOnAction(ActionEvent event)
    {
        txaTekst.setText("");
    }

}
