/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory;

import domainmodels.VoucherHd;
import java.util.List;

/**
 *
 * @author Laptop88
 */
public interface VoucherHdRespository {
    List<VoucherHd> getAll();
    VoucherHd getById(String id);
    boolean add(VoucherHd vhd);
    
    boolean update(VoucherHd newvhd, String id);
    
    boolean delete(String id);
}
