package controllers;

import View.MenuView;
import View.OperationView;
import View.PlayView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class OperationController implements EventHandler {

		private Pane root; 
		
		private Stage stage;
		
		private OperationView operationView; 
		
		public OperationController(Stage stage)
		{
		  	Pane root = new Pane();
			Scene scene = new Scene(root, 800, 800);
		  	stage.setScene(scene);
		  	stage.show();
			this.stage = stage; 
			this.root = root; 
			operationView = new OperationView(this, root);
		}
		
		

		@Override
		public void handle(Event event) {
			
			if (event.getSource().equals(operationView.getAdditionButton()))
			{
				PlayController playController = new PlayController(stage, "addition");
			}
			else if (event.getSource().equals(operationView.getDivisionButton()))
			{
				PlayController playController = new PlayController(stage, "division");
				
			}
			else if (event.getSource().equals(operationView.getMultiplicationButton()))
			{
				PlayController playController = new PlayController(stage, "multiplication");
				
			}
			else if (event.getSource().equals(operationView.getSubtractionButton()))
			{
				PlayController playController = new PlayController(stage, "subtraction");
				
			}
		}	
		
	}

