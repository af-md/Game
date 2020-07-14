package View;
import controllers.StarshipController;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class StarshipView {
	Pane root;
    Canvas canvas;
    GraphicsContext gc;
    AnchorPane gamePane;
    GridPane bottomPane;
	// TODO: change the name of this class
    public StarshipView(StarshipController starshipController, Pane root) {
        super();
        this.root = root;
        canvas = new Canvas(600, 300);
        gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
    }
}