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
public class TKSP {

    private String tenSP;
    private String soLuong;
    private String anh;

    public TKSP() {
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
        return "TKSP{" + "tenSP=" + tenSP + ", soLuong=" + soLuong + ", anh=" + anh + '}';
    }

}
