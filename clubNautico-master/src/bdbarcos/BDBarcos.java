/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdbarcos;

import bdbarcos.Interface.Ventana;

/**
 *
 * @author copad
 */
public class BDBarcos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ventana ventana=new Ventana();
        
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("Base de datos club nautico");
            }
    
}
