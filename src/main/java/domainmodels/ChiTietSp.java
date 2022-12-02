package domainmodels;
// Generated Nov 19, 2022 2:49:48 PM by Hibernate Tools 4.3.1

import java.io.Serializable;
import java.math.BigDecimal;
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

/**
 * ChiTietSp generated by hbm2java
 */
@Entity
@Table(name = "ChiTietSP",
        schema = "dbo",
        catalog = "ProjectOne"
)
public class ChiTietSp implements java.io.Serializable {

    @Column(name = "Id", unique = true, nullable = false, length = 10)
    @Id
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdDongSP")
    private DongSp dongSp;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNsx")
    private Nsx nsx;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdVoucherSP")
    private VoucherLaptop voucherLaptop;
    @Column(name = "tenSP")
    private String tenSp;
    @Column(name = "NamSX")
    private int namSx;
    @Column(name = "NamBH")
    private int namBh;
    @Column(name = "MoTa")
    private String moTa;
    @Column(name = "SoLuongTon")
    private int soLuongTon;
    @Column(name = "GiaBan", scale = 4)
    private BigDecimal giaBan;
    @Column(name = "Anh")
    private String anh;
    private int trangThai;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "chiTietSp")
    private Set<Serial> serials = new HashSet<Serial>(0);
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "chiTietSp")
    private Set<Cthd> cthds = new HashSet<Cthd>(0);
  

    public ChiTietSp() {
    }

    public ChiTietSp(String id) {
        this.id = id;
    }

    public ChiTietSp(String id, DongSp dongSp, Nsx nsx, String tenSp, int namSx, int namBh, String moTa, int soLuongTon, BigDecimal giaBan) {
        this.id = id;
        this.dongSp = dongSp;
        this.nsx = nsx;
        this.tenSp = tenSp;
        this.namSx = namSx;
        this.namBh = namBh;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaBan = giaBan;
    }

    public ChiTietSp(String id, DongSp dongSp, Nsx nsx, VoucherLaptop voucherLaptop, String tenSp, int namSx, int namBh, String moTa, int soLuongTon, BigDecimal giaBan) {
        this.id = id;
        this.dongSp = dongSp;
        this.nsx = nsx;
        this.voucherLaptop = voucherLaptop;
        this.tenSp = tenSp;
        this.namSx = namSx;
        this.namBh = namBh;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaBan = giaBan;
    }
    
     public ChiTietSp(String id, String tenSp, int namSx, int namBh, String moTa, int soLuongTon, BigDecimal giaBan) {
        this.id = id;
        this.tenSp = tenSp;
        this.namSx = namSx;
        this.namBh = namBh;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaBan = giaBan;
    }


    public ChiTietSp(String id, DongSp dongSp, Nsx nsx, VoucherLaptop voucherLaptop, String tenSp, int namSx, int namBh, String moTa, int soLuongTon, BigDecimal giaBan, String anh) {
        this.id = id;
        this.dongSp = dongSp;
        this.nsx = nsx;
        this.voucherLaptop = voucherLaptop;
        this.tenSp = tenSp;
        this.namSx = namSx;
        this.namBh = namBh;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaBan = giaBan;
        this.anh = anh;
    }

    
    
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DongSp getDongSp() {
        return this.dongSp;
    }

    public void setDongSp(DongSp dongSp) {
        this.dongSp = dongSp;
    }

    public Nsx getNsx() {
        return this.nsx;
    }

    public void setNsx(Nsx nsx) {
        this.nsx = nsx;
    }

    public VoucherLaptop getVoucherLaptop() {
        return this.voucherLaptop;
    }

    public void setVoucherLaptop(VoucherLaptop voucherLaptop) {
        this.voucherLaptop = voucherLaptop;
    }

    public String getTenSp() {
        return this.tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public int getNamSx() {
        return this.namSx;
    }

    public void setNamSx(int namSx) {
        this.namSx = namSx;
    }

    public int getNamBh() {
        return this.namBh;
    }

    public void setNamBh(int namBh) {
        this.namBh = namBh;
    }

    public String getMoTa() {
        return this.moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLuongTon() {
        return this.soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public BigDecimal getGiaBan() {
        return this.giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    public Set<Serial> getSerials() {
        return this.serials;
    }

    public void setSerials(Set<Serial> serials) {
        this.serials = serials;
    }

    public Set<Cthd> getCthds() {
        return this.cthds;
    }

    public void setCthds(Set<Cthd> cthds) {
        this.cthds = cthds;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

   

}
