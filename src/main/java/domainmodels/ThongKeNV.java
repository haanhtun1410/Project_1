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
public class ThongKeNV {
    private String idNV;
    private String tenNV;
    private String sdtNV;
    private double tongTien;
    private int sl;

    public ThongKeNV() {
    }

    public ThongKeNV(String idNV, String tenNV, String sdtNV, double tongTien, int sl) {
        this.idNV = idNV;
        this.tenNV = tenNV;
        this.sdtNV = sdtNV;
        this.tongTien = tongTien;
        this.sl = sl;
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

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    @Override
    public String toString() {
        return "ThongKeNV{" + "idNV=" + idNV + ", tenNV=" + tenNV + ", sdtNV=" + sdtNV + ", tongTien=" + tongTien + ", sl=" + sl + '}';
    }
    
}
