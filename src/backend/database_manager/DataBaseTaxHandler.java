package backend.database_manager;

import java.io.*;

public class DataBaseTaxHandler {
    public static double taxValueFromDataBase(String countryFrom, String countryTo)
    {
        FileInputStream stream = null;

        try {
            stream = new FileInputStream("src/database/tax.csv");
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
                if((words[0].compareTo(countryFrom) == 0)&&(words[1].compareTo(countryTo) == 0))
                {
                    try{
                        double taxe = Double.parseDouble(words[2]);
                        try {
                            reader.close();
                        }catch (IOException e)
                        {
                            e.printStackTrace();
                        }
                        return taxe;
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
    return -1;
    }
}
