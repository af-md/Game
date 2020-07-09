package model2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// This is class which is to be inherited by key objects drawing on canvas
public class GameObject {
	
	protected Image img;
	protected GraphicsContext gc;
	protected ImageView imgView; 

	public GameObject(GraphicsContext gc) {
		this.gc = gc;
	}
	
	// for drawing image
	public void update() {
		if (img != null) {
			gc.drawImage(img, 32, 32);
		}
	}

	public ImageView getImage() {
		return imgView;
	}

}
