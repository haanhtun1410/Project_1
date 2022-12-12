
package domainmodels;

import java.util.Date;

public class TKSP {

    private String tenSP;
    private String soLuong;
    private String anh;

    private Date ngayThanhToan;
    private String idNV;
    private String idKH;
    private double tongTien;
    private int tongSP;

    public TKSP() {
    }

    public TKSP(Date ngayThanhToan, String idNV, String idKH, double tongTien, int tongSP) {
        this.ngayThanhToan = ngayThanhToan;
        this.idNV = idNV;
        this.idKH = idKH;
        this.tongTien = tongTien;
        this.tongSP = tongSP;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public int getTongSP() {
        return tongSP;
    }

    public void setTongSP(int tongSP) {
        this.tongSP = tongSP;
    }

    public TKSP(String tenSP, String soLuong, String anh) {
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.anh = anh;
    }

    public String getTenSP() {
        return tenSP;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public String getAnh() {
        return anh;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    @Override
    public String toString() {
        return "TKSP{" + "tenSP=" + tenSP + ", soLuong=" + soLuong + ", anh=" + anh + ", ngayThanhToan=" + ngayThanhToan + ", idNV=" + idNV + ", idKH=" + idKH + ", tongTien=" + tongTien + ", tongSP=" + tongSP + '}';
    }

    

}
