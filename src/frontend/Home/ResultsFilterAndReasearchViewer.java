package frontend.Home;

import backend.system_manager.Catalog;
import backend.system_manager.VehicleCatalog;
import backend.utils.FilterAndResearch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.util.ArrayList;


public class ResultsFilterAndReasearchViewer extends ScrollPane {

    Catalog catalogFiltered;
    ArrayList<PostLabel> postLabels;
    VBox filteredPostVBox;

    public ResultsFilterAndReasearchViewer(FilterBar filterBar)
    {
        setPrefSize(2000, 150);

        postLabels = new ArrayList<>();
        filteredPostVBox = new VBox();
    }

    public void initPostLabels(FilterBar filterBar)
    {
        filteredPostVBox.getChildren().clear();

        String brand;
        try {
            brand = filterBar.getFilterItems().getBrandComboBox().getSelectionModel().getSelectedItem().toString();
        }catch (NullPointerException e)
        {
            brand = "";
        }

        String model;
        try {
            model = filterBar.getFilterItems().getModelComboBox().getSelectionModel().getSelectedItem().toString();
        }catch (NullPointerException e)
        {
            model = "";
        }

        int nbSeats;
        try {
            nbSeats = Integer.parseInt(filterBar.getFilterItems().getNbSeats().getSelectionModel().getSelectedItem().toString());
        }catch (NullPointerException e)
        {
            nbSeats = -1;
        }

        int minFiscalPower;
        try {
            minFiscalPower = Integer.parseInt(filterBar.getFilterItems().getMinFiscalPower().getText());
        }catch (NumberFormatException e)
        {
            minFiscalPower = Integer.MIN_VALUE;
        }

        int maxFiscalPower;
        try {
            maxFiscalPower = Integer.parseInt(filterBar.getFilterItems().getMaxFiscalPower().getText());
        }catch (NumberFormatException e)
        {
            maxFiscalPower = Integer.MAX_VALUE;
        }

        double minConsumption;
        try {
            minConsumption = Double.parseDouble(filterBar.getFilterItems().getMinConsumption().getText());
        }catch (NumberFormatException e)
        {
            minConsumption = Double.MIN_VALUE;
        }

        double maxConsumption;
        try {
            maxConsumption = Double.parseDouble(filterBar.getFilterItems().getMaxConsumption().getText());
        }catch (NumberFormatException e)
        {
            maxConsumption = Double.MAX_VALUE;
        }

        double minCo2Emission;
        try {
            minCo2Emission = Double.parseDouble(filterBar.getFilterItems().getMinCo2Emission().getText());
        }catch (NumberFormatException e)
        {
            minCo2Emission = Double.MIN_VALUE;
        }

        double maxCo2Emission;
        try {
            maxCo2Emission = Double.parseDouble(filterBar.getFilterItems().getMaxCo2Emission().getText());
        }catch (NumberFormatException e)
        {
            maxCo2Emission = Double.MAX_VALUE;
        }

        double minDistanceTraveled;
        try {
            minDistanceTraveled = Double.parseDouble(filterBar.getFilterItems().getMinDistanceTraveled().getText());
        }catch (NumberFormatException e)
        {
            minDistanceTraveled = Double.MIN_VALUE;
        }

        double maxDistanceTraveled;
        try {
            maxDistanceTraveled = Double.parseDouble(filterBar.getFilterItems().getMaxDistanceTraveled().getText());
        }catch (NumberFormatException e)
        {
            maxDistanceTraveled = Double.MAX_VALUE;
        }

        double minPrice;
        try {
            minPrice = Double.parseDouble(filterBar.getFilterItems().getMinPrice().getText());
        }catch (NumberFormatException e)
        {
            minPrice = Double.MIN_VALUE;
        }

        double maxPrice;
        try {
            maxPrice = Double.parseDouble(filterBar.getFilterItems().getMaxPrice().getText());
        }catch (NumberFormatException e)
        {
            maxPrice = Double.MAX_VALUE;
        }
        catalogFiltered = FilterAndResearch.createFilteredCatalog(filterBar.getCatalog(),
                brand,
                model,
                //new Date(filterBar.getFilterItems().getMinReleasedDate().toString()),
                //new Date(filterBar.getFilterItems().getMaxReleasedDate().toString()),
                filterBar.getFilterItems().getYesSecondHandRb().isSelected(),
                filterBar.getFilterItems().getNoSecondHandRb().isSelected(),
                nbSeats,
                minFiscalPower,
                maxFiscalPower,
                minConsumption,
                maxConsumption,
                minCo2Emission,
                maxCo2Emission,
                minDistanceTraveled,
                maxDistanceTraveled,
                minPrice,
                maxPrice);

        for(VehicleCatalog vehicleCatalog: catalogFiltered.getVehiclesCatalog())
        {
            PostLabel postLabel = new PostLabel(vehicleCatalog);
            postLabels.add(postLabel);
            filteredPostVBox.getChildren().add(postLabel);
        }

    }

    public Catalog getCatalogFiltered() {
        return catalogFiltered;
    }

    public void setCatalogFiltered(Catalog catalogFiltered) {
        this.catalogFiltered = catalogFiltered;
    }

    public ArrayList<PostLabel> getPostLabels() {
        return postLabels;
    }

    public void addPostLabelToPostLabels(PostLabel postLabel)
    {
        postLabels.add(postLabel);
    }

    public VBox getFilteredPostVBox() {
        return filteredPostVBox;
    }
}
