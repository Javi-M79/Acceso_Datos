package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestionDB implements SchemeDB {

    private static String url = String.format("jdbc:mysql://%s/ %S", SchemeDB.HOST, SchemeDB.DATABASENAME);
    private static String user = "root";
    private static String password = "";


    private static void createConnection() {

        try {
            Class.forName("mysql.jdbc.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    static Connection connection;//Recordar hacerla static

    public static Connection getConnection() {

        //Creamnos la conexion si no esta creada.
        //De esta manera evitamos cuellos de botella. Si no esta creada se crea, si no, la devolvemos.
        if (connection == null) {
            createConnection();

        }
        return connection;
    }
}
