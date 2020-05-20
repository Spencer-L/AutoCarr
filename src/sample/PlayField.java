package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class PlayField {
    //fields
    private MainGame mainGame;
    private Pane body = new Pane();
    private Rectangle base;
    private double [] screenDimensions;
    private double [] bodyDimensions;
    private double[] boxesCount;
    private double boxSize;
    private ArrayList<Box> boxes=new ArrayList<Box>();
    private ArrayList<Box> p1Boxes=new ArrayList<Box>();
    private ArrayList<Box> p2Boxes=new ArrayList<Box>();
    private ArrayList<Box> column=new ArrayList<Box>();
    private ArrayList<Piece> pieces=new ArrayList<Piece>();
    private boolean roundEnd=false;

    //constructor
    public PlayField(MainGame mG){
        mainGame=mG;
        boxesCount=new double[]{11,5};
        screenDimensions= GlobalVariable.screenDimensions;
        bodyDimensions=new double[]{screenDimensions[0]*0.9,screenDimensions[1]*0.7};
        base = new Rectangle(bodyDimensions[0],bodyDimensions[1]);
        base.setFill(Color.TRANSPARENT);
        body.getChildren().add(base);
        boxSize=findBoxSize();
        mainGame.adjustLayout(boxSize,boxesCount);
        createBoxes();
        setBodyDimensions(new double[]{boxSize*boxesCount[0],boxSize*boxesCount[1]});
    }

    //setter/getter
    public Pane getBody(){return body;}
    public double[] getBodyDimensions(){return bodyDimensions;}
    public double[] getBoxesCount(){return boxesCount;}
    public void setBodyDimensions(double[] bD) {
        bodyDimensions = bD;
        body.setLayoutX(GlobalVariable.screenDimensions[0]-bD[0]);
        body.setLayoutY(0);
        base.setWidth(bD[0]);
        base.setHeight(bD[1]);
    }
    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public ArrayList<Box> getBoxes() {
        return boxes;
    }

    public ArrayList<Box> getp1Boxes() { return p1Boxes; }

    public ArrayList<Box> getp2Boxes() { return p2Boxes; }

    public ArrayList<Box> getColumn() { return column; }

    public boolean getRoundEnd(){
        return roundEnd;
    }
    public void setRoundEnd(boolean rE){
        roundEnd=rE;
    }

    public double getBoxSize() {
        return boxSize;
    }

    //public methods
    public void startFight(){
        roundEnd=false;
        for(Piece p:pieces){
            p.startFight(pieces);
            if(roundEnd){
                break;
            }
        }
    }
    public void repositionPieces(){
        for(Piece p:pieces){
            p.reposition();
        }
    }
    public void endRound(){
        System.out.println("Called");
        roundEnd=true;
    }
    //private methods
    private void createBoxes(){
        int counter=1;
        int counter1=1;
        for(int i=0;i<boxesCount[1];i++){
            int check=0;
            for(int j=0;j<boxesCount[0];j++) {
                Box temp;
                if(check<5) {
                    temp = new Box(boxSize, i * (int) boxesCount[0] + j, counter, boxesCount);
                    counter++;
                }else if(check>5){
                    temp = new Box(boxSize, i * (int) boxesCount[0] + j, counter1, boxesCount);
                    counter1++;
                }else{
                    temp = new Box(boxSize, i * (int) boxesCount[0] + j, 0, boxesCount);
                }
                check++;
                body.getChildren().add(temp.getBody());
                boxes.add(temp);
                if(j<5){
                    p1Boxes.add(temp);
                }else if(j>5){
                    p2Boxes.add(temp);
                }else{
                    column.add(temp);
                }

            }
        }
    }

    private double findBoxSize(){
        return Math.min(bodyDimensions[0] / boxesCount[0], bodyDimensions[1] / boxesCount[1]);
    }

}