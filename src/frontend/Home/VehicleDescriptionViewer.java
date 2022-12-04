package frontend.Home;

import backend.system_manager.VehicleCatalog;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class VehicleDescriptionViewer extends ScrollPane {

    private VBox vehicleInformationContainer;

    public VehicleDescriptionViewer(VehicleCatalog vehicleCatalog)
    {
        setPrefSize(250, 2000);
        vehicleInformationContainer = new VBox();
        vehicleInformationContainer.setSpacing(10);
        vehicleInformationContainer.setPadding(new Insets(10));

        vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.ALWAYS);

        Label postedDateLbl = new Label();
        postedDateLbl.setAlignment(Pos.CENTER);
        postedDateLbl.setText("Posted date:\n" + vehicleCatalog.getPostedDateToString());

        Label ownerLbl = new Label();
        ownerLbl.setText("Owner:\n" + vehicleCatalog.getOwner());

        Label brandLbl = new Label();
        brandLbl.setText("Brand:\n" + vehicleCatalog.getBrand());

        Label modelLbl = new Label();
        modelLbl.setText("Model:\n" + vehicleCatalog.getModel());

        Label releasedDateLbl = new Label();
        releasedDateLbl.setText("Released date:\n" + vehicleCatalog.getReleasedDateToString());

        Label secondHandLbl = new Label();
        secondHandLbl.setText("Second Hand:\n" + vehicleCatalog.getSecondHandToString());

        Label colorLbl = new Label();
        colorLbl.setText("Color:\n" + vehicleCatalog.getColorToString());

        Label nbSeatsLbl = new Label();
        nbSeatsLbl.setText("Number seats:\n" + vehicleCatalog.getNbSeats());

        Label fiscalPowerLbl = new Label();
        fiscalPowerLbl.setText("Fiscal power:\n" + vehicleCatalog.getFiscalPower());

        Label consumptionLbl = new Label();
        consumptionLbl.setText("Consumption:\n" + vehicleCatalog.getConsumption());

        Label co2EmissionLbl = new Label();
        co2EmissionLbl.setText("CO2 emission:\n" + vehicleCatalog.getCo2Emission());

        Label distanceTraveledLbl = new Label();
        distanceTraveledLbl.setText("Distance traveled:\n" + vehicleCatalog.getDistanceTraveled());

        Label priceLbl = new Label();
        priceLbl.setText("Price:\n" + vehicleCatalog.getPrice());


        //vehicleInformationContainer.getChildren().add(postedDateLbl);
        vehicleInformationContainer.getChildren().addAll(postedDateLbl,
                ownerLbl, brandLbl, modelLbl, releasedDateLbl, secondHandLbl,
                colorLbl, nbSeatsLbl, fiscalPowerLbl, consumptionLbl, co2EmissionLbl,
                distanceTraveledLbl, priceLbl);

        setContent(vehicleInformationContainer);

    }
}
