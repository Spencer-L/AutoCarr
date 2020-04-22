package sample;

import javafx.scene.layout.Pane;

public class MainGame {
    //fields
    //int size=1000;
    double[] dimensions;
    Shop shop;
    GoldDisplay gDisplay;
    PlayField pField;
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
        Pane shopBody=(Pane)shop.getBody();
        Pane SDBody=(Pane)deck.getBody();
        Pane PFBod=(Pane)pField.getBody();
        Pane GDBody=(Pane)gDisplay.getBody();
        double[] shopDimen=new double[]{shopBody.getWidth(),shopBody.getHeight()};
        System.out.println(shopDimen[0]);
        System.out.println(shopDimen[1]);
        wrapper.getChildren().add(shopBody);
        shop.getBody().relocate(0,dimensions[1]-dimensions[1]/6);
        wrapper.getChildren().add(GDBody);
        gDisplay.getBody().relocate(0,dimensions[1]/9);
        wrapper.getChildren().add(PFBod);
        pField.getBody().relocate(dimensions[0]/8,dimensions[1]/20);
        wrapper.getChildren().add(SDBody);
        deck.getBody().relocate(0,dimensions[1]-dimensions[1]/6-dimensions[1]/7);
    }


    private void initAllVars(){
        shop = new Shop(dimensions);
        gDisplay = new GoldDisplay(dimensions);
        pField = new PlayField(dimensions);
        deck = new StorageDeck(dimensions);
    }

    //this is the mainGame file
}

