/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory.impl;
 
import domainmodels.ThongKeNSX;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import responsitory.NhaSanXuatRe;
import utilsNhan.Connect;

/**
 *
 * @author nhanp
 */
public class NhaSanXuatReImpls implements NhaSanXuatRe{

    @Override
    public List<ThongKeNSX> getNSX() {
        String query = "SELECT [Id]\n"
                + "      ,[Ten]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[NSX]"
                + "where trangthai = 1";
        List<ThongKeNSX> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThongKeNSX(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public static void main(String[] args) {
        new NhaSanXuatReImpls().getNSX().forEach(s -> System.out.println(s.toString()));
    }

    @Override
    public List<ThongKeNSX> getNSXtt() {
        String query = "SELECT [Id]\n"
                + "      ,[Ten]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[NSX]"
                + "where trangthai = 0";
        List<ThongKeNSX> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThongKeNSX(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean insert(ThongKeNSX nsx) {
        String query = "INSERT INTO [dbo].[NSX]\n"
                + "           ([Id]\n"
                + "           ,[Ten]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES (?, ?, ?)";
        int check = 0;
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, nsx.getIdNSX());
            ps.setObject(2, nsx.getTenNSX());
            ps.setObject(3, nsx.getTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    

    @Override
    public boolean update(ThongKeNSX nsx, String id) {
         String query = "UPDATE [dbo].[NSX]\n"
                + "   SET [Ten] = ?\n"
                + "      ,[TrangThai] =?\n"
                + " WHERE id = ?";
        int check = 0;
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, nsx.getTenNSX());
            ps.setObject(2, nsx.getTrangThai());
            ps.setObject(3, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(String id) {
        String query = "UPDATE [dbo].[NSX]\n"
                + "   SET [TrangThai] = 0 \n"
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
    
}
