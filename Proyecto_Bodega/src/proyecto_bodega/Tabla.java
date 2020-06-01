/*,
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_bodega;

import java.awt.Component;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luiz
 */
public class Tabla{
    static ResultSet res; 
    JButton btn1 = new JButton("modificar");
   
    JButton btn2 = new JButton("eliminar");
    
    JButton btn3 = new JButton("Pedido");
    
    JButton btn4 = new JButton("Completado");
    
    JButton btn5 = new JButton("Calcelar");
    
    
    public void ver_tabla(JTable tabla,String com){
        tabla.setDefaultRenderer(Object.class, new render());
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        res=Conexion.Conexion.Consulta(com);
        btn1.setName("M");
        btn2.setName("E");
        btn3.setName("P");
        try {
            
            while(res.next()){
                Vector v = new Vector();
                v.add(res.getString(1));
                v.add(res.getString(2));
                v.add(res.getString(3));
                v.add(res.getDouble(4));
                v.add(res.getDouble(5));
                v.add(btn1);
                v.add(btn2);
                v.add(btn3);
                modelo.addRow(v);
                tabla.setModel(modelo);
            }
                
        } catch (Exception e) {
        }    
    }
    
        public void ver_tablaPCom(JTable tabla){
        tabla.setDefaultRenderer(Object.class, new render());
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        res=Conexion.Conexion.Consulta("select * from pedidoscompletos;");

        try {
            
            while(res.next()){
                Vector v = new Vector();
                v.add(res.getInt(1));
                v.add(res.getString(2));
                v.add(res.getInt(3));
                v.add(res.getString(4));
                v.add(res.getString(5));
                v.add(res.getString(6));
                modelo.addRow(v);
                tabla.setModel(modelo);
            }
                
        } catch (Exception e) {
        }    
    }
    
    
    
    
    public void ver_tabla_pedidos(JTable tabla){
        tabla.setDefaultRenderer(Object.class, new render());
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        res=Conexion.Conexion.Consulta("select * from vistapedido");
        btn4.setName("Co");
        btn5.setName("Ca");
        try {
            
            while(res.next()){
                Vector v = new Vector();
                v.add(res.getString(1));
                v.add(res.getInt(2));
                v.add(res.getString(3));
                v.add(res.getString(4));
                v.add(res.getString(5));
                v.add(btn4);
                v.add(btn5);
                modelo.addRow(v);
                tabla.setModel(modelo);
            }
                
        } catch (Exception e) {
        }    
    }
    
    public void ver_tabla_maestra(JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        res=Conexion.Conexion.Consulta("select * from productos");
        try {
            
            while(res.next()){
                Vector v = new Vector();
                v.add(res.getString(1));
                v.add(res.getInt(2));
                v.add(res.getString(3));
                v.add(res.getString(4));
                v.add(res.getString(5));
                v.add(res.getDouble(6));
                v.add(res.getDouble(7));
                modelo.addRow(v);
                tabla.setModel(modelo);
            }
                
        } catch (Exception e) {
        }

    }
    
    public void ver_tabla_maestra_pedidos(JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        res=Conexion.Conexion.Consulta("select * from pedido;");
        try {
            
            while(res.next()){
                Vector v = new Vector();
                v.add(res.getString(1));
                v.add(res.getInt(2));
                v.add(res.getString(3));
                v.add(res.getInt(4));
                v.add(res.getString(5));
                v.add(res.getString(6));
                v.add(res.getString(7));
                modelo.addRow(v);
                tabla.setModel(modelo);
            }
                
        } catch (Exception e) {
        }
    
}
    
class render extends DefaultTableCellRenderer{

    @Override
 public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        if (value instanceof JButton) {
            JButton btn = (JButton)value;
            return btn;
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
    }
}
}