/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/AWTForms/Frame.java to edit this template
 */
package FinalProject;

import static FinalProject.Controller.connectDB;
import javax.swing.JOptionPane;

/**
 *
 * @author rober
 */
public class Login extends java.awt.Frame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        
        connectDB();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabelLogin = new javax.swing.JLabel();
        jLabelUser = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jTextFieldUser = new javax.swing.JTextField();
        jTextFieldPassword = new javax.swing.JTextField();
        jButtonLogin = new javax.swing.JButton();
        jLabelValidUser = new javax.swing.JLabel();
        jLabelValidateUser = new javax.swing.JLabel();
        jRadioButtonLibrarian = new javax.swing.JRadioButton();
        jRadioButtonStudent = new javax.swing.JRadioButton();
        jRadioButtonSupplier = new javax.swing.JRadioButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        jLabelLogin.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 24)); // NOI18N
        jLabelLogin.setText("Login");

        jLabelUser.setText("User: ");

        jLabelPassword.setText("Password");

        jTextFieldUser.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jButtonLogin.setText("Login");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        jLabelValidateUser.setText("Please enter user and passsword");

        buttonGroup1.add(jRadioButtonLibrarian);
        jRadioButtonLibrarian.setText("Librarian");

        buttonGroup1.add(jRadioButtonStudent);
        jRadioButtonStudent.setText("Student");

        buttonGroup1.add(jRadioButtonSupplier);
        jRadioButtonSupplier.setText("Supplier");
        jRadioButtonSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonSupplierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelUser)
                                    .addComponent(jLabelPassword))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonLogin)
                                    .addComponent(jTextFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(238, 238, 238)
                                .addComponent(jLabelValidUser))
                            .addComponent(jLabelValidateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jRadioButtonLibrarian)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonStudent)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonSupplier)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabelLogin)
                .addGap(28, 28, 28)
                .addComponent(jLabelValidUser)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(jLabelValidateUser)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelUser))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPassword))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonLogin)
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonLibrarian)
                            .addComponent(jRadioButtonStudent)
                            .addComponent(jRadioButtonSupplier))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        String user = jTextFieldUser.getText();
        String password = jTextFieldPassword.getText();
        Boolean choiceLibrarian = jRadioButtonLibrarian.isSelected();
        Boolean choiceStudent = jRadioButtonStudent.isSelected();
        Boolean choiceSupplier = jRadioButtonSupplier.isSelected();
        if (choiceLibrarian == true && user.equals("Librarian") && password.equals("123")) {
            MainLibrarian m = new MainLibrarian();
            m.setVisible(true);

        } else {
            jLabelValidateUser.setText("Username and Password do not match");
            jTextFieldUser.setText("");
            jTextFieldPassword.setText("");
        }
        if (choiceStudent == true && user.equals("Student") && password.equals("456")) {
            MainStudent m = new MainStudent();
            m.setVisible(true);
        } else {
            jLabelValidateUser.setText("Username and Password do not match");
            jTextFieldUser.setText("");
            jTextFieldPassword.setText("");
        }
        if (choiceSupplier == true && user.equals("Supplier") && password.equals("789")) {
            MainSupplier m = new MainSupplier();
            m.setVisible(true);
        } else {
            jLabelValidateUser.setText("Username and Password do not match");
            jTextFieldUser.setText("");
            jTextFieldPassword.setText("");
        }
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jRadioButtonSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonSupplierActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JLabel jLabelValidUser;
    private javax.swing.JLabel jLabelValidateUser;
    private javax.swing.JRadioButton jRadioButtonLibrarian;
    private javax.swing.JRadioButton jRadioButtonStudent;
    private javax.swing.JRadioButton jRadioButtonSupplier;
    private javax.swing.JTextField jTextFieldPassword;
    private javax.swing.JTextField jTextFieldUser;
    // End of variables declaration//GEN-END:variables
}
