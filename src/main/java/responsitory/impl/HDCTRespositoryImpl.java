/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory.impl;

import domainmodels.Cthd;
import domainmodels.HoaDon;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import responsitory.HDCTRespository;
import untilities.HibernateUtil;

public class HDCTRespositoryImpl implements HDCTRespository {

    @Override
    public List<Cthd> getAll() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session ss = factory.openSession();
        List<Cthd> listHD = null;
        try {
            Criteria cr = ss.createCriteria(Cthd.class);
            listHD = cr.list();
        } catch (HibernateException e) {
            System.out.println(e);
        }
        return listHD;
    }

    public List<Cthd> getHDCTofHD(HoaDon hd) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session ss = factory.openSession();
        List<Cthd> listHD = null;
        try {
            String sql = "from Cthd where IdHD = :IdHD ";
            Query createQuery = ss.createQuery(sql);
            createQuery.setParameter("IdHD", hd.getId());
            listHD = createQuery.list();
        } catch (HibernateException e) {
            System.out.println(e);
        }
        return listHD;
    }

    @Override
    public boolean add(Cthd hdct) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session ss = factory.openSession();
        try {
            ss.beginTransaction();
            ss.save(hdct);
            ss.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteHDCT(String idCTSP) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session ss = factory.openSession();
        try {
            ss.beginTransaction();
            String sql = "delete HoaDonChiTiet where IdChiTietSP = :IdCTSP";
            Query createQuery = ss.createQuery(sql);
            createQuery.setParameter("IdCTSP", idCTSP);
            createQuery.executeUpdate();
            ss.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

}
