package backend.order_manager;

import backend.system_manager.VehicleCatalog;

public class OrderLoanPayment extends Order {
    public OrderLoanPayment(String countryFrom, String countryTo, VehicleCatalog vehicleCatalog) {
        super(countryFrom, countryTo, vehicleCatalog);
        setCost(1.10 * vehicleCatalog.getPrice() + vehicleCatalog.getPrice() * getTax());
    }
}
