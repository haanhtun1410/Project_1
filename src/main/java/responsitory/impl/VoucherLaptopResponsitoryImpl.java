/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory.impl;

import domainmodels.VoucherLaptop;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import responsitory.VoucherLaptopResponsitory;
import untilities.HibernateUtil;

/**
 *
 * @author huyki
 */
public class VoucherLaptopResponsitoryImpl implements VoucherLaptopResponsitory{
    private Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public List<VoucherLaptop> getAll() {
        String hql = "from VoucherLaptop";

        Query query = session.createQuery(hql);
       // System.out.println("ok");
        List<VoucherLaptop> list = query.list();
       // System.out.println("ok");
        //Criteria criteria = session.createCriteria(VoucherLaptop.class);

        return list;
    }
    
    @Override
    public  boolean  add(VoucherLaptop voucherLaptop){
        try {
            session.getTransaction().begin();
            session.save(voucherLaptop);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public  boolean update(VoucherLaptop voucherLaptop){
        try {
            session.getTransaction().begin();
            session.saveOrUpdate(voucherLaptop);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return false;
        }
    }
    
    @Override
    public  boolean delete(String id){
        try {
            session.getTransaction().begin();
            VoucherLaptop vch = (VoucherLaptop) session.get(VoucherLaptop.class, id);
            session.delete(vch);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return false;
        }
    }
//    public static void main(String[] args) throws ParseException {
//        
//        DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
//        String t = "23/11/2022";
//        String x = "30/11/2022";
//        Date t1 = f.parse(t);
//        Date x1 =f.parse(x);
//        VoucherLaptop v = new VoucherLaptop("dfa", "aaaaa", BigDecimal.valueOf(500), 0, t1, x1);
//        boolean check = new VoucherLaptopResponsitoryImpl().delete("dfa");
//        System.out.println(check);
//        
//    }

}
