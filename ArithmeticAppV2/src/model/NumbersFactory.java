package model;

import Utilities.GeneralUtils;
import com.sun.scenario.effect.impl.state.GaussianRenderState;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class NumbersFactory  implements IFactory {
    public GeneralUtils generalUtils;
    @Override
    public Object createObject(String disc) {
        generalUtils = new GeneralUtils();

        return switch (disc) {
            case "ship" -> new Ship("resource/blueShip.png" ,600/2, 800-90);
            case "livesStatus" -> createPlayerLifeStatus();
            case "operands" -> createOperand();
            default -> null;
        };

    }

    private Ship[] createPlayerLifeStatus(){
        Ship[] playerLives = new Ship[3];
        for (int i = 0; i < 3; i++) {
            playerLives[i] =  new Ship("resource/playerLife1_blue.png", 455 + (i * 50), 80);
        }
        return playerLives;
    };

    private Group[] createOperand(){
        // needs work from here.
        GroupedNodes[] groupedNodes = new GroupedNodes[9];
        for (int i = 0; i < groupedNodes.length; i++) {
            groupedNodes[i] = new GroupedNodes("resource/meteorBrown_big3.png", generalUtils, i);
        }
        return groupedNodes;
    }
}
