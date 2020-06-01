/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_bodega;

import java.util.Vector;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import static proyecto_bodega.Tabla.res;

/**
 *
 * @author Luiz
 */
public class grafica {
    DefaultPieDataset data = new DefaultPieDataset();
    Vector v = new Vector();
    
        public void obtener_info(){
        res=Conexion.Conexion.Consulta("SELECT count(tipo),  tipo FROM vistaproducto GROUP BY tipo;");
        try {
            while(res.next()){
                data.setValue(res.getString(2).toString()+": "+ new Integer(res.getInt(1)), new Integer(res.getInt(1)));
            }
                
        } catch (Exception e) {
        }
       JFreeChart chart = ChartFactory.createPieChart("grafica de tipo de productos", data);
       ChartFrame frame = new ChartFrame("", chart);
       frame.pack();
       frame.setIconImage(new javax.swing.ImageIcon(getClass().getResource("base-de-datos.png")).getImage());
       frame.setSize(400,400);
       frame.setLocationRelativeTo(null);
       frame.setVisible(true);
    }
    

}
