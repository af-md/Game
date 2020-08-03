package controllers;

import View.PlayView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model2.GameObject;
import model2.WordFactory;

public class PlayController implements EventHandler {

		private Pane root; 
		
		private Stage stage;
		
		private PlayView playView;

		private GraphicsContext gc;

		private Canvas canvas;

	public PlayController(Stage stage)
		{
		  	Pane root = new Pane();
			Scene scene = new Scene(root, 800, 800);
		  	stage.setScene(scene);
		  	stage.show();

			canvas = new Canvas(800,600);

			gc = canvas.getGraphicsContext2D();

			gc.setFill(Color.BLACK);

			gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
			root.getChildren().add(canvas);

			this.stage = stage; 
			this.root = root;
			WordFactory wordFactory = new WordFactory(gc);
			GameObject word = wordFactory.createProduct();
			playView = new PlayView(this, root);
		}
		
		

		@Override
		public void handle(Event event) {

		}	
		
	}