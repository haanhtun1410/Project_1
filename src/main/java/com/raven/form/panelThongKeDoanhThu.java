/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

import com.raven.chart.ModelChart;
import domainmodels.CPUNhan;
import domainmodels.DisplayNhan;
import domainmodels.RamRomNhan;
import domainmodels.TKSP;
import domainmodels.ThongKeKH;
import domainmodels.ThongKeNSX;
import domainmodels.ThongKeNV;
import domainmodels.VGANhan;
import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.DoanhThuService;
import services.ThongKeNSXSe;
import services.ThongKeNVKHSe;
import services.ThongKeSe;
import services.impl.DoanhThuSerImpl;
import services.impl.ThongKeNSXSeImpl;
import services.impl.ThongKeSeImpls;
import services.impl.ThongKeSeNVKH;

public class panelThongKeDoanhThu extends javax.swing.JPanel {

    private DoanhThuService dtSe = new DoanhThuSerImpl();
    private ThongKeNSXSe nsxSe = new ThongKeNSXSeImpl();
    private List<ThongKeNSX> list = new ArrayList<>();
    private DefaultTableModel dtmLT = new DefaultTableModel();
    private DefaultTableModel dtmCPU = new DefaultTableModel();
    private DefaultTableModel dtmVGA = new DefaultTableModel();
    private DefaultTableModel dtmMH = new DefaultTableModel();
    private DefaultTableModel dtmRR = new DefaultTableModel();
    private DefaultTableModel dtmNV = new DefaultTableModel();
    private DefaultTableModel dtmKH = new DefaultTableModel();
    private DefaultTableModel dtmTKDT = new DefaultTableModel();
    private List<CPUNhan> listCPU = new ArrayList<>();
    private List<VGANhan> listVGA = new ArrayList<>();
    private List<DisplayNhan> listMH = new ArrayList<>();
    private List<RamRomNhan> listRR = new ArrayList<>();
    private List<TKSP> listSP = new ArrayList<>();
    private ThongKeSe tkSe = new ThongKeSeImpls();
    private ThongKeNVKHSe tkNVKH = new ThongKeSeNVKH();
    private List<ThongKeKH> listKH = new ArrayList<>();
    private List<ThongKeNV> listNV = new ArrayList<>();

    public panelThongKeDoanhThu() {
        initComponents();
        setOpaque(false);

        header();

        list = nsxSe.getAll();
        listCPU = tkSe.getAllCPU();
        listSP = tkSe.getAll();
        listRR = tkSe.getAllRR();
        listVGA = tkSe.getAllVGA();
        listMH = tkSe.getAllMH();
        listKH = tkNVKH.getListKH();
        listNV = tkNVKH.getListNV();

        fillDataTableCPU();
        fillDataTableLapTop();
        fillDataTableMH();
        fillDataTableRR();
        fillDataTableVGA();
        fillDataTableKH();
        fillDataTableNV();
        fillDataTableTKDT();
        fillSum();

        showDataTableCPU();
        showDataTableLT();
        showDataTableMH();
        showDataTableRR();
        showDataTableVGA();
        showDataTableKH();
        showDataTableNV();
        showDataTableTKDT();

    }

    private void fillSum() {
        
        double sum = tkSe.tongTien();
        String ga = String.valueOf(sum);
        String a = "";
        if (ga.contains("E8")) {
            a = sum / 1000000 + "00.000";
        }

        fillTongTien1.setText(a);
        fillHD.setText(String.valueOf(tkSe.soHD()));
        fillTongLT.setText(String.valueOf(tkSe.soSP()));
        fillSoKH.setText(String.valueOf(tkSe.soKH()));
        
        double summ = tkSe.TongTienHomNay();
        if (summ == 0) {
            fillTongTienhHomNay.setText("0");
        } else {
            String gaa = String.valueOf(summ);
            String b = "";
            if (gaa.contains("E8")) {
                b = summ / 1000000 + "00.000";
            }
            fillTongTienhHomNay.setText(b);
        }
        
        fillLTBanChayNhat.setText(tkSe.top1SP());
        
        int summm = tkSe.tongSPHN();
        if (summ == 0) {
            fillTongLThn.setText("0");
        } else {
          
            fillTongLThn.setText(String.valueOf(summm));
        }
    }
    private void fillDataTableTKDT() {
        tblTKDT.setModel(dtmTKDT);
        String header[] = {"STT", "NGÀY THANH TOÁN", "TÊN NHÂN VIÊN", "TÊN KHÁCH HÀNG", "TỔNG TIỀN (TRIỆU ĐỒNG)", "SỐ LƯỢNG"};
        dtmTKDT.setColumnIdentifiers(header);
    }
    private void showDataTableTKDT() {
        listSP = tkSe.tkspAll();
        dtmTKDT = (DefaultTableModel) tblTKDT.getModel();
        dtmTKDT.setRowCount(0);
        int i = 1;
        for (TKSP x : listSP) {
            dtmTKDT.addRow(new Object[]{
                i++, x.getNgayThanhToan(), tkSe.tenNV(x.getIdNV()), tkSe.tenKH(x.getIdKH()), x.getTongTien()/1000000, x.getTongSP()
            });
        }
    }

