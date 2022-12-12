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
public class DisplayNhan {
    private String id;
    private String tenDisplay;
    private int trangThai;
    private String sl;
    
    public DisplayNhan() {
    }

    public DisplayNhan(String id, String tenDisplay, int trangThai) {
        this.id = id;
        this.tenDisplay = tenDisplay;
        this.trangThai = trangThai;
    }

    public DisplayNhan(String tenDisplay, String sl) {
        this.tenDisplay = tenDisplay;
        this.sl = sl;
    }

    public String getSl() {
        return sl;
    }

    public void setSl(String sl) {
        this.sl = sl;
    }

    
    public String getId() {
        return id;
    }

    public String getTenDisplay() {
        return tenDisplay;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTenDisplay(String tenDisplay) {
        this.tenDisplay = tenDisplay;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "DisplayNhan{" + "id=" + id + ", tenDisplay=" + tenDisplay + ", trangThai=" + trangThai + '}';
    }
    
}
