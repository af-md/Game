package model;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class CircleNumber extends Circle {

    public Circle circleNumber;

    public Text getText() {
        return text;
    }

    public Text text;

    public CircleNumber(){
        circleNumber = new Circle();
        circleNumber.setFill(Color.ORCHID);
        circleNumber.setCenterX(100.0f);
        circleNumber.setCenterY(100.0f);
        circleNumber.setRadius(20);


        text = new Text("Xyzzz");
        text.layoutXProperty().bindBidirectional(circleNumber.layoutXProperty());
        text.layoutYProperty().bindBidirectional(circleNumber.layoutYProperty());

    }


    private Text createText(String string) {
//        text.setBoundsType(TextBoundsType.VISUAL);
//        text.setStyle(
//                "-fx-font-family: \"Times New Roman\";" +
//                        "-fx-font-style: italic;" +
//                        "-fx-font-size: 48px;"
//        );

        return text;
    }

    @Override
    public Node getStyleableNode() {
        return null;
    }


    public Circle getCircleNumber() {
        return circleNumber;
    }
}
