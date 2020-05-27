package sample;


import java.util.ArrayList;

public class Player {
    //fields
    PlayField playField;
    MainGame mainGame;
    Deck deck;
    String name;
    int teamNum;
    int money;
    int HP;

    //constructor
    Player(String n, int tN, int m,int hp, PlayField pF, MainGame mG){
        playField=pF;
        mainGame=mG;
        name=n;
        teamNum=tN;
        money=m;
        HP=hp;
        createDeck();
    }
    //setter/getter

    public Deck getDeck() {
        return deck;
    }

    public PlayField getPlayField() {
        return playField;
    }

    public int getMoney() { return money; }

    public MainGame getMainGame() {
        return mainGame;
    }

    public int getTeamNum() {
        return teamNum;
    }

    public String getName(){return name;}

    public int getHP() { return HP; }

    //public methods
    public void appendDeck(){
        mainGame.getWrapper().getChildren().add(deck.getBody());
    }
    //private methods
    private void createDeck(){
        //ArrayList<Box> boxes=playField.getBoxes();
        //double boxSize=playField.getBoxSize();
        //ArrayList<Piece> tempList = new ArrayList<Piece>();
        //RectPiece tempPiece=new RectPiece(boxSize*0.5,boxes.get(54),100,"Rect1",mainGame,playField,teamNum);
        //RectPiece tempPiece2=new RectPiece(boxSize*0.5,boxes.get(11),100,"Rect2",mainGame,playField,teamNum);
        //RectPiece tempPiece=new RectPiece(boxSize*0.5,100,"Rect1",mainGame,playField,teamNum,new double[]{0,0});
        //RectPiece tempPiece2=new RectPiece(boxSize*0.5,100,"Rect2",mainGame,playField,teamNum,new double[]{0,0});
        //tempList.add(tempPiece);
        //tempList.add(tempPiece2);
        deck=new Deck(this);
        deck.getBody().relocate(0,playField.getBodyDimensions()[1]);
        deck.movePieces();
    }
}
