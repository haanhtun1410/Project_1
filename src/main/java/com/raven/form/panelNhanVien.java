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
import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
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
    ChucVuServices chucVuServices = new ChucVuServicesImpl();
    NhanVienServices userServices = new NhanVienServicesImpl();
    List<ChucVu> chucVus = chucVuServices.getAll();
    List<User> listUser = userServices.getAll1();
    int index = 0;
    String path = "";

    public panelNhanVien() {
        initComponents();
        setOpaque(false);
        findComboBox(chucVuServices.getAll());
        System.out.println("track");
        findComboBoxChucVuTK(chucVuServices.getAll());
        System.out.println("track");
        rboNam.setSelected(true);
        fillTable(listUser);
        System.out.println("track");
        // fillTable2();
        DrawTable(tblUserNghiViec);
        DrawTable(tblUser);
        btnThemLaiNVNgihi.setEnabled(false);
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

    void findComboBox(List<ChucVu> list) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboChucVu.getModel();
        model.removeAllElements();
        for (ChucVu x : list) {
            model.addElement(x.getTen());
        }
    }

    void findComboBoxChucVuTK(List<ChucVu> list) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboChucVuTK.getModel();
        model.removeAllElements();
        model.addElement("Tất cả");
        for (ChucVu x : list) {
            model.addElement(x.getTen());
        }
    }

    void fillTable(List<User> list) {
        DefaultTableModel model = (DefaultTableModel) tblUser.getModel();
        DefaultTableModel model2 = (DefaultTableModel) tblUserNghiViec.getModel();
        model.setRowCount(0);
        model2.setRowCount(0);
        try {
            for (User x : list) {
                if (x.getTrangThai() == 1) {
                    model.addRow(new Object[]{x.getId(), x.getTen(), x.getGioiTinh(), x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getChucVu().getTen(), "Đang làm", x.getGmail()});
                } else {
                    model2.addRow(new Object[]{x.getId(), x.getTen(), x.getGioiTinh(), x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getChucVu().getTen(), "Đã nghỉ việc", x.getGmail()});
                }
            }
        } catch (Exception e) {
            System.out.println("lỗi truy vấn dữ liệu");
        }

    }

