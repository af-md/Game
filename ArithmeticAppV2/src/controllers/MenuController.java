package controllers;

import View.MenuView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MenuController implements EventHandler{

	
		private Pane root; 
		
		private Stage stage;
		
		private MenuView menuView;

		public MenuController(Stage stage)
		{
		  	Pane root = new Pane();
			Scene scene = new Scene(root, 800, 800);
		  	stage.setScene(scene);
		  	stage.show();
			this.stage = stage; 
			this.root = root; 
			menuView = new MenuView(this, root);
		}
		
		

		@Override
		public void handle(Event event) {
			
				if (event.getSource().equals(menuView.getPlayButton()))
						{
							// think this flow again
							PlayController playController = new PlayController(stage);
						}
				else if (event.getSource().equals(menuView.getExitButton()))
				{
					// shut the application
				}
		}	
		
		public Stage getStage()
		{
			return stage;
		}
		
		public MenuView getMenuView()
		{
			return menuView; 
		}
		
	

}
