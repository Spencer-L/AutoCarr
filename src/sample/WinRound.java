package sample;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WinRound {
    //field
    StackPane body=new StackPane();
    MainGame mainGame;
    Text msg;
    //constructor
    WinRound(MainGame mG){
        mainGame=mG;
        //System.out.println(mG.dimensions[1]);
        body.setPrefSize(mG.dimensions[0],mG.dimensions[1]);
        msg=new Text();
        msg.setText("Hello");
        msg.setFont(new Font(mG.dimensions[0]*0.0732));
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
        msg.setText(toWrite);
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
        if(pieces1.size()==0){
            dead1=true;
        }
        if(pieces2.size()==0){
            dead2=true;
        }
        if(!dead1&&!dead2){
            return false;
        }else if(dead1&&dead2){
            displayWinner("There is a tie");
            //try {
            //    displayWinner("There is a tie");
            //} catch (InterruptedException e) {
            //    e.printStackTrace();
            //}
        }else if(dead1){
            displayWinner("Player 2 Wins The Round!");
            //try {
            //    displayWinner("Player 2 Wins The Round!");
            //} catch (InterruptedException e) {
            //    e.printStackTrace();
            //}
        }else if(dead2){
            //try {
                displayWinner("Player 1 Wins The Round!");
            //} catch (InterruptedException e) {
             //   e.printStackTrace();
            //}
        }
        return true;
    }
    public void displayWinner(String msg){// throws InterruptedException {
        setToWrite(msg);
        body.setVisible(true);
        //TimeUnit.SECONDS.sleep(3);
        //body.setVisible(false);
    }
    //private methods

}
