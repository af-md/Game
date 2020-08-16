package View;

import controllers.MenuController;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class MenuView {
	Pane root;
    Button playButton;
    Button exitButton;

	
public MenuView(MenuController menuController, Pane root){
	super();
	this.root = root;

	playButton = new Button("Play Game");
	playButton.setLayoutX(208);
	playButton.setLayoutY(50.0);
	playButton.setPrefWidth(350.0);
	playButton.setPrefHeight(80.0);
	playButton.setTextFill(Color.BLACK);
	playButton.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
	playButton.setOnAction(menuController);
	
	exitButton = new Button("EXIT");
	exitButton.setLayoutX(208);
	exitButton.setLayoutY(172.0);
	exitButton.setPrefWidth(350.0);
	exitButton.setPrefHeight(80.0);
	exitButton.setTextFill(Color.BLACK);
	exitButton.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
	exitButton.setOnAction(menuController);

	//createButton();

	root.getChildren().addAll( playButton, exitButton);
	
}

public void updateView()
{
	// update the view with the users clicked number
}

public void createButton(){
	// get button
	MenuButton menuButton = new MenuButton("Play", 208, 50.0);

	menuButton.setPrefWidth(190);
	menuButton.setPrefHeight(45);
	// add to root
	root.getChildren().add(menuButton);
};

public Button getPlayButton()
{
	return playButton;
}

public Button getExitButton()
{
	return exitButton;
}
}