    private void fillDataTableLapTop() {
        tblLT.setModel(dtmLT);
        String header[] = {"STT", "TÊN LAPTOP", "ANH", "SL ĐÃ BÁN"};
        dtmLT.setColumnIdentifiers(header);
    }

    private void fillDataTableKH() {
        tblKH.setModel(dtmKH);
        String header[] = {"STT", "MÃ KHÁCH HÀNG", "TÊN KHÁCH HÀNG", "SDT", "TỔNG SỐ LAPTO ĐÃ MUA", "TỔNG TIỀN (Triệu VND)"};
        dtmKH.setColumnIdentifiers(header);
    }

    private void fillDataTableNV() {
        tblNV.setModel(dtmNV);
        String header[] = {"STT", "MÃ NHÂN VIÊN", "TÊN NHÂN VIÊN", "SDT", "TỔNG TIỀN (Triệu VND)", "TỔNG SỐ LAPTOP ĐÃ BÁN"};
        dtmNV.setColumnIdentifiers(header);
    }

    private void fillDataTableVGA() {
        tblVGA.setModel(dtmVGA);
        String header[] = {"STT", "TÊN Card", "SL ĐÃ BÁN"};
        dtmVGA.setColumnIdentifiers(header);
    }

    private void fillDataTableCPU() {
        tblCPU.setModel(dtmCPU);
        String header[] = {"STT", "TÊN CPU", "SL ĐÃ BÁN"};
        dtmCPU.setColumnIdentifiers(header);
    }

    private void fillDataTableRR() {
        tblRR.setModel(dtmRR);
        String header[] = {"STT", "TÊN RAM & ROM", "SL ĐÃ BÁN"};
        dtmRR.setColumnIdentifiers(header);
    }

    private void fillDataTableMH() {
        tblMH.setModel(dtmMH);
        String header[] = {"STT", "TÊN Màn Hình", "SL ĐÃ BÁN"};
        dtmMH.setColumnIdentifiers(header);
    }

    private void showDataTableLT() {
        dtmLT = (DefaultTableModel) tblLT.getModel();
        dtmLT.setRowCount(0);
        int i = 1;
        for (TKSP x : listSP) {
            dtmLT.addRow(new Object[]{
                i++, x.getTenSP(), x.getAnh(), x.getSoLuong() == null ? "" : x.getSoLuong()
            });
        }
    }

    private void showDataTableVGA() {
        dtmVGA = (DefaultTableModel) tblVGA.getModel();
        dtmVGA.setRowCount(0);
        int i = 1;
        for (VGANhan x : listVGA) {
            dtmVGA.addRow(new Object[]{
                i++, x.getTenVGA(), x.getSl()
            });
        }
    }

    private void showDataTableMH() {
        dtmMH = (DefaultTableModel) tblMH.getModel();
        dtmMH.setRowCount(0);
        int i = 1;
        for (DisplayNhan x : listMH) {
            dtmMH.addRow(new Object[]{
                i++, x.getTenDisplay(), x.getSl()
            });
        }
    }

    private void showDataTableRR() {
        dtmRR = (DefaultTableModel) tblRR.getModel();
        dtmRR.setRowCount(0);
        int i = 1;
        for (RamRomNhan x : listRR) {
            dtmRR.addRow(new Object[]{
                i++, x.getTenRR(), x.getSoluong()
            });
        }
    }

