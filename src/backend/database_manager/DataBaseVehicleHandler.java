package backend.database_manager;

import backend.system_manager.Catalog;
import backend.system_manager.VehicleCatalog;
import backend.vehicle_manager.Automotive;
import backend.vehicle_manager.Scooter;
import javafx.scene.paint.Color;

import java.io.*;
import java.util.Date;

public class DataBaseVehicleHandler {
    public static void vehicleDescriptionFromDataBase(Catalog catalog)
    {
        FileInputStream stream = null;

        try {
            stream = new FileInputStream("src/database/vehicle.csv");
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
                if(words[0].compareTo("Automotive") == 0)
                {
                    try{
                        boolean firstHand;
                        if(words[6].compareTo("no") == 0)
                        {
                            firstHand = false;
                        }
                        else {
                            firstHand = true;
                        }
                        catalog.addVehicleCatalog(new VehicleCatalog(words[1], new Automotive(words[2], words[3],
                                words[4], new Date(Integer.parseInt(words[5])-1, 12, 01), firstHand, Color.web(words[7]),
                                Integer.parseInt(words[8]), Integer.parseInt(words[9]), Double.parseDouble(words[10]),
                                Double.parseDouble(words[11]), Double.parseDouble(words[12]), Double.parseDouble(words[13])), new Date(1000), words[14]));

                    }catch (ClassCastException e)
                    {
                        e.printStackTrace();
                    }
                }
                else if(words[0].compareTo("Scooter") == 0)
                {
                    try{
                        boolean firstHand;
                        if(words[6].compareTo("no") == 0)
                        {
                            firstHand = false;
                        }
                        else {
                            firstHand = true;
                        }
                        catalog.addVehicleCatalog(new VehicleCatalog(words[1], new Scooter(words[2], words[3],
                                words[4], new Date(Integer.parseInt(words[5])-1, 12, 01), firstHand, Color.web(words[7]),
                                Integer.parseInt(words[8]), Integer.parseInt(words[9]), Double.parseDouble(words[10]),
                                Double.parseDouble(words[11]), Double.parseDouble(words[12]), Double.parseDouble(words[13])), new Date(1000), words[14]));

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
