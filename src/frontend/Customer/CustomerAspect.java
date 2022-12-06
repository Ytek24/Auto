package frontend.Customer;

import backend.customer_manager.Customer;
import backend.customer_manager.Individual;

public class CustomerAspect {

    private Customer customer;
    private String identifier;

    private String pathOfPic;

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
}
