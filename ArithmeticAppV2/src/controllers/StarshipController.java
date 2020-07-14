package controllers;

import View.StarshipView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StarshipController implements EventHandler {

		private Pane root; 
		
		private Stage stage;
		
		private StarshipView starshipView;
		
		public StarshipController(Stage stage)
		{
		  	Pane root = new Pane();
			Scene scene = new Scene(root, 800, 800);
		  	stage.setScene(scene);
		  	stage.show();
			this.stage = stage; 
			this.root = root; 
			starshipView = new StarshipView(this, root);
		}
		
		

		@Override
		public void handle(Event event) {

		}	
		
	}