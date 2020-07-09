package model2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class NumberFactory implements FactoryIF {

	protected Image img;
	protected double x, y;
	protected GraphicsContext gc; 
	

	@Override
	public GameObject createProduct(int Discriminator) {
		
		if(Discriminator == 0)
		{
			return new Number0(gc, x, x, Discriminator); 
		}
		else if(Discriminator == 1)
		{
			return new Number1(gc, x, x, Discriminator); 
		}
		else if(Discriminator == 2)
		{
			return new Number2(gc, x, x, Discriminator); 
		}

		else if(Discriminator == 3)
		{
			return new Number3(gc, x, x, Discriminator); 
		}
		else if(Discriminator == 4)
		{
			return new Number4(gc, x, x, Discriminator); 
		}
		else if(Discriminator == 5)
		{
			return new Number5(gc, x, x, Discriminator); 
		}
		else if(Discriminator == 6)
		{
			return new Number6(gc, x, x, Discriminator); 
		}
		else if(Discriminator == 7)
		{
			return new Number7(gc, x, x, Discriminator); 
		}
		else if(Discriminator == 8)
		{
			return new Number8(gc, x, x, Discriminator); 
		}
		else if(Discriminator == 9)
		{
			return new Number9(gc, x, x, Discriminator); 
		}
		
		return null; 
	}
		 
	}
	
