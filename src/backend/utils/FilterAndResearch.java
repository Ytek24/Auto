package backend.utils;

import backend.system_manager.Catalog;
import backend.system_manager.VehicleCatalog;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Date;

public class FilterAndResearch {

    ArrayList<String> brandList;
    ArrayList<String> modelList;
    ArrayList<Date> releaseDateList;
    ArrayList<Color> colorList;
    ArrayList<Integer> nbSeatsList;
    ArrayList<Integer> fiscalPowerList;
    ArrayList<Double> consumptionList;
    ArrayList<Double> co2EmissionList;
    ArrayList<Double> distanceTraveledList;
    ArrayList<Double> priceList;
    ArrayList<Integer> nbWheelsList;

    public FilterAndResearch(Catalog catalog)
    {
        brandList = new ArrayList<>();
        modelList = new ArrayList<>();
        releaseDateList = new ArrayList<>();
        colorList = new ArrayList<>();
        nbSeatsList = new ArrayList<>();
        fiscalPowerList = new ArrayList<>();
        consumptionList = new ArrayList<>();
        co2EmissionList = new ArrayList<>();
        distanceTraveledList = new ArrayList<>();
        priceList = new ArrayList<>();
        nbWheelsList = new ArrayList<>();

        addBrandIfDoesntExist(catalog);
        addModelIfDoesntExist(catalog);
        addColorIfDoesntExist(catalog);
        addNbSeatsIfDoesntExist(catalog);
        addFiscalPowerIfDoesntExist(catalog);
        addConsumptionIfDoesntExist(catalog);
        addCo2EmissionIfDoesntExist(catalog);
        addDistanceTraveledIfDoesntExist(catalog);
        addPriceIfDoesntExist(catalog);
        addNbWheelsIfDoesntExist(catalog);

        for(Integer in: nbWheelsList)
        {
            System.out.println("NbWheels : " + in);
        }

    }

    private void addBrandIfDoesntExist(Catalog catalog) {
        for (VehicleCatalog vehicleCatalog : catalog.getVehiclesCatalog()) {
            if (brandList.size() == 0) {
                brandList.add(vehicleCatalog.getBrand());
            } else {
                int i = 0;
                boolean exit = false;
                while (!exit) {
                    if (i < brandList.size())
                    {
                        if (brandList.get(i).compareTo(vehicleCatalog.getBrand()) > 0)
                        {
                            brandList.add(i, vehicleCatalog.getBrand());
                            exit = true;
                        }
                        else if (brandList.get(i).compareTo(vehicleCatalog.getBrand()) < 0)
                        {
                            i++;
                        }
                        else
                        {
                            exit = true;
                        }
                    }
                    else
                    {
                        brandList.add(vehicleCatalog.getBrand());
                    }
                }
            }
        }
    }

    private void addModelIfDoesntExist(Catalog catalog)
    {
        for (VehicleCatalog vehicleCatalog : catalog.getVehiclesCatalog()) {
            if (modelList.size() == 0) {
                modelList.add(vehicleCatalog.getModel());
            } else {
                int i = 0;
                boolean exit = false;
                while (!exit) {
                    if (i < modelList.size())
                    {
                        if (modelList.get(i).compareTo(vehicleCatalog.getModel()) > 0)
                        {
                            modelList.add(i, vehicleCatalog.getModel());
                            exit = true;
                        }
                        else if (modelList.get(i).compareTo(vehicleCatalog.getModel()) < 0)
                        {
                            i++;
                        }
                        else
                        {
                            exit = true;
                        }
                    }
                    else
                    {
                        modelList.add(vehicleCatalog.getModel());
                    }
                }
            }
        }
    }

