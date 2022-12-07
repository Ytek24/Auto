import backend.database_manager.DataBaseVehicleHandler;
import backend.system_manager.Catalog;
import frontend.Customer.CustomerScene;
import frontend.Home.HomeScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import backend.order_manager.OrderDownPayment;
import backend.order_manager.State;
import backend.system_manager.VehicleCatalog;
import backend.vehicle_manager.Automotive;
import backend.vehicle_manager.Vehicle;

import java.util.Date;

public class App extends Application
{
        public void start(Stage stage) throws Exception
        {

                HomeScene homeScene = new HomeScene();
                Scene scene = new Scene(homeScene);
                stage.setScene(scene);
                stage.sizeToScene();
                stage.show();
        }
}