package model2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Ship {
    public ImageView imageView;
    public String shipImagePath;
    public String shipLifeImagePath;
    public Ship(String shipImagePath, String shipLifeImagePath) {
        this.shipImagePath = shipImagePath;
        this.shipLifeImagePath = shipLifeImagePath;
    }
}
