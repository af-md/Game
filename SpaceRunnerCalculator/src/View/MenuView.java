package View;

import Utilities.GeneralUtils;
import controllers.MenuController;
import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MenuView {
	Pane root;
    Button playButton;
    Button exitButton;

	// moving background
	public GridPane gridPane;
	public GridPane gridPane2;

	private GeneralUtils generalUtils;
	public AnimationTimer animationTimer;

	public MenuView(MenuController menuController, Stage stage){
	root = new Pane();
	Scene scene = new Scene(root, 600, 800);
	stage.setScene(scene);
	stage.show();

	generalUtils = new GeneralUtils();

	playButton = new Button("Play Game");
	playButton.setLayoutX(120);
	playButton.setLayoutY(50.0);
	playButton.setPrefWidth(350.0);
	playButton.setPrefHeight(80.0);
	playButton.setTextFill(Color.BLACK);
	playButton.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
	playButton.setOnAction(menuController);
	
	exitButton = new Button("EXIT");
	exitButton.setLayoutX(120);
	exitButton.setLayoutY(172.0);
	exitButton.setPrefWidth(350.0);
	exitButton.setPrefHeight(80.0);
	exitButton.setTextFill(Color.BLACK);
	exitButton.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
	exitButton.setOnAction(menuController);

	//createButton();
	createBackground();
	createGameAnimationLoop();
	root.getChildren().addAll( playButton, exitButton);
	
}

public void createButton(){
	// get button
	MenuButton menuButton = new MenuButton("Play", 208, 50.0);

	menuButton.setPrefWidth(190);
	menuButton.setPrefHeight(45);
	// add to root
	root.getChildren().add(menuButton);
};

	private void createGameAnimationLoop()
	{
		animationTimer = new AnimationTimer() {
			@Override
			public void handle(long l) {
				generalUtils.moveBackground(gridPane, gridPane2);
			}
		};
		animationTimer.start();
	};

public Button getPlayButton()
{
	return playButton;
}

public Button getExitButton()
{
	return exitButton;
}

public void createBackground(){
		Node[] gridPanes = generalUtils.createGridPanesForLayout();
		gridPane = (GridPane) gridPanes[0];
		gridPane2 = (GridPane) gridPanes[1];
		root.getChildren().addAll(gridPane, gridPane2);
	};

}
