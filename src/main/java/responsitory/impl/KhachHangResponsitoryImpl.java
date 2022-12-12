/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory.impl;

import domainmodels.HoaDon;
import domainmodels.KhachHang;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;
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
    public Boolean addTheoTen(KhachHang kh) {
        Session session = HibernateUtil.getSessionFactory().openSession();
            String numberSQL = "SELECT TOP 1 CONVERT(INT,SUBSTRING(Id,6,DATALENGTH(Id))) AS number FROM KhachHang WHERE Id LIKE :ten1 ORDER BY number DESC";
            SQLQuery createNumber = session.createSQLQuery(numberSQL);
            createNumber.setParameter("ten1", "%" + kh.getId() + "%");

        //System.out.println("Ket qua " + createNumber.uniqueResult());
        String id;
        if (createNumber.uniqueResult() == null) {
            id = kh.getId() + "1";
        } else {
            Integer number = (int) createNumber.uniqueResult();
            System.out.println(number);
            number++;
            id = kh.getId() + number;
        }
        kh.setId(id);
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
    public KhachHang getBySDT(String id) {
        try {
            Session session1 = HibernateUtil.getSessionFactory().openSession();
            String hql = "from KhachHang p where p.sdt like :Ten1";
            Query query = session1.createQuery(hql);
            query.setParameter("Ten1", id);
            return (KhachHang) query.list().get(0);
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public List<KhachHang> getByTen(String ten) {
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session ss = sf.openSession();
            //p.ten là ten trong model
            String hql = "from KhachHang p where p.ten like :Ten1";
            Query query = ss.createQuery(hql);
            query.setParameter("Ten1", "%" + ten + "%");
            return query.list();
        } catch (Exception e) {

            e.printStackTrace();
            return null;

        }
    }

    @Override
    public BigDecimal getTien(String id) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session ss = factory.openSession();

        BigDecimal number = null;
        try {
            String numberSQL = "select sum(TongTien) from KhachHang k join HoaDon h on k.Id = h.IdKH where k.Id = :id";

            SQLQuery createNumber = ss.createSQLQuery(numberSQL);
            createNumber.setParameter("id", id);
            number = (BigDecimal) createNumber.uniqueResult();
            System.out.println(number);
            //System.out.println("độ dài :" + imeis.size());

        } catch (Exception e) {
            System.out.println(e);
        }
        return number;
    }

    public boolean updateLoaiKh(String idKh) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        try {
            String numberSQL = "select sum(TongTien) from KhachHang k join HoaDon h on k.Id = h.IdKH where k.Id = :id";
            SQLQuery createNumber = ss.createSQLQuery(numberSQL);
            createNumber.setParameter("id", idKh);
            BigDecimal number = (BigDecimal) createNumber.uniqueResult();
            System.out.println(number);
            String loaiKh;
            //so num competo == 0 là 2 bằng nhau
            // >0 thì num lơn hơn 200000000
            //<0 thì nhỏ hơn 200000
            if (number == null) {
                loaiKh = "LHK00";
            } else if (number.intValue() > 0 && number.compareTo(BigDecimal.valueOf(20000000)) < 0) {
                loaiKh = "LKH03";
            } else if (number.compareTo(BigDecimal.valueOf(50000000)) < 0) {
                loaiKh = "LKH01";
            } else {
                loaiKh = "LKH02";
            }
            ss.getTransaction().begin();
            String sql = "UPDATE KhachHang SET idloaiKH = :idLKH WHERE Id = :id ";
            System.out.println("ok");
            SQLQuery creLQuery = ss.createSQLQuery(sql);
            creLQuery.setParameter("idLKH", loaiKh);
            creLQuery.setParameter("id", idKh);
            creLQuery.executeUpdate();
            System.out.println("oke");
            //KhachHang kh = new KhachHang();
            ss.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(System.out);
            ss.getTransaction().rollback();
            return false;
        }
        return true;
    }

    @Override
    public List<KhachHang> getByLoaiKH(String id) {
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session ss = sf.openSession();
            //p.ten là ten trong model
            String hql = "FROM KhachHang WHERE idloaiKH = :id";
            Query query = ss.createQuery(hql);
            query.setParameter("id", id);
            List<KhachHang> list = query.list();
            return list;
        } catch (Exception e) {

            e.printStackTrace();
            return null;

        }
    }

    public static void main(String[] args) {
        KhachHang kh = new KhachHang("ab");
        boolean x = new KhachHangResponsitoryImpl().addTheoTen(kh);
        

        // List<KhachHang> list = new KhachHangResponsitoryImpl().getByLoaiKH();
        // for(KhachHang t : list){
        //     System.out.println(t.toString());
        // }
    }

}
