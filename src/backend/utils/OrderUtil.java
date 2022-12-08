package backend.utils;

import java.io.*;
import java.util.ArrayList;

public class OrderUtil {

    private ArrayList<String> countriesFrom;
    private ArrayList<String> countriesTo;

    public OrderUtil()
    {
        countriesFrom = new ArrayList<>();
        countriesTo = new ArrayList<>();
        fillUpCountriesFromAndToAL();
    }

    private void fillUpCountriesFromAndToAL()
    {
        FileInputStream stream = null;

        try {
            stream = new FileInputStream("src/database/tax.csv");
        } catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        try{
            String line = reader.readLine();
            String[] words;

            while((line = reader.readLine()) != null)
            {
                words = line.split(",");
                if (countriesFrom.size() == 0)
                {
                    countriesFrom.add(words[0]);
                }
                else
                {
                    int i = 0;
                    boolean exist = false;
                    while (i < countriesFrom.size() && !exist)
                    {
                        if(countriesFrom.get(i).compareTo(words[0]) == 0)
                        {
                            exist = true;
                        }
                        i++;
                    }
                    if (!exist)
                    {
                        countriesFrom.add(words[0]);
                    }
                }

                if (countriesTo.size() == 0)
                {
                    countriesTo.add(words[1]);
                }
                else
                {
                    int i = 0;
                    boolean exist = false;
                    while (i < countriesTo.size() && !exist)
                    {
                        if(countriesTo.get(i).compareTo(words[1]) == 0)
                        {
                            exist = true;
                        }
                        i++;
                    }
                    if (!exist)
                    {
                        countriesTo.add(words[1]);
                    }
                }
            }
        } catch(IOException e)
        {
            e.printStackTrace();
        }

        try {
            reader.close();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getCountriesFrom() {
        return countriesFrom;
    }

    public ArrayList<String> getCountriesTo() {
        return countriesTo;
    }
}
