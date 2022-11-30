/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

import domainmodels.ChucVu;
import domainmodels.User;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.Security;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.ChucVuServices;
import services.NhanVienServices;

import services.impl.ChucVuServicesImpl;
import services.impl.NhanVienServicesImpl;

import utilsHuy.MsgBox;
import utilsHuy.ShareHelper;
import utilsHuy.Xdate;

/**
 *
 * @author longv
 */
public class panelNhanVien extends javax.swing.JPanel {

    /**
     * Creates new form panelNhanVien
     */
    ChucVuServices chucVuServices;
    NhanVienServices userServices;
    int index = 0;
    String path = "";

    //JFileChooser fileChooser = new JFileChooser(ShareHelper.PATH_IMAGE);
    public panelNhanVien() {
        initComponents();
        setOpaque(false);
        init();
        chucVuServices = new ChucVuServicesImpl();
        userServices = new NhanVienServicesImpl();
        findComboBox(chucVuServices.getAll());
        fillTable();
    }

    void init() {
        // setIconImage(ShareHelper.App_Icon);
        //setLocationRelativeTo(null);
    }

    void findComboBox(List<ChucVu> list) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboChucVu.getModel();
        model.removeAllElements();
        for (ChucVu x : list) {
            model.addElement(x.getTen());
        }
    }

    void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblUser.getModel();
        model.setRowCount(0);
        try {
            List<User> list = userServices.getAll1();
            for (User x : list) {
                model.addRow(new Object[]{x.getId(), x.getTen(), x.getGioiTinh(), x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getChucVu().getTen(), x.getTrangThai()});
            }
        } catch (Exception e) {
            System.out.println("lỗi truy vấn dữ liệu");
        }

    }

//    private Image fitimage(Image img, int w, int h) {
//        BufferedImage resizedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
//        Graphics2D g2 = resizedImage.createGraphics();
//        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//        g2.drawImage(img, 0, 0, w, h, null);
//        g2.dispose();
//        return resizedImage;
//    }
    private void urlImage() {
        try {
            JFileChooser fc = new JFileChooser();
            int chon = fc.showOpenDialog(null);
            if (chon == 0) {
                path = fc.getSelectedFile().getPath();

                path = path.substring(path.lastIndexOf("\\") + 1);
                System.out.println(path);

                ImageIcon img = new ImageIcon("src/Image/Images NhanVien/" + path);
                lblHinh.setIcon(img);
//                int widght = lblHinh.getWidth();
//            int height = lblHinh.getHeight();
//        lblHinh.setIcon(new ImageIcon(img.getScaledInstance(widght, height, 0)));
            } else {
                JOptionPane.showMessageDialog(this, "chua chon file");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "loi doc file");
        }

    }

