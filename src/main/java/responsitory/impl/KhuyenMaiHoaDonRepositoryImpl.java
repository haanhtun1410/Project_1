/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory.impl;

import domainmodels.VoucherHd;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import responsitory.KhuyenMaiHoaDonRepository;
import untilities.HibernateUtil;

/**
 *
 * @author DELL
 */
public class KhuyenMaiHoaDonRepositoryImpl implements KhuyenMaiHoaDonRepository{
    private Session session = HibernateUtil.getSessionFactory().openSession();
    
    @Override
    public List<VoucherHd> getAll() {
        List<VoucherHd> list = null;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        try {
            Criteria crt = ss.createCriteria(VoucherHd.class);
            list = crt.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean themVHD(VoucherHd hd) {
        try {
            session.getTransaction().begin();
            hd.setTrangThai(1);
            session.merge(hd);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean suaVHD(VoucherHd hd) {
        try {
            session.getTransaction().begin();
            hd.setTrangThai(1);
            session.merge(hd);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean xoaHD(String id) {
        try {
            session.getTransaction().begin();
            VoucherHd hd = (VoucherHd) session.get(VoucherHd.class, id);
            hd.setTrangThai(0);
            session.merge(hd);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public VoucherHd getByID(String id) {
        try {
            VoucherHd hd = (VoucherHd) session.get(VoucherHd.class, id);
            return hd;
        } catch (Exception e) {
            return null;
        }
    }
    
}
