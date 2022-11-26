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
import org.hibernate.Query;
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
    private Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public List<KhachHang> getAll1() {
        List<KhachHang> list = null;
        try {
            Criteria criteria = session.createCriteria(KhachHang.class);
            list = criteria.list();

        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    @Override
    public Boolean add(KhachHang kh) {

        try {
            session.getTransaction().begin();
            session.saveOrUpdate(kh);
            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e);
            session.getTransaction().rollback();
            return false;
        }
        return true;
    }

    @Override
    public Boolean update(KhachHang kh) {
        
        try {
            session.getTransaction().begin();
            session.merge(kh);
            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e);
            session.getTransaction().rollback();
            return false;
        }
        return true;
    }

    @Override
    public Boolean delete(String id) {

        try {
            session.getTransaction().begin();
            KhachHang kh = (KhachHang) session.get(KhachHang.class, id);
            session.delete(kh);
            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e);
            session.getTransaction().rollback();
            return false;
        }
        return true;
    }

    @Override
    public KhachHang getById(String id) {
        KhachHang kh = (KhachHang) session.get(KhachHang.class, id);
        return kh;
    }

    @Override
    public List<KhachHang> getByTen(String ten) {
        try {
            session.getTransaction().begin();
            //p.ten là ten trong model
            String hql = "from KhachHang p where p.ten like :Ten1";
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
    

