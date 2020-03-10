package gui;

import java.security.SecureRandom;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class MenuScherm extends BorderPane
{
    private Pane middenPaneel;
    private final SecureRandom random = new SecureRandom();

    public MenuScherm()
    {
//Menu maken
        MenuBar menuBar = new MenuBar();
        this.setTop(menuBar);

// File menu - About, Exit
        Menu fileMenu = new Menu("File");
        MenuItem aboutMenuItem = new MenuItem("About");
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+x"));

        aboutMenuItem.setOnAction(this::aboutClicked);
        exitMenuItem.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e)
            {
                Platform.exit();
            }
        });

        fileMenu.getItems().addAll(aboutMenuItem, new SeparatorMenuItem(), exitMenuItem);
        menuBar.getMenus().add(fileMenu);

// Shape menu - Line, Rectangular
        Menu shapeMenu = new Menu("Shape");
        MenuItem lineMenuItem = new MenuItem("Line");
        MenuItem rectangularMenuItem = new MenuItem("Rectangular");

        lineMenuItem.setOnAction(this::lineClicked);
        rectangularMenuItem.setOnAction(this::rectangularClicked);

        shapeMenu.getItems().addAll(lineMenuItem, rectangularMenuItem);
        menuBar.getMenus().add(shapeMenu);

//Middenpaneel
        middenPaneel = new Pane();
        middenPaneel.setStyle("-fx-background-color: rgb(255,0,0)");
        this.setCenter(middenPaneel);

//Toolbar        
        Button btnRed = new Button("Red");
        btnRed.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent evt)
            {
                middenPaneel.setStyle("-fx-background-color: rgb(255,0,0)");
            }
        });
        Button btnGreen = new Button("Green");
        btnGreen.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent evt)
            {
                middenPaneel.setStyle("-fx-background-color: rgb(0,255,0)");
            }
        });
        Button btnBlue = new Button("Blue");
        btnBlue.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent evt)
            {
                middenPaneel.setStyle("-fx-background-color: rgb(0,0,255)");
            }
        });

        ToolBar toolBar = new ToolBar(new Label("Background color: "),
                btnRed, btnGreen, btnBlue);
        toolBar.setOrientation(Orientation.HORIZONTAL);
        this.setBottom(toolBar);

    }
    
      public void aboutClicked (ActionEvent e) {
                
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText(null);
        alert.setContentText("Program version 1.0\nMade by me");
        alert.showAndWait();
    }

    public void lineClicked(ActionEvent e){
// lijn van startpunt (x1,y1) tot eindpunt (x2,y2)
        int x1 = random.nextInt(600);
        int y1 = random.nextInt(300);
        int x2 = random.nextInt(600-x1);
        int y2 = random.nextInt(300-y1);
        Line line = new Line(x1,y1,x2,y2);
        middenPaneel.getChildren().add(line) ;  
    }
    
    public void rectangularClicked(ActionEvent e){
//rechthoek met x, y, width, height   
        int x = random.nextInt(600);
        int y = random.nextInt(300);
        int width = random.nextInt(600-x);
        int height = random.nextInt(300-y);
        Rectangle rectangle = new Rectangle(x,y,width,height);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        rectangle.setStrokeWidth(5);
        middenPaneel.getChildren().add(rectangle);  
    }
}
