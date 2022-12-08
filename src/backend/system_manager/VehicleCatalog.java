package backend.system_manager;

import backend.vehicle_manager.Vehicle;
import frontend.Home.VehicleDescriptionViewer;
import javafx.scene.paint.Color;

import java.util.Date;

public class VehicleCatalog {

    private String catalogTitle;
    private Vehicle vehicle;
    private Date postDate;
    private double price;
    private String pathOfPic;
    private String catalogDescription;
    private VehicleDescriptionViewer vehicleDescriptionViewer;

    public VehicleCatalog(String catalogTitle, Vehicle vehicle, Date postDate, String catalogDescription) {
        this.catalogTitle = catalogTitle;
        this.vehicle = vehicle;
        this.postDate = postDate;
        this.price = vehicle.getPrice();
        this.pathOfPic = (vehicle.getBrand() + "_" + vehicle.getModel() + "_" + vehicle.getReleasedDate().getYear() + ".png").toLowerCase();
        this.catalogDescription = catalogDescription;
        vehicleDescriptionViewer = null;
    }

    public String getCatalogTitle() {
        return catalogTitle;
    }

    public void setCatalogTitle(String catalogTitle) {
        this.catalogTitle = catalogTitle;
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

    public boolean isSecondHand()
    {
        return vehicle.isSecondHand();
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

    public String getCatalogDescription() {
        return catalogDescription;
    }

    public void setCatalogDescription(String catalogDescription) {
        this.catalogDescription = catalogDescription;
    }

    public VehicleDescriptionViewer getVehicleDescriptionViewer() {
        return vehicleDescriptionViewer;
    }

    public void setVehicleDescriptionViewer(VehicleDescriptionViewer vehicleDescriptionViewer) {
        this.vehicleDescriptionViewer = vehicleDescriptionViewer;
    }
}
