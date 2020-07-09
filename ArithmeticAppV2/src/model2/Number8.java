package model2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Number8 extends GameObject implements Number{

	

	public Number8(GraphicsContext gc, double x, double y, int number) {
		super(gc, x, y, number);
		imgView = new ImageView("resource/Number8.png");
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
