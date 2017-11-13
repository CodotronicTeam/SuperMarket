/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package UIPanels;

import UIFrames.Login;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Font;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author CompuFast
 */
public class Old_Bills extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public Old_Bills() {
        initComponents();
        Table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
        Table.getTableHeader().setAlignmentY(CENTER_ALIGNMENT);
        Table.setAutoCreateColumnsFromModel(false);
        
        LastBtn.doClick();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        CashNameTF = new javax.swing.JTextField();
        ShiftTF = new javax.swing.JTextField();
        DateTF = new javax.swing.JTextField();
        TimeTF = new javax.swing.JTextField();
        TotalTF = new javax.swing.JTextField();
        BillNumTF = new javax.swing.JTextField();
        PNumTF = new javax.swing.JTextField();
        PrintBtn = new javax.swing.JButton();
        NextBtn = new javax.swing.JButton();
        PreviousBtn = new javax.swing.JButton();
        LastBtn = new javax.swing.JButton();
        FirstBtn = new javax.swing.JButton();

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category No.", "Category", "Product Name", "Barcode", "Product Unit", "Quantity", "Price", "Total Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table);

        jLabel1.setText("Casher Name: ");

        jLabel2.setText("Shift: ");

        jLabel3.setText("Bill Number: ");

        jLabel4.setText("Date: ");

        jLabel5.setText("Time: ");

        jLabel6.setText("Pieces Number: ");

        jLabel7.setText("Total: ");

        CashNameTF.setEditable(false);

        ShiftTF.setEditable(false);

        DateTF.setEditable(false);

        TimeTF.setEditable(false);

        TotalTF.setEditable(false);
        TotalTF.setText("0");

        BillNumTF.setEditable(false);

        PNumTF.setEditable(false);
        PNumTF.setText("0");

        PrintBtn.setText("Print");
        PrintBtn.setEnabled(false);
        PrintBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(PNumTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(TimeTF, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DateTF, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ShiftTF, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CashNameTF, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BillNumTF, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TotalTF))
                .addGap(29, 29, 29)
                .addComponent(PrintBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BillNumTF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CashNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ShiftTF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DateTF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(PrintBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TimeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PNumTF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TotalTF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(179, Short.MAX_VALUE))
        );

        NextBtn.setText("Next");
        NextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextBtnActionPerformed(evt);
            }
        });

        PreviousBtn.setText("Previous");
        PreviousBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousBtnActionPerformed(evt);
            }
        });

        LastBtn.setText("Last");
        LastBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastBtnActionPerformed(evt);
            }
        });

        FirstBtn.setText("First");
        FirstBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(NextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(PreviousBtn)
                        .addGap(120, 120, 120)
                        .addComponent(LastBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(FirstBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PreviousBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LastBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(FirstBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    int BillNum;
    int maxBillNum;
    
    private void PrintBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintBtnActionPerformed
        try {

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "There is an error in the system\nplease contact Codotronic team", "Error", 0);
        }
    }//GEN-LAST:event_PrintBtnActionPerformed

    private void NextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextBtnActionPerformed
        try {
            PreviousBtn.setEnabled(true);
            BillNum+=1;
            System.out.println(BillNum);
            Login.pst = Login.dbc.conn.prepareStatement("select Category_Num,Category_Name,Product_Name,Barcode,"
                + "Product_Unit,Quantity_Sold,Price,Total_Price,Bill_Num,User_Name,Shift,Date,Time from Sales where Bill_Num="+BillNum);
            Login.rs = Login.pst.executeQuery();

            if(BillNum==maxBillNum)
            {
                NextBtn.setEnabled(false);
            }
            Table.setModel(DbUtils.resultSetToTableModel(Login.rs));
            double total_price=0;
            double quantity_sold=0;
            while(Login.rs.previous())
            {
                BillNumTF.setText(String.valueOf(BillNum));
                CashNameTF.setText(Login.rs.getString("User_Name"));
                ShiftTF.setText(Login.rs.getString("Shift"));
                DateTF.setText(Login.rs.getDate("Date").toString());
                TimeTF.setText(Login.rs.getDate("Time").toString());
                total_price+=Login.rs.getDouble("Total_Price");
                quantity_sold+=Login.rs.getDouble("Quantity_Sold");
                TotalTF.setText(String.valueOf(total_price));
                PNumTF.setText(String.valueOf(quantity_sold));
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "You reached the last sales", "Info", 1);
            NextBtn.setEnabled(false);

        }
    }//GEN-LAST:event_NextBtnActionPerformed

    private void PreviousBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousBtnActionPerformed

        try {
            NextBtn.setEnabled(true);
            BillNum-=1;
            System.out.println(BillNum);
            Login.pst = Login.dbc.conn.prepareStatement("select Category_Num,Category_Name,Product_Name,Barcode,"
                + "Product_Unit,Quantity_Sold,Price,Total_Price,Bill_Num,User_Name,Shift,Date,Time from Sales where Bill_Num="+BillNum);
            Login.rs = Login.pst.executeQuery();

            if(BillNum==1)
            {
                PreviousBtn.setEnabled(false);
            }
            
            Table.setModel(DbUtils.resultSetToTableModel(Login.rs));
            
            double total_price=0;
            double quantity_sold=0;
            while(Login.rs.previous())
            {

                BillNumTF.setText(String.valueOf(BillNum));
                CashNameTF.setText(Login.rs.getString("User_Name"));
                ShiftTF.setText(Login.rs.getString("Shift"));
                DateTF.setText(Login.rs.getDate("Date").toString());
                TimeTF.setText(Login.rs.getDate("Time").toString());
                total_price+=Login.rs.getDouble("Total_Price");
                quantity_sold+=Login.rs.getDouble("Quantity_Sold");
                TotalTF.setText(String.valueOf(total_price));
                PNumTF.setText(String.valueOf(quantity_sold));
            }
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            JOptionPane.showMessageDialog(this, "You reached the first sales", "Info", 1);
            PreviousBtn.setEnabled(false);
        }
    }//GEN-LAST:event_PreviousBtnActionPerformed

    private void LastBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastBtnActionPerformed

        try {

            Login.pst = Login.dbc.conn.prepareStatement("select Category_Num,Category_Name,Product_Name,Barcode,"
                + "Product_Unit,Quantity_Sold,Price,Total_Price,Bill_Num,User_Name,Shift,Date,Time from Sales where Bill_Num=(select max(Bill_Num) from Sales)");
            Login.rs = Login.pst.executeQuery();
            Table.setModel(DbUtils.resultSetToTableModel(Login.rs));
            double total_price=0;
            double quantity_sold=0;
            while(Login.rs.previous())
            {
                BillNum=Login.rs.getInt("Bill_Num");
                maxBillNum=BillNum;
                
                BillNumTF.setText(String.valueOf(BillNum));
                CashNameTF.setText(Login.rs.getString("User_Name"));
                ShiftTF.setText(Login.rs.getString("Shift"));
//                DateTF.setText(Login.rs.getDate("Date").toString());
//                TimeTF.setText(Login.rs.getDate("Time").toString());
                total_price+=Login.rs.getDouble("Total_Price");
                quantity_sold+=Login.rs.getDouble("Quantity_Sold");
                TotalTF.setText(String.valueOf(total_price));
                PNumTF.setText(String.valueOf(quantity_sold));
            }

                PreviousBtn.setEnabled(true);
                NextBtn.setEnabled(false);
                
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getCause());
System.out.println(e.getMessage());
            //            JOptionPane.showMessageDialog(this, "Database is not working\nplease contact Codotronic team", "Error", 0);
        }
    }//GEN-LAST:event_LastBtnActionPerformed

    private void FirstBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstBtnActionPerformed


        try {
           
            Login.pst = Login.dbc.conn.prepareStatement("select Category_Num,Category_Name,Product_Name,Barcode,"
                + "Product_Unit,Quantity_Sold,Price,Total_Price,Bill_Num,User_Name,Shift,Date,Time from Sales where Bill_Num=(select min(Bill_Num) from Sales)");
            Login.rs = Login.pst.executeQuery();

            Table.setModel(DbUtils.resultSetToTableModel(Login.rs));
            double total_price=0;
            double quantity_sold=0;
            while (Login.rs.previous())
            {
                BillNum=Login.rs.getInt("Bill_Num");
                BillNumTF.setText(String.valueOf(BillNum));
                CashNameTF.setText(Login.rs.getString("User_Name"));
                ShiftTF.setText(Login.rs.getString("Shift"));
                DateTF.setText(Login.rs.getDate("Date").toString());
                TimeTF.setText(Login.rs.getDate("Time").toString());
                total_price+=Login.rs.getDouble("Total_Price");
                quantity_sold+=Login.rs.getDouble("Quantity_Sold");
               
                TotalTF.setText(String.valueOf(total_price));
                PNumTF.setText(String.valueOf(quantity_sold));
            }
            
                NextBtn.setEnabled(true);
                PreviousBtn.setEnabled(false);
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_FirstBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField BillNumTF;
    public javax.swing.JTextField CashNameTF;
    public javax.swing.JTextField DateTF;
    private javax.swing.JButton FirstBtn;
    private javax.swing.JButton LastBtn;
    private javax.swing.JButton NextBtn;
    public javax.swing.JTextField PNumTF;
    private javax.swing.JButton PreviousBtn;
    public javax.swing.JButton PrintBtn;
    public javax.swing.JTextField ShiftTF;
    public javax.swing.JTable Table;
    public javax.swing.JTextField TimeTF;
    public javax.swing.JTextField TotalTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
  
}
