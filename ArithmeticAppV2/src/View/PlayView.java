package View;
import controllers.PlayController;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class PlayView {
	Pane root;
    Canvas canvas;
    GraphicsContext gc;
    AnchorPane gamePane;
    GridPane bottomPane;
	// TODO: change the name of this class
    public PlayView(PlayController playController, Pane root) {
        super();
        this.root = root;
        canvas = new Canvas(600, 300);
        gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
    }
}