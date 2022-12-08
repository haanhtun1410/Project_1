/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domainmodels.User;
import java.util.List;

/**
 *
 * @author huyki
 */
public interface NhanVienServices {
    List<User> getAll1();
    
    User getById(String id);
    Boolean add(User kh);
    Boolean update(User kh);
    Boolean delete(String id);
    List<User> getByTen(String ten);
    User getBySDT(String id);
    List<User> getByGioiTinh(String id);
    Boolean addKhTheoTen(User kh);
    
    List<User> getByChucVu(String id);
}
