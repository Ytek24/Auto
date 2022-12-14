package backend.system_manager;

import backend.vehicle_manager.Vehicle;
import javafx.scene.paint.Color;

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
        this.pathOfPic = (vehicle.getBrand() + "_" + vehicle.getModel() + "_" + vehicle.getReleasedDate().getYear() + ".png").toLowerCase();
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

    public String getPostedDateToString()
    {
        return postDate.toString();
    }

    public String getOwner()
    {
        return vehicle.getOwner();
    }

    public String getBrand()
    {
        return vehicle.getBrand();
    }

    public String getModel()
    {
        return vehicle.getModel();
    }

    public Date getReleasedDate()
    {
        return vehicle.getReleasedDate();
    }

    public String getReleasedDateToString()
    {
        return vehicle.getReleasedDate().toString();
    }

    public String getSecondHandToString()
    {
        return vehicle.isSecondHand() ? "Yes" : "No";
    }

    public Color getColor()
    {
        return vehicle.getColor();
    }

    public String getColorToString()
    {
        return vehicle.getColor().toString();
    }

    public int getNbSeats()
    {
        return vehicle.getNbSeats();
    }

    public int getFiscalPower()
    {
        return vehicle.getFiscalPower();
    }

    public double getConsumption()
    {
        return vehicle.getConsumption();
    }

    public double getCo2Emission()
    {
        return vehicle.getCo2Emission();
    }

    public double getDistanceTraveled()
    {
        return vehicle.getDistanceTraveled();
    }

    public int getNbWheels()
    {
        return vehicle.getNbWheels();
    }
}
