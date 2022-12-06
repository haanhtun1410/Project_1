/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory;

import domainmodels.Laptop;
import domainmodels.ThongKeNSX;
import domainmodels.VCLTandDong;
import java.util.List;

/**
 *
 * @author nhanp
 */
public interface LaptopRe {

    List<Laptop> getAll();

    boolean insert(Laptop lt);

    boolean update(String idLapTop, Laptop lt);
    
    boolean delete(String idLapTop);

    List<Laptop> getNamSX(int namSX);

    List<Laptop> getDongLT(String IDdongLT);

    List<Laptop> getNSX(String idNSX);

    List<Laptop> getTrangThai(int trangThai);

    List<Laptop> searchByName(String tenLaptop);

    List<Laptop> getGiathapCao();

    List<Laptop> getGiaCaoThap();

    List<Laptop> getKhoangGia(double giaMin, double giaMax);

    List<VCLTandDong> getVCLT();

    List<VCLTandDong> getDongLT();

    List<ThongKeNSX> getNSX();

    String getIDNSXbyName(String tenNSX);

    String getIDVCLTbyName(String tenVC);

    String getIDDongLTbyName(String tenDong);
    
    String getNameDongLTByID(String IDDongLT);
    
    String getNameVoucherByID(String idVoucher);
    
    String getNameNSXByID(String idNSX);

}
