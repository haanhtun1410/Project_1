/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory.impl;

import domainmodels.CPUNhan;
import domainmodels.DisplayNhan;
import domainmodels.RamRomNhan;
import domainmodels.TKSP;
import domainmodels.ThongKeNSX;
import domainmodels.VGANhan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import responsitory.ThongKeRe;
import utilsNhan.Connect;

/**
 *
 * @author nhanp
 */
public class ThongKeReImpl implements ThongKeRe {
    
    @Override
    public List<TKSP> getAll() {
        String query = "select ChiTietSP.tenSP, sum(soluong), ChiTietSP.Anh\n"
                + "                from ChiTietSP\n"
                + "                left join CTHD on ChiTietSP.Id = cthd.IdCTSP\n"
                + "                group by ChiTietSP.tenSP,  ChiTietSP.Anh\n"
                + "		   order by sum(soluong) desc";
        List<TKSP> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TKSP(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    
    @Override
    public List<RamRomNhan> getAllRR() {
        String query = "select RamAndRom.Ten, sum(soluong)\n"
                + "                from ChiTietSP\n"
                + "                left join CTHD on ChiTietSP.Id = cthd.IdCTSP\n"
                + "                join RamAndRom on RamAndRom.Id = ChiTietSP.IdRamRom\n"
                + "                group by RamAndRom.Ten\n"
                + "		   order by sum(soluong) desc";
        List<RamRomNhan> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new RamRomNhan(rs.getString(1), rs.getString(2)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    @Override
    public List<VGANhan> getAllVGA() {
        String query = "select VGA.Ten, sum(soluong)\n"
                + "                from ChiTietSP\n"
                + "                left join CTHD on ChiTietSP.Id = cthd.IdCTSP\n"
                + "                join VGA on VGA.Id = ChiTietSP.IdVGA\n"
                + "                group by VGA.Ten\n"
                + "		   order by sum(soluong) desc";
        List<VGANhan> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new VGANhan(rs.getString(1), rs.getString(2)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    @Override
    public List<DisplayNhan> getAllMH() {
        String query = "select ManHinh.Chip, sum(soluong)\n"
                + "                from ChiTietSP\n"
                + "                left join CTHD on ChiTietSP.Id = cthd.IdCTSP\n"
                + "                join ManHinh on ManHinh.Id = ChiTietSP.IdManHinh\n"
                + "                group by ManHinh.chip\n"
                + "		   order by sum(soluong) desc";
        List<DisplayNhan> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new DisplayNhan(rs.getString(1), rs.getString(2)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    @Override
    public List<CPUNhan> getAllCPU() {
        String query = "select CPU.Ten, sum(soluong)\n"
                + "                from ChiTietSP\n"
                + "                left join CTHD on ChiTietSP.Id = cthd.IdCTSP\n"
                + "                join CPU on CPU.Id = ChiTietSP.IdCPU\n"
                + "                group by CPU.Ten\n"
                + "		   order by sum(soluong) desc";
        List<CPUNhan> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new CPUNhan(rs.getString(1), rs.getString(2)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public Double tongTien() {
        String query = "select sum(TongTien) from hoadon";
        double sum = 0;
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sum = rs.getDouble(1);
            }
            return sum;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public static void main(String[] args) {
        System.out.println(new ThongKeReImpl().tongTien());
    }

    @Override
    public Integer soHD() {
        String query = "select count(id) from hoadon";
        int sum = 0;
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sum = rs.getInt(1);
            }
            return sum;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public Integer soSP() {
       String query = "select SUM(SOLUONG)  from CTHD";
        int sum = 0;
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sum = rs.getInt(1);
            }
            return sum;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public Integer soKH() {
        String query = "select count(distinct IdKH )from HoaDon";
        int sum = 0;
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sum = rs.getInt(1);
            }
            return sum;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
