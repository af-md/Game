package model;

import Utilities.GeneralUtils;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Class used to put the number text on top of the meteor.
 */
public class GroupedNodes extends Group {
    public static final int FONT_SIZE = 30;
    public static final int EXTRA_HORIZONTAL_TEXT_SPACING = 30;
    public static final int EXTRA_VERTICAL_TEXT_SPACING = 40;
    private int number;
    public GroupedNodes(String imageMeteorPath, GeneralUtils generalUtils, int number){
        super();
        this.number = number;
        ImageView imageView =  new ImageView(imageMeteorPath);
        getChildren().add(imageView);
        generalUtils.setRandomGroupElementPosition(this);
        Text text = new Text(imageView.getLayoutX() + EXTRA_HORIZONTAL_TEXT_SPACING, imageView.getLayoutY() + EXTRA_VERTICAL_TEXT_SPACING, Integer.toString(number));
        text.setFill(Color.BEIGE);
        text.setFont(new Font(FONT_SIZE));
        getChildren().add(text);
    }

    public int getNumber() {
        return number;
    }
}
