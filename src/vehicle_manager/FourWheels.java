package vehicle_manager;

import java.awt.*;
import java.util.Date;

public abstract class FourWheels extends Vehicle {
    public FourWheels(String owner, String brand, String model, Date releaseDate,
                      boolean secondHand, Color color, int nbSeats, int fiscalPower,
                      double consumption, double co2Emission, double distanceTraveled, double price) {
        super(owner, brand, model,
                releaseDate, secondHand, color,
                nbSeats, fiscalPower, consumption,
                co2Emission, distanceTraveled, price, 4);
    }
}
