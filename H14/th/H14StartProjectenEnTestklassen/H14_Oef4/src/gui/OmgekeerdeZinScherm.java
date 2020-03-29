package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import domein.MijnString;
import javafx.scene.layout.VBox;

public class OmgekeerdeZinScherm extends VBox
{
    private MijnString mijnString;
    private Label lblMessage,lblInvoer;
    private TextField txfInvoer,txfKeerom, txfPalin;
    private Button btnKeerom, btnPalin;

    public OmgekeerdeZinScherm()
    {
        this.setAlignment(Pos.CENTER_LEFT);
        this.setSpacing(10);
        this.setPadding(new Insets(25, 25, 25, 25));

        lblInvoer = new Label("GEEF INVOERSTRING: ");
        txfInvoer = new TextField();
        btnKeerom = new Button("KEER OM");
        txfKeerom = new TextField();
        btnPalin = new Button("IS PALINDROOM");
        txfPalin = new TextField();

        this.getChildren().addAll(lblInvoer, txfInvoer,btnKeerom,txfKeerom,btnPalin,txfPalin);

        lblMessage = new Label("Gelieve eerst een zin in te voeren");
        lblMessage.setVisible(false);
        this.getChildren().add(lblMessage);

        btnKeerom.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent evt)
            {
                lblMessage.setVisible(false);
                try
                {
                    mijnString = new MijnString(txfInvoer.getText());
                    txfKeerom.setText(mijnString.keerOm());
                }
                catch (NullPointerException | IllegalArgumentException | StringIndexOutOfBoundsException e )
                {
                    lblMessage.setVisible(true);
                    reset();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
        });

        btnPalin.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent evt)
            {
                lblMessage.setVisible(false);

                try
                {
                    mijnString = new MijnString(txfInvoer.getText());
                    txfPalin.setText ( mijnString.isPalindroom()?
                            "is een palindroom": "is geen palindroom");
                }
                catch (NullPointerException | IllegalArgumentException | StringIndexOutOfBoundsException e )
                {
                    lblMessage.setVisible(true);
                    reset();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
        });
    }

    private void reset()
    {
        txfInvoer.setText("");
        txfKeerom.setText("");
        txfPalin.setText("");
    }
}
