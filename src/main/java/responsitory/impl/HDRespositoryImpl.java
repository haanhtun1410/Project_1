/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory.impl;

import domainmodels.HoaDon;
import java.util.Date;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import responsitory.HDRespository;
import untilities.HibernateUtil;

public class HDRespositoryImpl implements HDRespository {

    @Override
    public List<HoaDon> getAll() {
        List<HoaDon> listHD = null;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        try {
            Criteria cr = ss.createCriteria(HoaDon.class);
            listHD = cr.list();
        } catch (HibernateException e) {
            System.out.println(e);
        }
        return listHD;
    }

    @Override
    public boolean addTempHD() {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        try {
            String sql = "SELECT top 1 id FROM HoaDon ORDER BY id DESC ";
            SQLQuery createSQLQuery = ss.createSQLQuery(sql);
            String id = (String) createSQLQuery.uniqueResult();
            if (id == null) {
                id = "HD1";
            } else {
                int co = id.length();
                String txt = id.substring(0, 2);
                String num = id.substring(2, co);
                int n = Integer.parseInt(num);
                n++;
                String snum = Integer.toString(n);
                id = txt + snum;
            }
            System.out.println(id);
            ss.beginTransaction();
            HoaDon hoaDon = new HoaDon(id, new Date(System.currentTimeMillis()));
            ss.save(hoaDon);
            ss.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            ss.getTransaction().rollback();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateHDTT(HoaDon hoaDon) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session ss = factory.openSession();
        try {
            Transaction transaction = ss.beginTransaction();
            String qry = "update HoaDon set TinhTrang = :TinhTrang , IdNV = :IdNV , IdKH = :IdKH , DiaChi = :DiaChi ,NgayThanhToan = :ntt ,TongTien = :tongTien where id = :id";
            Query createQuery = ss.createQuery(qry);
            createQuery.setParameter("id", hoaDon.getId());
            createQuery.setParameter("IdNV", hoaDon.getUser().getId());
            createQuery.setParameter("IdKH", hoaDon.getKhachHang().getId());
            createQuery.setParameter("ntt", hoaDon.getNgayThanhToan());
            createQuery.setParameter("TinhTrang", hoaDon.getTinhTrang());
            createQuery.setParameter("DiaChi", hoaDon.getDiaChi());

            createQuery.setParameter("tongTien", hoaDon.getTongTien());
            createQuery.executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public List<HoaDon> getAllHDC() {
        List<HoaDon> listHD = null;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        try {
            Criteria cr = ss.createCriteria(HoaDon.class);
            cr.add(Restrictions.or(Restrictions.eq("tinhTrang", 2), Restrictions.eq("tinhTrang", 0)));
            listHD = cr.list();
        } catch (HibernateException e) {
            System.out.println(e);
        }
        return listHD;
    }

    @Override
    public boolean updateHDSave(HoaDon hoaDon) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session ss = factory.openSession();
        try {
            Transaction transaction = ss.beginTransaction();
            String qry = "update HoaDon set TinhTrang = :TinhTrang , IdNV = :IdNV , IdKH = :IdKH , DiaChi = :DiaChi where id = :id";
            Query createQuery = ss.createQuery(qry);
            createQuery.setParameter("id", hoaDon.getId());
            createQuery.setParameter("IdNV", hoaDon.getUser().getId());
            createQuery.setParameter("IdKH", hoaDon.getKhachHang().getId());
            createQuery.setParameter("TinhTrang", hoaDon.getTinhTrang());
            createQuery.setParameter("DiaChi", hoaDon.getDiaChi());
            createQuery.executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
