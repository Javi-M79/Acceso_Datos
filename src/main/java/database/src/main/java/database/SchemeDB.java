package database;

public interface SchemeDB {


    String DATABASENAME = "almacen";
    String HOST = "localhost:3306";
    String TABLE_PRODUCTS = "productos";
    String COL_ID_PRODUCTS = "Id_Producto";
    String COL_NAME_PRODUCTS = "Nombre_Producto";
    String COL_DESCRIPTION_PRODUCTS = "Descripcion_Producto";
    String COL_STOCK_PRODUCTS = "Stock";
    String COL_PRICE_PRODUCTS = "Precio_Producto";
    String TABLE_EMPLOYEES = "empleados";

    String COL_ID_EMPLOYEE = "Id_Empleado";
    String COL_NAME_EMPLOYEE = "Nombre_Empleado";
    String COL_SURNAME_EMPLOYEE = "Apellido";
    String COL_MAIL_EMPLOYEE = "Correo";

    String TABLE_ORDERS = "pedidos";
    String COL_ID_ORDERS = "Id_Pedido";
    String COL_PRICE_ORDERS = "Precio_Total";
    String COL_PRICE_ORDER = "Precio_pedido";

    String TABLE_FAV = "favoritos";
    String COL_ID_FAV = "Id_Fav";


}
