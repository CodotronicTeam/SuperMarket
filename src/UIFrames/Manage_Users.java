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
import net.proteanit.sql.DbUtils;

/**
 *
 * @author CompuFast
 */
public class Manage_Users extends javax.swing.JFrame {
    
    public static DBConnection dbc = new DBConnection();
    public static PreparedStatement pst = null;
    public static ResultSet rs = null;
    
    public static Integer userId=null;
    
    public static ArrayList<String> dataSelected=new ArrayList<>();
    
    String searchBy = "user_name";
    

    /**
     * Creates new form Users
     */
    public Manage_Users() {
         dbc.ConnectDB();


         WindowListener exitListener = null;
        addWindowListener(prepareWindow(exitListener));
        
        initComponents();
        
//        load_searchTable("");
        
        searchTxt.getDocument().addDocumentListener(new DocumentListener() {
             @Override
             public void insertUpdate(DocumentEvent e) {
                searchParameters();
             }

             @Override
             public void removeUpdate(DocumentEvent e) {
                 searchParameters();
             }

             @Override
             public void changedUpdate(DocumentEvent e) {
                 searchParameters();
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
                Manage_Users.this.dispose();
                m.setVisible(true);
            }
        };
        return exitListener;
    }
    
     private void showAll() {
        clearTextFields();
        try {
            Login.pst = Login.dbc.conn.prepareStatement("select user_name, name, password, jobtitle, phone from User_Information"
                    + " order by Id");
            Login.rs = Login.pst.executeQuery();
            usersTable.setModel(DbUtils.resultSetToTableModel(Login.rs));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
     
     private void searchParameters()
     {
         if (userRadioBtn.isSelected()) {
            search(0);
        } else if (jobRadioBtn.isSelected()) {
            search(1);
        } else if (nameRadioBtn.isSelected()) {
            search(2);
        } else if (phoneRadioBtn.isSelected()) {
            search(3);
        }
     }
     
     private void clearTextFields() {
        userTxt.setText("");
        nameTxt.setText("");
        passwordField.setText("");
        phoneTxt.setText("");
    }
     
    private void search(int i) {
        try {
            if (i == 0) {
                Login.pst = Login.dbc.conn.prepareStatement("select user_name, name, password, jobtitle,"
                        + " phone from User_Information"
                        + " where user_name like ?"
                        + " order by Id;");
                Login.pst.setString(1, searchTxt.getText() + "%");
            } else if (i == 1) {
                Login.pst = Login.dbc.conn.prepareStatement("select user_name, name, password, jobtitle,"
                        + " phone from User_Information"
                        + " where jobtitle like ?"
                        + " order by Id;");
                Login.pst.setString(1, searchTxt.getText() + "%");
            } else if (i == 2) {
                Login.pst = Login.dbc.conn.prepareStatement("select user_name, name, password, jobtitle,"
                        + " phone from User_Information"
                        + " where name like ?"
                        + " order by Id;");
                Login.pst.setString(1, searchTxt.getText() + "%");
            } else if (i == 3) {
                Login.pst = Login.dbc.conn.prepareStatement("select user_name, name, password, jobtitle,"
                        + " phone from User_Information"
                        + " where phone like ?"
                        + " order by Id;");
                Login.pst.setString(1, searchTxt.getText() + "%");
            }
            Login.rs = Login.pst.executeQuery();
            usersTable.setModel(DbUtils.resultSetToTableModel(Login.rs));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
     private boolean checkEmptyFields() {
        if ((!userTxt.getText().equals("")) && (!nameTxt.getText().equals("")) && (passwordField.getPassword().length != 0)) {
            return false;
        }
        return true;
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
                passwordField.setText(rs.getString("password"));
                jobComboBox.setSelectedItem(rs.getString("jobtitle"));
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
        passwordField = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jobComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Username");

        jLabel2.setText("Name");

        jLabel4.setText("Job title");

        jLabel5.setText("Phone number");

        userTxt.setEditable(false);

        nameTxt.setEditable(false);

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

        passwordField.setEditable(false);

        jLabel3.setText("Password");

        jobComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "emp" }));

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
                            .addComponent(passwordField)
                            .addComponent(nameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(userTxt)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jobComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jobComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        if (!searchTxt.getText().equals("")) {
            userRadioBtn.setSelected(true);
            search(0);
        }
    }//GEN-LAST:event_userRadioBtnActionPerformed

    private void nameRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameRadioBtnActionPerformed
        // TODO add your handling code here:
        if (!searchTxt.getText().equals("")) {
            nameRadioBtn.setSelected(true);
            search(2);
        }
    }//GEN-LAST:event_nameRadioBtnActionPerformed

    private void jobRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobRadioBtnActionPerformed
        // TODO add your handling code here:
        if (!searchTxt.getText().equals("")) {
            jobRadioBtn.setSelected(true);
            search(1);
        }
    }//GEN-LAST:event_jobRadioBtnActionPerformed

    private void phoneRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneRadioBtnActionPerformed
        // TODO add your handling code here:
        if (!searchTxt.getText().equals("")) {
            phoneRadioBtn.setSelected(true);
            search(3);
        }
    }//GEN-LAST:event_phoneRadioBtnActionPerformed

