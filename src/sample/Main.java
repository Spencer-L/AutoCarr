package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
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
            BorderPane root = new BorderPane();
            root.setStyle("-fx-background-color: #67bffe");
            Scene scene = new Scene(root, 600,600);
//TODO: Implement and Format rules to look nice
            primaryStage.setTitle("Menu");
            primaryStage.setScene(scene);
            primaryStage.show();

        });

        VBox buttons = new VBox();
        buttons.setMargin(startGame, new Insets(250,275,10,275));
        buttons.setMargin(help, new Insets(0,273,10,273));
        buttons.getChildren().addAll(startGame, help);


        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #67bffe");
        root.setCenter(buttons);
        Scene scene = new Scene(root, 600,600);


        primaryStage.setTitle("Menu");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
//hello this is the edited Main file

    public static void main(String[] args) { launch(args); }
}
