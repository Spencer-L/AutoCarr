package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PlayField {
    //fields
    Pane body = new Pane();
    double [] screenDimensions;
    double [] bodyDimensions;

    //constructor
    public PlayField(){
        screenDimensions= GlobalVariable.screenDimensions;
        bodyDimensions=new double[]{screenDimensions[0]*0.9,screenDimensions[1]*0.7};
        Rectangle base = new Rectangle(bodyDimensions[0],bodyDimensions[1]);
        base.setFill(Color.PURPLE);
        body.getChildren().add(base);
    }

    //setter/getter
    public Pane getBody(){return body;}
    public double[] getBodyDimensions(){return bodyDimensions;}
    //methods
}
