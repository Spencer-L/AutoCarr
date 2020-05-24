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
    private Pane body = new Pane();
    private Rectangle base;
    private Rectangle r1;
    private Rectangle r;
    private Pane btn;
    private Pane btn1;
    private Pane u1;
    private Pane u2;
    private Pane u3;
    private Pane u4;
    private Pane u5;
    private boolean check=false;
    private double [] screenDimensions;
    private double [] bodyDimensions;
    //constructor
    public Shop(){
        screenDimensions=GlobalVariable.screenDimensions;
        bodyDimensions=new double[]{screenDimensions[0]*1,screenDimensions[1]*0.16};
        base = new Rectangle(bodyDimensions[0],bodyDimensions[1]);
        base.setFill(Color.LIGHTGREEN);
        body.getChildren().add(base);
        refreshShop();
        r=new Rectangle(bodyDimensions[0]/6,bodyDimensions[1]/2);
        r.setFill(Color.TAN);
        r1=new Rectangle(bodyDimensions[0]/6,bodyDimensions[1]/2);
        r1.setFill(Color.STEELBLUE);
        r1.setY(bodyDimensions[1]/2);
        Text txt=new Text(bodyDimensions[0]/100,bodyDimensions[1]/8,"Refresh");
        txt.setFont(Font.font("Verdana", FontWeight.BOLD, bodyDimensions[0]/100));
        txt.setFill(Color.WHITE);
        Text txt1=new Text(bodyDimensions[0]/100,bodyDimensions[1]/8+(bodyDimensions[1]/2),"Buy XP");
        txt1.setFont(Font.font("Verdana", FontWeight.BOLD, bodyDimensions[0]/100));
        txt1.setFill(Color.WHITE);
        StackPane gold=new StackPane();
        gold.setLayoutX(bodyDimensions[0]/100);
        gold.setLayoutY(bodyDimensions[1]/8);
        StackPane gold1=new StackPane();
        gold1.setLayoutX(bodyDimensions[0]/100);
        gold1.setLayoutY(bodyDimensions[1]/8+(bodyDimensions[1]/2));
        Circle c=new Circle(bodyDimensions[0]/175);
        c.setFill(Color.GOLD);
        Circle c1=new Circle(bodyDimensions[0]/175);
        c1.setFill(Color.GOLD);
        Text g=new Text("G");
        g.setFont(Font.font("Verdana", FontWeight.BOLD, bodyDimensions[0]/175));
        g.setFill(Color.BLACK);
        Text g1=new Text("G");
        g1.setFont(Font.font("Verdana", FontWeight.BOLD, bodyDimensions[0]/175));
        g1.setFill(Color.BLACK);
        gold.getChildren().addAll(c,g);
        gold1.getChildren().addAll(c1,g1);
        Text num=new Text(bodyDimensions[0]/100+bodyDimensions[0]/80,bodyDimensions[1]/8+bodyDimensions[1]/10,"2");
        num.setFont(Font.font("Verdana", FontWeight.BOLD, bodyDimensions[0]/100));
        num.setFill(Color.WHITE);
        Text num1=new Text(bodyDimensions[0]/100+bodyDimensions[0]/80,(bodyDimensions[1]/8+(bodyDimensions[1]/2))+bodyDimensions[1]/10,"4");
        num1.setFont(Font.font("Verdana", FontWeight.BOLD, bodyDimensions[0]/100));
        num1.setFill(Color.WHITE);
        btn1= new Pane();
        btn= new Pane();
        btn.getChildren().addAll(r1,txt1,gold1,num1);
        btn1.getChildren().addAll(r,txt,gold,num);
        body.getChildren().addAll(btn,btn1);
        actions();
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
    public void actions(){
        r.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
                if(check){
                    body.getChildren().removeAll(btn,btn1,u1,u2,u3,u4,u5);
                }
                refreshShop();
                body.getChildren().addAll(btn,btn1);
                actions();
            }
        });
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
    public void refreshShop(){
        //unit 1
        u1=new Pane();
        Rectangle a1=new Rectangle(bodyDimensions[0]/6,bodyDimensions[1]/1.5);
        a1.setX(bodyDimensions[0]/6);
        a1.setFill(Color.BEIGE);
        a1.setStroke(Color.BLACK);
        int num1=rarityCalc();
        Rectangle b1=new Rectangle(bodyDimensions[0]/6,bodyDimensions[1]/3);
        b1.setX(bodyDimensions[0]/6);
        b1.setY(bodyDimensions[1]/1.5);
        b1.setStroke(Color.BLACK);
        if(num1==1){
            b1.setFill(Color.GREY);
        }else if(num1==2){
            b1.setFill(Color.BLUE);
        }else if(num1==3){
            b1.setFill(Color.PURPLE);
        }else{
            b1.setFill(Color.YELLOW);
        }
        StackPane gold1=new StackPane();
        gold1.setLayoutX(bodyDimensions[0]/6+bodyDimensions[0]/8);
        gold1.setLayoutY(bodyDimensions[1]/1.4);
        Circle c1=new Circle(bodyDimensions[0]/175);
        c1.setFill(Color.GOLD);
        Text g1=new Text("G");
        g1.setFont(Font.font("Verdana", FontWeight.BOLD, bodyDimensions[0]/175));
        g1.setFill(Color.BLACK);
        gold1.getChildren().addAll(c1,g1);
        Text t1=new Text(bodyDimensions[0]/6+bodyDimensions[0]/7,bodyDimensions[1]/1.225,Integer.toString(num1));
        t1.setFont(Font.font("Verdana", FontWeight.BOLD, bodyDimensions[0]/100));
        t1.setFill(Color.BLACK);
        u1.getChildren().addAll(a1,b1,gold1,t1);
        //unit 2
        u2=new Pane();
        Rectangle a2=new Rectangle(bodyDimensions[0]/6,bodyDimensions[1]/1.5);
        a2.setX(bodyDimensions[0]/3);
        a2.setFill(Color.BEIGE);
        a2.setStroke(Color.BLACK);
        int num2=rarityCalc();
        Rectangle b2=new Rectangle(bodyDimensions[0]/6,bodyDimensions[1]/3);
        b2.setX(bodyDimensions[0]/3);
        b2.setY(bodyDimensions[1]/1.5);
        b2.setStroke(Color.BLACK);
        if(num2==1){
            b2.setFill(Color.GREY);
        }else if(num2==2){
            b2.setFill(Color.BLUE);
        }else if(num2==3){
            b2.setFill(Color.PURPLE);
        }else{
            b2.setFill(Color.YELLOW);
        }
        StackPane gold2=new StackPane();
        gold2.setLayoutX(bodyDimensions[0]/3+bodyDimensions[0]/8);
        gold2.setLayoutY(bodyDimensions[1]/1.4);
        Circle c2=new Circle(bodyDimensions[0]/175);
        c2.setFill(Color.GOLD);
        Text g2=new Text("G");
        g2.setFont(Font.font("Verdana", FontWeight.BOLD, bodyDimensions[0]/175));
        g2.setFill(Color.BLACK);
        gold2.getChildren().addAll(c2,g2);
        Text t2=new Text(bodyDimensions[0]/3+bodyDimensions[0]/7,bodyDimensions[1]/1.225,Integer.toString(num2));
        t2.setFont(Font.font("Verdana", FontWeight.BOLD, bodyDimensions[0]/100));
        t2.setFill(Color.BLACK);
        u2.getChildren().addAll(a2,b2,gold2,t2);
        //unit 3
        u3=new Pane();
        Rectangle a3=new Rectangle(bodyDimensions[0]/6,bodyDimensions[1]/1.5);
        a3.setX(bodyDimensions[0]/2);
        a3.setFill(Color.BEIGE);
        a3.setStroke(Color.BLACK);
        int num3=rarityCalc();
        Rectangle b3=new Rectangle(bodyDimensions[0]/6,bodyDimensions[1]/3);
        b3.setX(bodyDimensions[0]/2);
        b3.setY(bodyDimensions[1]/1.5);
        b3.setStroke(Color.BLACK);
        if(num3==1){
            b3.setFill(Color.GREY);
        }else if(num3==2){
            b3.setFill(Color.BLUE);
        }else if(num3==3){
            b3.setFill(Color.PURPLE);
        }else{
            b3.setFill(Color.YELLOW);
        }
        StackPane gold3=new StackPane();
        gold3.setLayoutX(bodyDimensions[0]/2+bodyDimensions[0]/8);
        gold3.setLayoutY(bodyDimensions[1]/1.4);
        Circle c3=new Circle(bodyDimensions[0]/175);
        c3.setFill(Color.GOLD);
        Text g3=new Text("G");
        g3.setFont(Font.font("Verdana", FontWeight.BOLD, bodyDimensions[0]/175));
        g3.setFill(Color.BLACK);
        gold3.getChildren().addAll(c3,g3);
        Text t3=new Text(bodyDimensions[0]/2+bodyDimensions[0]/7,bodyDimensions[1]/1.225,Integer.toString(num3));
        t3.setFont(Font.font("Verdana", FontWeight.BOLD, bodyDimensions[0]/100));
        t3.setFill(Color.BLACK);
        u3.getChildren().addAll(a3,b3,gold3,t3);
        //unit 4
        u4=new Pane();
        Rectangle a4=new Rectangle(bodyDimensions[0]/6,bodyDimensions[1]/1.5);
        a4.setX(bodyDimensions[0]/1.5);
        a4.setFill(Color.BEIGE);
        a4.setStroke(Color.BLACK);
        int num4=rarityCalc();
        Rectangle b4=new Rectangle(bodyDimensions[0]/6,bodyDimensions[1]/3);
        b4.setX(bodyDimensions[0]/1.5);
        b4.setY(bodyDimensions[1]/1.5);
        b4.setStroke(Color.BLACK);
        if(num4==1){
            b4.setFill(Color.GREY);
        }else if(num4==2){
            b4.setFill(Color.BLUE);
        }else if(num4==3){
            b4.setFill(Color.PURPLE);
        }else{
            b4.setFill(Color.YELLOW);
        }
        StackPane gold4=new StackPane();
        gold4.setLayoutX(bodyDimensions[0]/1.5+bodyDimensions[0]/8);
        gold4.setLayoutY(bodyDimensions[1]/1.4);
        Circle c4=new Circle(bodyDimensions[0]/175);
        c4.setFill(Color.GOLD);
        Text g4=new Text("G");
        g4.setFont(Font.font("Verdana", FontWeight.BOLD, bodyDimensions[0]/175));
        g4.setFill(Color.BLACK);
        gold4.getChildren().addAll(c4,g4);
        Text t4=new Text(bodyDimensions[0]/1.5+bodyDimensions[0]/7,bodyDimensions[1]/1.225,Integer.toString(num4));
        t4.setFont(Font.font("Verdana", FontWeight.BOLD, bodyDimensions[0]/100));
        t4.setFill(Color.BLACK);
        u4.getChildren().addAll(a4,b4,gold4,t4);
        //unit 5
        u5=new Pane();
        Rectangle a5=new Rectangle(bodyDimensions[0]/6,bodyDimensions[1]/1.5);
        a5.setX(bodyDimensions[0]/1.2);
        a5.setFill(Color.BEIGE);
        a5.setStroke(Color.BLACK);
        int num5=rarityCalc();
        Rectangle b5=new Rectangle(bodyDimensions[0]/6,bodyDimensions[1]/3);
        b5.setX(bodyDimensions[0]/1.2);
        b5.setY(bodyDimensions[1]/1.5);
        b5.setStroke(Color.BLACK);
        if(num5==1){
            b5.setFill(Color.GREY);
        }else if(num5==2){
            b5.setFill(Color.BLUE);
        }else if(num5==3){
            b5.setFill(Color.PURPLE);
        }else{
            b5.setFill(Color.YELLOW);
        }
        StackPane gold5=new StackPane();
        gold5.setLayoutX(bodyDimensions[0]/1.2+bodyDimensions[0]/8);
        gold5.setLayoutY(bodyDimensions[1]/1.4);
        Circle c5=new Circle(bodyDimensions[0]/175);
        c5.setFill(Color.GOLD);
        Text g5=new Text("G");
        g5.setFont(Font.font("Verdana", FontWeight.BOLD, bodyDimensions[0]/175));
        g5.setFill(Color.BLACK);
        gold5.getChildren().addAll(c5,g5);
        Text t5=new Text(bodyDimensions[0]/1.2+bodyDimensions[0]/7,bodyDimensions[1]/1.225,Integer.toString(num5));
        t5.setFont(Font.font("Verdana", FontWeight.BOLD, bodyDimensions[0]/100));
        t5.setFill(Color.BLACK);
        u5.getChildren().addAll(a5,b5,gold5,t5);
        body.getChildren().addAll(u1,u2,u3,u4,u5);
        check=true;
    }
    public int rarityCalc(){
        int num=(int)(Math.random()*100);
        if(num<50){
            return 1;
        }else if(num>50&&num<85){
            return 2;
        }else if(num>85&&num<95){
            return 3;
        }else{
            return 4;
        }
    }
}
