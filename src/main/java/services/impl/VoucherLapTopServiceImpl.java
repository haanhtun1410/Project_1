/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import domainmodels.VoucherLaptop;
import java.util.List;
import responsitory.VoucherLaptopResponsitory;
import responsitory.impl.VoucherLaptopResponsitoryImpl;
import services.VoucherLapTopService;

/**
 *
 * @author huyki
 */
public class VoucherLapTopServiceImpl implements VoucherLapTopService{
    private VoucherLaptopResponsitory voucherLaptopResponsitory = new VoucherLaptopResponsitoryImpl();

    @Override
    public List<VoucherLaptop> getAll() {
        return voucherLaptopResponsitory.getAll();
    }

    @Override
    public boolean add(VoucherLaptop voucherLaptop) {
        return voucherLaptopResponsitory.add(voucherLaptop);
    }

    @Override
    public boolean update(VoucherLaptop voucherLaptop) {
        return voucherLaptopResponsitory.update(voucherLaptop);
    }

    @Override
    public boolean delete(String id) {
        return voucherLaptopResponsitory.delete(id);
    }
}
