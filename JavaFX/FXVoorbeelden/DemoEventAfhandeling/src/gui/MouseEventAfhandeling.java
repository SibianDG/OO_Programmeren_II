package gui;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MouseEventAfhandeling implements EventHandler<MouseEvent>
{   
    @Override
    public void handle(MouseEvent event)
    {
        System.out.println("x = " + event.getSceneX());
        System.out.println("y = " + event.getSceneY());
    }  
}
