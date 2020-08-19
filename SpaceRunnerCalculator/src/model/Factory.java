package model;

import Utilities.GeneralUtils;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

public class Factory implements IFactory {
    public GeneralUtils generalUtils;
    @Override
    public Object createObject(String discriminator) {
        generalUtils = new GeneralUtils();

        return switch (discriminator) {
            case "ship" -> new Ship("resource/blueShip.png" ,600/2, 800-90);
            case "livesStatus" -> createPlayerLifeStatus();
            case "operands" -> createOperand();
            default -> null;
        };

    }

    /**
     * It creates an array of images which are used to create player life status panel at the top right hand side
     * @return array of {@link ImageView}
     */
    private Ship[] createPlayerLifeStatus(){
        Ship[] playerLives = new Ship[3];
        for (int i = 0; i < 3; i++) {
            playerLives[i] =  new Ship("resource/playerLife1_blue.png", 455 + (i * 50), 80);
        }
        return playerLives;
    };

    /**
     * creates array of images which are used to populate asteroids
     * @return array of {@link ImageView}
     */
    private Group[] createOperand(){
        // needs work from here.
        GroupedNodes[] groupedNodes = new GroupedNodes[9];
        for (int i = 0; i < groupedNodes.length; i++) {
            groupedNodes[i] = new GroupedNodes("resource/meteorBrown_big3.png", generalUtils, i);
        }
        return groupedNodes;
    }
}
