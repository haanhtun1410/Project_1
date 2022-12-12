package com.raven.formPhuKien;

import domainmodels.VGANhan;
import java.awt.Color;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import responsitory.LinhKienRe;
import services.LinhKienSe;
import services.impl.LinhKienSeImpls;

public class VGA extends javax.swing.JFrame {

    private List<VGANhan> listVGA = new ArrayList<>();
    private DefaultTableModel dtm = new DefaultTableModel();
    private DefaultTableModel dtmOff = new DefaultTableModel();
    private LinhKienSe lkSe = new LinhKienSeImpls();

    public VGA() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBackground(new Color(0, 0, 0, 0));

        fillHeaderTable();
        fillHeaderTableOff();
        showDataTable();
        showDataTableOff();
    }

    private boolean checkTrung(String id) {
        boolean check = false;
        for (VGANhan x : listVGA) {
            if (x.getIdVGA().contains(id)) {
                JOptionPane.showMessageDialog(this, "Đã có mã này rồi !");
            }
        }
        return check;
    }

    private void fillHeaderTable() {
        tblCPU.setModel(dtm);
        String header[] = {"STT", "Mã VGA", "TÊN", "TRẠNG THÁI"};
        dtm.setColumnIdentifiers(header);
    }

    private void fillHeaderTableOff() {
        tblCPUofff.setModel(dtmOff);
        String header[] = {"STT", "Mã VGA", "TÊN", "TRẠNG THÁI"};
        dtmOff.setColumnIdentifiers(header);
    }

    private void showDataTable() {
        listVGA = lkSe.getAllVGA();
        dtm = (DefaultTableModel) tblCPU.getModel();
        dtm.setRowCount(0);
        int i = 1;
        for (VGANhan x : listVGA) {
            dtm.addRow(new Object[]{
                i++, x.getIdVGA(), x.getTenVGA(), x.getTrangThai()
            });
        }
    }

    private void showDataTableOff() {
        listVGA = lkSe.getAllVGATT();
        dtmOff = (DefaultTableModel) tblCPUofff.getModel();
        dtmOff.setRowCount(0);
        int i = 1;
        for (VGANhan x : listVGA) {
            dtmOff.addRow(new Object[]{
                i++, x.getIdVGA(), x.getTenVGA(), x.getTrangThai()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        p = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCPU = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCPUofff = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        radioOnl = new javax.swing.JRadioButton();
        radioOff = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 102));
        jLabel3.setText("VGA");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        tblCPU.setAutoCreateRowSorter(true);
        tblCPU.setBackground(new java.awt.Color(51, 51, 51));
        tblCPU.setForeground(new java.awt.Color(255, 255, 255));
        tblCPU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCPU.setGridColor(new java.awt.Color(0, 0, 0));
        tblCPU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCPUMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCPU);

        p.addTab("CPU Đang họat động", jScrollPane1);

        tblCPUofff.setAutoCreateRowSorter(true);
        tblCPUofff.setBackground(new java.awt.Color(51, 51, 51));
        tblCPUofff.setForeground(new java.awt.Color(255, 255, 255));
        tblCPUofff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCPUofff.setGridColor(new java.awt.Color(0, 0, 0));
        tblCPUofff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCPUofffMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCPUofff);

        p.addTab("CPU Không hoạt động", jScrollPane2);

        getContentPane().add(p, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 500, 230));

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 a 4.png"))); // NOI18N
        btnDelete.setAlignmentY(0.0F);
        btnDelete.setBorder(null);
        btnDelete.setBorderPainted(false);
        btnDelete.setContentAreaFilled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, -1, -1));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 a 1.png"))); // NOI18N
        btnAdd.setAlignmentY(0.0F);
        btnAdd.setBorder(null);
        btnAdd.setBorderPainted(false);
        btnAdd.setContentAreaFilled(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, -1, -1));

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 a 2.png"))); // NOI18N
        btnUpdate.setAlignmentY(0.0F);
        btnUpdate.setBorder(null);
        btnUpdate.setBorderPainted(false);
        btnUpdate.setContentAreaFilled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 230, -1, 60));

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 a 3.png"))); // NOI18N
        btnRefresh.setAlignmentY(0.0F);
        btnRefresh.setBorder(null);
        btnRefresh.setBorderPainted(false);
        btnRefresh.setContentAreaFilled(false);
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        getContentPane().add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 310, 60, 60));

        txtID.setBorder(null);
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 150, 30));

        txtTen.setBorder(null);
        getContentPane().add(txtTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 160, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/175x30.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tên :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Trạng thái :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/175x30.png"))); // NOI18N
        jLabel7.setAlignmentY(0.0F);
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Mã VGA :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, -1, -1));

        buttonGroup1.add(radioOnl);
        radioOnl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioOnl.setForeground(new java.awt.Color(255, 255, 255));
        radioOnl.setSelected(true);
        radioOnl.setText("Active");
        radioOnl.setBorder(null);
        radioOnl.setContentAreaFilled(false);
        getContentPane().add(radioOnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, -1, -1));

        buttonGroup1.add(radioOff);
        radioOff.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioOff.setForeground(new java.awt.Color(255, 255, 255));
        radioOff.setText("InActive");
        radioOff.setBorder(null);
        radioOff.setContentAreaFilled(false);
        getContentPane().add(radioOff, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 a4.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void roundPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roundPanel1MouseClicked

    }//GEN-LAST:event_roundPanel1MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String id = txtID.getText();
        String ten = txtTen.getText();
        boolean a = radioOnl.isSelected();
        int tt = 0;
        if (a) {
            tt = 1;
        }
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không để trống mã");
        } else if (checkTrung(id)) {
        } else if (ten.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không để trống tên");
        } else {
            VGANhan cpu = new VGANhan(id, ten, tt);
            JOptionPane.showMessageDialog(this, lkSe.insertVGA(cpu));
            showDataTableOff();
            showDataTable();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String id = txtID.getText();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không để trống mã");
        } else {
            JOptionPane.showMessageDialog(this, lkSe.deleteVGA(id));
            showDataTable();
            showDataTableOff();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String id = txtID.getText();
        String ten = txtTen.getText();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không để trống id");
        } else if (ten.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không để trống TEN");
        } else {
            VGANhan cpu = new VGANhan(id, ten, 1);
            JOptionPane.showMessageDialog(this, lkSe.updateVGA(cpu, id));
            showDataTableOff();
            showDataTable();
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        String id = txtID.getText();
        String ten = txtTen.getText();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không để trống mã");
        } else {
            VGANhan cpu = new VGANhan(id, ten, 1);
            JOptionPane.showMessageDialog(this, lkSe.updateVGA(cpu, id));
            showDataTableOff();
            showDataTable();
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tblCPUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCPUMouseClicked
        listVGA = lkSe.getAllVGA();
        int row = tblCPU.getSelectedRow();
        VGANhan c = listVGA.get(row);
        txtID.setText(c.getIdVGA());
        txtTen.setText(c.getTenVGA());
        radioOnl.setSelected(true);
    }//GEN-LAST:event_tblCPUMouseClicked

    private void tblCPUofffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCPUofffMouseClicked
        listVGA = lkSe.getAllVGATT();
        int row = tblCPUofff.getSelectedRow();
        VGANhan c = listVGA.get(row);
        txtID.setText(c.getIdVGA());
        txtTen.setText(c.getTenVGA());
        radioOff.setSelected(true);
    }//GEN-LAST:event_tblCPUofffMouseClicked

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
            java.util.logging.Logger.getLogger(VGA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VGA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VGA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VGA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VGA().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane p;
    private javax.swing.JRadioButton radioOff;
    private javax.swing.JRadioButton radioOnl;
    private javax.swing.JTable tblCPU;
    private javax.swing.JTable tblCPUofff;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
