package sample;

import javafx.animation.Timeline;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class MainGame {
    //fields
    double[] dimensions;

    Shop shop;
    GoldDisplay gDisplay;
    PlayField pField;
    Deck deck;
    WinRound windRound;
    ArrayList<Player> players=new ArrayList<Player>();
    Pane wrapper = new Pane();
    int turn=0;

    //constructor
    public MainGame(double[] wSize){
        dimensions=wSize;
        wrapper.setPrefSize(wSize[0],wSize[1]);
        //wrapper.addEventHandler(MouseEvent.MOUSE_CLICKED,event -> console(event));
        initAllVars();
        createPlayers();
        appendBodies();
        nextPhase();
    }
    //setter/getter
    public Pane getWrapper(){return wrapper;}
    public WinRound getWinRound(){return windRound;}
    //public methods
    public void adjustGDBody(double[] dimensions){
        gDisplay.getBody().setLayoutX(dimensions[0]);
        gDisplay.getBody().setLayoutY(dimensions[1]);
        gDisplay.setBodyDimensions(new double[]{dimensions[2],dimensions[3]});
    }
    public void adjustShopBody(double[] dimensions){
        shop.getBody().setLayoutX(dimensions[0]);
        shop.getBody().setLayoutY(dimensions[1]);
        shop.setBodyDimensions(new double[]{dimensions[2],dimensions[3]});
    }
    public void adjustDeckBody(double[] dimensions){
        deck.getBody().setLayoutX(dimensions[0]);
        deck.getBody().setLayoutY(dimensions[1]);
        deck.setBodyDimensions(new double[]{dimensions[2],dimensions[3]});
    }
    public void adjustLayout(double boxSize,double[] boxesCount){
        double additionalVerticalSpace=(GlobalVariable.screenDimensions[1]-boxSize*boxesCount[1]-deck.getBodyDimensions()[1]-shop.getBodyDimensions()[1]);
        gDisplay.setBodyDimensions(new double[]{GlobalVariable.screenDimensions[0]-boxSize*boxesCount[0],
                boxSize*boxesCount[1]});
        deck.setBodyDimensions(new double[]{GlobalVariable.screenDimensions[0],
                deck.getBodyDimensions()[1]+(additionalVerticalSpace/2)});
        shop.setBodyDimensions(new double[]{GlobalVariable.screenDimensions[0],
                shop.getBodyDimensions()[1]+(additionalVerticalSpace/2)});
    }
    public void nextPhase(){
        System.out.println("Next Phase Called");
        pField.repositionPieces();
        if(turn%3==0){
            players.get(0).getDeck().showDeck();
            players.get(1).getDeck().hideDeck();
            deck.hideDeck();
        }else if(turn%3==1){
            players.get(0).getDeck().hideDeck();
            players.get(1).getDeck().showDeck();
        }else if(turn%3==2){
            startFight();
            players.get(0).getDeck().hideDeck();
            players.get(1).getDeck().hideDeck();
            deck.showDeck();
        }
        turn++;
        if(turn>1){
         shop.nextPhase();
        }
    }
    //private methods
    public void createPlayers(){
        players.add(new Player("Player 1",1,500d,pField,this));
        players.add(new Player("Player 2",2,500d,pField,this));
        shop.setPlayers(players.get(0),players.get(1));
        //players.get(0).getDeck().showDeck();
        //players.get(1).getDeck().hideDeck();
    }
    private void appendBodies(){
        for(Player player:players){
            for(Piece p:player.getDeck().getPieces()){
               wrapper.getChildren().add(p.getRangeBox());
            }
        }
        Pane shopBody=(Pane)shop.getBody();
        Pane SDBody=(Pane)deck.getBody();
        Pane PFBody=(Pane)pField.getBody();
        Pane GDBody=(Pane)gDisplay.getBody();
        wrapper.getChildren().add(shopBody);
        wrapper.getChildren().add(GDBody);
        wrapper.getChildren().add(PFBody);
        wrapper.getChildren().add(SDBody);
        for(Player player:players){
            player.appendDeck();
            for(Piece p:player.getDeck().getPieces()){
                //wrapper.getChildren().add(p.getRangeBox());
                wrapper.getChildren().add(p.getBody());

            }
        }
        shopBody.relocate(0, pField.getBodyDimensions()[1]+deck.getBodyDimensions()[1]);
        SDBody.relocate(0, pField.getBodyDimensions()[1]);
        PFBody.relocate(gDisplay.getBodyDimensions()[0], 0);
        GDBody.relocate(0,0);
        wrapper.getChildren().add(windRound.getBody());
    }
    private void initAllVars(){
        shop = new Shop();
        gDisplay = new GoldDisplay();
        deck = new Deck();
        pField = new PlayField(this);
        windRound=new WinRound(this);
        shop.setPlayField(pField);
        shop.setMainGame(this);
    }
    //private boolean start=false;
    private void startFight(){
        pField.startFight();
    }
    //this is the mainGame file
}

