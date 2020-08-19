package controllers;

import View.OperationView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import strategy.*;

public class OperationController implements EventHandler {

    private Stage stage;

    private OperationView operationView;

    public OperationController(Stage stage)
    {
        this.stage = stage;
        operationView = new OperationView(this, stage);
    }

    @Override
    public void handle(Event event) {
        if (event.getSource().equals(operationView.getMultiplication()))
        {
            PlayController playController = new PlayController(stage, new Multiplication());
        }
        if (event.getSource().equals(operationView.getAddition())){
            PlayController playController = new PlayController(stage, new Addition());
        }
        if (event.getSource().equals(operationView.getDivision())){
            PlayController playController = new PlayController(stage, new Division());
        }
        if (event.getSource().equals(operationView.getSubtraction())){
            PlayController playController = new PlayController(stage, new Subtraction());
        }
    }
}
