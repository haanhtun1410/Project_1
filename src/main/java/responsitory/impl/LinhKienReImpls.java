/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory.impl;

import domainmodels.CPUNhan;
import domainmodels.DisplayNhan;
import domainmodels.Laptop;
import domainmodels.RamRomNhan;
import domainmodels.VGANhan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import responsitory.LinhKienRe;
import utilsNhan.Connect;

/**
 *
 * @author nhanp
 */
public class LinhKienReImpls implements LinhKienRe {

    @Override
    public List<CPUNhan> getAllCPU() {
        String query = "SELECT [Id]\n"
                + "      ,[Ten]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[CPU]"
                + "where trangthai = 1";
        List<CPUNhan> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new CPUNhan(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<DisplayNhan> getAllDisplay() {
        String query = "SELECT [Id]\n"
                + "      ,[Chip]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[ManHinh]"
                + "where trangthai = 1";
        List<DisplayNhan> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new DisplayNhan(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<RamRomNhan> getAllRR() {
        String query = "SELECT [Id]\n"
                + "      ,[Ten]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[RamAndRom]"
                + "where trangthai = 1";
        List<RamRomNhan> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new RamRomNhan(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<VGANhan> getAllVGA() {
        String query = "SELECT [Id]\n"
                + "      ,[Ten]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[vga]"
                + "where trangthai = 1";
        List<VGANhan> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new VGANhan(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<CPUNhan> getAllCPUTT() {
        String query = "SELECT [Id]\n"
                + "      ,[Ten]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[CPU]"
                + "where trangthai = 0";
        List<CPUNhan> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new CPUNhan(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<DisplayNhan> getAllDisplayTT() {
        String query = "SELECT [Id]\n"
                + "      ,[Chip]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[ManHinh]"
                + "where trangthai = 0";
        List<DisplayNhan> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new DisplayNhan(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<RamRomNhan> getAllRRTT() {
        String query = "SELECT [Id]\n"
                + "      ,[Ten]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[RamAndRom]"
                + "where trangthai = 0";
        List<RamRomNhan> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new RamRomNhan(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<VGANhan> getAllVGATT() {
        String query = "SELECT [Id]\n"
                + "      ,[Ten]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[VGA]"
                + "where trangthai = 0";
        List<VGANhan> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new VGANhan(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean insertCPU(CPUNhan cpu) {
        String query = "INSERT INTO [dbo].[CPU]\n"
                + "           ([Id]\n"
                + "           ,[Ten]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES (?, ?, ?)";
        int check = 0;
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, cpu.getIdCPU());
            ps.setObject(2, cpu.getTenCPU());
            ps.setObject(3, cpu.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean insertDisplay(DisplayNhan ds) {
        String query = "INSERT INTO [dbo].[ManHinh]\n"
                + "           ([Id]\n"
                + "           ,[Chip]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES (?, ?, ?)";
        int check = 0;
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, ds.getId());
            ps.setObject(2, ds.getTenDisplay());
            ps.setObject(3, ds.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean insertRR(RamRomNhan rr) {
        String query = "INSERT INTO [dbo].[RamAndRom]\n"
                + "           ([Id]\n"
                + "           ,[Ten]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES (?, ?, ?)";
        int check = 0;
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, rr.getIdRR());
            ps.setObject(2, rr.getTenRR());
            ps.setObject(3, rr.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean insertVGA(VGANhan vga) {
        String query = "INSERT INTO [dbo].[VGA]\n"
                + "           ([Id]\n"
                + "           ,[Ten]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES (?, ?, ?)";
        int check = 0;
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, vga.getIdVGA());
            ps.setObject(2, vga.getTenVGA());
            ps.setObject(3, vga.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean updateCPU(CPUNhan cpu, String idCPU) {
        String query = "UPDATE [dbo].[CPU]\n"
                + "   SET [Ten] = ?\n"
                + "      ,[TrangThai] =?\n"
                + " WHERE id = ?";
        int check = 0;
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, cpu.getTenCPU());
            ps.setObject(2, cpu.getTrangThai());
            ps.setObject(3, idCPU);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean updateDisplay(DisplayNhan ds, String idDisplay) {
        String query = "UPDATE [dbo].[ManHinh]\n"
                + "   SET [Chip] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + " WHERE id = ?";
        int check = 0;
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, ds.getTenDisplay());
            ps.setObject(2, ds.getTrangThai());
            ps.setObject(3, idDisplay);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean updateRR(RamRomNhan rr, String idRR) {
        String query = "UPDATE [dbo].[RamAndRom]\n"
                + "   SET [Ten] = ?\n"
                + "      ,[TrangThai] = ?"
                + " WHERE id = ?";
        int check = 0;
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, rr.getTenRR());
            ps.setObject(2, rr.getTrangThai());
            ps.setObject(3, idRR);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean updateVGA(VGANhan vgva, String idVGA) {
        String query = "UPDATE [dbo].[VGA]\n"
                + "   SET [Ten] = ?\n"
                + "      ,[TrangThai] = ?"
                + " WHERE id = ?";
        int check = 0;
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, vgva.getTenVGA());
            ps.setObject(2, vgva.getTrangThai());
            ps.setObject(3, idVGA);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean deleteCPU(String idCPU) {
        String query = "UPDATE [dbo].[CPU]\n"
                + "   SET [TrangThai] =0 \n"
                + " WHERE id = ? ";
        int check = 0;
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, idCPU);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean deleteDisplay(String idDisplay) {
        String query = "UPDATE [dbo].[ManHinh]\n"
                + "   SET [TrangThai] = 0 \n"
                + " WHERE id = ?";
        int check = 0;
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, idDisplay);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean deleteRR(String idRR) {
        String query = "UPDATE [dbo].[RamAnhRom]\n"
                + "   SET [TrangThai] = 0 \n"
                + " WHERE id = ?";
        int check = 0;
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, idRR);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean deleteVGA(String idVGA) {
        String query = "UPDATE [dbo].[VGA]\n"
                + "   SET [TrangThai] = 0 \n"
                + " WHERE id = ?";
        int check = 0;
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, idVGA);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public String getTenVGA(String idVGA) {
        String query = "SELECT [Ten]\n"
                + "  FROM [dbo].[VGA]"
                + "where Id = ?";
        String tenVGA = "";
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, idVGA);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenVGA = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return tenVGA;
    }

    @Override
    public String getTenCPU(String idCPU) {
        String query = "SELECT [Ten]\n"
                + "  FROM [dbo].[CPU]"
                + "where Id = ?";
        String tenCPU = "";
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, idCPU);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenCPU = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return tenCPU;
    }

    @Override
    public String getTenRamRom(String idRR) {
        String query = "SELECT [Ten]\n"
                + "  FROM [dbo].[RamandRom]"
                + "where Id = ?";
        String tenRR = "";
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, idRR);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenRR = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return tenRR;
    }

    @Override
    public String getTenMH(String idMH) {
        String query = "SELECT [Chip]\n"
                + "  FROM [dbo].[ManHinh]"
                + "where Id = ?";
        String tenMH = "";
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, idMH);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenMH = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return tenMH;
    }

    @Override
    public String getIDVGA(String tenVGA) {
        String query = "SELECT [Id]\n"
                + "  FROM [dbo].[VGA]"
                + "where ten = ?";
        String idVGA = "";
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, tenVGA);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idVGA = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return idVGA;
    }

    @Override
    public String getIDCPU(String tenCPU) {
        String query = "SELECT [Id]\n"
                + "  FROM [dbo].[CPU]"
                + "where ten = ?";
        String idCPU = "";
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, tenCPU);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idCPU = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return idCPU;
    }

    @Override
    public String getIDNRAMROM(String tenRR) {
        String query = "SELECT [Id]\n"
                + "  FROM [dbo].[RAMANDROM]"
                + "where ten = ?";
        String idRR = "";
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, tenRR);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idRR = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return idRR;
    }

    @Override
    public String getIDMH(String tenMH) {
       String query = "SELECT [Id]\n"
                + "  FROM [dbo].[ManHinh]"
                + "where chip = ?";
        String idMH = "";
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, tenMH);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idMH = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return idMH;
    }

}
