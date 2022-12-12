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
public class VGANhan {
    private String idVGA;
    private String tenVGA;
    private Integer trangThai;
    private String sl;
    

    public VGANhan() {
    }

    public VGANhan(String idVGA, String tenVGA, Integer trangThai) {
        this.idVGA = idVGA;
        this.tenVGA = tenVGA;
        this.trangThai = trangThai;
    }

    public VGANhan(String tenVGA, String sl) {
        this.tenVGA = tenVGA;
        this.sl = sl;
    }

    public String getSl() {
        return sl;
    }

    public void setSl(String sl) {
        this.sl = sl;
    }

    public String getIdVGA() {
        return idVGA;
    }

    public String getTenVGA() {
        return tenVGA;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setIdVGA(String idVGA) {
        this.idVGA = idVGA;
    }

    public void setTenVGA(String tenVGA) {
        this.tenVGA = tenVGA;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
   
    
}
