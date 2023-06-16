package org.example.datos;
import java.sql.Connection;
import java.sql.DriverManager;
import org.sqlite.JDBC;

public class ConexionDB {
    private String baseDatos;
    private static ConexionDB _instance;
    private Connection connection;

    private ConexionDB(String dataBase){
        this.baseDatos = dataBase;
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:"+this.baseDatos);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static ConexionDB getInstance(String baseDatos){
        if(_instance == null){
            _instance = new ConexionDB(baseDatos);
        }else{
            System.out.println("Fue creada");
        }
        return _instance;
    }
    public Connection getConnection(){
        return connection;
    }

}