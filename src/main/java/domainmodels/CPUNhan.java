/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodels;

import customModels.*;

/**
 *
 * @author nhanp
 */
public class CPUNhan {
    private String idCPU;
    private String tenCPU;
    private int trangThai;
    private String sl;
    

    public CPUNhan() {
    }

    public CPUNhan(String idCPU, String tenCPU, int trangThai) {
        this.idCPU = idCPU;
        this.tenCPU = tenCPU;
        this.trangThai = trangThai;
    }

    public CPUNhan(String idCPU, String sl) {
        this.idCPU = idCPU;
        this.sl = sl;
    }

    public String getSl() {
        return sl;
    }

    public void setSl(String sl) {
        this.sl = sl;
    }

    
    public String getIdCPU() {
        return idCPU;
    }

    public String getTenCPU() {
        return tenCPU;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setIdCPU(String idCPU) {
        this.idCPU = idCPU;
    }

    public void setTenCPU(String tenCPU) {
        this.tenCPU = tenCPU;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "CPUNhan{" + "idCPU=" + idCPU + ", tenCPU=" + tenCPU + ", trangThai=" + trangThai + '}';
    }
    
}
