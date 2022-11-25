/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory;


import domainmodels.User;
import java.util.List;

/**
 *
 * @author longv
 */
public interface NhanVienRespository {
    List<User> getAll();
    
    boolean UserLogin(String idNV,String mk);
    List<User> getAll1();
    
    User getById(String id);
    Boolean add(User kh);
    Boolean update(User kh);
    Boolean delete(String id);
    List<User> getByTen(String ten);
}
