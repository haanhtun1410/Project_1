/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import domainmodels.KhachHang;
import domainmodels.LoaiKh;
import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import responsitory.impl.KhachHangResponsitoryImpl;
import services.KhachHangService;
import services.LoaiKHService;
import services.impl.KhachHangServiceImpl;
import services.impl.LoaiKHServiceImpl;
import utilsHuy.MsgBox;
import utilsHuy.Xdate;

/**
 *
 * @author longv
 */
public final class panelKhachHang extends javax.swing.JPanel {

    /**
     * Creates new form panelKhachHang
     */
    private final LoaiKHService loaiKHService = new LoaiKHServiceImpl();
    private final KhachHangService khachHangServices = new KhachHangServiceImpl();
    List<KhachHang> khachHangs = khachHangServices.getAll1();
    List<LoaiKh> loaiKhs = loaiKHService.getAll();
    int index = 0;

    public panelKhachHang() {
        initComponents();
        setOpaque(false);

        DrawTable(tblKhachHang);
        DrawTable(tblKhachHangKHD);
        fillComboBoxLoaiKH();
        System.out.println("ok");
        fillTable(khachHangs);
        txtId.setEditable(false);

    }

    void DrawTable(JTable tblGridView) {
        tblGridView.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
        tblGridView.getTableHeader().setForeground(Color.blue);

        // Column Width
        tblGridView.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblGridView.setForeground(Color.black);

        // Row Height
        tblGridView.setRowHeight(20);

        // Column Center
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tblGridView.setDefaultRenderer(Object.class, centerRenderer);
    }

