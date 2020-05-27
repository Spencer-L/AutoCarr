package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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
    private StackPane nameTag=new StackPane();
    private int teamNum;
    //constructor
    public Deck(Player p){
        screenDimensions= GlobalVariable.screenDimensions;
        bodyDimensions=new double[]{screenDimensions[0]*1,screenDimensions[1]*0.14};
        base = new Rectangle(bodyDimensions[0],bodyDimensions[1]);
        base.setFill(Color.ORANGE);
        //base.setFill(Color.TRANSPARENT);
        body.getChildren().add(0,base);
        player=p;
        mainGame=player.getMainGame();
        playField=player.getPlayField();
        teamNum=player.getTeamNum();
        createPieces();
        createNameTag();
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

    public ArrayList<double[]> getSlots() { return slots; }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }
    //public methods
    public void movePieces(){
        for(int i=0;i<=16;i++){
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
    public void movePieces2(Piece p,int num){
        p.getBody().setLayoutX(slots.get(num)[0]);
        p.getBody().setLayoutY(slots.get(num)[1]);
        slots.get(slots.size()-1)[2]=1;
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
        index=piecesInDock.indexOf(p);
        System.out.println(index);
        slots.get(index)[2]=0;
        piecesInDock.remove(p);
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
    }
    public void hideDeck(){
        getBody().setVisible(false);
        for(Piece p:piecesInDock){
            p.getBody().setVisible(false);
        }
    }
    public void createWizard(int num){
        ArrayList<Box> boxes=playField.getBoxes();
        double boxSize=playField.getBoxSize();
        CirPiece p=new CirPiece(num-1,1,boxSize*0.35,100,"Cir1",mainGame,playField,teamNum,new double[]{0,0},this);
        pieces.add(p);
        if(!p.getOnField()){
            piecesInDock.add(p);
        }
        mainGame.updateDeck(p);
        movePieces2(p,piecesInDock.size()-1);
    }
    public void createArcher(int num){
        ArrayList<Box> boxes=playField.getBoxes();
        double boxSize=playField.getBoxSize();
        TriPiece p=new TriPiece(num-1,1,boxSize*0.5,100,"Tri1",mainGame,playField,teamNum,new double[]{0,0},this);
        pieces.add(p);
        if(!p.getOnField()){
            piecesInDock.add(p);
        }
        mainGame.updateDeck(p);
        movePieces2(p,piecesInDock.size()-1);
    }
    public void createPaladin(int num){
        ArrayList<Box> boxes=playField.getBoxes();
        double boxSize=playField.getBoxSize();
        RectPiece p=new RectPiece(num-1,1,boxSize*0.5,100,"Rect1",mainGame,playField,teamNum,new double[]{0,0},this);
        pieces.add(p);
        if(!p.getOnField()){
            piecesInDock.add(p);
        }
        mainGame.updateDeck(p);
        movePieces2(p,piecesInDock.size()-1);
    }
    public void createPriest(int num){
        ArrayList<Box> boxes=playField.getBoxes();
        double boxSize=playField.getBoxSize();
        PentPiece p=new PentPiece(num-1,1,boxSize*0.4,100,"Pent1",mainGame,playField,teamNum,new double[]{0,0},this);
        pieces.add(p);
        mainGame.updateDeck(p);
        if(!p.getOnField()){
            piecesInDock.add(p);
        }
        movePieces2(p,piecesInDock.size()-1);
    }
    public void createBerserker(int num){
        ArrayList<Box> boxes=playField.getBoxes();
        double boxSize=playField.getBoxSize();
        HexPiece p=new HexPiece(num-1,1,boxSize*0.35,100,"Hex1",mainGame,playField,teamNum,new double[]{0,0},this);
        pieces.add(p);
        if(!p.getOnField()){
            piecesInDock.add(p);
        }
        mainGame.updateDeck(p);
        movePieces2(p,piecesInDock.size()-1);
    }

    //private methods
    private void createPieces(){
        ArrayList<Box> boxes=playField.getBoxes();
        double boxSize=playField.getBoxSize();
        RectPiece tempPiece=new RectPiece(boxSize*0.5,100,"Rect1",mainGame,playField,teamNum,new double[]{0,0},this);
        RectPiece tempPiece2=new RectPiece(boxSize*0.5,100,"Rect2",mainGame,playField,teamNum,new double[]{0,0},this);
        PentPiece tempPiece3=new PentPiece(boxSize*0.4,100,"Pent1",mainGame,playField,teamNum,new double[]{0,0},this);
        CirPiece tempPiece4=new CirPiece(boxSize*0.35,100,"Cir1",mainGame,playField,teamNum,new double[]{0,0},this);
        TriPiece tempPiece5=new TriPiece(boxSize*0.5,100,"Tri1",mainGame,playField,teamNum,new double[]{0,0},this);
        HexPiece tempPiece6=new HexPiece(boxSize*0.35,100,"Hex1",mainGame,playField,teamNum,new double[]{0,0},this);
        pieces.add(tempPiece);
        //pieces.add(tempPiece2);
      //  pieces.add(tempPiece3);
        //pieces.add(tempPiece4);
       // pieces.add(tempPiece5);
       // pieces.add(tempPiece6);
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
    private void createNameTag(){
        Text name=new Text();
        name.setText(player.getName());
        name.setFont(new Font(50));
        name.setFill(Color.RED);
        //name.setFill(Color.web("ECA310"));
        nameTag.getChildren().add(name);
        nameTag.setLayoutY(-30);
        body.getChildren().add(nameTag);
    }
    public void levelUp(){
        double boxSize=playField.getBoxSize();
        String[] names = new String[5];
        names[0]="Paladin";
        names[1]="Wizard";
        names[2]="Archer";
        names[3]="Berserker";
        names[4]="Priest";
        int pieceIndex = 0;
        ArrayList<Integer> similarIndex = new ArrayList<Integer>();
        for(Piece p:piecesInDock){
            int nameIndex = 0;
            for(String name:names) {
                for(int j = 1; j<=3;j++) {
                    for(int k = 0; k < 4; k++) {
                        int counter = 0;
                        if (p.getName().equals(name) && p.getLevel() == j && p.getRarity() == k) {
                            similarIndex.add(pieceIndex);
                            counter++;
                        }
                        if (counter >= 3) {
                            for (int i = 0; i < similarIndex.size(); i++) {
                                piecesInDock.remove(similarIndex.get(i));
                                pieces.remove(similarIndex.get(i));
                            }
                            if(nameIndex==0){
                                pieces.add(new RectPiece(p.getRarity(),j+1, boxSize * 0.5, 100, "Rect2", mainGame, playField, teamNum, new double[]{0, 0}, this));
                            }
                            else if(nameIndex==1){
                                pieces.add(new CirPiece(p.getRarity(),j+1, boxSize * 0.35, 100, "Rect2", mainGame, playField, teamNum, new double[]{0, 0}, this));
                            }
                            else if(nameIndex==2){
                                pieces.add(new TriPiece(p.getRarity(),j+1, boxSize * 0.5, 100, "Rect2", mainGame, playField, teamNum, new double[]{0, 0}, this));
                            }
                            else if(nameIndex==3){
                                pieces.add(new HexPiece(p.getRarity(),j+1, boxSize * 0.35, 100, "Rect2", mainGame, playField, teamNum, new double[]{0, 0}, this));
                            }
                            else if(nameIndex==4){
                                pieces.add(new PentPiece(p.getRarity(),j+1, boxSize * 0.4, 100, "Rect2", mainGame, playField, teamNum, new double[]{0, 0}, this));
                            }
                        }
                    }
                }
                nameIndex++;
            }
            pieceIndex++;
        }
    }
}
