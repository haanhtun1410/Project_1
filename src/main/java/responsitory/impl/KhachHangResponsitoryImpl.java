/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory.impl;

import domainmodels.HoaDon;
import domainmodels.KhachHang;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import responsitory.KhachHangResponsitory;
import untilities.HibernateUtil;


public class KhachHangResponsitoryImpl implements KhachHangResponsitory {

    @Override
    public List<KhachHang> getAll() {
           List<KhachHang> listKH = null;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        try {
            Criteria cr = ss.createCriteria(KhachHang.class);
            listKH = cr.list();

        } catch (HibernateException e) {
            System.out.println(e);
        }
        return listKH;
    }
    
}
