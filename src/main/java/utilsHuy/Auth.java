/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilsHuy;

import domainmodels.User;

/**
 *
 * @author huyki
 */
public class Auth {
     public  static  User user = null;
    public static void clear(){
        Auth.user = null;
    }
    
    public static  boolean  isLogin(){
        //nếu user khac null thì true 
        return Auth.user != null;
    }
    
//    public  static  boolean  isManager(){
//        return  Auth.isLogin()&&user.getChucVu().getTen();
//    }
}
