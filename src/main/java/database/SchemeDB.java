package database;

public interface SchemeDB {


    String DATABASENAME = "Almacen";
    String HOST = "localhost:3306";
    String TABLE_PRODUCTS = "Productos";
    String COL_ID_PRODUCTS = "Id_producto";
    String COL_NAME_PRODUCTS = "Nombre_Producto";
    String COL_DESCRIPTION_PRODUCTS = "Descripcion_producto";
    String COL_STOCK_PRODUCTS = "Cantidad";
    String COL_PRICE_PRODUCTS = "Precio";
    String TABLE_EMPLOYEES = "Precio";

    String COL_ID_EMPLOYEE = "Id_Empleado";
    String COL_NAME_EMPLOYEE = "Id_Empleado";
    String COL_SURNAME_EMPLOYEE = "Id_Empleado";
    String COL_MAIL_EMPLOYEE = "Id_Empleado";

    String TABLE_ORDERS = "Pedidos";
    String COL_ID_ORDERS = "Id_Pedido";
    String COL_PRICE_ORDERS = "Precio_Total";

    String TABLE_FAV = "Productos_Fav";
    String COL_ID_FAV = "Id_Fav";


}
