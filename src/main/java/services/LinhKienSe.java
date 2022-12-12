/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domainmodels.CPUNhan;
import domainmodels.DisplayNhan;
import domainmodels.RamRomNhan;
import domainmodels.VGANhan;
import java.util.List;

/**
 *
 * @author nhanp
 */
public interface LinhKienSe {
    List<CPUNhan> getAllCPU();

    List<DisplayNhan> getAllDisplay();

    List<RamRomNhan> getAllRR();

    List<VGANhan> getAllVGA();

    List<CPUNhan> getAllCPUTT();

    List<DisplayNhan> getAllDisplayTT();

    List<RamRomNhan> getAllRRTT();

    List<VGANhan> getAllVGATT();

    String insertCPU(CPUNhan cpu);

    String insertDisplay(DisplayNhan ds);

    String insertRR(RamRomNhan rr);

    String insertVGA(VGANhan vga);

    String  updateCPU(CPUNhan cpu, String idCPU);

    String updateDisplay(DisplayNhan ds, String idDisplay);

    String updateRR(RamRomNhan rr, String idRR);

    String updateVGA(VGANhan vgva, String idVGA);

    String deleteCPU(String idCPU);

    String deleteDisplay(String idDisplay);

    String deleteRR(String idRR);

    String deleteVGA(String idVGA);
    
    String  getTenVGA(String idVGA);
    
    String  getTenCPU(String idCPU);
    
    String  getTenRamRom(String idRAMROM);
    
    String  getTenMH(String idMH);
    
    String getIDVGA(String tenVGA);
    
    String getIDCPU(String tenCPU);
    
    String getIDNRAMROM(String tenRR);
    
    String getIDMH(String tenMH);
}