//    private String urlImage() {
//        JFileChooser jfc = new JFileChooser("H:\\Ky III\\SOF203_Lap trinh Java 3\\Assignment\\Assignment\\src\\images");
//        jfc.showOpenDialog(null);
//        File file = jfc.getSelectedFile();
//        Image img = null;
//        try {
//            img = ImageIO.read(file);
//        } catch (IOException ex) {
//            Logger.getLogger(panelNhanVien.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        lblHinh.setText("");
//        int widght = lblHinh.getWidth();
//        int height = lblHinh.getHeight();
//        lblHinh.setIcon(new ImageIcon(img.getScaledInstance(widght, height, 0)));
//        String s = file.getAbsolutePath().replace("//", "--");
//        return s;
//    }
//    void selectImage() throws IOException {
//        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
//            File file = fileChooser.getSelectedFile();
//            if (ShareHelper.saveLogo(file)) {
//                BufferedImage image = ImageIO.read(file);
//                ImageIcon icon = new ImageIcon((fitimage(image, lblHinh.getWidth(), lblHinh.getHeight())));
//                lblHinh.setIcon(icon);
//                lblHinh.setToolTipText(file.getName());
//            }
//            fileChooser.setCurrentDirectory(file);
//        }
//    }
    User getModel() {

        String ten = cboChucVu.getSelectedItem().toString();

        ChucVu cv = chucVuServices.getByName1(ten);
        
        boolean checkSo = true;
        String gioiTinh = "Nam";
        boolean gt = rboNam.isSelected();
        if (gt) {
            gioiTinh = "Nam";
        } else {
            gioiTinh = "Nữ";
        }
        String url = path;
        System.out.println(url);
        String id = txtId.getText();
        String hoTen = txtHoTen.getText();

        Date ngaysinh = jdcNgaySinh.getDate();
        String diaChi = txtDiaChi.getText();
        String sdt = txtSdt.getText();
        String mk = String.valueOf(txtMatKhau.getPassword());

        if (id.isEmpty() || hoTen.isEmpty() || diaChi.isEmpty() || sdt.isEmpty() || mk.isEmpty()) {
            MsgBox.alert(this, "Nhập đầy đủ thông tin!");

            return null;
        } else {

            try {
                int so = Integer.parseInt(sdt);

            } catch (Exception e) {
                checkSo = false;
                MsgBox.alert(this, "Bạn nhập sai sdt");
            }
            if (checkSo) {
                System.out.println(path);
                return new User(id, cv, hoTen, gioiTinh, ngaysinh, diaChi, sdt, mk, 0, url);
            }

        }

        return null;

    }

    void setModel(User user) {
        txtId.setText(user.getId());
        txtHoTen.setText(user.getTen());
        txtDiaChi.setText(user.getDiaChi());
        txtMatKhau.setText(user.getMatKhau());
        jdcNgaySinh.setDate(user.getNgaySinh());
        txtSdt.setText(user.getSdt());
        int widght = lblHinh.getWidth();
        int height = lblHinh.getHeight();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(user.getAnh()).getImage().getScaledInstance(height, height, WIDTH));
        lblHinh.setIcon(imageIcon);
    }

    void clear() {
        txtId.setText("");
        txtHoTen.setText("");
        txtDiaChi.setText("");
        txtMatKhau.setText("");
        jdcNgaySinh.setDate(Xdate.now());
        txtSdt.setText("");
        lblHinh.setIcon(null);
        setStatus(true);
        cboChucVu.setSelectedIndex(0);
    }

    void insert() {
        User model = getModel();
        if (model != null) {
            userServices.add(model);
            fillTable();
            clear();
            MsgBox.alert(this, "Thêm thành công! ");
        } else {
            MsgBox.alert(this, "Thêm thât bại!");
        }

    }

    void update() {
        User model = getModel();
        if (model != null) {
            userServices.update(model);
            fillTable();
            clear();
            MsgBox.alert(this, "Sửa thành công! ");
        } else {
            MsgBox.alert(this, "Sửa thât bại!");
        }
    }

    void delete() {
        String id = txtId.getText();
        try {
            userServices.delete(id);
            fillTable();
            clear();
            MsgBox.alert(this, "Xóa thành công! ");

        } catch (Exception e) {
            MsgBox.alert(this, "Xóa thât bại!");

        }
    }

    void setStatus(boolean insertTable) {

        btnThem.setEnabled(insertTable);
        btnSua.setEnabled(!insertTable);
        btnXoa.setEnabled(!insertTable);

        boolean first = this.index > 0;
        boolean last = this.index < tblUser.getRowCount() - 1;
        btnFirst.setEnabled(!insertTable && first);
        btnPrev.setEnabled(!insertTable && first);
        btnNext.setEnabled(!insertTable && last);
        btnLast.setEnabled(!insertTable && last);
    }

    void fillToFrom() {
        try {
            String id = (String) tblUser.getValueAt(index, 0);
            User model = userServices.getById(id);
            if (model != null) {
                setModel(model);
                setStatus(false);
                cboChucVu.setSelectedItem(model.getChucVu().getTen());
                String gt = null;
                gt = model.getGioiTinh();
                if (gt.equals("Nam")) {
                    rboNam.setSelected(true);
                } else {
                    rboNu.setSelected(true);
                }
                

            }
            lblHinh.setIcon(new ImageIcon("src/Image/Images NhanVien/" + model.getAnh()));
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }
    
    void guiMail(String to,String tk){
        final String username = "huykieu1012@gmail.com";
        final String password = "nlbikvekynldccsx";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new Authenticator() {
                    

                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("huykieu1012@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(to)
            );
            message.setSubject("Poly Thông báo");
            message.setText("Thông tin nhân viên:"
                    + "\n\n Tai khoản: "+tk+"\n"
                        +"\n MK :"+1);
            
            
            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        roundPanel2 = new com.raven.swing.RoundPanel();
        pnlEdit = new javax.swing.JPanel();
        lblMaNV = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        lblHoTen = new javax.swing.JLabel();
        lblMatKhau = new javax.swing.JLabel();
        lblXanNhanMatKhau = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        lblVaiTro = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        cboChucVu = new javax.swing.JComboBox<>();
        lblHinh = new javax.swing.JLabel();
        rboNam = new javax.swing.JRadioButton();
        rboNu = new javax.swing.JRadioButton();
        jdcNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        pnlList = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1550, 925));

        roundPanel2.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel2.setPreferredSize(new java.awt.Dimension(1080, 600));

        pnlEdit.setBackground(new java.awt.Color(51, 51, 51));

        lblMaNV.setBackground(new java.awt.Color(51, 51, 51));
        lblMaNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMaNV.setForeground(new java.awt.Color(255, 255, 255));
        lblMaNV.setText("Id nhân viên");

        txtHoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoTenActionPerformed(evt);
            }
        });

        lblHoTen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblHoTen.setForeground(new java.awt.Color(255, 255, 255));
        lblHoTen.setText("Họ và tên");

        lblMatKhau.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        lblMatKhau.setText("Mật khẩu");

        lblXanNhanMatKhau.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblXanNhanMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        lblXanNhanMatKhau.setText("Địa chỉ");

        lblVaiTro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblVaiTro.setForeground(new java.awt.Color(255, 255, 255));
        lblVaiTro.setText("Chức vụ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Giới tính");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ngày Sinh");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("SDT");

        cboChucVu.setBackground(new java.awt.Color(51, 51, 51));
        cboChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblHinh.setBackground(new java.awt.Color(51, 255, 255));
        lblHinh.setForeground(new java.awt.Color(0, 204, 255));
        lblHinh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhMouseClicked(evt);
            }
        });

        rboNam.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(rboNam);
        rboNam.setForeground(new java.awt.Color(255, 255, 255));
        rboNam.setSelected(true);
        rboNam.setText("Nam");

        rboNu.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(rboNu);
        rboNu.setForeground(new java.awt.Color(255, 255, 255));
        rboNu.setText("Nữ");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email");

        javax.swing.GroupLayout pnlEditLayout = new javax.swing.GroupLayout(pnlEdit);
        pnlEdit.setLayout(pnlEditLayout);
        pnlEditLayout.setHorizontalGroup(
            pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEditLayout.createSequentialGroup()
                        .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdcNgaySinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                            .addComponent(cboChucVu, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSdt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlEditLayout.createSequentialGroup()
                                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(lblHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblXanNhanMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(lblVaiTro)
                                    .addGroup(pnlEditLayout.createSequentialGroup()
                                        .addComponent(rboNam)
                                        .addGap(50, 50, 50)
                                        .addComponent(rboNu)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(64, 64, 64))))
        );
        pnlEditLayout.setVerticalGroup(
            pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(lblMaNV)
                .addGap(17, 17, 17)
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditLayout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblMatKhau)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblXanNhanMatKhau)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEditLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblVaiTro)
                .addGap(11, 11, 11)
                .addComponent(cboChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lblHoTen)
                .addGap(18, 18, 18)
                .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rboNam)
                    .addComponent(rboNu))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jdcNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 0, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("QUẢN LÝ NHÂN VIÊN QUẢN TRỊ");

        pnlList.setBackground(new java.awt.Color(51, 51, 51));

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tên", "Giới Tính", "Ngày Sinh", "Địa Chỉ", "SDT", "Chức Vụ", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblUser);

        javax.swing.GroupLayout pnlListLayout = new javax.swing.GroupLayout(pnlList);
        pnlList.setLayout(pnlListLayout);
        pnlListLayout.setHorizontalGroup(
            pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlListLayout.setVerticalGroup(
            pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        btnThem.setBackground(new java.awt.Color(51, 51, 51));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/icons8-plus-30.png"))); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(51, 51, 51));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/icons8-restart-30 (1).png"))); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(51, 51, 51));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/icons8-cancel-30 (1).png"))); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnMoi.setBackground(new java.awt.Color(51, 51, 51));
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
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMoi))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSua)
                        .addComponent(btnXoa)
                        .addComponent(btnMoi)))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));

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

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(pnlEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(pnlList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(345, 345, 345)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(pnlEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(80, 80, 80))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(pnlList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1572, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtHoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoTenActionPerformed

    private void lblHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMouseClicked
        urlImage();
    }//GEN-LAST:event_lblHinhMouseClicked

    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            index = tblUser.rowAtPoint(evt.getPoint());
            if (index >= 0) {
                fillToFrom();

            }
        }
    }//GEN-LAST:event_tblUserMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        
        
        
        User model = getModel();
        if (model != null) {
            guiMail(txtEmail.getText(), model.getId());
            userServices.add(model);
            
            fillTable();
            clear();
            MsgBox.alert(this, "Thêm thành công! ");
        } else {
            MsgBox.alert(this, "Thêm thât bại!");
        }
        // new BangKhachHang().setVisible(true);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        delete();
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
        index = tblUser.getRowCount() - 1;
        fillToFrom();
    }//GEN-LAST:event_btnLastActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cboChucVu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdcNgaySinh;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblMatKhau;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVaiTro;
    private javax.swing.JLabel lblXanNhanMatKhau;
    private javax.swing.JPanel pnlEdit;
    private javax.swing.JPanel pnlList;
    private javax.swing.JRadioButton rboNam;
    private javax.swing.JRadioButton rboNu;
    private com.raven.swing.RoundPanel roundPanel2;
    private javax.swing.JTable tblUser;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtId;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtSdt;
    // End of variables declaration//GEN-END:variables
}
