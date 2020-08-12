package controllers;

import View.PlayView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model2.GameObject;
import model2.WordFactory;

import javax.swing.*;

public class PlayController implements EventHandler {

		private Pane root; 
		
		private Stage stage;
		
		private PlayView playView;

		private GraphicsContext gc;

		private Canvas canvas;

		Rectangle r = new Rectangle();

	public PlayController(Stage stage)
		{
		  	Pane root = new Pane();
			Scene scene = new Scene(root, 800, 600);
		  	stage.setScene(scene);
		  	stage.show();

			canvas = new Canvas(800,600);

			gc = canvas.getGraphicsContext2D();

			gc.setFill(Color.WHITE);

			gc.fillRect(100,100,canvas.getWidth(),canvas.getHeight());

			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent keyEvent) {
					if (keyEvent.getCode() == KeyCode.LEFT)
					{

					}
					if (keyEvent.getCode() == KeyCode.RIGHT)
					{

					}
				}
			});

			scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent keyEvent) {
					if (keyEvent.getCode() == KeyCode.LEFT)
					{

					}
					if (keyEvent.getCode() == KeyCode.RIGHT)
					{

					}
				}
			});



			this.stage = stage; 
			this.root = root;
			//WordFactory wordFactory = new WordFactory(gc);
			//GameObject word = wordFactory.createProduct();
			playView = new PlayView(this, stage);

		}

	@Override
	public void handle(Event event)
	{

	}
}