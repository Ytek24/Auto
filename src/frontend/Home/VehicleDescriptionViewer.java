package frontend.Home;

import backend.system_manager.VehicleCatalog;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VehicleDescriptionViewer extends VBox {

    private ScrollPane vehicleDescriptionScrollPane;
    private VBox vehicleInformationContainer;
    private Button buyButton;

    private VehicleCatalog vehicleCatalog;

    public VehicleDescriptionViewer(VehicleCatalog vehicleCatalog)
    {
        this.vehicleCatalog = vehicleCatalog;

        vehicleDescriptionScrollPane = new ScrollPane();

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

        vehicleDescriptionScrollPane.setContent(vehicleInformationContainer);

        buyButton = new Button();

        getChildren().addAll(vehicleDescriptionScrollPane, buyButton);

    }

    public Button getBuyButton() {
        return buyButton;
    }

    public void setBuyButton(Button buyButton) {
        int index = removeFromChildren(this.buyButton);
        this.buyButton = buyButton;
        getChildren().add(index, buyButton);
    }

    private int removeFromChildren(Node node)
    {
        int index = getChildren().indexOf(node);
        getChildren().remove(node);
        return index;
    }
}
