/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import domainmodels.ChiTietSp;
import domainmodels.VoucherLaptop;
import java.util.List;
import responsitory.KhuyenMaiSanPhamRepository;
import responsitory.impl.KhuyenMaiSanPhamRepositoryImpl;
import services.KhuyenMaiSanPhamService;

/**
 *
 * @author DELL
 */
public class KhuyenMaiSanPhamServiceImpl implements KhuyenMaiSanPhamService{
    
    KhuyenMaiSanPhamRepository rpSP = new KhuyenMaiSanPhamRepositoryImpl();
    
    @Override
    public List<VoucherLaptop> getAll() {
        return rpSP.getAll();
    }

    @Override
    public boolean themVLT(VoucherLaptop lt) {
        return rpSP.themVLT(lt);
    }

    @Override
    public boolean suaVLT(VoucherLaptop lt) {
        return rpSP.suaVLT(lt);
    }

    @Override
    public boolean xoa(String id) {
        return rpSP.xoa(id);
    }

    @Override
    public VoucherLaptop getByID(String id) {
        return rpSP.getByID(id);
    }

    @Override
    public ChiTietSp getChiTietByID(String id) {
        return rpSP.getChiTietByID(id);
    }

    @Override
    public boolean suaCTSP(ChiTietSp sp) {
        return rpSP.suaCTSP(sp);
    }

    @Override
    public List<ChiTietSp> getAllCT() {
        return rpSP.getAllCT();
    }
    
}
