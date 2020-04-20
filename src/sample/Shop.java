package sample;

import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Shop {
    Pane body = new Pane();
    double [] dimensions;
    Rectangle base;
    public Shop(double[] dimen){
        dimensions=dimen;
        base = new Rectangle(dimensions[0],dimensions[1]/6);
        base.setFill(Color.GREEN);
        body.getChildren().add(base);
    }
    public Pane getBody(){return body;}
}