    //TODO Activate it
    private void addReleaseDateIfDoesntExist(Catalog catalog)
    {
        for (VehicleCatalog vehicleCatalog : catalog.getVehiclesCatalog()) {
            if (releaseDateList.size() == 0) {
                releaseDateList.add(vehicleCatalog.getReleasedDate());
            } else {
                int i = 0;
                boolean exit = false;
                while (!exit) {
                    if (i < releaseDateList.size())
                    {
                        if (releaseDateList.get(i).compareTo(vehicleCatalog.getReleasedDate()) > 0)
                        {
                            releaseDateList.add(i, vehicleCatalog.getReleasedDate());
                            exit = true;
                        }
                        else if (releaseDateList.get(i).compareTo(vehicleCatalog.getReleasedDate()) < 0)
                        {
                            i++;
                        }
                        else
                        {
                            exit = true;
                        }
                    }
                    else
                    {
                        releaseDateList.add(vehicleCatalog.getReleasedDate());
                    }
                }
            }
        }

    }

    private void addColorIfDoesntExist(Catalog catalog)
    {
        for (VehicleCatalog vehicleCatalog : catalog.getVehiclesCatalog()) {
            if (colorList.size() == 0) {
                colorList.add(vehicleCatalog.getColor());
            } else {
                int i = 0;
                boolean exit = false;
                while (!exit) {
                    if (i < colorList.size())
                    {
                        if (colorList.get(i).toString().compareTo(vehicleCatalog.getColorToString()) > 0)
                        {
                            colorList.add(i, vehicleCatalog.getColor());
                            exit = true;
                        }
                        else if (colorList.get(i).toString().compareTo(vehicleCatalog.getColorToString()) < 0)
                        {
                            i++;
                        }
                        else
                        {
                            exit = true;
                        }
                    }
                    else
                    {
                        colorList.add(vehicleCatalog.getColor());
                    }
                }
            }
        }
    }

    private void addNbSeatsIfDoesntExist(Catalog catalog)
    {
        for (VehicleCatalog vehicleCatalog : catalog.getVehiclesCatalog()) {
            if (nbSeatsList.size() == 0) {
                nbSeatsList.add(vehicleCatalog.getNbSeats());
            } else {
                int i = 0;
                boolean exit = false;
                while (!exit) {
                    if (i < nbSeatsList.size())
                    {
                        if (nbSeatsList.get(i) > vehicleCatalog.getNbSeats())
                        {
                            nbSeatsList.add(i, vehicleCatalog.getNbSeats());
                            exit = true;
                        }
                        else if (nbSeatsList.get(i) < vehicleCatalog.getNbSeats())
                        {
                            i++;
                        }
                        else
                        {
                            exit = true;
                        }
                    }
                    else
                    {
                        nbSeatsList.add(vehicleCatalog.getNbSeats());
                    }
                }
            }
        }
    }

    private void addFiscalPowerIfDoesntExist(Catalog catalog)
    {
        for (VehicleCatalog vehicleCatalog : catalog.getVehiclesCatalog()) {
            if (fiscalPowerList.size() == 0) {
                fiscalPowerList.add(vehicleCatalog.getFiscalPower());
            } else {
                int i = 0;
                boolean exit = false;
                while (!exit) {
                    if (i < fiscalPowerList.size())
                    {
                        if (fiscalPowerList.get(i) > vehicleCatalog.getFiscalPower())
                        {
                            fiscalPowerList.add(i, vehicleCatalog.getFiscalPower());
                            exit = true;
                        }
                        else if (fiscalPowerList.get(i) < vehicleCatalog.getFiscalPower())
                        {
                            i++;
                        }
                        else
                        {
                            exit = true;
                        }
                    }
                    else
                    {
                        fiscalPowerList.add(vehicleCatalog.getFiscalPower());
                    }
                }
            }
        }
    }

    private void addConsumptionIfDoesntExist(Catalog catalog)
    {
        for (VehicleCatalog vehicleCatalog : catalog.getVehiclesCatalog()) {
            if (consumptionList.size() == 0) {
                consumptionList.add(vehicleCatalog.getConsumption());
            } else {
                int i = 0;
                boolean exit = false;
                while (!exit) {
                    if (i < consumptionList.size())
                    {
                        if (consumptionList.get(i) > vehicleCatalog.getConsumption())
                        {
                            consumptionList.add(i, vehicleCatalog.getConsumption());
                            exit = true;
                        }
                        else if (consumptionList.get(i) < vehicleCatalog.getConsumption())
                        {
                            i++;
                        }
                        else
                        {
                            exit = true;
                        }
                    }
                    else
                    {
                        consumptionList.add(vehicleCatalog.getConsumption());
                    }
                }
            }
        }
    }

