/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_bodega;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Luiz
 */
public class Pedidos extends javax.swing.JFrame {

    /**
     * Creates new form Tabla_maestra
     */
    Tabla t = new Tabla();
    public Pantalla p;
    public Pedidos() {
        initComponents();
    }
    public void actualizarT(){
        t.ver_tabla_pedidos(tabla_vista);

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
        tabla_vista = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setIconImage(new javax.swing.ImageIcon(getClass().getResource("base-de-datos.png")).getImage());
        setResizable(false);

        jPanel1.setBackground(java.awt.SystemColor.activeCaption);

        tabla_vista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto pedido", "Cantidad", "Calle", "numero Domicilio", "Telefono cliente", "completado", "Cancelar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_vista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_vistaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_vista);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Pedidos Pendientes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    
    int click_tabla;
    private void tabla_vistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_vistaMouseClicked
        // TODO add your handling code here:
        click_tabla = this.tabla_vista.rowAtPoint(evt.getPoint());
        
        String NombreProducto = ""+tabla_vista.getValueAt(click_tabla, 0);
        System.out.println(NombreProducto);
        int Cantidad = (int)tabla_vista.getValueAt(click_tabla, 1);
        String Calle = ""+tabla_vista.getValueAt(click_tabla, 2);
        String Numdomicilio= ""+tabla_vista.getValueAt(click_tabla, 3);
        String Telefono = ""+tabla_vista.getValueAt(click_tabla, 4);
        int x=0;
        int column = tabla_vista.getColumnModel().getColumnIndexAtX(evt.getX());
        int Row = evt.getY()/tabla_vista.getRowHeight();
        
        if (Row<tabla_vista.getRowCount() && Row>=0 & column<tabla_vista.getColumnCount() && column>=0) {
            Object value = tabla_vista.getValueAt(Row, column);
            if (value instanceof  JButton) {
                ((JButton)value).doClick();
                JButton button = (JButton) value;
                
                if (button.getName().equals("Co")) {
                     int n = JOptionPane.showConfirmDialog(  
                    null,
                    "Seguro que se completo el pedido?! ",
                    "",
                    JOptionPane.YES_NO_OPTION);
                    
                    if(n == JOptionPane.YES_OPTION)
                    {
                        Conexion.Conexion.Ejecutar("execute PedidoEntregado '"+ NombreProducto+"',"+Cantidad+",'"+Calle+"','"+Numdomicilio+"','"+Telefono+"','','';");
                        //Conexion.Conexion.Ejecutar(
                        //"insert into pedidoscompletos(nombreProducto,cantidad,calle,numero_Domicilio,numero_tele) values ('"+
                                //NombreProducto+"',"+Cantidad+",'"+Calle+"','"+Numdomicilio+"','"+Telefono+"');");
                       
                        p.actualizar_tabla();
                        actualizarT();
                        //JOptionPane.showMessageDialog(null, "registro Eliminado");
                    }
                   
                }
                //execute CompletarPedido 'paca alfalfa',20,'carretera','rancho alamito 5','494','','';
                if (button.getName().equals("Ca")) {
                   int n = JOptionPane.showConfirmDialog(  
                    null,
                    "Seguro que se quieres cancelar pedido? ",
                    "",
                    JOptionPane.YES_NO_OPTION);
                    
                    if(n == JOptionPane.YES_OPTION)
                    {
                        Conexion.Conexion.Ejecutar("execute CompletarPedido '"+ NombreProducto+"',"+Cantidad+",'"+Calle+"','"+Numdomicilio+"','"+Telefono+"','','';");
                        actualizarT();
                        //JOptionPane.showMessageDialog(null, "registro Eliminado");
                    }
                    
                } 
              
        }
    }                        
    }//GEN-LAST:event_tabla_vistaMouseClicked

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tabla_maestra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tabla_maestra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tabla_maestra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tabla_maestra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tabla_maestra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_vista;
    // End of variables declaration//GEN-END:variables
}
