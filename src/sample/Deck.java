package sample;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Deck {
    //fields
    Pane body = new Pane();
    Rectangle base;
    double[] screenDimensions;
    double [] bodyDimensions;
    ArrayList<Piece> pieces;
    //constructor
    public Deck(ArrayList<Piece> p){
        screenDimensions= GlobalVariable.screenDimensions;
        bodyDimensions=new double[]{screenDimensions[0]*1,screenDimensions[1]*0.14};
        base = new Rectangle(bodyDimensions[0],bodyDimensions[1]);
        base.setFill(Color.PINK);
        body.getChildren().add(base);
        pieces=p;
    }
    public Deck(){
        screenDimensions= GlobalVariable.screenDimensions;
        bodyDimensions=new double[]{screenDimensions[0]*1,screenDimensions[1]*0.14};
        base = new Rectangle(bodyDimensions[0],bodyDimensions[1]);
        base.setFill(Color.PINK);
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
