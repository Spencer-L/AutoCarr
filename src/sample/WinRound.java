package sample;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Date;

public class WinRound {
    //field
    StackPane body=new StackPane();
    MainGame mainGame;
    String toWrite="Hello";
    //constructor
    WinRound(MainGame mG){
        mainGame=mG;
        System.out.println(mG.dimensions);
        //System.out.println(mG.dimensions[1]);
        body.setPrefSize(mG.dimensions[0],mG.dimensions[1]);
        Text msg=new Text();
        msg.setText(toWrite);
        msg.setFont(new Font(200));
        msg.setFill(Color.RED);
        body.getChildren().add(msg);
        //nameTag.setLayoutY(-30);
        //body.getChildren().add(nameTag);
        body.setVisible(false);
    }
    //setter/getter

    public StackPane getBody() {
        return body;
    }

    public void setToWrite(String toWrite) {
        this.toWrite = toWrite;
    }
    //public methods
    public boolean checkIfWinner(){
        PlayField pF=mainGame.pField;
        ArrayList<Piece> pieces1=new ArrayList<Piece>();
        ArrayList<Piece> pieces2=new ArrayList<Piece>();
        boolean dead1=false;
        boolean dead2=false;
        for(Piece p:pF.getPieces()) {
            if(p.getTeamNum()==1){
                pieces1.add(p);
            }else if(p.getTeamNum()==2) {
                pieces2.add(p);
            }
        }
        for(Piece p:pieces1){
            if(p.getHealth()<=0){
                dead1=true;
            }
        }
        for(Piece p:pieces2){
            if(p.getHealth()<=0){
                dead2=true;
            }
        }
        if(!dead1&&!dead2){
            return false;
        }else if(dead1&&dead2){
            displayWinner("There is a tie");
        }else if(dead1){
            displayWinner("Player 2 Wins The Round!");
        }else if(dead2){
            displayWinner("Player 1 Wins The Round!");
        }
        return true;
    }
    public void displayWinner(String msg){
        toWrite=msg;
        body.setVisible(true);
    }
    //private methods

}
