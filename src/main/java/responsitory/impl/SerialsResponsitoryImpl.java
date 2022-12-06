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
//    public static void main(String[] args) {
//        List<Serial> list = new SerialsResponsitoryImpl().getImei('8C8B3A13-DD2B-47E6-BABF-1B471545031E');
//        
//    }

    @Override
    public boolean DoiTra(String imei) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction beginTransaction = ss.beginTransaction();
        try {
            
            SQLQuery SQL1 = ss.createSQLQuery("select a.IdCTSP from CTHD a join serial s on a.Id = s.IdCTHD where s.IMEI = :imei");
            SQL1.setParameter("imei", imei);
            String idctsp = (String) SQL1.uniqueResult();
            SQLQuery SQL2 = ss.createSQLQuery("select a.Id from CTHD a join serial s on a.Id = s.IdCTHD where s.IMEI = :imei");
            SQL2.setParameter("imei", imei);
           
            String idCTHD = (String) SQL2.uniqueResult();
            System.out.println("idcthd : "+ idCTHD +"-" +idctsp);
            SQLQuery sql3 = ss.createSQLQuery("update serial set TrangThai = 2 ,IdCTHD = null where IMEI = :imei");
            sql3.setParameter("imei", imei);
            sql3.executeUpdate();
            SQLQuery sql4 = ss.createSQLQuery("update top(1) serial set TrangThai = 1 , IdCTHD = :idCTHD where IdCTSP = :IDCTSP and TrangThai = 0");
            sql4.setParameter("idCTHD", idCTHD);
            sql4.setParameter("IDCTSP",idctsp);
            sql4.executeUpdate();
            beginTransaction.commit();
        } catch (HibernateException e) {
            System.out.println("loo ne: " + e);
            beginTransaction.rollback();
            return false;
        }
        return true;
    }

}
