/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory.impl;

import domainmodels.ChiTietSp;
import domainmodels.VoucherLaptop;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import responsitory.KhuyenMaiSanPhamRepository;
import untilities.HibernateUtil;

/**
 *
 * @author DELL
 */
public class KhuyenMaiSanPhamRepositoryImpl implements KhuyenMaiSanPhamRepository{

    @Override
    public List<VoucherLaptop> getAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        List<VoucherLaptop> lt = null;
        Session ss = sf.openSession();
        try {
            Criteria crt = ss.createCriteria(VoucherLaptop.class);
            lt = crt.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lt;
    }
    
    private Session session = HibernateUtil.getSessionFactory().openSession();
    
    @Override
    public boolean themVLT(VoucherLaptop lt) {
        try {
            session.getTransaction().begin();
            lt.setTrangThai(1);
            session.merge(lt);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean suaVLT(VoucherLaptop lt) {
        try {
            session.getTransaction().begin();
            lt.setTrangThai(1);
            session.merge(lt);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean xoa(String id) {
        try {
            session.getTransaction().begin();
            VoucherLaptop lt = (VoucherLaptop) session.get(VoucherLaptop.class, id);
            lt.setTrangThai(0);
            session.merge(lt);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public VoucherLaptop getByID(String id) {
        try {
            VoucherLaptop lt = (VoucherLaptop) session.get(VoucherLaptop.class, id);
            return lt;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ChiTietSp getChiTietByID(String id) {
        try {
            ChiTietSp lt = (ChiTietSp) session.get(ChiTietSp.class, id);
            return lt;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean suaCTSP(ChiTietSp sp) {
        try {
            session.getTransaction().begin();
            session.merge(sp);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public List<ChiTietSp> getAllCT() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        List<ChiTietSp> lt = null;
        Session ss = sf.openSession();
        try {
            Criteria crt = ss.createCriteria(ChiTietSp.class);
            lt = crt.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lt;
    }
    
}
