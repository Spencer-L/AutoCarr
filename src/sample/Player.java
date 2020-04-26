package sample;


import java.util.ArrayList;

public class Player {
    //fields
    PlayField playField;
    MainGame mainGame;
    int teamNum;
    String name;
    double money;
    Deck deck;

    //constructor
    Player(String n, int tN, double m, PlayField pF, MainGame mG){
        playField=pF;
        mainGame=mG;
        name=n;
        teamNum=tN;
        money=m;
        createDeck();
    }
    //setter/getter

    //public methods

    //private methods
    private void createDeck(){
        ArrayList<Box> boxes=playField.getBoxes();
        double boxSize=playField.getBoxSize();
        ArrayList<Piece> tempList = new ArrayList<Piece>();
        RectPiece tempPiece=new RectPiece(boxSize*0.5,boxes.get(54),100,"Rect1",mainGame,playField,1);
        RectPiece tempPiece2=new RectPiece(boxSize*0.5,boxes.get(11),100,"Rect2",mainGame,playField,2);
        tempList.add(tempPiece);
        tempList.add(tempPiece2);
        deck=new Deck(tempList);
    }
}
