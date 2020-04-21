package sample;

import javafx.scene.layout.Pane;

public class MainGame {
    //fields
    //int size=1000;
    double[] dimensions;
    Shop shop;
    GoldDisplay gDisplay;
    Playfield pField;
    StorageDeck deck;

    Pane wrapper = new Pane();

    public MainGame(double[] wSize){
        dimensions=wSize;
        wrapper.setPrefSize(wSize[0],wSize[1]);
        initAllVars();
        appendBodies();
    }
    public Pane getWrapper(){return wrapper;}

    private void appendBodies(){
        wrapper.getChildren().add(shop.getBody());
        shop.getBody().relocate(0,dimensions[1]-dimensions[1]/6);
        wrapper.getChildren().add(gDisplay.getBody());
        gDisplay.getBody().relocate(0,dimensions[1]/9);
        /*wrapper.getChildren().add(pField);
        deck.getBody().relocate();*/
        wrapper.getChildren().add(deck.getBody());
        deck.getBody().relocate(0,dimensions[1]-dimensions[1]/6-dimensions[1]/7);
    }

    private void initAllVars(){
        shop = new Shop(dimensions);
        gDisplay = new GoldDisplay(dimensions);
        //pField = new PlayField(size);
        deck = new StorageDeck(dimensions);
    }

    //this is the mainGame file
}

