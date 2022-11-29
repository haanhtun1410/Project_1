/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import domainmodels.User;
import responsitory.NhanVienRespository;
import responsitory.impl.NhanVienRespositoryImpl;
import services.LoginServices;


public class LoginServicesImpl implements LoginServices {
     
    NhanVienRespository nhanVienRespository = new NhanVienRespositoryImpl();
    
    @Override
    public User loginCheck(String idNV,String mk) {
       return nhanVienRespository.UserLogin(idNV, mk);
    }
    
}
