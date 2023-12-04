import Employees.Employees;
import database.GestionDB;
import database.SchemeDB;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Connection connection = GestionDB.getConnection();
        System.out.println("Conexion a la base de datos establecida con exito");
        ArrayList<Employees> employees = new ArrayList<Employees>();
        Employees employee1 = new Employees("Javier", "Mira", "jmira@abc.es");
        Employees employee2 = new Employees("Pepe", "Perez", "pepe@abc.es");
        Employees employee3 = new Employees("Tomas", "Martin", "tomas@abc.es");
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

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
/*
            JSONObject response = new JSONObject(stringBuffer.toString());
            JSONArray products = response.getJSONArray("products");


            for (int i = 0; i < products.length(); i++) {

                JSONObject producto = products.getJSONObject(i);
                int id = producto.getInt("id");
                String model = producto.getString("title");
                System.out.println("- Id: " + id + "Modelo: " + model);
            }


                System.out.println("Contenido del objeto JSON: " + producto.toString());//Comprobamos que el objeto JSON estan ok.

                AÑADIR DATOS A LA TABLA PRODUCTOS

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

                */


            //AÑADIR DATOS A LA TABLA EMPLEADOS

            //Convertimos los objetos de la clase Employees en JSONObject los guardamos en un JSONArray

            JSONObject employeeJSON = new JSONObject();
            JSONArray employeesArray = new JSONArray();

            for (Employees e : employees
            ) {
                JSONObject em_json = e.getAsJSON();
                e.getAsJSON();
                employeesArray.put(em_json);
            }

            //AÑADIMOS EL ARRAY AL OBJETO JSON CON SU PAR CLAVE VALOR.

            employeeJSON.put("employees", employeesArray);

            //CREAMOS EL ARCHIVO JSON

            FileWriter file = new FileWriter("employees.json");
            file.write(employeeJSON.toString());
            file.close();

            //LO LEEMOS PARA COMPROBAR QUE ESTA CORRECTO.

            reader = new BufferedReader(new FileReader("employees.json"));
            String texto = "";
            linea = reader.readLine();
            while (linea != null) {
                texto = texto = linea + "\n";
                linea = reader.readLine();
            }

            System.out.println(texto);


            //LOS AÑADIMOS A LA BB.DD.


//                preparedStatement = connection.prepareStatement((String.format("INSERT INTO %s(%s,%s,%s,%s) VALUE (?,?,?,?)", SchemeDB.TABLE_EMPLOYEES,
//                        SchemeDB.COL_ID_EMPLOYEE,
//                        SchemeDB.COL_NAME_EMPLOYEE,
//                        SchemeDB.COL_SURNAME_EMPLOYEE,
//                        SchemeDB.COL_MAIL_EMPLOYEE
//
//
////                )));
//                preparedStatement.setInt(1, producto.getInt("id"));
//                preparedStatement.setString(2, producto.getString("nombre"));
//                preparedStatement.setString(3, producto.getString("Apellido"));
//                preparedStatement.setInt(4, producto.getInt("Correo"));
//
//                rowsAffected = preparedStatement.executeUpdate();


            reader.close();


        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }


    }

}






