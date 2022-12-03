package frontend.Home;

import backend.system_manager.VehicleCatalog;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class VehicleDescriptionViewer extends ScrollPane {

    private VBox vehicleInformationContainer;

    public VehicleDescriptionViewer(VehicleCatalog vehicleCatalog)
    {
        setPrefSize(2000, 200);
        vehicleInformationContainer = new VBox();
        vehicleInformationContainer.setSpacing(10);

        vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.ALWAYS);

        Label postedDateLbl = new Label();
        postedDateLbl.setAlignment(Pos.CENTER);
        postedDateLbl.setText("Posted date : " + vehicleCatalog.getPostedDateToString());

        Label ownerLbl = new Label();
        ownerLbl.setText("Owner : " + vehicleCatalog.getOwner());

        Label brandLbl = new Label();
        brandLbl.setText("Brand : " + vehicleCatalog.getBrand());

        Label modelLbl = new Label();
        modelLbl.setText("Model : " + vehicleCatalog.getModel());

        Label releasedDateLbl = new Label();
        releasedDateLbl.setText("Released date : " + vehicleCatalog.getReleasedDateToString());

        Label secondHandLbl = new Label();
        secondHandLbl.setText("Second Hand ? " + vehicleCatalog.getSecondHandToString());

        Label colorLbl = new Label();
        colorLbl.setText("Color : " + vehicleCatalog.getColorToString());

        Label nbSeatsLbl = new Label();
        nbSeatsLbl.setText("Number seats : " + vehicleCatalog.getNbSeats());

        Label fiscalPowerLbl = new Label();
        fiscalPowerLbl.setText("Fiscal power : " + vehicleCatalog.getFiscalPower());

        Label consumptionLbl = new Label();
        consumptionLbl.setText("Consumption : " + vehicleCatalog.getConsumption());

        Label co2EmissionLbl = new Label();
        co2EmissionLbl.setText("CO2 emission : " + vehicleCatalog.getCo2Emission());

        Label distanceTraveledLbl = new Label();
        distanceTraveledLbl.setText("Distance traveled : " + vehicleCatalog.getDistanceTraveled());

        Label priceLbl = new Label();
        priceLbl.setText("Price : " + vehicleCatalog.getPrice());


        //vehicleInformationContainer.getChildren().add(postedDateLbl);
        vehicleInformationContainer.getChildren().addAll(postedDateLbl,
                ownerLbl, brandLbl, modelLbl, releasedDateLbl, secondHandLbl,
                colorLbl, nbSeatsLbl, fiscalPowerLbl, consumptionLbl, co2EmissionLbl,
                distanceTraveledLbl, priceLbl);

        setContent(vehicleInformationContainer);

    }
}
