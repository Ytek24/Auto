package frontend.Customer;

import backend.order_manager.Order;
import frontend.Home.HomeScene;
import frontend.Home.MenuBar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CustomerScene extends BorderPane {

    private HomeScene homeScene;
    private MenuBar menuBar;

    private VBox orderVBox;
    private Label customerOrdersLabel;
    private OrderItem orderCategories;


    public CustomerScene(HomeScene homeScene) {

        this.homeScene = homeScene;
        menuBar = homeScene.getMenuBar();

        orderVBox = new VBox();
        orderVBox.setAlignment(Pos.TOP_CENTER);

        customerOrdersLabel = new Label("Customer Orders");
        customerOrdersLabel.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        customerOrdersLabel.setPadding(new Insets(10));
        customerOrdersLabel.setFont(Font.font(customerOrdersLabel.getFont().toString(), FontWeight.BOLD, 20));
        customerOrdersLabel.setPrefSize(getPrefWidth(), 20);
        customerOrdersLabel.setAlignment(Pos.CENTER);

        orderCategories = new OrderItem("Country from", "Country to",
                "Tax", "Order state", "Final cost",
                "Vehicle catalog title");
        orderCategories.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

        orderVBox.getChildren().addAll(customerOrdersLabel, orderCategories);
    }

    public void updateCustomerOrders()
    {
        orderVBox.getChildren().clear();
        orderVBox.getChildren().add(customerOrdersLabel);
        orderVBox.getChildren().add(orderCategories);
        for(Order order: menuBar.getCustomerAspect().getOrders())
        {
            OrderItem orderItem = new OrderItem(order);
            orderVBox.getChildren().add(orderItem);
        }
        setCenter(orderVBox);
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }
}
