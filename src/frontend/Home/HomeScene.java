package frontend.Home;

import backend.customer_manager.Customer;
import backend.database_manager.DataBaseCustomerHandler;
import backend.database_manager.DataBaseVehicleHandler;
import backend.system_manager.Catalog;
import backend.system_manager.VehicleCatalog;
import frontend.Customer.CustomerAspect;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;

import java.util.ArrayList;

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

    ArrayList<CustomerAspect> customersAspects;




    public HomeScene() {
        this.screenWidth = (int)Screen.getPrimary().getVisualBounds().getWidth();
        this.screenHeight = (int)Screen.getPrimary().getVisualBounds().getHeight();
        setPrefSize(screenWidth, screenHeight);

        catalog = new Catalog();
        DataBaseVehicleHandler.vehicleDescriptionFromDataBase(catalog);
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

        customersAspects = new ArrayList<>();
        DataBaseCustomerHandler.customerInformationFromDataBase(customersAspects);

        createCenterPane();
        initButtonsActions();
        disableOrEnableArrowButtons();
    }

    private void initButtonsActions()
    {
        this.leftArrowButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(currentIndex>0)
                {
                    currentIndex-=1;
                    vehicleCatalog = catalog.getVehiclesCatalog().get(currentIndex);
                    changeVehiclePic();
                    disableOrEnableArrowButtons();
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
                    disableOrEnableArrowButtons();
                }
            }
        });
    }

    private void disableOrEnableArrowButtons()
    {
        if(currentIndex == 0)
        {
            leftArrowButton.setDisable(true);
        }
        else
        {
            leftArrowButton.setDisable(false);
        }

        if (currentIndex == (catalog.getVehiclesCatalog().size()-1))
        {
            rightArrowButton.setDisable(true);
        }
        else
        {
            rightArrowButton.setDisable(false);
        }
    }

    private void createCenterPane()
    {
        MenuBar menuBar = new MenuBar(customersAspects);
        FilterBar filterBar = new FilterBar(catalog);
        imageHBox.setCenterShape(true);
        ResultsFilterAndReasearchViewer resultsFilterAndReasearchViewer = new ResultsFilterAndReasearchViewer(filterBar);
        filterBar.getApplyFiltersButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                resultsFilterAndReasearchViewer.initPostLabels(filterBar);
                resultsFilterAndReasearchViewer.setContent(resultsFilterAndReasearchViewer.getFilteredPostVBox());
                catalog = resultsFilterAndReasearchViewer.getCatalogFiltered();
                currentIndex = catalog.getVehiclesCatalog().indexOf(vehicleCatalog);
                if(currentIndex == -1)
                {
                    currentIndex = 0;
                }
                vehicleCatalog = catalog.getVehiclesCatalog().get(currentIndex);
                changeVehiclePic();
                disableOrEnableArrowButtons();

                for(PostLabel postLabel: resultsFilterAndReasearchViewer.getPostLabels())
                {
                    postLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            vehicleCatalog = postLabel.getVehicleCatalog();
                            currentIndex = catalog.getVehiclesCatalog().indexOf(vehicleCatalog);
                            changeVehiclePic();
                            disableOrEnableArrowButtons();
                        }
                    });
                }
            }
        });

        vehiclePic.setFitWidth(600);
        vehiclePic.setFitHeight(400);
        leftArrowButton.setMinSize(100, 400);
        rightArrowButton.setPrefSize(100, 400);

        imageHBox.getChildren().addAll(leftArrowButton, vehiclePic, rightArrowButton);
        setTop(menuBar);
        setRight(vehicleDescriptionViewer);
        setCenter(imageHBox);
        setLeft(filterBar);
        setBottom(resultsFilterAndReasearchViewer);
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
