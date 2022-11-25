/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import domainmodels.ChucVu;
import java.util.List;
import responsitory.ChucVuResponsitory;
import responsitory.impl.ChucVuResponsitoryImpl;
import services.ChucVuServices;

/**
 *
 * @author huyki
 */
public class ChucVuServicesImpl implements ChucVuServices{
    private ChucVuResponsitory chucVuResponsitory= new ChucVuResponsitoryImpl();
    
    @Override
    public List<ChucVu> getAll() {
        return  chucVuResponsitory.getAll();
    }

    @Override
    public ChucVu getById(String id) {
        return chucVuResponsitory.getById(id);
    }

    @Override
    public ChucVu getByName1(String id) {
        return chucVuResponsitory.getByName1(id);
    }
}
