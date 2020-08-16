package model;

import Utilities.GeneralUtils;

public class Star extends GameObject{
    public Star(String imagePath, GeneralUtils generalUtils){
        super(imagePath);
        generalUtils.setRandomElementPosition(this);
    }
}