//    void fillTable2() {
//        DefaultTableModel model = (DefaultTableModel) tblUserNghiViec.getModel();
//        model.setRowCount(0);
//        try {
//            List<User> list = userServices.getAll1();
//            for (User x : list) {
//                if (x.getTrangThai() == 1) {
//                    model.addRow(new Object[]{x.getId(), x.getTen(), x.getGioiTinh(), x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getChucVu().getTen(), "Đã nghỉ việc", x.getGmail()});
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("lỗi truy vấn dữ liệu");
//        }
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
                int widght = lblHinh.getWidth();
                int height = lblHinh.getHeight();
                Image image = img.getImage(); // transform it 
                Image newimg = image.getScaledInstance(widght, height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                img = new ImageIcon(newimg);
                lblHinh.setIcon(img);
            } else {
                JOptionPane.showMessageDialog(this, "chua chon file");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "loi doc file");
        }

    }

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
        String id ;
        String hoTen = txtHoTen.getText();

        Date ngaysinh = jdcNgaySinh.getDate();
        String diaChi = txtDiaChi.getText();
        String sdt = txtSdt.getText();
        String mk = String.valueOf(txtMatKhau.getPassword());
        String email = txtEmail.getText();
        //Tách phần id 
        String s1=new String();
        String s = hoTen;
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
        
        
        
        
        if ( hoTen.isEmpty() || diaChi.isEmpty() || sdt.isEmpty() || mk.isEmpty() || email.isEmpty()) {
            MsgBox.alert(this, "Nhập đầy đủ thông tin!");

            return null;
        } else {

            if (!email.matches("^\\w+@\\w+\\.\\w+$")) {
                JOptionPane.showMessageDialog(this, "Email sai định dạng");
            } else if (!sdt.matches("(0[1-9])+([0-9]{8})")) {
                JOptionPane.showMessageDialog(this, "SDT sai định dạng");
            } else {
                return new User(id, cv, hoTen, gioiTinh, ngaysinh, diaChi, sdt, mk, 1, url, email);
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
        txtEmail.setText(user.getGmail());
        int widght = lblHinh.getWidth();
        int height = lblHinh.getHeight();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(user.getAnh()).getImage().getScaledInstance(widght, height, WIDTH));

        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(widght, height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);

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
        txtEmail.setText("");
        cboChucVu.setSelectedIndex(0);
        rboNam.setSelected(true);
    }

    void update() {

        User model = getModel();
        if (model != null) {
            userServices.update(model);
            fillTable(userServices.getAll1());
            clear();
            MsgBox.alert(this, "Sửa thành công! ");
        } else {
            MsgBox.alert(this, "Sửa thât bại!");
        }
    }

    void updateN() {
        DefaultTableModel model = (DefaultTableModel) tblUserNghiViec.getModel();
        int soLuong = model.getRowCount();
        try {
            for (int i = 0; i < soLuong; i++) {
                boolean check = false;
                try {
                    check = (boolean) tblUserNghiViec.getValueAt(i, 9);

                } catch (Exception e) {
                    check = false;
                }
                String id = (String) tblUserNghiViec.getValueAt(i, 0);
                //System.out.println(id);

                if (check) {
                    User nv = userServices.getById(id);
                    nv.setTrangThai(1);
                    userServices.update(nv);
                    clear();

                }
            }

            MsgBox.alert(this, "Sửa thành công");
            fillTable(userServices.getAll1());
        } catch (Exception e) {
            MsgBox.alert(this, "Sửa thất bại");
        }
    }

    void delete() {
        String id = txtId.getText();
        User us = userServices.getById(id);
        us.setTrangThai(0);
        try {
            userServices.update(us);

            clear();
            MsgBox.alert(this, "Xóa thành công! ");
            fillTable(userServices.getAll1());
            tabs.setSelectedIndex(1);

        } catch (Exception e) {
            MsgBox.alert(this, "Xóa thât bại!");

        }
    }

    void deleteN() {
        DefaultTableModel model = (DefaultTableModel) tblUser.getModel();
        int soLuong = model.getRowCount();
        boolean check = false;
        try {
            for (int i = 0; i < soLuong; i++) {
                
                try {
                    check = (boolean) tblUser.getValueAt(i, 9);

                } catch (Exception e) {
                    check = false;
                }
                String id = (String) tblUser.getValueAt(i, 0);
                // System.out.println(id);

                if (check) {
                    User nv = userServices.getById(id);
                    nv.setTrangThai(0);
                    userServices.update(nv);
                    clear();

                }
            }
            

            MsgBox.alert(this, "Xóa thành công");
            fillTable(userServices.getAll1());
        } catch (Exception e) {
            MsgBox.alert(this, "Xóa thất bại");
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
                int widght = lblHinh.getWidth();
                int height = lblHinh.getHeight();
                ImageIcon imageIcon = new ImageIcon("src/Image/Images NhanVien/" + "NV1 - NhanVienBanHang.png");

                Image image = imageIcon.getImage(); // transform it 
                Image newimg = image.getScaledInstance(widght, height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                imageIcon = new ImageIcon(newimg);

                lblHinh.setIcon(imageIcon);

            }

        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void fillToFrom2() {
        try {
            String id = (String) tblUserNghiViec.getValueAt(index, 0);
            User model = userServices.getById(id);
            if (model != null) {
                setModel(model);
                // setStatus(false);
                cboChucVu.setSelectedItem(model.getChucVu().getTen());
                String gt = null;
                gt = model.getGioiTinh();
                if (gt.equals("Nam")) {
                    rboNam.setSelected(true);
                } else {
                    rboNu.setSelected(true);
                }
                int widght = lblHinh.getWidth();
                int height = lblHinh.getHeight();
                ImageIcon imageIcon = new ImageIcon("src/Image/Images NhanVien/" + model.getAnh());

                Image image = imageIcon.getImage(); // transform it 
                Image newimg = image.getScaledInstance(widght, height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                imageIcon = new ImageIcon(newimg);

                lblHinh.setIcon(imageIcon);

            }

        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void guiMail(String to, String tk, String name, String gioiTinh, String mk, String chucVu) {
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
            message.setSubject("PolyTechLap Thông báo");
            if (gioiTinh.equalsIgnoreCase("Nam")) {
                message.setText("THONG BAO TRUNG TUYEN : vi tri " + chucVu
                        + "\n Kinh gui : Anh " + name
                        + "\n Loi dau tien, cong ty PolyTechLap tran trong cam on su quan tam cua anh doi voi vi tri nhan vien tai cong ty. Sau qua trinh phong van, chung toi danh gia cao nang luc va tinh than nhiet huyet voi cong viec tu anh. "
                        + "\n Hom nay, thay mat cong ty, toi rat vui mung thong bao anh " + name + " da trung tuyen trong dot phong van vua qua."
                        + "\n Tran trong moi anh den lam viec tai cong ty theo cac dieu kien va dieu khoan cu the da thoa thuan trong buoi phong van nhu sau: ."
                        + "\n\n -Chuc danh : Nhan vien "
                        + "\n -Ngay bat dau lam viec : " + Xdate.now().toString()
                        + "\n -Dia diem lam viec :  60 Xuan Thuy"
                        + "\n -Thoi gian thu viec : 3 thang "
                        + "\n -Tai khoan dang nhap vao he thong: " + tk
                        + "\n -Mat khau dang nhap vao he thong :" + mk
                        + "\n Anh vui long kiem tra va phan hoi quyet dinh sau 5 ngay (Tinh tu ngay gui gmail)"
                        + "\n Neu co bat cu cau hoi nao vui long lien he truc tiep voi toi qua gmail de duoc phan hoi som nhat."
                        + "\n Mot lan nua, xin chuc mung anh va hy vong som don chao anh gia nhap cung tap the cong ty PolyTechLap "
                        + "\n Tran trong,  "
                        + "\n Kieu Quang Huy");

            } else {
                message.setText("THONG BAO TRUNG TUYEN : vi tri Nhan vien "
                        + "\n Kinh gui : Chi " + name
                        + "\n Loi dau tien, cong ty PolyTechLap tran trong cam on su quan tam cua chi doi voi vi tri nhan vien tai cong ty. Sau qua trinh phong van, chung toi danh gia cao nang luc va tinh than nhiet huyet voi cong viec tu chi. "
                        + "\n Hom nay, thay mat cong ty, toi rat vui mung thong bao chi " + name + " da trung tuyen trong dot phong van vua qua."
                        + "\n Tran trong moi chi den lam viec tai cong ty theo cac dieu kien va dieu khoan cu the da thoa thuan trong buoi phong van nhu sau: ."
                        + "\n\n -Chuc danh : Nhan vien "
                        + "\n -Ngay bat dau lam viec : " + Xdate.now().toString()
                        + "\n -Dia diem lam viec :  60 Xuan Thuy"
                        + "\n -Thoi gian thu viec : 3 thang "
                        + "\n -Tai khoan dang nhap vao he thong: " + tk
                        + "\n -Mat khau dang nhap vao he thong :" + mk
                        + "\n Chi vui long kiem tra va phan hoi quyet dinh sau 5 ngay (Tinh tu ngay gui gmail)"
                        + "\n Neu co bat cu cau hoi nao vui long lien he truc tiep voi toi qua gmail de duoc phan hoi som nhat."
                        + "\n Mot lan nua, xin chuc mung chi va hy vong som don chao chi gia nhap cung tap the cong ty PolyTechLap "
                        + "\n Tran trong,  "
                        + "\n Kieu Quang Huy");
            }

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            System.out.println("Gmail nguoi nhan khong dung dia chi");
        }
    }

    void load() {

        try {
            String key = txtTimKiem1.getText().trim();

            System.out.println(key);
            User x = userServices.getBySDT(key);

            if (x.getTrangThai() == 1) {
                DefaultTableModel model = (DefaultTableModel) tblUser.getModel();
                model.setRowCount(0);
                model.addRow(new Object[]{x.getId(), x.getTen(), x.getGioiTinh(), x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getChucVu().getTen(), "Đang làm", x.getGmail()});
            } else {
                MsgBox.alert(this, "Không tìm thấy");
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }

    }

    void load2() {

        try {
            String key = txtTimKiem2.getText().trim();

            System.out.println(key);
            User x = userServices.getBySDT(key);

            if (x.getTrangThai() == 0) {
                DefaultTableModel model1 = (DefaultTableModel) tblUserNghiViec.getModel();
                model1.setRowCount(0);
                model1.addRow(new Object[]{x.getId(), x.getTen(), x.getGioiTinh(), x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getChucVu().getTen(), "Đã nghỉ việc", x.getGmail()});
            } else {
                MsgBox.alert(this, "Không tìm thấy");
            }

        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void getCBXChucVu() {
        try {
            String ten = (String) cboChucVuTK.getSelectedItem();
            System.out.println(ten);
            String idLKH;
            if (ten.equalsIgnoreCase("Chủ Cửa Hàng")) {
                idLKH = "CV01";
                fillTable(userServices.getByChucVu(idLKH));

            } else if (ten.equals("Nhân Viên Bán Hàng")) {
                idLKH = "CV02";
                fillTable(userServices.getByChucVu(idLKH));
            } else {
                idLKH = "CV03";
                fillTable(userServices.getByChucVu(idLKH));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
    }

    void getCBXGioiTinh() {
        try {
            String ten = (String) cboGioiTinh.getSelectedItem();
            String idLKH;
            if (ten.equalsIgnoreCase("Nam")) {
                idLKH = "Nam";
                fillTable(userServices.getByGioiTinh(idLKH));

            } else {
                idLKH = "Nữ";
                fillTable(userServices.getByGioiTinh(idLKH));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
    }

    void get2CBX() {
        DefaultTableModel model = (DefaultTableModel) tblUser.getModel();
        DefaultTableModel model2 = (DefaultTableModel) tblUserNghiViec.getModel();
        model.setRowCount(0);
        model2.setRowCount(0);
        String gioiTinh = (String) cboGioiTinh.getSelectedItem();
        String chucVu = (String) cboChucVuTK.getSelectedItem();
        List<User> listNV = null;
        if (gioiTinh.equals("Nam")) {
            listNV = userServices.getByGioiTinh(gioiTinh);
            String idLKH;
            for (User x : listNV) {
                if (x.getChucVu().getTen().equals("Chủ Cửa Hàng") && chucVu.equals("Chủ Cửa Hàng")) {
                    idLKH = "CV01";
                    //fillTable(userServices.getByChucVu(idLKH));

                    if (x.getTrangThai() == 1) {
                        model.addRow(new Object[]{x.getId(), x.getTen(), x.getGioiTinh(), x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getChucVu().getTen(), "Đang làm", x.getGmail()});
                    } else {
                        model2.addRow(new Object[]{x.getId(), x.getTen(), x.getGioiTinh(), x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getChucVu().getTen(), "Đã nghỉ việc", x.getGmail()});
                    }

                } else if (x.getChucVu().getTen().equals("Nhân Viên Bán Hàng") && chucVu.equals("Nhân Viên Bán Hàng")) {
                    idLKH = "CV02";
                    if (x.getTrangThai() == 1) {
                        model.addRow(new Object[]{x.getId(), x.getTen(), x.getGioiTinh(), x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getChucVu().getTen(), "Đang làm", x.getGmail()});
                    } else {
                        model2.addRow(new Object[]{x.getId(), x.getTen(), x.getGioiTinh(), x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getChucVu().getTen(), "Đã nghỉ việc", x.getGmail()});
                    }
                } else if (x.getChucVu().getTen().equals("Nhân Viên Kỹ Thuật") && chucVu.equals("Nhân Viên Kỹ Thuật")) {
                    if (x.getTrangThai() == 1) {
                        model.addRow(new Object[]{x.getId(), x.getTen(), x.getGioiTinh(), x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getChucVu().getTen(), "Đang làm", x.getGmail()});
                    } else {
                        model2.addRow(new Object[]{x.getId(), x.getTen(), x.getGioiTinh(), x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getChucVu().getTen(), "Đã nghỉ việc", x.getGmail()});
                    }
                } else if (chucVu.equals("Tất cả")) {
                    fillTable(listNV);
                }
            }

        } else if (gioiTinh.equals("Nữ")) {
            listNV = userServices.getByGioiTinh(gioiTinh);
            String idLKH;
            for (User x : listNV) {
                if (x.getChucVu().getTen().equals("Chủ Cửa Hàng") && chucVu.equals("Chủ Cửa Hàng")) {
                    idLKH = "CV01";
                    //fillTable(userServices.getByChucVu(idLKH));

                    if (x.getTrangThai() == 1) {
                        model.addRow(new Object[]{x.getId(), x.getTen(), x.getGioiTinh(), x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getChucVu().getTen(), "Đang làm", x.getGmail()});
                    } else {
                        model2.addRow(new Object[]{x.getId(), x.getTen(), x.getGioiTinh(), x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getChucVu().getTen(), "Đã nghỉ việc", x.getGmail()});
                    }

                } else if (x.getChucVu().getTen().equals("Nhân Viên Bán Hàng") && chucVu.equals("Nhân Viên Bán Hàng")) {
                    idLKH = "CV02";
                    if (x.getTrangThai() == 1) {
                        model.addRow(new Object[]{x.getId(), x.getTen(), x.getGioiTinh(), x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getChucVu().getTen(), "Đang làm", x.getGmail()});
                    } else {
                        model2.addRow(new Object[]{x.getId(), x.getTen(), x.getGioiTinh(), x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getChucVu().getTen(), "Đã nghỉ việc", x.getGmail()});
                    }
                } else if (x.getChucVu().getTen().equals("Nhân Viên Kỹ Thuật") && chucVu.equals("Nhân Viên Kỹ Thuật")) {
                    if (x.getTrangThai() == 1) {
                        model.addRow(new Object[]{x.getId(), x.getTen(), x.getGioiTinh(), x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getChucVu().getTen(), "Đang làm", x.getGmail()});
                    } else {
                        model2.addRow(new Object[]{x.getId(), x.getTen(), x.getGioiTinh(), x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getChucVu().getTen(), "Đã nghỉ việc", x.getGmail()});
                    }
                } else if (chucVu.equals("Tất cả")) {
                    fillTable(listNV);
                }
            }
        } else if (gioiTinh.equals("Tất cả")) {
            if (chucVu.equals("Tất cả")) {
                fillTable(listUser);
            } else {
               // listNV = userServices.getByGioiTinh(gioiTinh);
                String idLKH;
                for (User x : listUser) {
                    if (x.getChucVu().getTen().equals("Chủ Cửa Hàng") && chucVu.equals("Chủ Cửa Hàng")) {
                        idLKH = "CV01";
                        //fillTable(userServices.getByChucVu(idLKH));

                        if (x.getTrangThai() == 1) {
                            model.addRow(new Object[]{x.getId(), x.getTen(), x.getGioiTinh(), x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getChucVu().getTen(), "Đang làm", x.getGmail()});
                        } else {
                            model2.addRow(new Object[]{x.getId(), x.getTen(), x.getGioiTinh(), x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getChucVu().getTen(), "Đã nghỉ việc", x.getGmail()});
                        }

                    } else if (x.getChucVu().getTen().equals("Nhân Viên Bán Hàng") && chucVu.equals("Nhân Viên Bán Hàng")) {
                        idLKH = "CV02";
                        if (x.getTrangThai() == 1) {
                            model.addRow(new Object[]{x.getId(), x.getTen(), x.getGioiTinh(), x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getChucVu().getTen(), "Đang làm", x.getGmail()});
                        } else {
                            model2.addRow(new Object[]{x.getId(), x.getTen(), x.getGioiTinh(), x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getChucVu().getTen(), "Đã nghỉ việc", x.getGmail()});
                        }
                    } else if (x.getChucVu().getTen().equals("Nhân Viên Kỹ Thuật") && chucVu.equals("Nhân Viên Kỹ Thuật")) {
                        if (x.getTrangThai() == 1) {
                            model.addRow(new Object[]{x.getId(), x.getTen(), x.getGioiTinh(), x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getChucVu().getTen(), "Đang làm", x.getGmail()});
                        } else {
                            model2.addRow(new Object[]{x.getId(), x.getTen(), x.getGioiTinh(), x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getChucVu().getTen(), "Đã nghỉ việc", x.getGmail()});
                        }
                    } else if (chucVu.equals("Tất cả")) {
                        fillTable(listUser);
                    }
                }
            }
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
        rboNam = new javax.swing.JRadioButton();
        rboNu = new javax.swing.JRadioButton();
        jdcNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblHinh = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnThemLaiNVNgihi = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        pnlList = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        txtTimKiem1 = new javax.swing.JTextField();
        btnTimKiem1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnPDF = new javax.swing.JButton();
        jcbNhanVien = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblUserNghiViec = new javax.swing.JTable();
        txtTimKiem2 = new javax.swing.JTextField();
        btnTimKiem2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jcbNhanVienNghi = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        cboGioiTinh = new javax.swing.JComboBox<>();
        cboChucVuTK = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnLoc = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1550, 925));

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel2.setPreferredSize(new java.awt.Dimension(1080, 600));

        pnlEdit.setBackground(new java.awt.Color(255, 255, 255));
        pnlEdit.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thiết lập thông tin nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        lblMaNV.setBackground(new java.awt.Color(51, 51, 51));
        lblMaNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMaNV.setText("Id nhân viên");

        txtId.setBackground(new java.awt.Color(204, 204, 204));

        txtHoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoTenActionPerformed(evt);
            }
        });

        lblHoTen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblHoTen.setText("Họ và tên");

        lblMatKhau.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMatKhau.setText("Mật khẩu");

        lblXanNhanMatKhau.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblXanNhanMatKhau.setText("Địa chỉ");

        txtMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatKhauActionPerformed(evt);
            }
        });

        lblVaiTro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblVaiTro.setText("Chức vụ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Giới tính");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Ngày Sinh");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("SDT");

        cboChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboChucVuActionPerformed(evt);
            }
        });

        rboNam.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rboNam);
        rboNam.setText("Nam");

        rboNu.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rboNu);
        rboNu.setText("Nữ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Email");

        lblHinh.setBackground(new java.awt.Color(51, 255, 255));
        lblHinh.setForeground(new java.awt.Color(0, 204, 255));
        lblHinh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhMouseClicked(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

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
                .addContainerGap()
                .addComponent(btnThem)
                .addGap(64, 64, 64)
                .addComponent(btnSua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(btnXoa)
                .addGap(66, 66, 66)
                .addComponent(btnMoi)
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnMoi)
                    .addComponent(btnXoa)
                    .addComponent(btnThem)
                    .addComponent(btnSua))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnThemLaiNVNgihi.setBackground(new java.awt.Color(102, 204, 255));
        btnThemLaiNVNgihi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/Refresh.png"))); // NOI18N
        btnThemLaiNVNgihi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemLaiNVNgihiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlEditLayout = new javax.swing.GroupLayout(pnlEdit);
        pnlEdit.setLayout(pnlEditLayout);
        pnlEditLayout.setHorizontalGroup(
            pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlEditLayout.createSequentialGroup()
                                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                                    .addComponent(txtDiaChi))
                                .addGap(160, 160, 160)
                                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboChucVu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtEmail)
                                    .addGroup(pnlEditLayout.createSequentialGroup()
                                        .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblVaiTro)
                                            .addComponent(jLabel4))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(lblXanNhanMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlEditLayout.createSequentialGroup()
                                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlEditLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(lblMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(199, 199, 199))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEditLayout.createSequentialGroup()
                                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(160, 160, 160)))
                                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(202, 202, 202)
                        .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlEditLayout.createSequentialGroup()
                                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(txtHoTen)
                                    .addComponent(jdcNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlEditLayout.createSequentialGroup()
                                .addComponent(rboNam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                .addComponent(rboNu)
                                .addGap(246, 246, 246))))
                    .addGroup(pnlEditLayout.createSequentialGroup()
                        .addGap(402, 402, 402)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160)
                        .addComponent(btnThemLaiNVNgihi)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlEditLayout.setVerticalGroup(
            pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlEditLayout.createSequentialGroup()
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblMaNV))
                    .addComponent(lblHoTen, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblVaiTro)
                    .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMatKhau)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jdcNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(lblXanNhanMatKhau)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rboNam)
                            .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rboNu)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEditLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnThemLaiNVNgihi)))
                .addGap(185, 185, 185))
        );

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 0, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("NHÂN VIÊN ");

        tabs.setBackground(new java.awt.Color(255, 255, 255));
        tabs.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        tabs.setOpaque(true);

        pnlList.setBackground(new java.awt.Color(255, 255, 255));

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tên", "Giới Tính", "Ngày Sinh", "Địa Chỉ", "SDT", "Chức Vụ", "Trạng Thái", "Gmail", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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

        txtTimKiem1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnTimKiem1.setBackground(new java.awt.Color(0, 153, 255));
        btnTimKiem1.setText("Tìm kiếm");
        btnTimKiem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiem1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 204, 255));
        jButton2.setText("Fill danh sach");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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

        jcbNhanVien.setText("Chọn tất cả");
        jcbNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbNhanVienMouseClicked(evt);
            }
        });
        jcbNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbNhanVienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlListLayout = new javax.swing.GroupLayout(pnlList);
        pnlList.setLayout(pnlListLayout);
        pnlListLayout.setHorizontalGroup(
            pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(pnlListLayout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(txtTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btnTimKiem1)
                .addGap(85, 85, 85)
                .addComponent(btnPDF)
                .addGap(95, 95, 95)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addComponent(jcbNhanVien)
                .addGap(33, 33, 33))
        );
        pnlListLayout.setVerticalGroup(
            pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem1)
                    .addComponent(jButton2)
                    .addComponent(btnPDF)
                    .addComponent(jcbNhanVien))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(227, 227, 227))
        );

        tabs.addTab("DANH SÁCH NHÂN VIÊN ĐANG LÀM VIỆC", pnlList);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblUserNghiViec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tên", "Giới Tính", "Ngày Sinh", "Địa Chỉ", "SDT", "Chức Vụ", "Trạng Thái", "Gmail", "null"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUserNghiViec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserNghiViecMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblUserNghiViec);

        txtTimKiem2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnTimKiem2.setText("Tìm kiếm");
        btnTimKiem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiem2ActionPerformed(evt);
            }
        });

        jButton1.setText("Fill danh sách");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jcbNhanVienNghi.setText("Chọn tất cả");
        jcbNhanVienNghi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbNhanVienNghiMouseClicked(evt);
            }
        });
        jcbNhanVienNghi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbNhanVienNghiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1224, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(246, 246, 246)
                .addComponent(txtTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnTimKiem2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(65, 65, 65)
                .addComponent(jcbNhanVienNghi)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem2)
                    .addComponent(jButton1)
                    .addComponent(jcbNhanVienNghi))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(224, 224, 224))
        );

        tabs.addTab("DANH SÁCH NHÂN VIÊN ĐÃ NGHỈ VIỆC", jPanel1);

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lọc", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        cboGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Tất cả" }));
        cboGioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGioiTinhActionPerformed(evt);
            }
        });

        cboChucVuTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboChucVuTKActionPerformed(evt);
            }
        });

        jLabel5.setText("Giới tính : ");

        jLabel6.setText("Chức vụ :");

        btnLoc.setText("Lọc cả hai");
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLoc)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cboChucVuTK, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cboGioiTinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboChucVuTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(btnLoc)
                .addContainerGap(47, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 1261, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1625, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            index = tblUser.rowAtPoint(evt.getPoint());
            if (index >= 0) {
                fillToFrom();

            }
        }
        setStatus(false);
        btnThemLaiNVNgihi.setEnabled(false);
    }//GEN-LAST:event_tblUserMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:

        User model = getModel();
        boolean tim = false;
        boolean check = false;
        for (User x : listUser) {
            if (x.getId().equalsIgnoreCase(txtId.getText())) {
                if (x.getTrangThai() == 1) {
                    tim = true;
                    break;
                } else {
                    check = true;
                    break;
                }
            }
        }
        if (model != null) {
//            if (tim) {
//                MsgBox.alert(this, "Id trùng");
//            } else if (check) {
//                MsgBox.alert(this, "Id trùng với nhân viên đã nghỉ!");
//            } else {

                userServices.addKhTheoTen(model);
                fillTable(userServices.getAll1());
                guiMail(txtEmail.getText(), model.getId(), model.getTen(), model.getGioiTinh(), model.getMatKhau(), model.getChucVu().getTen());
                tabs.setSelectedIndex(0);
                clear();
                MsgBox.alert(this, "Thêm thành công! ");
           // }
        } else {
            MsgBox.alert(this, "Thêm thất bại!");
        }

        //System.out.println(model.getTen());

        // new BangKhachHang().setVisible(true);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        update();

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
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
        index = tblUser.getRowCount() - 1;
        fillToFrom();
    }//GEN-LAST:event_btnLastActionPerformed

    private void lblHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMouseClicked
        urlImage();
    }//GEN-LAST:event_lblHinhMouseClicked

    private void txtMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatKhauActionPerformed

    private void txtHoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoTenActionPerformed

    private void tblUserNghiViecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserNghiViecMouseClicked
        // TODO add your handling code here:
        btnThem.setEnabled(false);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        btnThemLaiNVNgihi.setEnabled(true);
        if (evt.getClickCount() == 2) {
            index = tblUserNghiViec.rowAtPoint(evt.getPoint());
            if (index >= 0) {
                fillToFrom2();

            }
        }


    }//GEN-LAST:event_tblUserNghiViecMouseClicked

    private void btnTimKiem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiem1ActionPerformed
        // TODO add your handling code here:
        load();
    }//GEN-LAST:event_btnTimKiem1ActionPerformed

    private void btnTimKiem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiem2ActionPerformed
        // TODO add your handling code here:
        load2();
    }//GEN-LAST:event_btnTimKiem2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        fillTable(userServices.getAll1());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        fillTable(userServices.getAll1());
        //fillTable2();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cboGioiTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGioiTinhActionPerformed
        // TODO add your handling code here:
        getCBXGioiTinh();
        // getCBXChucVu();
    }//GEN-LAST:event_cboGioiTinhActionPerformed

    private void cboChucVuTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboChucVuTKActionPerformed
        // TODO add your handling code here:
        getCBXChucVu();
        //getCBXGioiTinh();
    }//GEN-LAST:event_cboChucVuTKActionPerformed

    private void btnThemLaiNVNgihiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemLaiNVNgihiActionPerformed
        // TODO add your handling code here:
        //update();
        updateN();
        tabs.setSelectedIndex(0);
    }//GEN-LAST:event_btnThemLaiNVNgihiActionPerformed

    private void cboChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboChucVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboChucVuActionPerformed

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
            PdfWriter.getInstance(doc, new FileOutputStream(path + " nhanVien.pdf"));
            doc.open();

            PdfPTable tbl = new PdfPTable(9);

            tbl.addCell("Id");
            tbl.addCell("Ten");
            tbl.addCell("Gioi Tinh");
            tbl.addCell("Ngay Sinh");
            tbl.addCell("Dia chi");
            tbl.addCell("SDT");

            tbl.addCell("Chuc Vu");
            tbl.addCell("Trang Thai");
            tbl.addCell("Gmail");

            for (int i = 0; i < tblUser.getRowCount(); i++) {
                String Id = tblUser.getValueAt(i, 0).toString();
                String ten = tblUser.getValueAt(i, 1).toString();
                String gioiTinh = tblUser.getValueAt(i, 2).toString();
                String ngaySinh = tblUser.getValueAt(i, 3).toString();
                String diaChi = tblUser.getValueAt(i, 4).toString();
                String sdt = tblUser.getValueAt(i, 5).toString();
                String chucVu = tblUser.getValueAt(i, 6).toString();

                String trangThai = tblUser.getValueAt(i, 7).toString();
                String gmail = tblUser.getValueAt(i, 8).toString();

                tbl.addCell(Id);
                tbl.addCell(ten);
                tbl.addCell(gioiTinh);
                tbl.addCell(ngaySinh);
                tbl.addCell(diaChi);
                tbl.addCell(sdt);
                tbl.addCell(chucVu);
                tbl.addCell(trangThai);
                tbl.addCell(gmail);

            }
            doc.add(tbl);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(panelKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(panelKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        doc.close();
    }//GEN-LAST:event_btnPDFActionPerformed

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
        // TODO add your handling code here:
        get2CBX();
    }//GEN-LAST:event_btnLocActionPerformed

    private void jcbNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbNhanVienActionPerformed
        // TODO add your handling code here:
        if (jcbNhanVien.isSelected() == true) {
            int soLuong = tblUser.getRowCount();
            for (int i = 0; i < soLuong; i++) {
                tblUser.setValueAt(true, i, 9);
            }
        }else{
            int soLuong = tblUser.getRowCount();
            for (int i = 0; i < soLuong; i++) {
                tblUser.setValueAt(false, i, 9);
            }
        }
    }//GEN-LAST:event_jcbNhanVienActionPerformed

    private void jcbNhanVienNghiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbNhanVienNghiActionPerformed
        // TODO add your handling code here:
        if (jcbNhanVienNghi.isSelected() == true) {
            int soLuong = tblUserNghiViec.getRowCount();
            for (int i = 0; i < soLuong; i++) {
                tblUserNghiViec.setValueAt(true, i, 9);
            }
        }else{
            int soLuong = tblUserNghiViec.getRowCount();
            for (int i = 0; i < soLuong; i++) {
                tblUserNghiViec.setValueAt(false, i, 9);
            }
        }
    }//GEN-LAST:event_jcbNhanVienNghiActionPerformed

    private void jcbNhanVienNghiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbNhanVienNghiMouseClicked
        // TODO add your handling code here:
        btnThemLaiNVNgihi.setEnabled(true);
        btnThem.setEnabled(false);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
    }//GEN-LAST:event_jcbNhanVienNghiMouseClicked

    private void jcbNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbNhanVienMouseClicked
        // TODO add your handling code here:
        btnThemLaiNVNgihi.setEnabled(false);
         btnThem.setEnabled(false);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(true);
    }//GEN-LAST:event_jcbNhanVienMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPDF;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemLaiNVNgihi;
    private javax.swing.JButton btnTimKiem1;
    private javax.swing.JButton btnTimKiem2;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cboChucVu;
    private javax.swing.JComboBox<String> cboChucVuTK;
    private javax.swing.JComboBox<String> cboGioiTinh;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JCheckBox jcbNhanVien;
    private javax.swing.JCheckBox jcbNhanVienNghi;
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
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblUser;
    private javax.swing.JTable tblUserNghiViec;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtId;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTimKiem1;
    private javax.swing.JTextField txtTimKiem2;
    // End of variables declaration//GEN-END:variables
}
