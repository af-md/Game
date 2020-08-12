package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;

public class CustomLabel extends Label {

    //private static final String

    public CustomLabel(String text){
        setPrefWidth(130);
        setPrefHeight(50);
        BackgroundImage backgroundImage = new BackgroundImage(new Image("resource/buttonBlue.png", 130, 50, false, true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
        setBackground(new Background(backgroundImage));
        setAlignment(Pos.CENTER_LEFT);
        setPadding(new Insets(10, 10 , 10 , 10));
        setText(text);
    }
}
