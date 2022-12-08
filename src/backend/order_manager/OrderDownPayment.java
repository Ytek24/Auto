package backend.order_manager;

import backend.system_manager.VehicleCatalog;

public class OrderDownPayment extends Order {
    public OrderDownPayment(String countryFrom, String countryTo, VehicleCatalog vehicleCatalog) {
        super(countryFrom, countryTo, vehicleCatalog);
        setCost(vehicleCatalog.getPrice() + vehicleCatalog.getPrice() * getTax());
    }
}
