/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import domainmodels.CPUNhan;
import domainmodels.DisplayNhan;
import domainmodels.RamRomNhan;
import domainmodels.TKSP;
import domainmodels.VGANhan;
import java.util.List;
import responsitory.ThongKeRe;
import responsitory.impl.ThongKeReImpl;
import services.ThongKeSe;

/**
 *
 * @author nhanp
 */
public class ThongKeSeImpls implements ThongKeSe{

    ThongKeRe tkRe = new ThongKeReImpl();
    
    @Override
    public List<TKSP> getAll() {
        return tkRe.getAll();
    }

    @Override
    public List<RamRomNhan> getAllRR() {
        return tkRe.getAllRR();
    }

    @Override
    public List<VGANhan> getAllVGA() {
        return tkRe.getAllVGA();
    }

    @Override
    public List<DisplayNhan> getAllMH() {
        return tkRe.getAllMH();
    }

    @Override
    public List<CPUNhan> getAllCPU() {
        return tkRe.getAllCPU();
    }

    @Override
    public Double tongTien() {
        return tkRe.tongTien();
    }

    @Override
    public Integer soHD() {
        return tkRe.soHD();
    }

    @Override
    public Integer soSP() {
         return tkRe.soSP();
    }

    @Override
    public Integer soKH() {
        return tkRe.soKH();
    }
    
}
