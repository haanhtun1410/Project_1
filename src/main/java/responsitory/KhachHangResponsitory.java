/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory;

import domainmodels.KhachHang;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author longv
 */
public interface KhachHangResponsitory {

    List<KhachHang> getAll();

    List<KhachHang> getAll1();

    KhachHang getById(String id);

    Boolean add(KhachHang kh);

    Boolean update(KhachHang kh);

    Boolean delete(String id);

    List<KhachHang> getByTen(String ten);

    KhachHang getBySDT(String id);

    List<KhachHang> getByLoaiKH(String ten);

   boolean updateLoaiKh(String idKh);

    BigDecimal getTien(String id); 

    Boolean addTheoTen(KhachHang kh);
}
