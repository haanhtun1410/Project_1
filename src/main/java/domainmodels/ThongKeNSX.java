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
    private int soLuong;

    public ThongKeNSX() {
    }

    public ThongKeNSX(String idNSX, String tenNSX) {
        this.idNSX = idNSX;
        this.tenNSX = tenNSX;
    }

    public ThongKeNSX(String tenNSX, int soLuong) {
        this.tenNSX = tenNSX;
        this.soLuong = soLuong;
    }

    public String getTenNSX() {
        return tenNSX;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setTenNSX(String tenNSX) {
        this.tenNSX = tenNSX;
    }

    public void setSoLuong(int soLuong) {
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
        return "ThongKeNSX{" + "idNSX=" + idNSX + ", tenNSX=" + tenNSX + ", soLuong=" + soLuong + '}';
    }

    
    
}
