/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory;

import domainmodels.ThongKeKH;
import domainmodels.ThongKeNV;
import java.util.List;

/**
 *
 * @author nhanp
 */
public interface ThongKeNVKHRe {

    List<ThongKeKH> getListKH();

    List<ThongKeNV> getListNV();
}
