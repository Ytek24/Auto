package frontend.Home;

import backend.system_manager.Catalog;
import backend.utils.FilterAndResearch;
import backend.utils.FilterItems;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class FilterBar extends VBox {

    Catalog catalog;
    FilterItems filterItems;

    Button slidingBarButton;
    boolean closed;
    VBox filtersVBox;
    ScrollPane filtersScrollPane;
    Button applyFiltersButton;
    Button clearFiltersButton;
    int width;

    public FilterBar(Catalog catalog) {
        width = 246;
        setPrefSize(width, 2000);

        this.catalog = catalog;
        slidingBarButton = new Button("Filters");
        slidingBarButton.setPrefSize(width,50);
        closed = false;
        filtersVBox = new VBox();
        filtersVBox.setSpacing(10);
        filtersVBox.setPadding(new Insets(5));
        filtersScrollPane = new ScrollPane();
        filtersScrollPane.setPrefSize(width, 1000);
        applyFiltersButton = new Button("APPLY");
        applyFiltersButton.setPrefSize(width, 50);
        clearFiltersButton = new Button("CLEAR");
        clearFiltersButton.setPrefSize(width, 50);


        FilterAndResearch filterAndResearch = new FilterAndResearch(catalog);
        addFiltersToFiltersVBox(filterAndResearch);

        filtersScrollPane.setContent(filtersVBox);

        getChildren().add(slidingBarButton);
        getChildren().add(filtersScrollPane);
        getChildren().add(applyFiltersButton);
        getChildren().add(clearFiltersButton);

        slidingBarButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(closed)
                {
                    setPrefSize(width, 2000);
                    filtersScrollPane.setVisible(true);
                    applyFiltersButton.setVisible(true);
                    clearFiltersButton.setVisible(true);
                    closed = false;
                }
                else {
                    setPrefSize(0, 2000);
                    filtersScrollPane.setVisible(false);
                    applyFiltersButton.setVisible(false);
                    clearFiltersButton.setVisible(false);
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
        brandHBox.getChildren().addAll(brandLbl, brandComboBox);

        HBox modelHBox = new HBox();
        modelHBox.setSpacing(5);
        Label modelbl = new Label("Model: ");
        ComboBox modelComboBox = new ComboBox();
        for(String models: filterAndResearch.getModelList())
        {
            modelComboBox.getItems().add(models);
        }
        modelHBox.getChildren().addAll(modelbl, modelComboBox);

        HBox yearHBox = new HBox();
        yearHBox.setSpacing(5);
        yearHBox.setDisable(true);
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

        filterItems = new FilterItems(brandComboBox, modelComboBox, minYearTf, maxYearTf,
                yesSecondHandRb, noSecondHandRb, nbSeatsComboBox, minFiscalPowerTf, maxFiscalPowerTf,
                minConsumptionTf, maxConsumptionTf, minco2EmissionTf, maxco2EmissionTf,
                minDistTraveledTf, maxDistTraveledTf, minPriceTf, maxPriceTf);

        filtersVBox.getChildren().addAll(brandHBox, modelHBox,
                yearHBox, secondHandHBox, nbSeatsHBox, fiscalPowerHBox, consumptionHBox,
                co2EmissionHBox, distTraveledHBox, priceHBox);

        //filterAndResearch.createFilteredCatalog(catalog, brandComboBox.getSelectionModel().get)

        clearFiltersButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                brandComboBox.getSelectionModel().clearSelection();
                modelComboBox.getSelectionModel().clearSelection();
                minYearTf.clear();
                maxYearTf.clear();
                if(secondHandGroup.getSelectedToggle() != null)
                {
                    secondHandGroup.getSelectedToggle().setSelected(false);
                }
                nbSeatsComboBox.getSelectionModel().clearSelection();
                minFiscalPowerTf.clear();
                maxFiscalPowerTf.clear();
                minConsumptionTf.clear();
                maxConsumptionTf.clear();
                minco2EmissionTf.clear();
                maxco2EmissionTf.clear();
                minDistTraveledTf.clear();
                maxDistTraveledTf.clear();
                minPriceTf.clear();
                maxPriceTf.clear();
            }
        });
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public FilterItems getFilterItems() {
        return filterItems;
    }

    public Button getApplyFiltersButton() {
        return applyFiltersButton;
    }
}
