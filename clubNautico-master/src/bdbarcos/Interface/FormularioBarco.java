/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdbarcos.Interface;

import bdbarcos.ConexionBaseDatos;
import bdbarcos.crud.CrudBarco;
import bdbarcos.crud.CrudSocio;
import bdbarcos.entidades.Barco;
import bdbarcos.entidades.Socio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author copad
 */
public class FormularioBarco extends javax.swing.JFrame {
    private ArrayList<Barco> datosDB=new ArrayList();
    private int socioID;
    private String socioNombre;
    private CrudBarco opCrud=new CrudBarco();
    /**
     * Creates new form FormularioBarco
     */
    public FormularioBarco() {
        initComponents();
        actualizarTabla();
        rellenarComboBox();
        TexId.setEditable(false);
    }
     public void actualizarTabla(){
        DefaultTableModel modelo=new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("matricula");
        modelo.addColumn("nombre");
        modelo.addColumn("amarre");
        modelo.addColumn("cuota");
        modelo.addColumn("socioID");
        modelo.addColumn("socioNombre");
        
        TablaBarcos.setModel(modelo);
        
        String datos[] =new String[7];
        
        ResultSet resultSet;
        Statement statement;
        
        try {
            ConexionBaseDatos cn=new ConexionBaseDatos();
            statement=cn.getConexionBaseDatos().createStatement();
                resultSet=statement.executeQuery("SELECT * FROM cubnautico.barco;");
            while(resultSet.next()){
                
                Barco barco=new Barco();
                
                barco.setId(resultSet.getInt(1));
                barco.setMatricula(resultSet.getString(2));
                barco.setNombre(resultSet.getString(3));
                barco.setNumeroAmarre(resultSet.getInt(4));
                barco.setCuota(resultSet.getFloat(5));
                barco.setIdSocio(resultSet.getInt(6));
                barco.setNombreSocio(resultSet.getString(7));
                
                datos[0]=String.valueOf(barco.getId());
                datos[1]=String.valueOf(barco.getMatricula());
                datos[2]=String.valueOf(barco.getNombre());
                datos[3]=String.valueOf(barco.getNumeroAmarre());
                datos[4]=String.valueOf(barco.getCuota());
                datos[5]=String.valueOf(barco.getIdSocio());
                datos[6]=String.valueOf(barco.getNombreSocio());
                
                datosDB.add(barco);
                modelo.addRow(datos);
            }
            TablaBarcos.setModel(modelo);
        } catch (SQLException e) {
            System.out.println("error "+e.getMessage());
        }
    
    }

     public void rellenarComboBox(){
         ConexionBaseDatos conexion=new ConexionBaseDatos();
        Statement statement;
        ResultSet resulset;
        ComboBoxSocio.removeAllItems();
        try {
            statement=conexion.getConexionBaseDatos().createStatement();
            resulset=statement.executeQuery("SELECT * FROM socio");
            ComboBoxSocio.addItem("Nuevo elemento");
            while(resulset.next()){
               ComboBoxSocio.addItem(resulset.getInt("idsocio")+" "+resulset.getString("nombre")); 
            }
        } catch (Exception e) {
            System.out.println("error"+" "+e);
        }
     }
    
     public void rellenarComboxBusquedaID(int idSocio){
         ConexionBaseDatos con=new ConexionBaseDatos();
        Connection co=con.getConexionBaseDatos();
        
        ComboBoxSocio.removeAllItems();
        try {
            
            PreparedStatement pps=co.prepareStatement("SELECT * FROM socio where idsocio=?;");
            pps.setInt(1, idSocio);
            
            pps.executeQuery();
            
            while(pps.getResultSet().next()){
               ComboBoxSocio.addItem(pps.getResultSet().getInt("idsocio")+" "+pps.getResultSet().getString("nombre")); 
            }
        } catch (Exception e) {
            System.out.println("error"+" "+e);
        }
     }
     public void obtenerDatosComboBox(){

         String cadena = ComboBoxSocio.getSelectedItem().toString();
         String[] separarnumero = cadena.split(" ");
         int numero = Integer.parseInt(separarnumero[0]);
         String nombre=separarnumero[1];
         
         this.socioID=numero;
         this.socioNombre=nombre;
         
     }
     
