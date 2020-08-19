package View;
import Utilities.GeneralUtils;
import controllers.PlayController;
import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import components.CustomLabel;
import model.GroupedNodes;


public class PlayView {

    public int randomNumber;
    private Stage stage;
    private PlayController playController;
    public AnimationTimer animationTimer;
    private Pane root;
    public GeneralUtils generalUtils;

    // moving background
    public GridPane gridPane;
    public GridPane gridPane2;

    // UI Elements
    public GroupedNodes[] brownMeteors;

    // points and lives. make static capital
    private CustomLabel customPointLabel;
    public CustomLabel answerGuide;
    private ImageView[] playerLives;
    private int playerLife;
    public int points;
    private String operator;

    private static final int GAME_WIDTH = 600;
    private static final int GAME_HEIGHT = 800;

    public ImageView ship;

    public PlayView(PlayController playController, Stage stage, ImageView ship, GroupedNodes[] brownMeteors, ImageView[] playerLives, int randomNumber, String operator)
    {
        root = new Pane();
        this.stage = stage;
        this.playController = playController;
        Scene scene = new Scene(root, GAME_WIDTH, GAME_HEIGHT);
        stage.setScene(scene);
        generalUtils = new GeneralUtils();


        createBackground();

        // add elements
        this.ship = ship;
        root.getChildren().add(ship);
        this.brownMeteors = brownMeteors;
        addElementsToPane(brownMeteors);
        playerLife = 2;
        this.operator = operator;
        createPointsLabel();
        this.randomNumber = randomNumber;
        createRandomNumberLabel(randomNumber, operator, "", "");
        this.playerLives = playerLives;
        addElementsToPane(playerLives);
        stage.show();

        // set event subscriber
        scene.setOnKeyPressed(playController);
        scene.setOnKeyReleased(playController);

        // start the animation loop frame
        createGameAnimationLoop();

    }


    private void createGameAnimationLoop()
    {
         animationTimer = new AnimationTimer() {
             @Override
             public void handle(long l) {
                 generalUtils.moveBackground(gridPane, gridPane2);
                 moveGameElement();
                 relocateElementToTheTop();
                 playController.checkIfElementCollide();
                playController.moveShip();
             }
         };
         animationTimer.start();
    };

    public void createBackground(){
        Node[] gridPanes = generalUtils.createGridPanesForLayout();
        gridPane = (GridPane) gridPanes[0];
        gridPane2 = (GridPane) gridPanes[1];
        root.getChildren().addAll(gridPane, gridPane2);
    };


    public void addElementsToPane(Node[] node) {
        for (int i = 0; i < node.length; i++) {
            root.getChildren().add(node[i]);
        }
    }

    private void createPointsLabel() {
        customPointLabel = new CustomLabel("POINTS: 00");
        customPointLabel.setLayoutX(460);
        customPointLabel.setLayoutY(20);
        root.getChildren().add(customPointLabel);
    }

    public void createRandomNumberLabel(int randomNumber, String operator, String firstNumber, String secondNumber) {
        answerGuide = new CustomLabel(firstNumber + "   " + operator + "   " + secondNumber  + "   =     " + randomNumber);
        answerGuide.setLayoutX(460);
        answerGuide.setLayoutY(120);
        answerGuide.setFont(new Font(20));
        root.getChildren().add(answerGuide);
    }

    public void moveGameElement(){
        for (int i = 0; i < brownMeteors.length; i++) {
            brownMeteors[i].setLayoutY(brownMeteors[i].getLayoutY()+7);
        }
    };

    public void relocateElementToTheTop(){
        for (int i = 0; i < brownMeteors.length; i++) {
            if (brownMeteors[i].getLayoutY() > 900){
                generalUtils.setRandomGroupElementPosition(brownMeteors[i]);
            }
        }

    };

    public void setTextCustomLabel(String textToSet){
        customPointLabel.setText(textToSet + points);
    };

    public void setAnswerGuide(String  firstNumber, String secondNumber){
        answerGuide.setText(firstNumber + "   " + operator + "   " + secondNumber  + "   =     " + randomNumber);
    };

    public void removeLife(){
        root.getChildren().remove(playerLives[playerLife]);
        playerLife--;
        if (playerLife < 0){
            stage.close();
            animationTimer.stop();
        };
    };
}