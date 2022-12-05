/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory;

import java.util.List;

/**
 *
 * @author nhanp
 */
public interface ThongKeDoanhThuRepository {
    Double DoanhThuThang(int thang,int nam);
    
    Double soLuongSanPhamDaBan(int thang, int nam);
    
    Double DoanhThuNgay( int day, int month, int years);
}
