package frontend.Customer;

import backend.order_manager.Order;
import frontend.Home.HomeScene;
import frontend.Home.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

public class CustomerScene extends BorderPane {

    private HomeScene homeScene;
    private MenuBar menuBar;

    private VBox orderVBox;


    public CustomerScene(HomeScene homeScene) {

        this.homeScene = homeScene;
        menuBar = homeScene.getMenuBar();
        orderVBox = new VBox();
    }

    public void updateCustomerOrders()
    {
        orderVBox.getChildren().clear();
        for(Order order: menuBar.getCustomerAspect().getOrders())
        {
            orderVBox.getChildren().add(new OrderItem(order));
        }
        setCenter(orderVBox);
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }
}
