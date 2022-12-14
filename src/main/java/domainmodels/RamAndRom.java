package domainmodels;
// Generated Dec 8, 2022 9:31:17 AM by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * RamAndRom generated by hbm2java
 */
@Entity
@Table(name="RamAndRom"
    ,schema="dbo"
    ,catalog="ProjectOne"
)
public class RamAndRom  implements java.io.Serializable {


     private String id;
     private String ten;
     private int trangThai;
     private Set<ChiTietSp> chiTietSps = new HashSet<ChiTietSp>(0);

    public RamAndRom() {
    }

	
    public RamAndRom(String id) {
        this.id = id;
    }
    public RamAndRom(String id, String ten, int trangThai, Set<ChiTietSp> chiTietSps) {
       this.id = id;
       this.ten = ten;
       this.trangThai = trangThai;
       this.chiTietSps = chiTietSps;
    }
   
     @Id 

    
    @Column(name="Id", unique=true, nullable=false, length=10)
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    
    @Column(name="Ten")
    public String getTen() {
        return this.ten;
    }
    
    public void setTen(String ten) {
        this.ten = ten;
    }

    
    @Column(name="TrangThai")
    public int getTrangThai() {
        return this.trangThai;
    }
    
    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="ramAndRom")
    public Set<ChiTietSp> getChiTietSps() {
        return this.chiTietSps;
    }
    
    public void setChiTietSps(Set<ChiTietSp> chiTietSps) {
        this.chiTietSps = chiTietSps;
    }




}


