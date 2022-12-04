package frontend.Home;

import backend.system_manager.VehicleCatalog;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class PostLabel extends Label {

    private VehicleCatalog vehicleCatalog;

    public PostLabel(VehicleCatalog vehicleCatalog)
    {
        this.vehicleCatalog = vehicleCatalog;
        setText(vehicleCatalog.getCatalogTitle());
    }

    public VehicleCatalog getVehicleCatalog() {
        return vehicleCatalog;
    }
}
