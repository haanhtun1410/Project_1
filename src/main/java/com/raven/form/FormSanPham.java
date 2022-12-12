package com.raven.form;

import com.raven.formPhuKien.CPU;
import com.raven.formPhuKien.CPUForm;
import com.raven.formPhuKien.Display;
import com.raven.formPhuKien.ManHinhForm;
import com.raven.formPhuKien.NSX;
import com.raven.formPhuKien.RAMandRom;
import com.raven.formPhuKien.VGA;
import domainmodels.CPUNhan;
import domainmodels.DisplayNhan;
import domainmodels.Laptop;
import domainmodels.RamRomNhan;
import domainmodels.ThongKeNSX;
import domainmodels.VCLTandDong;
import domainmodels.VGANhan;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import org.apache.poi.ss.usermodel.CellType;
import services.LaptopSe;
import services.LinhKienSe;
import services.impl.LaptopSeImpl;
import services.impl.LinhKienSeImpls;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FormSanPham extends javax.swing.JPanel {

    private List<Laptop> listLaptop = new ArrayList<>();
    private DefaultTableModel dtm = new DefaultTableModel();
    private DefaultTableModel dtmOff = new DefaultTableModel();
    private LaptopSe lapTopSe = new LaptopSeImpl();
    private List<ThongKeNSX> listNSX = new ArrayList<>();
    private List<CPUNhan> listCPU = new ArrayList<>();
    private List<VGANhan> listVGA = new ArrayList<>();
    private List<DisplayNhan> listMH = new ArrayList<>();
    private List<RamRomNhan> listRR = new ArrayList<>();
    private List<VCLTandDong> listVCLTandDong = new ArrayList<>();
    private DefaultComboBoxModel dccbNSX = new DefaultComboBoxModel();
    private DefaultComboBoxModel dccDisplay = new DefaultComboBoxModel();
    private DefaultComboBoxModel dccbCPU = new DefaultComboBoxModel();
    private DefaultComboBoxModel dccbRAMROM = new DefaultComboBoxModel();
    private DefaultComboBoxModel dccbVGA = new DefaultComboBoxModel();
    private DefaultComboBoxModel dccbDongLT = new DefaultComboBoxModel();
    private DefaultComboBoxModel dccbVoucher = new DefaultComboBoxModel();
    private DefaultComboBoxModel dccbLocNSX = new DefaultComboBoxModel();
    private DefaultComboBoxModel dccbLocAVG = new DefaultComboBoxModel();
    private DefaultComboBoxModel dccbLocCPU = new DefaultComboBoxModel();
    private DefaultComboBoxModel dccbLocRR = new DefaultComboBoxModel();
    private DefaultComboBoxModel dccbLocMH = new DefaultComboBoxModel();
    private DefaultComboBoxModel dccbLocDongSP = new DefaultComboBoxModel();
    private LinhKienSe lk = new LinhKienSeImpls();

    public FormSanPham() {
        initComponents();
        setOpaque(false);
        listLaptop = lapTopSe.getAll();
        fillTable();
        fillCBBtenNSX();
        fillCBBtenDongLT();
        fillCBBVoucheLT();
        fillCBBtenCPU();
        fillCBBtenMH();
        fillCBBtenRAMROM();
        fillCBBtenVGA();
        showDataTable();
        fillCBBLoctenNSX();
        fillCBBLoctenDongLT();
        showDataTable2();
        fillTable1();
        fillCBBLoctenAVG();
        fillCBBLoctenCPU();
        fillCBBLoctenMH();
        fillCBBLoctenRR();

    }

    private void fillTable() {
        tblLaptop.setModel(dtm);
        String header[] = {"STT", "Ma Laptop", "TÊN LAPTOP", "Tên NSX", "Tên DòngLT", "CPU", "RAM ROM", "Display", "VGA",
            "Tên Voucher", "Năm SX", "Năm BH", "Mô tả", "SL Tồn", "Giá Bán", "Ảnh", "Trạng Thái"};
        dtm.setColumnIdentifiers(header);
    }

    private void fillCBBtenNSX() {
        listNSX = lapTopSe.getNSX();
        ccbNSX.setModel(dccbNSX);
        for (ThongKeNSX x : listNSX) {
            dccbNSX.addElement(x.getTenNSX());
        }
    }

    private void fillCBBtenCPU() {
        listCPU = lk.getAllCPU();
        cbbCPU.setModel(dccbCPU);
        for (CPUNhan x : listCPU) {
            dccbCPU.addElement(x.getTenCPU());
        }
    }

    private void fillCBBtenMH() {
        listMH = lk.getAllDisplay();
        cbbMH.setModel(dccDisplay);
        for (DisplayNhan x : listMH) {
            dccDisplay.addElement(x.getTenDisplay());
        }
    }

    private void fillCBBtenVGA() {
        listVGA = lk.getAllVGA();
        cbbAVG.setModel(dccbVGA);
        for (VGANhan x : listVGA) {
            dccbVGA.addElement(x.getTenVGA());
        }
    }

    private void fillCBBtenRAMROM() {
        listRR = lk.getAllRR();
        cbbRamRom.setModel(dccbRAMROM);
        for (RamRomNhan x : listRR) {
            dccbRAMROM.addElement(x.getTenRR());
        }
    }

    private void fillCBBLoctenNSX() {
        listNSX = lapTopSe.getNSX();
        cbbLocNSX5.setModel(dccbLocNSX);
        dccbLocNSX.addElement("Tất cả");
        cbbLocNSX5.setSelectedItem("Tất cả");
        for (ThongKeNSX x : listNSX) {
            dccbLocNSX.addElement(x.getTenNSX());
        }
    }

    private void fillCBBtenDongLT() {
        listVCLTandDong = lapTopSe.getDongLT();
        cbbDongLaptop.setModel(dccbDongLT);
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

    private void fillCBBLoctenCPU() {
        listCPU = lk.getAllCPU();
        cbbLocCPU.setModel(dccbLocCPU);
        dccbLocCPU.addElement("Tất cả");
        dccbLocCPU.setSelectedItem("Tất cả");
        for (CPUNhan x : listCPU) {
            dccbLocCPU.addElement(x.getTenCPU());
        }
    }

    private void fillCBBLoctenAVG() {
        listVGA = lk.getAllVGA();
        cbbLocAVG.setModel(dccbLocAVG);
        dccbLocAVG.addElement("Tất cả");
        dccbLocAVG.setSelectedItem("Tất cả");
        for (VGANhan x : listVGA) {
            dccbLocAVG.addElement(x.getTenVGA());
        }
    }

    private void fillCBBLoctenMH() {
        listMH = lk.getAllDisplay();
        cbbLocMH.setModel(dccbLocMH);
        dccbLocMH.addElement("Tất cả");
        dccbLocMH.setSelectedItem("Tất cả");
        for (DisplayNhan x : listMH) {
            dccbLocMH.addElement(x.getTenDisplay());
        }
    }

    private void fillCBBLoctenRR() {
        listRR = lk.getAllRR();
        cbbLocRR.setModel(dccbLocRR);
        dccbLocRR.addElement("Tất cả");
        dccbLocRR.setSelectedItem("Tất cả");
        for (RamRomNhan x : listRR) {
            dccbLocRR.addElement(x.getTenRR());
        }
    }

    private void fillCBBVoucheLT() {
        listVCLTandDong = lapTopSe.getVCLT();
        cbbVoucher.setModel(dccbVoucher);
        dccbVoucher.addElement("Không Voucher");
        for (VCLTandDong x : listVCLTandDong) {
            dccbVoucher.addElement(x.getTenVoucher());
        }
    }

    private void fillTable1() {
        tblLaptop2.setModel(dtmOff);

        String header[] = {"STT", "Ma Laptop", "TÊN LAPTOP", "Tên NSX", "Tên DòngLT", "CPU", "RAM ROM", "Display", "VGA",
            "Tên Voucher", "Năm SX", "Năm BH", "Mô tả", "SL Tồn", "Giá Bán", "Ảnh", "Trạng Thái"};
        dtmOff.setColumnIdentifiers(header);
    }

    private void showDataTable() {

        dtm = (DefaultTableModel) tblLaptop.getModel();
        dtm.setRowCount(0);
        int i = 1;
        for (Laptop x : listLaptop) {
            dtm.addRow(new Object[]{
                i++, x.getIdLaptop(), x.getTenLaptop(), lapTopSe.getNameNSXByID(x.getIdNSX()), lapTopSe.getNameDongLTByID(x.getIdDongSP()),
                lk.getTenCPU(x.getIdCPU()), lk.getTenRamRom(x.getIdRR()), lk.getTenMH(x.getIdMH()), lk.getTenVGA(x.getIdVGA()),
                lapTopSe.getNameVoucherByID(x.getIdVoucher()), x.getNamSX(), x.getNamBH(), x.getMoTa(), x.getSoLuongTon(),
                x.getGiaBan() / 1000000, x.getAnh(), x.getTrangThai()
            });
        }
    }

    private void showDataTable2() {
        listLaptop = lapTopSe.getOne();
        dtmOff = (DefaultTableModel) tblLaptop2.getModel();
        dtmOff.setRowCount(0);
        int i = 1;
        for (Laptop x : listLaptop) {
            dtmOff.addRow(new Object[]{
                i++, x.getIdLaptop(), x.getTenLaptop(), lapTopSe.getNameNSXByID(x.getIdNSX()), lapTopSe.getNameDongLTByID(x.getIdDongSP()),
                lk.getTenCPU(x.getIdCPU()), lk.getTenRamRom(x.getIdRR()), lk.getTenMH(x.getIdMH()), lk.getTenVGA(x.getIdVGA()),
                lapTopSe.getNameVoucherByID(x.getIdVoucher()), x.getNamSX(), x.getNamBH(), x.getMoTa(), x.getSoLuongTon(),
                x.getGiaBan() / 1000000, x.getAnh(), x.getTrangThai()
            });
        }
    }

    private void clearData() {
        txtGiaBan.setText(null);
        txtGiaMin.setText(null);
        txtID.setText(null);
        txtMoTa.setText(null);
        txtSLTon.setText(null);
        txtSearchr.setText(null);
        txtTenLapTop.setText(null);
        namBH.setYear(2022);
        namSX.setYear(2022);
        cbbRamRom.setSelectedIndex(0);
        cbbLocDongLaptop.setSelectedIndex(0);
        cbbLocCPU.setSelectedIndex(0);
        cbbVoucher.setSelectedIndex(0);
        cbbMH.setSelectedIndex(0);
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

    private String urlImage() {
        String tenAnh = null;
        try {
            JFileChooser fc = new JFileChooser();
            int chon = fc.showOpenDialog(null);
            if (chon == 0) {
                tenAnh = fc.getSelectedFile().getPath();
                tenAnh = tenAnh.substring(tenAnh.lastIndexOf("\\") + 1);
            } else {
                JOptionPane.showMessageDialog(this, "Bạn phải ch�?n ảnh Laptop đi");
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
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        txtSearchr = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLaptop = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblLaptop2 = new javax.swing.JTable();
        btnGiaGiam = new javax.swing.JButton();
        btnGiaTang = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        fillAnhLaptop = new javax.swing.JLabel();
        txtSLTon = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtTenLapTop = new javax.swing.JTextField();
        namBH = new com.toedter.calendar.JYearChooser();
        namSX = new com.toedter.calendar.JYearChooser();
        cbbVoucher = new javax.swing.JComboBox<>();
        cbbRamRom = new javax.swing.JComboBox<>();
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
        cbbMH = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jLabel35 = new javax.swing.JLabel();
        cbbDongLaptop = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        cbbAVG = new javax.swing.JComboBox<>();
        cbbCPU = new javax.swing.JComboBox<>();
        ccbNSX = new javax.swing.JComboBox<>();
        btnNSX = new javax.swing.JButton();
        btnManHinh = new javax.swing.JButton();
        btnCPU = new javax.swing.JButton();
        btnRR = new javax.swing.JButton();
        btnVGA = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnUPdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        cbbLocDongLaptop = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        cbbLocCPU = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        year = new com.toedter.calendar.JYearChooser();
        jLabel28 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtGiaMin = new javax.swing.JTextField();
        txtGiaMax = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        btnLocNam = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        cbbLocRR = new javax.swing.JComboBox<>();
        cbbLocMH = new javax.swing.JComboBox<>();
        cbbLocAVG = new javax.swing.JComboBox<>();
        cbbLocNSX5 = new javax.swing.JComboBox<>();
        jLabel42 = new javax.swing.JLabel();
        btnLocKhoangGia1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1550, 925));

        roundPanel2.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel2.setPreferredSize(new java.awt.Dimension(1080, 600));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSearch.setAlignmentX(0.0F);
        txtSearch.setAlignmentY(0.0F);
        txtSearch.setAutoscrolls(false);
        txtSearch.setBorder(null);
        jPanel3.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 230, 35));

        txtSearchr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/250x30.png"))); // NOI18N
        jPanel3.add(txtSearchr, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

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

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Danh sách Laptop :");
        jPanel4.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jTabbedPane2.setBackground(new java.awt.Color(51, 51, 51));

        tblLaptop.setAutoCreateRowSorter(true);
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

        jTabbedPane2.addTab("Sản phẩm đang hoạt động", jScrollPane1);

        tblLaptop2.setAutoCreateRowSorter(true);
        tblLaptop2.setBackground(new java.awt.Color(51, 51, 51));
        tblLaptop2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblLaptop2.setForeground(new java.awt.Color(255, 255, 255));
        tblLaptop2.setModel(new javax.swing.table.DefaultTableModel(
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
        tblLaptop2.setGridColor(new java.awt.Color(0, 0, 0));
        tblLaptop2.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tblLaptop2.setSelectionForeground(new java.awt.Color(51, 51, 51));
        tblLaptop2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLaptop2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblLaptop2);

        jTabbedPane2.addTab("Sản Phẩm không hoạt động", jScrollPane3);

        jPanel4.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1110, 430));

        btnGiaGiam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 down.png"))); // NOI18N
        btnGiaGiam.setBorder(null);
        btnGiaGiam.setBorderPainted(false);
        btnGiaGiam.setContentAreaFilled(false);
        btnGiaGiam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaGiamActionPerformed(evt);
            }
        });
        jPanel4.add(btnGiaGiam, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 20, -1, -1));

        btnGiaTang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 up.png"))); // NOI18N
        btnGiaTang.setToolTipText("");
        btnGiaTang.setBorder(null);
        btnGiaTang.setBorderPainted(false);
        btnGiaTang.setContentAreaFilled(false);
        btnGiaTang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaTangActionPerformed(evt);
            }
        });
        jPanel4.add(btnGiaTang, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 20, -1, -1));

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 a 17.png"))); // NOI18N
        btnRefresh.setBorder(null);
        btnRefresh.setBorderPainted(false);
        btnRefresh.setContentAreaFilled(false);
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel4.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1130x500.png"))); // NOI18N
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 130, -1, 508));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fillAnhLaptop.setAlignmentY(0.0F);
        jPanel5.add(fillAnhLaptop, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 230, 240));

        txtSLTon.setAlignmentX(0.0F);
        txtSLTon.setAlignmentY(0.0F);
        txtSLTon.setBorder(null);
        jPanel5.add(txtSLTon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 180, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/250x250.png"))); // NOI18N
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 260, 260));

        txtGiaBan.setAlignmentX(0.0F);
        txtGiaBan.setAlignmentY(0.0F);
        txtGiaBan.setAutoscrolls(false);
        txtGiaBan.setBorder(null);
        jPanel5.add(txtGiaBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 180, 30));

        txtID.setAlignmentX(0.0F);
        txtID.setAlignmentY(0.0F);
        txtID.setAutoscrolls(false);
        txtID.setBorder(null);
        jPanel5.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 180, 30));

        txtTenLapTop.setAlignmentX(0.0F);
        txtTenLapTop.setAlignmentY(0.0F);
        txtTenLapTop.setAutoscrolls(false);
        txtTenLapTop.setBorder(null);
        jPanel5.add(txtTenLapTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 180, 30));

        namBH.setBackground(new java.awt.Color(255, 255, 255));
        namBH.setAlignmentX(0.0F);
        namBH.setAlignmentY(0.0F);
        namBH.setDoubleBuffered(false);
        jPanel5.add(namBH, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 460, 80, 35));

        namSX.setBackground(new java.awt.Color(255, 255, 255));
        namSX.setAlignmentX(0.0F);
        namSX.setAlignmentY(0.0F);
        namSX.setDoubleBuffered(false);
        jPanel5.add(namSX, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 80, 35));

        cbbVoucher.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cbbVoucher.setAlignmentX(0.0F);
        cbbVoucher.setAlignmentY(0.0F);
        cbbVoucher.setBorder(null);
        cbbVoucher.setFocusable(false);
        jPanel5.add(cbbVoucher, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 150, 30));

        cbbRamRom.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cbbRamRom.setAlignmentX(0.0F);
        cbbRamRom.setAlignmentY(0.0F);
        cbbRamRom.setBorder(null);
        cbbRamRom.setFocusable(false);
        jPanel5.add(cbbRamRom, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 600, 150, 30));

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tên Laptop :");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/200x30.png"))); // NOI18N
        jLabel11.setAlignmentY(0.0F);
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Mã Laptop :");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/200x30.png"))); // NOI18N
        jLabel12.setAlignmentY(0.0F);
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Số lượng tồn :");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/200x30.png"))); // NOI18N
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/200x30.png"))); // NOI18N
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Giá Bán :");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, -1, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Năm sản xuất :");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 429, -1, 30));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1text100x35.png"))); // NOI18N
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Năm bảo hành :");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 429, -1, 30));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1text100x35.png"))); // NOI18N
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 460, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Nhà sản xuất :");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, -1, 40));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Dòng Laptop :");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 499, -1, 30));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Trạng thái :");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 770, -1, -1));

        radioConHang.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        radioConHang.setForeground(new java.awt.Color(255, 255, 255));
        radioConHang.setText("Còn Hàng ");
        radioConHang.setContentAreaFilled(false);
        jPanel5.add(radioConHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 760, -1, -1));

        radioHetHang.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        radioHetHang.setForeground(new java.awt.Color(255, 255, 255));
        radioHetHang.setText("Hết Hàng");
        radioHetHang.setContentAreaFilled(false);
        jPanel5.add(radioHetHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 760, -1, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Mô tả :");
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 810, -1, -1));

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Màn Hình :");
        jLabel34.setAlignmentY(0.0F);
        jPanel5.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 630, -1, 30));

        cbbMH.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cbbMH.setAlignmentX(0.0F);
        cbbMH.setAlignmentY(0.0F);
        cbbMH.setBorder(null);
        jPanel5.add(cbbMH, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, 150, 30));

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane4.setViewportView(txtMoTa);

        jPanel5.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 820, 360, 80));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("RAM & ROM");
        jPanel5.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 560, -1, 40));

        cbbDongLaptop.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cbbDongLaptop.setAlignmentX(0.0F);
        cbbDongLaptop.setAlignmentY(0.0F);
        cbbDongLaptop.setBorder(null);
        cbbDongLaptop.setFocusable(false);
        jPanel5.add(cbbDongLaptop, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 530, 160, 30));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("CPU :");
        jLabel36.setAlignmentY(0.0F);
        jPanel5.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 690, -1, 30));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Card Đồ họa :");
        jLabel37.setAlignmentY(0.0F);
        jPanel5.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 630, -1, 30));

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Voucher Laptop : ");
        jLabel39.setAlignmentY(0.0F);
        jPanel5.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, -1, 30));

        cbbAVG.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cbbAVG.setAlignmentX(0.0F);
        cbbAVG.setAlignmentY(0.0F);
        cbbAVG.setBorder(null);
        jPanel5.add(cbbAVG, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 660, 150, 30));

        cbbCPU.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cbbCPU.setAlignmentX(0.0F);
        cbbCPU.setAlignmentY(0.0F);
        cbbCPU.setBorder(null);
        jPanel5.add(cbbCPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 720, 150, 30));

        ccbNSX.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        ccbNSX.setAlignmentX(0.0F);
        ccbNSX.setAlignmentY(0.0F);
        ccbNSX.setBorder(null);
        jPanel5.add(ccbNSX, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 600, 150, 30));

        btnNSX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 a 20.png"))); // NOI18N
        btnNSX.setBorder(null);
        btnNSX.setBorderPainted(false);
        btnNSX.setContentAreaFilled(false);
        btnNSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNSXActionPerformed(evt);
            }
        });
        jPanel5.add(btnNSX, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 600, -1, -1));

        btnManHinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 a 20.png"))); // NOI18N
        btnManHinh.setBorder(null);
        btnManHinh.setBorderPainted(false);
        btnManHinh.setContentAreaFilled(false);
        btnManHinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManHinhActionPerformed(evt);
            }
        });
        jPanel5.add(btnManHinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 660, -1, -1));

        btnCPU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 a 20.png"))); // NOI18N
        btnCPU.setBorder(null);
        btnCPU.setBorderPainted(false);
        btnCPU.setContentAreaFilled(false);
        btnCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCPUActionPerformed(evt);
            }
        });
        jPanel5.add(btnCPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 720, -1, -1));

        btnRR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 a 20.png"))); // NOI18N
        btnRR.setBorder(null);
        btnRR.setBorderPainted(false);
        btnRR.setContentAreaFilled(false);
        btnRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRRActionPerformed(evt);
            }
        });
        jPanel5.add(btnRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 600, -1, -1));

        btnVGA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 a 20.png"))); // NOI18N
        btnVGA.setBorder(null);
        btnVGA.setBorderPainted(false);
        btnVGA.setContentAreaFilled(false);
        btnVGA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVGAActionPerformed(evt);
            }
        });
        jPanel5.add(btnVGA, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 660, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("THÔNG TIN LAPTOP");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 a 21.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 720, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/475x880.png"))); // NOI18N
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 490, 900));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 20, 492, -1));

        btnUPdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 a 14.png"))); // NOI18N
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
        jPanel1.add(btnUPdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 50, -1, -1));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 a 15.png"))); // NOI18N
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
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 50, -1, -1));

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 a 13.png"))); // NOI18N
        btnDelete.setAutoscrolls(true);
        btnDelete.setBorder(null);
        btnDelete.setBorderPainted(false);
        btnDelete.setContentAreaFilled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 50, -1, -1));

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 a 12.png"))); // NOI18N
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
        jPanel1.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, -1, -1));

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
        jPanel1.add(cbbLocDongLaptop, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 700, 160, 30));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Dòng Laptop :");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 700, -1, 30));

        cbbLocCPU.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cbbLocCPU.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cbbLocCPU.setAlignmentX(0.0F);
        cbbLocCPU.setAlignmentY(0.0F);
        cbbLocCPU.setBorder(null);
        cbbLocCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocCPUActionPerformed(evt);
            }
        });
        jPanel1.add(cbbLocCPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 870, 170, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Nhà Sản Xuất :");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 700, -1, 30));

        year.setBackground(new java.awt.Color(255, 255, 255));
        year.setAlignmentX(0.0F);
        year.setAlignmentY(0.0F);
        year.setDoubleBuffered(false);
        jPanel1.add(year, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 700, 120, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Năm Sản Xuất");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 700, -1, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Lọc LapTop :");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 660, -1, -1));

        txtGiaMin.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txtGiaMin.setAlignmentX(0.0F);
        txtGiaMin.setAlignmentY(0.0F);
        txtGiaMin.setBorder(null);
        jPanel1.add(txtGiaMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 790, 80, 30));

        txtGiaMax.setAlignmentX(0.0F);
        txtGiaMax.setAlignmentY(0.0F);
        txtGiaMax.setAutoscrolls(false);
        txtGiaMax.setBorder(null);
        jPanel1.add(txtGiaMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 790, 80, 30));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/100x30.png"))); // NOI18N
        jLabel32.setAlignmentY(0.0F);
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 790, 100, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CPU :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 870, -1, 30));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/100x30.png"))); // NOI18N
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 790, -1, -1));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Giá Max :");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 790, -1, 30));

        btnLocNam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 a 18.png"))); // NOI18N
        btnLocNam.setBorder(null);
        btnLocNam.setBorderPainted(false);
        btnLocNam.setContentAreaFilled(false);
        btnLocNam.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLocNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocNamActionPerformed(evt);
            }
        });
        jPanel1.add(btnLocNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 700, -1, -1));

        btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 a2.png"))); // NOI18N
        btnExcel.setBorder(null);
        btnExcel.setBorderPainted(false);
        btnExcel.setContentAreaFilled(false);
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });
        jPanel1.add(btnExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("RAM/ROM :");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 790, -1, 30));

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Màn hình :");
        jPanel1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 870, -1, 30));

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Giá Min :");
        jPanel1.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 790, -1, 30));

        cbbLocRR.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cbbLocRR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cbbLocRR.setAlignmentX(0.0F);
        cbbLocRR.setAlignmentY(0.0F);
        cbbLocRR.setBorder(null);
        cbbLocRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocRRActionPerformed(evt);
            }
        });
        jPanel1.add(cbbLocRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 790, 160, 30));

        cbbLocMH.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cbbLocMH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cbbLocMH.setAlignmentX(0.0F);
        cbbLocMH.setAlignmentY(0.0F);
        cbbLocMH.setBorder(null);
        cbbLocMH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocMHActionPerformed(evt);
            }
        });
        jPanel1.add(cbbLocMH, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 870, 180, 30));

        cbbLocAVG.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cbbLocAVG.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cbbLocAVG.setAlignmentX(0.0F);
        cbbLocAVG.setAlignmentY(0.0F);
        cbbLocAVG.setBorder(null);
        cbbLocAVG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocAVGActionPerformed(evt);
            }
        });
        jPanel1.add(cbbLocAVG, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 870, 170, 30));

        cbbLocNSX5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cbbLocNSX5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cbbLocNSX5.setAlignmentX(0.0F);
        cbbLocNSX5.setAlignmentY(0.0F);
        cbbLocNSX5.setBorder(null);
        cbbLocNSX5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLocNSX5ActionPerformed(evt);
            }
        });
        jPanel1.add(cbbLocNSX5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 700, 180, 30));

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Card Đồ họa :");
        jPanel1.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 870, -1, 30));

        btnLocKhoangGia1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 a 18.png"))); // NOI18N
        btnLocKhoangGia1.setBorder(null);
        btnLocKhoangGia1.setBorderPainted(false);
        btnLocKhoangGia1.setContentAreaFilled(false);
        btnLocKhoangGia1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLocKhoangGia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocKhoangGia1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnLocKhoangGia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 780, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1130x300.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, 1140, 290));

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()

                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))

        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

            .addComponent(roundPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1676, Short.MAX_VALUE)

        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1034, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNSXActionPerformed
        new NSX().setVisible(true);

    }//GEN-LAST:event_btnNSXActionPerformed

    private void btnManHinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManHinhActionPerformed
        new ManHinhForm().setVisible(true);

    }//GEN-LAST:event_btnManHinhActionPerformed

    private void btnCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCPUActionPerformed
        new CPUForm().setVisible(true);

    }//GEN-LAST:event_btnCPUActionPerformed

    private void btnRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRRActionPerformed
        new RAMandRom().setVisible(true);

    }//GEN-LAST:event_btnRRActionPerformed

    private void btnVGAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVGAActionPerformed
        new VGA().setVisible(true);

    }//GEN-LAST:event_btnVGAActionPerformed

    private void btnUPdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUPdateActionPerformed
        String giaBan = txtGiaBan.getText();
        String ten = txtTenLapTop.getText();
        String id = txtID.getText();
        String moTa = txtMoTa.getText();
        String sl = txtSLTon.getText();
        int namSX = this.namSX.getYear();
        int namBH = this.namBH.getYear();
        String nsx = lapTopSe.getIDNSXbyName((String) ccbNSX.getSelectedItem());
        String vga = lk.getIDVGA((String) cbbAVG.getSelectedItem());
        String cpu = lk.getIDCPU((String) cbbCPU.getSelectedItem());
        String rr = lk.getIDNRAMROM((String) cbbRamRom.getSelectedItem());
        String mh = lk.getIDMH((String) cbbMH.getSelectedItem());
        String vc = null;
        if (cbbVoucher.getSelectedIndex()!=0) {
            vc = lapTopSe.getIDVCLTbyName((String) cbbVoucher.getSelectedItem());
        }
        int a = 0;
        if (radioConHang.isSelected()) {
            a = 1;
        }
        if (ten.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không để trống Tên Laptop");
        } else if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không để trống Mã Laptop");
        } else if (!checkTrungID(id)) {
            JOptionPane.showMessageDialog(this, "Không có mã Laptop này");
        } else if (sl.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không để trống số lượng tồn Laptop");
        } else if (!sl.matches("^\\d+$")) {
            JOptionPane.showMessageDialog(this, "Sai định dạng số lượng");
        } else if (giaBan.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không để trống giá bán Laptop");
        } else if (!giaBan.matches("^\\d*(\\.\\d+)?$")) {
            JOptionPane.showMessageDialog(this, "Sai định dạng giá tiền");
        } else if (namBH < namSX) {
            JOptionPane.showMessageDialog(this, "Năm bào hành lớn hơn năm sản xuất");
        } else if (moTa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không để trống mô tả Laptop");
        } else {
            int slTon = Integer.parseInt(sl);
            double gia = Double.parseDouble(giaBan);
            Laptop lt = new Laptop(ten, nsx, vc, vga, cpu, mh, rr, namSX, namBH, moTa, slTon, gia, urlImage(), a);
            JOptionPane.showMessageDialog(this, lapTopSe.update(id, lt));
            JOptionPane.showMessageDialog(this, lapTopSe.insertImei(id, slTon));
            listLaptop = lapTopSe.getAll();
            showDataTable();
            showDataTable2();
        }
    }//GEN-LAST:event_btnUPdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String giaBan = txtGiaBan.getText();
        String ten = txtTenLapTop.getText();
        String id = txtID.getText();
        String moTa = txtMoTa.getText();
        String sl = txtSLTon.getText();
        int namSX = this.namSX.getYear();
        int namBH = this.namBH.getYear();
        String vc = null;
        if (cbbVoucher.getSelectedIndex()!=0) {
            vc = lapTopSe.getIDVCLTbyName((String) cbbVoucher.getSelectedItem());
        }
        String nsx = lapTopSe.getIDNSXbyName((String) ccbNSX.getSelectedItem());
        String vga = lk.getIDVGA((String) cbbAVG.getSelectedItem());
        String cpu = lk.getIDCPU((String) cbbCPU.getSelectedItem());
        String rr = lk.getIDNRAMROM((String) cbbRamRom.getSelectedItem());
        String mh = lk.getIDMH((String) cbbMH.getSelectedItem());
        String dongLT = lapTopSe.getIDDongLTbyName((String) cbbDongLaptop.getSelectedItem());
        int a = 0;
        if (radioConHang.isSelected()) {
            a = 1;
        }
        if (ten.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không để trống Tên Laptop");
        } else if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không để trống Mã Laptop");
        } else if (checkTrungID(id)) {
            JOptionPane.showMessageDialog(this, "Dã có mã Laptop");
        } else if (sl.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không để trống số lượng tồn Laptop");
        } else if (!sl.matches("^\\d+$")) {
            JOptionPane.showMessageDialog(this, "Sai định dạng số lượng");
        } else if (giaBan.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không để trống giá bán Laptop");
        } else if (!giaBan.matches("^\\d*(\\.\\d+)?$")) {
            JOptionPane.showMessageDialog(this, "Sai định dạng giá ti�?n");
        } else if (namBH < namSX) {
            JOptionPane.showMessageDialog(this, "Năm bào hành lớn hơn năm sản xuất");
        } else if (moTa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không để trống mô tả Laptop");
        } else {
            int slTon = Integer.parseInt(sl);
            double gia = Double.parseDouble(giaBan);
            Laptop lt = new Laptop(id, ten, nsx, dongLT, vc, vga, cpu, mh, rr, namSX, namBH, moTa, slTon, gia, urlImage(), a);
            JOptionPane.showMessageDialog(this, lapTopSe.insert(lt));
            JOptionPane.showMessageDialog(this, lapTopSe.insertImei(id, slTon));
            listLaptop = lapTopSe.getAll();
            showDataTable();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearData();
        String a = "";
        ImageIcon img = new ImageIcon("src/Image/Image Laptops/" + a);
        int widght = fillAnhLaptop.getWidth();
        int height = fillAnhLaptop.getHeight();
        Image image = img.getImage(); // transform it 
        Image newimg = image.getScaledInstance(widght, height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        img = new ImageIcon(newimg);
        fillAnhLaptop.setIcon(img);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnGiaGiamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiaGiamActionPerformed
        listLaptop = lapTopSe.getGiaCaoThap();
        showDataTable();
    }//GEN-LAST:event_btnGiaGiamActionPerformed

    private void btnGiaTangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiaTangActionPerformed
        listLaptop = lapTopSe.getGiathapCao();
        showDataTable();
    }//GEN-LAST:event_btnGiaTangActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String id = txtID.getText();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không để trống mã Laptop");
        } else {
            JOptionPane.showMessageDialog(this, lapTopSe.delete(id));
            showDataTable();
            showDataTable2();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void cbbLocNSX5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocNSX5ActionPerformed
        if (cbbLocNSX5.getSelectedIndex() == 0) {
            listLaptop = lapTopSe.getAll();
            showDataTable();
        } else {
            String idNSX = lapTopSe.getIDNSXbyName((String) cbbLocNSX5.getSelectedItem());
            listLaptop = lapTopSe.getNSX(idNSX);
            showDataTable();
        }
    }//GEN-LAST:event_cbbLocNSX5ActionPerformed

    private void btnLocNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocNamActionPerformed
        if (year.getYear() == 2022) {
            listLaptop = lapTopSe.getAll();
            showDataTable();
        } else {
            int nam = year.getYear();
            listLaptop = lapTopSe.getNamSX(nam);
            showDataTable();
        }
    }//GEN-LAST:event_btnLocNamActionPerformed

    private void cbbLocDongLaptopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocDongLaptopActionPerformed
        if (cbbLocDongLaptop.getSelectedIndex() == 0) {
            listLaptop = lapTopSe.getAll();
            showDataTable();
        } else {
            String idDong = lapTopSe.getIDDongLTbyName((String) cbbLocDongLaptop.getSelectedItem());
            listLaptop = lapTopSe.getDongLT(idDong);
            showDataTable();
        }
    }//GEN-LAST:event_cbbLocDongLaptopActionPerformed

    private void btnLocKhoangGia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocKhoangGia1ActionPerformed
        double giaMin = Double.parseDouble(txtGiaMin.getText());
        double giaMax = Double.parseDouble(txtGiaMax.getText());
        listLaptop = lapTopSe.getKhoangGia(giaMin, giaMax);
        showDataTable();
    }//GEN-LAST:event_btnLocKhoangGia1ActionPerformed

    private void cbbLocRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocRRActionPerformed
        if (cbbLocRR.getSelectedIndex() == 0) {
            listLaptop = lapTopSe.getAll();
            showDataTable();
        } else {
            String idRR = lk.getIDNRAMROM((String) cbbLocRR.getSelectedItem());
            listLaptop = lapTopSe.getRAMROM(idRR);
            showDataTable();
        }
    }//GEN-LAST:event_cbbLocRRActionPerformed

    private void cbbLocMHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocMHActionPerformed
        if (cbbLocMH.getSelectedIndex() == 0) {
            listLaptop = lapTopSe.getAll();
            showDataTable();
        } else {
            String idMH = lk.getIDMH((String) cbbLocMH.getSelectedItem());
            listLaptop = lapTopSe.getMH(idMH);
            showDataTable();
        }
    }//GEN-LAST:event_cbbLocMHActionPerformed

    private void cbbLocCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocCPUActionPerformed
        if (cbbLocCPU.getSelectedIndex() == 0) {
            listLaptop = lapTopSe.getAll();
            showDataTable();
        } else {
            String idCPU = lk.getIDCPU((String) cbbCPU.getSelectedItem());
            listLaptop = lapTopSe.getCPU(idCPU);
            showDataTable();
        }
    }//GEN-LAST:event_cbbLocCPUActionPerformed

    private void cbbLocAVGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLocAVGActionPerformed
        if (cbbLocAVG.getSelectedIndex() == 0) {
            listLaptop = lapTopSe.getAll();
            showDataTable();
        } else {
            String idAVG = lk.getIDVGA((String) cbbAVG.getSelectedItem());
            listLaptop = lapTopSe.getAVG(idAVG);
            showDataTable();
        }
    }//GEN-LAST:event_cbbLocAVGActionPerformed

    private void tblLaptopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLaptopMouseClicked
        listLaptop = lapTopSe.getAll();
        int i = tblLaptop.getSelectedRow();
        Laptop lt = listLaptop.get(i);
        txtID.setText(lt.getIdLaptop());
        txtMoTa.setText(lt.getMoTa());
        txtGiaBan.setText(String.valueOf(lt.getGiaBan()/1000000)+".000.000");
        txtSLTon.setText(String.valueOf(lt.getSoLuongTon()));
        txtTenLapTop.setText(lt.getTenLaptop());
        radioConHang.setSelected(true);
        cbbAVG.setSelectedItem(lk.getTenVGA(lt.getIdVGA()));
        cbbCPU.setSelectedItem(lk.getTenCPU(lt.getIdCPU()));
        cbbDongLaptop.setSelectedItem(lapTopSe.getIDDongLTbyName(lt.getIdDongSP()));
        cbbMH.setSelectedItem(lk.getIDMH(lt.getIdMH()));
        cbbRamRom.setSelectedItem(lk.getIDNRAMROM(lt.getIdRR()));
        ccbNSX.setSelectedItem(lapTopSe.getNameNSXByID(lt.getIdNSX()));
        namBH.setYear(lt.getNamBH());
        namSX.setYear(lt.getNamSX());

        String a = lt.getAnh();
        ImageIcon img = new ImageIcon("src/Image/Image Laptops/" + a);
        int widght = fillAnhLaptop.getWidth();
        int height = fillAnhLaptop.getHeight();
        Image image = img.getImage(); // transform it 
        Image newimg = image.getScaledInstance(widght, height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        img = new ImageIcon(newimg);
        fillAnhLaptop.setIcon(img);

    }//GEN-LAST:event_tblLaptopMouseClicked

    private void tblLaptop2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLaptop2MouseClicked
        listLaptop = lapTopSe.getOne();
        int i = tblLaptop2.getSelectedRow();
        Laptop lt = listLaptop.get(i);
        txtID.setText(lt.getIdLaptop());
        txtMoTa.setText(lt.getMoTa());
        txtGiaBan.setText(String.valueOf(lt.getGiaBan()/1000000)+".000.000");
        txtSLTon.setText(String.valueOf(lt.getSoLuongTon()));
        txtTenLapTop.setText(lt.getTenLaptop());
        radioHetHang.setSelected(true);
        cbbAVG.setSelectedItem(lk.getTenVGA(lt.getIdVGA()));
        cbbCPU.setSelectedItem(lk.getTenCPU(lt.getIdCPU()));
        cbbDongLaptop.setSelectedItem(lapTopSe.getIDDongLTbyName(lt.getIdDongSP()));
        cbbMH.setSelectedItem(lk.getIDMH(lt.getIdMH()));
        cbbRamRom.setSelectedItem(lk.getIDNRAMROM(lt.getIdRR()));
        ccbNSX.setSelectedItem(lapTopSe.getNameNSXByID(lt.getIdNSX()));
        namBH.setYear(lt.getNamBH());
        namSX.setYear(lt.getNamSX());
        String a = lt.getAnh();
        ImageIcon img = new ImageIcon("src/Image/Image Laptops/" + a);
        int widght = fillAnhLaptop.getWidth();
        int height = fillAnhLaptop.getHeight();
        Image image = img.getImage(); // transform it 
        Image newimg = image.getScaledInstance(widght, height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        img = new ImageIcon(newimg);
        fillAnhLaptop.setIcon(img);
    }//GEN-LAST:event_tblLaptop2MouseClicked

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        String url = System.getProperty("user.dir");
        System.out.println("user.dir: " + url);
        try {
            XSSFWorkbook wordkbook = new XSSFWorkbook();
            XSSFSheet sheet = wordkbook.createSheet("danhsach");
            XSSFRow row = null;
            Cell cell = null;
            row = sheet.createRow(2);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("DANH SACH LAPTOP");

            row = sheet.createRow(3);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Ma Laptop");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("TÊN LAPTOP");

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Tên NSX");

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Tên DòngLT");

            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Tên CPU");

            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Tên RAM ROM");

            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("Tên Display");

            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue("Tên VGA");

            cell = row.createCell(9, CellType.STRING);
            cell.setCellValue("Tên Voucher");

            cell = row.createCell(10, CellType.STRING);
            cell.setCellValue("Năm Sản Xuất");

            cell = row.createCell(11, CellType.STRING);
            cell.setCellValue("Năm Bảo Hành");

            cell = row.createCell(12, CellType.STRING);
            cell.setCellValue("Mô tả");

            cell = row.createCell(13, CellType.STRING);
            cell.setCellValue("SL Tồn");

            cell = row.createCell(14, CellType.STRING);
            cell.setCellValue("Giá Bán");

            cell = row.createCell(15, CellType.STRING);
            cell.setCellValue("Ảnh");

            cell = row.createCell(16, CellType.STRING);
            cell.setCellValue("Trạng Thái");

            for (int i = 0; i < listLaptop.size(); i++) {
                //Modelbook book =arr.get(i);
                row = sheet.createRow(4 + i);

                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(i + 1);

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(listLaptop.get(i).getIdLaptop());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(listLaptop.get(i).getTenLaptop());

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(lapTopSe.getNameNSXByID(listLaptop.get(i).getIdNSX()));

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(lapTopSe.getNameDongLTByID(listLaptop.get(i).getIdDongSP()));

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(lk.getTenCPU(listLaptop.get(i).getIdCPU()));

                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(lk.getTenRamRom(listLaptop.get(i).getIdRR()));

                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(lk.getTenMH(listLaptop.get(i).getIdMH()));

                cell = row.createCell(8, CellType.STRING);
                cell.setCellValue(lk.getTenVGA(listLaptop.get(i).getIdVGA()));

                cell = row.createCell(9, CellType.STRING);
                cell.setCellValue(lapTopSe.getNameVoucherByID(listLaptop.get(i).getIdVoucher()));

                cell = row.createCell(10, CellType.STRING);
                cell.setCellValue(listLaptop.get(i).getNamSX());

                cell = row.createCell(11, CellType.STRING);
                cell.setCellValue(listLaptop.get(i).getNamBH());

                cell = row.createCell(12, CellType.STRING);
                cell.setCellValue(listLaptop.get(i).getMoTa());

                cell = row.createCell(13, CellType.STRING);
                cell.setCellValue(listLaptop.get(i).getSoLuongTon());

                cell = row.createCell(14, CellType.STRING);
                cell.setCellValue(listLaptop.get(i).getGiaBan());

                cell = row.createCell(15, CellType.STRING);
                cell.setCellValue(listLaptop.get(i).getAnh());

                cell = row.createCell(16, CellType.STRING);
                cell.setCellValue(listLaptop.get(i).getTrangThai());

            }

            String a = url + "\\Danh sách laptop.xlsx";
            File f = new File(a);
            System.out.println(a);
            try {
                FileOutputStream fis = new FileOutputStream(f);
                wordkbook.write(fis);
                fis.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

            JOptionPane.showMessageDialog(this, "Xuất File thành công" + a);

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi");
        }
    }//GEN-LAST:event_btnExcelActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        String id = txtID.getText();
        JOptionPane.showMessageDialog(this, lapTopSe.refreshTT(id));
        listLaptop = lapTopSe.getAll();
        showDataTable();
        showDataTable2();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String ten = txtSearch.getText();
        listLaptop = lapTopSe.searchByName(ten);
        showDataTable();
        showDataTable2();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        ccbNSX.removeAllItems();
        listNSX = lapTopSe.getNSX();

        cbbMH.removeAllItems();
        listMH = lk.getAllDisplay();

        listCPU = lk.getAllCPU();
        cbbCPU.setModel(dccbCPU);

        cbbRamRom.removeAllItems();
        listRR = lk.getAllRR();

        cbbAVG.removeAllItems();
        listVGA = lk.getAllVGA();

        fillCBBtenNSX();
        fillCBBtenCPU();
        fillCBBtenMH();
        fillCBBtenRAMROM();
        fillCBBtenVGA();


    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCPU;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnGiaGiam;
    private javax.swing.JButton btnGiaTang;
    private javax.swing.JButton btnLocKhoangGia1;
    private javax.swing.JButton btnLocNam;
    private javax.swing.JButton btnManHinh;
    private javax.swing.JButton btnNSX;
    private javax.swing.JButton btnRR;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUPdate;
    private javax.swing.JButton btnVGA;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbAVG;
    private javax.swing.JComboBox<String> cbbCPU;
    private javax.swing.JComboBox<String> cbbDongLaptop;
    private javax.swing.JComboBox<String> cbbLocAVG;
    private javax.swing.JComboBox<String> cbbLocCPU;
    private javax.swing.JComboBox<String> cbbLocDongLaptop;
    private javax.swing.JComboBox<String> cbbLocMH;
    private javax.swing.JComboBox<String> cbbLocNSX5;
    private javax.swing.JComboBox<String> cbbLocRR;
    private javax.swing.JComboBox<String> cbbMH;
    private javax.swing.JComboBox<String> cbbRamRom;
    private javax.swing.JComboBox<String> cbbVoucher;
    private javax.swing.JComboBox<String> ccbNSX;
    private javax.swing.JLabel fillAnhLaptop;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private com.toedter.calendar.JYearChooser namBH;
    private com.toedter.calendar.JYearChooser namSX;
    private javax.swing.JRadioButton radioConHang;
    private javax.swing.JRadioButton radioHetHang;
    private com.raven.swing.RoundPanel roundPanel2;
    private javax.swing.JTable tblLaptop;
    private javax.swing.JTable tblLaptop2;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaMax;
    private javax.swing.JTextField txtGiaMin;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtSLTon;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JLabel txtSearchr;
    private javax.swing.JTextField txtTenLapTop;
    private com.toedter.calendar.JYearChooser year;
    // End of variables declaration//GEN-END:variables
}
