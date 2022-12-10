package frontend.Customer;

import backend.order_manager.Order;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


public class OrderItem extends HBox {

    private Order order;

    private Label countryFromLbl;
    private Label countryToLbl;
    private Label appliedTaxLbl;
    private Label stateLbl;
    private Label costLbl;
    private Label vehicleCatalogTitleLbl;

    public OrderItem(String countryFromString, String countrtToString, String appliedTaxString,
                     String stateString, String costString, String vehicleCatalogTitleString) {

        setSpacing(40);

        this.countryFromLbl = new Label(countryFromString);
        this.countryFromLbl.setPrefSize(200, 40);
        this.countryToLbl = new Label(countrtToString);
        this.countryToLbl.setPrefSize(200, 40);
        this.appliedTaxLbl = new Label(appliedTaxString);
        this.appliedTaxLbl.setPrefSize(200, 40);
        this.stateLbl = new Label(stateString);
        this.stateLbl.setPrefSize(200, 40);
        this.costLbl = new Label(costString);
        this.costLbl.setPrefSize(200, 40);
        this.vehicleCatalogTitleLbl = new Label(vehicleCatalogTitleString);
        this.vehicleCatalogTitleLbl.setPrefSize(200, 40);

        getChildren().addAll(countryFromLbl, countryToLbl,
                appliedTaxLbl, stateLbl, costLbl, vehicleCatalogTitleLbl);

        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));

    }

    public OrderItem(Order order) {
        this.order = order;

        setSpacing(40);

        this.countryFromLbl = new Label(order.getCountryFrom());
        this.countryFromLbl.setPrefSize(200, 40);
        this.countryToLbl = new Label(order.getCountryTo());
        this.countryToLbl.setPrefSize(200, 40);
        this.appliedTaxLbl = new Label(String.valueOf(order.getTax()));
        this.appliedTaxLbl.setPrefSize(200, 40);
        this.stateLbl = new Label(order.getState().label);
        this.stateLbl.setPrefSize(200, 40);
        this.costLbl = new Label(String.valueOf(order.getCost()));
        this.costLbl.setPrefSize(200, 40);
        this.vehicleCatalogTitleLbl = new Label(order.getVehicleCatalog().getCatalogTitle());
        this.vehicleCatalogTitleLbl.setPrefSize(200, 40);

        getChildren().addAll(countryFromLbl, countryToLbl,
                appliedTaxLbl, stateLbl, costLbl, vehicleCatalogTitleLbl);

        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));

    }
}
