package sample;

import javafx.scene.layout.Pane;

public class MainGame {
    //fields
    double[] dimensions;
    Shop shop;
    GoldDisplay gDisplay;
    PlayField pField;
    StorageDeck deck;

    Pane wrapper = new Pane();
    //constructor
    public MainGame(double[] wSize){
        dimensions=wSize;
        wrapper.setPrefSize(wSize[0],wSize[1]);
        initAllVars();
        appendBodies();
    }
    //setter/getter
    public Pane getWrapper(){return wrapper;}
    //methods
    private void appendBodies(){
        Pane shopBody=(Pane)shop.getBody();
        Pane SDBody=(Pane)deck.getBody();
        Pane PFBody=(Pane)pField.getBody();
        Pane GDBody=(Pane)gDisplay.getBody();
        wrapper.getChildren().add(shopBody);
        wrapper.getChildren().add(GDBody);
        wrapper.getChildren().add(PFBody);
        wrapper.getChildren().add(SDBody);
        shopBody.relocate(0, pField.getBodyDimensions()[1]+deck.getBodyDimensions()[1]);
        SDBody.relocate(0, pField.getBodyDimensions()[1]);
        PFBody.relocate(gDisplay.getBodyDimensions()[0], 0);
        GDBody.relocate(0,0);
    }


    private void initAllVars(){
        shop = new Shop();
        gDisplay = new GoldDisplay();
        pField = new PlayField();
        deck = new StorageDeck();
    }

    //this is the mainGame file
}

