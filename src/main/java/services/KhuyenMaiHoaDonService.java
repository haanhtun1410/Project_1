/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domainmodels.VoucherHd;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface KhuyenMaiHoaDonService {
    List<VoucherHd> getAll();
    
    boolean themVHD(VoucherHd hd);
    boolean suaVHD(VoucherHd hd);
    boolean xoaHD(String id);
    
    VoucherHd getByID(String id);
}
