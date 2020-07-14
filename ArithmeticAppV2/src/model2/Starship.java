package model2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;

public class Starship extends GameObject {

    public Starship(GraphicsContext gc, double x, double y,)
    {
        super(gc, y, x);
        imgView = new ImageView("resource/Number0.png");
    }
}
