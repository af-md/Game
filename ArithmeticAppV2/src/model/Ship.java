package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Ship {
    public ImageView ship;
    public Ship(String shipImagePath, int gameWidth, int gameHeight) {
        ship = new ImageView("");
        ship.setLayoutX(gameWidth/2);
        ship.setLayoutY(gameHeight - 90);
    }
}
