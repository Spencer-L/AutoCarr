package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GoldDisplay {
    //fields
    Pane body = new Pane();
    double [] dimensions;
    double bodyWidth;
    double bodyHeight;
    //constructor
    public GoldDisplay(double[] dimen){
        dimensions=dimen;
        bodyWidth=dimensions[0]*0.15;
        bodyHeight=dimensions[1]*0.05;
        Rectangle base = new Rectangle(bodyWidth,bodyHeight);
        base.setFill(Color.BLUE);
        body.getChildren().add(base);
        System.out.println("Gold Display Is called");
    }
    //setter/getter
    public Pane getBody(){return body;}
    //methods

}
