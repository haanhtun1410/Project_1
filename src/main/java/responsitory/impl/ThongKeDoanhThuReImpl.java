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

    public static void main(String[] args) {
        Double doanhThu = new ThongKeDoanhThuReImpl().DoanhThuThang(11, 2022);
        System.out.println(doanhThu / 1000000);

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

}
