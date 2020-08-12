package View;
import controllers.PlayController;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model2.Ship;

import java.util.Random;

public class PlayView {
    private Pane root;

    private Stage stage;

    private PlayView playView;

    private GraphicsContext gc;

    private Canvas canvas;

    private boolean isLeftKeyPressed;
    private boolean isRightKeyPressed;

    private static final int GAME_WIDTH = 600;
    private static final int GAME_HEIGHT = 800;

    private GridPane gridPane;
    private GridPane gridPane2;


    private int angle;
    private AnimationTimer animationTimer;
    private ImageView ship;

    private ImageView[] brownMeteors;
    private ImageView[] greyMeteors;
    Random randomPositionGenerator;

    // points and lifes. make static capital
    private static final String shipLifeImagePath = "resource/playerLife1_blue.png";
    private ImageView star;
    private CustomLabel customLabel;
    private ImageView[] playerLives;
    private int playerLife;
    private int points;
    private static final String goldStar = "resource/star_gold.png";

    //collision
    private static final int STAR_RADIUS  = 12;
    private static final int SHIP_RADIUS  = 27;
    private static final int METEOR_RADIUS  = 20;

    // TODO
    // logic for points greater then 20
    //
    public PlayView(PlayController playController, Stage stage)
    {
        root = new Pane();
        Scene scene = new Scene(root, GAME_WIDTH, GAME_HEIGHT);
        stage.setScene(scene);
        stage.show();

        randomPositionGenerator = new Random();
        canvas = new Canvas(GAME_WIDTH,GAME_HEIGHT);

        gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.WHITE);

        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.LEFT)
                {
                    isLeftKeyPressed = true;
                }
                if (keyEvent.getCode() == KeyCode.RIGHT)
                {
                    isRightKeyPressed = true;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.LEFT)
                {
                    isLeftKeyPressed = false;
                }
                if (keyEvent.getCode() == KeyCode.RIGHT)
                {
                    isRightKeyPressed = false;
                }
            }
        });

        root.getChildren().add(canvas);
        createBackground();
        createShip();
        createGameElements();
        createGameAnimationLoop();
    }

    private void createShip() {
        ship = new ImageView("resource/playerShip1_blue.png");
        ship.setLayoutX(GAME_WIDTH/2);
        ship.setLayoutY(GAME_HEIGHT - 90);
        root.getChildren().add(ship);
    }

    private void createGameAnimationLoop()
    {
         animationTimer = new AnimationTimer() {
             @Override
             public void handle(long l) {
                 moveBackground();
                 moveGameElement();
                 relocateElementToTheTop();
                 checkIfElementCollide();
                 moveShip();
             }
         };
         animationTimer.start();
    };

    private void moveShip()
    {
        if (isLeftKeyPressed && !isRightKeyPressed){
            if (angle > -30){
                angle -= 5;
            }
            ship.setRotate(angle);
            if (ship.getLayoutX() > -20)
            {
                ship.setLayoutX(ship.getLayoutX() -3);
            }
        }
        if (!isLeftKeyPressed && isRightKeyPressed){
            if (angle < 30){
                angle += 5;
            }
            ship.setRotate(angle);
            if (ship.getLayoutX() < 522)
            {
                ship.setLayoutX(ship.getLayoutX() +3);
            }
        }
        if (!isLeftKeyPressed && !isRightKeyPressed){
            if (angle < 0) {
                angle += 5;
            } else if (angle > 0){
                angle -= 0;
            }
            ship.setRotate(angle );
        }
        if (isLeftKeyPressed && isRightKeyPressed){
            if (angle < 0) {
                angle += 5;
            } else if (angle > 0){
                angle -= 0;
            }
            ship.setRotate(angle );
        }
    };

    private void createBackground(){
      gridPane = new GridPane();
      gridPane2 = new GridPane();

        for (int i = 0; i < 12; i++) {
            ImageView backgroundImage = new ImageView("resource/purple.png");
            ImageView backgroundImage2 = new ImageView("resource/purple.png");
            GridPane.setConstraints(backgroundImage, i%3, i/3 );
            GridPane.setConstraints(backgroundImage2, i%3, i/3 );
            gridPane.getChildren().add(backgroundImage);
            gridPane2.getChildren().add(backgroundImage2);
        }

        gridPane2.setLayoutY(-1024);
        root.getChildren().addAll(gridPane, gridPane2);
    };

    private void moveBackground(){
        gridPane.setLayoutY(gridPane.getLayoutY() + 0.5);
        gridPane2.setLayoutY(gridPane2.getLayoutY() + 0.5);

        if (gridPane.getLayoutY() >= 1024){
            gridPane.setLayoutY(-1024);
        };


        if (gridPane2.getLayoutY() >= 1024){
            gridPane2.setLayoutY(-1024);
        };
    };

    private void createGameElements(){
        playerLife = 2;
        star = new ImageView(goldStar);
        setRandomElementPosition(star);
        root.getChildren().add(star);
        customLabel = new CustomLabel("POINTS: 00");
        customLabel.setLayoutX(460);
        customLabel.setLayoutY(20);
        root.getChildren().add(customLabel);
        playerLives = new ImageView[3];
        for (int i = 0; i < 3; i++) {
            playerLives[i] =  new ImageView(shipLifeImagePath);
            playerLives[i].setLayoutX(455 + (i * 50));
            playerLives[i].setLayoutY(80);
            root.getChildren().add(playerLives[i]);
        }


        brownMeteors = new ImageView[3];
        for (int i = 0; i < 3; i++) {
            brownMeteors[i] =  new ImageView("resource/meteorBrown_big3.png");
            setRandomElementPosition(brownMeteors[i]);
            root.getChildren().add(brownMeteors[i]);
        }
        greyMeteors = new ImageView[3];
        for (int i = 0; i < 3; i++) {
            greyMeteors[i] =  new ImageView("resource/meteorGrey_big3.png");
            setRandomElementPosition(greyMeteors[i]);
            root.getChildren().add(greyMeteors[i]);
        }
    };

    private void setRandomElementPosition(ImageView imageView){
         imageView.setLayoutX(randomPositionGenerator.nextInt(370));
         imageView.setLayoutY(-(randomPositionGenerator.nextInt(3200))+600);
    };

    private void moveGameElement(){
        star.setLayoutY(star.getLayoutY() + 5);

        for (int i = 0; i < brownMeteors.length; i++) {
            brownMeteors[i].setLayoutY(brownMeteors[i].getLayoutY()+7);
            brownMeteors[i].setRotate(brownMeteors[i].getRotate()+4);
        }

        for (int i = 0; i < greyMeteors.length; i++) {
            greyMeteors[i].setLayoutY(greyMeteors[i].getLayoutY()+7);
            greyMeteors[i].setRotate(greyMeteors[i].getRotate()+4);
        }
    };

    private void relocateElementToTheTop(){
        if (star.getLayoutY()>1200){
            setRandomElementPosition(star);
        }

        for (int i = 0; i < brownMeteors.length; i++) {
            if (brownMeteors[i].getLayoutY() > 900){
             setRandomElementPosition(brownMeteors[i]);
            }
        }

        for (int i = 0; i < greyMeteors.length; i++) {
            if (greyMeteors[i].getLayoutY() > 900){
                setRandomElementPosition(greyMeteors[i]);
            }
        }
    };

    private void checkIfElementCollide(){
        if (SHIP_RADIUS + STAR_RADIUS > calculateDistance(ship.getLayoutX() + 49, star.getLayoutX() + 15, ship.getLayoutY() + 37, star.getLayoutY() + 15)){
            setRandomElementPosition(star);
            points++;
            String textToSet = "POINTS : ";
            if (points < 10){
                textToSet = textToSet + "0";
            }
            customLabel.setText(textToSet + points);
        }

        for (int i = 0; i < brownMeteors.length; i++) {
            if (METEOR_RADIUS + SHIP_RADIUS > calculateDistance(ship.getLayoutX() + 49, brownMeteors[i].getLayoutX() + 20, ship.getLayoutY() + 37, brownMeteors[i].getLayoutY()+ 20)){
                removeLife();
                setRandomElementPosition(brownMeteors[i]);
            }
        }

        for (int i = 0; i < greyMeteors.length; i++) {
            if (METEOR_RADIUS + SHIP_RADIUS > calculateDistance(ship.getLayoutX() + 49, greyMeteors[i].getLayoutX() + 20, ship.getLayoutY() + 37, greyMeteors[i].getLayoutY()+ 20)){
                removeLife();
                setRandomElementPosition(greyMeteors[i]);
            }
        }
    };
    private void removeLife(){
      root.getChildren().remove(playerLives[playerLife]);
      playerLife--;
      if (playerLife < 0){
        stage.close();
        animationTimer.stop();

      };
    };

    private double calculateDistance(double x1, double x2, double y1, double y2){
        return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));

    }
}