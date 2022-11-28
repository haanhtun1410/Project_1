package com.raven.form;

import com.raven.chart.ModelChart;
import java.awt.Color;
import services.DoanhThuService;
import services.impl.DoanhThuSerImpl;

public class FormThongKeDoanhThu extends javax.swing.JPanel {

    private DoanhThuService dtSe = new DoanhThuSerImpl();
    
    public FormThongKeDoanhThu() {
        initComponents();
        setOpaque(false);
//        int nam = 2022;
//        init(nam);
    }
    
    

    private void init(int nam ) {
        String name1 = "Thống kê doanh thu hàng tháng " + nam; 
        chart.addLegend(name1, new Color(12, 84, 175), new Color(0, 108, 247));
        chart.addData(new ModelChart("January", new double[]{dtSe.DoanhThuThang(1, nam)/1000000}));
        chart.addData(new ModelChart("February", new double[]{dtSe.DoanhThuThang(2, nam)/1000000}));
        chart.addData(new ModelChart("March", new double[]{dtSe.DoanhThuThang(3, nam)/1000000}));
        chart.addData(new ModelChart("April", new double[]{dtSe.DoanhThuThang(4, nam)/1000000}));
        chart.addData(new ModelChart("May", new double[]{dtSe.DoanhThuThang(5, nam)/1000000}));
        chart.addData(new ModelChart("June", new double[]{dtSe.DoanhThuThang(6, nam)/1000000}));
        chart.addData(new ModelChart("July", new double[]{dtSe.DoanhThuThang(7, nam)/1000000}));
        chart.addData(new ModelChart("August", new double[]{dtSe.DoanhThuThang(8, nam)/1000000}));
        chart.addData(new ModelChart("September", new double[]{dtSe.DoanhThuThang(9, nam)/1000000}));
        chart.addData(new ModelChart("October", new double[]{dtSe.DoanhThuThang(10, nam)/1000000}));
        chart.addData(new ModelChart("November", new double[]{dtSe.DoanhThuThang(11, nam)/1000000}));
        chart.addData(new ModelChart("December", new double[]{dtSe.DoanhThuThang(12, nam)/1000000}));
        
        chart.start();
        String name2 = "Thống kê số lượng sản phẩm bán ra hàng tháng năm  " + nam;
        lineChart.addLegend(name2, new Color(186, 37, 37), new Color(241, 100, 120));
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.raven.swing.RoundPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNam = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnXemDoanhThu = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        roundPanel2 = new com.raven.swing.RoundPanel();
        chart = new com.raven.chart.Chart();
        jLabel5 = new javax.swing.JLabel();
        roundPanel3 = new com.raven.swing.RoundPanel();
        lineChart = new com.raven.chart.LineChart();

        roundPanel1.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(220, 220, 220));
        jLabel2.setText("Thống kê doanh thu");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        roundPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 536, -1));

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Danh mục thống kê :");
        roundPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 60, -1, -1));

        txtNam.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtNam.setAlignmentX(0.0F);
        txtNam.setAlignmentY(0.0F);
        txtNam.setBorder(null);
        roundPanel1.add(txtNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 80, 35));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/1text100x35.png"))); // NOI18N
        roundPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, -1));

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Năm thống kê :");
        roundPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

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
        roundPanel1.add(btnXemDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 60, 35));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgsHuy/35x60.png"))); // NOI18N
        jLabel6.setAlignmentY(0.0F);
        roundPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, -1));

        roundPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel5.setBackground(new java.awt.Color(193, 174, 66));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Triệu đồng ");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jLabel5)
                .addGap(23, 23, 23))
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
        chart.clear();
        lineChart.clear();
        int nam = Integer.parseInt(txtNam.getText());
        
        init(nam);
    }//GEN-LAST:event_btnXemDoanhThuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXemDoanhThu;
    private com.raven.chart.Chart chart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private com.raven.chart.LineChart lineChart;
    private com.raven.swing.RoundPanel roundPanel1;
    private com.raven.swing.RoundPanel roundPanel2;
    private com.raven.swing.RoundPanel roundPanel3;
    private javax.swing.JTextField txtNam;
    // End of variables declaration//GEN-END:variables
}
