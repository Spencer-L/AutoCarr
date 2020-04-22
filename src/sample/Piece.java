package sample;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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
    //constructor
    Piece(double s,Box pB,double h, String id,MainGame mG,PlayField pF){
        mainGame=mG;
        playField=pF;
        size=s;
        body=new StackPane();
        body.setPrefSize(s,s);
        parentBox=pB;
        body.addEventHandler(MouseEvent.MOUSE_DRAGGED,event -> dragPiece(event));
        body.addEventHandler(MouseEvent.MOUSE_RELEASED,event -> releasePiece(event));
        health=h;
        ID=id;
        overallPosition=findPosition();
        mainGame.getWrapper().getChildren().add(body);
        body.setLayoutX(overallPosition[0]);
        body.setLayoutY(overallPosition[1]);
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
    //public methods
    protected void dragPiece(MouseEvent e){
        body.setLayoutX(e.getSceneX());
        body.setLayoutY(e.getSceneY());
        body.toFront();
        System.out.println(e.getSceneX());
        System.out.println(e.getSceneY());
    }
    protected void releasePiece(MouseEvent e){
        isDragging=false;
        System.out.println("released");
    }
    protected  double[] findPosition(){
        double xCord=parentBox.getBody().getLayoutX()+playField.getBody().getLayoutX();
        double yCord=parentBox.getBody().getLayoutY();
        return new double[]{xCord,yCord};
    }

    //private methods

}
