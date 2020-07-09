package View;


import java.util.ArrayList;

import model2.GameObject;
import model2.NumberFactory;
import controllers.PlayController;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class PlayView {
	
		Canvas canvas;
		GraphicsContext gc;
		AnchorPane gamePane;
		BorderPane root;
		GridPane bottomPane;
		Label questionLabel;
		Label pointsLabel;
		Label triesLabel;
		Button backButton;
		ImageView Number0;
		ImageView Number1;
		ImageView Number2;
		ImageView Number3;
		ImageView Number4;
		ImageView Number5;
		ImageView Number6;
		ImageView Number7;
		ImageView Number8;
		ImageView Number9;
		private int result; 
	
		private int numberPane1; 
		private int numberPane2; 
		
		
		public PlayView(PlayController playController, BorderPane root) {
			super();
			this.root =  root;
			canvas = new Canvas(600, 300);
			gc = canvas.getGraphicsContext2D();
			pointsLabel = new Label("Question label");
			triesLabel = new Label("Tries label");
			root.setTop(designTopLabel());
			root.getChildren().add(canvas);
			
			
			// get product from factory. Create Image View and assign position
			
			NumberFactory factory = new NumberFactory();
			GameObject number0 = factory.createProduct(0);
			Number0 = number0.getImage(); 
			Number0.setFitWidth(94);
			Number0.setFitHeight(118);
			root.getChildren().add(Number0);
			Number0.setLayoutX(20);
			Number0.setLayoutY(110);
			Number0.setOnMouseClicked(playController);
			
			GameObject number1 = factory.createProduct(1);
			Number1 = number1.getImage(); 
			Number1.setFitWidth(94);
			Number1.setFitHeight(118);
			root.getChildren().add(Number1);
			Number1.setLayoutX(140);
			Number1.setLayoutY(110);
			
			GameObject number2 = factory.createProduct(2);
			Number2 = number2.getImage(); 
			Number2.setFitWidth(94);
			Number2.setFitHeight(118);
			root.getChildren().add(Number2);
			Number2.setLayoutX(60);
			Number2.setLayoutY(340);
			
			GameObject number3 = factory.createProduct(3);
			Number3 = number3.getImage(); 
			Number3.setFitWidth(94);
			Number3.setFitHeight(118);
			root.getChildren().add(Number3);
			Number3.setLayoutX(340);
			Number3.setLayoutY(150);
			
			GameObject number4 = factory.createProduct(4);
			Number4 = number4.getImage(); 
			Number4.setFitWidth(94);
			Number4.setFitHeight(118);
			root.getChildren().add(Number4);
			Number4.setLayoutX(440);
			Number4.setLayoutY(340);
			
			GameObject number5 = factory.createProduct(5);
			Number5 = number5.getImage(); 
			Number5.setFitWidth(94);
			Number5.setFitHeight(118);
			root.getChildren().add(Number5);
			Number5.setLayoutX(340);
			Number5.setLayoutY(440);
			
			GameObject number6 = factory.createProduct(6);
			Number6 = number6.getImage(); 
			Number6.setFitWidth(94);
			Number6.setFitHeight(118);
			root.getChildren().add(Number6);
			Number6.setLayoutX(540);
			Number6.setLayoutY(340);
			
			GameObject number7 = factory.createProduct(7);
			Number7 = number7.getImage(); 
			Number7.setFitWidth(94);
			Number7.setFitHeight(118);
			root.getChildren().add(Number7);
			Number7.setLayoutX(340);
			Number7.setLayoutY(540);
			
			GameObject number8 = factory.createProduct(8);
			Number8 = number8.getImage(); 
			Number8.setFitWidth(94);
			Number8.setFitHeight(118);
			root.getChildren().add(Number8);
			Number8.setLayoutX(640);
			Number8.setLayoutY(340);
			
			GameObject number9 = factory.createProduct(9);
			Number9 = number9.getImage(); 
			Number9.setFitWidth(94);
			Number9.setFitHeight(118);
			root.getChildren().add(Number9);
			Number9.setLayoutX(340);
			Number9.setLayoutY(640);
		}

	
	public void updateView()
	{
		// update the view with the users clicked number
	}
	
	// adjust the lable on the top of the border pane
	public Label designTopLabel()
	{
		questionLabel = new Label("Question what is" + numberPane1 +  numberPane2 +  " = " + "20");
		questionLabel.setPrefWidth(800);
		questionLabel.setPrefHeight(100);
		questionLabel.setStyle("-fx-border-Style: dotted; -fx-border-width: 0 0 1 0; -fx-font-weight-:bold;");
		return questionLabel;
	}
	
	public Button designBackButton()
	{
		backButton = new Button("Operation Menu");
//		multiplication.setLayoutX(200);
//   	 	multiplication.setLayoutY(50.0);
//   	 	multiplication.setPrefWidth(200);
//   	 	multiplication.setPrefHeight(80.0);
//   	 	multiplication.setTextFill(Color.BLACK);
//   	 	multiplication.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
//   	 	multiplication.setOnAction(operationController);
		return backButton;
	}
	
	public ImageView getImageViewNumber0()
	{
		return Number0;
	}
	
	public ImageView getImageViewNumber1()
	{
		return Number1;
	}
	
	public ImageView getImageViewNumber2()
	{
		return Number2;
	}
	
	public ImageView getImageViewNumber3()
	{
		return Number3;
	}
	
	public ImageView getImageViewNumber4()
	{
		return Number4;
	}
	
	public ImageView getImageViewNumber5()
	{
		return Number5;
	}
	
	public ImageView getImageViewNumber6()
	{
		return Number6;
	}
	
	
	public ImageView getImageViewNumber7()
	{
		return Number7;
	}
	
	public ImageView getImageViewNumber8()
	{
		return Number8;
	}
	
	public ImageView getImageViewNumber9()
	{
		return Number9;
	}
	
	public int getResult() {
		return result;
	}


	public void setResult(int result) {
		this.result = result;
	}


	public int getNumberPane1() {
		return numberPane1;
	}


	public void setNumberPane1(int numberPane1) {
		this.numberPane1 = numberPane1;
	}


	public int getNumberPane2() {
		return numberPane2;
	}


	public void setNumberPane2(int numberPane2) {
		this.numberPane2 = numberPane2;
	}

	


}
