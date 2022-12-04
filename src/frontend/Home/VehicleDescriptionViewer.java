package frontend.Home;

import backend.system_manager.VehicleCatalog;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class VehicleDescriptionViewer extends ScrollPane {

    private VBox vehicleInformationContainer;

    public VehicleDescriptionViewer(VehicleCatalog vehicleCatalog)
    {
        setPrefSize(226, 2000);
        vehicleInformationContainer = new VBox();
        vehicleInformationContainer.setSpacing(10);
        vehicleInformationContainer.setPadding(new Insets(5));

        Label postedDateLbl = new Label();
        postedDateLbl.setText("Posted date:\n" + vehicleCatalog.getPostedDateToString());

        Label titleLbl = new Label();
        titleLbl.setText("Title:\n" + vehicleCatalog.getCatalogTitle());

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

        Label descriptionLbl = new Label();
        descriptionLbl.setWrapText(true);
        descriptionLbl.setText("Desciption:\n" + vehicleCatalog.getCatalogDescription());
        descriptionLbl.setPrefWidth(getPrefWidth());


        //vehicleInformationContainer.getChildren().add(postedDateLbl);
        vehicleInformationContainer.getChildren().addAll(postedDateLbl, titleLbl,
                ownerLbl, brandLbl, modelLbl, releasedDateLbl, secondHandLbl,
                colorLbl, nbSeatsLbl, fiscalPowerLbl, consumptionLbl, co2EmissionLbl,
                distanceTraveledLbl, priceLbl, descriptionLbl);

        setContent(vehicleInformationContainer);

    }
}
