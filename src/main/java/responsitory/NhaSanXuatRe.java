/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory;

import domainmodels.ThongKeNSX;
import java.util.List;

/**
 *
 * @author nhanp
 */
public interface NhaSanXuatRe {
    List<ThongKeNSX> getNSX();

    List<ThongKeNSX> getNSXtt();
    
    boolean insert(ThongKeNSX nsx);

    boolean update(ThongKeNSX nsx , String id);

    boolean delete(String id);
}
