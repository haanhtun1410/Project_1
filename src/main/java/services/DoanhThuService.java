/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author nhanp
 */
public interface DoanhThuService {

    Double DoanhThuThang(int thang, int nam);

    Double SLLaptopBan(int thang, int nam);

    Double DoanhThuNgay(int day, int month, int years);
}
