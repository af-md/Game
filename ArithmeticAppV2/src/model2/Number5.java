package model2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Number5 extends GameObject implements Number {


	
	public Number5(GraphicsContext gc, double x, double y, int number) {
		super(gc, x, y, number);
		imgView = new ImageView("resource/Number5.png");
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
