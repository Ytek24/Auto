package frontend.Customer;

import backend.order_manager.Order;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;


public class OrderItem extends HBox {

    private Order order;

    private Label countryFromLbl;
    private Label countrtToLbl;
    private Label appliedTaxLbl;
    private Label stateLbl;
    private Label costLbl;
    private Label vehicleCatalogTitleLbl;

    public OrderItem(Order order) {
        this.order = order;

        this.countryFromLbl = new Label(order.getCountryFrom());
        this.countrtToLbl = new Label(order.getCountryTo());
        this.appliedTaxLbl = new Label(String.valueOf(order.getTax()));
        this.stateLbl = new Label(order.getState().label);
        this.costLbl = new Label(String.valueOf(order.getCost()));
        this.vehicleCatalogTitleLbl = new Label(order.getVehicleCatalog().getCatalogTitle());

        setSpacing(5);
        getChildren().addAll(countryFromLbl, countrtToLbl,
                appliedTaxLbl, stateLbl, costLbl, vehicleCatalogTitleLbl);
    }
}
