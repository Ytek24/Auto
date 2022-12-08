import frontend.Customer.CustomerScene;
import frontend.Home.HomeScene;
import frontend.Order.OrderScene;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class App extends Application
{
        private double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
        private double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();

        HomeScene homeScene ;
        CustomerScene customerScene;
        OrderScene orderScene;
        public void start(Stage stage) throws Exception
        {



                homeScene = new HomeScene();
                Scene home = new Scene(homeScene, screenWidth, screenHeight);

                customerScene = new CustomerScene(homeScene);
                Scene customer = new Scene(customerScene, screenWidth, screenHeight);

                orderScene = new OrderScene(homeScene, customerScene);
                Scene order = new Scene(orderScene, screenWidth, screenHeight);

                onCustomerImageViewClick(stage, customer);
                onBuyButtonAction(stage, order);
                onOrderDiscardButtonAction(stage, home);
                onOrderAcceptButtonAction(stage, customerScene, customer);

                stage.setScene(home);
                stage.setMaximized(true);

                stage.show();
        }

        private void onCustomerImageViewClick(Stage stage, Scene customer)
        {
                customerScene.getMenuBar().getCustomerGraphic().setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                                if (homeScene.getMenuBar().getCustomerAspect() != null)
                                {
                                        homeScene.setTop(null);
                                        customerScene.setTop(customerScene.getMenuBar());
                                        customerScene.updateCustomerOrders();
                                        stage.setScene(customer);
                                }
                        }
                });
        }

        private void onBuyButtonAction(Stage stage, Scene order)
        {
                homeScene.getBuyButton().setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                                stage.setScene(order);
                        }
                });
        }

        private void onOrderDiscardButtonAction(Stage stage, Scene home)
        {
                orderScene.getDiscardButton().setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                                orderScene.clearAll();
                                stage.setScene(home);
                        }
                });

        }

        private void onOrderAcceptButtonAction(Stage stage, CustomerScene customerScene, Scene customer)
        {
                orderScene.getAcceptButton().setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                                customerScene.getMenuBar().getCustomerAspect().addToOrders(orderScene.getOrder());
                                orderScene.clearAll();
                                homeScene.setTop(null);
                                customerScene.setTop(customerScene.getMenuBar());
                                customerScene.updateCustomerOrders();
                                stage.setScene(customer);
                        }
                });
        }


}