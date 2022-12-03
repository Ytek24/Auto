package backend.vehicle_manager;

import javafx.scene.paint.Color;

import java.util.Date;

public class Scooter extends TwoWheels {
    public Scooter(String owner, String brand, String model,
                   Date releaseDate, boolean secondHand, Color color,
                   int nbSeats, int fiscalPower, double consumption,
                   double co2Emission, double distanceTraveled, double price) {
        super(owner, brand, model,
                releaseDate, secondHand, color,
                nbSeats, fiscalPower, consumption,
                co2Emission, distanceTraveled, price);
    }
}
