/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domainmodels.ChiTietSp;
import domainmodels.DongSp;
import domainmodels.Nsx;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface ChiTietSpService {
    List<ChiTietSp> getAllCT();
    ChiTietSp getByMa(String ma);
    List<Nsx> getAllNSX();
    List<DongSp> getAllDongSp();
    Nsx getByTen(String id);
    DongSp DongSpgetByTen(String id);
    String add(ChiTietSp chiTietSp);
    String update(String id, ChiTietSp chiTietSp);
    String delete(String id);
}
