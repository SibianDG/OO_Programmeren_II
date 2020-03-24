package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

         
// Het hoofdScherm is opgebouwd met een GridPane
// Dit is de meest flexibele van alle layout panes maar ook de meest complexe
public class HoofdScherm extends GridPane
{
// Dit zijn de aparte vensters voor de verschillende demo's
    private Demo1HBox hBoxDemo1;
    private Demo2HBox hBoxDemo2;
    private DemoFlowPane flowPaneDemo;
    private DemoBorderPane borderPaneDemo;

    public HoofdScherm()
    {
        hBoxDemo1 = new Demo1HBox();
        hBoxDemo2 = new Demo2HBox();
        flowPaneDemo = new DemoFlowPane();
        borderPaneDemo = new DemoBorderPane();
        
        this.setPadding(new Insets(10));
        this.setHgap(10);
        this.setVgap(10);

// Wanneer je met een GridPane werkt, kan je instellingen op 3 manieren ingeven:
// - globaal: zoals bij this.setHgap()
// - per rij of colom: met constraints zoals hieronder te zien is
// - per component: met de statische methoden uit GridPane, net zoals we dit bij HBox gezien hebben
// We maken constraints aan voor beide kolommen en geven aan dat de eerste kolom mag groeien
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.ALWAYS);
        ColumnConstraints col2 = new ColumnConstraints();
        this.getColumnConstraints().addAll(col1, col2);

// Eerste rij      
        Label lblTitle1 = new Label("HBox Demo 1");
        Button btnButton1 = new Button("Show");

// Voor het koppelen van de event handler gebruiken we hier een anonieme innerklasse
        btnButton1.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent t)
            {
                hBoxDemo1.setTitle("HBox Demo 1");
                hBoxDemo1.show();
            }
        });

// Om componenten toe te voegen aan een GridPane kan je de shortcut-methoden met de naam 'add' gebruiken
// Zo kan je de rij en kolom meteen opgeven bij het toevoegen en hoef je deze niet apart in te stellen
        this.add(lblTitle1, 0, 0);
        this.add(btnButton1, 1, 0);

// Tweede rij
        Label lblTitle2 = new Label("HBox Demo 2");
        Button btnButton2 = new Button("Show");
        btnButton2.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent t)
            {
                hBoxDemo2.setTitle("HBox Demo 2");
                hBoxDemo2.show();
            }
        });

        this.add(lblTitle2, 0, 1);
        this.add(btnButton2, 1, 1);

// Derde rij        
        Label lblTitle3 = new Label("FlowPane Demo");
        Button btnButton3 = new Button("Show");
        btnButton3.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent t)
            {
                flowPaneDemo.setTitle("FlowPane Demo");
                flowPaneDemo.show();
            }
        });

        this.add(lblTitle3, 0, 2);
        this.add(btnButton3, 1, 2);

// Vierde rij        
        Label lblTitle4 = new Label("BorderPane Demo");
        Button btnButton4 = new Button("Show");
        btnButton4.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent t)
            {
                borderPaneDemo.setTitle("BorderPane Demo");
                borderPaneDemo.show();
            }
        });

        this.add(lblTitle4, 0, 3);
        this.add(btnButton4, 1, 3);
    }

}
