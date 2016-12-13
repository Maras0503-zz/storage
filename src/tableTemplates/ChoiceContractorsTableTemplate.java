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
public class ChoiceContractorsTableTemplate extends DefaultTableModel{
  
    @Override
    public int getColumnCount() {
        return 6;
    }

    String headers[] = new String[] { "ID", "NAZWA", "MIASTO", "KOD POCZTOWY", "ULICA", "NIP" };
       
    @Override
    public String getColumnName(int column) {
        return headers[column];
    }
        
    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }
    
}
