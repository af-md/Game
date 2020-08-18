package model;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;

/**
 * Class used to create custom label with background images
 */
public class CustomLabel extends Label {
    public static final int INSET_V1 = 10;
    public static final int INSET_V2 = 10;
    public static final int INSET_V3 = 10;
    public static final int INSET_V4 = 10;
    public static final int CUSTOM_LABEL_PREF_WIDTH = 130;
    public static final int CUSTOM_LABEL_PREF_HEIGHT = 50;
    public static final int IMAGE_HORIZANTAL = 130;
    public static final int IMAGE_VERTICAL = 50;
    public CustomLabel(String text){
        setPrefWidth(CUSTOM_LABEL_PREF_WIDTH);
        setPrefHeight(CUSTOM_LABEL_PREF_HEIGHT);
        BackgroundImage backgroundImage = new BackgroundImage(new Image("resource/buttonBlue.png", IMAGE_HORIZANTAL, IMAGE_VERTICAL, false, true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
        setBackground(new Background(backgroundImage));
        setAlignment(Pos.CENTER_LEFT);
        setPadding(new Insets(INSET_V1, INSET_V2, INSET_V3, INSET_V4));
        setText(text);
    }
}
