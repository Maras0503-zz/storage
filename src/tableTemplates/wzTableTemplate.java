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
public class wzTableTemplate extends DefaultTableModel{
  
    @Override
    public int getColumnCount() {
        return 7;
    }
    
    String headers[] = new String[] { "ID", "NUMER", "ROK", "ID KLIENTA", "KLIENT", "DATA", "DATA POTWIERDZENIA" };
       
    @Override
    public String getColumnName(int column) {
        return headers[column];
    }
        
    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }
    
}
