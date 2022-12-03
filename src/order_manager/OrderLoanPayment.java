package order_manager;

import system_manager.VehicleCatalog;

public class OrderLoanPayment extends Order {
    public OrderLoanPayment(String countryFrom, String countryTo, State state, VehicleCatalog vehicleCatalog) {
        super(countryFrom, countryTo, state, vehicleCatalog);
        setCost(1.10 * vehicleCatalog.getPrice() + vehicleCatalog.getPrice() * getTaxe());
    }
}
