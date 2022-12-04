package frontend.Home;

import backend.system_manager.Catalog;
import backend.system_manager.VehicleCatalog;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;

public class HomeScene extends BorderPane {

    private int screenWidth;
    private int screenHeight;

    Catalog catalog;
    VehicleCatalog vehicleCatalog;
    int currentIndex;
    Button leftArrowButton;
    ImageView vehiclePic;
    Button rightArrowButton;
    HBox imageHBox;

    VehicleDescriptionViewer vehicleDescriptionViewer;




    public HomeScene(Catalog catalog) {
        this.screenWidth = (int)Screen.getPrimary().getVisualBounds().getWidth();
        this.screenHeight = (int)Screen.getPrimary().getVisualBounds().getHeight();
        setPrefSize(screenWidth, screenHeight);

        this.catalog = catalog;
        this.currentIndex = 0;

        this.vehicleCatalog = catalog.getVehiclesCatalog().get(currentIndex);
        this.leftArrowButton = new Button();
        ImageView leftArrowIV = new ImageView(new Image("resources/arrow_ico/left_arrow.png"));
        leftArrowIV.setFitWidth(100);
        leftArrowIV.setFitHeight(400);
        this.leftArrowButton.setGraphic(leftArrowIV);
        vehiclePic = new ImageView(new Image("resources/vehicle_pics/" + this.vehicleCatalog.getPathOfPic()));
        this.rightArrowButton = new Button();
        ImageView rightArrowIV = new ImageView(new Image("resources/arrow_ico/right_arrow.png"));
        rightArrowIV.setFitWidth(100);
        rightArrowIV.setFitHeight(400);
        this.rightArrowButton.setGraphic(rightArrowIV);
        this.imageHBox = new HBox();
        imageHBox.setAlignment(Pos.CENTER);
        imageHBox.setBackground(new Background(new BackgroundFill(Color.GREY, null, null)));

        vehicleDescriptionViewer = new VehicleDescriptionViewer(vehicleCatalog);

        createCenterPane();

        this.leftArrowButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(currentIndex>0)
                {
                    currentIndex-=1;
                    vehicleCatalog = catalog.getVehiclesCatalog().get(currentIndex);
                    changeVehiclePic();
                }
            }
        });

        this.rightArrowButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(currentIndex<catalog.getVehiclesCatalog().size()-1)
                {
                    currentIndex+=1;
                    vehicleCatalog = catalog.getVehiclesCatalog().get(currentIndex);
                    changeVehiclePic();
                }
            }
        });
    }

    private void createCenterPane()
    {
        MenuBar menuBar = new MenuBar((int)this.getPrefWidth());
        FilterBar filterBar = new FilterBar((int)(this.getPrefHeight() - menuBar.getPrefHeight()));
        imageHBox.setCenterShape(true);
        ResultsFilterAndReasearchViewer resultsFilterAndReasearchViewer = new ResultsFilterAndReasearchViewer(catalog);

        vehiclePic.setFitWidth(600);
        vehiclePic.setFitHeight(400);
        leftArrowButton.setMinSize(100, 400);
        rightArrowButton.setPrefSize(100, 400);

        imageHBox.getChildren().addAll(leftArrowButton, vehiclePic, rightArrowButton);
        setTop(menuBar);
        setRight(vehicleDescriptionViewer);
        setCenter(imageHBox);
        setLeft(filterBar);
    }

    private void changeVehiclePic()
    {
        int index = imageHBox.getChildren().indexOf(vehiclePic);
        imageHBox.getChildren().remove(vehiclePic);
        vehiclePic = new ImageView(new Image("resources/vehicle_pics/" + vehicleCatalog.getPathOfPic()));
        vehiclePic.setFitWidth(600);
        vehiclePic.setFitHeight(400);
        imageHBox.getChildren().add(index, vehiclePic);

        vehicleDescriptionViewer = new VehicleDescriptionViewer(vehicleCatalog);
        setRight(vehicleDescriptionViewer);
    }
}
