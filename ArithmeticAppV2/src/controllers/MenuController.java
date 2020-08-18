package controllers;

import View.MenuView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MenuController implements EventHandler{

		private Stage stage;
		
		private MenuView menuView;

		public MenuController(Stage stage)
		{
			this.stage = stage;
			menuView = new MenuView(this, stage);
		}

		@Override
		public void handle(Event event) {
			
				if (event.getSource().equals(menuView.getPlayButton()))
						{
							OperationController operationController = new OperationController(stage);
						}
				else if (event.getSource().equals(menuView.getExitButton()))
				{
					stage.close();
					menuView.animationTimer.stop();
				}
		}

}
