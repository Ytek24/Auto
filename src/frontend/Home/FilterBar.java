package frontend.Home;

import backend.system_manager.Catalog;
import backend.utils.FilterAndResearch;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class FilterBar extends VBox {

    Button slidingBarButton;
    VBox filtersVBox;
    ScrollPane filtersScrollPane;
    boolean closed;

    public FilterBar(Catalog catalog) {
        setPrefSize(250, 2000);

        closed = false;
        slidingBarButton = new Button();
        slidingBarButton.setPrefSize(250,50);
        filtersVBox = new VBox();
        filtersVBox.setSpacing(10);
        filtersVBox.setPadding(new Insets(10));
        filtersScrollPane = new ScrollPane();
        filtersScrollPane.setPrefSize(getPrefWidth(), 1000);


        FilterAndResearch filterAndResearch = new FilterAndResearch(catalog);
        addFiltersToFiltersVBox(filterAndResearch);

        filtersScrollPane.setContent(filtersVBox);
        getChildren().add(slidingBarButton);
        getChildren().add(filtersScrollPane);

        slidingBarButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(closed)
                {
                    setPrefSize(250, 2000);
                    filtersScrollPane.setVisible(true);
                    closed = false;
                }
                else {
                    setPrefSize(0, 2000);
                    filtersScrollPane.setVisible(false);
                    closed = true;
                }
            }
        });
    }


    public void addFiltersToFiltersVBox(FilterAndResearch filterAndResearch)
    {
        HBox brandHBox = new HBox();
        brandHBox.setSpacing(5);
        Label brandLbl = new Label("Brand: ");
        ComboBox brandComboBox = new ComboBox();
        for(String brands: filterAndResearch.getBrandList())
        {
            brandComboBox.getItems().add(brands);
        }
        brandComboBox.getSelectionModel().selectFirst();
        brandHBox.getChildren().addAll(brandLbl, brandComboBox);

        HBox modelHBox = new HBox();
        modelHBox.setSpacing(5);
        Label modelbl = new Label("Model: ");
        ComboBox modelComboBox = new ComboBox();
        for(String models: filterAndResearch.getModelList())
        {
            modelComboBox.getItems().add(models);
        }
        modelComboBox.getSelectionModel().selectFirst();
        modelHBox.getChildren().addAll(modelbl, modelComboBox);

        HBox yearHBox = new HBox();
        yearHBox.setSpacing(5);
        Label yearLbl = new Label("Year: ");
        TextField minYearTf = new TextField();
        minYearTf.setPromptText("MIN");
        minYearTf.setMaxWidth(60);
        TextField maxYearTf = new TextField();
        maxYearTf.setPromptText("MAX");
        maxYearTf.setMaxWidth(60);
        yearHBox.getChildren().addAll(yearLbl, minYearTf, maxYearTf);

        HBox secondHandHBox = new HBox();
        secondHandHBox.setSpacing(5);
        Label secondeHandLbl = new Label("Seconde hand: ");
        ToggleGroup secondHandGroup = new ToggleGroup();
        RadioButton yesSecondHandRb = new RadioButton("Yes");
        yesSecondHandRb.setToggleGroup(secondHandGroup);
        RadioButton noSecondHandRb = new RadioButton("No");
        noSecondHandRb.setToggleGroup(secondHandGroup);
        secondHandHBox.getChildren().addAll(secondeHandLbl, yesSecondHandRb, noSecondHandRb);

        HBox nbSeatsHBox = new HBox();
        nbSeatsHBox.setSpacing(5);
        Label nbSeatsLbl = new Label("Number seats: ");
        ComboBox nbSeatsComboBox = new ComboBox();
        for(Integer nbSeats: filterAndResearch.getNbSeatsList())
        {
            nbSeatsComboBox.getItems().add(nbSeats);
        }
        nbSeatsComboBox.getSelectionModel().selectFirst();
        nbSeatsHBox.getChildren().addAll(nbSeatsLbl, nbSeatsComboBox);

        HBox fiscalPowerHBox = new HBox();
        fiscalPowerHBox.setSpacing(5);
        Label fiscalPowerLbl = new Label("Fiscal power: ");
        TextField minFiscalPowerTf = new TextField();
        minFiscalPowerTf.setPromptText("MIN");
        minFiscalPowerTf.setMaxWidth(60);
        TextField maxFiscalPowerTf = new TextField();
        maxFiscalPowerTf.setPromptText("MAX");
        maxFiscalPowerTf.setMaxWidth(60);
        fiscalPowerHBox.getChildren().addAll(fiscalPowerLbl, minFiscalPowerTf, maxFiscalPowerTf);

        HBox consumptionHBox = new HBox();
        consumptionHBox.setSpacing(5);
        Label consumptionLbl = new Label("Consumption: ");
        TextField minConsumptionTf = new TextField();
        minConsumptionTf.setPromptText("MIN");
        minConsumptionTf.setMaxWidth(60);
        TextField maxConsumptionTf = new TextField();
        maxConsumptionTf.setPromptText("MAX");
        maxConsumptionTf.setMaxWidth(60);
        consumptionHBox.getChildren().addAll(consumptionLbl, minConsumptionTf, maxConsumptionTf);

        HBox co2EmissionHBox = new HBox();
        co2EmissionHBox.setSpacing(5);
        Label co2EmissionLbl = new Label("Co2 emission: ");
        TextField minco2EmissionTf = new TextField();
        minco2EmissionTf.setPromptText("MIN");
        minco2EmissionTf.setMaxWidth(60);
        TextField maxco2EmissionTf = new TextField();
        maxco2EmissionTf.setPromptText("MAX");
        maxco2EmissionTf.setMaxWidth(60);
        co2EmissionHBox.getChildren().addAll(co2EmissionLbl, minco2EmissionTf, maxco2EmissionTf);

        HBox distTraveledHBox = new HBox();
        distTraveledHBox.setSpacing(5);
        Label distTraveledLbl = new Label("Dist. Traveled: ");
        TextField minDistTraveledTf = new TextField();
        minDistTraveledTf.setPromptText("MIN");
        minDistTraveledTf.setMaxWidth(60);
        TextField maxDistTraveledTf = new TextField();
        maxDistTraveledTf.setPromptText("MAX");
        maxDistTraveledTf.setMaxWidth(60);
        distTraveledHBox.getChildren().addAll(distTraveledLbl, minDistTraveledTf, maxDistTraveledTf);

        HBox priceHBox = new HBox();
        priceHBox.setSpacing(5);
        Label priceLbl = new Label("Price: ");
        TextField minPriceTf = new TextField();
        minPriceTf.setPromptText("MIN");
        minPriceTf.setMaxWidth(60);
        TextField maxPriceTf = new TextField();
        maxPriceTf.setPromptText("MAX");
        maxPriceTf.setMaxWidth(60);
        priceHBox.getChildren().addAll(priceLbl, minPriceTf, maxPriceTf);

        filtersVBox.getChildren().addAll(brandHBox, modelHBox,
                yearHBox, secondHandHBox, nbSeatsHBox, fiscalPowerHBox, consumptionHBox,
                co2EmissionHBox, distTraveledHBox, priceHBox);
    }

}
