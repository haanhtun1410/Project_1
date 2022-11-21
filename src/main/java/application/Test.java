/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import domainmodels.ChiTietSp;
import domainmodels.HoaDon;
import domainmodels.Serial;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import untilities.HibernateUtil;

/**
 *
 * @author longv
 */
public class Test {

    public List<ChiTietSp> getAll() {
        List<ChiTietSp> listCT = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session ss = sessionFactory.openSession();
        try {
            Criteria criteria = ss.createCriteria(ChiTietSp.class);
            listCT = criteria.list();

        } catch (Exception e) {
            System.out.println("sai");
        }
        return listCT;
    }

    public boolean addTempHD(HoaDon hoaDon) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        try {
            ss.beginTransaction();
            ss.save(hoaDon);
            ss.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            ss.getTransaction().rollback();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Serial> listSe = null;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Query createQuery = ss.createQuery("from HoaDon");
        System.out.println(createQuery.list().get(0).toString());;
 
       
    

    }
}
