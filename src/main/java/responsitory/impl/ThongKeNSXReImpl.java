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
import responsitory.ThongKeNSXRe;
import utilsNhan.Connect;

public class ThongKeNSXReImpl implements ThongKeNSXRe {

    @Override
    public List<ThongKeNSX> getAll() {
        String query = "select nsx.Ten, sum(soluong)\n"
                + "from ChiTietSP\n"
                + "left join CTHD on ChiTietSP.Id = cthd.IdCTSP\n"
                + "left join NSX on nsx.Id = ChiTietSP.IdNsx\n"
                + "group by nsx.Ten";
        List<ThongKeNSX> list = new ArrayList<>();
        try (Connection c = Connect.getConnection(); PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                list.add(new ThongKeNSX(rs.getString(1), rs.getInt(2)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
//    public static void main(String[] args) {
//        new ThongKeNSXReImpl().getAll().forEach(x ->System.out.println(x.toString()););
//    }

}
