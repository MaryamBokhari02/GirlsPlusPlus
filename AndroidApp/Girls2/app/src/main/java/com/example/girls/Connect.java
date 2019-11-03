package com.example.girls;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.*;
import java.util.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

class Connect{

    public static Object ParseintoAPICall(String function, HashMap<String,String> param, String ObjectType )
    {
        try {
            String s = "https://attend-in.com/GirlsPlusPlus/gppapi.php?";
            s += "function" + "=" + URLEncoder.encode(function, "UTF-8");
            URL url = new URL(s);
            //Some functions don't need any parameters and their hashmap is gonna be Empty
            if (param.isEmpty() == false) {
                for (Map.Entry mapElement : param.entrySet()) {
                    String key = (String) mapElement.getKey();
                    String value = (String) mapElement.getValue();
                    s += "&" + URLEncoder.encode(key, "UTF-8") + "=";
                    s += URLEncoder.encode(value, "UTF-8");

                }

            }
            // read from the URL
            Scanner scan = new Scanner(url.openStream());
            String str = new String();
            while (scan.hasNext())
                str += scan.nextLine();
            scan.close();
            //return str;
            ObjectMapper mapper = new ObjectMapper();
            Profile P= new Profile();

            try
            {
                if( ObjectType.equals("Proflile") )
                {
                    P = mapper.readValue(str, Profile.class);
                }
                if( ObjectType.equals("Feedback"))
                {
                    P.setFirstName("Hi");
                    return P;
                }

            }
            catch(Exception e) {
                System.out.println(e.toString());
                return P;
            }
            return P;

        }
        catch(Exception e)
        {
            return new Profile();
        }


    }

}