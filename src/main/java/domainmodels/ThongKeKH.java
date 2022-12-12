/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodels;

/**
 *
 * @author nhanp
 */
public class ThongKeKH {
    private String idNV;
    private String tenNV;
    private String sdtNV;
    private int soLuong;
    private double tongTien;

    public ThongKeKH() {
    }

    public ThongKeKH(String idNV, String tenNV, String sdtNV, int soLuong, double tongTien) {
        this.idNV = idNV;
        this.tenNV = tenNV;
        this.sdtNV = sdtNV;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getSdtNV() {
        return sdtNV;
    }

    public void setSdtNV(String sdtNV) {
        this.sdtNV = sdtNV;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return "ThongKerNVKH{" + "idNV=" + idNV + ", tenNV=" + tenNV + ", sdtNV=" + sdtNV + ", soLuong=" + soLuong + ", tongTien=" + tongTien + '}';
    }
    
    


    
    
    
}
