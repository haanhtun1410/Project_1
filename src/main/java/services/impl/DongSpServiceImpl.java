/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import domainmodels.DongSp;
import java.util.List;
import responsitory.DongSPRepository;
import responsitory.impl.DongspRepositoryImpl;
import services.DongSpService;

/**
 *
 * @author ASUS
 */
public class DongSpServiceImpl implements DongSpService{
private DongSPRepository dongSPRepository = new DongspRepositoryImpl();

    @Override
    public List<DongSp> getAllSp() {
      return dongSPRepository.getAll();
      
    }

    @Override
    public DongSp getByma(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String add(DongSp dongSp) {
        boolean addDongsp = dongSPRepository.add(dongSp);
        if (addDongsp) {
            return "Thêm Thành Công";
        }
        return "Thêm Thất Bại";
    }

    @Override
    public String update(String id, DongSp dongSp) {
        boolean updateDongsp = dongSPRepository.updateDong(id );
        if (updateDongsp) {
            return "Sửa Thành Công";
        }
        return "Sửa Thất Bại";
    }

    @Override
    public String delete(String id) {
        boolean deleteDongSp = dongSPRepository.delete(id);
        if (deleteDongSp) {
            return "Xóa Thành Công";
        }
        return "Xóa Thất Bại";
    }
    
}
