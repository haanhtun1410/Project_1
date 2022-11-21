/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory.impl;


import domainmodels.HoaDon;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
    public boolean addTempHD(HoaDon hoaDon) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        try {
            ss.beginTransaction();
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
    public boolean updateHD(HoaDon hoaDon) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session ss = factory.openSession();
        try {
            Transaction transaction = ss.beginTransaction();
            String qry = "update HoaDon set TinhTrang = :TinhTrang , IdNV = :IdNV ,IdKH = :IdKH \n"
                    + "where id = :id";
            Query createQuery = ss.createQuery(qry);
            createQuery.setParameter("id", hoaDon.getId());
            createQuery.setParameter("IdNV", hoaDon.getUser().getId());
            createQuery.setParameter("IdKH",hoaDon.getKhachHang().getId());
            createQuery.setParameter("TinhTrang", hoaDon.getTinhTrang());
            createQuery.executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

}
