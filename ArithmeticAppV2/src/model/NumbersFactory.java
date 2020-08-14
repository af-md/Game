package model;

import Utilities.GeneralUtils;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class NumbersFactory  implements IFactory {
    public GeneralUtils generalUtils;
    @Override
    public Object createObject(String disc) {
        generalUtils = new GeneralUtils();

        return switch (disc) {
            case "ship" -> createShip();
            case "star" -> createStar();
            case "livesStatus" -> createPlayerLifeStatus();
            case "meteors" -> createMeteors();
            case "operands" -> createOperand();
            default -> null;
        };

    }

    // TODO remove hard coding
    private ImageView createShip() {
        ImageView ship = new ImageView("resource/blueShip.png");
        ship.setLayoutX(600/2);
        ship.setLayoutY(800 - 90);
        return ship;
    }

    private ImageView createStar() {
        ImageView star = new ImageView("resource/star_gold.png");
        generalUtils.setRandomElementPosition(star);
        return star;
    }

    private ImageView[] createPlayerLifeStatus(){
        ImageView[] playerLives = new ImageView[3];
        for (int i = 0; i < 3; i++) {
            playerLives[i] =  new ImageView("resource/playerLife1_blue.png");
            playerLives[i].setLayoutX(455 + (i * 50));
            playerLives[i].setLayoutY(80);
        }
        return playerLives;
    };

    private ImageView[] createMeteors() {
        ImageView[] greyMeteors = new ImageView[3];
        for (int i = 0; i < 3; i++) {
            greyMeteors[i] =  new ImageView("resource/meteorGrey_big3.png");
            generalUtils.setRandomElementPosition(greyMeteors[i]);
        }

        return greyMeteors;
    }


    private Group createOperand(){
        // needs work from here.
        ImageView imageView =  new ImageView("resource/meteorBrown_big3.png");
        Group group = new Group(imageView);
        group.setLayoutX(150);
        group.setLayoutY(150);
        // generalUtils.setRandomElementPosition2(group);
        customText hi = new customText(group.getLayoutX(), group.getLayoutY(), 10);
        hi.setFill(Color.RED);
        group.getChildren().add(hi);

        return group;
    }
}
