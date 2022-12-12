package domainmodels;
// Generated Nov 19, 2022 2:49:48 PM by Hibernate Tools 4.3.1

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "`user`", schema = "dbo",
        catalog = "ProjectOne"
)
public class User implements java.io.Serializable {

    @Column(name = "ID", unique = true, nullable = false, length = 10)
    @Id
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCV")
    private ChucVu chucVu;
    @Column(name = "Ten")
    private String ten;
    @Column(name = "GioiTinh")
    private String gioiTinh;
    @Temporal(TemporalType.DATE)
    @Column(name = "NgaySinh", length = 10)
    private Date ngaySinh;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "Sdt", length = 30)
    private String sdt;
    @Column(name = "MatKhau")
    private String matKhau;
    @Column(name = "TrangThai")
    private int trangThai;
    @Column(name = "Anh")
    private String anh;
    @Column(name = "Gmail")
    private String gmail;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<HoaDon> hoaDons = new HashSet<HoaDon>(0);

    public User() {
    }

    public User(String id) {
        this.id = id;
    }

    public User(String id, ChucVu chucVu, String ten, String gioiTinh, Date ngaySinh, String diaChi, String sdt, String matKhau, int trangThai, String anh) {
        this.id = id;
        this.chucVu = chucVu;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
        this.anh = anh;
    }

    public User(String id, ChucVu chucVu, String ten, String gioiTinh, Date ngaySinh, String diaChi, String sdt, String matKhau, int trangThai, String anh, String gmail) {
        this.id = id;
        this.chucVu = chucVu;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
        this.anh = anh;
        this.gmail = gmail;
    }
    

    public User(String id, ChucVu chucVu, String ten, String gioiTinh, Date ngaySinh, String diaChi, String sdt, String matKhau, int trangThai) {
        this.id = id;
        this.chucVu = chucVu;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
    }

    public User(String id, String ten, String diaChi, String anh) {
        this.id = id;
        this.ten = ten;
        this.diaChi = diaChi;
        this.anh = anh;
    }
    

    public String getId() {
        return this.id;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ChucVu getChucVu() {
        return this.chucVu;
    }

    public void setChucVu(ChucVu chucVu) {
        this.chucVu = chucVu;
    }

    public String getTen() {
        return this.ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return this.gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return this.ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return this.diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return this.sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMatKhau() {
        return this.matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getTrangThai() {
        return this.trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public Set<HoaDon> getHoaDons() {
        return this.hoaDons;
    }

    public void setHoaDons(Set<HoaDon> hoaDons) {
        this.hoaDons = hoaDons;
    }


    @Override
    public String toString() {
        return ten;
    }

}
