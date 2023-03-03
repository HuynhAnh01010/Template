package vn.mobileid.templatedkportal.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Certificate {

    private String hoten;
    private String mst;
    private String cmndhc;
    private String certSN;
    private String tenKHCu;
    private String tenKHMoi;
    private String cmndHCCu;
    private String cmndHCMoi;
    private String diachiCu;
    private String diachiMoi;
    private String khacCu;
    private String khacMoi;

    private String ttHoten;
    private String ttChucvu;
    private String ttSdt;
    private String ttEmail;

    private String tgianDiaDiem;

    public Certificate() {
        super();
    }

    public Certificate(String hoten, String mst, String cmndhc, String certSN, String tenKHCu, String tenKHMoi, String cmndHCCu, String cmndHCMoi, String diachiCu, String diachiMoi, String khacCu, String khacMoi, String ttHoten, String ttChucvu, String ttSdt, String ttEmail, String tgianDiaDiem) {
        this.hoten = hoten;
        this.mst = mst;
        this.cmndhc = cmndhc;
        this.certSN = certSN;
        this.tenKHCu = tenKHCu;
        this.tenKHMoi = tenKHMoi;
        this.cmndHCCu = cmndHCCu;
        this.cmndHCMoi = cmndHCMoi;
        this.diachiCu = diachiCu;
        this.diachiMoi = diachiMoi;
        this.khacCu = khacCu;
        this.khacMoi = khacMoi;
        this.ttHoten = ttHoten;
        this.ttChucvu = ttChucvu;
        this.ttSdt = ttSdt;
        this.ttEmail = ttEmail;
        this.tgianDiaDiem = tgianDiaDiem;
    }

    

}
