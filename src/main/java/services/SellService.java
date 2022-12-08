/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domainmodels.ChiTietSp;
import domainmodels.Cthd;
import domainmodels.DongSp;
import domainmodels.HoaDon;
import domainmodels.KhachHang;
import domainmodels.Nsx;
import domainmodels.User;
import java.util.List;

/**
 *
 * @author longv
 */
public interface SellService {

    List<ChiTietSp> getAllSP();

    List<ChiTietSp> getSPBy(); 
    
    List<HoaDon> getAllHDC();

    List<Cthd> getAllHDCT();

    List<HoaDon> getAllHD();

    List<User> getAllNV();

    List<KhachHang> getAllKH();

    boolean addHD();

    boolean updateHDTT(HoaDon hoaDon);

    boolean updateHDSave(HoaDon hoaDon);

    boolean addHDCT(Cthd hdct);

    public List<Cthd> getHDCTofHD(HoaDon hd);

    boolean updateSerials(Cthd cthd);

    boolean updateSLSP(String IdCTSP);

    public boolean updateHDShip(HoaDon hoaDon);
    
    public boolean updateHDShipDone(HoaDon hoaDon);

    public List<Nsx> getAllNSX();

    public List<DongSp> getAllDSP();
    
     public boolean updateLoaiKH(String idkh);
    
}
