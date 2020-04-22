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
    private ArrayList<Piece> pieces=new ArrayList<Piece>();

    //constructor
    public PlayField(MainGame mG){
        mainGame=mG;
        boxesCount=new double[]{11,5};
        screenDimensions= GlobalVariable.screenDimensions;
        bodyDimensions=new double[]{screenDimensions[0]*0.9,screenDimensions[1]*0.7};
        base = new Rectangle(bodyDimensions[0],bodyDimensions[1]);
        base.setFill(Color.PURPLE);
        body.getChildren().add(base);
        boxSize=findBoxSize();
        mainGame.adjustLayout(boxSize,boxesCount);
        createBoxes();
        setBodyDimensions(new double[]{boxSize*boxesCount[0],boxSize*boxesCount[1]});
        createPieces();
    }

    //setter/getter
    public Pane getBody(){return body;}
    public double[] getBodyDimensions(){return bodyDimensions;}
    public double[] getBoxesCount(){return boxesCount;}
    public void setBodyDimensions(double[] bD) {
        bodyDimensions = bD;
        base.setWidth(bD[0]);
        base.setHeight(bD[1]);
    }
    //methods
    private void createBoxes(){
        for(int i=0;i<boxesCount[1];i++){
            for(int j=0;j<boxesCount[0];j++){
                Box temp=new Box(boxSize,i*(int)boxesCount[0]+j,boxesCount);
                body.getChildren().add(temp.getBody());
                boxes.add(temp);
            }
        }
    }
    private double findBoxSize(){
        return Math.min(bodyDimensions[0] / boxesCount[0], bodyDimensions[1] / boxesCount[1]);
    }
    private void createPieces(){
        RectPiece tempPiece=new RectPiece(boxSize,boxes.get(0));
        pieces.add(tempPiece);
    }
}
