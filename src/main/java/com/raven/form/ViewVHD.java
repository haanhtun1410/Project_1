/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import domainmodels.VoucherHd;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import responsitory.VoucherHdRespository;
import responsitory.impl.VoucherHdRespositoryImpl;
import services.VoucherHdService;
import services.impl.VoucherHdServiceImpl;

//import utilsHuy.MsgBox;

/**
 *
 * @author Laptop88
 */
public class ViewVHD extends javax.swing.JFrame {

   private VoucherHdRespository VHDrepo = new VoucherHdRespositoryImpl();
   private final  VoucherHdService VHDser = new VoucherHdServiceImpl();
   static List<VoucherHd> listVHD = new ArrayList<>();
   int index = 0;
   
   
    public ViewVHD() {
        initComponents();
        fillTable();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblVoucherHD = new javax.swing.JTable();
        txtId = new javax.swing.JTextField();
        txtMoTa = new javax.swing.JTextField();
        txtTienGiam = new javax.swing.JTextField();
        txtPhanTramGiam = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNgayKetThuc = new javax.swing.JTextField();
        txtNgayApDung = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblVoucherHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "MoTa", "TienGiam", "PhanTramGiam", "NgayApDung", "NgayKetThuc"
            }
        ));
        tblVoucherHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVoucherHDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVoucherHD);

        jLabel3.setText("PhanTramGiam");

        jLabel4.setText("TienGiam");

        jLabel2.setText("MoTa");

        jLabel1.setText("Id");

        jLabel5.setText("NgayApDung");

        jLabel6.setText("NgayKetThuc");

        btnXoa.setText("Xoa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setText("Sua");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setText("Them");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(60, 60, 60))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(512, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTienGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPhanTramGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtNgayApDung, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(136, 136, 136))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btnThem)
                        .addGap(38, 38, 38)
                        .addComponent(btnSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoa)))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNgayApDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTienGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPhanTramGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
            insert();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
            update();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
            delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblVoucherHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVoucherHDMouseClicked
            if (evt.getClickCount() == 2) {
              index = tblVoucherHD.rowAtPoint(evt.getPoint());
                if (index>0) {
                    fillToForm();
                }
        }
    }//GEN-LAST:event_tblVoucherHDMouseClicked

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
            java.util.logging.Logger.getLogger(ViewVHD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewVHD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewVHD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewVHD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewVHD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVoucherHD;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtNgayApDung;
    private javax.swing.JTextField txtNgayKetThuc;
    private javax.swing.JTextField txtPhanTramGiam;
    private javax.swing.JTextField txtTienGiam;
    // End of variables declaration//GEN-END:variables

    private void fillTable() {
           DefaultTableModel dtm = (DefaultTableModel) tblVoucherHD.getModel();
        dtm.setRowCount(0);
        for (VoucherHd x : VHDser.getAll()) {
            Object[] rowData ={
                x.getId(),
                x.getMoTa(),
                x.getTienGiam(),
                x.getPhanTramGiam(),
                x.getNgayApDung(),
                x.getNgayKetThuc()
            };
            dtm.addRow(rowData);
            
        }
    }
    
    VoucherHd getformData(){
        String id = txtId.getText();
        String moTa = txtMoTa.getText();
        String tienGiam = txtTienGiam.getText();
        String phanTramGiam = txtPhanTramGiam.getText();
        String ngayApDung = txtNgayApDung.getText();
        String ngayKetThuc = txtNgayKetThuc.getText();
        boolean check = true;
        
        Date tApDung =null;
        Date tKetThuc =null;
        
        if(id.isEmpty()|| moTa.isEmpty()|| tienGiam.isEmpty()|| phanTramGiam.isEmpty()|| ngayApDung.isEmpty()|| ngayKetThuc.isEmpty()){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
            return null;
        }else{
            try {
                SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
                tApDung = f.parse(ngayApDung);
                tKetThuc = f.parse(ngayKetThuc);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dang yyyy-MM-dd");
            }
            
            try {
                int intPhanTramGiam = Integer.parseInt(phanTramGiam);
            } catch (Exception e) {
                check = false;
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng kiểu");
            }
            
            
        }
        
        if(check){
            return new VoucherHd(id, moTa, BigDecimal.TEN, NORMAL, tApDung, tKetThuc);
        }
            
        return null;
    }
    
    void clear(){
        txtId.setText("");
        txtMoTa.setText("");
        txtTienGiam.setText("");
        txtPhanTramGiam.setText("");
        txtNgayApDung.setText("");
        txtNgayKetThuc.setText("");
    }
    
    void insert(){
        VoucherHd vhd = getformData();
        if(vhd != null){
            VHDser.add(vhd);         
            fillTable();           
            clear();
            JOptionPane.showMessageDialog(this, "Thêm thành công");
        }else{
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }
    
    void delete(){
        VoucherHd vhd = VHDser.getAll().get(tblVoucherHD.getSelectedRow());
        String id = txtId.getText();
        try {         
            VHDser.delete(id);
            fillTable();
            clear();        
            JOptionPane.showMessageDialog(this, "Xóa thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
           
            
        }
    void update(){
        VoucherHd vhd = getformData();
        String id = txtId.getText();
        if(vhd != null){
            VHDser.update(vhd, id);
            fillTable();
            clear();
            JOptionPane.showMessageDialog(this, "Sửa thành công");
        }else{
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
    }
    
    void setFormData(VoucherHd vhd){
        txtId.setText(vhd.getId());
        txtMoTa.setText(vhd.getMoTa());
//        txtNgayApDung.setText();
    }
    
    void fillToForm(){
        try {
            String id = (String) tblVoucherHD.getValueAt(index, 0);
            VoucherHd vhd = VHDser.getById(id);
            if (vhd != null) {
                setFormData(vhd);             
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "lỗi");
        }
    }
}
    
    

