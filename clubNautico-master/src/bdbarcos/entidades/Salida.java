/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdbarcos.entidades;

/**
 *
 * @author copad
 */
public class Salida {
    
    int idSalida;
    
    String horaSalida;
    String direccion;
    
    int idBarco;
    String nombreBarco;

    public Salida(){
        
    }

    public Salida(int idSalida, String horaSalida, String direccion, int idBarco, String nombreBarco) {
        this.idSalida = idSalida;
        
        this.horaSalida = horaSalida;
        this.direccion = direccion;
        this.idBarco = idBarco;
        this.nombreBarco = nombreBarco;
    }

    public int getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(int idSalida) {
        this.idSalida = idSalida;
    }

    public int getIdBarco() {
        return idBarco;
    }

    public void setIdBarco(int idBarco) {
        this.idBarco = idBarco;
    }

    public String getNombreBarco() {
        return nombreBarco;
    }

    public void setNombreBarco(String nombreBarco) {
        this.nombreBarco = nombreBarco;
    }
    

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
