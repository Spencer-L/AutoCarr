package sample;

import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

//priest class
public class PentPiece extends Piece {
    private Polygon base;
    PentPiece(double s,double h, String id,MainGame mG,PlayField pF,int tN,double[] pos,Deck pD){
        super(s,h,id,mG,pF,tN,pos,pD);
        setHealth(getHealth()+120);
        setMaxHealth((int)getHealth());
        setAtkSpd(1.5);
        setDamage(getDamage()+5);
        setRange(5);
        setRangeFactor(0.43);
        base=new Polygon();
        base.getPoints().addAll(
                0.0, 0.0,
                s, 0.0,
                s+(0.309*s), s*0.951,
                s/2, s*0.951 + s*0.588,
                0-(0.309*s), s*0.951
        );
        if(getTeamNum()==1){
            base.setFill(Color.VIOLET);
        }else if(getTeamNum()==2){
            base.setFill(Color.BROWN);
        }

        getBody().getChildren().add(base);
        getBody().setAlignment(getRarityBand(), Pos.TOP_CENTER);
        getBody().getChildren().add(getRarityBand());
        getBody().getChildren().add((getLevels()));
        getBody().setAlignment(getHealthBarRed(), Pos.BOTTOM_CENTER);
        getBody().getChildren().add(getHealthBarRed());
        setRangeBox(makeRangeBox());
    }


    //polymorphic constructor for level ups
    PentPiece(int r,int l,double s,double h, String id,MainGame mG,PlayField pF,int tN,double[] pos,Deck pD){
        super(r,l,s,h,id,mG,pF,tN,pos,pD);
        setHealth(getHealth()+120);
        setMaxHealth((int)getHealth());
        setAtkSpd(1.5);
        setDamage(getDamage()+5);
        setRange(5);
        setRangeFactor(0.43);
        base=new Polygon();
        base.getPoints().addAll(
                0.0, 0.0,
                s, 0.0,
                s+(0.309*s), s*0.951,
                s/2, s*0.951 + s*0.588,
                0-(0.309*s), s*0.951
        );
        if(getTeamNum()==1){
            base.setFill(Color.VIOLET);
        }else if(getTeamNum()==2){
            base.setFill(Color.BROWN);
        }

        getBody().getChildren().add(base);
        getBody().setAlignment(getRarityBand(), Pos.TOP_CENTER);
        getBody().getChildren().add(getRarityBand());
        getBody().getChildren().add((getLevels()));
        getBody().setAlignment(getHealthBarRed(), Pos.BOTTOM_CENTER);
        getBody().getChildren().add(getHealthBarRed());
        setRangeBox(makeRangeBox());
    }

}
