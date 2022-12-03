package frontend.Home;

import backend.system_manager.Catalog;
import backend.system_manager.VehicleCatalog;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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



    public HomeScene(Catalog catalog) {
        this.screenWidth = (int) Screen.getPrimary().getVisualBounds().getWidth();
        this.screenHeight = (int) Screen.getPrimary().getVisualBounds().getWidth();
        setPrefSize(screenWidth, screenHeight);

        this.catalog = catalog;
        this.currentIndex = 0;

        this.vehicleCatalog = catalog.getVehiclesCatalog().get(currentIndex);
        this.leftArrowButton = new Button();
        vehiclePic = new ImageView(new Image("resources/vehicle_pics/" + this.vehicleCatalog.getPathOfPic()));
        this.rightArrowButton = new Button();
        this.imageHBox = new HBox();

        createCenterPane();

        this.leftArrowButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(currentIndex>0)
                {
                    currentIndex-=1;
                    vehicleCatalog = catalog.getVehiclesCatalog().get(currentIndex);
                    vehiclePic = new ImageView(new Image("resources/vehicle_pics/" + vehicleCatalog.getPathOfPic()));
                    vehiclePic.setFitWidth(600);
                    vehiclePic.setFitHeight(400);
                    removeAllFromHBox();
                    imageHBox.getChildren().addAll(leftArrowButton, vehiclePic, rightArrowButton);
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
                    vehiclePic = new ImageView(new Image("resources/vehicle_pics/" + vehicleCatalog.getPathOfPic()));
                    vehiclePic.setFitWidth(600);
                    vehiclePic.setFitHeight(400);
                    removeAllFromHBox();
                    imageHBox.getChildren().addAll(leftArrowButton, vehiclePic, rightArrowButton);
                }
            }
        });
    }

    private void createCenterPane()
    {
        MenuBar menuBar = new MenuBar((int)this.getPrefWidth());
        FilterBar filterBar = new FilterBar((int)(this.getPrefHeight() - menuBar.getPrefHeight()));
        imageHBox.setCenterShape(true);

        vehiclePic.setFitWidth(600);
        vehiclePic.setFitHeight(400);
        leftArrowButton.setMinSize(100, 400);
        rightArrowButton.setPrefSize(100, 400);

        imageHBox.getChildren().addAll(leftArrowButton, vehiclePic, rightArrowButton);
        setTop(menuBar);
        setCenter(imageHBox);
        setLeft(filterBar);
    }

    private void removeAllFromHBox()
    {
        int size = imageHBox.getChildren().size();
        for(int i = 0; i <  size; i++)
        {
            imageHBox.getChildren().remove(0);
        }
    }
}
