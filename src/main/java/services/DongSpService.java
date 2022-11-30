/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domainmodels.DongSp;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface DongSpService {
    List<DongSp> getAllSp();
    DongSp getByma(String id);
   String add(DongSp dongSp);
    String update(String id, DongSp dongSp);
    String delete(String id);
    
}
