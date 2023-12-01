package org.AD;


import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {

        try {

            URL url = new URL("https://dummyjson.com/products");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer();
            String linea = null;
            //Comprobacion de lectura correcta del JSON
            while ((linea = reader.readLine()) != null) {
                stringBuffer.append(linea);
            }

            JSONObject response = new JSONObject(stringBuffer.toString());
            JSONArray products = response.getJSONArray("products");

            //Lectura de todos los objetos del JSON en funcion de su clave. En este caso "title"

            for (int i = 0; i < products.length(); i++) {

                JSONObject producto = products.getJSONObject(i);
                int id = producto.getInt("id");
                String model = producto.getString("title");
                System.out.println("Modelo: " + model + "- Id: " + id);

            }


        } catch (IOException e) {
            System.out.println("Error enb la conexion I/O");
        }
    }


}
