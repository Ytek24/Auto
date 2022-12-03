import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import order_manager.OrderDownPayment;
import order_manager.State;
import system_manager.VehicleCatalog;
import vehicle_manager.Automotive;
import vehicle_manager.Vehicle;
import java.awt.Color;

import java.util.Date;

public class App extends Application
{
        public void start(Stage stage) throws Exception
        {
                Pane pane = new Pane(new Rectangle(200, 200, javafx.scene.paint.Color.BLUE));
                Scene scene = new Scene(pane);

                Vehicle panda = new Automotive("Youssef", "Fiat", "Panda",
                        new Date(2022, 12, 01), false,
                        Color.BLUE, 5, 5, 5, 2, 200, 15000);
                System.out.println(panda);

                VehicleCatalog vehicleCatalog = new VehicleCatalog(panda, new Date(1000));

                OrderDownPayment downPayment = new OrderDownPayment("France", "Spain", State.IN_PROGRESS, vehicleCatalog);
                stage.setScene(scene);
                stage.show();
        }
}