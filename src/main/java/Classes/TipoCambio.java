package Classes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.JOptionPane;
import org.json.JSONObject;

public class TipoCambio {
    
    private String nombre;
    //======================================================================
    private static String code;
    private static double valor;

    public TipoCambio() {
    }
  
    
    public TipoCambio(String nombre) {
        
        this.nombre = nombre;
        
        
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public double getValor(){
        return valor;
    }
    
    public static void setValor(double ValorString){
        TipoCambio.valor = ValorString;
    }
    
    public String getCode(){
        return code;
    }
    
    public void setCode(String CodeString){
        this.code = CodeString;
    }
    
    @Override
    public String toString(){
        return nombre;
    }
    
    
    public static double convertCurrency(String fromCurrency, String toCurrency, double amount){
        
        String apiurl = "https://api.currencyapi.com/v3/latest?apikey=cur_live_rHJFaDOwDrwIsT6ZFuFpNUEE2nupY1NOxB1onIWS&base_currency=" + fromCurrency;
        
        try {
            
            HttpsURLConnection connection = (HttpsURLConnection) new URL(apiurl).openConnection();
            connection.setRequestMethod("GET");
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder responser = new StringBuilder();
            String line;
            
            while ((line = reader.readLine()) != null) {                
                responser.append(line);
            }
            
            reader.close();
            
            JSONObject jsonResponser = new JSONObject(responser.toString());
            
            JSONObject currency = jsonResponser.getJSONObject("data");
            
            String currencyCode = currency.getJSONObject(toCurrency).getString("code");
            double currencyValue = currency.getJSONObject(toCurrency).getDouble("value");
            
            double convertAmout = amount * currencyValue;
            
            setValor(currencyValue);
            
            return convertAmout;
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "ERROR...." + 404);
            return 404;
        }
        
    }
}
