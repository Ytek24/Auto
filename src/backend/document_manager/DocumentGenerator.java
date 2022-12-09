package backend.document_manager;

import backend.customer_manager.Customer;
import backend.order_manager.Order;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DocumentGenerator {

    public static void createRegistCertif(Customer customer, Order order)
    {
        String directoryPath = "src/resources/output_documents/";
        File registCertifFile = new File(directoryPath
                + "registCertif_customer" + customer.getID()
                + "_" + order.getVehicleCatalog().getBrand()
                + "_" + order.getVehicleCatalog().getModel()
                + ".html");
        try
        {
            registCertifFile.createNewFile();
        }catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            FileWriter registCertifWriter = new FileWriter(registCertifFile);
            registCertifWriter.write(
                    "<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "   <head>\n" +
                        "       <style>\n" +
                        "               h3 {\n" +
                        "                   padding-bottom: 50px;\n" +
                        "                   padding-left: 150px;\n" +
                        "               }\n" +
                        "               h2 {\n" +
                        "                   padding-bottom: 10px;\n" +
                        "                   padding-left: 50px\n" +
                        "               }\n" +
                        "               h1 {\n" +
                        "                   padding-bottom: 50px;\n" +
                        "                   padding-left: 250px;\n" +
                        "               }\n" +
                        "       </style>\n" +
                        "   </head>\n" +
                        "   <body>\n" +
                        "       <center>\n" +
                        "           <h1>Demande de certificat d'immatriculation</h1>\n" +
                        "       </center>\n" +
                        "       <h2>Informations du véhicule</h2>\n" +
                        "       <h3>Numéro d'imatriculation : </h3>\n" +
                        "       <h3>Date d'achat : </h3>\n" +
                        "       <h3>Date du certificat actuel : </h3>\n" +
                        "       <h3>Date de première immatriculation : </h3>\n" +
                        "       <h3>Marque : " + order.getVehicleCatalog().getBrand() +  "</h3>\n" +
                        "       <h3>Type : " + order.getVehicleCatalog().getModel() + "</h3>\n" +
                        "       <h2>Informations du propriétaire</h2>\n" +
                        "       <h3>Nom/prénom ou Nom de l'agence : " + customer.getIdentifier() + "</h3>\n" +
                        "       <h3 style=\"padding-bottom: 0px;\">Adresse : </h3>\n" +
                        "       <h3>(exemple : 13 rue Jean Jaurès, 75094 Paris, France)</h3>\n" +
                        "       <h3>Numéro de téléphone : </h3>\n" +
                        "   </body>\n" +
                        "</html>"
            );
            registCertifWriter.close();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void createProtocolOfHandingOver(Customer customer, Order order)
    {
        String directoryPath = "src/resources/output_documents/";
        File registCertifFile = new File(directoryPath
                + "protocolOfHandingOver_customer" + customer.getID()
                + "_" + order.getVehicleCatalog().getBrand()
                + "_" + order.getVehicleCatalog().getModel()
                + ".html");
        try
        {
            registCertifFile.createNewFile();
        }catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            FileWriter registCertifWriter = new FileWriter(registCertifFile);
            registCertifWriter.write("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "   <head>\n" +
                    "       <style>\n" +
                    "               h3 {\n" +
                    "                   padding-bottom: 50px;\n" +
                    "                   padding-left: 150px;\n" +
                    "               }\n" +
                    "               h2 {\n" +
                    "                   padding-bottom: 10px;\n" +
                    "                   padding-left: 50px\n" +
                    "               }\n" +
                    "               h1 {\n" +
                    "                   padding-bottom: 50px;\n" +
                    "                   padding-left: 250px;\n" +
                    "               }\n" +
                    "       </style>\n" +
                    "   </head>\n" +
                    "   <body>\n" +
                    "       <center>\n" +
                    "           <h1>Certificat de cession d'un vehicule</h1>\n" +
                    "       </center>\n" +
                    "       <h2>Informations du véhicule</h2>\n" +
                    "       <h3>Numéro d'imatriculation : </h3>\n" +
                    "       <h3>Date de première immatriculation : </h3>\n" +
                    "       <h3>Marque : " + order.getVehicleCatalog().getBrand() + "</h3>\n" +
                    "       <h3>Type : " + order.getVehicleCatalog().getModel() + "</h3>\n" +
                    "       <h3>Kilométrage inscrit au compteur : " + order.getVehicleCatalog().getDistanceTraveled() + "</h3>\n" +
                    "       <h2>Informations de l'ancien propriétaire</h2>\n" +
                    "       <h3>Nom/prénom ou Nom de l'agence : " + order.getVehicleCatalog().getOwner() + "</h3>\n" +
                    "       <h3 style=\"padding-bottom: 0px;\">Adresse : </h3>\n" +
                    "       <h3>(exemple : 13 rue Jean Jaurès, 75094 Paris, France)</h3>\n" +
                    "       <h3>Numéro de téléphone : </h3>\n" +
                    "       <h3>Fait à : </h3>\n" +
                    "       <h3>Le (JJ/MM/AAAA) : </h3>\n" +
                    "       <h2>Informations du nouveau propriétaire</h2>\n" +
                    "       <h3>Nom/prénom ou Nom de l'agence : " + customer.getIdentifier() + "</h3>\n" +
                    "       <h3 style=\"padding-bottom: 0px;\">Adresse : </h3>\n" +
                    "       <h3>(exemple : 13 rue Jean Jaurès, 75094 Paris, France)</h3>\n" +
                    "       <h3>Numéro de téléphone : </h3>\n" +
                    "       <h3>Fait à : </h3>\n" +
                    "       <h3>Le (JJ/MM/AAAA) : </h3>\n" +
                    "   </body>\n" +
                    "</html>");
            registCertifWriter.close();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void createOrderForm(Customer customer, Order order)
    {

        String directoryPath = "src/resources/output_documents/";
        File registCertifFile = new File(directoryPath
                + "orderForm_customer" + customer.getID()
                + "_" + order.getVehicleCatalog().getBrand()
                + "_" + order.getVehicleCatalog().getModel()
                + ".html");
        try
        {
            registCertifFile.createNewFile();
        }catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            FileWriter registCertifWriter = new FileWriter(registCertifFile);
            registCertifWriter.write("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "   <head>\n" +
                    "       <style>\n" +
                    "               h3 {\n" +
                    "                   padding-bottom: 50px;\n" +
                    "                   padding-left: 150px;\n" +
                    "               }\n" +
                    "               h2 {\n" +
                    "                   padding-bottom: 10px;\n" +
                    "                   padding-left: 50px\n" +
                    "               }\n" +
                    "               h1 {\n" +
                    "                   padding-bottom: 50px;\n" +
                    "                   padding-left: 250px;\n" +
                    "               }\n" +
                    "       </style>\n" +
                    "   </head>\n" +
                    "   <body>\n" +
                    "       <center>\n" +
                    "           <h1>Bon de commande</h1>\n" +
                    "       </center>\n" +
                    "       <h2>Informations de la livraison</h2>\n" +
                    "       <h3>Partant de : " + order.getCountryFrom() + "</h3>\n" +
                    "       <h3>Allant en : " + order.getCountryTo() + "</h3>\n" +
                    "       <h3>Etat de la commande : " + order.getState().label + "</h3>\n" +
                    "       <h2>Informations du véhicule</h2>\n" +
                    "       <h3>Marque : " + order.getVehicleCatalog().getBrand() + "</h3>\n" +
                    "       <h3>Type : " + order.getVehicleCatalog().getModel() + "</h3>\n" +
                    "       <h3>Seconde main : " + order.getVehicleCatalog().getSecondHandToStringFR() + "</h3>\n" +
                    "       <h3>Couleur : " + order.getVehicleCatalog().getColorToString() + "</h3>\n" +
                    "       <h3>Nombre de places : " + order.getVehicleCatalog().getNbSeats() + "</h3>\n" +
                    "       <h3>Puissance fiscale (ch) : " + order.getVehicleCatalog().getFiscalPower() + "</h3>\n" +
                    "       <h3>Consomation (L/100) : " + order.getVehicleCatalog().getConsumption() + "</h3>\n" +
                    "       <h3>Rejet de CO2 (g/100) : " + order.getVehicleCatalog().getCo2Emission() + "</h3>\n" +
                    "       <h3>Kilométrage au compteur : " + order.getVehicleCatalog().getDistanceTraveled() + "</h3>\n" +
                    "       <h3>Nombre de roues : " + order.getVehicleCatalog().getNbWheels() + "</h3>\n" +
                    "       <h2>Informations fiscales</h2>\n" +
                    "       <h3>Taxe (% du prix) : " + order.getTax() + "</h3>\n" +
                    "       <h3>Prix final : " + order.getVehicleCatalog().getPrice() + "</h3>\n" +
                    "   </body>\n" +
                    "</html>");
            registCertifWriter.close();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
