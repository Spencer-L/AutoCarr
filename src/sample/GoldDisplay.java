package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GoldDisplay {
    //fields
    Pane body = new Pane();
    double [] screenDimensions;
    double [] bodyDimensions;
    //constructor
    public GoldDisplay(){
        screenDimensions=GlobalVariable.screenDimensions;
        bodyDimensions=new double[]{screenDimensions[0]*0.1,screenDimensions[1]*0.7};
        Rectangle base = new Rectangle(bodyDimensions[0],bodyDimensions[1]);
        base.setFill(Color.BLUE);
        body.getChildren().add(base);
    }
    //setter/getter
    public Pane getBody(){return body;}
    public double[] getBodyDimensions(){return bodyDimensions;}
    //methods

}
