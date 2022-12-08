package frontend.Home;

import frontend.Customer.CustomerAspect;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;

import java.util.ArrayList;

public class MenuBar extends HBox {

    private int screenWidth = (int)Screen.getPrimary().getVisualBounds().getWidth();

    private CustomerAspect customerAspect = null;

    private TextField customerLoginTf;
    private Button customerLoginButton;
    private Button customerLogoutButton;

    private ImageView customerGraphic;
    private VBox customerInfoVBox;

    private Label customerIDLbl;
    private Label customerNameLbl;

    ArrayList<CustomerAspect> customersAspects;

    public MenuBar(ArrayList<CustomerAspect> customersAspects) {

        this.customersAspects = customersAspects;

        setPrefSize(screenWidth, 100);
        setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
        setSpacing(10);
        setPadding(new Insets(5));
        setAlignment(Pos.CENTER_RIGHT);

        customerLoginTf = new TextField();
        customerLoginTf.setPromptText("Your ID");
        customerLoginTf.setFocusTraversable(false);
        customerLoginButton = new Button("Log in");
        customerLogoutButton = new Button("Log out");
        customerGraphic = new ImageView(new Image("resources/customer_pics/customer_default.png"));
        customerGraphic.setFitWidth(100);
        customerGraphic.setFitHeight(getPrefHeight());
        customerInfoVBox = new VBox();
        customerIDLbl = new Label("Default");
        customerNameLbl = new Label("Default");
        customerInfoVBox.getChildren().addAll(customerIDLbl, customerNameLbl);
        notLogged();
    }

    public void logged()
    {
        getChildren().clear();
        getChildren().addAll(customerInfoVBox, customerLogoutButton, customerGraphic);
    }

    public void notLogged()
    {
        getChildren().clear();
        getChildren().addAll(customerLoginTf, customerLoginButton, customerGraphic);
    }

    public void setCustomerInformation(){
        customerGraphic.setImage(new Image(customerAspect.getPathOfPic()));
        customerIDLbl.setText(String.valueOf(customerAspect.getCustomer().getID()));
        customerNameLbl.setText(customerAspect.getIdentifier());
    }

    public void unsetCustomerInformation()
    {
        customerGraphic.setImage(new Image("resources/customer_pics/customer_default.png"));
        customerIDLbl.setText("Default");
        customerNameLbl.setText("Default");
    }

    public ImageView getCustomerGraphic() {
        return customerGraphic;
    }

    public CustomerAspect getCustomerAspect() {
        return customerAspect;
    }

    public void setCustomerAspect(CustomerAspect customerAspect) {
        this.customerAspect = customerAspect;
    }

    public Button getCustomerLoginButton() {
        return customerLoginButton;
    }

    public Button getCustomerLogoutButton() {
        return customerLogoutButton;
    }

    public TextField getCustomerLoginTf() {
        return customerLoginTf;
    }
}
