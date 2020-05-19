package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class HexPiece extends Piece{
    private Polygon base;
    HexPiece(double s,double h, String id,MainGame mG,PlayField pF,int tN,double[] pos,Deck pD){
        super(s,h,id,mG,pF,tN,pos,pD);
        base=new Polygon();
        base.getPoints().addAll(
                0.0, 0.0,
                s, 0.0,
                s+(s/2), s*0.866,
                s, s*0.866*2,
                0.0, s*0.866*2,
                0-s/2, s*0.866
        );
        if(getTeamNum()==1){
            base.setFill(Color.VIOLET);
        }else if(getTeamNum()==2){
            base.setFill(Color.BROWN);
        }

        getBody().getChildren().add(base);
    }
}
