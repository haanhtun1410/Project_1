/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domainmodels.ChiTietSp;
import domainmodels.VoucherLaptop;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface KhuyenMaiSanPhamService {
    List<VoucherLaptop> getAll();
    List<ChiTietSp> getAllCT();
    
    boolean themVLT(VoucherLaptop lt);
    boolean suaVLT(VoucherLaptop lt);
    boolean xoa(String id);
    
    VoucherLaptop getByID(String id);
    ChiTietSp getChiTietByID(String id);
    boolean suaCTSP(ChiTietSp sp);
}
