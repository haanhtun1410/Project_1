
package services.impl;

import responsitory.ThongKeDoanhThuRepository;
import responsitory.impl.ThongKeDoanhThuReImpl;
import services.DoanhThuService;

public class DoanhThuSerImpl implements DoanhThuService{
    ThongKeDoanhThuRepository tkdt = new ThongKeDoanhThuReImpl();

    @Override
    public Double DoanhThuThang(int thang, int nam) {
        return tkdt.DoanhThuThang(thang ,nam);
    }

    @Override
    public Double SLLaptopBan(int thang, int nam) {
        return tkdt.soLuongSanPhamDaBan(thang, nam);
    }

    @Override
    public Double DoanhThuNgay(int day, int month, int years) {
        return tkdt.DoanhThuNgay(day, month, years);
    }
    
}