    private void showDataTableCPU() {
        dtmCPU = (DefaultTableModel) tblCPU.getModel();
        dtmCPU.setRowCount(0);
        int i = 1;
        for (CPUNhan x : listCPU) {
            dtmCPU.addRow(new Object[]{
                i++, x.getIdCPU(), x.getSl()
            });
        }
    }

    private void showDataTableNV() {
        dtmNV = (DefaultTableModel) tblNV.getModel();
        dtmNV.setRowCount(0);
        int i = 1;
        for (ThongKeNV x : listNV) {
            dtmNV.addRow(new Object[]{
                i++, x.getIdNV(), x.getTenNV(), x.getSdtNV(), x.getTongTien() / 1000000, x.getSl()
            });
        }
    }

    private void showDataTableKH() {
        dtmKH = (DefaultTableModel) tblKH.getModel();
        dtmKH.setRowCount(0);
        int i = 1;
        for (ThongKeKH x : listKH) {
            dtmKH.addRow(new Object[]{
                i++, x.getIdNV(), x.getTenNV(), x.getSdtNV(), x.getSoLuong(), x.getTongTien() / 1000000
            });
        }
    }

    private void header() {

        String name1 = "Thống kê doanh thu  ";
        chartTKDT.addLegend(name1, new Color(12, 84, 175), new Color(0, 108, 247));

        String name2 = "Thống kê số lượng sản phẩm bán ra  ";
        lineChartTKSP.addLegend(name2, new Color(186, 37, 37), new Color(241, 100, 120));

        String name = "Thống kê số lượng Laptop của Nhà Sản Xuất đã bán";
        chartNSX.addLegend(name, new Color(255, 182, 193), new Color(255, 182, 193));

    }

