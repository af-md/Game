package model2;

import javafx.scene.canvas.GraphicsContext;

public class WordFactory implements FactoryIF {
    GraphicsContext gc;

    public WordFactory(GraphicsContext gc) {
        this.gc = gc;
    }

    @Override
    public GameObject createProduct() {
        return new Word(gc, 90, 80);
    }
}
