/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory.impl;

import domainmodels.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import responsitory.NhanVienRespository;
import untilities.HibernateUtil;

public class NhanVienRespositoryImpl implements NhanVienRespository {

    @Override
    public List<User> getAll() {
        List<User> listNV = null;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        try {
            String sql = "from User";
            Query createQuery = ss.createQuery(sql);
            listNV = createQuery.list();

        } catch (HibernateException e) {
            System.out.println(e);
        }
        return listNV;
    }

    /*   @Override
    public List<CustomNhanVien> getCustom() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session ss = factory.openSession();
        List<CustomNhanVien> customNhanViens = null;
        try {
            ss.beginTransaction();
            String sql = "select n.ho + ' ' + n.tenDem + ' ' + n.ten as hoTen ,n.gioiTinh as gioiTinh ,n.ngaySinh as ngaySinh ,n.diaChi as diaChi,n.sdt as sdt ,n.chucVu.ten as ChucVu,n.cuaHang.ten as CuaHang ,n.trangThai as Trangthai from NhanVien n ";
            Query createQuery = ss.createQuery(sql);
            createQuery.setResultTransformer(Transformers.aliasToBean(CustomNhanVien.class));
            customNhanViens = createQuery.list();
            ss.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return customNhanViens;
    }*/

 /*   public List<NhanVienTest> getNVTs() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session ss = factory.openSession();
        List<NhanVienTest> nhanVienTests = null;
        try {
            ss.beginTransaction();
            String sql = "select n.ma as ma, n.ho as ho, n.tenDem as tenDem, n.ten as ten ,n.gioiTinh as gioiTinh,n.sdt as sdt from NhanVien n ";
            Query createQuery = ss.createQuery(sql);
            createQuery.setResultTransformer(Transformers.aliasToBean(NhanVienTest.class));
            nhanVienTests = createQuery.list();
            ss.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return nhanVienTests;
    }

    public NhanVienTest getNVTByMa(String ma) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session ss = factory.openSession();
        NhanVienTest nhanVienTests = null;
        try {
            ss.beginTransaction();
            String sql = "select n.ma as ma, n.ho as ho, n.tenDem as tenDem, n.ten as ten ,n.gioiTinh as gioiTinh,n.sdt as sdt from NhanVien n where n.ma = :ma ";
            Query createQuery = ss.createQuery(sql);
            createQuery.setParameter("ma", ma);
            createQuery.setResultTransformer(Transformers.aliasToBean(NhanVienTest.class));
            nhanVienTests = (NhanVienTest) createQuery.uniqueResult();
            ss.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return nhanVienTests;
    }
     
    public boolean add(User nv) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session ss = factory.openSession();
        try {
            ss.beginTransaction();
            ss.save(nv);
            ss.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
     */
    @Override
    public User UserLogin(String idNV, String mk) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session ss = factory.openSession();
        User result;
        try {
            Criteria criteria = ss.createCriteria(User.class);
            criteria.add(Restrictions.and(Restrictions.eq("matKhau", mk), Restrictions.eq("id", idNV)));
            result = (User) criteria.uniqueResult();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

        return result == null ? null : result;
    }
   

    @Override
    public List<User> getAll1() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> list = null;
        try {
            Criteria criteria = session.createCriteria(User.class);
            list = criteria.list();
        } catch (Exception e) {
            System.out.println(e);
        }

        if (list.size() > 0) {
            return list;
        } else {
            System.out.println("lỗi");
        }

        return null;
    }

    @Override
    public User getById(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {

            String hql = "from User where id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            List<User> list = query.list();

            return list.size() > 0 ? list.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public Boolean add(User kh) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (kh != null) {
            System.out.println("Da co du lieu");
        } else {
            System.out.println("Chua co du lieu");
        }

        try {
            session.getTransaction().begin();
            session.save(kh);
            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e);

            return false;
        }
        return true;
    }
    
    @Override
    public Boolean addKhTheoTen(User kh) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String numberSQL = "SELECT TOP 1 CONVERT(INT,SUBSTRING(Id,6,DATALENGTH(Id))) AS number FROM dbo.[User] WHERE Id LIKE :ten1 ORDER BY number DESC";
        SQLQuery createNumber = session.createSQLQuery(numberSQL);
        createNumber.setParameter("ten1", "%" + kh.getId() + "%");
            System.out.println("Ket qua " + createNumber.uniqueResult());
            String id;
            if (createNumber.uniqueResult() == null) {
                id = kh.getId()+"1";
            } else {
                Integer number = (int) createNumber.uniqueResult();
                System.out.println(number);
                number++;
                id = kh.getId() + number;
            }   
            kh.setId(id);

        try {
            session.getTransaction().begin();
            session.save(kh);
            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e);

            return false;
        }
        return true;
    }

    @Override
    public Boolean update(User kh) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();

            //session.saveOrUpdate(kh); khhoonf dung đc vì có khả nang trùng
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
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            User us = (User) session.get(User.class, id);

            session.delete(us);
            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e);
            session.getTransaction().rollback();
            return false;
        }
        return true;
    }

    @Override
    public List<User> getByTen(String ten) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> list = null;
        try {
            session.getTransaction().begin();
            String hql = "from User p where p.Ten like :ten1";
            Query query = session.createQuery(hql);
            query.setParameter("ten1", "%" + ten + "%");
            list = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            session.getTransaction().rollback();
            return null;
        }
        return list;
    }
    
    @Override
    public  User getBySDT(String sdt){
        Session session = HibernateUtil.getSessionFactory().openSession();
        User  us = null;
        try {
            session.getTransaction().begin();
            String hql = "from User p where p.sdt = :sdt1";
            Query query = session.createQuery(hql);
            query.setParameter("sdt1",sdt);
            us = (User) query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            session.getTransaction().rollback();
            return null;
        }
        return us;
    }
    
    @Override
    public List<User> getByGioiTinh(String id) {
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session ss = sf.openSession();
            //p.ten là ten trong model
            String hql = "from User WHERE GioiTinh = :id";
            Query query = ss.createQuery(hql);
            query.setParameter("id",id);
            List<User> list = query.list();
            return list;
        } catch (Exception e) {

            e.printStackTrace();
            return null;

        }
    }
    
    @Override
    public List<User> getByChucVu(String id) {
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session ss = sf.openSession();
            //p.ten là ten trong model
            String hql = "from User WHERE IdCV = :id";
            Query query = ss.createQuery(hql);
            query.setParameter("id",id);
            List<User> list = query.list();
            return list;
        } catch (Exception e) {

            e.printStackTrace();
            return null;

        }
    }
//    public static void main(String[] args) {
////        List<User> list = new NhanVienRespositoryImpl().getByChucVu("CV01");
////        for(User x : list){
////            System.out.println(x.toString());
////        }
//        User us = new User("nv", "HUY", "dhsuad", "dsajha");
//    boolean check = new NhanVienRespositoryImpl().addKhTheoTen(us);
//    
//    }
    
}