    private void date15TKDT() {
        Date start = dateStart.getDate();
        int monthStart = Integer.parseInt(String.format("%1$tm", start));
        int dayStart = Integer.valueOf(String.format("%1$td", start));
        int yearStart = Integer.valueOf(String.format("%1$tY", start));

        Date end = dateEnd.getDate();
        int monthEnd = Integer.valueOf(String.format("%1$tm", end));
        int dayEnd = Integer.valueOf(String.format("%1$td", end));
        int yearEnd = Integer.valueOf(String.format("%1$tY", end));

        if (yearEnd == yearStart) {
            if (monthEnd == monthStart) {
                if (dayEnd == dayStart) {
                    JOptionPane.showMessageDialog(this, "Ngày thống kê phải lớn hơn 1");
                } else if (dayEnd < dayStart) {
                    JOptionPane.showMessageDialog(this, "Ngày kết thúc phải lớn hơn ngày bắt đầu");
                } else if (dayEnd - dayStart <= 15) {
                    int a = dayEnd - dayStart + 1;
                    JOptionPane.showMessageDialog(this, "Bạn thống kê " + a + " ngày !");
                    for (int i = dayStart; i <= dayEnd; i++) {
                        chartTKDT.addData(new ModelChart(i + "/" + monthStart, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                        lineChartTKSP.addData(new ModelChart(i + "/" + monthStart, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Ngày thống kê phải nhỏ hơn 15");
                }
            } else if (monthEnd - monthStart == 1) {
                if (monthStart == 1 || monthStart == 3 || monthStart == 5 || monthStart == 7 || monthStart == 8 || monthStart == 10 || monthStart == 12) {
                    int a = 31 - dayStart + 2 + dayEnd - 1;
                    int du = dayStart + a - 31;
                    if (a <= 15) {
                        JOptionPane.showMessageDialog(this, "Bạn thống kê " + a + " ngày !");
                        for (int i = dayStart; i <= 31; i++) {
                            chartTKDT.addData(new ModelChart(i + "/" + monthStart, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                            lineChartTKSP.addData(new ModelChart(i + "/" + monthStart, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                        }
                        for (int i = 1; i < du; i++) {
                            chartTKDT.addData(new ModelChart(i + "/" + monthEnd, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                            lineChartTKSP.addData(new ModelChart(i + "/" + monthEnd, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Chỉ được thống kê dưới 15 ngày");
                    }
                } else if (monthStart == 4 || monthStart == 6 || monthStart == 9 || monthStart == 11) {
                    int a = 30 - dayStart + 2 + dayEnd - 1;
                    int du = dayStart + a - 30;
                    if (a <= 15) {
                        JOptionPane.showMessageDialog(this, "Bạn thống kê " + a + " ngày !");
                        for (int i = dayStart; i <= 30; i++) {
                            chartTKDT.addData(new ModelChart(i + "/" + monthStart, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                            lineChartTKSP.addData(new ModelChart(i + "/" + monthEnd, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                        }
                        for (int i = 1; i < du; i++) {
                            chartTKDT.addData(new ModelChart(i + "/" + monthEnd, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                            lineChartTKSP.addData(new ModelChart(i + "/" + monthEnd, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Chỉ được thống kê dưới 15 ngày");
                    }
                } else if (monthStart == 2 && yearStart % 4 == 0) {
                    int a = 29 - dayStart + 2 + dayEnd - 1;
                    int du = dayStart + 15 - 29;
                    JOptionPane.showMessageDialog(this, "Bạn thống kê " + a + " ngày !");
                    if (a <= 15) {
                        for (int i = dayStart; i <= 29; i++) {
                            chartTKDT.addData(new ModelChart(i + "/" + monthStart, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                            lineChartTKSP.addData(new ModelChart(i + "/" + monthEnd, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                        }
                        for (int i = 1; i < du; i++) {
                            chartTKDT.addData(new ModelChart(i + "/" + monthEnd, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                            lineChartTKSP.addData(new ModelChart(i + "/" + monthEnd, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Chỉ được thống kê dưới 15 ngày");
                    }
                } else {
                    int a = 28 - dayStart + 2 + dayEnd - 1;
                    int du = dayStart + 15 - 28;
                    JOptionPane.showMessageDialog(this, "Bạn thống kê " + a + " ngày !");
                    if (a <= 15) {
                        for (int i = dayStart; i <= 28; i++) {
                            chartTKDT.addData(new ModelChart(i + "/" + monthStart, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                            lineChartTKSP.addData(new ModelChart(i + "/" + monthEnd, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                        }
                        for (int i = 1; i < du; i++) {
                            chartTKDT.addData(new ModelChart(i + "/" + monthEnd, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                            lineChartTKSP.addData(new ModelChart(i + "/" + monthEnd, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Chỉ được thống kê dưới 15 ngày");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ngoài khoảng thời gian có thể thống kê");
            }
        } else if (yearEnd - yearStart == 1) {
            if (monthEnd == 1 && monthStart == 12) {
                int a = 31 - dayStart + 2 + dayEnd - 1;
                int du = dayStart + a - 31;
                if (a <= 15) {
                    JOptionPane.showMessageDialog(this, "Bạn thống kê " + a + " ngày !");
                    for (int i = dayStart; i <= 31; i++) {
                        lineChartTKSP.addData(new ModelChart(i + "/" + monthEnd, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                        chartTKDT.addData(new ModelChart(i + "/" + monthStart, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                    }
                    for (int i = 1; i < du; i++) {
                        chartTKDT.addData(new ModelChart(i + "/" + monthEnd, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                        lineChartTKSP.addData(new ModelChart(i + "/" + monthEnd, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Chỉ được thống kê dưới 15 ngày");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ngoài khoảng thời gian có thể thống kê");
        }
    }

    private void initThongKeTheoNam(int nam) {

        chartTKDT.addData(new ModelChart("January", new double[]{dtSe.DoanhThuThang(1, nam) / 1000000}));
        chartTKDT.addData(new ModelChart("February", new double[]{dtSe.DoanhThuThang(2, nam) / 1000000}));
        chartTKDT.addData(new ModelChart("March", new double[]{dtSe.DoanhThuThang(3, nam) / 1000000}));
        chartTKDT.addData(new ModelChart("April", new double[]{dtSe.DoanhThuThang(4, nam) / 1000000}));
        chartTKDT.addData(new ModelChart("May", new double[]{dtSe.DoanhThuThang(5, nam) / 1000000}));
        chartTKDT.addData(new ModelChart("June", new double[]{dtSe.DoanhThuThang(6, nam) / 1000000}));
        chartTKDT.addData(new ModelChart("July", new double[]{dtSe.DoanhThuThang(7, nam) / 1000000}));
        chartTKDT.addData(new ModelChart("August", new double[]{dtSe.DoanhThuThang(8, nam) / 1000000}));
        chartTKDT.addData(new ModelChart("September", new double[]{dtSe.DoanhThuThang(9, nam) / 1000000}));
        chartTKDT.addData(new ModelChart("October", new double[]{dtSe.DoanhThuThang(10, nam) / 1000000}));
        chartTKDT.addData(new ModelChart("November", new double[]{dtSe.DoanhThuThang(11, nam) / 1000000}));
        chartTKDT.addData(new ModelChart("December", new double[]{dtSe.DoanhThuThang(12, nam) / 1000000}));

        lineChartTKSP.addData(new ModelChart("January", new double[]{dtSe.SLLaptopBan(1, nam)}));
        lineChartTKSP.addData(new ModelChart("February", new double[]{dtSe.SLLaptopBan(2, nam)}));
        lineChartTKSP.addData(new ModelChart("March", new double[]{dtSe.SLLaptopBan(3, nam)}));
        lineChartTKSP.addData(new ModelChart("April", new double[]{dtSe.SLLaptopBan(4, nam)}));
        lineChartTKSP.addData(new ModelChart("May", new double[]{dtSe.SLLaptopBan(5, nam)}));
        lineChartTKSP.addData(new ModelChart("June", new double[]{dtSe.SLLaptopBan(6, nam)}));
        lineChartTKSP.addData(new ModelChart("July", new double[]{dtSe.SLLaptopBan(7, nam)}));
        lineChartTKSP.addData(new ModelChart("August", new double[]{dtSe.SLLaptopBan(8, nam)}));
        lineChartTKSP.addData(new ModelChart("September", new double[]{dtSe.SLLaptopBan(9, nam)}));
        lineChartTKSP.addData(new ModelChart("October", new double[]{dtSe.SLLaptopBan(10, nam)}));
        lineChartTKSP.addData(new ModelChart("November", new double[]{dtSe.SLLaptopBan(11, nam)}));
        lineChartTKSP.addData(new ModelChart("December", new double[]{dtSe.SLLaptopBan(12, nam)}));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        roundPanel3 = new com.raven.swing.RoundPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblTKDT = new javax.swing.JTable();
        fillTongTien1 = new javax.swing.JLabel();
        fillTongTien = new javax.swing.JLabel();
        fillTongTienhHomNay = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        fillHD = new javax.swing.JLabel();
        fillTongTien3 = new javax.swing.JLabel();
        fillTongLT = new javax.swing.JLabel();
        fillTongLThn = new javax.swing.JLabel();
        fillLTBanChayNhat = new javax.swing.JLabel();
        fillSoKH = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        roundPanel2 = new com.raven.swing.RoundPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        chartTKDT = new com.raven.chart.Chart();
        chartNSX = new com.raven.chart.Chart();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLT = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        fillImage = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVGA = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRR = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCPU = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblMH = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblNV = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblKH = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        roundPanel5 = new com.raven.swing.RoundPanel();
        lineChartTKSP = new com.raven.chart.LineChart();
        jLabel2 = new javax.swing.JLabel();
        roundPanel1 = new com.raven.swing.RoundPanel();
        jLabel6 = new javax.swing.JLabel();
        chooseYears = new com.toedter.calendar.JYearChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        dateStart = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        dateEnd = new com.toedter.calendar.JDateChooser();
        btnNgay = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnNam = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnNSX = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1550, 925));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTabbedPane1.setForeground(new java.awt.Color(51, 51, 51));

        roundPanel3.setBackground(new java.awt.Color(0, 0, 0));
        roundPanel3.setPreferredSize(new java.awt.Dimension(1080, 600));
        roundPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 sac.png"))); // NOI18N
        roundPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, -1, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("TỔNG SỐ SẢN PHẨM ĐÃ BÁN");
        roundPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 130, -1, -1));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 tkdt.png"))); // NOI18N
        roundPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 470, 60));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("THÔNG TIN HÓA ĐƠN ĐÃ BÁN");
        roundPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 480, -1, -1));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 laptop 1.png"))); // NOI18N
        roundPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 110, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("TỔNG DOANH THU");
        roundPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, -1, -1));

        tblTKDT.setBackground(new java.awt.Color(0, 0, 0));
        tblTKDT.setForeground(new java.awt.Color(255, 255, 255));
        tblTKDT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
        tblTKDT.setGridColor(new java.awt.Color(0, 0, 0));
        tblTKDT.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane8.setViewportView(tblTKDT);

        roundPanel3.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 1540, 360));

        fillTongTien1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        fillTongTien1.setForeground(new java.awt.Color(0, 255, 51));
        roundPanel3.add(fillTongTien1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 140, 40));

        fillTongTien.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        fillTongTien.setForeground(new java.awt.Color(255, 255, 255));
        fillTongTien.setText("VND");
        roundPanel3.add(fillTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, 60, 40));

        fillTongTienhHomNay.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        fillTongTienhHomNay.setForeground(new java.awt.Color(0, 255, 51));
        roundPanel3.add(fillTongTienhHomNay, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 120, 40));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("TỔNG SỐ LAPTOP ĐÃ BÁN :");
        roundPanel3.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 200, -1, 40));

        fillHD.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fillHD.setForeground(new java.awt.Color(0, 255, 0));
        roundPanel3.add(fillHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 140, 40));

        fillTongTien3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        fillTongTien3.setForeground(new java.awt.Color(255, 255, 255));
        fillTongTien3.setText("VND");
        roundPanel3.add(fillTongTien3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 60, 40));

        fillTongLT.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        fillTongLT.setForeground(new java.awt.Color(0, 255, 0));
        roundPanel3.add(fillTongLT, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 200, 40, 40));

        fillTongLThn.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        fillTongLThn.setForeground(new java.awt.Color(0, 255, 0));
        roundPanel3.add(fillTongLThn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 260, 40, 40));

        fillLTBanChayNhat.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        fillLTBanChayNhat.setForeground(new java.awt.Color(0, 255, 51));
        roundPanel3.add(fillLTBanChayNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 320, 280, 40));

        fillSoKH.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fillSoKH.setForeground(new java.awt.Color(0, 255, 0));
        roundPanel3.add(fillSoKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 90, 40));

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("MÁY");
        roundPanel3.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 200, -1, 40));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("SỐ TIỀN HÔM NAY ĐÃ BÁN :");
        roundPanel3.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, -1, 40));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("SỐ HÓA ĐƠN :");
        roundPanel3.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, -1, 40));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("LAPTOP BÁN CHẠY NHẤT :");
        roundPanel3.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 320, -1, 40));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("TỔNG SỐ TIỀN ĐÃ BÁN :");
        roundPanel3.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, -1, 40));

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("HÔM NAY ĐÃ BÁN :");
        roundPanel3.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 260, -1, 40));

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("SỐ KHÁCH HÀNG ĐÃ MUA :");
        roundPanel3.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, -1, 40));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 money 1.png"))); // NOI18N
        roundPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, -1, -1));

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("MÁY");
        roundPanel3.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 260, -1, 40));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 a 0.png"))); // NOI18N
        roundPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 a 0.png"))); // NOI18N
        roundPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 100, -1, -1));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 a 02.png"))); // NOI18N
        roundPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        jTabbedPane1.addTab("Thống kê doanh thu ", roundPanel3);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jTabbedPane2.setBackground(new java.awt.Color(51, 51, 51));
        jTabbedPane2.setForeground(new java.awt.Color(102, 102, 102));
        jTabbedPane2.setAlignmentX(0.0F);
        jTabbedPane2.setAlignmentY(0.0F);
        jTabbedPane2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTabbedPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane2MouseClicked(evt);
            }
        });
        jTabbedPane2.addTab("Thống kê doanh thu", chartTKDT);
        jTabbedPane2.addTab("Thống kê NSX", chartNSX);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblLT.setBackground(new java.awt.Color(51, 51, 51));
        tblLT.setForeground(new java.awt.Color(255, 255, 255));
        tblLT.setModel(new javax.swing.table.DefaultTableModel(
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
        tblLT.setGridColor(new java.awt.Color(255, 255, 255));
        tblLT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLT);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 540, 330));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SẢN PHẨM BÁN CHẠY");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));
        jPanel2.add(fillImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 135, 135));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 a 6.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 170, 180));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Danh sách VGA bán chạy");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 280, -1, 30));

        tblVGA.setBackground(new java.awt.Color(51, 51, 51));
        tblVGA.setForeground(new java.awt.Color(255, 255, 255));
        tblVGA.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblVGA);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 320, 390, 190));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Danh sách RAM & ROM bán chạy");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 280, -1, 30));

