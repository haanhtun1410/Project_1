/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import domainmodels.LoaiKh;
import java.util.List;
import responsitory.LoaiKHResponsitory;
import responsitory.impl.LoaiKHResponsitoryImpl;
import services.LoaiKHService;

/**
 *
 * @author huyki
 */
public class LoaiKHServiceImpl implements LoaiKHService{
    private LoaiKHResponsitory loaiKHResponsitory = new LoaiKHResponsitoryImpl();
    @Override
    public List<LoaiKh> getAll() {
        return loaiKHResponsitory.getAll();
    }
    @Override
    public LoaiKh getById(String id) {
        return loaiKHResponsitory.getById(id);
    }

    @Override
    public LoaiKh getByTen(String id) {
        return loaiKHResponsitory.getByTen(id);
    }
}
