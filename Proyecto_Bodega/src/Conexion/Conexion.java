/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

/**
 *
 * @author Luizenrique
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import proyecto_bodega.Pantalla;
public class Conexion {
    public static Connection con=null;
    public static Connection getConnection(){
        //DESKTOP-DMHSAF3 laptop
    String url = "jdbc:sqlserver://DESKTOP-DDNUBG6:1433;databaseName=Bodega";
        try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,"No se puede establecer conexion.. revisa drivers" + e.getMessage(),
                    "error de conexion",JOptionPane.ERROR_MESSAGE);
        }
    
        try {
            con = DriverManager.getConnection(url,"Luiz","12345");
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null,"ERROR" + e.getMessage(),
                    "error de conexion",JOptionPane.ERROR_MESSAGE);
        }
    return con;
    }
    
    public static ResultSet Consulta(String consulta){
    Connection con = getConnection();
    Statement declara;
        try {
            declara=con.createStatement();
            ResultSet respuesta = declara.executeQuery(consulta);
            return respuesta;
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null,"ERROR" + e.getMessage(),
                    "error de conexion",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    public static void Ejecutar(String consulta){
    Connection con = getConnection();
    Statement declara;
        try {
            declara=con.createStatement();
            declara.executeQuery(consulta);
            
        } catch (SQLException e) {
            if (e.getMessage().equals("La instrucción no devolvió un conjunto de resultados.")) {
                JOptionPane.showMessageDialog(null,
                    "Se actualizo el base de datos correctamente");
               
            }else{
            JOptionPane.showMessageDialog(null,"Producto con ese nombre ya existe " ,
                    "ERROR",JOptionPane.ERROR_MESSAGE);
                    //System.out.println(e);
            }
             
        }
        
    }
        public static void Eliminar_Producto(String consulta){
    Connection con = getConnection();
    Statement declara;
        try {
            declara=con.createStatement();
            declara.executeQuery(consulta);
            
        } catch (SQLException e) {
            if (e.getMessage().equals("La instrucción no devolvió un conjunto de resultados.")) {
                JOptionPane.showMessageDialog(null,
                    "Se actualizo el base de datos correctamente");
               
            }else{
            JOptionPane.showMessageDialog(null,"Producto siendo usado en pedidos" ,
                    "ERROR",JOptionPane.ERROR_MESSAGE);
                    //System.out.println(e);
            }
             
        }
        
    }
    
}
