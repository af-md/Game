package View;

import controllers.OperationController;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class OperationView {
    private Pane root;
    private OperationController operationController;

    public Button getMultiplication() {
        return multiplication;
    }

    private Button multiplication;

    public Button getAddition() {
        return addition;
    }

    private Button addition;

    public Button getSubtraction() {
        return subtraction;
    }

    private Button subtraction;

    public Button getDivision() {
        return division;
    }

    private Button division;

    public OperationView(OperationController operationController, Pane root) {
        super();
        this.root = root;
        this.operationController = operationController;

        multiplication = new Button("Multiplication");
        multiplication.setLayoutX(208);
        multiplication.setLayoutY(50.0);
        multiplication.setPrefWidth(350.0);
        multiplication.setPrefHeight(80.0);
        multiplication.setTextFill(Color.BLACK);
        multiplication.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
        multiplication.setOnAction(operationController);

        addition = new Button("Addiction");
        addition.setLayoutX(208);
        addition.setLayoutY(172.0);
        addition.setPrefWidth(350.0);
        addition.setPrefHeight(80.0);
        addition.setTextFill(Color.BLACK);
        addition.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
        addition.setOnAction(operationController);


        subtraction = new Button("Subtraction");
        subtraction.setLayoutX(208);
        subtraction.setLayoutY(220.0);
        subtraction.setPrefWidth(350.0);
        subtraction.setPrefHeight(80.0);
        subtraction.setTextFill(Color.BLACK);
        subtraction.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
        subtraction.setOnAction(operationController);



        division = new Button("Division");
        division.setLayoutX(208);
        division.setLayoutY(280.0);
        division.setPrefWidth(350.0);
        division.setPrefHeight(80.0);
        division.setTextFill(Color.BLACK);
        division.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
        division.setOnAction(operationController);

        root.getChildren().addAll(addition, multiplication, subtraction, division);

    }
}
