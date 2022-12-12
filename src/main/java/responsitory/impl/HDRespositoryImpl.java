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
            String numberSQL = "select top 1 CONVERT(int, SUBSTRING(id,3,DATALENGTH(id))) as number from HoaDon order by number desc";
            SQLQuery createNumber = ss.createSQLQuery(numberSQL);
            String id;
            if (createNumber.uniqueResult() == null) {
                id = "HD1";
            } else {
                Integer number = (int) createNumber.uniqueResult();
                System.out.println(number);
                number++;
                id = "HD" + number;
            }
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
            String qry = "update HoaDon set idVoucher = :idvc, TinhTrang = :TinhTrang ,Sdt = :sdt ,TenNguoiNhan =:nguoinhan, IdNV = :IdNV , IdKH = :IdKH , DiaChi = :DiaChi ,NgayThanhToan = :ntt ,TongTien = :tongTien where id = :id";
            Query createQuery = ss.createQuery(qry);
            createQuery.setParameter("id", hoaDon.getId());
            createQuery.setParameter("idvc", hoaDon.getVoucherHd());
            createQuery.setParameter("sdt", hoaDon.getKhachHang().getSdt());
            createQuery.setParameter("nguoinhan", hoaDon.getKhachHang().getTen());
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
            cr.add(Restrictions.or(Restrictions.eq("tinhTrang", 2), Restrictions.eq("tinhTrang", 0), Restrictions.eq("tinhTrang", 3), Restrictions.eq("tinhTrang", 4)));
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
        Transaction transaction = ss.beginTransaction();
        try {
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
            transaction.rollback();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateHDShip(HoaDon hoaDon) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session ss = factory.openSession();
        try {
            Transaction transaction = ss.beginTransaction();
            String qry = "update HoaDon set DiaChi = :dc, idVoucher = :idvc,TinhTrang = :TinhTrang ,Sdt = :sdt,NgayShip =:ngayship,TenNguoiNhan =:nguoinhan,TongTien = :tongtien where id = :id";
            Query createQuery = ss.createQuery(qry);
            createQuery.setParameter("id", hoaDon.getId());
            createQuery.setParameter("dc", hoaDon.getDiaChi());
            createQuery.setParameter("sdt", hoaDon.getSdt());
            createQuery.setParameter("idvc", hoaDon.getVoucherHd());
            createQuery.setParameter("ngayship", hoaDon.getNgayShip());
            createQuery.setParameter("TinhTrang", hoaDon.getTinhTrang());
            createQuery.setParameter("nguoinhan", hoaDon.getTenNguoiNhan());
            createQuery.setParameter("tongtien", hoaDon.getTongTien());
            createQuery.executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateHDShipDone(HoaDon hoaDon) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session ss = factory.openSession();
        try {
            Transaction transaction = ss.beginTransaction();
            String qry = "update HoaDon set TinhTrang = :TinhTrang ,Sdt = :sdt,NgayThanhToan =:ngayTT,NgayNhan =:ngayNhan,TenNguoiNhan =:nguoinhan where id = :id";
            Query createQuery = ss.createQuery(qry);
            createQuery.setParameter("id", hoaDon.getId());
            createQuery.setParameter("sdt", hoaDon.getSdt());
            createQuery.setParameter("ngayTT", hoaDon.getNgayThanhToan());
            createQuery.setParameter("ngayNhan", hoaDon.getNgayNhan());
            createQuery.setParameter("TinhTrang", hoaDon.getTinhTrang());
            createQuery.setParameter("nguoinhan", hoaDon.getTenNguoiNhan());
            createQuery.executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean xoaHDtrong(String idhd) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session ss = factory.openSession();
        Transaction transaction = ss.beginTransaction();
        try {
            SQLQuery createSQLQuery = ss.createSQLQuery("delete from HoaDon where Id = :id");
            createSQLQuery.setParameter("id", idhd);
            createSQLQuery.executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            transaction.rollback();
            return false;
        }
        return true;
    }

    @Override
    public boolean xoaHDCho(String idhd) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session ss = factory.openSession();
        Transaction transaction = ss.beginTransaction();
        try {
            SQLQuery createSQLQuery1 = ss.createSQLQuery("update serial set trangthai = 0, IdCTHD = null where IMEI in (select IMEI from HoaDon h join CTHD c on h.Id = c.IdHD join serial s on s.IdCTHD = c.Id where h.id = :id)");
            createSQLQuery1.setParameter("id", idhd);
            SQLQuery createSQLQuery2 = ss.createSQLQuery("delete from CTHD where IdHD = :id");
            createSQLQuery2.setParameter("id", idhd);
            SQLQuery createSQLQuery3 = ss.createSQLQuery("delete from HoaDon where Id = :id");
            createSQLQuery3.setParameter("id", idhd);
            createSQLQuery1.executeUpdate();
            createSQLQuery2.executeUpdate();
            createSQLQuery3.executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            transaction.rollback();
            return false;
        }
        return true;
    }

    @Override
    public boolean capNhatVanChuyen(String idhd) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session ss = factory.openSession();
        Transaction transaction = ss.beginTransaction();
        try {
            SQLQuery createSQLQuery = ss.createSQLQuery("update HoaDon set TinhTrang = 3, TongTien = null,Sdt = null,TenNguoiNhan = null ,NgayShip = null where id = :id");
            createSQLQuery.setParameter("id", idhd);
            createSQLQuery.executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            transaction.rollback();
            return false;
        }
        return true;
    }
}
