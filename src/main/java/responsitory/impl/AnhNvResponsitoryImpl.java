/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory.impl;

import domainmodels.AnhNv;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import responsitory.AnhNvResponsitory;
import untilities.HibernateUtil;

/**
 *
 * @author huyki
 */
public class AnhNvResponsitoryImpl implements AnhNvResponsitory{
    private Session session = HibernateUtil.getSessionFactory().openSession();
    
    @Override
    public  List<AnhNv> getAll(){
        Criteria criteria = session.createCriteria(AnhNv.class);
        return criteria.list();
    }
    
    @Override
    public  AnhNv getById(String id){
        AnhNv anhNv = (AnhNv) session.get(AnhNv.class, id);
        return anhNv;
    }
    
    
    public static void main(String[] args) {
        List<AnhNv> list = new AnhNvResponsitoryImpl().getAll();
        for(AnhNv x : list){
            System.out.println(x.toString());
        }
    }
}
