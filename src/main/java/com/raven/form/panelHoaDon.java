/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

import customModels.ImeiCustom;
import domainmodels.ChiTietSp;
import domainmodels.Cthd;
import domainmodels.HoaDon;
import domainmodels.Serial;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import responsitory.ChiTietSPRespository;
import responsitory.HDCTRespository;
import responsitory.HDRespository;
import responsitory.SerialsResponsitory;
import responsitory.impl.ChiTietSPRespositoyImpl;
import responsitory.impl.HDCTRespositoryImpl;
import responsitory.impl.HDRespositoryImpl;
import responsitory.impl.SerialsResponsitoryImpl;
import services.HoaDonServices;
import services.impl.HoaDonServicesImpl;

/**
 *
 * @author longv
 */
public class panelHoaDon extends javax.swing.JPanel {

    private final ChiTietSPRespository chiTietSPRespository = new ChiTietSPRespositoyImpl();
    private final HDCTRespository chiTietHDRespository = new HDCTRespositoryImpl();
    private final HDRespository HDRespository = new HDRespositoryImpl();
    private final SerialsResponsitory serialsResponsitory = new SerialsResponsitoryImpl();
    HoaDonServices sv = new HoaDonServicesImpl(chiTietSPRespository, chiTietHDRespository, HDRespository, serialsResponsitory);
    private List<HoaDon> listHD = sv.getAllHD();
    private List<Cthd> listCthds;
    private List<Serial> listImei;
    List<HoaDon> listHDFind = new ArrayList<>();

