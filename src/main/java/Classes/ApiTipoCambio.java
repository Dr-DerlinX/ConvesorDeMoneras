package Classes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import static javax.management.Query.value;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApiTipoCambio {
    
    private static final String API_URL = "https://api.currencyapi.com/v3/latest?apikey=cur_live_rHJFaDOwDrwIsT6ZFuFpNUEE2nupY1NOxB1onIWS";
    
    static ArrayList<TipoCambio> tipoList = new ArrayList<>();
   
    public static ArrayList<TipoCambio> obtenerCambios(){

        try {
            
            URL url = new URL(API_URL);
            
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            
            while ((line = reader.readLine()) != null) {                
            
                response.append(line);
                
            }
            
            reader.close();
            
            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONObject rate = jsonResponse.getJSONObject("data");
            
            JSONArray keys = rate.names();
            
            for (int i = 0; i < keys.length(); i++) {
                
                String currencyCode = keys.getString(i);
                
                tipoList.add(new TipoCambio(currencyCode));
                
                
            }
            
        } catch (Exception e) {
            
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
        
        return tipoList;
    }
    
     public ArrayList<TipoCambio> obtenerTiposDivisa() {
        return tipoList;
    }
    
}
