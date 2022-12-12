/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import domainmodels.ThongKeNSX;
import java.util.List;
import responsitory.NhaSanXuatRe;
import responsitory.impl.NhaSanXuatReImpls;
import services.NhaSanXuatSe;

/**
 *
 * @author nhanp
 */
public class NhaSanXuatSeImpls implements NhaSanXuatSe{

    private NhaSanXuatRe nsxRe = new NhaSanXuatReImpls();
    
    @Override
    public List<ThongKeNSX> getNSX() {
        return nsxRe.getNSX();
    }

    @Override
    public List<ThongKeNSX> getNSXtt() {
        return nsxRe.getNSXtt();
    }

    @Override
    public String insert(ThongKeNSX nsx) {
        boolean insert = nsxRe.insert(nsx);
        if (insert) {
            return "Tạo mới Nhà Sản Xuất thành công";
        }else{
            return "Tạo mới Nhà Sản Xuất thất bại";
        }
    }

    @Override
    public String update(ThongKeNSX nsx, String id) {
        boolean update = nsxRe.update(nsx, id);
        if (update) {
            return "Sửa thông tin Nhà Sản Xuất thành công";
        }else{
            return "Sửa thông tin Nhà Sản Xuất thất bại";
        }
    }

    @Override
    public String delete(String id) {
        boolean delete = nsxRe.delete(id);
        if (delete) {
            return "Cập nhật tráng thái Nhà Sản Xuất thành công";
        }else{
            return "Cập nhật tráng thái Nhà Sản Xuất thất bại";
        }
    }
    
}
