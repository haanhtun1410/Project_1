package responsitory;

import domainmodels.CPUNhan;
import domainmodels.DisplayNhan;
import domainmodels.RamRomNhan;
import domainmodels.VGANhan;
import java.util.List;

/**
 *
 * @author nhanp
 */
public interface LinhKienRe {

    List<CPUNhan> getAllCPU();

    List<DisplayNhan> getAllDisplay();

    List<RamRomNhan> getAllRR();

    List<VGANhan> getAllVGA();
    
    List<CPUNhan> getAllCPUTT();

    List<DisplayNhan> getAllDisplayTT();

    List<RamRomNhan> getAllRRTT();

    List<VGANhan> getAllVGATT();

    boolean insertCPU(CPUNhan cpu);

    boolean insertDisplay(DisplayNhan ds);

    boolean insertRR(RamRomNhan rr);

    boolean insertVGA(VGANhan vga);

    boolean updateCPU(CPUNhan cpu, String idCPU);

    boolean updateDisplay(DisplayNhan ds, String idDisplay);

    boolean updateRR(RamRomNhan rr, String idRR);

    boolean updateVGA(VGANhan vgva, String idVGA);

    boolean deleteCPU(String idCPU);

    boolean deleteDisplay(String idDisplay);

    boolean deleteRR(String idRR);

    boolean deleteVGA(String iddVGA);
    
    String  getTenVGA(String idVGA);
    
    String  getTenCPU(String idCPU);
    
    String  getTenRamRom(String idRAMROM);
    
    String  getTenMH(String idMH);
    
    String getIDVGA(String tenVGA);
    
    String getIDCPU(String tenCPU);
    
    String getIDNRAMROM(String tenRR);
    
    String getIDMH(String tenMH);
}
