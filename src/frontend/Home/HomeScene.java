package frontend;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class HomeScene extends Pane {

    public HomeScene() {
        getChildren().add(new Rectangle(200, 200, javafx.scene.paint.Color.BLUE));
    }
}
