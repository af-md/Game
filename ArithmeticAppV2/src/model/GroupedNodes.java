package model;

import Utilities.GeneralUtils;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GroupedNodes extends Group {
    private int number;
    public GroupedNodes(String imageMeteorPath, GeneralUtils generalUtils, int number){
        super();
        this.number = number;
        ImageView imageView =  new ImageView(imageMeteorPath);
        getChildren().add(imageView);
        generalUtils.setRandomElementPosition2(this);
        Text hi = new Text(imageView.getLayoutX() + 17, imageView.getLayoutY() + 25, Integer.toString(number));
        hi.setFill(Color.RED);
        hi.setFont(new Font(20));
        getChildren().add(hi);
    }

    public int getNumber() {
        return number;
    }
}
