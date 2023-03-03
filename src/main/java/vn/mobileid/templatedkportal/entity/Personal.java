/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.mobileid.templatedkportal.entity;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Mobile ID 21
 */
@Getter
@Setter
public class Personal {
    private String tochuc_TenGiaoDich;
    private String tochuc_MST;
    private String tochuc_DiaChi;
    private String tochuc_HoTen;
    private String tochuc_ChucVu;
    private String tochuc_CMND;
    private String tochuc_NgayCap;
    private String tochuc_NoiCap;
    private String tochuc_SDT;
    private String tochuc_Email;
    
    private String canhan_HoTen;
    private String canhan_ChucVu;
    private String canhan_CMND;
    private String canhan_NgayCap;
    private String canhan_NoiCap;
    private String canhan_DiaChi;
    private String canhan_SDT;
    private String canhan_Email;
            
    private String canhan;
    private String tochuc;
    private String canhanTtochuc;
    private String capmoi;
    private String giahan;
    private String caplai;
    private String tamdung;
    private String khoiphuc;
    private String thuhoi;
    private String motnam;
    private String hainam;
    private String banam;
    private String bonnam;
    private String khac;
    private String khacText;

    private String usbToken;
    private String hsm;
    
    private String series_CTS;
    
    private String psThanhPho;
    private String psNgay;
    private String psThang;
    private String psNam;


    public Personal() {
        super();
    }

    public Personal(String tochuc_TenGiaoDich, String tochuc_MST, String tochuc_DiaChi, String tochuc_HoTen, String tochuc_ChucVu, String tochuc_CMND, String tochuc_NgayCap, String tochuc_NoiCap, String tochuc_SDT, String tochuc_Email, String canhan_HoTen, String canhan_ChucVu, String canhan_CMND, String canhan_NgayCap, String canhan_NoiCap, String canhan_DiaChi, String canhan_SDT, String canhan_Email, String canhan, String tochuc, String canhanTtochuc, String capmoi, String giahan, String caplai, String tamdung, String khoiphuc, String thuhoi, String motnam, String hainam, String banam, String bonnam, String khac, String khacText, String usbToken, String hsm, String series_CTS, String psThanhPho, String psNgay, String psThang, String psNam) {
        this.tochuc_TenGiaoDich = tochuc_TenGiaoDich;
        this.tochuc_MST = tochuc_MST;
        this.tochuc_DiaChi = tochuc_DiaChi;
        this.tochuc_HoTen = tochuc_HoTen;
        this.tochuc_ChucVu = tochuc_ChucVu;
        this.tochuc_CMND = tochuc_CMND;
        this.tochuc_NgayCap = tochuc_NgayCap;
        this.tochuc_NoiCap = tochuc_NoiCap;
        this.tochuc_SDT = tochuc_SDT;
        this.tochuc_Email = tochuc_Email;
        this.canhan_HoTen = canhan_HoTen;
        this.canhan_ChucVu = canhan_ChucVu;
        this.canhan_CMND = canhan_CMND;
        this.canhan_NgayCap = canhan_NgayCap;
        this.canhan_NoiCap = canhan_NoiCap;
        this.canhan_DiaChi = canhan_DiaChi;
        this.canhan_SDT = canhan_SDT;
        this.canhan_Email = canhan_Email;
        this.canhan = canhan;
        this.tochuc = tochuc;
        this.canhanTtochuc = canhanTtochuc;
        this.capmoi = capmoi;
        this.giahan = giahan;
        this.caplai = caplai;
        this.tamdung = tamdung;
        this.khoiphuc = khoiphuc;
        this.thuhoi = thuhoi;
        this.motnam = motnam;
        this.hainam = hainam;
        this.banam = banam;
        this.bonnam = bonnam;
        this.khac = khac;
        this.khacText = khacText;
        this.usbToken = usbToken;
        this.hsm = hsm;
        this.series_CTS = series_CTS;
        this.psThanhPho = psThanhPho;
        this.psNgay = psNgay;
        this.psThang = psThang;
        this.psNam = psNam;
    }

    

    

}
