package model2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class WordBin extends GameObject {

    public WordBin(GraphicsContext gc, double x, double y)
    {
        super(gc, y, x);
        img = new Image("resource/Number0.png");
    }
}
