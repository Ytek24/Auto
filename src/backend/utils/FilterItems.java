package backend.utils;

import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class FilterItems {

    private ComboBox brandComboBox;
    private ComboBox modelComboBox;
    private TextField minReleasedDate;
    private TextField maxReleasedDate;
    private RadioButton yesSecondHandRb;
    private RadioButton noSecondHandRb;
    private ComboBox nbSeats;
    private TextField minFiscalPower;
    private TextField maxFiscalPower;
    private TextField minConsumption;
    private TextField maxConsumption;
    private TextField minCo2Emission;
    private TextField maxCo2Emission;
    private TextField minDistanceTraveled;
    private TextField maxDistanceTraveled;
    private TextField minPrice;
    private TextField maxPrice;

    public FilterItems(ComboBox brandComboBox, ComboBox modelComboBox,
                       TextField minReleasedDate, TextField maxReleasedDate,
                       RadioButton yesSecondHandRb, RadioButton noSecondHandRb,
                       ComboBox nbSeats, TextField minFiscalPower, TextField maxFiscalPower,
                       TextField minConsumption, TextField maxConsumption,
                       TextField minCo2Emission, TextField maxCo2Emission,
                       TextField minDistanceTraveled, TextField maxDistanceTraveled,
                       TextField minPrice, TextField maxPrice) {
        this.brandComboBox = brandComboBox;
        this.modelComboBox = modelComboBox;
        this.minReleasedDate = minReleasedDate;
        this.maxReleasedDate = maxReleasedDate;
        this.yesSecondHandRb = yesSecondHandRb;
        this.noSecondHandRb = noSecondHandRb;
        this.nbSeats = nbSeats;
        this.minFiscalPower = minFiscalPower;
        this.maxFiscalPower = maxFiscalPower;
        this.minConsumption = minConsumption;
        this.maxConsumption = maxConsumption;
        this.minCo2Emission = minCo2Emission;
        this.maxCo2Emission = maxCo2Emission;
        this.minDistanceTraveled = minDistanceTraveled;
        this.maxDistanceTraveled = maxDistanceTraveled;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public ComboBox getBrandComboBox() {
        return brandComboBox;
    }

    public void setBrandComboBox(ComboBox brandComboBox) {
        this.brandComboBox = brandComboBox;
    }

    public ComboBox getModelComboBox() {
        return modelComboBox;
    }

    public void setModelComboBox(ComboBox modelComboBox) {
        this.modelComboBox = modelComboBox;
    }

    public TextField getMinReleasedDate() {
        return minReleasedDate;
    }

    public void setMinReleasedDate(TextField minReleasedDate) {
        this.minReleasedDate = minReleasedDate;
    }

    public TextField getMaxReleasedDate() {
        return maxReleasedDate;
    }

    public void setMaxReleasedDate(TextField maxReleasedDate) {
        this.maxReleasedDate = maxReleasedDate;
    }

    public RadioButton getYesSecondHandRb() {
        return yesSecondHandRb;
    }

    public void setYesSecondHandRb(RadioButton yesSecondHandRb) {
        this.yesSecondHandRb = yesSecondHandRb;
    }

    public RadioButton getNoSecondHandRb() {
        return noSecondHandRb;
    }

    public void setNoSecondHandRb(RadioButton noSecondHandRb) {
        this.noSecondHandRb = noSecondHandRb;
    }

    public ComboBox getNbSeats() {
        return nbSeats;
    }

    public void setNbSeats(ComboBox nbSeats) {
        this.nbSeats = nbSeats;
    }

    public TextField getMinFiscalPower() {
        return minFiscalPower;
    }

    public void setMinFiscalPower(TextField minFiscalPower) {
        this.minFiscalPower = minFiscalPower;
    }

    public TextField getMaxFiscalPower() {
        return maxFiscalPower;
    }

    public void setMaxFiscalPower(TextField maxFiscalPower) {
        this.maxFiscalPower = maxFiscalPower;
    }

    public TextField getMinConsumption() {
        return minConsumption;
    }

    public void setMinConsumption(TextField minConsumption) {
        this.minConsumption = minConsumption;
    }

    public TextField getMaxConsumption() {
        return maxConsumption;
    }

    public void setMaxConsumption(TextField maxConsumption) {
        this.maxConsumption = maxConsumption;
    }

    public TextField getMinCo2Emission() {
        return minCo2Emission;
    }

    public void setMinCo2Emission(TextField minCo2Emission) {
        this.minCo2Emission = minCo2Emission;
    }

    public TextField getMaxCo2Emission() {
        return maxCo2Emission;
    }

    public void setMaxCo2Emission(TextField maxCo2Emission) {
        this.maxCo2Emission = maxCo2Emission;
    }

    public TextField getMinDistanceTraveled() {
        return minDistanceTraveled;
    }

    public void setMinDistanceTraveled(TextField minDistanceTraveled) {
        this.minDistanceTraveled = minDistanceTraveled;
    }

    public TextField getMaxDistanceTraveled() {
        return maxDistanceTraveled;
    }

    public void setMaxDistanceTraveled(TextField maxDistanceTraveled) {
        this.maxDistanceTraveled = maxDistanceTraveled;
    }

    public TextField getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(TextField minPrice) {
        this.minPrice = minPrice;
    }

    public TextField getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(TextField maxPrice) {
        this.maxPrice = maxPrice;
    }
}
