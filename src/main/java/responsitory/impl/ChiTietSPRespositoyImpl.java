/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory.impl;

import domainmodels.ChiTietSp;
import domainmodels.DongSp;
import domainmodels.Nsx;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
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
    public boolean updateSLSP(String idCTSP) {
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
            ss.getTransaction().rollback();
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

    @Override
    public List<DongSp> getALLDongSP() {
        List<DongSp> listdongsp = null;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        try {
            Criteria cr = ss.createCriteria(DongSp.class);
            listdongsp = cr.list();
        } catch (HibernateException e) {
            System.out.println(e);
        }
        return listdongsp;

    }

    @Override
    public Nsx nsxGetbyten(String id) {
        Nsx nsx = null;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        try {
            ss.beginTransaction();
            String sql = "From NSX p where p.ten = :id";
            Query query = ss.createQuery(sql);
            query.setParameter("id", id);
            nsx = (Nsx) query.uniqueResult();
            ss.getTransaction().commit();
            return nsx;

        } catch (Exception e) {
            System.out.println(e);
        }
        return nsx;
    }

    @Override
    public DongSp DongSPGetByTen(String id) {
        DongSp dongSp = null;
        SessionFactory sr = HibernateUtil.getSessionFactory();
        Session ss = sr.openSession();
        try {
            ss.beginTransaction();
            String sql = "From DongSp p where p.ten = :id";
            Query query = ss.createQuery(sql);
            query.setParameter("id", id);
            dongSp = (DongSp) query.uniqueResult();
            ss.getTransaction().commit();
            return dongSp;
        } catch (Exception e) {
            System.out.println(e);
        }
        return dongSp;
    }
    private SessionFactory sf = HibernateUtil.getSessionFactory();
    Session session = sf.openSession();

    @Override
    public List<ChiTietSp> GetByTen(String ten) {
        try {

            session.getTransaction().begin();
            //p.ten là ten trong model
            String hql = "from ChiTietSP p where p.ten like :Ten1";
            Query query = session.createQuery(hql);
            query.setParameter("Ten1", "%" + ten + "%");
            session.getTransaction().commit();
            return query.list();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.flush();
            session.close();
        }
    }

}
