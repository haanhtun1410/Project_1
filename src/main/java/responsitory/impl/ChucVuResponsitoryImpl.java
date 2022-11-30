/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory.impl;

import domainmodels.ChucVu;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import responsitory.ChucVuResponsitory;
import untilities.HibernateUtil;

/**
 *
 * @author huyki
 */
public class ChucVuResponsitoryImpl implements ChucVuResponsitory{
    private Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public List<ChucVu> getAll() {
        Criteria criteria = session.createCriteria(ChucVu.class);
        //String hql = "from ChucVu";
        // query = (Query) session.createQuery(hql);

        return criteria.list();
    }

    @Override
    public ChucVu getById(String id) {
        Criteria criteria = session.createCriteria(ChucVu.class);
        
        List<ChucVu> list = criteria.list();
        for(int i=0;i<=list.size();i++){
            if(id.equals(list.get(i).getId())){
                return list.get(i);
            }else{
                return null;
            }
        }
        
//        try {
//            session.beginTransaction();
//            String hql = "From ChucVu where id = :id";
//
//            Query query =  session.createQuery(hql);
//            query.setParameter("id", id);
//            List<ChucVu> list = query.list();
//            session.getTransaction().commit();
//            return list.size() > 0 ? list.get(0) : null;
//        } catch (Exception e) {
//            System.out.println("lỗi");
//        }

        return null;
    }

    @Override
    public ChucVu getByName1(String ten){
        ChucVu cv = null;
        try {
            session.beginTransaction();
            String hql = "From ChucVu where ten = :id";

            Query query =  session.createQuery(hql);
            query.setParameter("id", ten);
            cv = (ChucVu) query.uniqueResult();
            session.getTransaction().commit();
            
        } catch (Exception e) {
            System.out.println("lỗi");
            return null;
        }
        return cv;
       
    }
//    public static void main(String[] args) {
//        List<ChucVu> list = new ChucVuResponsitoryImpl().getAll();
//        for (ChucVu x : list) {
//            System.out.println(x);
//        }
//
//        System.out.println("test getById");
//        ChucVu c = new ChucVuResponsitoryImpl().getByName1("Nhân Viên Bán Hàng");
//        if(c !=null){
//            System.out.println(c.toString());
//        }else{
//            System.out.println("lỗi");
//        }
//        
//        
//        
//    }
}
