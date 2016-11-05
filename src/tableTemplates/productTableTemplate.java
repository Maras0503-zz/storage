/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableTemplates;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marek
 */
public class productTableTemplate extends DefaultTableModel{
  
    @Override
    public int getColumnCount() {
        return 9;
    }

    String headers[] = new String[] { "ID", "NAZWA", "NETTO", "BRUTTO", "JEDN.", "VAT", "ILOŚĆ", "SUMA NETTO", "SUMA BRUTTO" };
       
    @Override
    public String getColumnName(int column) {
        return headers[column];
    }
        
    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }
    
}
