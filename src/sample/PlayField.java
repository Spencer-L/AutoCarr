package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class PlayField {
    //fields
    private MainGame mainGame;
    private Pane body = new Pane();
    private double [] screenDimensions;
    private double [] bodyDimensions;
    private double[] boxesCount;
    private double boxSize;
    private ArrayList<Box> boxes=new ArrayList<Box>();

    //constructor
    public PlayField(MainGame mG){
        mainGame=mG;
        boxesCount=new double[]{10,5};
        screenDimensions= GlobalVariable.screenDimensions;
        bodyDimensions=new double[]{screenDimensions[0]*0.9,screenDimensions[1]*0.7};
        Rectangle base = new Rectangle(bodyDimensions[0],bodyDimensions[1]);
        base.setFill(Color.PURPLE);
        body.getChildren().add(base);
        boxSize=findBoxSize();
        mainGame.adjustLayout(boxSize,boxesCount);
        createBoxes();
    }

    //setter/getter
    public Pane getBody(){return body;}
    public double[] getBodyDimensions(){return bodyDimensions;}
    //methods
    private void createBoxes(){
        for(int i=0;i<boxesCount[1];i++){
            for(int j=0;j<boxesCount[0];j++){
                Box temp=new Box(boxSize,i*10+j);
                body.getChildren().add(temp.getBody());
                boxes.add(temp);
            }
        }
    }
    private double findBoxSize(){
        return Math.min(bodyDimensions[0] / boxesCount[0], bodyDimensions[1] / boxesCount[1]);
    }
}
