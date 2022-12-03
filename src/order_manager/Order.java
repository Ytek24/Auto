package order_manager;

import database_manager.DataBaseTaxHandler;
import system_manager.VehicleCatalog;

public abstract class Order {

    private String countryFrom;
    private String countryTo;
    private double taxe; //Maybe % create a function to apply the taxe on a price (double taxe(double price))
    private State state;
    private VehicleCatalog vehicleCatalog;
    private double cost;

    public Order(String countryFrom, String countryTo, State state, VehicleCatalog vehicleCatalog) {
        this.countryFrom = countryFrom;
        this.countryTo = countryTo;
        this.taxe = taxe;
        this.state = state;
        this.vehicleCatalog = vehicleCatalog;

        setTaxe(DataBaseTaxHandler.taxValueFromDataBase(countryFrom, countryTo));
        System.out.println("La taxe est : " + taxe);
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

    public double getTaxe() {
        return taxe;
    }

    public void setTaxe(double taxe) {
        this.taxe = taxe;
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
}
