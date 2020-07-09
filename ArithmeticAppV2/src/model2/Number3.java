package model2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Number3 extends GameObject implements Number {
	

	
	public Number3(GraphicsContext gc, double x, double y, int number) {
		super(gc, x, y, number);
		imgView = new ImageView("resource/Number3.png");
		update();
	}

	@Override
	public int getNumber() {
		// TODO Auto-generated method stub
		return number;
	}
	
	public ImageView getImage()
	{
		return imgView; 
	}

}
