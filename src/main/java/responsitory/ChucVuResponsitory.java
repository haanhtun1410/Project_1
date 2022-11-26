/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory;

import domainmodels.ChucVu;
import java.util.List;

/**
 *
 * @author huyki
 */
public interface ChucVuResponsitory {
    List<ChucVu> getAll();
    ChucVu getById(String id);
    ChucVu getByName1(String id);
}
