package frontend.Customer;

import backend.customer_manager.Customer;
import backend.customer_manager.Individual;
import backend.order_manager.Order;

import java.util.ArrayList;

public class CustomerAspect {

    private Customer customer;
    private String identifier;

    private String pathOfPic;
    private ArrayList<Order> orders;

    public CustomerAspect(Customer customer) {
        this.customer = customer;
        this.identifier = "Default";
        this.pathOfPic = "resources/customer_pics/";
        if (customer instanceof Individual)
        {
            this.pathOfPic = this.pathOfPic + "individual_default.png";
        }
        else
        {
            this.pathOfPic = this.pathOfPic + "company_default.png";
        }
        orders = new ArrayList<>();
    }

    public String getIdentifier()
    {
        return customer.getIdentifier();
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getPathOfPic() {
        return pathOfPic;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void addToOrders(Order order)
    {
        orders.add(order);
    }
}
