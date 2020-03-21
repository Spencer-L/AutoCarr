package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        MainGame root2 = new MainGame();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root2.getWrapper(), 1000, 1000));
        primaryStage.show();

    }
//hello this is the edited Main file

    public static void main(String[] args) { launch(args); }
}
