/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domainmodels.VoucherLaptop;
import java.util.List;

/**
 *
 * @author huyki
 */
public interface VoucherLapTopService {
     List<VoucherLaptop> getAll();
    boolean add(VoucherLaptop voucherLaptop);
    boolean update(VoucherLaptop voucherLaptop);
    boolean delete(String id);
}
