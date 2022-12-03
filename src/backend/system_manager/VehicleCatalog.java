package backend.system_manager;

import backend.vehicle_manager.Vehicle;

import java.util.Date;

public class VehicleCatalog {
    private Vehicle vehicle;
    private Date postDate;
    private double price;

    public VehicleCatalog(Vehicle vehicle, Date postDate) {
        this.vehicle = vehicle;
        this.postDate = postDate;
        this.price = vehicle.getPrice();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
