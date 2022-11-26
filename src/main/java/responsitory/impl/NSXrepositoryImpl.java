/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory.impl;


import domainmodels.Nsx;
import java.util.List;
import org.hibernate.*;
import untilities.HibernateUtil;
import responsitory.NSXrepository;

/**
 *
 * @author DELL
 */
public class NSXrepositoryImpl implements NSXrepository{
    private final SessionFactory sf = HibernateUtil.getSessionFactory();

    @Override
    public List<Nsx> getNSX() {
        //Session ss = sf.openSession();
        try {
            
            return sf.openSession().createCriteria(Nsx.class).list();
           
        } catch (HibernateException e) {
            return null;
        }
    }

    @Override
    public boolean them(Nsx a) {
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().save(a);
            sf.getCurrentSession().getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean sua(Nsx a) {
        try {
            sf.getCurrentSession().beginTransaction();
            
            sf.getCurrentSession().update(a);
            sf.getCurrentSession().getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean xoa(Nsx a) {
        try {
            sf.getCurrentSession().beginTransaction();
            
            sf.getCurrentSession().delete(a);
            sf.getCurrentSession().getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }
}
