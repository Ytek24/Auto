package backend.order_manager;

import backend.system_manager.VehicleCatalog;

public class OrderDownPayment extends Order {
    public OrderDownPayment(String countryFrom, String countryTo, State state, VehicleCatalog vehicleCatalog) {
        super(countryFrom, countryTo, state, vehicleCatalog);
        setCost(vehicleCatalog.getPrice() + vehicleCatalog.getPrice() * getTaxe());
    }
}
