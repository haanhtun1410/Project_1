/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domainmodels.ThongKeNSX;
import java.util.List;

/**
 *
 * @author nhanp
 */
public interface NhaSanXuatSe {
    List<ThongKeNSX> getNSX();

    List<ThongKeNSX> getNSXtt();
    
    String insert(ThongKeNSX nsx);

    String update(ThongKeNSX nsx , String id);

    String delete(String id);
}
