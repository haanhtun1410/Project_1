/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import domainmodels.ChiTietSp;
import domainmodels.Cthd;
import domainmodels.DongSp;
import domainmodels.HoaDon;
import domainmodels.KhachHang;
import domainmodels.Nsx;
import domainmodels.User;
import java.util.List;
import responsitory.ChiTietSPRespository;
import responsitory.HDCTRespository;
import responsitory.HDRespository;
import responsitory.KhachHangResponsitory;
import responsitory.NhanVienRespository;
import responsitory.SerialsResponsitory;

public class SellServiceImpl implements services.SellService {

    private ChiTietSPRespository chiTietSPRespository;
    private HDCTRespository chiTietHDRespository;
    private HDRespository hDRespository;
    private NhanVienRespository nhanVienRespository;
    private KhachHangResponsitory khachHangResponsitory;
    private SerialsResponsitory serialsResponsitory;

    public SellServiceImpl(ChiTietSPRespository chiTietSPRespository, HDCTRespository chiTietHDRespository, HDRespository hDRespository, NhanVienRespository nhanVienRespository) {
        this.chiTietSPRespository = chiTietSPRespository;
        this.chiTietHDRespository = chiTietHDRespository;
        this.hDRespository = hDRespository;
        this.nhanVienRespository = nhanVienRespository;
    }

    public SellServiceImpl(ChiTietSPRespository chiTietSPRespository, HDCTRespository chiTietHDRespository, HDRespository hDRespository, NhanVienRespository nhanVienRespository, KhachHangResponsitory khachHangResponsitory, SerialsResponsitory serialsResponsitory) {
        this.chiTietSPRespository = chiTietSPRespository;
        this.chiTietHDRespository = chiTietHDRespository;
        this.hDRespository = hDRespository;
        this.nhanVienRespository = nhanVienRespository;
        this.khachHangResponsitory = khachHangResponsitory;
        this.serialsResponsitory = serialsResponsitory;
    }

    public SellServiceImpl(ChiTietSPRespository chiTietSPRespository, HDCTRespository chiTietHDRespository, HDRespository hDRespository, NhanVienRespository nhanVienRespository, KhachHangResponsitory khachHangResponsitory) {
        this.chiTietSPRespository = chiTietSPRespository;
        this.chiTietHDRespository = chiTietHDRespository;
        this.hDRespository = hDRespository;
        this.nhanVienRespository = nhanVienRespository;
        this.khachHangResponsitory = khachHangResponsitory;
    }

    public SellServiceImpl(ChiTietSPRespository chiTietSPRespository, HDCTRespository chiTietHDRespository, HDRespository HDRespository) {
        this.chiTietSPRespository = chiTietSPRespository;
        this.chiTietHDRespository = chiTietHDRespository;
        this.hDRespository = HDRespository;
    }

    public SellServiceImpl(HDRespository hDRespository, NhanVienRespository nhanVienRespository) {
        this.hDRespository = hDRespository;
        this.nhanVienRespository = nhanVienRespository;
    }

    public SellServiceImpl(NhanVienRespository nhanVienRespository) {
        this.nhanVienRespository = nhanVienRespository;
    }

    @Override
    public List<ChiTietSp> getAllSP() {
        return chiTietSPRespository.getAll();
    }

    @Override
    public List<Cthd> getAllHDCT() {
        return chiTietHDRespository.getAll();
    }

    @Override
    public List<HoaDon> getAllHD() {
        return hDRespository.getAll();
    }

    @Override
    public List<User> getAllNV() {
        return nhanVienRespository.getAll();
    }

    @Override
    public boolean addHD() {
        return hDRespository.addTempHD();
    }

    @Override
    public boolean updateHDTT(HoaDon hoaDon) {
        return hDRespository.updateHDTT(hoaDon);
    }

    @Override
    public boolean addHDCT(Cthd hdct) {
        return chiTietHDRespository.add(hdct);
    }

    @Override
    public List<Cthd> getHDCTofHD(HoaDon hd) {
        return chiTietHDRespository.getHDCTofHD(hd);
    }

    @Override
    public List<KhachHang> getAllKH() {
        return khachHangResponsitory.getAll();
    }

    @Override
    public boolean updateSerials(Cthd cthd) {
        return serialsResponsitory.updateSerials(cthd);
    }

    @Override
    public boolean updateSLSP(String IdCTSP) {
        return chiTietSPRespository.updateSLSP(IdCTSP);
    }

    @Override
    public List<HoaDon> getAllHDC() {
        return hDRespository.getAllHDC();
    }

    @Override
    public boolean updateHDSave(HoaDon hoaDon) {
        return hDRespository.updateHDSave(hoaDon);
    }

    @Override
    public boolean updateHDShip(HoaDon hoaDon) {
        return hDRespository.updateHDShip(hoaDon);
    }

    @Override
    public boolean updateHDShipDone(HoaDon hoaDon) {
        return hDRespository.updateHDShipDone(hoaDon);
    }

    @Override
    public List<ChiTietSp> getSPBy() {
        return null;
    }

    @Override
    public List<Nsx> getAllNSX() {
       return chiTietSPRespository.getAllNSX();
    }

    @Override
    public List<DongSp> getAllDSP() {
      return chiTietSPRespository.getALLDongSP();
    }

    @Override
    public boolean updateLoaiKH(String idkh) {
     return khachHangResponsitory.updateLoaiKh(idkh);
    }

}
