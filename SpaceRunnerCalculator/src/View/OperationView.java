package View;

import Utilities.GeneralUtils;
import controllers.OperationController;
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

public class OperationView {
    private final Stage stage;
    private Pane root;
    private OperationController operationController;

    // moving background
    public GridPane gridPane;
    public GridPane gridPane2;

    private GeneralUtils generalUtils;
    private AnimationTimer animationTimer;

    private Button multiplication;
    private Button addition;
    private Button subtraction;
    private Button division;

    public OperationView(OperationController operationController, Stage stage) {
        super();
        root = new Pane();
        Scene scene = new Scene(root, 600, 800);
        stage.setScene(scene);
        stage.show();
        this.stage = stage;
        this.operationController = operationController;

        generalUtils = new GeneralUtils();

        multiplication = new Button("Multiplication");
        multiplication.setLayoutX(120);
        multiplication.setLayoutY(50.0);
        multiplication.setPrefWidth(350.0);
        multiplication.setPrefHeight(80.0);
        multiplication.setTextFill(Color.BLACK);
        multiplication.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
        multiplication.setOnAction(operationController);

        addition = new Button("Addition");
        addition.setLayoutX(120);
        addition.setLayoutY(172.0);
        addition.setPrefWidth(350.0);
        addition.setPrefHeight(80.0);
        addition.setTextFill(Color.BLACK);
        addition.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
        addition.setOnAction(operationController);


        subtraction = new Button("Subtraction");
        subtraction.setLayoutX(120);
        subtraction.setLayoutY(290);
        subtraction.setPrefWidth(350.0);
        subtraction.setPrefHeight(80.0);
        subtraction.setTextFill(Color.BLACK);
        subtraction.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
        subtraction.setOnAction(operationController);



        division = new Button("Division");
        division.setLayoutX(120);
        division.setLayoutY(420);
        division.setPrefWidth(350.0);
        division.setPrefHeight(80.0);
        division.setTextFill(Color.BLACK);
        division.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
        division.setOnAction(operationController);
        createBackground();
        createGameAnimationLoop();
        root.getChildren().addAll(addition, multiplication, subtraction, division);

    }

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

    public void createBackground(){
        Node[] gridPanes = generalUtils.createGridPanesForLayout();
        gridPane = (GridPane) gridPanes[0];
        gridPane2 = (GridPane) gridPanes[1];
        root.getChildren().addAll(gridPane, gridPane2);
    };

    public Button getMultiplication() {
        return multiplication;
    }

    public Button getAddition() {
        return addition;
    }

    public Button getSubtraction() {
        return subtraction;
    }

    public Button getDivision() {
        return division;
    }

}
