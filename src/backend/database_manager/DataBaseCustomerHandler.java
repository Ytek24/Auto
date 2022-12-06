package backend.database_manager;

import backend.customer_manager.Company;
import backend.customer_manager.Customer;
import backend.customer_manager.Individual;
import frontend.Customer.CustomerAspect;

import java.io.*;
import java.util.ArrayList;

public class DataBaseCustomerHandler {

    public static void customerInformationFromDataBase(ArrayList<CustomerAspect> customerAspects)
    {
        FileInputStream stream = null;

        try {
            stream = new FileInputStream("src/database/customer.csv");
        } catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String line;
        String[] words;
        try{
            while((line = reader.readLine()) != null)
            {
                words = line.split(",");
                if(words[0].compareTo("Individual") == 0)
                {
                    try{
                        customerAspects.add(new CustomerAspect(new Individual(words[1],words[2],Integer.parseInt(words[3]))) {
                        });
                    }catch (ClassCastException e)
                    {
                        e.printStackTrace();
                    }
                }
                else if(words[0].compareTo("Company") == 0)
                {
                    try{
                        customerAspects.add(new CustomerAspect(new Company(words[1],Long.parseLong(words[2]))));
                    }catch (ClassCastException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        } catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
