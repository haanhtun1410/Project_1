/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import domainmodels.User;
import java.util.List;
import responsitory.NhanVienRespository;
import responsitory.impl.NhanVienRespositoryImpl;
import services.NhanVienServices;

/**
 *
 * @author huyki
 */
public class NhanVienServicesImpl implements NhanVienServices{
    private NhanVienRespository userResponsitory = new NhanVienRespositoryImpl();

    @Override
    public List<User> getAll1() {
        return userResponsitory.getAll();
    }

    @Override
    public User getById(String id) {
        return userResponsitory.getById(id);
    }

    @Override
    public Boolean add(User kh) {
        return userResponsitory.add(kh);
    }

    @Override
    public Boolean update(User kh) {
        return userResponsitory.update(kh);
    }

    @Override
    public Boolean delete(String id) {
        return userResponsitory.delete(id);
    }

    @Override
    public List<User> getByTen(String ten) {
        return userResponsitory.getByTen(ten);
    }

    @Override
    public User getBySDT(String id) {
        return userResponsitory.getBySDT(id);
    }

    @Override
    public List<User> getByGioiTinh(String id) {
        return userResponsitory.getByGioiTinh(id);
    }

    @Override
    public List<User> getByChucVu(String id) {
        return userResponsitory.getByChucVu(id);
    }

    @Override
    public Boolean addKhTheoTen(User kh) {
        return userResponsitory.addKhTheoTen(kh);
    }
}
