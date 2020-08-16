package controllers;

import View.MenuView;
import View.OperationView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import strategy.Multiplication;

public class OperationController implements EventHandler {
    private Pane root;

    private Stage stage;

    private OperationView operationView;

    private PlayController playController;

    public OperationController(Stage stage)
    {
        Pane root = new Pane();
        Scene scene = new Scene(root, 600, 800);
        stage.setScene(scene);
        stage.show();
        this.stage = stage;
        this.root = root;
        operationView = new OperationView(this, root);
    }

    @Override
    public void handle(Event event) {
        if (event.getSource().equals(operationView.getMultiplication()))
        {
            // think this flow again
            playController = new PlayController(stage, new Multiplication());
        }
    }
}
