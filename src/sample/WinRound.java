package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WinRound {
    //field
    StackPane body=new StackPane();
    MainGame mainGame;
    Text msg;
    Timeline timer;
    int timerCounter;
    int seconds;
    //constructor
    WinRound(MainGame mG){
        mainGame=mG;
        timerCounter=0;
        seconds=0;
        body.setPrefSize(mG.dimensions[0],mG.dimensions[1]);
        msg=new Text();
        msg.setText("Hello");
        msg.setFont(new Font(mG.dimensions[0]*0.0732));
        msg.setFill(Color.RED);
        body.getChildren().add(msg);
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
            mainGame.getPlayers().get(0).setMoney(mainGame.getPlayers().get(0).getMoney()+2);
            mainGame.getPlayers().get(1).setMoney(mainGame.getPlayers().get(1).getMoney()+2);
            mainGame.getPlayers().get(0).generateInterest();
            mainGame.getPlayers().get(1).generateInterest();
            mainGame.getGoldDisplay().updateMoney(1);
            mainGame.getGoldDisplay().updateMoney(2);
        }else if(dead1){
            displayWinner("Player 2 Wins The Round!");
            mainGame.getPlayers().get(0).setMoney(mainGame.getPlayers().get(0).getMoney()+1);
            mainGame.getPlayers().get(1).setMoney(mainGame.getPlayers().get(1).getMoney()+2);
            int num=0;
            for(Piece p:pieces2){
                num+=p.getRarity();
            }
            mainGame.getPlayers().get(0).setHP(mainGame.getPlayers().get(0).getHP()-((mainGame.getTurn()+1)/3+(num/2)));
            mainGame.getPlayers().get(0).generateInterest();
            mainGame.getPlayers().get(1).generateInterest();
            mainGame.getGoldDisplay().updateMoney(1);
            mainGame.getGoldDisplay().updateMoney(2);
            mainGame.getGoldDisplay().updateHP(1);
        }else if(dead2){
            displayWinner("Player 1 Wins The Round!");
            mainGame.getPlayers().get(0).setMoney(mainGame.getPlayers().get(0).getMoney()+2);
            mainGame.getPlayers().get(1).setMoney(mainGame.getPlayers().get(1).getMoney()+1);
            int num=0;
            for(Piece p:pieces1){
                num+=(p.getRarity()+1);
            }
            mainGame.getPlayers().get(1).setHP(mainGame.getPlayers().get(1).getHP()-((mainGame.getTurn()+1)/3+(num/2)));
            mainGame.getPlayers().get(0).generateInterest();
            mainGame.getPlayers().get(1).generateInterest();
            mainGame.getGoldDisplay().updateMoney(1);
            mainGame.getGoldDisplay().updateMoney(2);
            mainGame.getGoldDisplay().updateHP(2);
        }
        return true;
    }
    //private methods
    private void displayWinner(String msg){// throws InterruptedException {
        setToWrite(msg);
        mainGame.getWrapper().getChildren().remove(body);
        mainGame.getWrapper().getChildren().add(body);
        body.setVisible(true);
        timer = new Timeline(new KeyFrame(Duration.millis(40), ae -> doCount(3)));
        timer.setCycleCount(Animation.INDEFINITE);
        timer.play();
    }
    private void doCount(int numSec){
        if (timerCounter < 30) timerCounter++;
        else{
            seconds++;
            timerCounter=0;
            if(seconds==numSec){
                body.setVisible(false);
                seconds=0;
                timer.stop();
                checkIfEndGame();
            }
        }
    }
    private void checkIfEndGame(){
        boolean loose1=mainGame.players.get(0).getHP()<=0;
        boolean loose2=mainGame.players.get(1).getHP()<=0;
        if(loose1&&loose2){
            displayWinner("There Is A Tie");
        }else if(loose1){
            displayWinner("Player 2 Has Won the Game!");
        }else if(loose2){
            displayWinner("Player 1 Has Won the Game!");
        }
    }
}
