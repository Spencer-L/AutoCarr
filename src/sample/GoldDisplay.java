package sample;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class GoldDisplay {
    Pane body = new Pane();

    public GoldDisplay(int size){
        Rectangle base = new Rectangle(size/8,size/2);
        body.getChildren().add(base);
    }
    public Pane getBody(){return body;}
}
