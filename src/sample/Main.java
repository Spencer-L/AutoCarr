package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        Screen myScreen=Screen.getPrimary();
        Rectangle2D bounds= myScreen.getVisualBounds();
        GlobalVariable.screenDimensions=new double[]{bounds.getWidth(),bounds.getHeight()};
        MainGame root2 = new MainGame(new double[]{bounds.getWidth(),bounds.getHeight()});
        primaryStage.setScene(new Scene(root2.getWrapper(), 1000, 1000));
        primaryStage.setMaximized(true);
        primaryStage.show();

    }
//hello this is the edited Main file

    public static void main(String[] args) { launch(args); }
}
