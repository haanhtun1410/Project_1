/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import domainmodels.ThongKeKH;
import domainmodels.ThongKeNV;
import java.util.List;
import responsitory.ThongKeNVKHRe;
import responsitory.impl.ThongKeNVKHReImpl;
import services.ThongKeNSXSe;
import services.ThongKeNVKHSe;

/**
 *
 * @author nhanp
 */
public class ThongKeSeNVKH implements ThongKeNVKHSe{

    ThongKeNVKHRe tkRe = new ThongKeNVKHReImpl();
    @Override
    public List<ThongKeKH> getListKH() {
        return tkRe.getListKH();
    }

    @Override
    public List<ThongKeNV> getListNV() {
        return tkRe.getListNV();
    }
    
}
