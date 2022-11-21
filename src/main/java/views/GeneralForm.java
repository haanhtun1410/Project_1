/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import domainmodels.ChiTietSp;
import domainmodels.Cthd;
import domainmodels.HoaDon;
import domainmodels.KhachHang;
import domainmodels.User;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import responsitory.ChiTietSPRespository;
import responsitory.HDCTRespository;
import responsitory.HDRespository;
import responsitory.KhachHangResponsitory;
import responsitory.NhanVienRespository;
import responsitory.SerialsResponsitory;
import responsitory.impl.ChiTietSPRespositoyImpl;
import responsitory.impl.HDCTRespositoryImpl;
import responsitory.impl.HDRespositoryImpl;
import responsitory.impl.KhachHangResponsitoryImpl;
import responsitory.impl.NhanVienRespositoryImpl;
import responsitory.impl.SerialsResponsitoryImpl;
import services.SellService;
import services.impl.SellServiceImpl;

/**
 *
 * @author longv
 */
public class GeneralForm extends javax.swing.JFrame {

    private final ChiTietSPRespository chiTietSPRespository = new ChiTietSPRespositoyImpl();
    private final HDCTRespository chiTietHDRespository = new HDCTRespositoryImpl();
    private final HDRespository HDRespository = new HDRespositoryImpl();
    private final NhanVienRespository nhanVienRespository = new NhanVienRespositoryImpl();
    private final KhachHangResponsitory khachHangResponsitory = new KhachHangResponsitoryImpl();
    private final SerialsResponsitory serialsResponsitory = new SerialsResponsitoryImpl();
    SellService sv = new SellServiceImpl(chiTietSPRespository, chiTietHDRespository, HDRespository, nhanVienRespository, khachHangResponsitory, serialsResponsitory);
    static int rollnumber = 1;
    static double thanhTien = 0;
    List<HoaDon> listHD = sv.getAllHD();
    private List<User> listNV = sv.getAllNV();
    private List<KhachHang> listKH = sv.getAllKH();
    List<ChiTietSp> listSP = sv.getAllSP();
    static List<ChiTietSp> listSelectedSp = new ArrayList<>();

