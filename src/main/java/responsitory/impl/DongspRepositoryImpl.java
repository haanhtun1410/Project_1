/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory.impl;

import domainmodels.DongSp;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import responsitory.DongSPRepository;
import untilities.HibernateUtil;

/**
 *
 * @author ASUS
 */
public class DongspRepositoryImpl implements DongSPRepository {

    @Override
    public List<DongSp> getAll() {
        List<DongSp> list = null;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        try {
            Criteria cr = ss.createCriteria(DongSp.class);
            list = cr.list();

        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    @Override
    public boolean updateDong(String id) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session ss = factory.openSession();
        try {
            ss.beginTransaction();
            DongSp dong = (DongSp) ss.get(DongSp.class, id);
            SQLQuery creSQLQuery = ss.createSQLQuery("Update Dongsp set Ten = ? where id = ?");
        } catch (Exception e) {
        }
        return true;
    }

    @Override
    public boolean add(DongSp dongSp) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session ss = factory.openSession();
        try {
            ss.beginTransaction();
            ss.save(dongSp);
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
            String sql = "delete DongSp where id = ?";
            Query createQuery = ss.createQuery(sql);
            createQuery.setParameter("id", id);
            createQuery.executeUpdate();
            ss.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e);
            return false;

        }
        return true;

    }

}
