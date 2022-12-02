/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory.impl;

import domainmodels.LoaiKh;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import responsitory.LoaiKHResponsitory;
import untilities.HibernateUtil;

/**
 *
 * @author huyki
 */
public class LoaiKHResponsitoryImpl implements LoaiKHResponsitory{
         
    @Override
    public List<LoaiKh> getAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Criteria criteria = session.createCriteria(LoaiKh.class);
        return criteria.list();
        
    }
    
    @Override
    public LoaiKh getById(String id){
        Session session = HibernateUtil.getSessionFactory().openSession();

        LoaiKh loaiKh = (LoaiKh) session.get(LoaiKh.class, id);
        return loaiKh;
    }

    @Override
    public LoaiKh getByTen(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        LoaiKh loaiKh = null;
        try {
            session.beginTransaction();
            //loaiKh là lấy tên theo class tạo chứ k lấy theo database
            String hql = "from LoaiKh p where p.ten = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            
            loaiKh = (LoaiKh) query.uniqueResult();
            session.getTransaction().commit();
            return loaiKh;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi getBYTen");
        }
        return loaiKh;
    }
//    public static void main(String[] args) {
//        LoaiKh k = new LoaiKHResponsitoryImpl().getByTen("Gold");
//        if(k!=null){
//            System.out.println(k.toString());
//        }else{
//            System.out.println("Lỗi");
//        }
//        
//    }
}
