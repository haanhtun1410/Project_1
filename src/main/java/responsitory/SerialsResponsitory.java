/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory;

import customModels.ImeiCustom;
import domainmodels.Cthd;
import domainmodels.Serial;
import java.util.List;

/**
 *
 * @author longv
 */
public interface SerialsResponsitory {
    
    boolean updateSerials(Cthd cthd);
    
    List<Serial> getImei(String idCTDHD);
    
    boolean DoiTra(String imei) ;
    
}
