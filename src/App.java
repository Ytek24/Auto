import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class App extends Application
{
        public void start(Stage stage) throws Exception
        {
                Pane pane = new Pane(new Rectangle(200, 200, Color.BLUE));
                Scene scene = new Scene(pane);
                stage.setScene(scene);
                stage.show();
        }
}