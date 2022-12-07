package com.raven.form;

import com.raven.chart.ModelChart;
import com.raven.main.Main;
import domainmodels.ThongKeNSX;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import services.DoanhThuService;
import services.ThongKeNSXSe;
import services.impl.DoanhThuSerImpl;
import services.impl.ThongKeNSXSeImpl;

public class FormThongKeDoanhThu extends javax.swing.JPanel {

    private DoanhThuService dtSe = new DoanhThuSerImpl();
    private ThongKeNSXSe nsxSe = new ThongKeNSXSeImpl();
    private List<ThongKeNSX> list = new ArrayList<>();

    public FormThongKeDoanhThu() {
        initComponents();
        setOpaque(false);
        list = nsxSe.getAll();
        initThongKeTheoNam(2022);
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

        String name2 = "Thống kê doanh thu theo ngày";
        chart.addLegend(name2, new Color(12, 84, 175), new Color(0, 108, 247));
        lineChart.addLegend(name2, new Color(186, 37, 37), new Color(241, 100, 120));
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
                        chart.addData(new ModelChart(i + "/" + monthStart, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                        lineChart.addData(new ModelChart(i + "/" + monthStart, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
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
                            chart.addData(new ModelChart(i + "/" + monthStart, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                            lineChart.addData(new ModelChart(i + "/" + monthStart, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                        }
                        for (int i = 1; i < du; i++) {
                            chart.addData(new ModelChart(i + "/" + monthEnd, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                            lineChart.addData(new ModelChart(i + "/" + monthEnd, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
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
                            chart.addData(new ModelChart(i + "/" + monthStart, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                            lineChart.addData(new ModelChart(i + "/" + monthEnd, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                        }
                        for (int i = 1; i < du; i++) {
                            chart.addData(new ModelChart(i + "/" + monthEnd, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                            lineChart.addData(new ModelChart(i + "/" + monthEnd, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
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
                            chart.addData(new ModelChart(i + "/" + monthStart, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                            lineChart.addData(new ModelChart(i + "/" + monthEnd, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                        }
                        for (int i = 1; i < du; i++) {
                            chart.addData(new ModelChart(i + "/" + monthEnd, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                            lineChart.addData(new ModelChart(i + "/" + monthEnd, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
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
                            chart.addData(new ModelChart(i + "/" + monthStart, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                            lineChart.addData(new ModelChart(i + "/" + monthEnd, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                        }
                        for (int i = 1; i < du; i++) {
                            chart.addData(new ModelChart(i + "/" + monthEnd, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                            lineChart.addData(new ModelChart(i + "/" + monthEnd, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
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
                        lineChart.addData(new ModelChart(i + "/" + monthEnd, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                        chart.addData(new ModelChart(i + "/" + monthStart, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                    }
                    for (int i = 1; i < du; i++) {
                        chart.addData(new ModelChart(i + "/" + monthEnd, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                        lineChart.addData(new ModelChart(i + "/" + monthEnd, new double[]{dtSe.DoanhThuNgay(i, monthStart, yearStart) / 1000000}));
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Chỉ được thống kê dưới 15 ngày");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ngoài khoảng thời gian có thể thống kê");
        }
        chart.start();
        lineChart.start();
    }

    private void initThongKeTheoNam(int nam) {

        chart.addData(new ModelChart("January", new double[]{dtSe.DoanhThuThang(1, nam) / 1000000}));
        chart.addData(new ModelChart("February", new double[]{dtSe.DoanhThuThang(2, nam) / 1000000}));
        chart.addData(new ModelChart("March", new double[]{dtSe.DoanhThuThang(3, nam) / 1000000}));
        chart.addData(new ModelChart("April", new double[]{dtSe.DoanhThuThang(4, nam) / 1000000}));
        chart.addData(new ModelChart("May", new double[]{dtSe.DoanhThuThang(5, nam) / 1000000}));
        chart.addData(new ModelChart("June", new double[]{dtSe.DoanhThuThang(6, nam) / 1000000}));
        chart.addData(new ModelChart("July", new double[]{dtSe.DoanhThuThang(7, nam) / 1000000}));
        chart.addData(new ModelChart("August", new double[]{dtSe.DoanhThuThang(8, nam) / 1000000}));
        chart.addData(new ModelChart("September", new double[]{dtSe.DoanhThuThang(9, nam) / 1000000}));
        chart.addData(new ModelChart("October", new double[]{dtSe.DoanhThuThang(10, nam) / 1000000}));
        chart.addData(new ModelChart("November", new double[]{dtSe.DoanhThuThang(11, nam) / 1000000}));
        chart.addData(new ModelChart("December", new double[]{dtSe.DoanhThuThang(12, nam) / 1000000}));
        chart.start();

        lineChart.addData(new ModelChart("January", new double[]{dtSe.SLLaptopBan(1, nam)}));
        lineChart.addData(new ModelChart("February", new double[]{dtSe.SLLaptopBan(2, nam)}));
        lineChart.addData(new ModelChart("March", new double[]{dtSe.SLLaptopBan(3, nam)}));
        lineChart.addData(new ModelChart("April", new double[]{dtSe.SLLaptopBan(4, nam)}));
        lineChart.addData(new ModelChart("May", new double[]{dtSe.SLLaptopBan(5, nam)}));
        lineChart.addData(new ModelChart("June", new double[]{dtSe.SLLaptopBan(6, nam)}));
        lineChart.addData(new ModelChart("July", new double[]{dtSe.SLLaptopBan(7, nam)}));
        lineChart.addData(new ModelChart("August", new double[]{dtSe.SLLaptopBan(8, nam)}));
        lineChart.addData(new ModelChart("September", new double[]{dtSe.SLLaptopBan(9, nam)}));
        lineChart.addData(new ModelChart("October", new double[]{dtSe.SLLaptopBan(10, nam)}));
        lineChart.addData(new ModelChart("November", new double[]{dtSe.SLLaptopBan(11, nam)}));
        lineChart.addData(new ModelChart("December", new double[]{dtSe.SLLaptopBan(12, nam)}));
        lineChart.start();
    }

    private void initNSX() {
        String name = "Thống kê số lượng Laptop của Nhà Sản Xuất đã bán";
        chart4.addLegend(name, new Color(255, 182, 193), new Color(255, 182, 193));
        for (ThongKeNSX x : list) {
            String sl = String.valueOf(x.getSoLuong());
            Double a = Double.parseDouble(sl);
            chart4.addData(new ModelChart(x.getTenNSX(), new double[]{a}));
        }
        chart4.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.raven.swing.RoundPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        chooseYears = new com.toedter.calendar.JYearChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnXemDoanhThu = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dateStart = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        dateEnd = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        roundPanel2 = new com.raven.swing.RoundPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        chart = new com.raven.chart.Chart();
        chart4 = new com.raven.chart.Chart();
        jPanel1 = new javax.swing.JPanel();
        roundPanel3 = new com.raven.swing.RoundPanel();
        lineChart = new com.raven.chart.LineChart();

        roundPanel1.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(220, 220, 220));
        jLabel2.setText("Thống kê doanh thu");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        roundPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 536, -1));

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Danh mục thống kê :");
        roundPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        chooseYears.setBackground(new java.awt.Color(255, 255, 255));
        chooseYears.setAlignmentX(0.0F);
        chooseYears.setAlignmentY(0.0F);
        chooseYears.setDoubleBuffered(false);
        roundPanel1.add(chooseYears, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 80, 35));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1text100x35.png"))); // NOI18N
        roundPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, -1));

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Năm thống kê :");
        roundPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        btnXemDoanhThu.setBackground(new java.awt.Color(255, 255, 255));
        btnXemDoanhThu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnXemDoanhThu.setText("Xem");
        btnXemDoanhThu.setAlignmentY(0.0F);
        btnXemDoanhThu.setBorder(null);
        btnXemDoanhThu.setBorderPainted(false);
        btnXemDoanhThu.setContentAreaFilled(false);
        btnXemDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemDoanhThuActionPerformed(evt);
            }
        });
        roundPanel1.add(btnXemDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 60, 35));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/35x60.png"))); // NOI18N
        jLabel6.setAlignmentY(0.0F);
        roundPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Ngày bắt đầu :");
        roundPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        dateStart.setBackground(new java.awt.Color(255, 255, 255));
        dateStart.setAlignmentX(0.0F);
        dateStart.setAlignmentY(0.0F);
        roundPanel1.add(dateStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 180, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ngày kết thúc :");
        roundPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));
        roundPanel1.add(dateEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 180, 30));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Xem TK");
        jButton1.setAlignmentY(0.0F);
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        roundPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 60, 35));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/35x60.png"))); // NOI18N
        roundPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/200x30.png"))); // NOI18N
        roundPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/200x30.png"))); // NOI18N
        roundPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, -1, -1));

        roundPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jTabbedPane1.setBackground(new java.awt.Color(51, 51, 51));
        jTabbedPane1.setForeground(new java.awt.Color(102, 102, 102));
        jTabbedPane1.setAlignmentX(0.0F);
        jTabbedPane1.setAlignmentY(0.0F);
        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });
        jTabbedPane1.addTab("Thống kê doanh thu", chart);
        jTabbedPane1.addTab("Thống kê NSX", chart4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1147, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Thống kê top Laptop bán chạy", jPanel1);

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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addContainerGap())
        );

        roundPanel3.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lineChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lineChart, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXemDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemDoanhThuActionPerformed

        int nam = chooseYears.getYear();

        String name1 = "Thống kê doanh thu hàng tháng " + nam;
        chart.addLegend(name1, new Color(12, 84, 175), new Color(0, 108, 247));

        String name2 = "Thống kê số lượng sản phẩm bán ra hàng tháng năm  " + nam;
        lineChart.addLegend(name2, new Color(186, 37, 37), new Color(241, 100, 120));

        chart.clear();
        lineChart.clear();

        initThongKeTheoNam(nam);


    }//GEN-LAST:event_btnXemDoanhThuActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        chart4.clear();
        initNSX();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //date15TKDT();
        chart.clear();
        //date15TKDT();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXemDoanhThu;
    private com.raven.chart.Chart chart;
    private com.raven.chart.Chart chart4;
    private com.toedter.calendar.JYearChooser chooseYears;
    private com.toedter.calendar.JDateChooser dateEnd;
    private com.toedter.calendar.JDateChooser dateStart;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.raven.chart.LineChart lineChart;
    private com.raven.swing.RoundPanel roundPanel1;
    private com.raven.swing.RoundPanel roundPanel2;
    private com.raven.swing.RoundPanel roundPanel3;
    // End of variables declaration//GEN-END:variables
}
