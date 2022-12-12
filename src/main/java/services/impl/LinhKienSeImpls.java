/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import domainmodels.CPUNhan;
import domainmodels.DisplayNhan;
import domainmodels.RamRomNhan;
import domainmodels.VGANhan;
import java.util.List;
import responsitory.LinhKienRe;
import responsitory.impl.LinhKienReImpls;
import services.LinhKienSe;

/**
 *
 * @author nhanp
 */
public class LinhKienSeImpls implements LinhKienSe {
    
    LinhKienRe lkRe = new LinhKienReImpls();
    
    @Override
    public List<CPUNhan> getAllCPU() {
        return lkRe.getAllCPU();
    }
    
    @Override
    public List<DisplayNhan> getAllDisplay() {
        return lkRe.getAllDisplay();
    }
    
    @Override
    public List<RamRomNhan> getAllRR() {
        return lkRe.getAllRR();
    }
    
    @Override
    public List<VGANhan> getAllVGA() {
        return lkRe.getAllVGA();
    }
    
    @Override
    public List<CPUNhan> getAllCPUTT() {
        return lkRe.getAllCPUTT();
    }
    
    @Override
    public List<DisplayNhan> getAllDisplayTT() {
        return lkRe.getAllDisplayTT();
    }
    
    @Override
    public List<RamRomNhan> getAllRRTT() {
        return lkRe.getAllRRTT();
    }
    
    @Override
    public List<VGANhan> getAllVGATT() {
        return lkRe.getAllVGATT();
    }
    
    @Override
    public String insertCPU(CPUNhan cpu) {
        boolean insert = lkRe.insertCPU(cpu);
        if (insert) {
            return "Tạo mới thành công";
        } else {
            return "Tạo mới thất bại";
        }
    }
    
    @Override
    public String insertDisplay(DisplayNhan ds) {
        boolean insert = lkRe.insertDisplay(ds);
        if (insert) {
            return "Tạo mới thành công";
        } else {
            return "Tạo mới thất bại";
        }
    }
    
    @Override
    public String insertRR(RamRomNhan rr) {
        boolean insert = lkRe.insertRR(rr);
        if (insert) {
            return "Tạo mới thành công";
        } else {
            return "Tạo mới thất bại";
        }
    }
    
    @Override
    public String insertVGA(VGANhan vga) {
        boolean insert = lkRe.insertVGA(vga);
        if (insert) {
            return "Tạo mới thành công";
        } else {
            return "Tạo mới thất bại";
        }
    }
    
    @Override
    public String updateCPU(CPUNhan cpu, String idCPU) {
        boolean update = lkRe.updateCPU(cpu, idCPU);
        if (update) {
            return " Sửa thông tin thành công";
        } else {
            return "Sửa thông tin thành công";
        }
    }
    
    @Override
    public String updateDisplay(DisplayNhan ds, String idDisplay) {
        boolean update = lkRe.updateDisplay(ds, idDisplay);
        if (update) {
            return " Sửa thông tin thành công";
        } else {
            return "Sửa thông tin thành công";
        }
    }
    
    @Override
    public String updateRR(RamRomNhan rr, String idRR) {
        boolean update = lkRe.updateRR(rr, idRR);
        if (update) {
            return " Sửa thông tin thành công";
        } else {
            return "Sửa thông tin thành công";
        }
    }
    
    @Override
    public String updateVGA(VGANhan vgva, String idVGA) {
        boolean update = lkRe.updateVGA(vgva, idVGA);
        if (update) {
            return " Sửa thông tin thành công";
        } else {
            return "Sửa thông tin thành công";
        }
    }
    
    @Override
    public String deleteCPU(String idCPU) {
        boolean delete = lkRe.deleteCPU(idCPU);
        if (delete) {
            return "Thay đổi trạngh thái thành công ";
        } else {
            return "Thay đổi trạng thái thất bại";
        }
    }
    
    @Override
    public String deleteDisplay(String idDisplay) {
        boolean delete = lkRe.deleteDisplay(idDisplay);
        if (delete) {
            return "Thay đổi trạngh thái thành công ";
        } else {
            return "Thay đổi trạng thái thất bại";
        }
    }
    
    @Override
    public String deleteRR(String idRR) {
        boolean delete = lkRe.deleteRR(idRR);
        if (delete) {
            return "Thay đổi trạngh thái thành công ";
        } else {
            return "Thay đổi trạng thái thất bại";
        }
    }
    
    @Override
    public String deleteVGA(String idVGA) {
        boolean delete = lkRe.deleteVGA(idVGA);
        if (delete) {
            return "Thay đổi trạngh thái thành công ";
        } else {
            return "Thay đổi trạng thái thất bại";
        }
    }
    
    @Override
    public String getTenVGA(String idVGA) {
        return lkRe.getTenVGA(idVGA);
    }
    
    @Override
    public String getTenCPU(String idCPU) {
        return lkRe.getTenCPU(idCPU);
    }
    
    @Override
    public String getTenRamRom(String idRAMROM) {
        return lkRe.getTenRamRom(idRAMROM);
    }
    
    @Override
    public String getTenMH(String idMH) {
        return lkRe.getTenMH(idMH);
    }
    
    @Override
    public String getIDVGA(String tenVGA) {
        return lkRe.getIDVGA(tenVGA);
    }
    
    @Override
    public String getIDCPU(String tenCPU) {
        return lkRe.getIDCPU(tenCPU);
    }
    
    @Override
    public String getIDNRAMROM(String tenRR) {
        return lkRe.getIDNRAMROM(tenRR);
    }
    
    @Override
    public String getIDMH(String tenMH) {
        return lkRe.getIDMH(tenMH);
    }
    
}
