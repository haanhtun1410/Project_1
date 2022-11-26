/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domainmodels.LoaiKh;
import java.util.List;

/**
 *
 * @author huyki
 */
public interface LoaiKHService {
    List<LoaiKh> getAll();
    LoaiKh getById(String id);
    LoaiKh getByTen(String id);
}
