package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.ArrayList;

public class Deck {
    //fields
    private Pane body = new Pane();
    private Rectangle base;
    private double[] screenDimensions;
    private double [] bodyDimensions;
    private ArrayList<Piece> pieces=new ArrayList<Piece>();
    private ArrayList<double[]> slots=new ArrayList<double[]>();
    private ArrayList<Piece> piecesInDock=new ArrayList<Piece>();
    private Player player;
    private MainGame mainGame;
    private PlayField playField;
    private int teamNum;
    //constructor
    public Deck(Player p){
        screenDimensions= GlobalVariable.screenDimensions;
        bodyDimensions=new double[]{screenDimensions[0]*1,screenDimensions[1]*0.14};
        base = new Rectangle(bodyDimensions[0],bodyDimensions[1]);
        base.setFill(Color.ORANGE);
        body.getChildren().add(base);
        player=p;
        mainGame=player.getMainGame();
        playField=player.getPlayField();
        teamNum=player.getTeamNum();
        createPieces();
    }
    public Deck(){
        screenDimensions= GlobalVariable.screenDimensions;
        bodyDimensions=new double[]{screenDimensions[0]*1,screenDimensions[1]*0.14};
        base = new Rectangle(bodyDimensions[0],bodyDimensions[1]);
        base.setFill(Color.ORANGE);
        body.getChildren().add(base);
    }
    //setter/getter
    public Pane getBody(){return body;}
    public double[] getBodyDimensions(){return bodyDimensions;}
    public void setBodyDimensions(double[] bD) {
        bodyDimensions = bD;
        base.setWidth(bD[0]);
        base.setHeight(bD[1]);
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }
    //public methods
    public void movePieces(){
        for(int i=0;i<=5;i++){
            double pieceSize=getPieces().get(0).getSize();
            slots.add(new double[]{getBody().getLayoutX()+pieceSize/2*(3*i)+pieceSize/2,
                    getBody().getLayoutY()+getPieces().get(0).getSize()/2,0});
        }
        for(int i=0;i<getPieces().size();i++){
            getPieces().get(i).getBody().setLayoutX(slots.get(i)[0]);
            getPieces().get(i).getBody().setLayoutY(slots.get(i)[1]);
            slots.get(i)[2]=1;
        }
    }
    public void glow(){
        base.setFill(Color.DARKORANGE);
    }
    public void notGlow(){
        base.setFill(Color.ORANGE);
    }
    public void fieldToDeck(Piece p){
        int index=piecesInDock.size();
        piecesInDock.add(p);
        p.setParentBox(null);
        p.getBody().setLayoutX(slots.get(index)[0]);
        p.getBody().setLayoutY(slots.get(index)[1]);
    }
    public void fieldToField(Piece p){

    }
    public void deckToField(Piece p){
        int index=0;
        for(int i=0;i<piecesInDock.size();i++){
            index=piecesInDock.indexOf(p);
            slots.get(index)[2]=0;
            piecesInDock.remove(p);
        }
        movePiecesLeft(index);
    }
    public void deckToDeck(Piece p){
        int index=piecesInDock.indexOf(p);
        p.getBody().setLayoutX(slots.get(index)[0]);
        p.getBody().setLayoutY(slots.get(index)[1]);
        if(piecesInDock.indexOf(p)!=-1){
            piecesInDock.add(p);
        }
    }
    public void showDeck(){
        getBody().setVisible(true);
        for(Piece p:piecesInDock){
            p.getBody().setVisible(true);
        }
        System.out.println(player.getTeamNum()+" deck should be displayed");
    }
    public void hideDeck(){
        getBody().setVisible(false);
        for(Piece p:piecesInDock){
            p.getBody().setVisible(false);
        }
        System.out.println(player.getTeamNum()+" deck should be hidden");
    }
    //private methods
    private void createPieces(){
        ArrayList<Box> boxes=playField.getBoxes();
        double boxSize=playField.getBoxSize();
        RectPiece tempPiece=new RectPiece(boxSize*0.5,100,"Rect1",mainGame,playField,teamNum,new double[]{0,0},this);
        RectPiece tempPiece2=new RectPiece(boxSize*0.5,100,"Rect2",mainGame,playField,teamNum,new double[]{0,0},this);
        pieces.add(tempPiece);
        pieces.add(tempPiece2);
        for(Piece p:pieces){
            if(!p.getOnField()){
                piecesInDock.add(p);
            }
        }
    }
    private void movePiecesLeft(int index){
        double diff=slots.get(1)[0]-slots.get(0)[0];
        for(int i=index;i<piecesInDock.size();i++){
            double cycleCount=10;
            int tempI=i;
            piecesInDock.get(i).setTL(new Timeline(new KeyFrame(Duration.millis(30),ae->shuffleLeft(tempI,diff/cycleCount))));
            piecesInDock.get(i).getTL().setCycleCount((int)cycleCount);
            piecesInDock.get(i).getTL().play();
        }
    }
    private void shuffleLeft(int index,double distance){
        Piece p=piecesInDock.get(index);
        p.getBody().setLayoutX(p.getBody().getLayoutX()-distance);
        System.out.println("shuffling left");
    }
}
