package sample;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectPiece extends Piece{
    private Rectangle base;
    RectPiece(double s,double h, String id,MainGame mG,PlayField pF,int tN,double[] pos,Deck pD){
        super(s,h,id,mG,pF,tN,pos,pD);
        base=new Rectangle(0,0,getSize(),getSize());
        if(getTeamNum()==1){
            base.setFill(Color.VIOLET);
        }else if(getTeamNum()==2){
            base.setFill(Color.BROWN);
        }

        getBody().getChildren().add(base);
        getBody().getChildren().add(getHealthPoints());
        getBody().getChildren().add(getRarityBand());
        getBody().getChildren().add(getLevels());

    }
}
