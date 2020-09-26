/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdbarcos.crud;

import bdbarcos.ConexionBaseDatos;
import bdbarcos.Interface.FormularioSocio;
import bdbarcos.entidades.Barco;
import bdbarcos.entidades.Salida;
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
public class CrudSalida {

    public void socioIncertar(Salida S) {
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection co = con.getConexionBaseDatos();

        try {

            PreparedStatement pps = co.prepareStatement("insert into salida (id,horaSalida,direccion,idBarco,nombreBarco) values (?,?,?,?,?);");

            pps.setInt(1, 0);
            pps.setString(2, S.getHoraSalida());
            pps.setString(3, S.getDireccion());
            pps.setInt(4, S.getIdBarco());
            pps.setString(5, S.getNombreBarco());

//            System.out.println(B.getId()+" "+B.getMatricula()+" "+B.getNombre()+" "+B.getNumeroAmarre()+" "+B.getCuota()+" "+B.getIdSocio()+" "+B.getNombreSocio());
            pps.executeUpdate();

            con.getConexionBaseDatos().close();

        } catch (SQLException e) {
            Logger.getLogger(FormularioSocio.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void actualizar(Salida S) {
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection co = con.getConexionBaseDatos();
        ResultSet resultSet = null;
        Statement statement = null;

        try {

            PreparedStatement pps = co.prepareStatement("update salida set id=?,horaSalida=?,direccion=?,idBarco=?,nombreBarco=? where id=?;");
            pps.setInt(1, S.getIdSalida());
            pps.setString(2, S.getHoraSalida());
            pps.setString(3, S.getDireccion());
            pps.setInt(4, S.getIdBarco());
            pps.setString(5, S.getNombreBarco());

            pps.setInt(6, S.getIdSalida());

            pps.executeUpdate();

            con.getConexionBaseDatos().close();
        } catch (SQLException e) {
            Logger.getLogger(FormularioSocio.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void eliminar(int idBarco) {
        ConexionBaseDatos con = new ConexionBaseDatos();
        Connection co = con.getConexionBaseDatos();

        try {
            PreparedStatement pps = co.prepareStatement("delete from salida where id=?;");

            pps.setInt(1, idBarco);

            pps.executeUpdate();

            con.getConexionBaseDatos().close();
        } catch (Exception e) {

        }
    }
}

        
        
        
 
