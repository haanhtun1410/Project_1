package com.raven.form;

import domainmodels.Laptop;
import domainmodels.ThongKeNSX;
import domainmodels.VCLTandDong;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.LaptopSe;
import services.impl.LaptopSeImpl;

public class FormSanPham extends javax.swing.JPanel {

    private List<Laptop> listLaptop = new ArrayList<>();
    private DefaultTableModel dtm = new DefaultTableModel();
    private LaptopSe lapTopSe = new LaptopSeImpl();
    private List<ThongKeNSX> listNSX = new ArrayList<>();
    private List<VCLTandDong> listVCLTandDong = new ArrayList<>();
    private DefaultComboBoxModel dccbNSX = new DefaultComboBoxModel();
    private DefaultComboBoxModel dccbDongLT = new DefaultComboBoxModel();
    private DefaultComboBoxModel dccbVoucher = new DefaultComboBoxModel();
    private DefaultComboBoxModel dccbLocNSX = new DefaultComboBoxModel();
    private DefaultComboBoxModel dccbLocDongSP = new DefaultComboBoxModel();

    public FormSanPham() {
        initComponents();
        setOpaque(false);
        listLaptop = lapTopSe.getAll();
        fillTable();
        fillCBBtenNSX();
        fillCBBtenDongLT();
        fillCBBVoucheLT();
        showDataTable();
        fillCBBLoctenNSX();
        fillCBBLoctenDongLT();
    }

    private void fillTable() {
        tblLaptop.setModel(dtm);
        String header[] = {"STT", "ID Laptop","TÊN LAPTOP", "Tên NSX", "Tên DòngLT",
            "Tên Voucher", "Năm SX", "Năm BH", "Mô tả", "SL Tồn", "Giá Bán", "Ảnh", "Trạng Thái"};
        dtm.setColumnIdentifiers(header);
    }

    private void fillCBBtenNSX() {
        listNSX = lapTopSe.getNSX();
        cbbNSX.setModel(dccbNSX);
        for (ThongKeNSX x : listNSX) {
            dccbNSX.addElement(x.getTenNSX());
        }
    }

    private void fillCBBLoctenNSX() {
        listNSX = lapTopSe.getNSX();
        cbbLocNSX.setModel(dccbLocNSX);
        dccbLocNSX.addElement("Tất cả");
        cbbLocNSX.setSelectedItem("Tất cả");
        for (ThongKeNSX x : listNSX) {
            dccbLocNSX.addElement(x.getTenNSX());
        }
    }

    private void fillCBBtenDongLT() {
        listVCLTandDong = lapTopSe.getDongLT();
        cbbDongLT.setModel(dccbDongLT);
        for (VCLTandDong x : listVCLTandDong) {
            dccbDongLT.addElement(x.getTenDongLt());
        }
    }

    private void fillCBBLoctenDongLT() {
        listVCLTandDong = lapTopSe.getDongLT();
        cbbLocDongLaptop.setModel(dccbLocDongSP);
        dccbLocDongSP.addElement("Tất cả");
        dccbLocDongSP.setSelectedItem("Tất cả");
        for (VCLTandDong x : listVCLTandDong) {
            dccbLocDongSP.addElement(x.getTenDongLt());
        }
    }

    private void fillCBBVoucheLT() {
        listVCLTandDong = lapTopSe.getVCLT();
        cbbVoucherLT.setModel(dccbVoucher);
        dccbVoucher.addElement("Không Voucher");
        for (VCLTandDong x : listVCLTandDong) {
            dccbVoucher.addElement(x.getTenVoucher());
        }
    }

