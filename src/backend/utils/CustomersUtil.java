package backend.utils;

import backend.customer_manager.Customer;
import frontend.Customer.CustomerAspect;

import java.util.ArrayList;

public class CustomersUtil {

    public static CustomerAspect doesIDBelongToCustomers(long ID, ArrayList<CustomerAspect> customersAspects)
    {
        for(CustomerAspect custAsp : customersAspects)
        {
            if (custAsp.getCustomer().getID() == ID)
            {
                return custAsp;
            }
        }
        return null;
    }
}
