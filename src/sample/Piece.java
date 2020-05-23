package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javafx.scene.text.Text;

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
    private int cost;
    private int level = 1;
    private Text levels;
    private int rarity;
    private Rectangle rarityBand;
    private double damage;
    private double atkSpd;
    private String name;
    private int range;
    private Piece target;
    private Timeline tL;
    private boolean onField=false;
    private Deck parentDeck;
    private Text healthPoints;
    private Timeline attackPacing;
    private int timerCounter;
    private StackPane healthBarRed;
    private Rectangle healthBarGreen;

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
        atkSpd=.9;
        damage=10;

        levels = new Text(Integer.toString(level));

        rarityBand = new Rectangle(s/2,10);
        createRarityBand();


        healthBarGreen = new Rectangle();
        healthBarGreen.setWidth(s);
        healthBarGreen.setHeight(15);
        healthBarGreen.setFill(Color.GREEN);

        healthBarRed = new StackPane();
        healthBarRed.setMaxSize(s,15);
        healthBarRed.setStyle("-fx-background-color:RED");
        healthBarRed.setAlignment(healthBarGreen, Pos.CENTER_LEFT);
        healthBarRed.getChildren().add(healthBarGreen);

        healthPoints = new Text((health + ""));
        timerCounter=0;
    }
    //setter/getter


    public Rectangle getRarityBand() {
        return rarityBand;
    }

    public void setRarityBand(Rectangle rarityBand) {
        this.rarityBand = rarityBand;
    }

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

    public Text getLevels() {
        return levels;
    }

    public void setLevels(Text levels) {
        this.levels = levels;
    }

    public int getTeamNum() {
        return teamNum;
    }
    public int getCost(){return cost;}
    public int getLevel(){return level;}
    public void setLevel(int lev){level = lev;}
    public int getRarity(){return rarity;}
    public double getDamage(){return damage;}
    public void setDamage(double damage){this.damage = damage; }
    public double getAtkSpd(){return atkSpd;}
    public void setAtkSpd(double atkSpd){this.atkSpd = atkSpd;}
    public Text getHealthPoints(){return healthPoints;}
    public void setHealthPoints(Text t){healthPoints=t;}

    public StackPane getHealthBarRed() {
        return healthBarRed;
    }

    public void setHealthBarRed(StackPane healthBarRed) {
        this.healthBarRed = healthBarRed;
    }

    public Rectangle getHealthBarGreen() {
        return healthBarGreen;
    }

    public void setHealthBarGreen(Rectangle healthBarGreen) {
        this.healthBarGreen = healthBarGreen;
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
            ArrayList<Box>temp=playField.getColumn();
            for(Box b:temp){
                b.altGlow();
            }
        }
    }

    protected Box findClosestBox(){
        double minDiff=Double.MAX_VALUE;
        int boxCount=0;
        if(getTeamNum()==1){
         for(int i=0;i<playField.getp2Boxes().size();i++){
            Box b=playField.getp2Boxes().get(i);
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
         return playField.getp2Boxes().get(boxCount);
        }else {
            for(int i=0;i<playField.getp1Boxes().size();i++){
                Box b=playField.getp1Boxes().get(i);
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
            return playField.getp1Boxes().get(boxCount);
        }
    }

    protected void releasePiece(MouseEvent e){
        isDragging=false;
        if(body.getLayoutY()>playField.getBodyDimensions()[1]){
            if(onField){
                parentDeck.fieldToDeck(this);
            }else{
                parentDeck.deckToDeck(this);
            }
            onField=false;
            parentDeck.notGlow();
            ArrayList<Box>temp=playField.getColumn();
            for(Box b:temp){
                b.notGlow();
            }
        }else if(body.getLayoutY()<=playField.getBodyDimensions()[1]){
            parentBox=findClosestBox();
            if(onField){
                parentDeck.fieldToField(this);
            }else{
                parentDeck.deckToField(this);
                playField.getPieces().add(this);
            }
            parentBox=findClosestBox();
            onField=true;
            reposition();
            parentBox.notGlow();
            ArrayList<Box>temp=playField.getColumn();
            for(Box b:temp){
                b.notGlow();
            }
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
            System.out.println("here");
            if(inRange(target)){
               attackPacing =  new Timeline(new KeyFrame(Duration.millis(40),ae->doAttack()));
               attackPacing.setCycleCount(Animation.INDEFINITE);
               attackPacing.play();


            }
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

    protected void doAttack(){
        if(timerCounter<(int)(30*atkSpd))timerCounter++;
        else{
            timerCounter=0;
            if(inRange(target)){
                boolean dead = dealDamage(target);
                target.getHealthPoints().setText(target.getHealth()+ "");
                if(dead) attackPacing.stop();
            }
        }

    }
    protected boolean inRange(Piece enemy){
        //if(enemy.getBody().getLayoutBounds())
        return true;
    }
    protected boolean dealDamage(Piece enemy){
        enemy.setHealth(enemy.getHealth()-damage);
        if(enemy.getHealth()<=0) return true;
        else return false;
    }

    protected void calculateHealthBar(int damage){
        healthBarGreen.setWidth(((health-damage)/health)*size);
    }

    protected void createRarityBand(){
        if(rarity == 0){
            rarityBand.setFill(Color.WHITE);
        }
        else if(rarity == 1){
            rarityBand.setFill(Color.BLUE);
        }
        else if(rarity == 2){
            rarityBand.setFill(Color.PURPLE);
        }
        else if(rarity == 3){
            rarityBand.setFill(Color.GOLD);
        }
    }


    //private methods

}
