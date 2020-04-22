package sample;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Stack;

public abstract class Piece {
    //fields
    private StackPane body;
    private double size;
    private Box parentBox;
    //constructor
    Piece(double s,Box pB){
        size=s*0.5;
        body=new StackPane();
        body.setPrefSize(s,s);
        parentBox=pB;
        pB.getBody().getChildren().add(body);
    }
    //setter/getter
    public double getSize(){return size;}
    public StackPane getBody(){return body;}
    public void setBody(StackPane sP){body=sP;}
    public Box getParentBox(){return parentBox;}
    public void setParentBox(Box pB){parentBox=pB;}
    //public methods

    //private methods
}
