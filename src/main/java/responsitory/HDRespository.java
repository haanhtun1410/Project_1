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

    boolean updateHD(HoaDon hoaDon);
    
    
}
