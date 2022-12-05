package responsitory.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import responsitory.ThongKeDoanhThuRepository;
import utilsNhan.Connect;

public class ThongKeDoanhThuReImpl implements ThongKeDoanhThuRepository {

    @Override
    public Double DoanhThuThang(int thang, int nam) {
        String query = "SELECT Sum(TongTien)\n"
                + "FROM HoaDon\n"
                + "WHERE Month(NgayThanhToan) = ? and year(NgayThanhToan) = ?";
        Double doanhThu = null;
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, thang);
            ps.setObject(2, nam);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                doanhThu = rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return doanhThu;
    }

    @Override
    public Double soLuongSanPhamDaBan(int thang, int nam) {
        String query = "SELECT SUM(cthd.soluong)\n"
                + "FROM HoaDon hd , CTHD cthd\n"
                + "WHERE cthd.idhd = hd. Id and Month(NgayThanhToan) = ? and year(NgayThanhToan) = ?";
        Double slLT = null;
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, thang);
            ps.setObject(2, nam);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                slLT = rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return slLT;
    }

    @Override
    public Double DoanhThuNgay(int day, int month, int years) {
        String query = "SELECT Sum(TongTien)\n"
                + "FROM HoaDon\n"
                + "WHERE day(NgayThanhToan) = ? \n"
                + "and month(NgayThanhToan) = ? \n"
                + "and year(ngaythanhtoan) = ? ";
        Double doanhThu = null;
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ps.setObject(1, day);
            ps.setObject(2, month);
            ps.setObject(3, years);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                doanhThu = rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return doanhThu;
    }
    public static void main(String[] args) {
        Double a = new ThongKeDoanhThuReImpl().DoanhThuNgay(27, 11, 2022);
        System.out.println(a/1000000);
        
    }

}
