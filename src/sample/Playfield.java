package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Playfield {
    //fields
    Pane body = new Pane();
    double [] dimensions;
    double bodyWidth;
    double bodyHeight;

    //constructor
    public Playfield(double[] dimen){
        dimensions=dimen;
        bodyWidth=dimensions[0]*0.5;
        bodyHeight=dimensions[1]*0.5;
        Rectangle base = new Rectangle(bodyWidth,bodyHeight);
        base.setFill(Color.PURPLE);
        body.getChildren().add(base);
        //Can this be seen?
    }

    //setter/getter

    //methods
}
