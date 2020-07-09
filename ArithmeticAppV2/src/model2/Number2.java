package model2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Number2 extends GameObject implements Number {
 
	
	public Number2(GraphicsContext gc, double x, double y, int number) {
		super(gc, x, y, number);
		imgView = new ImageView("resource/Number2.png");
		 update();
	}


	@Override
	public int getNumber() {
		return number;
	}
	
	
	public ImageView getImage()
	{
		return imgView; 
	}

}
