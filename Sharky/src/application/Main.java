package application;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
	private double xOffset=0;										//X Coordinate
	private double yOffset=0;										//Y Coordinate
	
	public void start(Stage primaryStage) throws IOException{
		
		Group root = new Group();									//Setting up Root/image/scene
		Image image = new Image("sharky.gif");
		ImageView view = new ImageView(image);
		root.getChildren().add(view);
		Scene scene = new Scene(root, Color.TRANSPARENT);			//Setting scene to "transparent" borders
		
		
		// Get X and Y coordinates when mouse pressed
		view.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
		    public void handle(MouseEvent event) {
		          xOffset = event.getSceneX();
		          yOffset = event.getSceneY();
		    }
		});
		//Change X and Y Coor. to new one while mouse drags
		view.setOnMouseDragged(new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent event) {
		           primaryStage.setX(event.getScreenX() - xOffset);
		           primaryStage.setY(event.getScreenY() - yOffset);
		    }
		});
		
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}

}
