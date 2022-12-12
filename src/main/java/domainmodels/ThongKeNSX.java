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
public class ThongKeNSX {

    private String idNSX;
    private String tenNSX;
    private Integer soLuong;
    private int trangThai;

    public ThongKeNSX(String idNSX, String tenNSX, int trangThai) {
        this.idNSX = idNSX;
        this.tenNSX = tenNSX;
        this.trangThai = trangThai;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public ThongKeNSX() {
    }

    public ThongKeNSX(String idNSX, String tenNSX) {
        this.idNSX = idNSX;
        this.tenNSX = tenNSX;
    }

    public ThongKeNSX(String tenNSX, Integer soLuong) {
        this.tenNSX = tenNSX;
        this.soLuong = soLuong;
    }

    public String getTenNSX() {
        return tenNSX;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setTenNSX(String tenNSX) {
        this.tenNSX = tenNSX;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getIdNSX() {
        return idNSX;
    }

    public void setIdNSX(String idNSX) {
        this.idNSX = idNSX;
    }

    @Override
    public String toString() {
        return "ThongKeNSX{" + "idNSX=" + idNSX + ", tenNSX=" + tenNSX + ", soLuong=" + soLuong + ", trangThai=" + trangThai + '}';
    }

    

}
