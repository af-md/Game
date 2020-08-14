package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameObject {

	protected GraphicsContext gc;
	protected double x;
	protected double y;

	public GameObject(GraphicsContext gc, double x, double y)
	{
		this.gc = gc;
		this.x = x;
		this.y = y;
	}

}