    void fillTable(List<KhachHang> list) {
        DefaultTableModel model = (DefaultTableModel) tblKhachHang.getModel();
        DefaultTableModel modelKHD = (DefaultTableModel) tblKhachHangKHD.getModel();
        model.setRowCount(0);
        modelKHD.setRowCount(0);

        for (KhachHang x : list) {
            if (x.getTinhTrang() == 1) {

                if (x.getLoaiKh() == null) {
                    model.addRow(new Object[]{x.getId(), " ", x.getTen(), x.getSdt(), x.getEmail(), x.getNgaySinh(), x.getDiaChi(), khachHangServices.getTien(x.getId())});
                } else {
                    model.addRow(new Object[]{x.getId(), x.getLoaiKh().getTen(), x.getTen(), x.getSdt(), x.getEmail(), x.getNgaySinh(), x.getDiaChi(), khachHangServices.getTien(x.getId())});
                }
            } else {
                if (x.getLoaiKh() == null) {
                    modelKHD.addRow(new Object[]{x.getId(), " ", x.getTen(), x.getSdt(), x.getEmail(), x.getNgaySinh(), x.getDiaChi(), khachHangServices.getTien(x.getId())});
                } else {
                    modelKHD.addRow(new Object[]{x.getId(), x.getLoaiKh().getTen(), x.getTen(), x.getSdt(), x.getEmail(), x.getNgaySinh(), x.getDiaChi(), khachHangServices.getTien(x.getId())});
                }
            }
        }
    }

//    LoaiKh updateLoaiKH(double tien) {
//        LoaiKh loaiKh = null;
//        if (tien > 10000000) {
//
//            loaiKh = loaiKHService.getById("LKH03");
//        } else if (tien > 50000000) {
//            loaiKh = loaiKHService.getById("LKH01");
//        } else {
//            loaiKh = loaiKHService.getById("LKH02");
//        }
//        return loaiKh;
//    }
    void load() {
        DefaultTableModel model = (DefaultTableModel) tblKhachHang.getModel();
        DefaultTableModel modelKHD = (DefaultTableModel) tblKhachHangKHD.getModel();
        modelKHD.setRowCount(0);
        model.setRowCount(0);

        try {
            String key = txtTimKiem.getText().trim();
            System.out.println(key);
            KhachHang x = khachHangServices.getBySDT(key);
            System.out.println(x.toString());

            if (x.getTinhTrang() == 1) {

                if (x.getLoaiKh() == null) {
                    model.addRow(new Object[]{x.getId(), " ", x.getTen(), x.getSdt(), x.getEmail(), x.getNgaySinh(), x.getDiaChi(), khachHangServices.getTien(x.getId())});
                } else {
                    model.addRow(new Object[]{x.getId(), x.getLoaiKh().getTen(), x.getTen(), x.getSdt(), x.getEmail(), x.getNgaySinh(), x.getDiaChi(), khachHangServices.getTien(x.getId())});
                }
                tabs.setSelectedIndex(0);
            } else if (x.getTinhTrang() == 0) {
                if (x.getLoaiKh() == null) {
                    modelKHD.addRow(new Object[]{x.getId(), " ", x.getTen(), x.getSdt(), x.getEmail(), x.getNgaySinh(), x.getDiaChi(), khachHangServices.getTien(x.getId())});
                } else {
                    modelKHD.addRow(new Object[]{x.getId(), x.getLoaiKh().getTen(), x.getTen(), x.getSdt(), x.getEmail(), x.getNgaySinh(), x.getDiaChi(), khachHangServices.getTien(x.getId())});
                }
                tabs.setSelectedIndex(1);
            } else {
                MsgBox.alert(this, "Không tìm thấy");
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }

    }

    KhachHang getModel() {
        String id ;
        String ten = txtTen.getText();
        Date ngaySinh = jdcNgaySinh.getDate();
        String sdt = txtSdt.getText();
        String diaChi = txtDiaChi.getText();
        String email = txtEmail.getText();
        
        //Tách phần id 
        String s1=new String();
        String s = ten;
        s=s.trim();// Tac dung la de loai bo hai dau cach dau va cuoi Ten
        int k;
        for(k=s.length()-1;k>=0;k--)
        {
            s1=s.substring(k,k+1);
            if(s1.equals(" ")) break;
        }
        System.out.println("Ten: "+ s.substring(k+1));
        int i;
        for(i=0;i<=s.length();i++)
        {
           s1=s.substring(i,i+1);
            if(s1.equals(" ")) break;
        }
        System.out.println("Ho: "+ s.substring(0,i));
        String ho = s.substring(0,i);
        int j = 0;
    
        if(j>i&&j<k)
        {
            s1=s.substring(j,j+1);
        }
        System.out.println("Ten Dem: "+s.substring(i+1,k));
        String dem = s.substring(i+1,k);
        id = s.substring(k+1)+ho.substring(0,1)+dem.substring(0,1);

        LoaiKh loaiKh = loaiKHService.getById("LKH00");
        boolean check = true;

        if (id.isEmpty() || ten.isEmpty() || sdt.isEmpty() || diaChi.isEmpty() || email.isEmpty()) {
            MsgBox.alert(this, "Vui lòng nhập đầy đủ thông tin ");
            return null;
        } else {
            if (!email.matches("^\\w+@\\w+\\.\\w+$")) {
                MsgBox.alert(this, "Email sai định dạng");
            } else if (!sdt.matches("(0[1-9])+([0-9]{8})")) {
                MsgBox.alert(this, "SDT sai định dạng");
            } else {
                return new KhachHang(id, loaiKh, ten, ngaySinh, sdt, diaChi, email, 1);

            }
        }

        return null;

    }

    void setModel(KhachHang kh) {
        txtId.setText(kh.getId());
        txtDiaChi.setText(kh.getDiaChi());
        txtTen.setText(kh.getTen());
        txtDiaChi.setText(kh.getDiaChi());
        txtEmail.setText(kh.getEmail());
        jdcNgaySinh.setDate(kh.getNgaySinh());
        txtSdt.setText(kh.getSdt());
        int tt = kh.getTinhTrang();

    }

    void clear() {
        txtId.setText("");
        txtDiaChi.setText("");
        txtTen.setText("");
        txtDiaChi.setText("");
        txtEmail.setText("");
        jdcNgaySinh.setDate(Xdate.now());
        txtSdt.setText("");
        setStatus(true);

    }

    void setStatus(boolean insertTable) {

        btnThem.setEnabled(insertTable);
        btnSua.setEnabled(!insertTable);
        btnXoa.setEnabled(!insertTable);

        boolean first = this.index > 0;
        boolean last = this.index < tblKhachHang.getRowCount() - 1;
        btnFirst.setEnabled(!insertTable && first);
        btnPrev.setEnabled(!insertTable && first);
        btnNext.setEnabled(!insertTable && last);
        btnLast.setEnabled(!insertTable && last);
    }

    void insert() {
        KhachHang kh = getModel();
        boolean tim = false;
        for (KhachHang x : khachHangs) {
            if (x.getId().equalsIgnoreCase(txtId.getText())) {
                tim = true;
            }
        }
        if (kh != null) {
//            if (tim) {
//                MsgBox.alert(this, "Id trùng");
//            } 
           // else {

                khachHangServices.addTheoTen(kh);

                clear();
                MsgBox.alert(this, "Thêm thành công!");
                fillTable(khachHangServices.getAll1());
           // }

        } else {
            MsgBox.alert(this, "Thêm thât bại!");
        }
    }

    void update() {
        KhachHang kh = getModel();

        if (kh != null) {
            khachHangServices.update(kh);
            fillTable(khachHangs);

            clear();
            MsgBox.alert(this, "Sửa thành công!");
        } else {
            MsgBox.alert(this, "Sửa thât bại!");
        }
    }

    void updateN() {
        DefaultTableModel model = (DefaultTableModel) tblKhachHangKHD.getModel();
        int soLuong = model.getRowCount();
        try {
            for (int i = 0; i < soLuong; i++) {
                boolean check = false;
                try {
                    check = (boolean) tblKhachHangKHD.getValueAt(i, 8);

                } catch (Exception e) {
                    check = false;
                }
                String id = (String) tblKhachHangKHD.getValueAt(i, 0);
                System.out.println(id);

                if (check) {
                    KhachHang kh = khachHangServices.getById(id);
                    kh.setTinhTrang(1);
                    khachHangServices.update(kh);
                    clear();

                }
            }

            MsgBox.alert(this, "Update thành công");
            fillTable(khachHangServices.getAll1());
        } catch (Exception e) {
            MsgBox.alert(this, "Update thất bại");
        }
    }

    void delete() {

        String id = txtId.getText();
        KhachHang kh = khachHangServices.getById(id);

        try {

            kh.setTinhTrang(0);
            khachHangServices.update(kh);
            clear();
            fillTable(khachHangServices.getAll1());
            MsgBox.alert(this, "Xóa thành công! ");
        } catch (Exception e) {
            MsgBox.alert(this, "Xóa thât bại!");
        }
    }

    void deleteN() {
        DefaultTableModel model = (DefaultTableModel) tblKhachHang.getModel();
        int soLuong = model.getRowCount();
        try {
            for (int i = 0; i < soLuong; i++) {
                boolean check = false;
                try {
                    check = (boolean) tblKhachHang.getValueAt(i, 8);

                } catch (Exception e) {
                    check = false;
                }
                String id = (String) tblKhachHang.getValueAt(i, 0);
                System.out.println(id);

                if (check) {
                    KhachHang kh = khachHangServices.getById(id);
                    kh.setTinhTrang(0);
                    khachHangServices.update(kh);
                    clear();

                }
            }

            MsgBox.alert(this, "Xóa thành công");
            fillTable(khachHangServices.getAll1());
        } catch (Exception e) {
            MsgBox.alert(this, "Xóa thất bại");
        }

//            MsgBox.alert(this, "Xóa thành công! ");
//        } catch (Exception e) {
//            MsgBox.alert(this, "Xóa thât bại!");
//        
    }

    void fillToFrom() {
        try {
            String id = (String) tblKhachHang.getValueAt(index, 0);
            KhachHang kh = khachHangServices.getById(id);
            if (kh != null) {
                setModel(kh);
                setStatus(false);

            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void fillToFromKHD() {
        try {
            String id = (String) tblKhachHangKHD.getValueAt(index, 0);
            KhachHang kh = khachHangServices.getById(id);
            if (kh != null) {
                setModel(kh);
                setStatus(false);

            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void getCBXLoaiKH() {
        try {
            String ten = (String) cboLoaiKh.getSelectedItem();
            String idLKH;
            if (ten.equals("Gold")) {
                idLKH = "LKH01";
                fillTable(khachHangServices.getByLoaiKH(idLKH));
            } else if (ten.equals("Platinum")) {
                idLKH = "LKH02";
                fillTable(khachHangServices.getByLoaiKH(idLKH));
            } else {
                idLKH = "LKH03";
                fillTable(khachHangServices.getByLoaiKH(idLKH));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }

    }

    void fillComboBoxLoaiKH() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboLoaiKh.getModel();
        model.removeAllElements();
        loaiKhs = loaiKHService.getAll();
        loaiKhs.forEach((x) -> {
            model.addElement(x.getTen());
        });
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
        roundPanel2 = new com.raven.swing.RoundPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jdcNgaySinh = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cboLoaiKh = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        jcbKHHD = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKhachHangKHD = new javax.swing.JTable();
        jcbKHKhongHD = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        btnPDF = new javax.swing.JButton();
        btnThemLaiKHNghi = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setPreferredSize(new java.awt.Dimension(1550, 925));

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel2.setPreferredSize(new java.awt.Dimension(1080, 600));

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("KHÁCH HÀNG ");
        jLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thiết lập thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Id");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Ngày sinh");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Địa chỉ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Tên");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Sđt");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Email");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnThem.setBackground(new java.awt.Color(102, 204, 255));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/icons8-plus-30.png"))); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(102, 204, 255));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/icons8-restart-30 (1).png"))); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(102, 204, 255));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/icons8-cancel-30 (1).png"))); // NOI18N
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnXoa.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnMoi.setBackground(new java.awt.Color(102, 204, 255));
        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/icons8-broom-30.png"))); // NOI18N
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnMoi)
                    .addComponent(btnThem))
                .addGap(79, 79, 79))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSua)
                    .addComponent(btnXoa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem)
                .addGap(27, 27, 27)
                .addComponent(btnSua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoa)
                .addGap(18, 18, 18)
                .addComponent(btnMoi)
                .addContainerGap())
        );

        txtId.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jdcNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                            .addComponent(txtDiaChi)
                            .addComponent(jLabel5)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(232, 232, 232)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11)
                    .addComponent(txtTen, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(txtSdt)
                    .addComponent(txtEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTen, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txtId))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/icons8-search-property-30.png"))); // NOI18N

        txtTimKiem.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemCaretUpdate(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 153, 255));
        jButton2.setText("Tim kiếm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        btnFirst.setBackground(new java.awt.Color(51, 51, 51));
        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/icons8-first-30 (1).png"))); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrev.setBackground(new java.awt.Color(51, 51, 51));
        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/icons8-previous-30 (1).png"))); // NOI18N
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setBackground(new java.awt.Color(51, 51, 51));
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/icons8-next-30.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setBackground(new java.awt.Color(51, 51, 51));
        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/icons8-last-30 (1).png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFirst)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrev)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLast))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst)
                    .addComponent(btnPrev)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lọc", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        cboLoaiKh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoaiKhActionPerformed(evt);
            }
        });

        jLabel2.setText("Loại Kh: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addComponent(cboLoaiKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboLoaiKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        tblKhachHang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Loại KH", "Tên", "SDT", "Email", "Ngày Sinh", "Địa Chỉ", "Tông tien", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);

        jcbKHHD.setText("Chọn tất cả");
        jcbKHHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbKHHDMouseClicked(evt);
            }
        });
        jcbKHHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbKHHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1473, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jcbKHHD)
                        .addGap(40, 40, 40))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jcbKHHD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabs.addTab("DANH SÁCH KHÁCH HÀNG ĐANG HOẠT ĐỘNG", jPanel2);

        tblKhachHangKHD.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblKhachHangKHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Loại KH", "Tên", "SDT", "Email", "Ngày Sinh", "Địa Chỉ", "Tông tien", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhachHangKHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangKHDMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblKhachHangKHD);

        jcbKHKhongHD.setText("Chọn tất cả");
        jcbKHKhongHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbKHKhongHDMouseClicked(evt);
            }
        });
        jcbKHKhongHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbKHKhongHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jcbKHKhongHD)
                .addGap(83, 83, 83))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jcbKHKhongHD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabs.addTab("DANH SÁCH KHÁCH HÀNG KHÔNG HOẠT ĐỘNG", jPanel7);

        jButton1.setBackground(new java.awt.Color(102, 204, 255));
        jButton1.setText("Fill danh sách");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnPDF.setBackground(new java.awt.Color(102, 204, 255));
        btnPDF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPDF.setText("PDF");
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });

        btnThemLaiKHNghi.setBackground(new java.awt.Color(102, 204, 255));
        btnThemLaiKHNghi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/Refresh.png"))); // NOI18N
        btnThemLaiKHNghi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemLaiKHNghiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(47, 47, 47)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnPDF)
                .addGap(95, 95, 95)
                .addComponent(btnThemLaiKHNghi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tabs)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(102, 102, 102))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2)
                                .addComponent(jButton1)
                                .addComponent(btnPDF)
                                .addComponent(btnThemLaiKHNghi))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(tabs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1520, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
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

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        insert();
        tabs.setSelectedIndex(0);
        // new BangKhachHang().setVisible(true);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
//        if(txtId.getText()!=" "){
//            System.out.println("oke1231");
//            delete();
//            System.out.println("okeqqq");
//        }else{
//           
//        }
        deleteN();
        tabs.setSelectedIndex(1);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        index = 0;
        fillToFrom();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        index--;
        fillToFrom();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        index++;
        fillToFrom();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        index = tblKhachHang.getRowCount() - 1;
        fillToFrom();
    }//GEN-LAST:event_btnLastActionPerformed

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate
        // TODO add your handling code here:
        // load();
    }//GEN-LAST:event_txtTimKiemCaretUpdate

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            index = tblKhachHang.rowAtPoint(evt.getPoint());
            if (index >= 0) {
                fillToFrom();

            }
        }
        setStatus(false);
        btnThemLaiKHNghi.setEnabled(false);
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        load();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cboLoaiKhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLoaiKhActionPerformed
        // TODO add your handling code here:
        getCBXLoaiKH();
    }//GEN-LAST:event_cboLoaiKhActionPerformed

    private void tblKhachHangKHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangKHDMouseClicked
        // TODO add your handling code here:
        btnThem.setEnabled(false);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        btnThemLaiKHNghi.setEnabled(true);
        if (evt.getClickCount() == 2) {
            index = tblKhachHangKHD.rowAtPoint(evt.getPoint());
            if (index >= 0) {
                fillToFromKHD();

            }
        }
        setStatus(false);
    }//GEN-LAST:event_tblKhachHangKHDMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        fillTable(khachHangs);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
        // TODO add your handling code here:
        String path = "";
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(this);
        if (x == JFileChooser.APPROVE_OPTION) {
            path = j.getSelectedFile().getPath();
        }

        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + " khachHang.pdf"));
            doc.open();

            PdfPTable tbl = new PdfPTable(8);

            tbl.addCell("Id");
            tbl.addCell("Loai KH");
            tbl.addCell("Ten");
            tbl.addCell("SĐT");
            tbl.addCell("Email");
            tbl.addCell("Ngay sinh");

            tbl.addCell("Dia chi");
            tbl.addCell("Tong tien");

            for (int i = 0; i < tblKhachHang.getRowCount(); i++) {
                String Id = tblKhachHang.getValueAt(i, 0).toString();
                String loaiKH = tblKhachHang.getValueAt(i, 1).toString();
                String ten = tblKhachHang.getValueAt(i, 2).toString();
                String sdt = tblKhachHang.getValueAt(i, 3).toString();
                String email = tblKhachHang.getValueAt(i, 4).toString();
                String ngaySinh = tblKhachHang.getValueAt(i, 5).toString();
                String diaChi = tblKhachHang.getValueAt(i, 6).toString();
                
                
                String fe = tblKhachHang.getValueAt(i, 7).toString();
                String tongTien ;
                if (fe != null) {
                    tongTien = fe;
                    //break;
                } else {
                    tongTien = "0";
                    //f  break;
                }
                tbl.addCell(Id);
                tbl.addCell(loaiKH);
                tbl.addCell(ten);
                tbl.addCell(sdt);
                tbl.addCell(email);
                tbl.addCell(ngaySinh);
                tbl.addCell(diaChi);
                tbl.addCell(tongTien);
            }
            doc.add(tbl);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(panelKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(panelKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        doc.close();
    }//GEN-LAST:event_btnPDFActionPerformed

    private void btnThemLaiKHNghiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemLaiKHNghiActionPerformed
        // TODO add your handling code here:
        updateN();
        tabs.setSelectedIndex(0);
    }//GEN-LAST:event_btnThemLaiKHNghiActionPerformed

    private void jcbKHHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbKHHDActionPerformed
        // TODO add your handling code here:
        if (jcbKHHD.isSelected() == true) {
            int soLuong = tblKhachHang.getRowCount();
            for (int i = 0; i < soLuong; i++) {
                tblKhachHang.setValueAt(true, i, 8);
            }
        } else {
            int soLuong = tblKhachHang.getRowCount();
            for (int i = 0; i < soLuong; i++) {
                tblKhachHang.setValueAt(false, i, 8);
            }
        }
    }//GEN-LAST:event_jcbKHHDActionPerformed

    private void jcbKHKhongHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbKHKhongHDActionPerformed
        // TODO add your handling code here:
        if (jcbKHKhongHD.isSelected() == true) {
            int soLuong = tblKhachHangKHD.getRowCount();
            for (int i = 0; i < soLuong; i++) {
                tblKhachHangKHD.setValueAt(true, i, 8);
            }
        } else {
            int soLuong = tblKhachHangKHD.getRowCount();
            for (int i = 0; i < soLuong; i++) {
                tblKhachHangKHD.setValueAt(false, i, 8);
            }
        }
    }//GEN-LAST:event_jcbKHKhongHDActionPerformed

    private void jcbKHKhongHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbKHKhongHDMouseClicked
        // TODO add your handling code here:
        btnThemLaiKHNghi.setEnabled(true);
        btnThem.setEnabled(false);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
    }//GEN-LAST:event_jcbKHKhongHDMouseClicked

    private void jcbKHHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbKHHDMouseClicked
        // TODO add your handling code here:
        btnThemLaiKHNghi.setEnabled(false);
        btnThem.setEnabled(false);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(true);
    }//GEN-LAST:event_jcbKHHDMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPDF;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemLaiKHNghi;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboLoaiKh;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JCheckBox jcbKHHD;
    private javax.swing.JCheckBox jcbKHKhongHD;
    private com.toedter.calendar.JDateChooser jdcNgaySinh;
    private com.raven.swing.RoundPanel roundPanel2;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTable tblKhachHangKHD;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
