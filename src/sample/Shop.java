package sample;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Shop {
    //fields
    Pane body = new Pane();
    Rectangle base;
    Rectangle r1;
    Rectangle r;
    Pane btn;
    Pane btn1;
    private double [] screenDimensions;
    private double [] bodyDimensions;
    //constructor
    public Shop(){
        screenDimensions=GlobalVariable.screenDimensions;
        bodyDimensions=new double[]{screenDimensions[0]*1,screenDimensions[1]*0.16};
        base = new Rectangle(bodyDimensions[0],bodyDimensions[1]);
        base.setFill(Color.LIGHTGREEN);
        body.getChildren().add(base);
        r=new Rectangle(bodyDimensions[0]/6,bodyDimensions[1]/2);
        r.setFill(Color.TAN);
        r1=new Rectangle(bodyDimensions[0]/6,bodyDimensions[1]/2);
        r1.setFill(Color.STEELBLUE);
        r1.setY(bodyDimensions[1]/2);
        Text txt=new Text(bodyDimensions[0]/100,bodyDimensions[1]/8,"Refresh");
        txt.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        txt.setFill(Color.WHITE);
        Text txt1=new Text(bodyDimensions[0]/100,bodyDimensions[1]/8+(bodyDimensions[1]/2),"Buy XP");
        txt1.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        txt1.setFill(Color.WHITE);
        StackPane gold=new StackPane();
        gold.setLayoutX(bodyDimensions[0]/100);
        gold.setLayoutY(bodyDimensions[1]/8);
        StackPane gold1=new StackPane();
        gold1.setLayoutX(bodyDimensions[0]/100);
        gold1.setLayoutY(bodyDimensions[1]/8+(bodyDimensions[1]/2));
        Circle c=new Circle(10);
        c.setFill(Color.GOLD);
        Circle c1=new Circle(10);
        c1.setFill(Color.GOLD);
        Text g=new Text("G");
        g.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
        g.setFill(Color.BLACK);
        Text g1=new Text("G");
        g1.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
        g1.setFill(Color.BLACK);
        gold.getChildren().addAll(c,g);
        gold1.getChildren().addAll(c1,g1);
        Text num=new Text(bodyDimensions[0]/100+bodyDimensions[0]/80,bodyDimensions[1]/8+bodyDimensions[1]/10,"2");
        num.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        num.setFill(Color.WHITE);
        Text num1=new Text(bodyDimensions[0]/100+bodyDimensions[0]/80,(bodyDimensions[1]/8+(bodyDimensions[1]/2))+bodyDimensions[1]/10,"4");
        num1.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        num1.setFill(Color.WHITE);
        btn1= new Pane();
        btn= new Pane();
        btn.getChildren().addAll(r1,txt1,gold1,num1);
        btn1.getChildren().addAll(r,txt,gold,num);
        body.getChildren().addAll(btn,btn1);
        r.setOnMouseEntered(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
                r.setFill(Color.WHEAT);
            }
        });
        r1.setOnMouseEntered(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
                r1.setFill(Color.SKYBLUE);
            }
        });
        r1.setOnMouseExited(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
                r1.setFill(Color.STEELBLUE);
            }
        });
        r.setOnMouseExited(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
                r.setFill(Color.TAN);
            }
        });
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
