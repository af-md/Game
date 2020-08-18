package Utilities;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.Random;

/**
 * Common functions are aggregated within this class to make them available to other classes
 */
public class GeneralUtils {

    public static final int RAISE_POWER = 2;
    public static final int BOUND_HORISONTAL_LAYOUT = 400;
    public static final int BOUND_VERTICAL_LAYOUT = 3000;
    public static final int VERTICAL_DEPTH = -1024;
    public static final int VERTICAL_HEIGHT = 1024;
    public Random randomGenerator;

    public GeneralUtils(){
        randomGenerator = new Random();
    }

    /**
     * sets the random position of a group element on a pane
     * @param group
     */
    public void setRandomGroupElementPosition(Group group){
        group.setLayoutX(randomGenerator.nextInt(BOUND_HORISONTAL_LAYOUT));
        group.setLayoutY(-(randomGenerator.nextInt(BOUND_VERTICAL_LAYOUT)));
    };

    /**
     * calculates the distance between 2 circles
     * @param x1
     * @param x2
     * @param y1
     * @param y2
     * @return int
     */
    public double calculateDistance(double x1, double x2, double y1, double y2){
        return Math.sqrt(Math.pow(x1-x2, RAISE_POWER) + Math.pow(y1-y2, RAISE_POWER));
    }

    /**
     * creates a grid pane layout
     * @return
     */
    public Node[] createGridPanesForLayout(){

        // create grids
        GridPane gridPane = new GridPane();
        GridPane gridPane2 = new GridPane();

        for (int i = 0; i < 12; i++) {
            ImageView backgroundImage = new ImageView("resource/purple.png");
            ImageView backgroundImage2 = new ImageView("resource/purple.png");
            GridPane.setConstraints(backgroundImage, i%3, i/3 );
            GridPane.setConstraints(backgroundImage2, i%3, i/3 );
            gridPane.getChildren().add(backgroundImage);
            gridPane2.getChildren().add(backgroundImage2);
        }

        gridPane2.setLayoutY(VERTICAL_DEPTH);

        // add grids to array
        Node[] gripPanes = new Node[2];
        gripPanes[0] = gridPane;
        gripPanes[1] = gridPane2;
        return  gripPanes;
    };

    /**
     * moves one of the grids 0.5 vertically and creates a background moving effect
     * @param gridPane
     * @param gridPane2
     */
    public void moveBackground(GridPane gridPane, GridPane gridPane2){
        gridPane.setLayoutY(gridPane.getLayoutY() + 0.5);
        gridPane2.setLayoutY(gridPane2.getLayoutY() + 0.5);

        if (gridPane.getLayoutY() >= VERTICAL_HEIGHT){
            gridPane.setLayoutY(VERTICAL_DEPTH);
        };


        if (gridPane2.getLayoutY() >= VERTICAL_HEIGHT){
            gridPane2.setLayoutY(VERTICAL_DEPTH);
        };
    };
}
