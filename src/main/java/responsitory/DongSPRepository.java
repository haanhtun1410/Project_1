/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory;

import domainmodels.DongSp;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface DongSPRepository {
    List<DongSp> getAll();
    boolean updateDong(String id );
    boolean add(DongSp dongSp);
    boolean delete(String id);
}
