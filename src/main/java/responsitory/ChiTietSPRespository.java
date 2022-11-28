/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory;

import domainmodels.ChiTietSp;
import domainmodels.DongSp;
import domainmodels.Nsx;
import java.util.List;

/**
 *
 * @author longv
 */
public interface ChiTietSPRespository {

    List<ChiTietSp> getAll();

    boolean updateSLSP(String idString);

    boolean add(ChiTietSp chiTietSp);

    List<Nsx> getAllNSX();
    
    List<DongSp> getALLDongSP();

    boolean delete(String id);

    Nsx nsxGetbyten(String id);
    
    DongSp DongSPGetByTen(String id);
    
    List<ChiTietSp> GetByTen(String ten);
}
