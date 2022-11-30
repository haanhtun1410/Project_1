/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory.impl;

import domainmodels.VoucherHd;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import responsitory.VoucherHdRespository;
import untilities.HibernateUtil;

/**
 *
 * @author Laptop88
 */
public class VoucherHdRespositoryImpl implements VoucherHdRespository{

    @Override
    public List<VoucherHd> getAll() {
        List<VoucherHd> listVHD = null;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss= sf.openSession();
        try {
//            String sql = "from VoucherHD";
//            Query createQuery = ss.createQuery(sql);
            Criteria cr = ss.createCriteria(VoucherHd.class);
            listVHD = cr.list();
          
        } catch (Exception e) {
            System.out.println(e);
        }
        return listVHD;
    }

    @Override
    public boolean add(VoucherHd vhd) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        try {
            ss.beginTransaction();
            ss.save(vhd);
            ss.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean update(VoucherHd newvhd, String id) {
    SessionFactory sf = HibernateUtil.getSessionFactory();
       Session ss = sf.openSession();
        try {
            ss.getTransaction().begin();
            ss.saveOrUpdate(newvhd);
            ss.getTransaction().commit();
            return true;
        } catch (Exception e) {
            ss.getTransaction().rollback();
            return false;
        }   
    }

    @Override
    public boolean delete(String id) {
       SessionFactory sf = HibernateUtil.getSessionFactory();
       Session ss = sf.openSession();
        try {
            ss.beginTransaction();
            String sql = "delete VoucherHD where Id= :Id";
            Query createQuery = ss.createQuery(sql);
            createQuery.setParameter("Id", id);
            createQuery.executeUpdate();
            ss.getTransaction().commit();
              
              
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public VoucherHd getById(String id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
       Session ss = sf.openSession();
        Criteria cr = ss.createCriteria(VoucherHd.class);
        
        List<VoucherHd> list = cr.list();
        for (int i = 0; i < list.size(); i++) {
            if(id.equals(list.get(i).getId())){
                return list.get(i);
            }else{
                return null;
            }
        }
        return null;
    }
    
}
