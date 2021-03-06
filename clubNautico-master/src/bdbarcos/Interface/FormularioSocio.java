/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdbarcos.Interface;

import bdbarcos.ConexionBaseDatos;
import bdbarcos.entidades.Socio;
import bdbarcos.crud.CrudSocio;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author copad
 */
public class FormularioSocio extends javax.swing.JFrame {
     private ArrayList<Socio> datosDB=new ArrayList();
     private CrudSocio opCrud=new CrudSocio();
    /**
     * Creates new form FormularioCliente
     */
    public FormularioSocio() {
        initComponents();
        actualizarTabla();
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
        TablaClientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TexIdCliente = new javax.swing.JTextField();
        TexTelefonoSocio = new javax.swing.JTextField();
        TexDireccionSocio = new javax.swing.JTextField();
        TexNombreSocio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Busqueda = new javax.swing.JTextField();
        BotonGuardar = new javax.swing.JToggleButton();
        actualizar = new javax.swing.JToggleButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel6 = new javax.swing.JLabel();
        jTextCorreo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaClientes);

        jLabel1.setText("Nombre");

        jLabel2.setText("ID cliente");

        jLabel3.setText("Telefono");

        jLabel4.setText("Direccion");

        TexIdCliente.setEditable(false);
        TexIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TexIdClienteActionPerformed(evt);
            }
        });

        jLabel5.setText("Buscar ID");

        BotonGuardar.setText("guardar");
        BotonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarActionPerformed(evt);
            }
        });

        actualizar.setText("actualizar");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });

        jToggleButton1.setText("buscar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("correo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(BotonGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(actualizar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel3))
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel6))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TexDireccionSocio)
                            .addComponent(TexIdCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TexTelefonoSocio)
                            .addComponent(TexNombreSocio, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(Busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TexIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TexNombreSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TexTelefonoSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TexDireccionSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BotonGuardar)
                            .addComponent(actualizar))
                        .addGap(32, 32, 32))))
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

    private void TexIdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TexIdClienteActionPerformed
        
    }//GEN-LAST:event_TexIdClienteActionPerformed

    private void BotonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarActionPerformed

//        String nombre=TexNombreSocio.getText();
//        String telefono=TexTelefonoSocio.getText();
//        String direccio=TexDireccionSocio.getText();
//        Socio socio=new Socio();
//
//        socio.setNombre(nombre);
//        socio.setDireccion(direccio);
//        socio.setTelefono(telefono);
//        
//        
//        opCrud.cliente(socio);
//        actualizarTabla();
//        limpiar();

        
        String nombre=TexNombreSocio.getText();
        String telefono=TexTelefonoSocio.getText();
        String direccio=TexDireccionSocio.getText();
        String correo=jTextCorreo.getText();
        
        Socio s=new Socio(0, nombre,direccio,correo, telefono );
        
        opCrud.socioIncertar(s);
        actualizarTabla();
        limpiar();
        
    }//GEN-LAST:event_BotonGuardarActionPerformed

    public void actualizarTabla(){
         DefaultTableModel modelo=new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("nombre");
        modelo.addColumn("direccion");
        modelo.addColumn("correo");
        modelo.addColumn("telefono");
        TablaClientes.setModel(modelo);
        
        
        String datos[] =new String[5];
        
       
        
        ResultSet resultSet;
        Statement statement;
        
        try {
            ConexionBaseDatos cn=new ConexionBaseDatos();
            statement=cn.getConexionBaseDatos().createStatement();
                resultSet=statement.executeQuery("SELECT * FROM cubnautico.socio;");
            while(resultSet.next()){
                Socio socio=new Socio();
                socio.setId(resultSet.getInt(1));
                socio.setNombre(resultSet.getString(2));
                socio.setDireccion(resultSet.getString(3));
                socio.setCorreo(resultSet.getString(4));
                socio.setTelefono(resultSet.getString(5));
                
                datos[0]=String.valueOf(socio.getId());
                datos[1]=String.valueOf(socio.getNombre());
                datos[2]=String.valueOf(socio.getDireccion());
                datos[3]=String.valueOf(socio.getCorreo());
                datos[4]=String.valueOf(socio.getTelefono());
                
                datosDB.add(socio);
                modelo.addRow(datos);
            }
            TablaClientes.setModel(modelo);
        } catch (SQLException e) {
            System.out.println(e.getCause());
        }
    
    }
    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        int idSocio=Integer.valueOf(TexIdCliente.getText());
        String nombre=TexNombreSocio.getText();
        String telefono=TexTelefonoSocio.getText();
        String direccio=TexDireccionSocio.getText();
        String correo=jTextCorreo.getText();
        
        Socio s=new Socio(idSocio, nombre,direccio,correo, telefono );
        
        opCrud.actualizar(s);
        actualizarTabla();
        limpiar();
    }//GEN-LAST:event_actualizarActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        String datos[]=new String[4];
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("nombre");
        modelo.addColumn("telefono");
        modelo.addColumn("direccion");
        String nombre=Busqueda.getText();
        TablaClientes.setModel(modelo);
        
        for (int i = 0; i < datosDB.size(); i++) {
            if(datosDB.get(i).getNombre().equals(nombre)){
                
            datos[0]=String.valueOf(datosDB.get(i).getId());
            datos[1]=datosDB.get(i).getNombre();
            datos[2]=datosDB.get(i).getTelefono();
            datos[3]=datosDB.get(i).getDireccion();
            modelo.addRow(datos);}
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    public void limpiar(){
        TexIdCliente.setText("");
        TexNombreSocio.setText("");
        TexTelefonoSocio.setText("");
        TexDireccionSocio.setText("");
        jTextCorreo.setText("");
        
    }
    private void TablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaClientesMouseClicked
        
        
        int seleccion=TablaClientes.rowAtPoint(evt.getPoint());
        TexIdCliente.setText(String.valueOf(TablaClientes.getValueAt(seleccion,0 )));
        TexNombreSocio.setText(String.valueOf(TablaClientes.getValueAt(seleccion,1 )));
        TexDireccionSocio.setText(String.valueOf(TablaClientes.getValueAt(seleccion,2 )));
        jTextCorreo.setText(String.valueOf(TablaClientes.getValueAt(seleccion,3 )));
        TexTelefonoSocio.setText(String.valueOf(TablaClientes.getValueAt(seleccion,4 )));
        
    }//GEN-LAST:event_TablaClientesMouseClicked

    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BotonGuardar;
    private javax.swing.JTextField Busqueda;
    private javax.swing.JTable TablaClientes;
    private javax.swing.JTextField TexDireccionSocio;
    private javax.swing.JTextField TexIdCliente;
    private javax.swing.JTextField TexNombreSocio;
    private javax.swing.JTextField TexTelefonoSocio;
    private javax.swing.JToggleButton actualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextCorreo;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
