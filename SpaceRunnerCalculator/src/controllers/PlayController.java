package controllers;

import Utilities.GeneralUtils;
import View.PlayView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.GroupedNodes;
import model.IFactory;
import model.Factory;
import strategy.IStrategy;

public class PlayController implements EventHandler {
		
	private PlayView playView;
	private Stage stage;


	public boolean isLeftKeyPressed;
	public boolean isRightKeyPressed;

	//collision
	private static final int STAR_RADIUS  = 12;
	private static final int SHIP_RADIUS  = 27;
	private static final int METEOR_RADIUS  = 20;

	// to create motion when pressing left right keyboard keys
	private int angle;

	//factory for objects
	private IFactory factory;

	private IStrategy concreteStrategy;

	public GeneralUtils generalUtils;

	public PlayController(Stage stage, IStrategy concreteStrategy)
		{
			// instantiate general utils
			generalUtils = new GeneralUtils();
			this.concreteStrategy = concreteStrategy;
			this.stage = stage;

			factory = new Factory();

			// get images from a factory
			ImageView shipModel = (ImageView) factory.createObject("ship");
			GroupedNodes[] brownMeteorModels = (GroupedNodes[]) factory.createObject("operands");
			ImageView[] playerLivesModels = (ImageView[]) factory.createObject("livesStatus");

			playView = new PlayView(this, stage, shipModel, brownMeteorModels, playerLivesModels, concreteStrategy.getRandomNumber(), concreteStrategy.getOperator());
		}

	@Override
	public void handle(Event event) {

		// cast to get eventType
		KeyEvent keyEvent = (KeyEvent) event;

		if (keyEvent.getEventType() == KeyEvent.KEY_PRESSED){

			if (keyEvent.getCode() == KeyCode.LEFT)
			{
				isLeftKeyPressed = true;
			}
			if (keyEvent.getCode() == KeyCode.RIGHT)
			{
				isRightKeyPressed = true;
			}
		} else if (keyEvent.getEventType() == KeyEvent.KEY_RELEASED){
			if (keyEvent.getCode() == KeyCode.LEFT)
			{
				isLeftKeyPressed = false;
			}
			if (keyEvent.getCode() == KeyCode.RIGHT)
			{
				isRightKeyPressed = false;
			}
		}
	}

	/**
	 * Moves ship by checking on each frame whether right key or left key are pressed by the user
	 */
	public void moveShip()
	{
		if (isLeftKeyPressed && !isRightKeyPressed){
			if (angle > -30){
				angle -= 5;
			}
			playView.ship.setRotate(angle);
			if (playView.ship.getLayoutX() > -20)
			{
				playView.ship.setLayoutX(playView.ship.getLayoutX() -3);
			}
		}
		if (!isLeftKeyPressed && isRightKeyPressed){
			if (angle < 30){
				angle += 5;
			}
			playView.ship.setRotate(angle);
			if (playView.ship.getLayoutX() < 522)
			{
				playView.ship.setLayoutX(playView.ship.getLayoutX() +3);
			}
		}
		if (!isLeftKeyPressed && !isRightKeyPressed){
			if (angle < 0) {
				angle += 5;
			} else if (angle > 0){
				angle -= 0;
			}
			playView.ship.setRotate(angle);
		}
		if (isLeftKeyPressed && isRightKeyPressed){
			if (angle < 0) {
				angle += 5;
			} else if (angle > 0){
				angle -= 0;
			}
			playView.ship.setRotate(angle);
		}
	};

	/**
	 * By using the radius of the 2 objects on the pane, this method determines whether they're circumference have been in contact with each other.
	 */
	public void checkIfElementCollide(){
		for (int i = 0; i < playView.brownMeteors.length; i++) {
			if (METEOR_RADIUS + SHIP_RADIUS > generalUtils.calculateDistance(playView.ship.getLayoutX() + 49, playView.brownMeteors[i].getLayoutX() + 20, playView.ship.getLayoutY() + 37, playView.brownMeteors[i].getLayoutY()+ 20)){
				concreteStrategy.addToNumberList(playView.brownMeteors[i].getNumber());
				checkAnswer();
				generalUtils.setRandomGroupElementPosition(playView.brownMeteors[i]);
			}
		}
	};

	/**
	 * Uses concrete strategy to check whether the answer is correct
	 */
	public void checkAnswer(){
		if (concreteStrategy.canCalculateAnswer()){
			setChosenOperandsOnAnswerGuide(String.valueOf(concreteStrategy.getNumberList().get(0)), String.valueOf(concreteStrategy.getNumberList().get(1)));
			if (concreteStrategy.checkAnswer()){
				// add points to the view if answer is correct
				playView.points++;
				String textToSet = "POINTS : ";
				if (playView.points < 10){
					textToSet = textToSet + "0";
				}
				playView.setTextCustomLabel(textToSet);
				resetRandomNumber();
			} else {
				playView.removeLife();
				resetRandomNumber();
			}
		} else {
			setChosenOperandsOnAnswerGuide(String.valueOf(concreteStrategy.getNumberList().get(0)), "");
		}
	}

	private void resetRandomNumber() {
		playView.randomNumber = concreteStrategy.getRandomNumber();
		playView.setAnswerGuide("", "");
	}

	/**
	 * Takes in the operands of an operation and displays them on the label on the view
	 * @param firstOperand
	 * @param secondOperand
	 */
	private void setChosenOperandsOnAnswerGuide(String firstOperand, String secondOperand) {
		if (secondOperand != "")
		playView.setAnswerGuide(firstOperand, secondOperand);
		else playView.setAnswerGuide(firstOperand, "");
	}
	;
}