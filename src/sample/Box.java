package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Box {
    //fields
    private double size;
    private int ID;
    private Pane body=new Pane();
    private Rectangle base;
    //constructor
    Box(double s,int id){
        size=s;
        ID=id;
        base=new Rectangle(id%10*s,id/10*s,s,s);
        base.setFill(Color.BISQUE);
        base.setStroke(Color.BLACK);
        base.setStrokeWidth(size*0.0186);
        body.getChildren().add(base);
    }
    //setter/getter

    public Pane getBody() {
        return body;
    }

    //methods
}