    private void showDataTable() {
        dtm = (DefaultTableModel) tblLaptop.getModel();
        dtm.setRowCount(0);
        int i = 1;
        for (Laptop x : listLaptop) {
            dtm.addRow(new Object[]{
                i++, x.getIdLaptop(),x.getTenLaptop(), lapTopSe.getNameNSXByID(x.getIdNSX()), lapTopSe.getNameDongLTByID(x.getIdDongSP()),
                lapTopSe.getNameVoucherByID(x.getIdVoucher()), x.getNamSX(), x.getNamBH(), x.getMoTa(), x.getSoLuongTon(),
                x.getGiaBan(), x.getAnh(), x.getTrangThai()
            });
        }
    }

    private void clearData() {
        txtGiaBan.setText(null);
        txtGiaMin.setText(null);
        txtID.setText(null);
        txtMoTa.setText(null);
        txtSLTon.setText(null);
        txtSearch.setText(null);
        txtTenLapTop.setText(null);
        namBH.setYear(2022);
        namSX.setYear(2022);
        cbbDongLT.setSelectedIndex(0);
        cbbLocDongLaptop.setSelectedIndex(0);
        cbbLocNSX.setSelectedIndex(0);
        cbbNSX.setSelectedIndex(0);
        cbbVoucherLT.setSelectedIndex(0);
        radioConHang.setSelected(true);
    }

    private boolean checkTrungID(String id) {
        boolean check = false;
        for (Laptop x : listLaptop) {
            if (x.getIdLaptop().contains(id)) {
                check = true;
            }
        }
        return check;
    }

