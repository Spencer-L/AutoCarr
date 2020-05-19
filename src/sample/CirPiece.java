package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CirPiece extends Piece{
    private Circle base;
    CirPiece(double s,double h, String id,MainGame mG,PlayField pF,int tN,double[] pos,Deck pD){
        super(s,h,id,mG,pF,tN,pos,pD);
        base=new Circle(0,0,getSize());
        if(getTeamNum()==1){
            base.setFill(Color.VIOLET);
        }else if(getTeamNum()==2){
            base.setFill(Color.BROWN);
        }

        getBody().getChildren().add(base);
    }
}
