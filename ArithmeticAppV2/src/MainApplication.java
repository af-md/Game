
import model2.NumberFactory;
import View.MenuView;
import controllers.MenuController;
import javafx.application.Application; 
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;  

public class MainApplication extends Application { 
 	
   public static void main(String args[]){          
      launch(args); 
      
   }

@Override
public void start(Stage stage) throws Exception {

	stage.setTitle("Arithmethic App");
  	MenuController menuController = new MenuController(stage);
}

} 

