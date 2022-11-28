/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import domainmodels.Nsx;
import java.util.List;
import responsitory.impl.NSXrepositoryImpl;
import responsitory.NSXrepository;
import services.NSXservice;

/**
 *
 * @author DELL
 */
public class NSXserviceImpl implements NSXservice{
    NSXrepository RP = new NSXrepositoryImpl();
    
    @Override
    public List<Nsx> getNSX() {
        return RP.getNSX();
    }

    @Override
    public boolean them(Nsx a) {
        return RP.them(a);
    }

    @Override
    public boolean sua(Nsx a) {
        return RP.sua(a);
    }

    @Override
    public boolean xoa(Nsx a) {
        return RP.xoa(a);
    }
    
}
