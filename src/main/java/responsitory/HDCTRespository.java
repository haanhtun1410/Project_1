/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory;

import domainmodels.HoaDon;
import domainmodels.Cthd;
import java.util.List;

/**
 *
 * @author longv
 */
public interface HDCTRespository {

    List<Cthd> getAll();
    
    List<Cthd> getHDCTofHD(HoaDon hd);

    boolean add(Cthd hdct);
    
    boolean deleteHDCT(String idCTSP);
}
