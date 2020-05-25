package sample;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class WinRound {
    //field
        StackPane body=new StackPane();
        MainGame mainGame;
    //constructor
        WinRound(MainGame mG){
            mainGame=mG;
            Text msg=new Text();
            msg.setText("Hello");
            msg.setFont(new Font(50));
            msg.setFill(Color.RED);
            body.getChildren().add(msg);
            //nameTag.setLayoutY(-30);
            //body.getChildren().add(nameTag);
        }
    //setter/getter

    //public methods

    //private methods

}
