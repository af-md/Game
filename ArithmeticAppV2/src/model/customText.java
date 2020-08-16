package model;

import javafx.scene.text.Text;

public class customText extends Text {

    public customText(double v, double v1, int number) {
        super(v, v1, Integer.toString(number));
    }
}
