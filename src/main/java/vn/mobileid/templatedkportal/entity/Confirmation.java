package vn.mobileid.templatedkportal.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Confirmation {
    
    private String cfNgay;
    private String cfThang;
    private String cfNam;
    
    private String tenKhachHang;
    private String maSoThue;
    private String diaChi;
    private String sdt;
    private String hoTen;
    private String chucVu;
    
    private String series_cts;
    private String tbpc;
    private String tgiansd;
    private String subject_DN;
    private String issuer_DN;
    
    public Confirmation() {
        super();
    }

    public Confirmation(String cfNgay, String cfThang, String cfNam, String tenKhachHang, String maSoThue, String diaChi, String sdt, String hoTen, String chucVu, String series_cts, String tbpc, String tgiansd, String subject_DN, String issuer_DN) {
        this.cfNgay = cfNgay;
        this.cfThang = cfThang;
        this.cfNam = cfNam;
        this.tenKhachHang = tenKhachHang;
        this.maSoThue = maSoThue;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.hoTen = hoTen;
        this.chucVu = chucVu;
        this.series_cts = series_cts;
        this.tbpc = tbpc;
        this.tgiansd = tgiansd;
        this.subject_DN = subject_DN;
        this.issuer_DN = issuer_DN;
    }

    

    
    
}
