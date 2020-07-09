package controllers;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Stack;

import View.MenuView;
import View.OperationView;
import View.PlayView;



public class PlayController implements EventHandler {

	private Pane root; 
	
	private Stage stage;
	
	private PlayView playView; 
	
	OperationView operationView; 
	
	private String operationString;
	
	private int counter; 
	
	private Stack stack; 
	
	private int result; 
	
	public PlayController(Stage stage, String operatioString)
	{
	  	BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 800, 800);
	  	stage.setScene(scene);
	  	stage.show();
		this.stage = stage; 
		this.root = root; 
		this.operationString = operationString;
		stack = new Stack(); 
		counter = 0; 
		result = 0; 
		playView = new PlayView(this, root);
	}
	
	

	@Override
	public void handle(Event event) {
		// TODO Auto-generated method stub
		
		if(event.getSource().equals(playView.getImageViewNumber0()))
				{
				
				if(counter < 2){
					stack.push(0);
				}
				else if (counter == 2)
				{
					stack.push(0);
					calculate();
					}
				}
		if(event.getSource().equals(playView.getImageViewNumber1()))
		{
		
		if(counter < 2){
			stack.push(1);
		}
		else if (counter == 2)
		{
			stack.push(1);
			calculate();
			}
		}
		if(event.getSource().equals(playView.getImageViewNumber2()))
		{
		
		if(counter < 2){
			stack.push(0);
		}
		else if (counter == 2)
		{
			stack.push(2);
			calculate();
			}
		}
		if(event.getSource().equals(playView.getImageViewNumber3()))
		{
		
		if(counter < 2){
			stack.push(3);
		}
		else if (counter == 2)
		{
			stack.push(3);
			calculate();
			}
		}
		if(event.getSource().equals(playView.getImageViewNumber4()))
		{
		
		if(counter < 2){
			stack.push(4);
		}
		else if (counter == 2)
		{
			stack.push(4);
			calculate();
			}
		}
		if(event.getSource().equals(playView.getImageViewNumber5()))
		{
		
		if(counter < 2){
			stack.push(5);
		}
		else if (counter == 2)
		{
			stack.push(5);
			calculate();
			}
		}
		if(event.getSource().equals(playView.getImageViewNumber6()))
		{
		
		if(counter < 2){
			stack.push(6);
		}
		else if (counter == 2)
		{
			stack.push(6);
			calculate();
			}
		}
		if(event.getSource().equals(playView.getImageViewNumber7()))
		{
		
		if(counter < 2){
			stack.push(7);
		}
		else if (counter == 2)
		{
			stack.push(7);
			calculate();
			}
		}
		if(event.getSource().equals(playView.getImageViewNumber8()))
		{
		
		if(counter < 2){
			stack.push(8);
		}
		else if (counter == 2)
		{
			stack.push(8);
			calculate();
			}
		}
		if(event.getSource().equals(playView.getImageViewNumber9()))
		{
		
		if(counter < 2){
			stack.push(9);
		}
		else if (counter == 2)
		{
			stack.push(9);
			calculate();
			}
		}
		
		
	}	
	
	public Stage getStage()
	{
		return stage;
	}
	
	public PlayView getPlayView()
	{
		return playView; 
	}
	
		
		public void calculate()
		{
			int number2  = (int) stack.pop();
			int number1 = (int) stack.pop(); 
			
			result = number1 + number2;  
		}
		
	public int getResult()
	{
		return result; 
	}
	
}
