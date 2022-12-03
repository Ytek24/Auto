package frontend.Home;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class MenuBar extends HBox {

    public MenuBar(int width) {
        setPrefSize(width, 100);
        setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
    }
}
