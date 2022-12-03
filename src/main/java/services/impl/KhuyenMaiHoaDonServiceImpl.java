/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import domainmodels.VoucherHd;
import java.util.List;
import responsitory.KhuyenMaiHoaDonRepository;
import responsitory.impl.KhuyenMaiHoaDonRepositoryImpl;
import services.KhuyenMaiHoaDonService;

/**
 *
 * @author DELL
 */
public class KhuyenMaiHoaDonServiceImpl implements KhuyenMaiHoaDonService{
    KhuyenMaiHoaDonRepository rpVHD = new KhuyenMaiHoaDonRepositoryImpl();

    @Override
    public List<VoucherHd> getAll() {
        return rpVHD.getAll();
    }

    @Override
    public boolean themVHD(VoucherHd hd) {
        return rpVHD.themVHD(hd);
    }

    @Override
    public boolean suaVHD(VoucherHd hd) {
        return rpVHD.suaVHD(hd);
    }

    @Override
    public boolean xoaHD(String id) {
        return rpVHD.xoaHD(id);
    }

    @Override
    public VoucherHd getByID(String id) {
        return rpVHD.getByID(id);
    }
    
}
