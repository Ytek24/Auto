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
    boolean closed;

    public FilterBar(int height) {
        setPrefSize(250, height);
        setBackground(new Background(new BackgroundFill(Color.LIGHTCORAL, null, null)));

        closed = false;
        slidingBarButton = new Button();
        slidingBarButton.setPrefSize(250,50);
        getChildren().add(slidingBarButton);

        slidingBarButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(closed)
                {
                    setPrefSize(250, height);
                    closed = false;
                }
                else {
                    setPrefSize(0, height);
                    closed = true;
                }
            }
        });
    }

}
