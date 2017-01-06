package windows;

import db.DbQueries;
import entities.ProductEntity;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import tableTemplates.ProductsTableTemplate;
import static utilities.Other.getScreenWidth;
import static java.lang.Math.round;
import static java.lang.Math.round;
import static java.lang.Math.round;
import static java.lang.Math.round;

/**
 *
 * @author Marek
 */
public class productsWindow extends javax.swing.JFrame {
    public DbQueries wz = new DbQueries();
    public List<ProductEntity> toShow = wz.getProducts();
    MainWindow parentFrame;
    public productsWindow() {
        initComponents();
        this.setExtendedState( this.getExtendedState()|JFrame.MAXIMIZED_BOTH );
        toShow = wz.getProducts();
        drawTable(toShow);
        if(LoginPage.conn.userAns.getType()==1){
            adminMenu.show();
        }
        else{
            adminMenu.hide();
        } 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        adminMenu = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        withdrawUnwithdrawBtt = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NAZWA", "PRODUCENT", "ILOŚĆ", "CENA", "VAT", "GRUPA", "STATUS", "JEDN."
            }
        ));
        jScrollPane1.setViewportView(productTable);

        jMenu2.setText("Okno");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Zamknij");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        adminMenu.setText("Administrator");

        jMenuItem2.setText("Dodaj produkt");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        adminMenu.add(jMenuItem2);

        withdrawUnwithdrawBtt.setText("Oznacz produkt jako wycofany/aktywny");
        withdrawUnwithdrawBtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawUnwithdrawBttActionPerformed(evt);
            }
        });
        adminMenu.add(withdrawUnwithdrawBtt);

        jMenuBar1.add(adminMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        parentFrame.enable();
        this.hide();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        addProduct addProd = new addProduct();
        addProd.parentFrameProductWindow = this;
        addProd.parentFrameId = 1;
        addProd.show();
        this.disable();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void withdrawUnwithdrawBttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawUnwithdrawBttActionPerformed
        String status = productTable.getValueAt(productTable.getSelectedRow(),7).toString();
        confirmWithdrawUnwithdrawProduct confirmWithdraw = new confirmWithdrawUnwithdrawProduct();
        confirmWithdraw.prWind = this;
        confirmWithdraw.productId = (int) productTable.getValueAt(productTable.getSelectedRow(),0);
        confirmWithdraw.status = status;
        confirmWithdraw.selectedId = productTable.getSelectedRow();
        if(status.equalsIgnoreCase("AKTYWNY")){
            confirmWithdraw.question.setText("Czy chcesz wycofać produkt?");
        }else{
            confirmWithdraw.question.setText("Czy chcesz przywrócić produkt?");
        }
        confirmWithdraw.show();
        this.disable();
    }//GEN-LAST:event_withdrawUnwithdrawBttActionPerformed

    public void drawTable(List<ProductEntity> docList){
        ProductsTableTemplate dtm = new ProductsTableTemplate();
        productTable.setModel(dtm);
        
        //SET SIZE OF TABLE 6PX LESS THAN SCREEN RESOLUTION
        productTable.setSize(getScreenWidth()-29, 300);
        productTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        int tableWidth = productTable.getWidth();
        int temp = 0;
        productTable.getColumnModel().getColumn(0).setPreferredWidth((int)round(tableWidth*0.05));
        temp += (int)round(tableWidth*0.05);
        productTable.getColumnModel().getColumn(3).setPreferredWidth((int)round(tableWidth*0.1));
        temp += (int)round(tableWidth*0.1);
        productTable.getColumnModel().getColumn(4).setPreferredWidth((int)round(tableWidth*0.1));
        temp += (int)round(tableWidth*0.1);
        productTable.getColumnModel().getColumn(5).setPreferredWidth((int)round(tableWidth*0.05));
        temp += (int)round(tableWidth*0.05);
        productTable.getColumnModel().getColumn(6).setPreferredWidth((int)round(tableWidth*0.15));
        temp += (int)round(tableWidth*0.15);
        productTable.getColumnModel().getColumn(7).setPreferredWidth((int)round(tableWidth*0.05));
        temp += (int)round(tableWidth*0.05);
        productTable.getColumnModel().getColumn(7).setPreferredWidth((int)round(tableWidth*0.1));
        temp += (int)round(tableWidth*0.1);
        productTable.getColumnModel().getColumn(1).setPreferredWidth(round(tableWidth-temp)/2);
        productTable.getColumnModel().getColumn(2).setPreferredWidth(round(tableWidth-temp)/2);
        //INPUT DATA INTO TABLE
        dtm.setRowCount(docList.size());    
        for(int i = 0; i < docList.size(); i++){
              productTable.getModel().setValueAt(docList.get(i).getId(), i, 0);
              productTable.getModel().setValueAt(docList.get(i).getName(), i, 1);
              productTable.getModel().setValueAt(docList.get(i).getProducer(), i, 2);
              productTable.getModel().setValueAt(docList.get(i).getNumber(), i, 3);
              productTable.getModel().setValueAt(docList.get(i).getPrice(), i, 4);
              productTable.getModel().setValueAt(docList.get(i).getVat(), i, 5);
              productTable.getModel().setValueAt(docList.get(i).getGroup(), i, 6);
              productTable.getModel().setValueAt(docList.get(i).getStatus(), i, 7);
              productTable.getModel().setValueAt(docList.get(i).getUnit(), i, 8);
        }  
        //INITIALIZE RIGHT RENDERER
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);        
        //INITIALIZE CENTER RENDERER
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER); 
        //CHANGE COLUMN ALIGMENT
        productTable.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        productTable.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        productTable.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        productTable.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        productTable.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        productTable.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
        productTable.getColumnModel().getColumn(8).setCellRenderer(centerRenderer);
    }
    
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
            java.util.logging.Logger.getLogger(productsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(productsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(productsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(productsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new productsWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu adminMenu;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable productTable;
    private javax.swing.JMenuItem withdrawUnwithdrawBtt;
    // End of variables declaration//GEN-END:variables
}
