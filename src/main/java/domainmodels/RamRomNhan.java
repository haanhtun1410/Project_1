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
public class RamRomNhan {
    private String idRR;
    private String tenRR;
    private int trangThai;
    private String soluong;

    public RamRomNhan() {
    }

    public RamRomNhan(String idRR, String tenRR, Integer trangThai) {
        this.idRR = idRR;
        this.tenRR = tenRR;
        this.trangThai = trangThai;
    }

    public RamRomNhan(String tenRR, String soluong) {
        this.tenRR = tenRR;
        this.soluong = soluong;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }
    
    

    public String getIdRR() {
        return idRR;
    }

    public String getTenRR() {
        return tenRR;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setIdRR(String idRR) {
        this.idRR = idRR;
    }

    public void setTenRR(String tenRR) {
        this.tenRR = tenRR;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "RamRomNhan{" + "idRR=" + idRR + ", tenRR=" + tenRR + ", trangThai=" + trangThai + '}';
    }
    
}
