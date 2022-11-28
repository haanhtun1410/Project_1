/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import domainmodels.ChiTietSp;
import domainmodels.Nsx;
import java.util.List;
import responsitory.ChiTietSPRespository;
import responsitory.impl.ChiTietSPRespositoyImpl;
import services.ChiTietSpService;

/**
 *
 * @author ASUS
 */
public class ChiTietSpServiceImpl implements ChiTietSpService{
private ChiTietSPRespository chiTietSPRespository = new ChiTietSPRespositoyImpl();
    @Override
    public List<ChiTietSp> getAllCT() {
        return chiTietSPRespository.getAll();
        
    }

    @Override
    public ChiTietSp getByMa(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String add(ChiTietSp chiTietSp) {
        boolean addChiTietSP = chiTietSPRespository.add(chiTietSp);
        if (addChiTietSP) {
            return "Thêm Thành Công";
        }
    return "Thêm Thất Bại";
    }

    @Override
    public String update(String id, ChiTietSp chiTietSp) {
        boolean updateChiTietSp  = chiTietSPRespository.updateSLSP(id);
        if (updateChiTietSp) {
            return "Sửa Thành Công";
        }
    return "Sửa Thất bại";
        
    }

    @Override
    public String delete(String id) {
        boolean deleteChiTietSp = chiTietSPRespository.delete(id);
        if (deleteChiTietSp) {
            return "Xóa Thành Công";
        }
        return "Xáo Thất Bại";
    }

    @Override
    public List<Nsx> getAllNSX() {
        return chiTietSPRespository.getAllNSX();
    }
    
}
