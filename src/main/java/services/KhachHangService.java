/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domainmodels.KhachHang;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author huyki
 */
public interface KhachHangService {
    List<KhachHang> getAll1();
    KhachHang getById(String id);
    Boolean add(KhachHang kh);
    Boolean update(KhachHang kh);
    Boolean delete(String id);
    List<KhachHang> getByTen(String ten);
    KhachHang getBySDT(String id);
    List<KhachHang> getByLoaiKH(String ten);
    BigDecimal getTien(String id);
    Boolean addTheoTen(KhachHang kh);
}
