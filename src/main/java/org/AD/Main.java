package org.AD;


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
            BufferedReader lectura = new BufferedReader (new InputStreamReader(conexion.getInputStream()));
//            System.out.println(lectura.readLine());//Comprobar que lee correctamente el JSON
        } catch (IOException e) {
            System.out.println("Error enb la conexion I/O");
        }
    }


}
