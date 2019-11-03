import org.json.*;
import java.util.*;
import java.net.*;
import java.util.HashMap; 
import java.util.Map; 

class Connect{


    public static void main(String args[]) throws Exception{
            // Call API call. 
    }
    public static Object ParseintoAPICall(string function, HashMap<String,String> param )
    {

         String s = "https://attend-in.com/GirlsPlusPlus/gppapi.php?";
          s += "function" + "=" + URLEncoder.encode(function, "UTF-8");
          URL url = new URL(s);
        //Some functions don't need any parameters and their hashmap is gonna be Empty
        if( param.isEmpty()== False )
        {
            for( Map.Entry mapElement : param.entrySet())) 
            {
                String key = (String)mapElement.getKey();
                String value=((Int)mapElement.getValue(); 
                s += "&"+ URLEncoder.encode(key, "UTF-8") + "=";
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
        Person johnDoe= new Person();
        try 
        { 
            johnDoe = mapper.readValue(str, Person.class);

        }
        catch(Exception e)
        {
             System.out.println(e.toString());
             return new Person(); 
        }
         return johnDoe; 
      
        


        }

    }
}


        // String key1 = "key1";
        // String value1 = "test1";
        // String key2 = "key2";
        // String value2 = "test2";
        // String key3 = "function";
        // String value3 = "test";
        // String key= 
        // private String[] Keys = new String[ ];

        // HashMap<String, String> map = new HashMap<>(); 
        // map.put("function", ""); 

        // String s = "https://attend-in.com/GirlsPlusPlus/gppapi.php?";
        // s += URLEncoder.encode(key1, "UTF-8") + "=";
        // s += URLEncoder.encode(value1, "UTF-8") + "&";
        // s += URLEncoder.encode(key2, "UTF-8") + "=";
        // s += URLEncoder.encode(value2, "UTF-8") + "&";
        // s += URLEncoder.encode(key3, "UTF-8") + "=";
        // s += URLEncoder.encode(value3, "UTF-8");

        // URL url = new URL(s);
        // System.out.println("s = " + s);
    
        // // read from the URL
        // Scanner scan = new Scanner(url.openStream());
        // String str = new String();
        // while (scan.hasNext())
        //     str += scan.nextLine();
        // scan.close();
        // System.out.println(str);
    
        // // build a JSON object
        // //JSONObject obj = new JSONObject(str);
        // //if (! obj.getString("status").equals("OK"))
        // //    return;*/