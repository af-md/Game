package model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameObject extends ImageView {

	public GameObject(String imagePath, double layoutX, double layoutY)
	{
		super(imagePath);
		setLayoutX(layoutX);
		setLayoutY(layoutY);
	}
	public GameObject(String imagePath)
	{
		super(imagePath);
	}
}