     public void limpiar(){
        
         TexId.setText("");
        TextMatricula.setText("");
        TextNombre.setText("");
        TextAmarre.setText("");
        TextCuota.setText("");
        rellenarComboBox();
        
     }
     /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaBarcos = new javax.swing.JTable();
        TexId = new javax.swing.JTextField();
        TextNombre = new javax.swing.JTextField();
        TextCuota = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Busqueda = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        botonGuardar = new javax.swing.JToggleButton();
        botonCancelar = new javax.swing.JToggleButton();
        botonBuscar = new javax.swing.JToggleButton();
        ComboBoxSocio = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        TextMatricula = new javax.swing.JTextField();
        TextAmarre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        botonBuscar1 = new javax.swing.JToggleButton();
        botonBorrar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        TablaBarcos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaBarcos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaBarcosMouseClicked(evt);
            }
        });
        TablaBarcos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TablaBarcosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(TablaBarcos);

        TexId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TexIdActionPerformed(evt);
            }
        });

        jLabel2.setText("ID cliente");

        jLabel1.setText("Matricula");

        jLabel3.setText("Nombre");

        jLabel4.setText("cuota");

        jLabel5.setText("Buscar");

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        botonBuscar.setText("editar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        jLabel6.setText("socio");

        jLabel7.setText("Amarre");

        botonBuscar1.setText("Buscar");
        botonBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscar1ActionPerformed(evt);
            }
        });

        botonBorrar.setText("borrar");
        botonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(botonGuardar))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(84, 84, 84)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ComboBoxSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TextCuota, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(TexId, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(botonCancelar, javax.swing.GroupLayout.Alignment.TRAILING))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TextAmarre, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(TextMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel6)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(Busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonBuscar1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonBuscar)
                    .addComponent(botonBorrar))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar1)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(TexId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(TextMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextAmarre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextCuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(ComboBoxSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(149, 149, 149)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonGuardar)
                            .addComponent(botonCancelar))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botonBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(botonBorrar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TexIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TexIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TexIdActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        obtenerDatosComboBox();
        
        String matricula = TextMatricula.getText();
        String nombre = TextNombre.getText();
        int amarre = Integer.parseInt(TextAmarre.getText());
        float cuota = Float.valueOf(TextCuota.getText());
        int idSocio=this.socioID;
        String nombreSocio=this.socioNombre;

        
        Barco B = new Barco(0, matricula, nombre, amarre, cuota,idSocio,nombreSocio);
        
        
        opCrud.socioIncertar(B);
        actualizarTabla();
        limpiar();
        
        
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void TablaBarcosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TablaBarcosKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_TablaBarcosKeyPressed

    private void TablaBarcosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaBarcosMouseClicked
        
        int seleccion=TablaBarcos.rowAtPoint(evt.getPoint());
        TexId.setText(String.valueOf(TablaBarcos.getValueAt(seleccion,0 )));
        TextMatricula.setText(String.valueOf(TablaBarcos.getValueAt(seleccion,1 )));
        TextNombre.setText(String.valueOf(TablaBarcos.getValueAt(seleccion,2 )));
        TextAmarre.setText(String.valueOf(TablaBarcos.getValueAt(seleccion,3 )));
        TextCuota.setText(String.valueOf(TablaBarcos.getValueAt(seleccion,4 )));
        
        String socio=String.valueOf(TablaBarcos.getValueAt(seleccion, 5));
        int idSocio=Integer.parseInt(socio);
        
        rellenarComboxBusquedaID(idSocio);
        
        
        
        
    }//GEN-LAST:event_TablaBarcosMouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        limpiar();
        actualizarTabla();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        int id=Integer.valueOf(TexId.getText());
        String matricula=TextMatricula.getText();
        String nombre=TextNombre.getText();
        int amarre=Integer.parseInt(TextAmarre.getText());
        float cuota=Float.parseFloat(TextCuota.getText());
        
        obtenerDatosComboBox();
        
        int idSocio=this.socioID;
        String nombreSocio=this.socioNombre;
        
        Barco B=new Barco(id, matricula,nombre,amarre,cuota, idSocio,nombreSocio);
        
        opCrud.actualizar(B);
        actualizarTabla();
        limpiar();
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed
        int idBarco=Integer.parseInt(TexId.getText());
        
        opCrud.eliminar(idBarco);
        
        limpiar();
        actualizarTabla();
   
    }//GEN-LAST:event_botonBorrarActionPerformed

    private void botonBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscar1ActionPerformed
        DefaultTableModel modelo=new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("matricula");
        modelo.addColumn("nombre");
        modelo.addColumn("amarre");
        modelo.addColumn("cuota");
        modelo.addColumn("socioID");
        modelo.addColumn("socioNombre");
        
        TablaBarcos.setModel(modelo);
        
        String datos[] =new String[7];
        
        int idBarco=Integer.parseInt(Busqueda.getText());
        
        
        
        try {
            ConexionBaseDatos con = new ConexionBaseDatos();
            Connection co = con.getConexionBaseDatos();
            
            PreparedStatement pps=co.prepareStatement("SELECT * FROM cubnautico.barco where id=?;");
            
            pps.setInt(1, idBarco);
            
            pps.executeQuery();
            while(pps.getResultSet().next()){
                
                Barco barco=new Barco();
                
                barco.setId(pps.getResultSet().getInt(1));
                barco.setMatricula(pps.getResultSet().getString(2));
                barco.setNombre(pps.getResultSet().getString(3));
                barco.setNumeroAmarre(pps.getResultSet().getInt(4));
                barco.setCuota(pps.getResultSet().getFloat(5));
                barco.setIdSocio(pps.getResultSet().getInt(6));
                barco.setNombreSocio(pps.getResultSet().getString(7));
                
                datos[0]=String.valueOf(barco.getId());
                datos[1]=String.valueOf(barco.getMatricula());
                datos[2]=String.valueOf(barco.getNombre());
                datos[3]=String.valueOf(barco.getNumeroAmarre());
                datos[4]=String.valueOf(barco.getCuota());
                datos[5]=String.valueOf(barco.getIdSocio());
                datos[6]=String.valueOf(barco.getNombreSocio());
                
                modelo.addRow(datos);
            }
            TablaBarcos.setModel(modelo);
            con.getConexionBaseDatos().close();
        } catch (SQLException e) {
            System.out.println("error "+e.getMessage());
        }
        
    }//GEN-LAST:event_botonBuscar1ActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Busqueda;
    private javax.swing.JComboBox ComboBoxSocio;
    private javax.swing.JTable TablaBarcos;
    private javax.swing.JTextField TexId;
    private javax.swing.JTextField TextAmarre;
    private javax.swing.JTextField TextCuota;
    private javax.swing.JTextField TextMatricula;
    private javax.swing.JTextField TextNombre;
    private javax.swing.JToggleButton botonBorrar;
    private javax.swing.JToggleButton botonBuscar;
    private javax.swing.JToggleButton botonBuscar1;
    private javax.swing.JToggleButton botonCancelar;
    private javax.swing.JToggleButton botonGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}


