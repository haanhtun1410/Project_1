/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory.impl;


import domainmodels.ChiTietSp;
import domainmodels.Nsx;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import responsitory.ChiTietSPRespository;
import untilities.HibernateUtil;

/**
 *
 * @author longv
 */
public class ChiTietSPRespositoyImpl implements ChiTietSPRespository {

    @Override
    public List<ChiTietSp> getAll() {
        List<ChiTietSp> listSP = null;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        try {
            Criteria cr = ss.createCriteria(ChiTietSp.class);
            listSP = cr.list();

        } catch (HibernateException e) {
            System.out.println(e);
        }
        return listSP;
    }
    
    @Override
    public boolean updateSLSP( String idCTSP) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session ss = factory.openSession();
        try {
            
            ss.beginTransaction();
            ChiTietSp oldCT = (ChiTietSp) ss.get(ChiTietSp.class, idCTSP);
             SQLQuery createSQLQuery = ss.createSQLQuery("select count(Imei) from serial where Trangthai = 0 and IDCTSP = :id");
            createSQLQuery.setParameter("id", idCTSP);
            int slton = (int) createSQLQuery.uniqueResult();
            System.out.println(slton);
            oldCT.setSoLuongTon(slton);
            ss.update(oldCT);
            ss.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean add(ChiTietSp chiTietSp) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session ss = factory.openSession();
        try {
            ss.beginTransaction();
            ss.save(chiTietSp);
            ss.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    

    @Override
    public boolean delete(String id) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session ss = factory.openSession();
        try {
            ss.beginTransaction();
            String sql = "delete ChiTietSp where Id = :Id";
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
    public List<Nsx> getAllNSX() {
        List<Nsx> listNSX = null;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        try {
            Criteria cr = ss.createCriteria(Nsx.class);
            listNSX = cr.list();

        } catch (HibernateException e) {
            System.out.println(e);
        }
        return listNSX;
        
        }

    
}
