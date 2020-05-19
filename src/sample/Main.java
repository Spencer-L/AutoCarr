package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Main extends Application {

    Scene scene1;
    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox buttons = new VBox();

        Button startGame = new Button();
        startGame.setText("Play!");
        startGame.setOnAction(e -> {
            //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            primaryStage.setTitle("Hello World");
            Screen myScreen=Screen.getPrimary();
            Rectangle2D bounds= myScreen.getVisualBounds();
            GlobalVariable.screenDimensions=new double[]{bounds.getWidth(),bounds.getHeight()};
            MainGame root2 = new MainGame(new double[]{bounds.getWidth(),bounds.getHeight()});
            primaryStage.setScene(new Scene(root2.getWrapper(), 1000, 1000));
            primaryStage.setMaximized(true);
            primaryStage.show();
        });

        Button help = new Button();
        help.setText("Rules");
        help.setOnAction(e -> {
            primaryStage.setTitle("Rules");
            VBox root = new VBox();
            root.setStyle("-fx-background-color: #67bffe");

            Text rulesText1 = new Text();
            rulesText1.setFont(Font.font("Impact", FontWeight.BOLD, 30));
            rulesText1.setText("\nPre-round basics:\n");
            rulesText1.setUnderline(true);

            Text rulesText2 = new Text();
            rulesText2.setFont(Font.font("Impact", 25));
            rulesText2.setText("" +
                    "At the beginning of the round, you get a base amount of 5 gold plus 1 for every 10 gold you have saved, capped at 5 extra gold.\n" +
                    "Uses for gold?: \n" +
                    "       Buy units to fight on the battlefield\n" +
                    "       Reroll your shop to get new units available for purchase\n" +
                    "       Saving gold so you can make more the following round\n" +
                    "       Raising your level to place more units on the board\n" +
                    "You can only place your units on your side of the board, Player 1 goes on the left side, while player two goes on the right side. End your turn when you are finished, \nwhich will either hand your turn to the other player so they may do pre-round prep, or begin the battle phase.\n\n");

            Text rulesText3 = new Text();
            rulesText3.setFont(Font.font("Impact", FontWeight.BOLD, 30));
            rulesText3.setText("Battle Phase:\n");
            rulesText3.setUnderline(true);

            Text rulesText4 = new Text();
            rulesText4.setFont(Font.font("Impact",25));
            rulesText4.setText("Units will path find towards the closest enemy to them and begin to attack them. Once a unit begins their attacks on a unit, they do not switch targets until that unit is dead. \nThe battle phase ends after the timer reaches 0, or all units of one player dies. The player with fewer units left will take damage scaling with winner’s level, \namount of units, and tier of the units. If the losing player takes damage bringing them to 0 hp, they are out of the game. \n\n");

            Text rulesText5 = new Text();
            rulesText5.setFont(Font.font("Impact",FontWeight.BOLD,30));
            rulesText5.setText("Units:\n");
            rulesText5.setUnderline(true);

            Text rulesText6 = new Text();
            rulesText6.setFont(Font.font("Impact",25));
            rulesText6.setText("Units in the shop will have different costs, ranging from 1G - 5G, based on their rarity and class. Based on their class, units will have specialized areas in stats, including attack speed, \nattack damage, ability damage, physical and magical defense, and mana bar. Units gain mana while attacking, being attacked, \nand passively overtime. When a unit's mana bar is full, it will be able to cast its unique ability, which has effects ranging from dealing damage to healing units.");

            root.getChildren().addAll(rulesText1,rulesText2,rulesText3,rulesText4,rulesText5,rulesText6);
            Button menu = new Button();
            menu.setText("Back");
            menu.setOnAction(f -> {
                primaryStage.setTitle("Menu");
                primaryStage.setScene(scene1);
                primaryStage.setHeight(650);
                primaryStage.setWidth(650);
                primaryStage.setMaximized(false);
                primaryStage.show();
            });

            root.getChildren().add(menu);
            Scene scene = new Scene(root, 1000,1000);
//TODO: Implement and Format rules to look nice
            //primaryStage.setTitle("Menu");
            primaryStage.setScene(scene);
            primaryStage.setMaximized(true);
            primaryStage.show();

        });


        buttons.setMargin(startGame, new Insets(250,275,10,275));
        buttons.setMargin(help, new Insets(0,273,10,273));
        buttons.getChildren().addAll(startGame, help);


        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #67bffe");
        root.setCenter(buttons);
        scene1 = new Scene(root, 600,600);


        primaryStage.setTitle("Menu");
        primaryStage.setScene(scene1);
        primaryStage.show();

    }

    public void showRules(){

    }

//hello this is the edited Main file

    public static void main(String[] args) { launch(args); }
}
