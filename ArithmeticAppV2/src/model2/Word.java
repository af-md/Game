package model2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Word extends GameObject {
    public Word(GraphicsContext gc, double x, double y) {
        super(gc, x, y);
        img=new Image("resource/word.jpg");
        super.update();
    }
}
