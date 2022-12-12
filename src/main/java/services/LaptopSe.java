/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domainmodels.Laptop;
import domainmodels.ThongKeNSX;
import domainmodels.VCLTandDong;
import java.util.List;

/**
 *
 * @author nhanp
 */
public interface LaptopSe {

    List<Laptop> getAll();

    List<Laptop> getOne();
    
    String insertImei(String id , int sl);

    String refreshTT(String id);
    
    String insert(Laptop lt);

    String update(String idLapTop, Laptop lt);

    String delete(String idLaptop);

    List<Laptop> getNamSX(int namSX);

    List<Laptop> getDongLT(String IDdongLT);

    List<Laptop> getCPU(String IDcpu);

    List<Laptop> getAVG(String idAVG);

    List<Laptop> getMH(String IDmh);

    List<Laptop> getRAMROM(String idRR);

    List<Laptop> getNSX(String idNSX);

    List<Laptop> getTrangThai(int trangThai);

    List<Laptop> searchByName(String tenLaptop);

    List<Laptop> getGiathapCao();

    List<Laptop> getGiaCaoThap();

    List<Laptop> getKhoangGia(double giaMin, double giaMax);

    List<VCLTandDong> getVCLT();

    List<VCLTandDong> getDongLT();

    List<ThongKeNSX> getNSX();

    String getNameDongLTByID(String IDDongLT);

    String getNameVoucherByID(String idVoucher);

    String getNameNSXByID(String idNSX);

    String getIDNSXbyName(String tenNSX);

    String getIDVCLTbyName(String tenVC);

    String getIDDongLTbyName(String tenDong);
}
