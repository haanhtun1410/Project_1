/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory;


import domainmodels.HoaDon;
import java.util.List;

/**
 *
 * @author longv
 */
public interface HDRespository {

    List<HoaDon> getAll();
    
    List<HoaDon> getAllHDC();

    boolean addTempHD();

    boolean updateHDTT(HoaDon hoaDon);

    public boolean updateHDSave(HoaDon hoaDon);
    
    public boolean updateHDShip(HoaDon hoaDon);
    
    public boolean updateHDShipDone(HoaDon hoaDon);

    public boolean xoaHDtrong(String idhd);

    public boolean xoaHDCho(String idhd);

    public boolean capNhatVanChuyen(String idhd);
}
