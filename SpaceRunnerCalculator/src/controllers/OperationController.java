package controllers;

import View.MenuView;
import View.OperationView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import strategy.*;

public class OperationController implements EventHandler {

    private Stage stage;

    private OperationView operationView;

    private PlayController playController;

    public OperationController(Stage stage)
    {
        this.stage = stage;
        operationView = new OperationView(this, stage);
    }

    @Override
    public void handle(Event event) {
        if (event.getSource().equals(operationView.getMultiplication()))
        {
            // TODO full MVC
            playController = new PlayController(stage, new Multiplication());
        }
        if (event.getSource().equals(operationView.getAddition())){
            playController = new PlayController(stage, new Addition());
        }
        if (event.getSource().equals(operationView.getDivision())){
            playController = new PlayController(stage, new Division());
        }
        if (event.getSource().equals(operationView.getSubtraction())){
            playController = new PlayController(stage, new Subtraction());
        }
    }
}
