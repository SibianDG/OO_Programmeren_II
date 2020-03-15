package gui;

import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import domein.MijnString;

public class UnicodeScherm extends Pane
{
     
     public UnicodeScherm()
     {
        TextArea txaUnicode = new TextArea();
        txaUnicode.setText(MijnString.geefUnicodeTabel());
            
        txaUnicode.setTranslateX(10);
        txaUnicode.setTranslateY(10);
        this.getChildren().add(txaUnicode);    
  }    
}
