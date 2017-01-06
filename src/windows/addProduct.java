
package windows;

import db.DbQueries;
import entities.groupEntity;
import entities.unitEntity;
import entities.vatEntity;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;


/**
 *
 * @author Marek
 */
public class addProduct extends javax.swing.JFrame {
    public productsWindow parentFrameProductWindow;
    public MainWindow parentFrameMainWidnow;
    public int selectedContractorId = 0;
    public String selectedContractorName = "";
    public int parentFrameId;
    public DbQueries db = new DbQueries();
    /**
     * Creates new form addProduct
     */
    public addProduct() {
        getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY));
        initComponents();
        List<groupEntity> groupList = new ArrayList<>();
        groupList = db.getGroups();
        groupsCombo.addItem("brak");
        for(groupEntity group : groupList){
           groupsCombo.addItem(group.getName());
        }
        
        List<vatEntity> vatList = new ArrayList<>();
        vatList = db.getVat();
        vatCombo.addItem("brak");
        for(vatEntity vat : vatList){
           vatCombo.addItem(vat.getValue()+"");
        }
        
        List<unitEntity> unitList = new ArrayList<>();
        unitList = db.getUnits();
        unitCombo.addItem("brak");
        for(unitEntity unit : unitList){
           unitCombo.addItem(unit.getName());
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameBox = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        choseProducer = new javax.swing.JButton();
        selectedContractorNameLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        priceBox = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        groupsCombo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        vatCombo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        codeBox = new javax.swing.JTextField();
        addAndClose = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        selectedContractorIdLabel = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        unitCombo = new javax.swing.JComboBox<>();
        communicatLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        window = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setUndecorated(true);

        nameBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nameBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("NAZWA:");

        choseProducer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        choseProducer.setText("WYBIERZ PRODUCENTA");
        choseProducer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choseProducerActionPerformed(evt);
            }
        });

        selectedContractorNameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        selectedContractorNameLabel.setText("NIE WYBRANO PRODUCENTA");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("WYBRANY:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("CENA NETTO:");

        priceBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("GRUPA PRODUKTOWA:");

        groupsCombo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("STAWKA VAT:");

        vatCombo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("KOD KRESKOWY:");

        codeBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        addAndClose.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addAndClose.setText("DODAJ I ZAMKNIJ");
        addAndClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAndCloseActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("ID:");

        selectedContractorIdLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        selectedContractorIdLabel.setText("--");

        add.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add.setText("DODAJ");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("JEDNOSTKA:");

        unitCombo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        communicatLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        communicatLabel.setForeground(new java.awt.Color(255, 0, 0));
        communicatLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        window.setText("Okno");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Zamknij");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        window.add(jMenuItem1);

        jMenuBar1.add(window);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(communicatLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameBox))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addAndClose, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(priceBox)
                            .addComponent(groupsCombo, 0, 306, Short.MAX_VALUE)
                            .addComponent(vatCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(codeBox)
                            .addComponent(unitCombo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(choseProducer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(selectedContractorIdLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(selectedContractorNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(choseProducer)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(selectedContractorNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectedContractorIdLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(priceBox)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(groupsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vatCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(unitCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(communicatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addAndClose, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if(parentFrameId == 1){
            parentFrameProductWindow.enable();
        }
        if(parentFrameId == 2){
            parentFrameMainWidnow.enable();
        }
        this.hide();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void choseProducerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choseProducerActionPerformed
        ContractorChoice cont = new ContractorChoice();
        cont.parentFrameAddProduct = this;
        cont.parentFrameId = 2;
        cont.show();
        this.disable();
    }//GEN-LAST:event_choseProducerActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        String alertText = "<html><center>";
        int colonNeeded = 0;
        int errorsCounter = 0;
    
        //checks whether the name is not empty
        if(nameBox.getText().equals("")){
            alertText += "nie podano nazwy";
            colonNeeded++;
            errorsCounter++;
        }
        
        //colon needed?
        if(colonNeeded == 1){
            alertText+=", ";
            colonNeeded--;
        }
        
        //checks whether the name is not too short minimum 10 character
        if(nameBox.getText().length() < 10){
            alertText += "nazwa jest za krótka (minimum 10 znaków)";
            colonNeeded++;
            errorsCounter++;
        }
        //Sprawdzenie czy potrzebny przecinek
        if(colonNeeded == 1){
            alertText+=", ";
            colonNeeded--;
        }

        
        //checks whether the group is selected
        if(groupsCombo.getSelectedItem().toString().equals("brak")){
            alertText += "nie wybrano grupy";
            colonNeeded++;
            errorsCounter++;
        }
        //Sprawdzenie czy potrzebny przecinek
        if(colonNeeded == 1){
            alertText+=", ";
            colonNeeded--;
        }
        
        //checks whether the vat is selected
        if(vatCombo.getSelectedItem().toString().equals("brak")){
            alertText += "nie wybrano stawki vat";
            colonNeeded++;
            errorsCounter++;
        }
        //Sprawdzenie czy potrzebny przecinek
        if(colonNeeded == 1){
            alertText+=", ";
            colonNeeded--;
        }
        
        //checks whether the unit is selected
        if(unitCombo.getSelectedItem().toString().equals("brak")){
            alertText += "nie wybrano jednostki";
            colonNeeded++;
            errorsCounter++;
        }
        //Sprawdzenie czy potrzebny przecinek
        if(colonNeeded == 1){
            alertText+=", ";
            colonNeeded--;
        }
        
        //checks whether the producer is selected
        if(selectedContractorIdLabel.getText().equals("--")){
            alertText += "nie wybrano producenta";
            colonNeeded++;
            errorsCounter++;
        }    
      
       if (errorsCounter == 0){ 
            db.addProduct(nameBox.getText().toUpperCase(), Integer.valueOf(selectedContractorIdLabel.getText()), Float.valueOf(priceBox.getText()), groupsCombo.getSelectedItem().toString(), Integer.valueOf(vatCombo.getSelectedItem().toString()), codeBox.getText(), unitCombo.getSelectedItem().toString());
            if(parentFrameId == 1){
                parentFrameProductWindow.drawTable(parentFrameProductWindow.wz.getProducts());
                nameBox.setText("");
                selectedContractorIdLabel.setText("--");
                selectedContractorNameLabel.setText("NIE WYBRANO PRODUCENTA");
                priceBox.setText("");
                vatCombo.setSelectedIndex(1);
                groupsCombo.setSelectedIndex(1);
                unitCombo.setSelectedIndex(1);
                codeBox.setText("");
                communicatLabel.setText("");
                parentFrameProductWindow.productTable.changeSelection(parentFrameProductWindow.productTable.getRowCount()-1, 1, false , false);
            }
       }else{
            communicatLabel.setText(alertText);
       }
       
    }//GEN-LAST:event_addActionPerformed

    private void addAndCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAndCloseActionPerformed
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        String alertText = "<html><center>";
        int colonNeeded = 0;
        int errorsCounter = 0;
    
        //checks whether the name is not empty
        if(nameBox.getText().equals("")){
            alertText += "nie podano nazwy";
            colonNeeded++;
            errorsCounter++;
        }
        
        //colon needed?
        if(colonNeeded == 1){
            alertText+=", ";
            colonNeeded--;
        }
        
        //checks whether the name is not too short minimum 10 character
        if(nameBox.getText().length() < 10){
            alertText += "nazwa jest za krótka (minimum 10 znaków)";
            colonNeeded++;
            errorsCounter++;
        }
        //Sprawdzenie czy potrzebny przecinek
        if(colonNeeded == 1){
            alertText+=", ";
            colonNeeded--;
        }

        
        //checks whether the group is selected
        if(groupsCombo.getSelectedItem().toString().equals("brak")){
            alertText += "nie wybrano grupy";
            colonNeeded++;
            errorsCounter++;
        }
        //Sprawdzenie czy potrzebny przecinek
        if(colonNeeded == 1){
            alertText+=", ";
            colonNeeded--;
        }
        
        //checks whether the vat is selected
        if(vatCombo.getSelectedItem().toString().equals("brak")){
            alertText += "nie wybrano stawki vat";
            colonNeeded++;
            errorsCounter++;
        }
        //Sprawdzenie czy potrzebny przecinek
        if(colonNeeded == 1){
            alertText+=", ";
            colonNeeded--;
        }
        
        //checks whether the unit is selected
        if(unitCombo.getSelectedItem().toString().equals("brak")){
            alertText += "nie wybrano jednostki";
            colonNeeded++;
            errorsCounter++;
        }
        //Sprawdzenie czy potrzebny przecinek
        if(colonNeeded == 1){
            alertText+=", ";
            colonNeeded--;
        }
        //checks whether the producer is selected
        if(selectedContractorIdLabel.getText().equals("--")){
            alertText += "nie wybrano producenta";
            colonNeeded++;
            errorsCounter++;
        }
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        
        
       
       if (errorsCounter == 0){ 
            db.addProduct(nameBox.getText().toUpperCase(), Integer.valueOf(selectedContractorIdLabel.getText()), Float.valueOf(priceBox.getText()), groupsCombo.getSelectedItem().toString(), Integer.valueOf(vatCombo.getSelectedItem().toString()), codeBox.getText(), unitCombo.getSelectedItem().toString());
            if(parentFrameId == 1){
                parentFrameProductWindow.enable();
                parentFrameProductWindow.drawTable(parentFrameProductWindow.wz.getProducts());
                parentFrameProductWindow.productTable.changeSelection(parentFrameProductWindow.productTable.getRowCount()-1, 1, false , false);
            }
            if(parentFrameId == 2){
                parentFrameMainWidnow.enable();
            }
            this.dispose();
       }else{
            communicatLabel.setText(alertText);
       }
    }//GEN-LAST:event_addAndCloseActionPerformed

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
            java.util.logging.Logger.getLogger(addProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton addAndClose;
    private javax.swing.JButton choseProducer;
    private javax.swing.JTextField codeBox;
    private javax.swing.JLabel communicatLabel;
    private javax.swing.JComboBox<String> groupsCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JTextField nameBox;
    private javax.swing.JTextField priceBox;
    public javax.swing.JLabel selectedContractorIdLabel;
    public javax.swing.JLabel selectedContractorNameLabel;
    private javax.swing.JComboBox<String> unitCombo;
    private javax.swing.JComboBox<String> vatCombo;
    private javax.swing.JMenu window;
    // End of variables declaration//GEN-END:variables
}
