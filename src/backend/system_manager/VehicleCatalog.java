package backend.system_manager;

import backend.vehicle_manager.Vehicle;

import java.util.Date;

public class VehicleCatalog {
    private Vehicle vehicle;
    private Date postDate;
    private double price;
    private String pathOfPic;

    public VehicleCatalog(Vehicle vehicle, Date postDate) {
        this.vehicle = vehicle;
        this.postDate = postDate;
        this.price = vehicle.getPrice();
        this.pathOfPic = (vehicle.getBrand() + "_" + vehicle.getModel() + "_" + vehicle.getReleaseDate().getYear() + ".png").toLowerCase();
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

    public String getPathOfPic() {
        return pathOfPic;
    }

    public void setPathOfPic(String pathOfPic) {
        this.pathOfPic = pathOfPic;
    }
}
