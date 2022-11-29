/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

import customModels.ImeiCustom;
import domainmodels.Cthd;
import domainmodels.HoaDon;
import domainmodels.Serial;
import java.util.List;
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

    /**
     * Creates new form panelHoaDon
     */
    public panelHoaDon() {
        initComponents();
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

        roundPanel2 = new com.raven.swing.RoundPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_hoaDon = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_ChiTietHD = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_imei = new javax.swing.JTable();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1550, 925));

        roundPanel2.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel2.setPreferredSize(new java.awt.Dimension(1080, 600));

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(220, 220, 220));
        jLabel6.setText("HÓA ĐƠN");
        jLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        tbl_hoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HĐ", "Khách Hàng", "Nhân Viên", "Ngày tạo", "Ngày thanh toán", "Voucher", "Tổng tiền", "Tên người nhận", "Địa chỉ", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
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
        jScrollPane2.setViewportView(tbl_imei);
        if (tbl_imei.getColumnModel().getColumnCount() > 0) {
            tbl_imei.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 1530, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(87, 87, 87)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(121, Short.MAX_VALUE))
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
        HoaDon hd = listHD.get(getSelectedHDRow());
        fillHDCT(hd);
        if (getSelectedHDRow() < 0) {
            return;
        }

    }//GEN-LAST:event_tbl_hoaDonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private com.raven.swing.RoundPanel roundPanel2;
    private javax.swing.JTable tbl_ChiTietHD;
    private javax.swing.JTable tbl_hoaDon;
    private javax.swing.JTable tbl_imei;
    // End of variables declaration//GEN-END:variables

    private void fillHD() {
        DefaultTableModel dtm = (DefaultTableModel) tbl_hoaDon.getModel();
        dtm.setRowCount(0);
        listHD = sv.getAllHD();
        int i = 1;
        for (HoaDon x : listHD) {
            Object[] data = new Object[]{
                x.getId(), x.getKhachHang(), x.getUser(),
                x.getNgayTao(), x.getNgayThanhToan(), x.getVoucherHd(), x.getTongTien(), x.getTenNguoiNhan(), x.getDiaChi(), x.getTinhTrang()
            };
            dtm.addRow(data);
        }
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
}
