package backend.system_manager;

import java.util.ArrayList;

public class Catalog {

    private ArrayList<VehicleCatalog> vehiclesCatalog = new ArrayList<>();
    public Catalog() {
    }

    public Catalog(ArrayList<VehicleCatalog> vehiclesCatalog) {
        this.vehiclesCatalog = vehiclesCatalog;
    }

    public ArrayList<VehicleCatalog> getVehiclesCatalog() {
        return vehiclesCatalog;
    }

    public void setVehiclesCatalog(ArrayList<VehicleCatalog> vehiclesCatalog) {
        this.vehiclesCatalog = vehiclesCatalog;
    }

    public void addVehicleCatalog(VehicleCatalog vehicleCatalog)
    {
        vehiclesCatalog.add(vehicleCatalog);
    }
}
