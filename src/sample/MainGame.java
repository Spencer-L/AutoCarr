package sample;

import javafx.scene.input.MouseEvent;
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
        wrapper.addEventHandler(MouseEvent.MOUSE_CLICKED,event -> console(event));
        initAllVars();
        appendBodies();
    }
    private void console(MouseEvent e){
        pField.startFight();
    }
    //setter/getter
    public Pane getWrapper(){return wrapper;}
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
    //private methods
    private void appendBodies(){
        Pane shopBody=(Pane)shop.getBody();
        Pane SDBody=(Pane)deck.getBody();
        Pane PFBody=(Pane)pField.getBody();
        Pane GDBody=(Pane)gDisplay.getBody();
        wrapper.getChildren().add(shopBody);
        wrapper.getChildren().add(GDBody);
        wrapper.getChildren().add(PFBody);
        wrapper.getChildren().add(SDBody);
        for(Piece p : pField.getPieces())
        wrapper.getChildren().add(p.getBody());
        shopBody.relocate(0, pField.getBodyDimensions()[1]+deck.getBodyDimensions()[1]);
        SDBody.relocate(0, pField.getBodyDimensions()[1]);
        PFBody.relocate(gDisplay.getBodyDimensions()[0], 0);
        GDBody.relocate(0,0);
    }


    private void initAllVars(){
        shop = new Shop();
        gDisplay = new GoldDisplay();
        deck = new StorageDeck();
        pField = new PlayField(this);
    }

    //this is the mainGame file
}