    private String getUrlImage() {
        JFileChooser jfc = new JFileChooser("H:");
        jfc.showOpenDialog(null);
        File file = jfc.getSelectedFile();
        Image img = null;
        try {
            img = ImageIO.read(file);
        } catch (IOException ex) {
            Logger.getLogger(FormSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        fillAnhLaptop.setText("");
        int widght = fillAnhLaptop.getWidth();
        int height = fillAnhLaptop.getHeight();
        fillAnhLaptop.setIcon(new ImageIcon(img.getScaledInstance(widght, height, 0)));
        String s = file.getAbsolutePath().replace("//", "--");
        return s;
    }

    private String urlImage() {
        String tenAnh = null;
        try {
            JFileChooser fc = new JFileChooser();
            int chon = fc.showOpenDialog(null);
            if (chon == 0) {
                tenAnh = fc.getSelectedFile().getPath();
                tenAnh = tenAnh.substring(tenAnh.lastIndexOf("\\") + 1);
            } else {
                JOptionPane.showMessageDialog(this, "Bạn phải chọn ảnh Laptop đi");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi rồi này ");
        }
        return tenAnh;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        roundPanel2 = new com.raven.swing.RoundPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLaptop = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLaptop1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        fillAnhLaptop = new javax.swing.JLabel();
        txtSLTon = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtTenLapTop = new javax.swing.JTextField();
        namBH = new com.toedter.calendar.JYearChooser();
        namSX = new com.toedter.calendar.JYearChooser();
        cbbNSX = new javax.swing.JComboBox<>();
        cbbDongLT = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        radioConHang = new javax.swing.JRadioButton();
        radioHetHang = new javax.swing.JRadioButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        cbbVoucherLT = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        cbbLocDongLaptop = new javax.swing.JComboBox<>();
        cbbLocNSX = new javax.swing.JComboBox<>();
        locGia = new javax.swing.JComboBox<>();
        txtGiaMax = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtGiaMin = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        year = new com.toedter.calendar.JYearChooser();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnUPdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1550, 925));

        roundPanel2.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel2.setPreferredSize(new java.awt.Dimension(1080, 600));

        jTabbedPane1.setBackground(new java.awt.Color(51, 51, 51));
        jTabbedPane1.setAlignmentX(0.0F);
        jTabbedPane1.setAlignmentY(0.0F);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/250x30.png"))); // NOI18N
        jPanel3.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        btnSearch.setBackground(new java.awt.Color(51, 51, 51));
        btnSearch.setForeground(new java.awt.Color(51, 51, 51));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1search.png"))); // NOI18N
        btnSearch.setAlignmentY(0.0F);
        btnSearch.setBorder(null);
        btnSearch.setBorderPainted(false);
        btnSearch.setContentAreaFilled(false);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel3.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 40, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tìm kiếm :");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/400x100ver2.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 400, 110));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setAlignmentX(0.0F);
        jPanel4.setAlignmentY(0.0F);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Danh sách Laptop :");
        jPanel4.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        tblLaptop.setBackground(new java.awt.Color(51, 51, 51));
        tblLaptop.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblLaptop.setForeground(new java.awt.Color(255, 255, 255));
        tblLaptop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "null", "null", "Title 7", "Title 8"
            }
        ));
        tblLaptop.setGridColor(new java.awt.Color(0, 0, 0));
        tblLaptop.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tblLaptop.setSelectionForeground(new java.awt.Color(51, 51, 51));
        tblLaptop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLaptopMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLaptop);
        if (tblLaptop.getColumnModel().getColumnCount() > 0) {
            tblLaptop.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 1110, 440));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1130x500.png"))); // NOI18N
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        tblLaptop1.setBackground(new java.awt.Color(51, 51, 51));
        tblLaptop1.setForeground(new java.awt.Color(255, 255, 255));
        tblLaptop1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "null", "null", "Title 7", "Title 8"
            }
        ));
        tblLaptop1.setGridColor(new java.awt.Color(0, 0, 0));
        tblLaptop1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tblLaptop1.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jScrollPane2.setViewportView(tblLaptop1);
        if (tblLaptop1.getColumnModel().getColumnCount() > 0) {
            tblLaptop1.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 1110, 400));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("THÔNG TIN LAPTOP");

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fillAnhLaptop.setAlignmentY(0.0F);
        jPanel5.add(fillAnhLaptop, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 230, 240));

        txtSLTon.setAlignmentX(0.0F);
        txtSLTon.setAlignmentY(0.0F);
        txtSLTon.setBorder(null);
        jPanel5.add(txtSLTon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 180, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/250x250.png"))); // NOI18N
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 260, 260));

        txtGiaBan.setAlignmentX(0.0F);
        txtGiaBan.setAlignmentY(0.0F);
        txtGiaBan.setAutoscrolls(false);
        txtGiaBan.setBorder(null);
        jPanel5.add(txtGiaBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 180, 30));

        txtID.setAlignmentX(0.0F);
        txtID.setAlignmentY(0.0F);
        txtID.setAutoscrolls(false);
        txtID.setBorder(null);
        jPanel5.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 180, 30));

        txtTenLapTop.setAlignmentX(0.0F);
        txtTenLapTop.setAlignmentY(0.0F);
        txtTenLapTop.setAutoscrolls(false);
        txtTenLapTop.setBorder(null);
        jPanel5.add(txtTenLapTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 180, 30));

        namBH.setBackground(new java.awt.Color(255, 255, 255));
        namBH.setAlignmentX(0.0F);
        namBH.setAlignmentY(0.0F);
        namBH.setDoubleBuffered(false);
        jPanel5.add(namBH, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 80, 35));

        namSX.setBackground(new java.awt.Color(255, 255, 255));
        namSX.setAlignmentX(0.0F);
        namSX.setAlignmentY(0.0F);
        namSX.setDoubleBuffered(false);
        jPanel5.add(namSX, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 80, 35));

        cbbNSX.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cbbNSX.setAlignmentX(0.0F);
        cbbNSX.setAlignmentY(0.0F);
        cbbNSX.setBorder(null);
        cbbNSX.setFocusable(false);
        jPanel5.add(cbbNSX, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 190, 30));

        cbbDongLT.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cbbDongLT.setAlignmentX(0.0F);
        cbbDongLT.setAlignmentY(0.0F);
        cbbDongLT.setBorder(null);
        cbbDongLT.setFocusable(false);
        jPanel5.add(cbbDongLT, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 530, 190, 30));

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tên Laptop :");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/200x30.png"))); // NOI18N
        jLabel11.setAlignmentY(0.0F);
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("ID Laptop :");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/200x30.png"))); // NOI18N
        jLabel12.setAlignmentY(0.0F);
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Số lượng tồn :");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/200x30.png"))); // NOI18N
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/200x30.png"))); // NOI18N
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Giá Bán :");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Năm sản xuất :");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1text100x35.png"))); // NOI18N
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Năm bảo hành :");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 420, -1, -1));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1text100x35.png"))); // NOI18N
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 450, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Nhà sản xuất :");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, -1, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Dòng Laptop :");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 500, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Trạng thái :");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 630, -1, -1));

        buttonGroup1.add(radioConHang);
        radioConHang.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        radioConHang.setForeground(new java.awt.Color(255, 255, 255));
        radioConHang.setSelected(true);
        radioConHang.setText("Còn Hàng ");
        radioConHang.setContentAreaFilled(false);
        jPanel5.add(radioConHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 630, -1, -1));

        buttonGroup1.add(radioHetHang);
        radioHetHang.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        radioHetHang.setForeground(new java.awt.Color(255, 255, 255));
        radioHetHang.setText("Hết Hàng");
        radioHetHang.setContentAreaFilled(false);
        jPanel5.add(radioHetHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 630, -1, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Mô tả :");
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 670, -1, -1));

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Voucher Laptop : ");
        jLabel34.setAlignmentY(0.0F);
        jPanel5.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 579, -1, 30));

        cbbVoucherLT.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cbbVoucherLT.setAlignmentX(0.0F);
        cbbVoucherLT.setAlignmentY(0.0F);
        cbbVoucherLT.setBorder(null);
        jPanel5.add(cbbVoucherLT, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 582, 190, 30));

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane4.setViewportView(txtMoTa);

        jPanel5.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 680, 350, 90));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/475x790.png"))); // NOI18N
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Nhà Sản Xuất :");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, -1, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Lọc LapTop :");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Giá Bán :");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Năm Sản Xuất");
        jPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 60, -1, 30));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Dòng Laptop :");
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 69, -1, 30));

        cbbLocDongLaptop.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cbbLocDongLaptop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cbbLocDongLaptop.setAlignmentX(0.0F);
        cbbLocDongLaptop.setAlignmentY(0.0F);
        cbbLocDongLaptop.setBorder(null);
        cbbLocDongLaptop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocDongLaptopActionPerformed(evt);
            }
        });
        jPanel2.add(cbbLocDongLaptop, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 200, 30));

        cbbLocNSX.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cbbLocNSX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cbbLocNSX.setAlignmentX(0.0F);
        cbbLocNSX.setAlignmentY(0.0F);
        cbbLocNSX.setBorder(null);
        cbbLocNSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocNSXActionPerformed(evt);
            }
        });
        jPanel2.add(cbbLocNSX, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 200, 30));

        locGia.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        locGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Từ thấp lên cao", "Từ cao xuống thấp" }));
        locGia.setAlignmentX(0.0F);
        locGia.setAlignmentY(0.0F);
        locGia.setBorder(null);
        locGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locGiaActionPerformed(evt);
            }
        });
        jPanel2.add(locGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 200, 30));

        txtGiaMax.setAlignmentX(0.0F);
        txtGiaMax.setAlignmentY(0.0F);
        txtGiaMax.setAutoscrolls(false);
        txtGiaMax.setBorder(null);
        jPanel2.add(txtGiaMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 160, 180, 30));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/200x30.png"))); // NOI18N
        jPanel2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 160, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Giá Min :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 169, -1, 20));

        txtGiaMin.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtGiaMin.setAlignmentX(0.0F);
        txtGiaMin.setAlignmentY(0.0F);
        txtGiaMin.setBorder(null);
        jPanel2.add(txtGiaMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 180, 30));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/200x30.png"))); // NOI18N
        jLabel32.setAlignmentY(0.0F);
        jPanel2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, -1, -1));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Giá Max :");
        jPanel2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 160, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1Filter.png"))); // NOI18N
        jButton1.setAlignmentY(0.0F);
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 160, -1, -1));

        year.setBackground(new java.awt.Color(255, 255, 255));
        year.setAlignmentX(0.0F);
        year.setAlignmentY(0.0F);
        year.setDoubleBuffered(false);
        jPanel2.add(year, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 62, 200, 30));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1f.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 50, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1130x270.png"))); // NOI18N
        jLabel5.setAlignmentY(0.0F);
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        btnUPdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1update.png"))); // NOI18N
        btnUPdate.setAlignmentY(0.0F);
        btnUPdate.setAutoscrolls(true);
        btnUPdate.setBorder(null);
        btnUPdate.setBorderPainted(false);
        btnUPdate.setContentAreaFilled(false);
        btnUPdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUPdateActionPerformed(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1add.png"))); // NOI18N
        btnAdd.setAlignmentY(0.0F);
        btnAdd.setAutoscrolls(true);
        btnAdd.setBorder(null);
        btnAdd.setBorderPainted(false);
        btnAdd.setContentAreaFilled(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1delete.png"))); // NOI18N
        btnDelete.setAutoscrolls(true);
        btnDelete.setBorder(null);
        btnDelete.setBorderPainted(false);
        btnDelete.setContentAreaFilled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1clear.png"))); // NOI18N
        btnClear.setAlignmentY(0.0F);
        btnClear.setAutoscrolls(true);
        btnClear.setBorder(null);
        btnClear.setBorderPainted(false);
        btnClear.setContentAreaFilled(false);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(btnClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd)
                        .addGap(78, 78, 78)
                        .addComponent(btnUPdate)
                        .addGap(76, 76, 76)
                        .addComponent(btnDelete)
                        .addGap(158, 158, 158)
                        .addComponent(jLabel6)
                        .addGap(129, 129, 129))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd)
                            .addComponent(btnUPdate)
                            .addComponent(btnDelete)
                            .addComponent(btnClear))
                        .addGap(25, 25, 25)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 58, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản Lý Sản Phẩm", jPanel1);

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1683, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1034, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String tenLaptop = txtTenLapTop.getText();
        String IdLaptop = txtID.getText();
        String SLTon = txtSLTon.getText();
        String gia = txtGiaBan.getText();
        int namSX = this.namSX.getYear();
        int namBH = this.namBH.getYear();
        String nsx = (String) cbbNSX.getSelectedItem();
        String dongLaptop = (String) cbbDongLT.getSelectedItem();
        String voucherLaptop = null;
        int trangThai = 1;
        String moTa = txtMoTa.getText();
        if (IdLaptop.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống ID Laptop bạn ơi !");
        } else if (checkTrungID(IdLaptop)) {
            JOptionPane.showMessageDialog(this, "Đã có ID Laptop rùi nhé ^^");
        } else if (tenLaptop.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Để trống tên Laptop kìa bạn !");
        } else if (SLTon.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sao lại để trống số lượng thế này ToT");
        } else if (!txtSLTon.getText().matches("^\\d+$")) {
            JOptionPane.showMessageDialog(this, "Nhập sai định dạng số rồi bạn ơi");
        } else if (Integer.parseInt(txtSLTon.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Số lượng tồn phải lớn hơn 0 chứ");
        } else if (txtGiaBan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Đừng để trống giá bán chứ");
        } else if (!txtGiaBan.getText().matches("^\\d*\\.\\d+$")) {
            JOptionPane.showMessageDialog(this, "Nhập đúng định dạng tiền bạn ơi");
        } else if (Double.parseDouble(txtGiaBan.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Bạn định cho người mua tiền hở =.=");
        } else if (moTa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nhớ nhập mô tả bạn ơi");
        } else {
            double giaBan = Double.parseDouble(txtGiaBan.getText());
            int sl = Integer.parseInt(SLTon);
            Laptop lt = new Laptop(IdLaptop, tenLaptop, lapTopSe.getIDNSXbyName(nsx), lapTopSe.getIDDongLTbyName(dongLaptop),
                    voucherLaptop, namSX, namBH, moTa, sl, giaBan, urlImage(), trangThai);
            JOptionPane.showMessageDialog(this, lapTopSe.insert(lt));
            listLaptop = lapTopSe.getAll();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearData();
        JOptionPane.showMessageDialog(this, "An DB an C");
    }//GEN-LAST:event_btnClearActionPerformed

    private void cbbLocDongLaptopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocDongLaptopActionPerformed
        if (String.valueOf(cbbLocDongLaptop.getSelectedItem()).contains("Tất cả")) {
            listLaptop = lapTopSe.getAll();
            showDataTable();
        } else {
            String idDongLT = lapTopSe.getIDDongLTbyName((String) cbbLocDongLaptop.getSelectedItem());
            listLaptop = lapTopSe.getDongLT(idDongLT);
            showDataTable();
        }
    }//GEN-LAST:event_cbbLocDongLaptopActionPerformed

    private void cbbLocNSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocNSXActionPerformed
        if (String.valueOf(cbbLocNSX.getSelectedItem()).contains("Tất cả")) {
            listLaptop = lapTopSe.getAll();
            showDataTable();
        } else {
            String idNSX = lapTopSe.getIDNSXbyName((String) cbbLocNSX.getSelectedItem());
            listLaptop = lapTopSe.getNSX(idNSX);
            showDataTable();
        }
    }//GEN-LAST:event_cbbLocNSXActionPerformed

    private void locGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locGiaActionPerformed
        int a = locGia.getSelectedIndex();
        if (a == 1) {
            listLaptop = lapTopSe.getGiaCaoThap();
            showDataTable();
        } else {
            listLaptop = lapTopSe.getGiathapCao();
            showDataTable();
        }
    }//GEN-LAST:event_locGiaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int year = this.year.getYear();
        listLaptop = lapTopSe.getNamSX(year);
        showDataTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        double giaMin = Double.parseDouble(txtGiaMin.getText());
        double giaMax = Double.parseDouble(txtGiaMax.getText());
        listLaptop = lapTopSe.getKhoangGia(giaMin, giaMax);
        showDataTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        String IdLaptop = txtID.getText();
        Laptop lt = new Laptop();
        JOptionPane.showMessageDialog(this, lapTopSe.delete(IdLaptop));
        listLaptop = lapTopSe.getAll();
        showDataTable();

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUPdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUPdateActionPerformed
        String tenLaptop = txtTenLapTop.getText();
        String IdLaptop = txtID.getText();
        String SLTon = txtSLTon.getText();
        String gia = txtGiaBan.getText();
        int namSX = this.namSX.getYear();
        int namBH = this.namBH.getYear();
        String nsx = (String) cbbNSX.getSelectedItem();
        String dongLaptop = (String) cbbDongLT.getSelectedItem();
        String voucherLaptop = null;
        int trangThai = 1;
        String moTa = txtMoTa.getText();
        if (IdLaptop.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống ID Laptop bạn ơi !");
        } else if (checkTrungID(IdLaptop)) {
            JOptionPane.showMessageDialog(this, "Đã có ID Laptop rùi nhé ^^");
        } else if (tenLaptop.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Để trống tên Laptop kìa bạn !");
        } else if (SLTon.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sao lại để trống số lượng thế này ToT");
        } else if (!txtSLTon.getText().matches("^\\d+$")) {
            JOptionPane.showMessageDialog(this, "Nhập sai định dạng số rồi bạn ơi");
        } else if (Integer.parseInt(txtSLTon.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Số lượng tồn phải lớn hơn 0 chứ");
        } else if (txtGiaBan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Đừng để trống giá bán chứ");
        } else if (!txtGiaBan.getText().matches("^\\d*\\.\\d+$")) {
            JOptionPane.showMessageDialog(this, "Nhập đúng định dạng tiền bạn ơi");
        } else if (Double.parseDouble(txtGiaBan.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Bạn định cho người mua tiền hở =.=");
        } else if (moTa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nhớ nhập mô tả bạn ơi");
        } else {
            double giaBan = Double.parseDouble(txtGiaBan.getText());
            int sl = Integer.parseInt(SLTon);
            Laptop lt = new Laptop(tenLaptop, lapTopSe.getIDNSXbyName(nsx), lapTopSe.getIDDongLTbyName(dongLaptop),
                    voucherLaptop, namSX, namBH, moTa, sl, giaBan, urlImage(), trangThai);
            JOptionPane.showMessageDialog(this, lapTopSe.update(IdLaptop, lt));
            listLaptop = lapTopSe.getAll();
            showDataTable();
        }
    }//GEN-LAST:event_btnUPdateActionPerformed

    private void tblLaptopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLaptopMouseClicked
        int row = tblLaptop.getSelectedRow();
        Laptop a = listLaptop.get(row);
        txtID.setText(a.getIdLaptop());
        txtGiaBan.setText(String.valueOf(a.getGiaBan()));
        txtMoTa.setText(a.getMoTa());
        txtSLTon.setText(String.valueOf(a.getSoLuongTon()));
        txtTenLapTop.setText(a.getTenLaptop());
        cbbDongLT.setSelectedItem(lapTopSe.getNameDongLTByID(a.getIdDongSP()));
        cbbNSX.setSelectedItem(lapTopSe.getNameNSXByID(a.getIdNSX()));
        namBH.setYear(a.getNamBH());
        namSX.setYear(a.getNamSX());
        cbbVoucherLT.setSelectedItem(lapTopSe.getNameVoucherByID(a.getIdLaptop()));
        int tt = a.getTrangThai();
        if (tt == 1) {
            radioConHang.setSelected(true);
        } else {
            radioHetHang.setSelected(true);
        }
        String url = a.getAnh()+".png";
        System.out.println(url);
        ImageIcon img = new ImageIcon("src/Image/Image Laptops/" + url);
        int widght = fillAnhLaptop.getWidth();
        int height = fillAnhLaptop.getHeight();
        Image image = img.getImage(); // transform it 
        Image newimg = image.getScaledInstance(widght, height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        img = new ImageIcon(newimg);
        fillAnhLaptop.setIcon(img);
    }//GEN-LAST:event_tblLaptopMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
       String tenLaptop = txtSearch.getText();
       listLaptop = lapTopSe.searchByName(tenLaptop);
       showDataTable();
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUPdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbDongLT;
    private javax.swing.JComboBox<String> cbbLocDongLaptop;
    private javax.swing.JComboBox<String> cbbLocNSX;
    private javax.swing.JComboBox<String> cbbNSX;
    private javax.swing.JComboBox<String> cbbVoucherLT;
    private javax.swing.JLabel fillAnhLaptop;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> locGia;
    private com.toedter.calendar.JYearChooser namBH;
    private com.toedter.calendar.JYearChooser namSX;
    private javax.swing.JRadioButton radioConHang;
    private javax.swing.JRadioButton radioHetHang;
    private com.raven.swing.RoundPanel roundPanel2;
    private javax.swing.JTable tblLaptop;
    private javax.swing.JTable tblLaptop1;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaMax;
    private javax.swing.JTextField txtGiaMin;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtSLTon;
    private javax.swing.JLabel txtSearch;
    private javax.swing.JTextField txtTenLapTop;
    private com.toedter.calendar.JYearChooser year;
    // End of variables declaration//GEN-END:variables
}
