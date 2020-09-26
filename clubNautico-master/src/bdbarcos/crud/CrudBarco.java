/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdbarcos.crud;

import bdbarcos.ConexionBaseDatos;
import bdbarcos.Interface.FormularioSocio;
import bdbarcos.entidades.Barco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author copad
 */
public class CrudBarco {
     public void socioIncertar(Barco B) {
        ConexionBaseDatos con=new ConexionBaseDatos();
        Connection co=con.getConexionBaseDatos();

        try {
            
            
            PreparedStatement pps=co.prepareStatement("insert into barco (id,matricula,nombre,amarre,cuota,socio_idsocio,socio_nombre) values (?,?,?,?,?,?,?);");
            
            pps.setInt(1, 0);
            pps.setString(2, B.getMatricula());
            pps.setString(3, B.getNombre());
            pps.setInt(4, B.getNumeroAmarre());
            pps.setFloat(5, B.getCuota());
            pps.setInt(6, B.getIdSocio());
            pps.setString(7, B.getNombreSocio());
            
//            System.out.println(B.getId()+" "+B.getMatricula()+" "+B.getNombre()+" "+B.getNumeroAmarre()+" "+B.getCuota()+" "+B.getIdSocio()+" "+B.getNombreSocio());

            pps.executeUpdate();
            
            con.getConexionBaseDatos().close();
            
        } catch (SQLException e) {
            Logger.getLogger(FormularioSocio.class.getName()).log(Level.SEVERE, null, e);
        }
       
    }
    public void actualizar(Barco B)
    {
        ConexionBaseDatos con=new ConexionBaseDatos();
        Connection co=con.getConexionBaseDatos();
        ResultSet resultSet = null;
        Statement statement = null;

        try {
            
            
            PreparedStatement pps=co.prepareStatement("update barco set id=?,matricula=?,nombre=?,amarre=?,cuota=?,socio_idsocio=?,socio_nombre=? where id=?;");
            pps.setInt(1, B.getId());
            pps.setString(2, B.getMatricula());
            pps.setString(3, B.getNombre());
            pps.setInt(4, B.getNumeroAmarre());
            pps.setFloat(5, B.getCuota());
            pps.setInt(6, B.getId());
            pps.setString(7, B.getNombreSocio());
            
            pps.setInt(8,B.getId() );
            
            

            pps.executeUpdate();
            
            
            
            con.getConexionBaseDatos().close();
        } catch (SQLException e) {
            Logger.getLogger(FormularioSocio.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void eliminar(int idBarco){
        ConexionBaseDatos con=new ConexionBaseDatos();
        Connection co=con.getConexionBaseDatos();
        
        try {
            PreparedStatement pps=co.prepareStatement("delete from barco where id=?;");
            
            pps.setInt(1, idBarco);
            
            pps.executeUpdate();
            
            
            
            con.getConexionBaseDatos().close();
        } catch (Exception e) {
        }
        
        
    }
}
