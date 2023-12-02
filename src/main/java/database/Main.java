package database;


import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        Connection connection = GestionDB.getConnection();
        System.out.println("Conexion a la base de datos establecida con exito");

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

            //Lectura de todos los objetos del JSON en funcion de su clave."

            for (int i = 0; i < products.length(); i++) {

                JSONObject producto = products.getJSONObject(i);
//                int id = producto.getInt("id");
//                String model = producto.getString("title");
////                System.out.println("- Id: " + id + "Modelo: " + model);

                System.out.println("Contenido del objeto JSON: " + producto.toString());//Comprobamos que el objeto JSON estan ok.

                Statement statement = connection.createStatement();
                PreparedStatement preparedStatement = connection.prepareStatement((String.format("INSERT INTO %s(%s,%s,%s,%s,%s) VALUE (?,?,?,?,?)", SchemeDB.TABLE_PRODUCTS,
                        SchemeDB.COL_ID_PRODUCTS,
                        SchemeDB.COL_NAME_PRODUCTS,
                        SchemeDB.COL_DESCRIPTION_PRODUCTS,
                        SchemeDB.COL_STOCK_PRODUCTS,
                        SchemeDB.COL_PRICE_PRODUCTS

                )));
                preparedStatement.setInt(1, producto.getInt("id"));
                preparedStatement.setString(2, producto.getString("title"));
                preparedStatement.setString(3, producto.getString("description"));
                preparedStatement.setInt(4, producto.getInt("stock"));
                preparedStatement.setInt(5, producto.getInt("price"));
                int rowsAffected = preparedStatement.executeUpdate();


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error enb la conexion I/O");


        }

    }

}




