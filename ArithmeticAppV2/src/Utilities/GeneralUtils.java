package Utilities;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.Random;

public class GeneralUtils {

    public Random randomGenerator;

    public GeneralUtils(){
        randomGenerator = new Random();
    }
    public  void setRandomElementPosition(ImageView imageView){
        imageView.setLayoutX(randomGenerator.nextInt(370));
        imageView.setLayoutY(-(randomGenerator.nextInt(3200))+600);
    };

    public void setRandomElementPosition2(Group group){
        group.setLayoutX(randomGenerator.nextInt(400));
        group.setLayoutY(-(randomGenerator.nextInt(3000)));
    };

    public double calculateDistance(double x1, double x2, double y1, double y2){
        return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
    }

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

        gridPane2.setLayoutY(-1024);

        // add grids to array
        Node[] gripPanes = new Node[2];
        gripPanes[0] = gridPane;
        gripPanes[1] = gridPane2;
        return  gripPanes;
    };


    public void moveBackground(GridPane gridPane, GridPane gridPane2){
        gridPane.setLayoutY(gridPane.getLayoutY() + 0.5);
        gridPane2.setLayoutY(gridPane2.getLayoutY() + 0.5);

        if (gridPane.getLayoutY() >= 1024){
            gridPane.setLayoutY(-1024);
        };


        if (gridPane2.getLayoutY() >= 1024){
            gridPane2.setLayoutY(-1024);
        };
    };

    public int getRandomNumber(){
        return randomGenerator.nextInt(99);
    };
}
