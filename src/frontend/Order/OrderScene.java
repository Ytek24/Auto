package frontend.Order;

import backend.order_manager.Order;
import backend.order_manager.OrderDownPayment;
import backend.order_manager.OrderLoanPayment;
import backend.system_manager.VehicleCatalog;
import backend.utils.OrderUtil;
import frontend.Customer.CustomerScene;
import frontend.Home.HomeScene;
import frontend.Home.VehicleDescriptionViewer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class OrderScene extends BorderPane {

    private HomeScene homeScene;
    private CustomerScene customerScene;
    private VehicleDescriptionViewer vehicleDescriptionViewer;

    private VehicleCatalog vehicleCatalog;
    private OrderUtil orderUtil;

    private Order order;

    private VBox centerVBox;

    private Label orderFormLbl;

    HBox orderTypeHBox;
    Label orderTypeLbl;
    private ComboBox orderTypeCb;


    private HBox countriesHBox;
    Label countriesLbl;
    private ComboBox countriesFromCb;
    private ComboBox countriesToCb;

    private Label forVehicleCatalogLbl;

    private HBox calculatePriceHBox;
    private Label calculatePriceLbl;
    private Label calculatePriceValueLbl;

    private HBox priceHBox;
    private Label priceLbl;
    private Label priceValueLbl;

    private HBox buttonsHBox;

    private Button previewButton;
    private Button discardButton;
    private Button acceptButton;



    public OrderScene(HomeScene homeScene, CustomerScene customerScene)
    {

        this.homeScene = homeScene;
        this.customerScene = customerScene;
        this.vehicleDescriptionViewer = homeScene.getVehicleDescriptionViewer();

        vehicleCatalog = homeScene.getVehicleCatalog();
        orderUtil = new OrderUtil();

        centerVBox = new VBox();
        centerVBox.setSpacing(75);

        orderFormLbl = new Label("Order Form");
        orderFormLbl.setFont(Font.font(orderFormLbl.getFont().toString(), FontWeight.BOLD, 50));


        orderTypeHBox = new HBox();
        orderTypeHBox.setSpacing(15);
        orderTypeLbl = new Label("Order type: ");
        orderTypeLbl.setFont(Font.font(orderTypeLbl.getFont().toString(), FontWeight.BOLD, 14));
        orderTypeCb = new ComboBox();
        orderTypeCb.getItems().add("Down payment");
        orderTypeCb.getItems().add("Loan payment");

        orderTypeHBox.getChildren().addAll(orderTypeLbl, orderTypeCb);

        countriesHBox = new HBox();
        countriesHBox.setSpacing(20);

        countriesLbl = new Label("Country From/To: ");
        countriesLbl.setFont(Font.font(countriesLbl.getFont().toString(), FontWeight.BOLD, 14));

        countriesFromCb = new ComboBox();
        for(String countFrom: orderUtil.getCountriesFrom())
        {
            countriesFromCb.getItems().add(countFrom);
        }

        countriesToCb = new ComboBox();
        for(String countTo: orderUtil.getCountriesTo())
        {
            countriesToCb.getItems().add(countTo);
        }

        countriesHBox.getChildren().addAll(countriesLbl, countriesFromCb, countriesToCb);

        forVehicleCatalogLbl = new Label("Concerned offer: " + vehicleCatalog.getCatalogTitle());
        forVehicleCatalogLbl.setFont(Font.font(forVehicleCatalogLbl.getFont().toString(), FontWeight.BOLD, 14));

        calculatePriceHBox = new HBox();
        calculatePriceLbl = new Label("Used method: ");
        calculatePriceLbl.setFont(Font.font(calculatePriceLbl.getFont().toString(), FontWeight.BOLD, 14));
        calculatePriceValueLbl = new Label();

        calculatePriceHBox.getChildren().addAll(calculatePriceLbl, calculatePriceValueLbl);

        priceHBox = new HBox();
        priceLbl = new Label("Price: ");
        priceLbl.setFont(Font.font(priceLbl.getFont().toString(), FontWeight.BOLD, 14));
        priceValueLbl = new Label();

        priceHBox.getChildren().addAll(priceLbl, priceValueLbl);

        buttonsHBox = new HBox();
        buttonsHBox.setAlignment(Pos.CENTER);
        buttonsHBox.setPadding(new Insets(0, 0, 20, 0));
        buttonsHBox.setSpacing(15);

        previewButton = new Button("Preview");
        discardButton = new Button("Discard");
        acceptButton = new Button("Accept");

        buttonsHBox.getChildren().addAll(previewButton, discardButton, acceptButton);


        centerVBox.getChildren().addAll(orderTypeHBox, countriesHBox,
                forVehicleCatalogLbl, calculatePriceHBox, priceHBox);

        centerVBox.setMaxWidth(1000);

        centerVBox.setPadding(new Insets(100, 0, 100, 0));

        setTop(orderFormLbl);
        setCenter(centerVBox);
        setBottom(buttonsHBox);

        setAlignment(getTop(), Pos.CENTER);

        onPreviewAction();
    }

    private void onPreviewAction()
    {
        previewButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setAppropriateOrder();
            }
        });
    }

    public void setAppropriateOrder()
    {
        String orderType;
        try {
            orderType = orderTypeCb.getSelectionModel().getSelectedItem().toString();
        }catch (NullPointerException e)
        {
            orderType = "Empty";
        }

        String countriesFrom;
        try {
            countriesFrom = countriesFromCb.getSelectionModel().getSelectedItem().toString();
        }catch (NullPointerException e)
        {
            countriesFrom = "Empty";
        }

        String countriesTo;
        try {
            countriesTo = countriesToCb.getSelectionModel().getSelectedItem().toString();
        }catch (NullPointerException e)
        {
            countriesTo = "Empty";
        }

        if (orderType.compareTo("Down payment") == 0)
        {
            order = new OrderDownPayment(
                    countriesFrom,
                    countriesTo,
                    vehicleCatalog
            );
            calculatePriceValueLbl.setText("vehicleCatalog.getPrice() + vehicleCatalog.getPrice() * getTax()");
            priceValueLbl.setText(vehicleCatalog.getPrice() + " + " + vehicleCatalog.getPrice() + " * " + order.getTax() + " = " + order.getCost());

        }
        else if (orderType.compareTo("Loan payment") == 0)
        {
            order = new OrderLoanPayment(
                    countriesFrom,
                    countriesTo,
                    vehicleCatalog
            );
            calculatePriceValueLbl.setText("1.10 * vehicleCatalog.getPrice() + vehicleCatalog.getPrice() * getTax()");
            priceValueLbl.setText("1.10 * " + vehicleCatalog.getPrice() + " + " + vehicleCatalog.getPrice() + " * " + order.getTax() + " = " + order.getCost());
        }
    }

    public void clearAll()
    {
        order = null;
        calculatePriceValueLbl.setText("");
        priceValueLbl.setText("");
        orderTypeCb.getSelectionModel().clearSelection();
        countriesFromCb.getSelectionModel().clearSelection();
        countriesToCb.getSelectionModel().clearSelection();
    }

    public VehicleDescriptionViewer getVehicleDescriptionViewer() {
        return vehicleDescriptionViewer;
    }

    public Button getDiscardButton() {
        return discardButton;
    }

    public Button getAcceptButton() {
        return acceptButton;
    }

    public Order getOrder() {
        return order;
    }
}
