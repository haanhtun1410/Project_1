/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory.impl;

import domainmodels.ThongKeKH;
import domainmodels.ThongKeNSX;
import domainmodels.ThongKeNV;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import responsitory.ThongKeNVKHRe;
import utilsNhan.Connect;

/**
 *
 * @author nhanp
 */
public class ThongKeNVKHReImpl implements ThongKeNVKHRe {

    @Override
    public List<ThongKeKH> getListKH() {
        String query = "select KhachHang.id,KhachHang.Ten,KhachHang.Sdt, sum(TongTien), sum(soluong)\n"
                + "                 from HoaDon\n"
                + "                 left join KhachHang on KhachHang.Id = HoaDon.IdKH\n"
                + "                 join CTHD on CTHD.IdHD = HoaDon.Id\n"
                + "                 group by KhachHang.Ten,KhachHang.id,KhachHang.sdt";
        List<ThongKeKH> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThongKeKH(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(5), rs.getDouble(4)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<ThongKeNV> getListNV() {
        String query = "select [dbo].[User].ID, [dbo].[User].Ten ,[dbo].[User].Sdt, sum(TongTien), sum(soluong)\n"
                + "                 from HoaDon\n"
                + "                 left join [dbo].[User] on [dbo].[User].Id = HoaDon.Idnv\n"
                + "                 join CTHD on CTHD.IdHD = HoaDon.Id\n"
                + "                 group by [dbo].[User].Ten, [dbo].[User].id, [dbo].[User].sdt";
        List<ThongKeNV> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThongKeNV(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

}
