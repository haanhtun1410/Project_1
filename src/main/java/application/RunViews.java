/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javax.swing.UIManager;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import services.LoginServices;
import services.impl.LoginServicesImpl;
import untilities.HibernateUtil;

/**
 *
 * @author longv
 */
public class RunViews {

    public static void main(String[] args) {
        LoginServices loginServices = new LoginServicesImpl();
        String result = loginServices.loginCheck("nv01", "longvip") ? "ok" : "ko ok";
        System.out.println(result);
    }
}
