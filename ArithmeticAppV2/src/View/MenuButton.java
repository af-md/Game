package View;

import javafx.scene.control.Button;

public class MenuButton extends Button {
    public MenuButton(String s, double x, double y) {
        super(s);
        setLayoutX(x);
        setLayoutY(y);
        setStyle("-fx-background-color: transparent; -fx-background-image: url('/resource/buttonBlue.png')");
    }
}
