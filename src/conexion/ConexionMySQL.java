package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {
  
    private static String driver = "com.mysql-jdbc.Driver";
    
    private static String database = "trasefor";
    
    private static String hostname = "127.0.0.1";
    
    private static String port = "3306";
    
    private static String username = "root";
    
    private static String password = "claudio101521";
    
    private static String connectionURL;
    
    private static Connection conn;
    
    
    public ConexionMySQL () {
        this.connectionURL = "jdbc:mysql://";
        this.connectionURL += hostname + ":" + port + "/" + database;
        this.connectionURL += "?autoReconnect=true&useSSL=false";
        this.getConnection();
    }
    public static Connection getConnection(){
        try {
            Class.forName(driver);
            try {
                conn = DriverManager.getConnection(connectionURL, username, password);
            } catch(Exception e){
               System.out.print("No se puede conectar: " +e.getMessage()); 
            }
        } catch(ClassNotFoundException ex){
            System.out.print("la clase " +driver+ "no existe en el sistema");
        }
         return conn;
    }
}
