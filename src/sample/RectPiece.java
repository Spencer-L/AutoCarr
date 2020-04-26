package sample;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectPiece extends Piece{
    private Rectangle base;
    RectPiece(double s,Box pB,double h, String id,MainGame mG,PlayField pF,int tN){
        super(s,pB,h,id,mG,pF,tN);
        base=new Rectangle(0,0,getSize(),getSize());
        base.setFill(Color.VIOLET);
        getBody().getChildren().add(base);
    }
}
