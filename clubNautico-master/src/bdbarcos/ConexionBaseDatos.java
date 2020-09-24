/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdbarcos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author copad
 */
public class ConexionBaseDatos {
    
    private Connection conexionBaseDatos;

    public Connection getConexionBaseDatos() {
        return conexionBaseDatos;
    }

    public void setConexionBaseDatos(Connection conexionBaseDatos) {
        this.conexionBaseDatos = conexionBaseDatos;
    }
    
    
    
    public ConexionBaseDatos(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexionBaseDatos=DriverManager.getConnection("jdbc:mysql://localhost:3306/cubnautico","root","");
        } catch (Exception e) {
            System.out.println("error"+" "+e);
        }
    }
//        public static void main(String[] args) {
//        ConexionBaseDatos cn=new ConexionBaseDatos();
//        Statement statement;
//        ResultSet retulset;
//        try {
//            
//            
//            statement=cn.conexionBaseDatos.createStatement();
//            retulset=statement.executeQuery("SELECT * FROM cubnautico.socio;");
//            
//            while(retulset.next()){
//                System.out.println(retulset.getInt("idsocio")+" "+retulset.getString("nombre"));
//            }
//        } catch (Exception e) {
//            System.out.println("error "+e.getMessage());
//        }
//        
//    }
    
}