        tblRR.setBackground(new java.awt.Color(51, 51, 51));
        tblRR.setForeground(new java.awt.Color(255, 255, 255));
        tblRR.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblRR);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 320, 390, 190));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Danh sách CPU bán chạy");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, -1, 30));

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
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tblCPU);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, 390, 190));

        tblMH.setBackground(new java.awt.Color(51, 51, 51));
        tblMH.setForeground(new java.awt.Color(255, 255, 255));
        tblMH.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tblMH);

        jPanel2.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 70, 390, 190));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Danh sách Màn Hình bán chạy");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 30, -1, 30));

        jTabbedPane2.addTab("Thống kê top Laptop ", jPanel2);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblNV.setBackground(new java.awt.Color(51, 51, 51));
        tblNV.setForeground(new java.awt.Color(255, 255, 255));
        tblNV.setModel(new javax.swing.table.DefaultTableModel(
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
        tblNV.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane6.setViewportView(tblNV);

        jPanel3.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 780, 410));

        tblKH.setBackground(new java.awt.Color(51, 51, 51));
        tblKH.setForeground(new java.awt.Color(255, 255, 255));
        tblKH.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKH.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane7.setViewportView(tblKH);

        jPanel3.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 120, 730, 410));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Thống kê Nhân viên");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Thống kê Khách hàng");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 50, -1, -1));

        jTabbedPane2.addTab("Thống kê Nhân Viên & Khách Hàng", jPanel3);

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(roundPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 314, 1620, 590));

        roundPanel5.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        roundPanel5.add(lineChartTKSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 1000, 210));

        jPanel1.add(roundPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(603, 49, 1030, 213));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Biều đồ thống kê số lượng sản phẩm đã bán");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, -1, -1));

        roundPanel1.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(51, 51, 51));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Danh mục thống kê :");
        roundPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        chooseYears.setBackground(new java.awt.Color(255, 255, 255));
        chooseYears.setAlignmentX(0.0F);
        chooseYears.setAlignmentY(0.0F);
        chooseYears.setDoubleBuffered(false);
        roundPanel1.add(chooseYears, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 80, 35));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1text100x35.png"))); // NOI18N
        roundPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Năm thống kê :");
        roundPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Ngày bắt đầu :");
        roundPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        dateStart.setBackground(new java.awt.Color(255, 255, 255));
        dateStart.setAlignmentX(0.0F);
        dateStart.setAlignmentY(0.0F);
        roundPanel1.add(dateStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 180, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Ngày kết thúc :");
        roundPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));
        roundPanel1.add(dateEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 180, 30));

        btnNgay.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnNgay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 a 5.png"))); // NOI18N
        btnNgay.setAlignmentY(0.0F);
        btnNgay.setBorder(null);
        btnNgay.setBorderPainted(false);
        btnNgay.setContentAreaFilled(false);
        btnNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNgayActionPerformed(evt);
            }
        });
        roundPanel1.add(btnNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 60, 40));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/200x30.png"))); // NOI18N
        roundPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/200x30.png"))); // NOI18N
        roundPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        btnNam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 a 10.png"))); // NOI18N
        btnNam.setToolTipText("");
        btnNam.setBorder(null);
        btnNam.setBorderPainted(false);
        btnNam.setContentAreaFilled(false);
        btnNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNamActionPerformed(evt);
            }
        });
        roundPanel1.add(btnNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, -1, -1));

        jPanel1.add(roundPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 510, 210));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(220, 220, 220));
        jLabel5.setText("Thống kê doanh thu");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 210, -1));

        btnNSX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 a9.png"))); // NOI18N
        btnNSX.setBorder(null);
        btnNSX.setBorderPainted(false);
        btnNSX.setContentAreaFilled(false);
        btnNSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNSXActionPerformed(evt);
            }
        });
        jPanel1.add(btnNSX, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 a 7.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Biểu đồ thống kê doanh thu");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 270, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1 a 8.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, -1, -1));

        jTabbedPane1.addTab("Thống kê theo biểu đồ", jPanel1);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1660, 950));
    }// </editor-fold>//GEN-END:initComponents

    private void btnNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNamActionPerformed

        int year = chooseYears.getYear();
        JOptionPane.showMessageDialog(this, "Bạn thống kê doanh thu năm " + year);
        chartTKDT.clear();
        lineChartTKSP.clear();
        initThongKeTheoNam(year);
        chartTKDT.start();
        lineChartTKSP.start();

    }//GEN-LAST:event_btnNamActionPerformed

    private void jTabbedPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseClicked

    }//GEN-LAST:event_jTabbedPane2MouseClicked

    private void btnNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNgayActionPerformed

        chartTKDT.clear();
        lineChartTKSP.clear();
        date15TKDT();
        chartTKDT.start();
        lineChartTKSP.start();
    }//GEN-LAST:event_btnNgayActionPerformed

    private void btnNSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNSXActionPerformed
        chartNSX.clear();
        for (ThongKeNSX x : list) {
            String sl = String.valueOf(x.getSoLuong());
            Double a = Double.parseDouble(sl);
            chartNSX.addData(new ModelChart(x.getTenNSX(), new double[]{a}));
        }
        chartNSX.start();
    }//GEN-LAST:event_btnNSXActionPerformed

    private void tblLTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLTMouseClicked

        listSP = tkSe.getAll();
        int row = tblLT.getSelectedRow();

        TKSP t = listSP.get(row);

        String b = t.getAnh();

        ImageIcon img = new ImageIcon("src/Image/Image Laptops/" + b);
        int widght = fillImage.getWidth();
        int height = fillImage.getHeight();
        Image image = img.getImage(); // transform it 
        Image newimg = image.getScaledInstance(widght, height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        img = new ImageIcon(newimg);
        fillImage.setIcon(img);
    }//GEN-LAST:event_tblLTMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        listCPU = tkSe.getAllCPU();
        listSP = tkSe.getAll();
        listRR = tkSe.getAllRR();
        listVGA = tkSe.getAllVGA();
        listMH = tkSe.getAllMH();
        showDataTableCPU();
        showDataTableLT();
        showDataTableMH();
        showDataTableRR();
        showDataTableVGA();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        listKH = tkNVKH.getListKH();
        listNV = tkNVKH.getListNV();
        showDataTableKH();
        showDataTableNV();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNSX;
    private javax.swing.JButton btnNam;
    private javax.swing.JButton btnNgay;
    private com.raven.chart.Chart chartNSX;
    private com.raven.chart.Chart chartTKDT;
    private com.toedter.calendar.JYearChooser chooseYears;
    private com.toedter.calendar.JDateChooser dateEnd;
    private com.toedter.calendar.JDateChooser dateStart;
    private javax.swing.JLabel fillHD;
    private javax.swing.JLabel fillImage;
    private javax.swing.JLabel fillLTBanChayNhat;
    private javax.swing.JLabel fillSoKH;
    private javax.swing.JLabel fillTongLT;
    private javax.swing.JLabel fillTongLThn;
    private javax.swing.JLabel fillTongTien;
    private javax.swing.JLabel fillTongTien1;
    private javax.swing.JLabel fillTongTien3;
    private javax.swing.JLabel fillTongTienhHomNay;
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
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private com.raven.chart.LineChart lineChartTKSP;
    private com.raven.swing.RoundPanel roundPanel1;
    private com.raven.swing.RoundPanel roundPanel2;
    private com.raven.swing.RoundPanel roundPanel3;
    private com.raven.swing.RoundPanel roundPanel5;
    private javax.swing.JTable tblCPU;
    private javax.swing.JTable tblKH;
    private javax.swing.JTable tblLT;
    private javax.swing.JTable tblMH;
    private javax.swing.JTable tblNV;
    private javax.swing.JTable tblRR;
    private javax.swing.JTable tblTKDT;
    private javax.swing.JTable tblVGA;
    // End of variables declaration//GEN-END:variables

}
