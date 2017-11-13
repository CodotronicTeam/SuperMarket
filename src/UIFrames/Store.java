/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UIFrames;

import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author CompuFast
 */
public class Store extends javax.swing.JFrame {

    
    //this variable will be changed according to the radio button selected for search
    String searchBy = "groupNumber";
    
    /**
     * Creates new form NewJFrame
     */
    public Store() {
        initComponents();
        
        WindowListener exitListener = null;
        addWindowListener(prepareWindow(exitListener));
        
         if (!Login.dbc.check) {
            Login.dbc.ConnectDB();
        }
        
        storeTable.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
        storeTable.getTableHeader().setAlignmentY(CENTER_ALIGNMENT);
        storeTable.setAutoCreateColumnsFromModel(false);
        
        showAll();
        
        
        
        storeTable.getSelectionModel().setSelectionInterval(storeTable.getRowCount()-1, 
                    storeTable.getRowCount()-1);
            getDataFromSelectedRow();
        
            //I used DocumentListener instead of KeyListener according to these two pages
        //https://stackoverflow.com/questions/29830788/documentlistener-or-keylistener
        //https://stackoverflow.com/questions/13597760/keylistener-why-is-the-keypressed-method-is-delayed-by-one-type
            searchTxt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                searchMethod();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                searchMethod();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                searchMethod();
            }
        });
                
    }
    
    
    private WindowListener prepareWindow(WindowListener exitListener) {
        exitListener = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                MenuForAdmin m = new MenuForAdmin();
                Store.this.dispose();
                m.setVisible(true);
            }
        };
        return exitListener;
    }
    
    private void searchMethod()
    {
        try {
            
            Login.pst=Login.dbc.conn.prepareStatement("select groupNumber, groupName, productName, barcode, unitOfMeasurment, "
            + "price, averagePrice, sellingPrice, quantity from Store where "+searchBy+" like'%"+searchTxt.getText()+"%' order by groupNumber");        
            
            Login.rs=Login.pst.executeQuery();
            storeTable.setModel(DbUtils.resultSetToTableModel(Login.rs));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    private void showAll()
    {
        clearTextFields();
        try {
            Login.pst=Login.dbc.conn.prepareStatement("select groupNumber, groupName, productName, barcode, unitOfMeasurment, "
                    + "price, averagePrice, sellingPrice, quantity from Store order by groupNumber");
            Login.rs=Login.pst.executeQuery();
            storeTable.setModel(DbUtils.resultSetToTableModel(Login.rs));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }

    private void clearTextFields() {
        gpNumberTxt.setText("");
        gpNameTxt.setText("");
        pdtNameTxt.setText("");
        barcodeTxt.setText("");
        unitTxt.setText("");
        priceTxt.setText("");
        avgPriceTxt.setText("");
        sellPriceTxt.setText("");
        quantityTxt.setText("");
        searchTxt.setText("");
    }
    
    
    private void getDataFromSelectedRow()
    {
        try{
        if(storeTable.getSelectedRow()!=-1)
        {
//            clearTextFields();
            gpNumberTxt.setText(storeTable.getValueAt(storeTable.getSelectedRow(), 0).toString());
            gpNameTxt.setText(storeTable.getValueAt(storeTable.getSelectedRow(), 1).toString());
            pdtNameTxt.setText(storeTable.getValueAt(storeTable.getSelectedRow(), 2).toString());
            barcodeTxt.setText(storeTable.getValueAt(storeTable.getSelectedRow(), 3).toString());
            unitTxt.setText(storeTable.getValueAt(storeTable.getSelectedRow(), 4).toString());
            priceTxt.setText(storeTable.getValueAt(storeTable.getSelectedRow(), 5).toString());
            avgPriceTxt.setText(storeTable.getValueAt(storeTable.getSelectedRow(), 6).toString());
            sellPriceTxt.setText(storeTable.getValueAt(storeTable.getSelectedRow(), 7).toString());
            quantityTxt.setText(storeTable.getValueAt(storeTable.getSelectedRow(), 8).toString());
        } 
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

     private boolean checkEmptyFields() {
//
        if ((!gpNumberTxt.getText().equals("")) && (!gpNameTxt.getText().equals("")) && (!pdtNameTxt.getText().equals(""))
                && (!barcodeTxt.getText().equals("")) && (!unitTxt.getText().equals(""))
                && (!priceTxt.getText().equals("")) && (!avgPriceTxt.getText().equals(""))
                && (!sellPriceTxt.getText().equals("")) && (!quantityTxt.getText().equals(""))) {

            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchGp = new javax.swing.ButtonGroup();
        jLabel4 = new javax.swing.JLabel();
        gpNameRadio = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        pdtRadio = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        barcodeRadio = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        refreshBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        storeTable = new javax.swing.JTable();
        gpNumberTxt = new javax.swing.JTextField();
        gpNameTxt = new javax.swing.JTextField();
        barcodeTxt = new javax.swing.JTextField();
        pdtNameTxt = new javax.swing.JTextField();
        unitTxt = new javax.swing.JTextField();
        priceTxt = new javax.swing.JTextField();
        avgPriceTxt = new javax.swing.JTextField();
        sellPriceTxt = new javax.swing.JTextField();
        quantityTxt = new javax.swing.JTextField();
        newBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        searchTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        gpNumberRadio = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel4.setText("Product name");

        searchGp.add(gpNameRadio);
        gpNameRadio.setText("Group name");
        gpNameRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gpNameRadioActionPerformed(evt);
            }
        });

        jLabel5.setText("Unit of measurment");

        searchGp.add(pdtRadio);
        pdtRadio.setText("Product name");
        pdtRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdtRadioActionPerformed(evt);
            }
        });

        jLabel6.setText("Price");

        searchGp.add(barcodeRadio);
        barcodeRadio.setText("Barcode");
        barcodeRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barcodeRadioActionPerformed(evt);
            }
        });

        jLabel7.setText("Average price");

        refreshBtn.setText("Refresh table");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        jLabel8.setText("Selling price");

        jLabel9.setText("Quantity");

        storeTable = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex,int colIndex)
            {
                return false;
            }
        };
        storeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Number", "Group", "Product", "Barcode", "Unit", "Price", "Average price", "Selling price", "Quantity"
            }
        )

    );
    storeTable.setInheritsPopupMenu(true);
    storeTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    storeTable.getTableHeader().setResizingAllowed(false);
    storeTable.getTableHeader().setReorderingAllowed(false);
    storeTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            storeTableMouseClicked(evt);
        }
    });
    jScrollPane2.setViewportView(storeTable);

    newBtn.setText("New");
    newBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            newBtnActionPerformed(evt);
        }
    });

    saveBtn.setText("Save");
    saveBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            saveBtnActionPerformed(evt);
        }
    });

    deleteBtn.setText("Delete");
    deleteBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            deleteBtnActionPerformed(evt);
        }
    });

    jLabel1.setText("Group number");

    searchTxt.addCaretListener(new javax.swing.event.CaretListener() {
        public void caretUpdate(javax.swing.event.CaretEvent evt) {
            searchTxtCaretUpdate(evt);
        }
    });

    jLabel2.setText("Group name");

    searchGp.add(gpNumberRadio);
    gpNumberRadio.setSelected(true);
    gpNumberRadio.setText("Group number");
    gpNumberRadio.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            gpNumberRadioActionPerformed(evt);
        }
    });

    jLabel3.setText("Barcode");

    jLabel10.setText("Search by:");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(28, 28, 28)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel4)
                    .addGap(18, 18, 18)
                    .addComponent(pdtNameTxt))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel5)
                    .addGap(18, 18, 18)
                    .addComponent(unitTxt))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel6)
                    .addGap(64, 64, 64)
                    .addComponent(priceTxt))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel7)
                    .addGap(18, 18, 18)
                    .addComponent(avgPriceTxt))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(gpNameTxt)
                        .addComponent(barcodeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(gpNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sellPriceTxt)
                        .addComponent(quantityTxt))))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(newBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(saveBtn)
                    .addGap(18, 18, 18)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(refreshBtn))
            .addGap(68, 68, 68)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel10)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(gpNameRadio)
                        .addComponent(gpNumberRadio))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pdtRadio)
                        .addComponent(barcodeRadio)))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(searchTxt)
                    .addGap(124, 124, 124)))
            .addGap(8, 8, 8))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(gpNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(gpNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(27, 27, 27)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(pdtNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(barcodeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(23, 23, 23)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(unitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(priceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(avgPriceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(sellPriceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(quantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(newBtn)
                .addComponent(saveBtn)
                .addComponent(deleteBtn)
                .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(gpNumberRadio)
                        .addComponent(jLabel10)
                        .addComponent(pdtRadio))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(gpNameRadio)
                        .addComponent(barcodeRadio))
                    .addGap(5, 5, 5))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(refreshBtn)
                    .addContainerGap())))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gpNameRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gpNameRadioActionPerformed
        // TODO add your handling code here:
        searchBy = "groupName";
    }//GEN-LAST:event_gpNameRadioActionPerformed

    private void pdtRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdtRadioActionPerformed
        // TODO add your handling code here:
        searchBy = "productName";
    }//GEN-LAST:event_pdtRadioActionPerformed

    private void barcodeRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barcodeRadioActionPerformed
        // TODO add your handling code here:
        searchBy = "barcode";
    }//GEN-LAST:event_barcodeRadioActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        // TODO add your handling code here:
        showAll();
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void storeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_storeTableMouseClicked
        // TODO add your handling code here:
        getDataFromSelectedRow();
    }//GEN-LAST:event_storeTableMouseClicked

    private void newBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBtnActionPerformed
        // TODO add your handling code here:
        try {
            Login.pst = Login.dbc.conn.prepareStatement("insert into Store(groupNumber, groupName, productName,"
                    + " barcode, unitOfMeasurment, price, averagePrice, sellingPrice,quantity) values(?,?,?,?,?,?,?,?,?)");
            Login.pst.setInt(1, Integer.parseInt(gpNumberTxt.getText()));
            Login.pst.setString(2, gpNameTxt.getText());
            Login.pst.setString(3, pdtNameTxt.getText());
            Login.pst.setString(4, barcodeTxt.getText());
            Login.pst.setString(5, unitTxt.getText());
            Login.pst.setDouble(6, Double.parseDouble(priceTxt.getText()));
            Login.pst.setDouble(7, Double.parseDouble(avgPriceTxt.getText()));
            Login.pst.setDouble(8, Double.parseDouble(sellPriceTxt.getText()));
            Login.pst.setInt(9, Integer.parseInt(quantityTxt.getText()));
            Login.pst.execute();

            
            //add the new item to storeTable
            //I used this instead of showAll method to avoid reloading the table
            
            //showAll();
            
            DefaultTableModel tm = (DefaultTableModel) storeTable.getModel();
            tm.addRow(new String[]{gpNumberTxt.getText(), gpNameTxt.getText(), pdtNameTxt.getText(),
                barcodeTxt.getText(),unitTxt.getText(),priceTxt.getText(),avgPriceTxt.getText(),sellPriceTxt.getText() ,quantityTxt.getText()});
            
            JOptionPane.showMessageDialog(null, "New item added successfully");
            storeTable.getSelectionModel().setSelectionInterval(storeTable.getRowCount()-1, 
                    storeTable.getRowCount()-1);
            getDataFromSelectedRow();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
             
        }
    }//GEN-LAST:event_newBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
        if(storeTable.getSelectedRow()!=-1 && !checkEmptyFields())
        {
            try{
            Login.pst = Login.dbc.conn.prepareStatement("update Store set groupNumber=?, groupName=?, productName=?,"
                        + "barcode=?, unitOfMeasurment=?, price=?, averagePrice=?, sellingPrice=?, quantity=? where barcode=?");

                Login.pst.setInt(1, Integer.parseInt(gpNumberTxt.getText()));
                Login.pst.setString(2, gpNameTxt.getText());
                Login.pst.setString(3, pdtNameTxt.getText());
                Login.pst.setString(4, barcodeTxt.getText());
                Login.pst.setString(5, unitTxt.getText());
                Login.pst.setDouble(6, Double.parseDouble(priceTxt.getText()));
                Login.pst.setDouble(7, Double.parseDouble(avgPriceTxt.getText()));
                Login.pst.setDouble(8, Double.parseDouble(sellPriceTxt.getText()));
                Login.pst.setDouble(9, Double.parseDouble(quantityTxt.getText()));
                Login.pst.setString(10, storeTable.getValueAt(storeTable.getSelectedRow(), 3).toString());
                Login.pst.executeUpdate();
                
//                showAll();
                //I used this instead of showAll() method to avoid reloading the whole table again
                DefaultTableModel tm=(DefaultTableModel)storeTable.getModel();
                tm.setValueAt(gpNumberTxt.getText(), storeTable.getSelectedRow(), 0);
                tm.setValueAt(gpNameTxt.getText(), storeTable.getSelectedRow(), 1);
                tm.setValueAt(pdtNameTxt.getText(), storeTable.getSelectedRow(), 2);
                tm.setValueAt(barcodeTxt.getText(), storeTable.getSelectedRow(), 3);
                tm.setValueAt(unitTxt.getText(), storeTable.getSelectedRow(), 4);
                tm.setValueAt(priceTxt.getText(), storeTable.getSelectedRow(), 5);
                tm.setValueAt(avgPriceTxt.getText(), storeTable.getSelectedRow(), 6);
                tm.setValueAt(sellPriceTxt.getText(), storeTable.getSelectedRow(), 7);
                tm.setValueAt(quantityTxt.getText(), storeTable.getSelectedRow(), 8);
                
                JOptionPane.showMessageDialog(null, "Item updated successfully");
                
                
                
            } catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, "This barcode is already in system\nPlease change it");
                barcodeTxt.requestFocus();
            }
        }
         else if (storeTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Please select row from the table first");
        } else {
            JOptionPane.showMessageDialog(null, "One or more fields are empty");
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        int select = JOptionPane.showOptionDialog(null,
                "Do you want to delete this item?", null,
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, new String[]{"Delete", "Cancel"}, "default");
        
        if (storeTable.getSelectedRow() != -1 && select == 0) {
            try {
                Login.pst = Login.dbc.conn.prepareStatement("delete from Store where barcode=?");
                Login.pst.setString(1, barcodeTxt.getText());
                Login.pst.executeUpdate();
                
                //showAll();
                
                //I used this method to avoid reloding the whole table after deleting an item
                //When deleting a row in storeTable the previous row will be selected
                
                int selectedRow=storeTable.getSelectedRow();
                DefaultTableModel tm = (DefaultTableModel) storeTable.getModel();
                
                tm.removeRow(storeTable.getSelectedRow());
                if(storeTable.getRowCount()>0)
                {
                    storeTable.getSelectionModel().setSelectionInterval(selectedRow-1, selectedRow-1);
                    getDataFromSelectedRow();
                }
                else
                {
                    //if storeTable is empty and row count=0
                    clearTextFields();
                }
                

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void searchTxtCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_searchTxtCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTxtCaretUpdate

    private void gpNumberRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gpNumberRadioActionPerformed
        // TODO add your handling code here:
        searchBy = "groupNumber";
    }//GEN-LAST:event_gpNumberRadioActionPerformed

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
            java.util.logging.Logger.getLogger(Store.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Store.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Store.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Store.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Store().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField avgPriceTxt;
    private javax.swing.JRadioButton barcodeRadio;
    private javax.swing.JTextField barcodeTxt;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JRadioButton gpNameRadio;
    private javax.swing.JTextField gpNameTxt;
    private javax.swing.JRadioButton gpNumberRadio;
    private javax.swing.JTextField gpNumberTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton newBtn;
    private javax.swing.JTextField pdtNameTxt;
    private javax.swing.JRadioButton pdtRadio;
    private javax.swing.JTextField priceTxt;
    private javax.swing.JTextField quantityTxt;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.ButtonGroup searchGp;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JTextField sellPriceTxt;
    private javax.swing.JTable storeTable;
    private javax.swing.JTextField unitTxt;
    // End of variables declaration//GEN-END:variables
  
}
