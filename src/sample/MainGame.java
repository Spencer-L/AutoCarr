package sample;

import javafx.scene.layout.Pane;

public class MainGame {
    //fields
    int size=1000;
    Shop shop = new Shop(size);
    GoldDisplay gDisplay = new GoldDisplay(size);
    /*Playfield pField = new PlayField(size);
    */StorageDeck deck = new StorageDeck(size);

    Pane wrapper = new Pane();

    public MainGame(){
        wrapper.setPrefSize(size,size);
        wrapper.getChildren().add(shop.getBody());
        shop.getBody().relocate(0,size-size/6);
        wrapper.getChildren().add(gDisplay.getBody());
        gDisplay.getBody().relocate(0,size/9);
        /*wrapper.getChildren().add(pField);
        deck.getBody().relocate();*/
        wrapper.getChildren().add(deck.getBody());
        deck.getBody().relocate(0,size-size/6-size/7);
    }
    public Pane getWrapper(){return wrapper;}
}

