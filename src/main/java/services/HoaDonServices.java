/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import customModels.ImeiCustom;
import domainmodels.Cthd;
import domainmodels.HoaDon;
import domainmodels.Serial;
import java.util.List;

/**
 *
 * @author longv
 */
public interface HoaDonServices {

    List<HoaDon> getAllHDC();

    List<Cthd> getAllHDCT();

    List<HoaDon> getAllHD();

    List<Cthd> getHDCTofHD(HoaDon hd);
    
    List<Serial> getImeis(String idCTHD);
    
    boolean DoiTra(String imei);

    boolean xoaHDtrong(String idhd);
    
    boolean xoaHDCho(String idhd);
    
    boolean capNhatVanChuyen(String idhd);
}
