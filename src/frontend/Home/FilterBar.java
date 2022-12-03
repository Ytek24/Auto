package frontend.Home;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class FilterBar extends VBox {

    Button slidingBarButton;

    public FilterBar(int height) {
        setPrefSize(250, height);
        setBackground(new Background(new BackgroundFill(Color.LIGHTCORAL, null, null)));

        slidingBarButton = new Button();
        slidingBarButton.setPrefSize(250,50);
        getChildren().add(slidingBarButton);

        slidingBarButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setPrefSize(0, height);
            }
        });
    }

}
