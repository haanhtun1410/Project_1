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
    private String tenNSX;
    private int soLuong;

    public ThongKeNSX() {
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

    @Override
    public String toString() {
        return "ThongKeNSX{" + "tenNSX=" + tenNSX + ", soLuong=" + soLuong + '}';
    }
    
}
