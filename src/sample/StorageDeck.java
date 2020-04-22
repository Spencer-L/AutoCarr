package sample;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class StorageDeck {
    Pane body = new Pane();
    Rectangle base;
    double[] dimensions;
    public StorageDeck(double[] dimen){
        dimensions=dimen;
        base = new Rectangle(dimensions[0],dimensions[1]*0.14);
        base.setFill(Color.RED);
        body.getChildren().add(base);
    }
    public Pane getBody(){return body;}
}
