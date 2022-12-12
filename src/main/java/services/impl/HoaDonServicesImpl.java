/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import customModels.ImeiCustom;
import domainmodels.Cthd;
import domainmodels.HoaDon;
import domainmodels.Serial;
import java.util.List;
import responsitory.ChiTietSPRespository;
import responsitory.HDCTRespository;
import responsitory.HDRespository;
import responsitory.SerialsResponsitory;
import services.HoaDonServices;

public class HoaDonServicesImpl implements HoaDonServices {

    private ChiTietSPRespository chiTietSPRespository;
    private HDCTRespository chiTietHDRespository;
    private HDRespository hDRespository;
    private SerialsResponsitory serialsResponsitory;

    public HoaDonServicesImpl(ChiTietSPRespository chiTietSPRespository, HDCTRespository chiTietHDRespository, HDRespository hDRespository, SerialsResponsitory serialsResponsitory) {
        this.chiTietSPRespository = chiTietSPRespository;
        this.chiTietHDRespository = chiTietHDRespository;
        this.hDRespository = hDRespository;
        this.serialsResponsitory = serialsResponsitory;
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
    public List<Cthd> getHDCTofHD(HoaDon hd) {
        return chiTietHDRespository.getHDCTofHD(hd);
    }

    @Override
    public List<HoaDon> getAllHDC() {
        return hDRespository.getAllHDC();
    }

    @Override
    public List<Serial> getImeis(String idCTHD) {
       return serialsResponsitory.getImei(idCTHD);
    }

    @Override
    public boolean DoiTra(String imei) {
        return serialsResponsitory.DoiTra(imei);
    }

    @Override
    public boolean xoaHDtrong(String idhd) {
        return hDRespository.xoaHDtrong(idhd);
    }

    @Override
    public boolean xoaHDCho(String idhd) {
        return hDRespository.xoaHDCho(idhd);
    }

    @Override
    public boolean capNhatVanChuyen(String idhd) {
       return hDRespository.capNhatVanChuyen(idhd);
    }

}
