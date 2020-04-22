package sample;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectPiece extends Piece{
    private Rectangle base;
    RectPiece(double s,Box pB){
        super(s,pB);
        base=new Rectangle(0,0,getSize(),getSize());
        base.setFill(Color.VIOLET);
        getBody().getChildren().add(base);
    }
}
