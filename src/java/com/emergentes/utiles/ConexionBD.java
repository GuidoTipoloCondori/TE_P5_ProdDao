package com.emergentes.utiles;

import java.sql.*;


public class ConexionBD {
  
    static String url = "jdbc:mysql://localhost:3306/db_almacen";
    static String usuario = "root";
    static String password = "";
    
        protected Connection conn = null;
    
    public ConexionBD(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, password);
            if (conn != null){
                System.out.println("Conexion OK "+ conn);
            }
        } catch (SQLException ex) {
            System.out.println("Error al conectar "+ ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en driver "+ ex.getMessage());
        }
    }
    
    public Connection conectar(){
        return conn;
    }
    
    public void desconectar(){
        System.out.println("Cerrando la BD " + conn);
        
        try {
            conn.close();
        } catch (SQLException ex) {
             System.out.println("Error en descinectar "+ ex.getMessage());
        }
    }
    
    
}
