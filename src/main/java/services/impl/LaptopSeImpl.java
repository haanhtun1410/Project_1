/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import domainmodels.Laptop;
import domainmodels.ThongKeNSX;
import domainmodels.VCLTandDong;
import java.util.List;
import responsitory.LaptopRe;
import responsitory.impl.LaptopReImpl;
import services.LaptopSe;

/**
 *
 * @author nhanp
 */
public class LaptopSeImpl implements LaptopSe{

    LaptopRe LTRe = new LaptopReImpl();
    
    @Override
    public List<Laptop> getAll() {
        return LTRe.getAll();
    }

    @Override
    public String insert(Laptop lt) {
        boolean insert = LTRe.insert(lt);
        if (insert) {
            return "Thêm Laptop thành công ! ";
        }else{
            return "Thêm laptop thất bại !";
        }
    }

    @Override
    public String update(String idLapTop, Laptop lt) {
        boolean update = LTRe.update(idLapTop, lt);
        if (update) {
            return "Thay đổi thông tin Laptop thành công ! ";
        }else{
            return "Thay đổi thông tin laptop thất bại !";
        }
    }

    @Override
    public List<Laptop> getNamSX(int namSX) {
        return LTRe.getNamSX(namSX);
    }

    @Override
    public List<Laptop> getDongLT(String IDdongLT) {
        return LTRe.getDongLT(IDdongLT);
    }

    @Override
    public List<Laptop> getNSX(String idNSX) {
        return LTRe.getNSX(idNSX);
    }

    @Override
    public List<Laptop> getTrangThai(int trangThai) {
        return LTRe.getTrangThai(trangThai);
    }

    @Override
    public List<Laptop> searchByName(String tenLaptop) {
        return LTRe.searchByName(tenLaptop);
    }

    @Override
    public List<Laptop> getGiathapCao() {
        return LTRe.getGiathapCao();
    }

    @Override
    public List<Laptop> getGiaCaoThap() {
        return LTRe.getGiaCaoThap();
    }

    @Override
    public List<Laptop> getKhoangGia(double giaMin, double giaMax) {
        return LTRe.getKhoangGia(giaMin, giaMax);
    }

    @Override
    public List<VCLTandDong> getVCLT() {
        return LTRe.getVCLT();
    }

    @Override
    public List<VCLTandDong> getDongLT() {
        return LTRe.getDongLT();
    }

    @Override
    public List<ThongKeNSX> getNSX() {
        return LTRe.getNSX();
    }

    @Override
    public String getNameDongLTByID(String IDDongLT) {
        return LTRe.getNameDongLTByID(IDDongLT);
    }

    @Override
    public String getNameVoucherByID(String idVoucher) {
        return LTRe.getNameVoucherByID(idVoucher);
    }

    @Override
    public String getNameNSXByID(String idNSX) {
        return LTRe.getNameNSXByID(idNSX);
    }

    @Override
    public String getIDNSXbyName(String tenNSX) {
        return LTRe.getIDNSXbyName(tenNSX);
    }

    @Override
    public String getIDVCLTbyName(String tenVC) {
        return LTRe.getIDVCLTbyName(tenVC);
    }

    @Override
    public String getIDDongLTbyName(String tenDong) {
        return LTRe.getIDDongLTbyName(tenDong);
    }

    @Override
    public String delete(String idLaptop) {
        boolean delete = LTRe.delete(idLaptop);
        if (delete) {
            return "Xóa Laptop thành công ! ";
        }else{
            return "Xóa laptop thất bại !";
        }
    }

    @Override
    public List<Laptop> getOne() {
        return LTRe.getOnt();
                
    }

    @Override
    public List<Laptop> getCPU(String IDcpu) {
       return LTRe.getCPU(IDcpu);
    }

    @Override
    public List<Laptop> getAVG(String idAVG) {
        return LTRe.getAVG(idAVG);
    }

    @Override
    public List<Laptop> getMH(String IDmh) {
        return LTRe.getMH(IDmh);
    }

    @Override
    public List<Laptop> getRAMROM(String idRR) {
        return LTRe.getRAMROM(idRR);
    }

    @Override
    public String refreshTT(String id) {
        boolean refresh = LTRe.refreshTT(id);
        if (refresh) {
            return "Sửa đỏi trạng thái thành công";
        }else{
            return "Sửa đổi trạng thái thất bại";
        }
    }

    @Override
    public String insertImei(String id, int sl) {
        boolean insertImei = LTRe.insertImei(id, sl);
        if (insertImei) {
            return "Tạo " + sl + " Imei thành công" ;
        }else{
            return "Tạo Imei thất bại";
        }
    }

    
    
}
