/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_bodega;

import java.sql.ResultSet;
import javax.swing.JOptionPane;


/**
 *
 * @author Luiz
 */
public class Modificaciones extends javax.swing.JFrame {

    /**
     * Creates new form Modificaciones
     */
    public Pantalla p;
    public Modificaciones() {
        initComponents();
    }
    String ID_prodcuto_selected;
    ResultSet res;
    public void insertar_datos(String nombre,int index,String marca,double peso,double precio){
        
        res=Conexion.Conexion.Consulta("Select IDProducto From productos where nombre=" +"'"+nombre+"'" );
        
        
        
        try {
            if (res.next()) {
                ID_prodcuto_selected=res.getString(1);
            }
        } catch (Exception e) {    
        }
        Md_Nombre_producto.setText(nombre);
        Md_Tipo.setSelectedIndex(index);
        Md_Marca.setText(marca);
        Md_Peso.setValue((double)peso);
        Md_Precio.setValue(precio);
    }
    public boolean isValidName(String name)
{
    String specialCharacters="!#$%&'*+,-./:;<=>?@[]^_`{|}~0123456789";
    String str2[]=name.split("");
    int count=0;
    for (int i=0;i<str2.length;i++)
    {
        if (specialCharacters.contains(str2[i]))
        {
            count++;
        }
    }       

    if (name!=null && count==0 )
    {
        return true;
    }
    else
    {
        return false;
        
    }
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
        btn_Actualizar = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Md_Nombre_producto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Md_Tipo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        Md_Marca = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Md_Peso = new javax.swing.JSpinner();
        Md_Precio = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();

        setAlwaysOnTop(true);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("base-de-datos.png")).getImage());
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        btn_Actualizar.setText("Actualizar");
        btn_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ActualizarActionPerformed(evt);
            }
        });

        btn_Cancelar.setText("Cancelar");
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre Producto");

        jLabel3.setText("Tipo Producto");

        Md_Tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE UNA OPCION...", "MOLIDO", "PACA", "GRANO", "ENLATADO", "ENBOTELLADO", "ENPAQUETADO", "FIERRO NUEVO" }));

        jLabel4.setText("Marca Producto");

        jLabel5.setText("Cantidad");

        jLabel6.setText("Precio");

        Md_Peso.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        Md_Precio.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(Md_Marca)
                        .addComponent(Md_Nombre_producto, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Md_Tipo, javax.swing.GroupLayout.Alignment.LEADING, 0, 215, Short.MAX_VALUE)
                        .addComponent(Md_Peso)
                        .addComponent(Md_Precio))
                    .addComponent(btn_Cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Md_Nombre_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Md_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Md_Marca, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Md_Peso, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Md_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Actualizar)
                    .addComponent(btn_Cancelar))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 51));
        jLabel1.setText("Modificaciones");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btn_CancelarActionPerformed
    
    
    private void btn_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ActualizarActionPerformed
        // TODO add your handling code here:
        boolean val=true;
        if (!isValidName(Md_Nombre_producto.getText())) {
            val=false;
        }
        if (!isValidName(Md_Marca.getText())) {
            val=false;
        }
        
        
        if (val) {
            if (Md_Nombre_producto.getText().equals("") || Md_Tipo.getSelectedIndex()==0 || Md_Marca.getText().equals("") || Md_Peso.getValue().equals(0) || Md_Precio.getValue().equals(0)) {
             JOptionPane.showMessageDialog(this,"Campo invalido o vacia","Error",JOptionPane.WARNING_MESSAGE);
        }else{
            try {
               this.setVisible(false);
               Conexion.Conexion.Ejecutar("BEGIN; \n update productos SET Nombre="+"'"+Md_Nombre_producto.getText().toUpperCase() +"'"+ "," +
                               "tipo="+"'"+Md_Tipo.getSelectedItem().toString()+"'"+","+
                               "marca="+"'"+ Md_Marca.getText().toUpperCase() +"'"+","+
                               "peso="+ Md_Peso.getValue()+","+"precio="+Md_Precio.getValue()+" where IDProducto ='"+ID_prodcuto_selected+"'; \n COMMIT;");
            
            } catch (Exception e) {
                //JOptionPane.showMessageDialog(this,"Nombres de productos ya existe en la base de datos","Error",JOptionPane.WARNING_MESSAGE);
            }
        }
        }else{
            JOptionPane.showMessageDialog(this,"Campo invalido o vacia","Error",JOptionPane.WARNING_MESSAGE);
    
        }
       p.actualizar_tabla();
    }//GEN-LAST:event_btn_ActualizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Modificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modificaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Md_Marca;
    private javax.swing.JTextField Md_Nombre_producto;
    private javax.swing.JSpinner Md_Peso;
    private javax.swing.JSpinner Md_Precio;
    private javax.swing.JComboBox<String> Md_Tipo;
    private javax.swing.JButton btn_Actualizar;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