    /**
     * Creates new form panelHoaDon
     */
    public panelHoaDon() {
        initComponents();
        listHDFind = listHD;
        fillHD(listHD);
        Date date = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24 * 2);
        jdc_from.setDate(date);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel2 = new com.raven.swing.RoundPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_hoaDon = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_ChiTietHD = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_imei = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txt_timKiem = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        cbo_phanLoai = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jdc_to = new com.toedter.calendar.JDateChooser();
        jdc_from = new com.toedter.calendar.JDateChooser();
        cbo_trangThai = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_doitra = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1550, 925));

        roundPanel2.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel2.setPreferredSize(new java.awt.Dimension(1080, 600));

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(220, 220, 220));
        jLabel6.setText("Tìm kiếm hóa đơn :");
        jLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        tbl_hoaDon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbl_hoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HĐ", "Khách Hàng", "Nhân Viên", "Ngày tạo", "Ngày vận chuyển", "ngày nhận", "Ngày thanh toán", "Địa chỉ", "Voucher", "Tổng tiền", "Tên người nhận", "SĐT", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, false, false, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_hoaDon.setDragEnabled(true);
        tbl_hoaDon.setRowHeight(30);
        tbl_hoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_hoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_hoaDon);

        tbl_ChiTietHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Số Lượng", "Đơn Giá", "Thành Tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_ChiTietHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ChiTietHDMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_ChiTietHD);

        tbl_imei.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "                          IMEI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_imei.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_imeiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_imei);
        if (tbl_imei.getColumnModel().getColumnCount() > 0) {
            tbl_imei.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(220, 220, 220));
        jLabel7.setText("HÓA ĐƠN");
        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        txt_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timKiemActionPerformed(evt);
            }
        });
        txt_timKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_timKiemKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_timKiemKeyTyped(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(220, 220, 220));
        jLabel20.setText("Trạng Thái");
        jLabel20.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        cbo_phanLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày tạo", "Ngày vận chuyển", "Ngày thanh toán" }));
        cbo_phanLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_phanLoaiActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(220, 220, 220));
        jLabel21.setText("Từ ");
        jLabel21.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel22.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(220, 220, 220));
        jLabel22.setText("đến");
        jLabel22.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jdc_to.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jdc_toInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        jdc_from.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jdc_fromInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jdc_from.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdc_fromPropertyChange(evt);
            }
        });

        cbo_trangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Trống", "Đã thanh toán", "Chờ thanh toán", "Chờ vận chuyển", "Đang vận chuyển" }));
        cbo_trangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_trangThaiActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(220, 220, 220));
        jLabel23.setText("Lọc");
        jLabel23.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel24.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(220, 220, 220));
        jLabel24.setText("Đổi trả ");
        jLabel24.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        txt_doitra.setColumns(20);
        txt_doitra.setRows(5);
        jScrollPane3.setViewportView(txt_doitra);

        jButton1.setText("Đổi Máy Mới");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3)
                                    .addGroup(roundPanel2Layout.createSequentialGroup()
                                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(771, 771, 771))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbo_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(651, 651, 651))
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addComponent(cbo_phanLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jdc_from, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jdc_to, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(128, 128, 128))))))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(cbo_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_phanLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(jdc_to, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdc_from, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(2, 2, 2)))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(113, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1550, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_ChiTietHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ChiTietHDMouseClicked

        fillImei();

    }//GEN-LAST:event_tbl_ChiTietHDMouseClicked

    private void tbl_hoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_hoaDonMouseClicked
        if (getSelectedHDRow() < 0) {
            return;
        }
        clear();
        HoaDon hd = listHDFind.get(getSelectedHDRow());
        fillHDCT(hd);


    }//GEN-LAST:event_tbl_hoaDonMouseClicked

    private void cbo_phanLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_phanLoaiActionPerformed
        clear();
        System.out.println(cbo_phanLoai.getSelectedIndex());
        findByDate();
    }//GEN-LAST:event_cbo_phanLoaiActionPerformed

    private void cbo_trangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_trangThaiActionPerformed
        clear();
        fillFindByStatus();
    }//GEN-LAST:event_cbo_trangThaiActionPerformed

    private void txt_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_timKiemActionPerformed

    private void txt_timKiemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timKiemKeyTyped

    }//GEN-LAST:event_txt_timKiemKeyTyped

    private void txt_timKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timKiemKeyReleased
        listHDFind.clear();
        String text = txt_timKiem.getText();
        if (text.isEmpty() || text.startsWith(" ")) {
            listHDFind = listHD;
            fillHD(listHDFind);
        } else {
            for (HoaDon hd : listHD) {
                if (hd.getTinhTrang() == 0) {
                    if (hd.getId().toLowerCase().contains(text.toLowerCase())) {
                        listHDFind.add(hd);
                    }
                } else if (hd.getTinhTrang() == 1) {
                    if (hd.getId().toLowerCase().contains(text.toLowerCase()) || hd.getKhachHang().getTen().toLowerCase().contains(text.toLowerCase()) || hd.getSdt().toLowerCase().contains(text.toLowerCase())) {
                        listHDFind.add(hd);
                    } else {
                        if (hd.getId().toLowerCase().contains(text.toLowerCase()) || hd.getKhachHang().getTen().toLowerCase().contains(text.toLowerCase())) {
                            listHDFind.add(hd);
                        }
                    }

                }
                fillHD(listHDFind);
            }
        }
    }//GEN-LAST:event_txt_timKiemKeyReleased

    private void jdc_fromInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jdc_fromInputMethodTextChanged
        System.out.println("to change");
        clear();
        findByDate();
    }//GEN-LAST:event_jdc_fromInputMethodTextChanged

    private void jdc_toInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jdc_toInputMethodTextChanged
        System.out.println("from change");
        clear();
        findByDate();
    }//GEN-LAST:event_jdc_toInputMethodTextChanged

    private void jdc_fromPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdc_fromPropertyChange
        System.out.println("to change");
        clear();
        findByDate();
    }//GEN-LAST:event_jdc_fromPropertyChange

    private void tbl_imeiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_imeiMouseClicked
        return;
    }//GEN-LAST:event_tbl_imeiMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (tbl_imei.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Hãy chọn 1 imei");

            return;
        }
        if (txt_doitra.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền lý do");
            return;
        }
        System.out.println(tbl_imei.getValueAt(tbl_imei.getSelectedRow(), 0).toString());
        if (sv.DoiTra(tbl_imei.getValueAt(tbl_imei.getSelectedRow(), 0).toString())) {
            JOptionPane.showMessageDialog(this, "Đổi thành công");
        }
        clear();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbo_phanLoai;
    private javax.swing.JComboBox<String> cbo_trangThai;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private com.toedter.calendar.JDateChooser jdc_from;
    private com.toedter.calendar.JDateChooser jdc_to;
    private com.raven.swing.RoundPanel roundPanel2;
    private javax.swing.JTable tbl_ChiTietHD;
    private javax.swing.JTable tbl_hoaDon;
    private javax.swing.JTable tbl_imei;
    private javax.swing.JTextArea txt_doitra;
    private javax.swing.JTextField txt_timKiem;
    // End of variables declaration//GEN-END:variables

    private void fillHD(List<HoaDon> listHDF) {
        listHD = sv.getAllHD();
        DefaultTableModel dtm = (DefaultTableModel) tbl_hoaDon.getModel();
        dtm.setRowCount(0);
        int i = 1;
        for (HoaDon x : listHDF) {
            String voucherr = x.getVoucherHd() == null ? "Không áp dụng" : x.getVoucherHd().getId();
            Object[] data = new Object[]{
                x.getId(), x.getKhachHang(), x.getUser(),
                x.getNgayTao(), x.getNgayShip(), x.getNgayNhan(), x.getNgayThanhToan(), x.getDiaChi(), voucherr, x.getTongTien(), x.getTenNguoiNhan(), x.getSdt(), getTinhTrang(x.getTinhTrang())
            };
            dtm.addRow(data);
        }
    }

    private String getTinhTrang(int tt) {
        String tinhTrang;
        switch (tt) {
            case 0:
                tinhTrang = "Trống";
                break;
            case 1:
                tinhTrang = "Đã thanh toán";
                break;
            case 2:
                tinhTrang = "Chờ thanh toán";
                break;
            case 3:
                tinhTrang = "Chờ vận chuyển";
                break;
            default:
                tinhTrang = "Đang vận chuyển";
                break;
        }
        return tinhTrang;
    }

    private int getSelectedHDRow() {
        return tbl_hoaDon.getSelectedRow();
    }

    private void fillHDCT(HoaDon hoaDon) {
        DefaultTableModel dtm = (DefaultTableModel) tbl_ChiTietHD.getModel();
        int i = 1;
        dtm.setRowCount(0);
        for (Cthd x : sv.getHDCTofHD(hoaDon)) {
            Object[] data = new Object[]{
                i++, x.getChiTietSp().getId(), x.getChiTietSp().getTenSp(), x.getSoLuong(), x.getChiTietSp().getGiaBan(), x.getThanhTien()
            };
            dtm.addRow(data);
        }
    }

    private void fillImei() {

        listCthds = sv.getHDCTofHD(getHD());
        Cthd cthd = listCthds.get(tbl_ChiTietHD.getSelectedRow());
        System.out.println(cthd.getId());
        listImei = sv.getImeis(cthd.getId());
        DefaultTableModel dtm = (DefaultTableModel) tbl_imei.getModel();
        dtm.setRowCount(0);
        listHD = sv.getAllHD();
        listImei.forEach(e -> dtm.addRow(new Object[]{e.getImei()}));
    }

    private HoaDon getHD() {
        return listHD.get(getSelectedHDRow());
    }

    private void clear() {
        DefaultTableModel dtm = (DefaultTableModel) tbl_imei.getModel();
        dtm.setRowCount(0);
        DefaultTableModel dtm2 = (DefaultTableModel) tbl_ChiTietHD.getModel();
        dtm.setRowCount(0);
        txt_doitra.setText("");
    }

    private void fillFindByStatus() {
        listHDFind.clear();
        int status = cbo_trangThai.getSelectedIndex();
        if (status == 0) {
            listHDFind = listHD;
            fillHD(listHDFind);
        } else {
            for (HoaDon hoaDon : listHD) {
                if (hoaDon.getTinhTrang() == (status - 1)) {
                    listHDFind.add(hoaDon);
                }
            }
            fillHD(listHDFind);
        }
    }

    private void findByDate() {
        listHDFind.clear();
        int status = cbo_phanLoai.getSelectedIndex();
        Date dateFrom = new java.sql.Date(jdc_from.getDate().getTime());
        Date dateTo = new java.sql.Date(jdc_to.getDate().getTime());
        switch (status) {
            case 0:
                for (HoaDon hoaDon : listHD) {
                    if (hoaDon.getNgayTao().after(dateFrom) && hoaDon.getNgayTao().before(dateTo)) {
                        listHDFind.add(hoaDon);
                    }
                }
                fillHD(listHDFind);
                break;
            case 1:
                for (HoaDon hoaDon : listHD) {
                    if (hoaDon.getTinhTrang() == 4 && hoaDon.getNgayShip().after(dateFrom) && hoaDon.getNgayShip().before(dateTo) && !hoaDon.getDiaChi().contains("a hàng")) {
                        listHDFind.add(hoaDon);
                    }
                }
                fillHD(listHDFind);
                break;
            case 2:
                for (HoaDon hoaDon : listHD) {
                    if (hoaDon.getTinhTrang() == 1 && hoaDon.getNgayThanhToan().after(dateFrom) && hoaDon.getNgayThanhToan().before(dateTo)) {
                        listHDFind.add(hoaDon);
                    }
                }
                fillHD(listHDFind);
                break;
            default:
                break;
        }
    }
}
