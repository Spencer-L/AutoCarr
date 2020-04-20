package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GoldDisplay {
    Pane body = new Pane();
    double bodySize;

    public GoldDisplay(double size){
        bodySize=size/8;
        Rectangle base = new Rectangle(size/8,size/8);
        //base.setFill(Color.BLUE);
        body.getChildren().add(base);
        System.out.println("Gold Display Is called");
        //So this basically means, I'm claiming this file, I just realize, when u claim this file
        //The file name will be in blue
    }
    public Pane getBody(){return body;}
}
