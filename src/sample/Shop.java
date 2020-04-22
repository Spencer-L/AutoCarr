package sample;

import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Shop {
    //fields
    Pane body = new Pane();
    Rectangle base;
    double [] screenDimensions;
    double [] bodyDimensions;
    //constructor
    public Shop(){
        screenDimensions=GlobalVariable.screenDimensions;
        bodyDimensions=new double[]{screenDimensions[0]*1,screenDimensions[1]*0.16};
        base = new Rectangle(bodyDimensions[0],bodyDimensions[1]);
        base.setFill(Color.GREEN);
        body.getChildren().add(base);
    }
    //setter/getter
    public Pane getBody(){return body;}
    public double[] getBodyDimensions(){return bodyDimensions;}
    //methods
}
