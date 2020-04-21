package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GoldDisplay {
    Pane body = new Pane();
    double [] dimensions;
    double bodyWidth;
    double bodyHeight;
    public GoldDisplay(double[] dimen){
        dimensions=dimen;
        bodyWidth=dimensions[0]*0.05;
        bodyHeight=dimensions[1]*0.05;
        Rectangle base = new Rectangle(bodyWidth,bodyHeight);
        base.setFill(Color.BLUE);
        body.getChildren().add(base);
        System.out.println("Gold Display Is called");
        //So this basically means, I'm claiming this file, I just realize, when u claim this file
        //The file name will be in blue
    }
    public Pane getBody(){return body;}
}
