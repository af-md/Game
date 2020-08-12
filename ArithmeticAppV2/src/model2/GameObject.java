package model2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// This is class which is to be inherited by key objects drawing on canvas
public class GameObject {
	
	protected Image img;
	protected GraphicsContext gc;
	protected double x;
	protected double y;

	public GameObject(GraphicsContext gc, double x, double y)
	{
		this.gc = gc;
		this.x = x;
		this.y = y;
	}

	// for drawing image
	public void update() {
		if (img != null) {
			gc.drawImage(img, this.x, this.y);
		}
	}

	public Image getImage() {
		return img;
	}

}
