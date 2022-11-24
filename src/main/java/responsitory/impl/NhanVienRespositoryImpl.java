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
    public boolean UserLogin(String idNV, String mk) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session ss = factory.openSession();
        int result;
        try {
            String sql = "select count(*) from [User] where id = :id and matkhau = :mk";
            SQLQuery createSQLQuery = ss.createSQLQuery(sql);
            createSQLQuery.setParameter("id", idNV);
            createSQLQuery.setParameter("mk", mk);
            result = (int) createSQLQuery.uniqueResult();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

        return result == 1 ? true : false;
    }
}
