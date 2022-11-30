package domainmodels;
// Generated Nov 19, 2022 2:49:48 PM by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VoucherHd generated by hbm2java
 */
@Entity
@Table(name="VoucherHD"
    ,schema="dbo"
    ,catalog="ProjectOne"
)
public class VoucherHd  implements java.io.Serializable {


     private String id;
     private String moTa;
     private BigDecimal tienGiam;
     private int phanTramGiam;
     private Date ngayApDung;
     private Date ngayKetThuc;
     private Set<HoaDon> hoaDons = new HashSet<HoaDon>(0);

    public VoucherHd() {
    }

	
    public VoucherHd(String id) {
        this.id = id;
    }

    public VoucherHd(String id, String moTa, BigDecimal tienGiam, int phanTramGiam, Date ngayApDung, Date ngayKetThuc) {
        this.id = id;
        this.moTa = moTa;
        this.tienGiam = tienGiam;
        this.phanTramGiam = phanTramGiam;
        this.ngayApDung = ngayApDung;
        this.ngayKetThuc = ngayKetThuc;
    }
    
    public VoucherHd(String id, String moTa, BigDecimal tienGiam, int phanTramGiam, Date ngayApDung, Date ngayKetThuc, Set<HoaDon> hoaDons) {
       this.id = id;
       this.moTa = moTa;
       this.tienGiam = tienGiam;
       this.phanTramGiam = phanTramGiam;
       this.ngayApDung = ngayApDung;
       this.ngayKetThuc = ngayKetThuc;
       this.hoaDons = hoaDons;
    }
   
     @Id 

    
    @Column(name="Id", unique=true, nullable=false, length=10)
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    
    @Column(name="MoTa")
    public String getMoTa() {
        return this.moTa;
    }
    
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    
    @Column(name="TienGiam", scale=4)
    public BigDecimal getTienGiam() {
        return this.tienGiam;
    }
    
    public void setTienGiam(BigDecimal tienGiam) {
        this.tienGiam = tienGiam;
    }

    
    @Column(name="phanTramGiam")
    public int getPhanTramGiam() {
        return this.phanTramGiam;
    }
    
    public void setPhanTramGiam(int phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="NgayApDung", length=10)
    public Date getNgayApDung() {
        return this.ngayApDung;
    }
    
    public void setNgayApDung(Date ngayApDung) {
        this.ngayApDung = ngayApDung;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="NgayKetThuc", length=10)
    public Date getNgayKetThuc() {
        return this.ngayKetThuc;
    }
    
    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="voucherHd")
    public Set<HoaDon> getHoaDons() {
        return this.hoaDons;
    }
    
    public void setHoaDons(Set<HoaDon> hoaDons) {
        this.hoaDons = hoaDons;
    }




}


