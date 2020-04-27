package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Stack;

public abstract class Piece {
    //fields
    private StackPane body;
    private double size;
    private Box parentBox;
    private double health;
    private String ID;
    private double[] overallPosition;
    boolean isDragging=false;
    private MainGame mainGame;
    private PlayField playField;
    private int teamNum;
    private Piece target;
    private Timeline tL;
    private boolean onField=false;
    private Deck parentDeck;
    //constructor
    Piece(double s,double h, String id,MainGame mG,PlayField pF,int tN,double[] pos,Deck pD){
        mainGame=mG;
        playField=pF;
        parentDeck=pD;
        size=s;
        teamNum=tN;
        body=new StackPane();
        body.setPrefSize(s,s);
        parentBox=null;
        body.addEventHandler(MouseEvent.MOUSE_DRAGGED,event -> dragPiece(event));
        body.addEventHandler(MouseEvent.MOUSE_RELEASED,event -> releasePiece(event));
        health=h;
        ID=id;
        body.setLayoutX(pos[0]);
        body.setLayoutY(pos[1]);
        overallPosition=findPosition();
    }
    //setter/getter
    public double getSize(){
        return size;
    }
    public StackPane getBody(){
        return body;
    }
    public void setBody(StackPane sP){
        body=sP;
    }
    public Box getParentBox(){
        return parentBox;
    }
    public void setParentBox(Box pB){parentBox=pB;}
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getID() {
        return ID;
    }
    public double getHealth() {
        return health;
    }
    public void setHealth(double health) {
        this.health = health;
    }

    public int getTeamNum() {
        return teamNum;
    }

    public double[] getOverallPosition() {
        return overallPosition;
    }
    public boolean getOnField(){
        return onField;
    }

    public void setOnField(boolean onField) {
        this.onField = onField;
    }

    public Timeline getTL() {
        return tL;
    }

    public void setTL(Timeline tL) {
        this.tL = tL;
    }

    //public methods
    protected void dragPiece(MouseEvent e){
        body.setLayoutX(e.getSceneX()-(size/2));
        body.setLayoutY(e.getSceneY()-(size/2));
        for (Box b:playField.getBoxes()) {
            b.notGlow();
        }
        parentDeck.notGlow();
        if(body.getLayoutY()>playField.getBodyDimensions()[1]){
            parentDeck.glow();
        }else{
            Box tempParent=findClosestBox();
            tempParent.glow();
        }

    }
    protected Box findClosestBox(){
        double minDiff=Double.MAX_VALUE;
        int boxCount=0;
        for(int i=0;i<playField.getBoxes().size();i++){
            Box b=playField.getBoxes().get(i);
            double centerX=getBody().getLayoutX()+(size/2);
            double centerY=getBody().getLayoutY()+(size/2);
            double centerBoxX=b.getBody().getLayoutX()+(b.getSize()/2)+mainGame.gDisplay.getBodyDimensions()[0];
            double centerBoxY=b.getBody().getLayoutY()+(b.getSize()/2);
            double diffX=centerX-centerBoxX;
            double diffY=centerY-centerBoxY;
            double diff=Math.sqrt(Math.pow(diffX,2)+Math.pow(diffY,2));
            if(diff<minDiff){
                minDiff=diff;
                boxCount=i;
            }
        }
        return playField.getBoxes().get(boxCount);
    }
    protected void releasePiece(MouseEvent e){
        isDragging=false;
        if(body.getLayoutY()>playField.getBodyDimensions()[1]){
            parentBox=null;
            if(onField){
                onField=false;
                parentDeck.placePieceInDeck(this);
            }else{
                parentDeck.deckToDeck(this);
            }
            System.out.println("Should go back in deck");
        }else{
            parentBox=findClosestBox();
            onField=true;
            parentDeck.placePieceInField(this);
            reposition();
            parentBox.notGlow();
        }
    }
    protected  double[] findPosition(){
        //double xCord=parentBox.getBody().getLayoutX()+mainGame.gDisplay.getBodyDimensions()[0]+(getSize()/2);
        //double yCord=parentBox.getBody().getLayoutY()+(getSize()/2);
        //return new double[]{xCord,yCord};
        return new double[]{getBody().getLayoutX(),getBody().getLayoutY()};
    }
    protected Piece findClosestEnemy(ArrayList<Piece> allPieces){
        double minDiff=Double.MAX_VALUE;
        int boxCount=-1;
        for(int i=0;i<allPieces.size();i++){
            Piece p=allPieces.get(i);
            if(p!=this&&p.getTeamNum()!=getTeamNum()) {
                double centerX = getBody().getLayoutX() + (size / 2);
                double centerY = getBody().getLayoutY() + (size / 2);
                double centerBoxX = p.getBody().getLayoutX() + (p.getSize() / 2);
                double centerBoxY = p.getBody().getLayoutY() + (p.getSize() / 2);
                double diffX = centerX - centerBoxX;
                double diffY = centerY - centerBoxY;
                double diff = Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));
                if (diff < minDiff) {
                    minDiff = diff;
                    boxCount = i;
                }
            }
        }
        if(boxCount==-1){
            return null;
        }
        return allPieces.get(boxCount);
    }
    protected void startFight(ArrayList<Piece> allPieces){
        target=findClosestEnemy(allPieces);
        if(target==null){
            playField.endRound();
        }else{
            moveUpClose(target);
        }
    }
    protected void moveUpClose(Piece target){
        double otherX=target.getOverallPosition()[0];
        double otherY=target.getOverallPosition()[1];
        double x=getOverallPosition()[0];
        double y=getOverallPosition()[1];
        double diffX=otherX-x;
        double diffY=otherY-y;
        diffX=diffX>0? diffX-size-(parentBox.getSize()*0.46502976):diffX+size+(parentBox.getSize()*0.46502976);
        System.out.println(parentBox.getSize());
        double cycles=80;
        double[] eachMove=new double[]{(diffX/cycles/2d),(diffY/cycles/2d)};
        tL=new Timeline(new KeyFrame(Duration.millis(30),ae->movePiece(eachMove)));
        tL.setCycleCount((int)cycles);
        tL.play();
    }
    protected void movePiece(double[] movement){
        getBody().setLayoutX(getBody().getLayoutX()+movement[0]);
        getBody().setLayoutY(getBody().getLayoutY()+movement[1]);
    }
    protected void reposition(){
        body.setLayoutX(parentBox.getBody().getLayoutX()+mainGame.gDisplay.getBodyDimensions()[0]+(getSize()/2));
        body.setLayoutY(parentBox.getBody().getLayoutY()+(getSize()/2));
        overallPosition=findPosition();
    }
    //private methods

}
