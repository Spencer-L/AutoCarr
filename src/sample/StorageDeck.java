package sample;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class StorageDeck {
    Pane body = new Pane();

    public StorageDeck(int size){
        Rectangle base = new Rectangle(size,size/7);
        base.setFill(Color.RED);
        body.getChildren().add(base);
    }
    public Pane getBody(){return body;}
}
