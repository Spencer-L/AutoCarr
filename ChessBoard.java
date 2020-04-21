/*project stuff
 *
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.input.MouseEvent;

public class ChessBoard extends Application {
	public static void main(String[] args){
    	launch(args);
    }
    public void start(Stage primaryStage) {
        Pane tileMap = new Pane();
        double size = 70;
        double v=Math.sqrt(3)/2.0;
        double height=300;
        double width=800;
        for(double y=50;y<height;y+=size*3){
            for(double x=50,dy=y;x<width;x+=size*v){
                Polygon tile = new Polygon();
                tile.getPoints().addAll(new Double[]{
                    x,dy,
                    x+size*v,dy-(size/2.0),
                    x+size*Math.sqrt(3),dy,
                    x+size*Math.sqrt(3),dy+size,
                    x+size*v,dy+1.5*size,
                    x,dy+size
                });
                tile.setFill(Color.BLANCHEDALMOND);
                tile.setStrokeWidth(2);
                tile.setStroke(Color.CHOCOLATE);
                tile.setOpacity(0.5);
                tileMap.getChildren().add(tile);
                if(dy==y){
                	dy=dy+size*1.5;
                }else{
                	dy=y;
                }
                tile.setOnMouseEntered(new EventHandler<MouseEvent>(){
					public void handle(MouseEvent event){
					tile.setOpacity(1);
                    tile.setStroke(Color.ORANGE);
				}
				});
				tile.setOnMouseExited(new EventHandler<MouseEvent>(){
					public void handle(MouseEvent event){
					tile.setOpacity(0.5);
                    tile.setStroke(Color.CHOCOLATE);
				}
				});
          	 }
        }
        Scene root = new Scene(tileMap, 1000, 600);
        primaryStage.setScene(root);
        primaryStage.show();
    }
}


