package sample;

import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Shop {
    //fields
    Pane body = new Pane();
    Rectangle base;
    private double [] screenDimensions;
    private double [] bodyDimensions;
    //constructor
    public Shop(){
        screenDimensions=GlobalVariable.screenDimensions;
        bodyDimensions=new double[]{screenDimensions[0]*1,screenDimensions[1]*0.16};
        base = new Rectangle(bodyDimensions[0],bodyDimensions[1]);
        base.setFill(Color.LIGHTGREEN);
        body.getChildren().add(base);
    }
    //setter/getter
    public Pane getBody(){return body;}
    public double[] getBodyDimensions(){return bodyDimensions;}
    public void setBodyDimensions(double[] bD) {
        bodyDimensions = bD;
        base.setWidth(bD[0]);
        base.setHeight(bD[1]);
    }
    //methods
}