    /**
     * Creates new form GeneralForm
     */
    public GeneralForm() {
        initComponents();
        GeneralForm.rollnumber = 1;
        loadModel();
        loadKH();
        fillSP();
        fillHD();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btn_taohd = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_hoaDon = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_mahd = new javax.swing.JTextField();
        txt_ngaytao = new javax.swing.JTextField();
        txt_tongtien = new javax.swing.JTextField();
        txt_khachTra = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btn_thanhtoan = new javax.swing.JButton();
        cbo_nv = new javax.swing.JComboBox<>();
        cbo_kh = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btn_rename = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_chiTietSP = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_ChiTietHD = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btn_taohd.setText("Tạo Hóa Đơn");
        btn_taohd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_taohdMouseClicked(evt);
            }
        });
        btn_taohd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taohdActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Chờ thanh toán");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setSelected(true);
        jRadioButton2.setText("Tất cả");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Đã Hủy");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("Đã thanh toán");

        tbl_hoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã HD", "Ngày Tạo", "Tên NV", "Tình Trạng"
            }
        ));
        tbl_hoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_hoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_hoaDon);

        jLabel1.setText("Mã HD");

        jLabel2.setText("Tổng Tiền");

        jLabel3.setText("Tên NV");

        jLabel4.setText("Ngày Tạo");

        txt_mahd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mahdActionPerformed(evt);
            }
        });

        txt_ngaytao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ngaytaoActionPerformed(evt);
            }
        });

        txt_tongtien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tongtienActionPerformed(evt);
            }
        });

        txt_khachTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_khachTraActionPerformed(evt);
            }
        });

        jLabel6.setText("Khách Trả");

        btn_thanhtoan.setText("Thanh Toán");
        btn_thanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thanhtoanActionPerformed(evt);
            }
        });

        cbo_nv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_nv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_nvActionPerformed(evt);
            }
        });

        cbo_kh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_kh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_khActionPerformed(evt);
            }
        });

        jLabel7.setText("Tên KH");

        btn_rename.setText("Clear");
        btn_rename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_renameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel2))
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_khachTra, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_thanhtoan)
                                .addGap(44, 44, 44)
                                .addComponent(btn_rename))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_ngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(24, 24, 24)
                        .addComponent(cbo_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)
                        .addComponent(txt_mahd, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel5)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_mahd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(cbo_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_kh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txt_khachTra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_thanhtoan)
                    .addComponent(btn_rename))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        tbl_chiTietSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Năm Sản Xuất", "Mô Tả", "Năm BH", "SL SP", "Giá Bán"
            }
        ));
        tbl_chiTietSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_chiTietSPMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_chiTietSP);
        if (tbl_chiTietSP.getColumnModel().getColumnCount() > 0) {
            tbl_chiTietSP.getColumnModel().getColumn(3).setResizable(false);
            tbl_chiTietSP.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        tbl_ChiTietHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Số Lượng", "Đơn Giá", "Thành Tiền"
            }
        ));
        jScrollPane3.setViewportView(tbl_ChiTietHD);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_taohd)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jRadioButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton4))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_taohd)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_taohdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taohdActionPerformed
        if (sv.addHD(createTempHD())) {
            JOptionPane.showMessageDialog(this, "Thành công");
            this.fillHD();
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Mã hóa đơn đã tồn tại");
        }

    }//GEN-LAST:event_btn_taohdActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void txt_mahdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mahdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_mahdActionPerformed

    private void txt_ngaytaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ngaytaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ngaytaoActionPerformed

    private void txt_tongtienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tongtienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tongtienActionPerformed

    private void txt_khachTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_khachTraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_khachTraActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setLocationRelativeTo(null);
    }//GEN-LAST:event_formWindowOpened

    private void tbl_hoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_hoaDonMouseClicked
        clearForm();
        if (listHD.get(getSelectedRow()).getTinhTrang() == 0) {
            cbo_nv.setEnabled(true);
            cbo_kh.setEnabled(true);
        }
        if (getSelectedRow() < 0) {
            return;
        }
        fillTextField();

    }//GEN-LAST:event_tbl_hoaDonMouseClicked

    private void tbl_chiTietSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_chiTietSPMouseClicked

        if (getSelectedRow() < 0) {
            return;
        }
        if (getHD().getTinhTrang() == 1) {
            return;
        }
        fillSPtoHDCT();
    }//GEN-LAST:event_tbl_chiTietSPMouseClicked

    private void btn_thanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thanhtoanActionPerformed
        HoaDon hoaDonn = getHD();
        hoaDonn.setUser((User) cbo_nv.getSelectedItem());
        hoaDonn.setKhachHang((KhachHang) cbo_kh.getSelectedItem());
        System.out.println(hoaDonn);
        if (hoaDonn.getTinhTrang() == 1) {
            JOptionPane.showMessageDialog(this, "Hoa don nay da duoc thanh toan!");
            return;
        }
        if (Double.valueOf(txt_khachTra.getText()) >= Double.valueOf(txt_tongtien.getText())) {
            hoaDonn.setTinhTrang(1);
        } else {
            hoaDonn.setTinhTrang(0);
            JOptionPane.showMessageDialog(this, "Không đủ tiền");
            return;
        }

        for (int i = 0; i < listSelectedSp.size(); i++) {
            ChiTietSp sp = listSelectedSp.get(i);
            String idCTHD = hoaDonn.getId() + String.valueOf(i + 1);
            System.out.println(idCTHD);
            Cthd hdct = new Cthd(idCTHD, sp, hoaDonn, (int) tbl_ChiTietHD.getValueAt(i, 3), sp.getGiaBan(), (double) tbl_ChiTietHD.getValueAt(i, 5));
            if (sv.addHDCT(hdct)) {
                System.out.println("added : " + hdct.toString());
            }
            sv.updateSerials(hdct);
            sv.updateSLSP(sp.getId());
            fillSP();
        }
        hoaDonn.setTinhTrang(1);
        if (sv.updateHD(hoaDonn)) {
            JOptionPane.showMessageDialog(this, "Thanh Cong");
            fillHD();
        } else {
            JOptionPane.showMessageDialog(this, "that bai");
        }
        this.fillHD();
        this.clearForm();

    }//GEN-LAST:event_btn_thanhtoanActionPerformed

    private void cbo_nvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_nvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_nvActionPerformed

    private void cbo_khActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_khActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_khActionPerformed

    private void btn_taohdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_taohdMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_taohdMouseClicked

    private void btn_renameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_renameActionPerformed
        // TODO add your handling code here:
        clearForm();
        txt_mahd.setEnabled(true);
        txt_ngaytao.setEnabled(true);

    }//GEN-LAST:event_btn_renameActionPerformed

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
            java.util.logging.Logger.getLogger(GeneralForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GeneralForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GeneralForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GeneralForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GeneralForm().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_rename;
    private javax.swing.JButton btn_taohd;
    private javax.swing.JButton btn_thanhtoan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbo_kh;
    private javax.swing.JComboBox<String> cbo_nv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbl_ChiTietHD;
    private javax.swing.JTable tbl_chiTietSP;
    private javax.swing.JTable tbl_hoaDon;
    private javax.swing.JTextField txt_khachTra;
    private javax.swing.JTextField txt_mahd;
    private javax.swing.JTextField txt_ngaytao;
    private javax.swing.JTextField txt_tongtien;
    // End of variables declaration//GEN-END:variables

    private void fillSP() {
        listSP = sv.getAllSP();
        DefaultTableModel dtm = (DefaultTableModel) tbl_chiTietSP.getModel();
        dtm.setRowCount(0);
        int i = 1;
        for (ChiTietSp x : listSP) {
            Object[] data = new Object[]{
                i++, x.getId(), x.getTenSp(), x.getNamSx(), x.getMoTa(), x.getNamBh(), x.getSoLuongTon(), x.getGiaBan()
            };
            dtm.addRow(data);
        }
    }

    private void loadKH() {
        cbo_kh.removeAllItems();
        DefaultComboBoxModel dcm = (DefaultComboBoxModel) cbo_kh.getModel();
        listKH = sv.getAllKH();
        listKH.forEach(e -> dcm.addElement(e));
    }

    private void loadModel() {
        cbo_nv.removeAllItems();
        DefaultComboBoxModel dcm = (DefaultComboBoxModel) cbo_nv.getModel();
        listNV = sv.getAllNV();
        listNV.forEach(e -> dcm.addElement(e));
    }
//fill hoa don

    private void fillHD() {
        DefaultTableModel dtm = (DefaultTableModel) tbl_hoaDon.getModel();
        dtm.setRowCount(0);
        listHD = sv.getAllHD();
        int i = 1;
        for (HoaDon x : listHD) {
            String tenNV;
            if (x.getUser() != null) {
                tenNV = x.getUser().getTen();
            } else {
                tenNV = "";
            }
            String tinhtrang = x.getTinhTrang() == 0 ? "chưa xong" : "đã xong";
            Object[] data = new Object[]{
                i++, x.getId(), x.getNgayTao(), tenNV, tinhtrang
            };
            dtm.addRow(data);
        }
    }

    private int getSelectedRow() {
        return tbl_hoaDon.getSelectedRow();
    }

    private int getSelectedSPRow() {
        return tbl_chiTietSP.getSelectedRow();
    }

    private HoaDon createTempHD() {
        return new HoaDon(txt_mahd.getText(), new Date(System.currentTimeMillis()));
    }

    void fillSPtoHDCT() {
        int tong = 0;
        int selectedRow = getSelectedSPRow();
        if (selectedRow < 0) {
            return;
        }
        ChiTietSp chiTietSp = listSP.get(getSelectedSPRow());
        DefaultTableModel dtm = (DefaultTableModel) tbl_ChiTietHD.getModel();
        if (dtm.getRowCount() == 0 || !isExist(selectedRow)) {
            Object[] data = new Object[]{
                rollnumber++, chiTietSp.getId(), chiTietSp.getTenSp(), 1, chiTietSp.getGiaBan(), chiTietSp.getGiaBan()};
            dtm.addRow(data);
            listSelectedSp.add(chiTietSp);
            System.out.println("addded");
            System.out.println(listSelectedSp.size());
        } else {
            for (int i = 0; i < dtm.getRowCount(); i++) {
                int soluong = Integer.valueOf(dtm.getValueAt(i, 3).toString()) + 1;

                if (chiTietSp.getId().equalsIgnoreCase(dtm.getValueAt(i, 1).toString())) {
                    if (soluong > chiTietSp.getSoLuongTon()) {
                        JOptionPane.showMessageDialog(this, "vuot qua so hang");
                        return;
                    }
                    dtm.setValueAt(soluong, i, 3);
                    dtm.setValueAt(Double.valueOf(dtm.getValueAt(i, 3).toString()) * chiTietSp.getGiaBan(), i, 5);
                    break;
                }
            }
        }
        for (int i = 0; i < dtm.getRowCount(); i++) {
            tong += Integer.valueOf(dtm.getValueAt(i, 3).toString()) * Double.valueOf(dtm.getValueAt(i, 4).toString());
        }
        txt_tongtien.setText(String.valueOf(tong));
    }

    private void fillTextField() {
        HoaDon hd = getHD();
        if (hd.getTinhTrang() == 1) {
            txt_mahd.setEnabled(false);
            txt_ngaytao.setEnabled(false);
            cbo_nv.setEnabled(false);
            btn_thanhtoan.setEnabled(false);
            cbo_kh.setEnabled(false);
            fillHDCT();
        }
        txt_mahd.setText(hd.getId());
        txt_ngaytao.setText(hd.getNgayTao().toString());
        cbo_nv.setSelectedItem(hd.getUser());
        cbo_kh.setSelectedItem(hd.getKhachHang());

        sv.getHDCTofHD(hd).forEach(e -> thanhTien += e.getThanhTien());
        txt_tongtien.setText("" + thanhTien);

    }

    private void setEditable() {
        txt_mahd.setEnabled(true);
        txt_ngaytao.setEnabled(true);
        btn_thanhtoan.setEnabled(true);
        btn_thanhtoan.setEnabled(true);
        cbo_kh.setEnabled(true);
        cbo_nv.setEnabled(true);
        rollnumber = 1;
    }

    private HoaDon getHD() {
        HoaDon hd = listHD.get(getSelectedRow());
        return hd;
    }

    private void fillHDCT() {
        DefaultTableModel dtm = (DefaultTableModel) tbl_ChiTietHD.getModel();
        int i = 1;
        dtm.setRowCount(0);
        for (Cthd x : sv.getHDCTofHD(getHD())) {
            Object[] data = new Object[]{
                i++, x.getChiTietSp().getId(), x.getChiTietSp().getTenSp(), x.getSoLuong(), x.getChiTietSp().getGiaBan(), x.getThanhTien()
            };
            dtm.addRow(data);
        }
    }

    private void clearForm() {
        txt_khachTra.setText("");
        txt_mahd.setText("");
        txt_ngaytao.setText("");
        txt_tongtien.setText("");
        DefaultTableModel dtm = (DefaultTableModel) tbl_ChiTietHD.getModel();
        dtm.setRowCount(0);
        thanhTien = 0;
        listSelectedSp.removeAll(listSelectedSp);
        setEditable();

    }

    private boolean isExist(int selectedRow) {
        DefaultTableModel dtm = (DefaultTableModel) tbl_ChiTietHD.getModel();
        ChiTietSp chiTietSp = listSP.get(selectedRow);
        for (int i = 0; i < tbl_ChiTietHD.getRowCount(); i++) {
            if (chiTietSp.getId().equalsIgnoreCase(dtm.getValueAt(i, 1).toString())) {
                System.out.println(dtm.getValueAt(i, 1).toString() + "  IS EXIST");
                return true;
            }
        }
        return false;
    }

}