    private void newBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBtnActionPerformed
        // TODO add your handling code here:
        if (!checkEmptyFields()) {
            try {
                Login.pst = Login.dbc.conn.prepareStatement("insert into User_Information(user_name, name, password,"
                        + " jobtitle, phone)"
                        + " values(?,?,?,?,?)");
                Login.pst.setString(1, userTxt.getText());
                Login.pst.setString(2, nameTxt.getText());
                Login.pst.setString(3, String.valueOf(passwordField.getPassword()));
                String job = (jobComboBox.getSelectedIndex() == 0) ? "admin" : "emp";
                Login.pst.setString(4, job);
                Login.pst.setString(5, phoneTxt.getText());

                Login.pst.execute();

                showAll();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "This user is already in system\nPlease change it");
                userTxt.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "One or more fields are empty");
        }
    }//GEN-LAST:event_newBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        // TODO add your handling code here:
        if (!checkEmptyFields() && usersTable.getSelectedRow() != -1) {
            try {
                Login.pst = Login.dbc.conn.prepareStatement("update User_Information set user_name=?, name=?, password=?,"
                        + "jobtitle=?, phone=? where user_name=?");

                Login.pst.setString(1, userTxt.getText());
                Login.pst.setString(2, nameTxt.getText());
                Login.pst.setString(3, String.valueOf(passwordField.getPassword()));
                String job = (jobComboBox.getSelectedIndex() == 0) ? "admin" : "emp";
                Login.pst.setString(4, job);
                Login.pst.setString(5, phoneTxt.getText());
                Login.pst.setString(6, usersTable.getValueAt(usersTable.getSelectedRow(), 0).toString());

                Login.pst.executeUpdate();

                showAll();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "This user is already in system\nPlease change it");
                userTxt.requestFocus();
            }
        } else if (usersTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Please select row from the table first");
        } else {
            JOptionPane.showMessageDialog(null, "One or more fields are empty");
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
         if (usersTable.getSelectedRow() != -1) {
            try {
                Login.pst = Login.dbc.conn.prepareStatement("delete from User_Information where user_name=?");

                Login.pst.setString(1, usersTable.getValueAt(usersTable.getSelectedRow(), 0).toString());
                Login.pst.execute();

                showAll();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (usersTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Please select row from the table first");
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
            java.util.logging.Logger.getLogger(Manage_Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manage_Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manage_Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manage_Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manage_Users().setVisible(true);
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
    private javax.swing.JComboBox<String> jobComboBox;
    private javax.swing.JRadioButton jobRadioBtn;
    private javax.swing.JRadioButton nameRadioBtn;
    public static javax.swing.JTextField nameTxt;
    private javax.swing.JButton newBtn;
    public static javax.swing.JPasswordField passwordField;
    private javax.swing.JRadioButton phoneRadioBtn;
    public static javax.swing.JTextField phoneTxt;
    private javax.swing.ButtonGroup searchGp;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JRadioButton userRadioBtn;
    public static javax.swing.JTextField userTxt;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
  
}
