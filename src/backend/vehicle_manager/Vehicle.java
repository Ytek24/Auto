package backend.vehicle_manager;

import javafx.scene.paint.Color;

import java.util.Date;

public abstract class Vehicle {

    private String owner;
    private String brand;
    private String model;
    private Date releasedDate;
    private boolean secondHand;
    private Color color;
    private int nbSeats;
    private int fiscalPower;
    private double consumption;
    private double co2Emission;
    private double distanceTraveled;
    private double price;
    private int nbWheels;

    public Vehicle(String owner, String brand, String model,
                   Date releaseDate, boolean secondHand, Color color,
                   int nbSeats, int fiscalPower, double consumption,
                   double co2Emission, double distanceTraveled, double price, int nbWheels) {
        this.owner = owner;
        this.brand = brand;
        this.model = model;
        this.releasedDate = releaseDate;
        this.secondHand = secondHand;
        this.color = color;
        this.nbSeats = nbSeats;
        this.fiscalPower = fiscalPower;
        this.consumption = consumption;
        this.co2Emission = co2Emission;
        this.distanceTraveled = distanceTraveled;
        this.price = price;
        this.nbWheels = nbWheels;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(Date releaseDate) {
        this.releasedDate = releaseDate;
    }

    public boolean isSecondHand() {
        return secondHand;
    }

    public void setSecondHand(boolean secondHand) {
        this.secondHand = secondHand;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getNbSeats() {
        return nbSeats;
    }

    public void setNbSeats(int nbSeats) {
        this.nbSeats = nbSeats;
    }

    public int getFiscalPower() {
        return fiscalPower;
    }

    public void setFiscalPower(int fiscalPower) {
        this.fiscalPower = fiscalPower;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public double getCo2Emission() {
        return co2Emission;
    }

    public void setCo2Emission(double co2Emission) {
        this.co2Emission = co2Emission;
    }

    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(double distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNbWheels() {
        return nbWheels;
    }

    @Override
    public String toString() {
        return "Vehicle{\n" +
                "owner='" + owner + '\'' +
                ",\nbrand='" + brand + '\'' +
                ",\nmodel='" + model + '\'' +
                ",\nreleaseDate=" + releasedDate +
                ",\nsecondHand=" + secondHand +
                ",\ncolor=" + color +
                ",\nnbSeats=" + nbSeats +
                ",\nfiscalPower=" + fiscalPower +
                ",\nconsumption=" + consumption +
                ",\nco2Emission=" + co2Emission +
                ",\ndistanceTraveled=" + distanceTraveled +
                ",\nprice=" + price +
                ",\nnbWheels=" + nbWheels +
                "\n}";
    }
}
