/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import domainmodels.VoucherHd;
import java.util.List;
import responsitory.VoucherHdRespository;
import responsitory.impl.VoucherHdRespositoryImpl;
import services.VoucherHdService;

/**
 *
 * @author Laptop88
 */
public class VoucherHdServiceImpl implements VoucherHdService{
    private VoucherHdRespository VHDrepo = new VoucherHdRespositoryImpl();
    
    
    
    @Override
    public List<VoucherHd> getAll() {
        return VHDrepo.getAll();
    }

    @Override
    public boolean add(VoucherHd vhd) {
        return VHDrepo.add(vhd);
    }

    @Override
    public boolean update(VoucherHd newvhd, String id) {
        return VHDrepo.update(newvhd, id);
    }

    @Override
    public boolean delete(String id) {
        return VHDrepo.delete(id);
    }

    @Override
    public VoucherHd getById(String id) {
       return  VHDrepo.getById(id);
    }
    
}
