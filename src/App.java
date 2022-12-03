import backend.system_manager.Catalog;
import frontend.Home.HomeScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import backend.order_manager.OrderDownPayment;
import backend.order_manager.State;
import backend.system_manager.VehicleCatalog;
import backend.vehicle_manager.Automotive;
import backend.vehicle_manager.Vehicle;
import java.awt.Color;

import java.util.Date;

public class App extends Application
{
        public void start(Stage stage) throws Exception
        {
                Vehicle panda = new Automotive("Youssef", "Fiat", "Panda3",
                        new Date(2019, 12, 01), false,
                        Color.BLUE, 5, 5, 5, 2, 200, 15000);
                System.out.println(panda);

                VehicleCatalog pandaCatalog = new VehicleCatalog(panda, new Date(1000));
                OrderDownPayment downPayment = new OrderDownPayment("France", "Spain", State.IN_PROGRESS, pandaCatalog);

                Vehicle clio = new Automotive("Youssef", "Renault", "Clio5",
                        new Date(2018, 12, 01), false,
                        Color.BLUE, 5, 5, 5, 2, 200, 15000);

                VehicleCatalog clioCatalog = new VehicleCatalog(clio, new Date(1000));
                System.out.println("URL clio : " + clioCatalog.getPathOfPic());

                Vehicle golf = new Automotive("Youssef", "Volkswagen", "Golf8",
                        new Date(2019, 12, 01), false,
                        Color.BLUE, 5, 5, 5, 2, 200, 15000);

                VehicleCatalog golfCatalog = new VehicleCatalog(golf, new Date(1000));
                System.out.println("URL clio : " + golfCatalog.getPathOfPic());

                Catalog catalog = new Catalog();
                catalog.addVehicleCatalog(pandaCatalog);
                catalog.addVehicleCatalog(clioCatalog);
                catalog.addVehicleCatalog(golfCatalog);

                for(VehicleCatalog veh: catalog.getVehiclesCatalog())
                {
                        System.out.println(veh.getPathOfPic());
                }

                HomeScene homeScene = new HomeScene(catalog);
                Scene scene = new Scene(homeScene);
                stage.setScene(scene);
                stage.sizeToScene();
                stage.show();
        }
}