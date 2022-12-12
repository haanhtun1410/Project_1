/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory.impl;

import domainmodels.Laptop;
import domainmodels.ThongKeNSX;
import domainmodels.VCLTandDong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import responsitory.LaptopRe;
import utilsNhan.Connect;

/**
 *
 * @author nhanp
 */
public class LaptopReImpl implements LaptopRe {

    @Override
    public List<Laptop> getAll() {
        String query = "SELECT [Id]\n"
                + "      ,[tenSP]\n"
                + "      ,[IdNsx]\n"
                + "      ,[IdDongSP]\n"
                + "      ,[IdVoucherSP]\n"
                + "      ,[NamSX]\n"
                + "      ,[NamBH]\n"
                + "      ,[MoTa]\n"
                + "      ,[SoLuongTon]\n"
                + "      ,[GiaBan]\n"
                + "      ,[Anh]\n"
                + "      ,[TrangThai]\n"
                + "      ,[IdVga]\n"
                + "      ,[IdCpu]\n"
                + "      ,[IdManHinh]\n"
                + "      ,[IdRamRom]\n"
                + "  FROM [dbo].[ChiTietSP]"
                + "where trangthai = 1";
        List<Laptop> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Laptop(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(13),
                        rs.getString(14), rs.getString(15), rs.getString(16), rs.getInt(6), rs.getInt(7), rs.getString(8),
                        rs.getInt(9), rs.getInt(10), rs.getString(11), rs.getInt(12)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean insert(Laptop lt) {
        String query = "INSERT INTO [dbo].[ChiTietSP]\n"
                + "           ([Id]\n"
                + "           ,[tenSP]\n"
                + "           ,[IdNsx]\n"
                + "           ,[IdDongSP]\n"
                + "           ,[IdVoucherSP]\n"
                + "           ,[NamSX]\n"
                + "           ,[NamBH]\n"
                + "           ,[MoTa]\n"
                + "           ,[SoLuongTon]\n"
                + "           ,[GiaBan]\n"
                + "           ,[Anh]\n"
                + "           ,[TrangThai]\n"
                + "           ,[IdVga]\n"
                + "           ,[IdCpu]\n"
                + "           ,[IdManHinh]\n"
                + "           ,[IdRamRom])\n"
                + "     VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int check = 0;
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, lt.getIdLaptop());
            ps.setObject(2, lt.getTenLaptop());
            ps.setObject(3, lt.getIdNSX());
            ps.setObject(4, lt.getIdDongSP());
            ps.setObject(5, lt.getIdVoucher());
            ps.setObject(6, lt.getNamSX());
            ps.setObject(7, lt.getNamBH());
            ps.setObject(8, lt.getMoTa());
            ps.setObject(9, lt.getSoLuongTon());
            ps.setObject(10, lt.getGiaBan());
            ps.setObject(11, lt.getAnh());
            ps.setObject(12, lt.getTrangThai());
            ps.setObject(13, lt.getIdVGA());
            ps.setObject(14, lt.getIdCPU());
            ps.setObject(15, lt.getIdMH());
            ps.setObject(16, lt.getIdRR());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(String idLapTop, Laptop lt) {
        String query = "UPDATE [dbo].[ChiTietSP]\n"
                + "       SET [tenSP] = ?\n"
                + "           ,[IdNsx] = ?\n"
                + "           ,[IdVoucherSP] = ?\n"
                + "           ,[NamSX] = ?\n"
                + "           ,[NamBH] = ?\n"
                + "           ,[MoTa] = ?\n"
                + "           ,[SoLuongTon] = ?\n"
                + "           ,[GiaBan]= ?\n"
                + "           ,[Anh] = ?\n"
                + "           ,[TrangThai] = ?\n"
                + "           ,[IdVga] = ?\n"
                + "           ,[IdCpu] = ?\n"
                + "           ,[IdManHinh] = ?\n"
                + "           ,[IdRamRom] = ?\n"
                + "                  WHERE ID =?";
        int check = 0;
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, lt.getTenLaptop());
            ps.setObject(2, lt.getIdNSX());
            ps.setObject(3, lt.getIdVoucher());
            ps.setObject(4, lt.getNamSX());
            ps.setObject(5, lt.getNamBH());
            ps.setObject(6, lt.getMoTa());
            ps.setObject(7, lt.getSoLuongTon());
            ps.setObject(8, lt.getGiaBan());
            ps.setObject(9, lt.getAnh());
            ps.setObject(10, lt.getTrangThai());
            ps.setObject(11, lt.getIdVGA());
            ps.setObject(12, lt.getIdCPU());
            ps.setObject(13, lt.getIdMH());
            ps.setObject(14, lt.getIdRR());
            ps.setObject(15, idLapTop);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        Laptop lt = new Laptop("bb", "NSX03", "Voucher01", "VGA01", "CPU01", "MH1", "RamRom1", 2022, 2023, "asjhdg", 123, 1241234.0, "@4124", 0);
        String id = "Laptop03";
        new LaptopReImpl().update(id, lt);

    }

    @Override
    public List<Laptop> getNamSX(int namSX) {
        String query = "SELECT [Id]\n"
                + "      ,[tenSP]\n"
                + "      ,[IdNsx]\n"
                + "      ,[IdDongSP]\n"
                + "      ,[IdVoucherSP]\n"
                + "      ,[NamSX]\n"
                + "      ,[NamBH]\n"
                + "      ,[MoTa]\n"
                + "      ,[SoLuongTon]\n"
                + "      ,[GiaBan]\n"
                + "      ,[Anh]\n"
                + "      ,[TrangThai]\n"
                + "      ,[IdVga]\n"
                + "      ,[IdCpu]\n"
                + "      ,[IdManHinh]\n"
                + "      ,[IdRamRom]\n"
                + "  FROM [dbo].[ChiTietSP]"
                + " Where namSX = ?";
        List<Laptop> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, namSX);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Laptop(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(13),
                        rs.getString(14), rs.getString(15), rs.getString(16), rs.getInt(6), rs.getInt(7), rs.getString(8),
                        rs.getInt(9), rs.getInt(10), rs.getString(11), rs.getInt(12)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<Laptop> getDongLT(String IDdongLT) {
        String query = "SELECT [Id]\n"
                + "      ,[tenSP]\n"
                + "      ,[IdNsx]\n"
                + "      ,[IdDongSP]\n"
                + "      ,[IdVoucherSP]\n"
                + "      ,[NamSX]\n"
                + "      ,[NamBH]\n"
                + "      ,[MoTa]\n"
                + "      ,[SoLuongTon]\n"
                + "      ,[GiaBan]\n"
                + "      ,[Anh]\n"
                + "      ,[TrangThai]\n"
                + "      ,[IdVga]\n"
                + "      ,[IdCpu]\n"
                + "      ,[IdManHinh]\n"
                + "      ,[IdRamRom]\n"
                + "  FROM [dbo].[ChiTietSP]"
                + " Where idDongSP = ?";
        List<Laptop> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, IDdongLT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Laptop(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(13),
                        rs.getString(14), rs.getString(15), rs.getString(16), rs.getInt(6), rs.getInt(7), rs.getString(8),
                        rs.getInt(9), rs.getInt(10), rs.getString(11), rs.getInt(12)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<Laptop> getNSX(String idNSX) {
        String query = "SELECT [Id]\n"
                + "      ,[tenSP]\n"
                + "      ,[IdNsx]\n"
                + "      ,[IdDongSP]\n"
                + "      ,[IdVoucherSP]\n"
                + "      ,[NamSX]\n"
                + "      ,[NamBH]\n"
                + "      ,[MoTa]\n"
                + "      ,[SoLuongTon]\n"
                + "      ,[GiaBan]\n"
                + "      ,[Anh]\n"
                + "      ,[TrangThai]\n"
                + "      ,[IdVga]\n"
                + "      ,[IdCpu]\n"
                + "      ,[IdManHinh]\n"
                + "      ,[IdRamRom]\n"
                + "  FROM [dbo].[ChiTietSP]"
                + " Where idNSX = ?";
        List<Laptop> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, idNSX);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Laptop(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(13),
                        rs.getString(14), rs.getString(15), rs.getString(16), rs.getInt(6), rs.getInt(7), rs.getString(8),
                        rs.getInt(9), rs.getInt(10), rs.getString(11), rs.getInt(12)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<Laptop> getTrangThai(int trangThai) {
        String query = "SELECT [Id]\n"
                + "      ,[tenSP]\n"
                + "      ,[IdNsx]\n"
                + "      ,[IdDongSP]\n"
                + "      ,[IdVoucherSP]\n"
                + "      ,[NamSX]\n"
                + "      ,[NamBH]\n"
                + "      ,[MoTa]\n"
                + "      ,[SoLuongTon]\n"
                + "      ,[GiaBan]\n"
                + "      ,[Anh]\n"
                + "      ,[TrangThai]\n"
                + "      ,[IdVga]\n"
                + "      ,[IdCpu]\n"
                + "      ,[IdManHinh]\n"
                + "      ,[IdRamRom]\n"
                + "  FROM [dbo].[ChiTietSP]"
                + " Where TrangThai = ?";
        List<Laptop> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, trangThai);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Laptop(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(13),
                        rs.getString(14), rs.getString(15), rs.getString(16), rs.getInt(6), rs.getInt(7), rs.getString(8),
                        rs.getInt(9), rs.getInt(10), rs.getString(11), rs.getInt(12)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<Laptop> searchByName(String tenLaptop) {
        String query = "SELECT [Id]\n"
                + "      ,[tenSP]\n"
                + "      ,[IdNsx]\n"
                + "      ,[IdDongSP]\n"
                + "      ,[IdVoucherSP]\n"
                + "      ,[NamSX]\n"
                + "      ,[NamBH]\n"
                + "      ,[MoTa]\n"
                + "      ,[SoLuongTon]\n"
                + "      ,[GiaBan]\n"
                + "      ,[Anh]\n"
                + "      ,[TrangThai]\n"
                + "      ,[IdVga]\n"
                + "      ,[IdCpu]\n"
                + "      ,[IdManHinh]\n"
                + "      ,[IdRamRom]\n"
                + "  FROM [dbo].[ChiTietSP]"
                + " Where tenSP = ?";
        List<Laptop> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, tenLaptop);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Laptop(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(13),
                        rs.getString(14), rs.getString(15), rs.getString(16), rs.getInt(6), rs.getInt(7), rs.getString(8),
                        rs.getInt(9), rs.getInt(10), rs.getString(11), rs.getInt(12)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<Laptop> getGiaCaoThap() {
        String query = "SELECT [Id]\n"
                + "      ,[tenSP]\n"
                + "      ,[IdNsx]\n"
                + "      ,[IdDongSP]\n"
                + "      ,[IdVoucherSP]\n"
                + "      ,[NamSX]\n"
                + "      ,[NamBH]\n"
                + "      ,[MoTa]\n"
                + "      ,[SoLuongTon]\n"
                + "      ,[GiaBan]\n"
                + "      ,[Anh]\n"
                + "      ,[TrangThai]\n"
                + "      ,[IdVga]\n"
                + "      ,[IdCpu]\n"
                + "      ,[IdManHinh]\n"
                + "      ,[IdRamRom]\n"
                + "  FROM [dbo].[ChiTietSP]"
                + " order by GiaBan desc ";
        List<Laptop> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Laptop(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(13),
                        rs.getString(14), rs.getString(15), rs.getString(16), rs.getInt(6), rs.getInt(7), rs.getString(8),
                        rs.getInt(9), rs.getInt(10), rs.getString(11), rs.getInt(12)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<Laptop> getKhoangGia(double giaMin, double giaMax) {
        String query = "SELECT [Id]\n"
                + "      ,[tenSP]\n"
                + "      ,[IdNsx]\n"
                + "      ,[IdDongSP]\n"
                + "      ,[IdVoucherSP]\n"
                + "      ,[NamSX]\n"
                + "      ,[NamBH]\n"
                + "      ,[MoTa]\n"
                + "      ,[SoLuongTon]\n"
                + "      ,[GiaBan]\n"
                + "      ,[Anh]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[ChiTietSP]"
                + "  where GiaBan between ? and ?";
        List<Laptop> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, giaMin);
            ps.setObject(2, giaMax);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Laptop(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(13),
                        rs.getString(14), rs.getString(15), rs.getString(16), rs.getInt(6), rs.getInt(7), rs.getString(8),
                        rs.getInt(9), rs.getInt(10), rs.getString(11), rs.getInt(12)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<Laptop> getGiathapCao() {
        String query = "SELECT [Id]\n"
                + "      ,[tenSP]\n"
                + "      ,[IdNsx]\n"
                + "      ,[IdDongSP]\n"
                + "      ,[IdVoucherSP]\n"
                + "      ,[NamSX]\n"
                + "      ,[NamBH]\n"
                + "      ,[MoTa]\n"
                + "      ,[SoLuongTon]\n"
                + "      ,[GiaBan]\n"
                + "      ,[Anh]\n"
                + "      ,[TrangThai]\n"
                + "      ,[IdVga]\n"
                + "      ,[IdCpu]\n"
                + "      ,[IdManHinh]\n"
                + "      ,[IdRamRom]\n"
                + "  FROM [dbo].[ChiTietSP]"
                + " order by GiaBan  ";
        List<Laptop> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Laptop(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(13),
                        rs.getString(14), rs.getString(15), rs.getString(16), rs.getInt(6), rs.getInt(7), rs.getString(8),
                        rs.getInt(9), rs.getInt(10), rs.getString(11), rs.getInt(12)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<VCLTandDong> getVCLT() {
        String query = "SELECT [Id]\n"
                + "      ,[MoTa]\n"
                + "      ,[phanTramGiam]\n"
                + "  FROM [dbo].[VoucherLaptop]";
        List<VCLTandDong> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new VCLTandDong(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<VCLTandDong> getDongLT() {
        String query = "SELECT [Id]\n"
                + "      ,[Ten]\n"
                + "  FROM [dbo].[DongSP]";
        List<VCLTandDong> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new VCLTandDong(rs.getString(1), rs.getString(2)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<ThongKeNSX> getNSX() {
        String query = "SELECT [Id]\n"
                + "      ,[Ten]\n"
                + "  FROM [dbo].[NSX]";
        List<ThongKeNSX> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThongKeNSX(rs.getString(1), rs.getString(2)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public String getIDNSXbyName(String tenNSX) {
        String query = "SELECT [Id]\n"
                + "  FROM [dbo].[NSX]"
                + "where ten = ?";
        String idNSX = "";
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, tenNSX);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idNSX = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return idNSX;
    }

    @Override
    public String getIDVCLTbyName(String tenVC) {
        String query = "SELECT [Id]\n"
                + "  FROM [dbo].[VoucherLaptop]"
                + "where moTa = ?";
        String idVC = "";
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, tenVC);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idVC = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return idVC;
    }

    @Override
    public String getIDDongLTbyName(String tenDong) {
        String query = "SELECT [Id]\n"
                + "  FROM [dbo].[DongSP]"
                + "where ten = ?";
        String idDongLT = "";
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, tenDong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idDongLT = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return idDongLT;
    }

    @Override
    public String getNameDongLTByID(String IDDongLT) {
        String query = "SELECT [Ten]\n"
                + "  FROM [dbo].[DongSP]"
                + "where id = ?";
        String tenDongLT = "";
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, IDDongLT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenDongLT = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return tenDongLT;
    }

    @Override
    public String getNameVoucherByID(String idVoucher) {
        String query = "SELECT [mota]\n"
                + "  FROM [dbo].[VoucherLaptop]"
                + "where id = ?";
        String tenVoucher = "";
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, idVoucher);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenVoucher = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return tenVoucher;
    }

    @Override
    public String getNameNSXByID(String idNSX) {
        String query = "SELECT [Ten]\n"
                + "  FROM [dbo].[NSX]"
                + "where Id = ?";
        String tenNSX = "";
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, idNSX);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenNSX = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return tenNSX;
    }

    @Override
    public boolean delete(String idLapTop) {
        String query = "UPDATE [dbo].[ChiTietSP]\n"
                + "   SET [TrangThai] = 0\n"
                + " WHERE id =?";
        int check = 0;
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, idLapTop);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public List<Laptop> getOnt() {
        String query = "SELECT [Id]\n"
                + "      ,[tenSP]\n"
                + "      ,[IdNsx]\n"
                + "      ,[IdDongSP]\n"
                + "      ,[IdVoucherSP]\n"
                + "      ,[NamSX]\n"
                + "      ,[NamBH]\n"
                + "      ,[MoTa]\n"
                + "      ,[SoLuongTon]\n"
                + "      ,[GiaBan]\n"
                + "      ,[Anh]\n"
                + "      ,[TrangThai]\n"
                + "      ,[IdVga]\n"
                + "      ,[IdCpu]\n"
                + "      ,[IdManHinh]\n"
                + "      ,[IdRamRom]\n"
                + "  FROM [dbo].[ChiTietSP]"
                + "where trangthai = 0";
        List<Laptop> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Laptop(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(13),
                        rs.getString(14), rs.getString(15), rs.getString(16), rs.getInt(6), rs.getInt(7), rs.getString(8),
                        rs.getInt(9), rs.getInt(10), rs.getString(11), rs.getInt(12)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<Laptop> getCPU(String IDcpu) {
        String query = "SELECT [Id]\n"
                + "      ,[tenSP]\n"
                + "      ,[IdNsx]\n"
                + "      ,[IdDongSP]\n"
                + "      ,[IdVoucherSP]\n"
                + "      ,[NamSX]\n"
                + "      ,[NamBH]\n"
                + "      ,[MoTa]\n"
                + "      ,[SoLuongTon]\n"
                + "      ,[GiaBan]\n"
                + "      ,[Anh]\n"
                + "      ,[TrangThai]\n"
                + "      ,[IdVga]\n"
                + "      ,[IdCpu]\n"
                + "      ,[IdManHinh]\n"
                + "      ,[IdRamRom]\n"
                + "  FROM [dbo].[ChiTietSP]"
                + " Where idCpu = ?";
        List<Laptop> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, IDcpu);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Laptop(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(13),
                        rs.getString(14), rs.getString(15), rs.getString(16), rs.getInt(6), rs.getInt(7), rs.getString(8),
                        rs.getInt(9), rs.getInt(10), rs.getString(11), rs.getInt(12)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<Laptop> getAVG(String idAVG) {
        String query = "SELECT [Id]\n"
                + "      ,[tenSP]\n"
                + "      ,[IdNsx]\n"
                + "      ,[IdDongSP]\n"
                + "      ,[IdVoucherSP]\n"
                + "      ,[NamSX]\n"
                + "      ,[NamBH]\n"
                + "      ,[MoTa]\n"
                + "      ,[SoLuongTon]\n"
                + "      ,[GiaBan]\n"
                + "      ,[Anh]\n"
                + "      ,[TrangThai]\n"
                + "      ,[IdVga]\n"
                + "      ,[IdCpu]\n"
                + "      ,[IdManHinh]\n"
                + "      ,[IdRamRom]\n"
                + "  FROM [dbo].[ChiTietSP]"
                + " Where idVga = ?";
        List<Laptop> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, idAVG);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Laptop(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(13),
                        rs.getString(14), rs.getString(15), rs.getString(16), rs.getInt(6), rs.getInt(7), rs.getString(8),
                        rs.getInt(9), rs.getInt(10), rs.getString(11), rs.getInt(12)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<Laptop> getMH(String IDmh) {
        String query = "SELECT [Id]\n"
                + "      ,[tenSP]\n"
                + "      ,[IdNsx]\n"
                + "      ,[IdDongSP]\n"
                + "      ,[IdVoucherSP]\n"
                + "      ,[NamSX]\n"
                + "      ,[NamBH]\n"
                + "      ,[MoTa]\n"
                + "      ,[SoLuongTon]\n"
                + "      ,[GiaBan]\n"
                + "      ,[Anh]\n"
                + "      ,[TrangThai]\n"
                + "      ,[IdVga]\n"
                + "      ,[IdCpu]\n"
                + "      ,[IdManHinh]\n"
                + "      ,[IdRamRom]\n"
                + "  FROM [dbo].[ChiTietSP]"
                + " Where idManHinh = ?";
        List<Laptop> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, IDmh);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Laptop(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(13),
                        rs.getString(14), rs.getString(15), rs.getString(16), rs.getInt(6), rs.getInt(7), rs.getString(8),
                        rs.getInt(9), rs.getInt(10), rs.getString(11), rs.getInt(12)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<Laptop> getRAMROM(String idRR) {
        String query = "SELECT [Id]\n"
                + "      ,[tenSP]\n"
                + "      ,[IdNsx]\n"
                + "      ,[IdDongSP]\n"
                + "      ,[IdVoucherSP]\n"
                + "      ,[NamSX]\n"
                + "      ,[NamBH]\n"
                + "      ,[MoTa]\n"
                + "      ,[SoLuongTon]\n"
                + "      ,[GiaBan]\n"
                + "      ,[Anh]\n"
                + "      ,[TrangThai]\n"
                + "      ,[IdVga]\n"
                + "      ,[IdCpu]\n"
                + "      ,[IdManHinh]\n"
                + "      ,[IdRamRom]\n"
                + "  FROM [dbo].[ChiTietSP]"
                + " Where idRamRom = ?";
        List<Laptop> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, idRR);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Laptop(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(13),
                        rs.getString(14), rs.getString(15), rs.getString(16), rs.getInt(6), rs.getInt(7), rs.getString(8),
                        rs.getInt(9), rs.getInt(10), rs.getString(11), rs.getInt(12)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean refreshTT(String id) {
        String query = "UPDATE [dbo].[ChiTietSP]\n"
                + "   SET [TrangThai] = 1\n"
                + " WHERE id = ?";
        int check = 0;
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean insertImei(String id, int sl) {
        String query = "EXEC createSerial ?, ?";
        int check = 0;
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, id);
            ps.setObject(2, sl);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

}