    private void addCo2EmissionIfDoesntExist(Catalog catalog)
    {
        for (VehicleCatalog vehicleCatalog : catalog.getVehiclesCatalog()) {
            if (co2EmissionList.size() == 0) {
                co2EmissionList.add(vehicleCatalog.getCo2Emission());
            } else {
                int i = 0;
                boolean exit = false;
                while (!exit) {
                    if (i < co2EmissionList.size())
                    {
                        if (co2EmissionList.get(i) > vehicleCatalog.getCo2Emission())
                        {
                            co2EmissionList.add(i, vehicleCatalog.getCo2Emission());
                            exit = true;
                        }
                        else if (co2EmissionList.get(i) < vehicleCatalog.getCo2Emission())
                        {
                            i++;
                        }
                        else
                        {
                            exit = true;
                        }
                    }
                    else
                    {
                        co2EmissionList.add(vehicleCatalog.getCo2Emission());
                    }
                }
            }
        }
    }

    private void addDistanceTraveledIfDoesntExist(Catalog catalog)
    {
        for (VehicleCatalog vehicleCatalog : catalog.getVehiclesCatalog()) {
            if (distanceTraveledList.size() == 0) {
                distanceTraveledList.add(vehicleCatalog.getDistanceTraveled());
            } else {
                int i = 0;
                boolean exit = false;
                while (!exit) {
                    if (i < distanceTraveledList.size())
                    {
                        if (distanceTraveledList.get(i) > vehicleCatalog.getDistanceTraveled())
                        {
                            distanceTraveledList.add(i, vehicleCatalog.getDistanceTraveled());
                            exit = true;
                        }
                        else if (distanceTraveledList.get(i) < vehicleCatalog.getDistanceTraveled())
                        {
                            i++;
                        }
                        else
                        {
                            exit = true;
                        }
                    }
                    else
                    {
                        distanceTraveledList.add(vehicleCatalog.getDistanceTraveled());
                    }
                }
            }
        }
    }

    private void addPriceIfDoesntExist(Catalog catalog)
    {
        for (VehicleCatalog vehicleCatalog : catalog.getVehiclesCatalog()) {
            if (priceList.size() == 0) {
                priceList.add(vehicleCatalog.getPrice());
            } else {
                int i = 0;
                boolean exit = false;
                while (!exit) {
                    if (i < priceList.size())
                    {
                        if (priceList.get(i) > vehicleCatalog.getPrice())
                        {
                            priceList.add(i, vehicleCatalog.getPrice());
                            exit = true;
                        }
                        else if (priceList.get(i) < vehicleCatalog.getPrice())
                        {
                            i++;
                        }
                        else
                        {
                            exit = true;
                        }
                    }
                    else
                    {
                        priceList.add(vehicleCatalog.getPrice());
                    }
                }
            }
        }
    }

    private void addNbWheelsIfDoesntExist(Catalog catalog)
    {
        for (VehicleCatalog vehicleCatalog : catalog.getVehiclesCatalog()) {
            if (nbWheelsList.size() == 0) {
                nbWheelsList.add(vehicleCatalog.getNbWheels());
            } else {
                int i = 0;
                boolean exit = false;
                while (!exit) {
                    if (i < nbWheelsList.size())
                    {
                        if (nbWheelsList.get(i) > vehicleCatalog.getNbWheels())
                        {
                            nbWheelsList.add(i, vehicleCatalog.getNbWheels());
                            exit = true;
                        }
                        else if (nbWheelsList.get(i) < vehicleCatalog.getNbWheels())
                        {
                            i++;
                        }
                        else
                        {
                            exit = true;
                        }
                    }
                    else
                    {
                        nbWheelsList.add(vehicleCatalog.getNbWheels());
                    }
                }
            }
        }
    }
}
