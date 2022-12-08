package backend.order_manager;

import backend.database_manager.DataBaseTaxHandler;
import backend.system_manager.VehicleCatalog;

public abstract class Order {

    private String countryFrom;
    private String countryTo;
    private double tax; //Maybe % create a function to apply the taxe on a price (double taxe(double price))
    private State state;
    private VehicleCatalog vehicleCatalog;
    private double cost;

    public Order(String countryFrom, String countryTo, VehicleCatalog vehicleCatalog) {
        this.countryFrom = countryFrom;
        this.countryTo = countryTo;
        this.tax = tax;
        this.state = State.IN_PROGRESS;
        this.vehicleCatalog = vehicleCatalog;

        setTax(DataBaseTaxHandler.taxValueFromDataBase(countryFrom, countryTo));
    }

    public String getCountryFrom() {
        return countryFrom;
    }

    public void setCountryFrom(String countryFrom) {
        this.countryFrom = countryFrom;
    }

    public String getCountryTo() {
        return countryTo;
    }

    public void setCountryTo(String countryTo) {
        this.countryTo = countryTo;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public VehicleCatalog getVehicleCatalog() {
        return vehicleCatalog;
    }

    public void setVehicleCatalog(VehicleCatalog vehicleCatalog) {
        this.vehicleCatalog = vehicleCatalog;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean compareToOrder(Order order)
    {
        if (vehicleCatalog.compareToVehicleCatalog(order.getVehicleCatalog()))
        {
            return true;
        }
        return false;
    }
}
