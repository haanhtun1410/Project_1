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
public class Laptop {

    private String idLaptop;
    private String tenLaptop;
    private String idNSX;
    private String idDongSP;
    private String idVoucher;
    private String idVGA;
    private String idCPU;
    private String idMH;
    private String idRR;
    private int namSX;
    private int namBH;
    private String moTa;
    private int soLuongTon;
    private double giaBan;
    private String anh;
    private int trangThai;

    public Laptop() {
    }

    public Laptop(String idLaptop, String tenLaptop, String idNSX, String idDongSP, String idVoucher, String idVGA, String idCPU, String idMH, String idRR, int namSX, int namBH, String moTa, int soLuongTon, double giaBan, String anh, int trangThai) {
        this.idLaptop = idLaptop;
        this.tenLaptop = tenLaptop;
        this.idNSX = idNSX;
        this.idDongSP = idDongSP;
        this.idVoucher = idVoucher;
        this.idVGA = idVGA;
        this.idCPU = idCPU;
        this.idMH = idMH;
        this.idRR = idRR;
        this.namSX = namSX;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaBan = giaBan;
        this.anh = anh;
        this.trangThai = trangThai;
    }

    public Laptop(String tenLaptop, String idNSX, String idDongSP, String idVoucher, String idVGA, String idCPU, String idMH, String idRR, int namSX, int namBH, String moTa, int soLuongTon, double giaBan, String anh, int trangThai) {
        this.tenLaptop = tenLaptop;
        this.idNSX = idNSX;
        this.idDongSP = idDongSP;
        this.idVoucher = idVoucher;
        this.idVGA = idVGA;
        this.idCPU = idCPU;
        this.idMH = idMH;
        this.idRR = idRR;
        this.namSX = namSX;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaBan = giaBan;
        this.anh = anh;
        this.trangThai = trangThai;
    }

    public Laptop(String tenLaptop, String idNSX, String idDongSP, String idVoucher) {
        this.tenLaptop = tenLaptop;
        this.idNSX = idNSX;
        this.idDongSP = idDongSP;
        this.idVoucher = idVoucher;
    }

    public Laptop(String tenLaptop, String idNSX, String idVoucher, String idVGA, String idCPU, String idMH, String idRR, int namSX, int namBH, String moTa, int soLuongTon, double giaBan, String anh, int trangThai) {
        this.tenLaptop = tenLaptop;
        this.idNSX = idNSX;
        this.idVoucher = idVoucher;
        this.idVGA = idVGA;
        this.idCPU = idCPU;
        this.idMH = idMH;
        this.idRR = idRR;
        this.namSX = namSX;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaBan = giaBan;
        this.anh = anh;
        this.trangThai = trangThai;
    }

    

    public String getIdVGA() {
        return idVGA;
    }

    public String getIdCPU() {
        return idCPU;
    }

    public String getIdMH() {
        return idMH;
    }

    public String getIdRR() {
        return idRR;
    }

    public void setIdVGA(String idVGA) {
        this.idVGA = idVGA;
    }

    public void setIdCPU(String idCPU) {
        this.idCPU = idCPU;
    }

    public void setIdMH(String idMH) {
        this.idMH = idMH;
    }

    public void setIdRR(String idRR) {
        this.idRR = idRR;
    }

    public String getIdLaptop() {
        return idLaptop;
    }

    public String getTenLaptop() {
        return tenLaptop;
    }

    public String getIdNSX() {
        return idNSX;
    }

    public String getIdDongSP() {
        return idDongSP;
    }

    public String getIdVoucher() {
        return idVoucher;
    }

    public int getNamSX() {
        return namSX;
    }

    public int getNamBH() {
        return namBH;
    }

    public String getMoTa() {
        return moTa;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public String getAnh() {
        return anh;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setIdLaptop(String idLaptop) {
        this.idLaptop = idLaptop;
    }

    public void setTenLaptop(String tenLaptop) {
        this.tenLaptop = tenLaptop;
    }

    public void setIdNSX(String idNSX) {
        this.idNSX = idNSX;
    }

    public void setIdDongSP(String idDongSP) {
        this.idDongSP = idDongSP;
    }

    public void setIdVoucher(String idVoucher) {
        this.idVoucher = idVoucher;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }

    public void setNamBH(int namBH) {
        this.namBH = namBH;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "Laptop{" + "idLaptop=" + idLaptop + ", tenLaptop=" + tenLaptop + ", idNSX=" + idNSX + ", idDongSP=" + idDongSP + ", idVoucher=" + idVoucher + ", namSX=" + namSX + ", namBH=" + namBH + ", moTa=" + moTa + ", soLuongTon=" + soLuongTon + ", giaBan=" + giaBan + ", anh=" + anh + ", trangThai=" + trangThai + '}';
    }
}
