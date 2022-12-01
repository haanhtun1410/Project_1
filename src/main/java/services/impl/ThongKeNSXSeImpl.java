/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import domainmodels.ThongKeNSX;
import java.util.List;
import responsitory.ThongKeNSXRe;
import responsitory.impl.ThongKeNSXReImpl;
import services.ThongKeNSXSe;

/**
 *
 * @author nhanp
 */
public class ThongKeNSXSeImpl implements ThongKeNSXSe{

    ThongKeNSXRe tk = new ThongKeNSXReImpl();
    @Override
    public List<ThongKeNSX> getAll() {
        return tk.getAll();
    }
    
}
