/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UIFrames;

import Classes.DBConnection;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author CompuFast
 */
public class Users extends javax.swing.JFrame {
    
    public static DBConnection dbc = new DBConnection();
    public static PreparedStatement pst = null;
    public static ResultSet rs = null;
    
    public static Integer userId=null;
    
    public static ArrayList<String> dataSelected=new ArrayList<>();
    
    String searchBy = "user_name";
    

    /**
     * Creates new form Users
     */
    public Users() {
         dbc.ConnectDB();


         WindowListener exitListener = null;
        addWindowListener(prepareWindow(exitListener));
        
        initComponents();
        
        load_searchTable("");
        
        searchTxt.getDocument().addDocumentListener(new DocumentListener() {
             @Override
             public void insertUpdate(DocumentEvent e) {
                 load_searchTable("where "+searchBy+" like '%"+searchTxt.getText()+"%'");
             }

             @Override
             public void removeUpdate(DocumentEvent e) {
                 load_searchTable("where "+searchBy+" like '%"+searchTxt.getText()+"%'");
             }

             @Override
             public void changedUpdate(DocumentEvent e) {
             }
         });
        
        usersTable.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if(usersTable.getSelectedRow()!=-1)
            {
                getSelectedRowData();
            }
        });
        
    }

    private WindowListener prepareWindow(WindowListener exitListener) {
        exitListener = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                MenuForAdmin m = new MenuForAdmin();
                Users.this.dispose();
                m.setVisible(true);
            }
        };
        return exitListener;
    }
    
    private void load_searchTable(String searchParameter) {
        try {
            //the data will be putted in usersTable arranged according to Id
            pst = dbc.conn.prepareStatement("select user_name, name, jobtitle, phone from User_Information "+searchParameter+"order by Id");
            rs = pst.executeQuery();
            usersTable.setModel(DbUtils.resultSetToTableModel(rs));
            
            TableColumnModel tm=usersTable.getColumnModel();
            
            
            String[] columnHeaders={"UserName", "Name", "Job Title", "Phone Number"};
            for(int i=0;i<tm.getColumnCount();i++)
            {
                tm.getColumn(i).setHeaderValue(columnHeaders[i]);
            }
            
            
            //after the data are loaded to usersTable, the last row will be selected
            
            int lastRowIndex = usersTable.getRowCount() - 1;
            usersTable.setRowSelectionInterval(lastRowIndex, lastRowIndex);
            
            //this method to fill the textfields with the data selected from usersTable
            getSelectedRowData();
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }
    
    private void getSelectedRowData() {
        int row = usersTable.getSelectedRow();

        try {
            //we selected the item from databse according to barcode as it is unique
            pst = dbc.conn.prepareStatement("select * from User_Information where user_name=?");
            pst.setString(1, String.valueOf(usersTable.getValueAt(row, 0)));
            rs = pst.executeQuery();
            if (rs.next()) {
                userId=rs.getInt("Id");
                userTxt.setText(rs.getString("user_name"));
                nameTxt.setText(rs.getString("name"));
                pswTxt.setText(rs.getString("password"));
                jobTxt.setText(rs.getString("jobtitle"));
                phoneTxt.setText(rs.getString("phone"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        userTxt = new javax.swing.JTextField();
        nameTxt = new javax.swing.JTextField();
        jobTxt = new javax.swing.JTextField();
        phoneTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        searchTxt = new javax.swing.JTextField();
        userRadioBtn = new javax.swing.JRadioButton();
        nameRadioBtn = new javax.swing.JRadioButton();
        jobRadioBtn = new javax.swing.JRadioButton();
        phoneRadioBtn = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        newBtn = new javax.swing.JButton();
        pswTxt = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Username");

        jLabel2.setText("Name");

        jLabel4.setText("Job title");

        jLabel5.setText("Phone number");

        userTxt.setEditable(false);

        nameTxt.setEditable(false);

        jobTxt.setEditable(false);

        phoneTxt.setEditable(false);

        usersTable = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex,int colIndex)
            {
                return false;
            }
        };
        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "Name", "Job Title", "Phone Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(usersTable);

        editBtn.setText("Edit");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        searchGp.add(userRadioBtn);
        userRadioBtn.setSelected(true);
        userRadioBtn.setText("User Name");
        userRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userRadioBtnActionPerformed(evt);
            }
        });

        searchGp.add(nameRadioBtn);
        nameRadioBtn.setText("Name");
        nameRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameRadioBtnActionPerformed(evt);
            }
        });

        searchGp.add(jobRadioBtn);
        jobRadioBtn.setText("Job Title");
        jobRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobRadioBtnActionPerformed(evt);
            }
        });

        searchGp.add(phoneRadioBtn);
        phoneRadioBtn.setText("Phone Number");
        phoneRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneRadioBtnActionPerformed(evt);
            }
        });

        jLabel6.setText("Search");

        newBtn.setText("New");
        newBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBtnActionPerformed(evt);
            }
        });

        pswTxt.setEditable(false);

        jLabel3.setText("Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pswTxt)
                            .addComponent(nameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(userTxt)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jobTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameRadioBtn)
                                    .addComponent(jobRadioBtn)
                                    .addComponent(phoneRadioBtn))
                                .addGap(123, 123, 123))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(userRadioBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(newBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)))
                        .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(260, 260, 260))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(userTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pswTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jobTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(phoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editBtn)
                    .addComponent(deleteBtn)
                    .addComponent(userRadioBtn)
                    .addComponent(newBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nameRadioBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jobRadioBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(phoneRadioBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(10, 10, 10))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void userRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userRadioBtnActionPerformed
        // TODO add your handling code here:
        searchBy = "user_name";
        load_searchTable("where "+searchBy+" like '%"+searchTxt.getText()+"%'");
    }//GEN-LAST:event_userRadioBtnActionPerformed

    private void nameRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameRadioBtnActionPerformed
        // TODO add your handling code here:
        searchBy = "name";
        load_searchTable("where "+searchBy+" like '%"+searchTxt.getText()+"%'");
    }//GEN-LAST:event_nameRadioBtnActionPerformed

    private void jobRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobRadioBtnActionPerformed
        // TODO add your handling code here:
        searchBy = "jobtitle";
        load_searchTable("where "+searchBy+" like '%"+searchTxt.getText()+"%'");
    }//GEN-LAST:event_jobRadioBtnActionPerformed

    private void phoneRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneRadioBtnActionPerformed
        // TODO add your handling code here:
        searchBy = "phone";
        load_searchTable("where "+searchBy+" like '%"+searchTxt.getText()+"%'");
    }//GEN-LAST:event_phoneRadioBtnActionPerformed

    private void newBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Register().setVisible(true);
    }//GEN-LAST:event_newBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new editUser().setVisible(true);
        editUser.userId=userId;
        editUser.ReNameTF.setText(nameTxt.getText());
        editUser.ReUserNameTF.setText(userTxt.getText());
        editUser.RePassTF.setText(new String(pswTxt.getPassword()));
        editUser.ReConfPassTF.setText(new String(pswTxt.getPassword()));
        editUser.RePhoneTF.setText(phoneTxt.getText());
        
        
        
    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        //to delete an item from table
        int select = JOptionPane.showOptionDialog(null,
                "Do you want to delete this user?", null,
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, new String[]{"Delete", "Cancel"}, "default");
        if (usersTable.getSelectedRow() != -1 && select == 0) {
            try {
                pst = dbc.conn.prepareStatement("delete from User_Information where user_name=?");
                pst.setString(1, userTxt.getText());
                pst.executeUpdate();
                DefaultTableModel tm = (DefaultTableModel) usersTable.getModel();
                int selectedRow = usersTable.getSelectedRow();
                tm.removeRow(selectedRow);
                if (selectedRow < usersTable.getRowCount()) {
                    usersTable.setRowSelectionInterval(selectedRow, selectedRow);
                } else {
                    usersTable.setRowSelectionInterval(selectedRow - 1, selectedRow - 1);
                }

                getSelectedRowData();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Users().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jobRadioBtn;
    public static javax.swing.JTextField jobTxt;
    private javax.swing.JRadioButton nameRadioBtn;
    public static javax.swing.JTextField nameTxt;
    private javax.swing.JButton newBtn;
    private javax.swing.JRadioButton phoneRadioBtn;
    public static javax.swing.JTextField phoneTxt;
    public static javax.swing.JPasswordField pswTxt;
    private javax.swing.ButtonGroup searchGp;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JRadioButton userRadioBtn;
    public static javax.swing.JTextField userTxt;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
  
}
