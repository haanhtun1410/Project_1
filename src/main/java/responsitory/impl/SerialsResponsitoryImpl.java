/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory.impl;

import customModels.ImeiCustom;
import domainmodels.Cthd;
import domainmodels.Serial;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import responsitory.SerialsResponsitory;
import untilities.HibernateUtil;

public class SerialsResponsitoryImpl implements SerialsResponsitory {

    @Override
    public boolean updateSerials(Cthd cthd) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        try {
            SQLQuery createSQLQuery = ss.createSQLQuery("SELECT top (?) imei from serial where IdCTSP = :IdCTSP and TrangThai = 0");
            createSQLQuery.setInteger(0, cthd.getSoLuong());
            createSQLQuery.setParameter("IdCTSP", cthd.getChiTietSp().getId());
            List<String> listImei = createSQLQuery.list();

            String qry = "update Serial set TrangThai = :TrangThai ,IdCTHD = :IdCTHD \n"
                    + "where IMEI = :IMEI";
            Query createQuery = ss.createQuery(qry);
            listImei.forEach((x) -> {
                System.out.println(x.toString());
                Transaction transaction = ss.beginTransaction();
                createQuery.setParameter("IMEI", x);
                createQuery.setParameter("IdCTHD", cthd.getId());
                createQuery.setParameter("TrangThai", 1);
                createQuery.executeUpdate();
                transaction.commit();
                System.out.println("da xong ;" + listImei.indexOf(x));
            });
        } catch (HibernateException e) {
            System.out.println("loo ne: " + e);
            return false;
        }
        return true;
    }

    @Override
    public List<Serial> getImei(String idCTDHD) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session ss = factory.openSession();
        List<Serial> imeis = null;
        try {
            String sql = "select e from Serial e inner join e.cthd p where p.id = :id";
            Query createQuery = ss.createQuery(sql);
            createQuery.setParameter("id", idCTDHD);
            imeis = createQuery.list();

        } catch (Exception e) {
            System.out.println(e);
        }
        return imeis;
    }
  
}
