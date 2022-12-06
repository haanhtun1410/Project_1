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
public class VCLTandDong {
    private String idDongLT;
    private String tenDongLt;
    private String idVoucher;
    private String tenVoucher;
    private int  phanTramGiam;

    public VCLTandDong() {
    }

    public VCLTandDong(String idDongLT, String tenDongLt) {
        this.idDongLT = idDongLT;
        this.tenDongLt = tenDongLt;
    }

    public VCLTandDong(String idVoucher, String tenVoucher, int phanTramGiam) {
        this.idVoucher = idVoucher;
        this.tenVoucher = tenVoucher;
        this.phanTramGiam = phanTramGiam;
    }

    public String getIdDongLT() {
        return idDongLT;
    }

    public String getTenDongLt() {
        return tenDongLt;
    }

    public String getIdVoucher() {
        return idVoucher;
    }

    public String getTenVoucher() {
        return tenVoucher;
    }

    public int getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setIdDongLT(String idDongLT) {
        this.idDongLT = idDongLT;
    }

    public void setTenDongLt(String tenDongLt) {
        this.tenDongLt = tenDongLt;
    }

    public void setIdVoucher(String idVoucher) {
        this.idVoucher = idVoucher;
    }

    public void setTenVoucher(String tenVoucher) {
        this.tenVoucher = tenVoucher;
    }

    public void setPhanTramGiam(int phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }

    @Override
    public String toString() {
        return "VCLTaNSXaDong{" + "idDongLT=" + idDongLT + ", tenDongLt=" + tenDongLt + ", idVoucher=" + idVoucher + ", tenVoucher=" + tenVoucher + ", phanTramGiam=" + phanTramGiam + '}';
    }
    
    
    
}
