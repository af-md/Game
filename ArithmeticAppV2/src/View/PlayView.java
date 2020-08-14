package View;
import Utilities.GeneralUtils;
import controllers.PlayController;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class PlayView {
    private PlayController playController;
    public AnimationTimer animationTimer;
    private Pane root;
    public GeneralUtils generalUtils;
    public PlayView(PlayController playController, Stage stage, Pane root, int gameWidth, int gameHeight)
    {

        this.root = root;
        this.playController = playController;
        Scene scene = new Scene(root, gameWidth, gameHeight);
        stage.setScene(scene);
        stage.setTitle("Afzal's Calculator Game");
        stage.show();

        // set event subscriber
        scene.setOnKeyPressed(playController);
        scene.setOnKeyReleased(playController);

        // start the animation loop frame
        createGameAnimationLoop();

        generalUtils = new GeneralUtils();
    }

    // TODO Casting issue


    private void createGameAnimationLoop()
    {
         animationTimer = new AnimationTimer() {
             @Override
             public void handle(long l) {
                 generalUtils.moveBackground(playController.gridPane, playController.gridPane2);
                 playController.moveGameElement();
                 playController.relocateElementToTheTop();
                 playController.checkIfElementCollide();
                playController.moveShip();
             }
         };
         animationTimer.start();
    };
}