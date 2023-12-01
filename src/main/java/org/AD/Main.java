package org.AD;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {

        try {

            URL url = new URL("https://dummyjson.com/products");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            System.out.println("Error enb la conexion I/O");
        }
    }


}
