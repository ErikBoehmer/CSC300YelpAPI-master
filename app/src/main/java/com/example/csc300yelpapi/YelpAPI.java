package com.example.csc300yelpapi;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class YelpAPI extends Thread
{
    @Override
    public void run()
    {
        try
        {
            URL businessEndpoint = new URL("https://api.yelp.com/v3/businesses/search?location=Mequon+WI&categories=restaurants");
            HttpURLConnection conn = (HttpURLConnection)businessEndpoint.openConnection();
            conn.setRequestProperty("Authorization", "Bearer QfNiw2MDLN8b9O5a9AuxnEmrkPVsq1r_aC7lRvG7KgavAvAzo1SgNpG0cdRrocYHZ4zzj6Eog1R6sbXZDkipb89DhTCGI6yQbMTAC5gOky8ecCR64j-nhy4rvbzTXHYx");
            Scanner input = new Scanner(conn.getInputStream());
            String data = "";

            while(input.hasNextLine())
            {
                data = data + input.nextLine();
            }
            input.close();
            System.out.println("*** DATA: " + data);

            JSONObject obj = new JSONObject(data);
            JSONArray businesses = obj.getJSONArray("businesses");
            for(int i = 0; i < businesses.length(); i++)
            {
                String name = businesses.getJSONObject(i).getString("name");
                System.out.println("*** " + name);
            }


        }
        catch(Exception e)
        {
            System.out.println("*** " + e.toString());
        }
    }

}