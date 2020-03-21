package sample;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Shop {
    Pane body = new Pane();
    public Shop(int size){
        Rectangle base = new Rectangle(size,size/6);
        body.getChildren().add(base);
    }
    public Pane getBody(){return body;}
}
