/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import domainmodels.KhachHang;
import java.math.BigDecimal;
import java.util.List;
import responsitory.KhachHangResponsitory;
import responsitory.impl.KhachHangResponsitoryImpl;
import services.KhachHangService;

/**
 *
 * @author huyki
 */
public class KhachHangServiceImpl implements KhachHangService{
    private KhachHangResponsitory khachHangResponsitory = new KhachHangResponsitoryImpl();
    
    @Override
    public List<KhachHang> getAll1() {
        return khachHangResponsitory.getAll();
    }

    @Override
    public KhachHang getById(String id) {
        return khachHangResponsitory.getById(id);
    }

    @Override
    public Boolean add(KhachHang kh) {
        return khachHangResponsitory.add(kh);
    }

    

    @Override
    public Boolean delete(String id) {
        return khachHangResponsitory.delete(id);
    }

    @Override
    public List<KhachHang> getByTen(String ten) {
        return khachHangResponsitory.getByTen(ten);
    }

    @Override
    public Boolean update(KhachHang kh) {
        
        return  khachHangResponsitory.update(kh);
    }

    @Override
    public KhachHang getBySDT(String id) {
        return khachHangResponsitory.getBySDT(id);
    }

    @Override
    public List<KhachHang> getByLoaiKH(String ten) {
        return khachHangResponsitory.getByLoaiKH(ten);
    }

    @Override
    public BigDecimal getTien(String id) {
        return  khachHangResponsitory.getTien(id);
    }

    @Override
    public Boolean addTheoTen(KhachHang kh) {
        return  khachHangResponsitory.addTheoTen(kh);
    }
}
