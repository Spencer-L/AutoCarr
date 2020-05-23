package sample;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Button;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

public class GoldDisplay {
    //fields
    private Pane body = new Pane();
    private double [] screenDimensions;
    private double [] bodyDimensions;
    Rectangle base;
    int goldCount;
    //constructor
    public GoldDisplay(){
        screenDimensions=GlobalVariable.screenDimensions;
        bodyDimensions=new double[]{screenDimensions[0]*0.1,screenDimensions[1]*0.7};
        base = new Rectangle(bodyDimensions[0],bodyDimensions[1]);
        base.setFill(Color.LIGHTBLUE);
        body.getChildren().add(base);
        Text p1=new Text(bodyDimensions[0]/4,bodyDimensions[1]/25,"Player 1");
        p1.setFont(Font.font("Verdana", FontWeight.BOLD, bodyDimensions[0]/5.5));
        p1.setFill(Color.MEDIUMSLATEBLUE);
        p1.setStroke(Color.SEAGREEN);
        p1.setStrokeWidth(2);
        Text hp=new Text(bodyDimensions[0]/4,bodyDimensions[1]/11.5,"HP: 100");
        hp.setFont(Font.font("Verdana", FontWeight.BOLD, bodyDimensions[0]/6.5));
        hp.setFill(Color.RED);
        Text lvl=new Text(bodyDimensions[0]/4,bodyDimensions[1]/8,"LVL: 1 (XP ?/?)");
        lvl.setFont(Font.font("Verdana", FontWeight.BOLD, bodyDimensions[0]/6.5));
        lvl.setFill(Color.BLUE);
        StackPane gold=new StackPane();
        gold.setLayoutX(bodyDimensions[0]/4);
        gold.setLayoutY(bodyDimensions[1]/7);
        Circle c=new Circle(bodyDimensions[0]/13);
        c.setFill(Color.GOLD);
        Text g=new Text("G");
        g.setFont(Font.font("Verdana", FontWeight.BOLD, bodyDimensions[0]/13));
        g.setFill(Color.BLACK);
        gold.getChildren().addAll(c,g);
        Text num=new Text(bodyDimensions[0]/4+bodyDimensions[0]/4,bodyDimensions[1]/5.60,"1000");
        num.setFont(Font.font("Verdana", FontWeight.BOLD, bodyDimensions[0]/6.5));
        num.setFill(Color.BLACK);
        //p2
        Text p2=new Text(bodyDimensions[0]/4,bodyDimensions[1]/4,"Player 2");
        p2.setFont(Font.font("Verdana", FontWeight.BOLD, bodyDimensions[0]/5.5));
        p2.setFill(Color.MEDIUMSLATEBLUE);
        p2.setStroke(Color.SEAGREEN);
        p2.setStrokeWidth(2);
        Text hp1=new Text(bodyDimensions[0]/4,bodyDimensions[1]/3.4,"HP: 100");
        hp1.setFont(Font.font("Verdana", FontWeight.BOLD, bodyDimensions[0]/6.5));
        hp1.setFill(Color.RED);
        Text lvl1=new Text(bodyDimensions[0]/4,bodyDimensions[1]/3,"LVL: 1 (XP ?/?)");
        lvl1.setFont(Font.font("Verdana", FontWeight.BOLD, bodyDimensions[0]/6.5));
        lvl1.setFill(Color.BLUE);
        StackPane gold1=new StackPane();
        gold1.setLayoutX(bodyDimensions[0]/4);
        gold1.setLayoutY(bodyDimensions[1]/2.85);
        Circle c1=new Circle(bodyDimensions[0]/13);
        c1.setFill(Color.GOLD);
        Text g1=new Text("G");
        g1.setFont(Font.font("Verdana", FontWeight.BOLD, bodyDimensions[0]/13));
        g1.setFill(Color.BLACK);
        gold1.getChildren().addAll(c1,g1);
        Text num1=new Text(bodyDimensions[0]/4+bodyDimensions[0]/4,bodyDimensions[1]/2.60,"1000");
        num1.setFont(Font.font("Verdana", FontWeight.BOLD, bodyDimensions[0]/6.5));
        num1.setFill(Color.BLACK);
        body.getChildren().addAll(p1,hp,lvl,gold,num,p2,hp1,lvl1,gold1,num1);
    }
    //setter/getter
    public Pane getBody(){return body;}
    public double[] getBodyDimensions(){return bodyDimensions;}
    public void setBodyDimensions(double[] bD) {
        bodyDimensions = bD;
        base.setWidth(bD[0]);
        base.setHeight(bD[1]);
    }
    //methods

}
