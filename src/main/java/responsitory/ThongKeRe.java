/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory;

import domainmodels.CPUNhan;
import domainmodels.DisplayNhan;
import domainmodels.RamRomNhan;
import domainmodels.TKSP;
import domainmodels.VGANhan;
import java.util.Date;
import java.util.List;

/**
 *
 * @author nhanp
 */
public interface ThongKeRe {

    List<TKSP> getAll();

    List<RamRomNhan> getAllRR();

    List<VGANhan> getAllVGA();

    List<DisplayNhan> getAllMH();

    List<CPUNhan> getAllCPU();

    Double tongTien();

    Integer soHD();

    Integer soSP();

    Integer soKH();

    Double TongTienHomNay();

    String top1SP();

    Integer TongLTHomNay();

    List<TKSP> tkspAll();

    String tenNV(String idNV);

    String tenKH(String idKH);

}
