package vn.mobileid.templatedkportal.common;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.Arrays;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Mobile ID 21
 */
@Slf4j
@Component
public class CommonClass {
    
    public static String createXMLByPersonal(
            String tcTenGiaoDich, String tcMaSoThue, String tcDiaChi, String tcHoTen, String tcChucVu, String tcCMND, String tcNgayCap, String tcNoiCap, String tcMobile, String tcEmail,
            String cnHoTen, String cnChucVu, String cnCMND, String cnNgayCap, String cnNoiCap, String cnDiaChi, String cnMobile, String cnEmail,
            String dtisCaNhan, String dtisToChuc, String dtisCaNhanThuocToChuc,
            String dvisCapMoi, String dvisGiaHan, String dvisCapLai, String dvisTamDung, String dvisKhoiPhuc, String dvisThuHoi,
            String tgis1Nam, String tgis2Nam, String tgis3Nam, String tgis4Nam, String tgisKhac, String tgKhacText,
//            String tbusbToken, String tbHSM,
            String certSN,
            String thanhPho,
            String psNgay, String psThang, String psNam
    //            String tgDiaDiem
    ) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // root elements
        Document doc = docBuilder.newDocument();
        Element elmRoot = doc.createElement("CCTSDN");
        doc.appendChild(elmRoot);

        // ThongTinToChuc
        Element thongTinToChuc = doc.createElement("ThongTinToChuc");
        elmRoot.appendChild(thongTinToChuc);

        // ThongTinToChuc
        Element tenGiaoDichElm = doc.createElement("TenGiaoDich");
        tenGiaoDichElm.appendChild(doc.createTextNode(tcTenGiaoDich));
        thongTinToChuc.appendChild(tenGiaoDichElm);
        
        //ThongTinToChuc
        Element maSoThueElm = doc.createElement("MaSoThue");
        maSoThueElm.appendChild(doc.createTextNode(tcMaSoThue));
        thongTinToChuc.appendChild(maSoThueElm);
        
        
        //ThongTinToChuc
        Element diaChiElm = doc.createElement("DiaChi");
        diaChiElm.appendChild(doc.createTextNode(tcDiaChi));
        thongTinToChuc.appendChild(diaChiElm);

        //ThongTinToChuc
        Element hoTenElm = doc.createElement("HoTen");
        hoTenElm.appendChild(doc.createTextNode(tcHoTen));
        thongTinToChuc.appendChild(hoTenElm);
        
        //ThongTinToChuc
        Element chucVuElm = doc.createElement("ChucVu");
        chucVuElm.appendChild(doc.createTextNode(tcChucVu));
        thongTinToChuc.appendChild(chucVuElm);
        
        //ThongTinToChuc
        Element cmndElm = doc.createElement("CMND");
        cmndElm.appendChild(doc.createTextNode(tcCMND));
        thongTinToChuc.appendChild(cmndElm);
        
        //ThongTinToChuc
        Element ngayCapElm = doc.createElement("NgayCap");
        ngayCapElm.appendChild(doc.createTextNode(tcNgayCap));
        thongTinToChuc.appendChild(ngayCapElm);
        
        //ThongTinToChuc
        Element noiCapElm = doc.createElement("NoiCap");
        noiCapElm.appendChild(doc.createTextNode(tcNoiCap));
        thongTinToChuc.appendChild(noiCapElm);
        
        //ThongTinToChuc
        Element mobileElm = doc.createElement("Mobile");
        mobileElm.appendChild(doc.createTextNode(tcMobile));
        thongTinToChuc.appendChild(mobileElm);
        
        //ThongTinToChuc
        Element emailElm = doc.createElement("Email");
        emailElm.appendChild(doc.createTextNode(tcEmail));
        thongTinToChuc.appendChild(emailElm);
        
        
        //
        //ThongTinCaNhan
        Element thongTinCaNhanElm = doc.createElement("ThongTinCaNhan");
        elmRoot.appendChild(thongTinCaNhanElm);

        //thongTinCaNhan
        Element cnHoTenElm = doc.createElement("HoTen");
        cnHoTenElm.appendChild(doc.createTextNode(cnHoTen));
        thongTinCaNhanElm.appendChild(cnHoTenElm);
        
        //thongTinCaNhan
        Element cnChucVuElm = doc.createElement("ChucVu");
        cnChucVuElm.appendChild(doc.createTextNode(cnChucVu));
        thongTinCaNhanElm.appendChild(cnChucVuElm);
        
        //thongTinCaNhan
        Element cnCMNDElm = doc.createElement("CMND");
        cnCMNDElm.appendChild(doc.createTextNode(cnCMND));
        thongTinCaNhanElm.appendChild(cnCMNDElm);
        
        //thongTinCaNhan
        Element cnNgayCapElm = doc.createElement("NgayCap");
        cnNgayCapElm.appendChild(doc.createTextNode(cnNgayCap));
        thongTinCaNhanElm.appendChild(cnNgayCapElm);
        
        //thongTinCaNhan
        Element cnNoiCapElm = doc.createElement("NoiCap");
        cnNoiCapElm.appendChild(doc.createTextNode(cnNoiCap));
        thongTinCaNhanElm.appendChild(cnNoiCapElm);
        
        //thongTinCaNhan
        Element cnDiaChiElm = doc.createElement("DiaChi");
        cnDiaChiElm.appendChild(doc.createTextNode(cnDiaChi));
        thongTinCaNhanElm.appendChild(cnDiaChiElm);
        
        //thongTinCaNhan
        Element cnMobileElm = doc.createElement("Mobile");
        cnMobileElm.appendChild(doc.createTextNode(cnMobile));
        thongTinCaNhanElm.appendChild(cnMobileElm);
        
        //thongTinCaNhan
        Element cnEmailElm = doc.createElement("Email");
        cnEmailElm.appendChild(doc.createTextNode(cnEmail));
        thongTinCaNhanElm.appendChild(cnEmailElm);
        

        //DoiTuongSuDung
        Element doiTuongSuDungElm = doc.createElement("DoiTuongSuDung");
        elmRoot.appendChild(doiTuongSuDungElm);

        //doituongsudung
        Element dtisCaNhanElm = doc.createElement("isCaNhan");
        dtisCaNhanElm.appendChild(doc.createTextNode(dtisCaNhan));
        doiTuongSuDungElm.appendChild(dtisCaNhanElm);

        //doituongsudung
        Element dtisToChucElm = doc.createElement("isToChuc");
        dtisToChucElm.appendChild(doc.createTextNode(dtisToChuc));
        doiTuongSuDungElm.appendChild(dtisToChucElm);

        //doituongsudung
        Element dtisCaNhanThuocToChucElm = doc.createElement("isCaNhanThuocToChuc");
        dtisCaNhanThuocToChucElm.appendChild(doc.createTextNode(dtisCaNhanThuocToChuc));
        doiTuongSuDungElm.appendChild(dtisCaNhanThuocToChucElm);

        //DichVuYeuCau
        Element dichVuYeuCauElm = doc.createElement("DichVuYeuCau");
        elmRoot.appendChild(dichVuYeuCauElm);

        //dichvuyeucau
        Element dvisCaoMoiElm = doc.createElement("isCapMoi");
        dvisCaoMoiElm.appendChild(doc.createTextNode(dvisCapMoi));
        dichVuYeuCauElm.appendChild(dvisCaoMoiElm);

        //dichvuyeucau
        Element dvisGiaHanElm = doc.createElement("isGiaHan");
        dvisGiaHanElm.appendChild(doc.createTextNode(dvisGiaHan));
        dichVuYeuCauElm.appendChild(dvisGiaHanElm);

        //dichvuyeucau
        Element dvisCapLaiElm = doc.createElement("isCapLai");
        dvisCapLaiElm.appendChild(doc.createTextNode(dvisCapLai));
        dichVuYeuCauElm.appendChild(dvisCapLaiElm);

        //dichvuyeucau
        Element dvisTamDungElm = doc.createElement("isTamDung");
        dvisTamDungElm.appendChild(doc.createTextNode(dvisTamDung));
        dichVuYeuCauElm.appendChild(dvisTamDungElm);

        //dichvuyeucau
        Element dvisKhoiPhucElm = doc.createElement("isKhoiPhuc");
        dvisKhoiPhucElm.appendChild(doc.createTextNode(dvisKhoiPhuc));
        dichVuYeuCauElm.appendChild(dvisKhoiPhucElm);

        //dichvuyeucau
        Element dvisThuHoiElm = doc.createElement("isThuHoi");
        dvisThuHoiElm.appendChild(doc.createTextNode(dvisThuHoi));
        dichVuYeuCauElm.appendChild(dvisThuHoiElm);

        //ThoiGianSuDung
        Element tgianSuDungElm = doc.createElement("ThoiGianSuDung");
        elmRoot.appendChild(tgianSuDungElm);

        //tgiansudung
        Element tgis1NamElm = doc.createElement("is1Nam");
        tgis1NamElm.appendChild(doc.createTextNode(tgis1Nam));
        tgianSuDungElm.appendChild(tgis1NamElm);

        //tgiansudung
        Element tgis2NamElm = doc.createElement("is2Nam");
        tgis2NamElm.appendChild(doc.createTextNode(tgis2Nam));
        tgianSuDungElm.appendChild(tgis2NamElm);

        //tgiansudung
        Element tgis3NamElm = doc.createElement("is3Nam");
        tgis3NamElm.appendChild(doc.createTextNode(tgis3Nam));
        tgianSuDungElm.appendChild(tgis3NamElm);

        //tgiansudung
        Element tgis4NamElm = doc.createElement("is4Nam");
        tgis4NamElm.appendChild(doc.createTextNode(tgis4Nam));
        tgianSuDungElm.appendChild(tgis4NamElm);

        //tgiansudung
        Element tgisKhacElm = doc.createElement("isKhac");
        tgisKhacElm.appendChild(doc.createTextNode(tgisKhac));
        tgianSuDungElm.appendChild(tgisKhacElm);
        
        //tgKhacText
        Element tgKhacTextElm = doc.createElement("ThoiGianKhacText");
        tgKhacTextElm.appendChild(doc.createTextNode(tgKhacText));
        tgianSuDungElm.appendChild(tgKhacTextElm);

//        //ThietBi
//        Element thietBiElm = doc.createElement("ThietBi");
//        elmRoot.appendChild(thietBiElm);

//        //thietbi
//        Element tbusbTokenElm = doc.createElement("usbToken");
//        tbusbTokenElm.appendChild(doc.createTextNode(tbusbToken));
//        thietBiElm.appendChild(tbusbTokenElm);
//
//        //thietbi
//        Element tbHSMElm = doc.createElement("HSM");
//        tbHSMElm.appendChild(doc.createTextNode(tbHSM));
//        thietBiElm.appendChild(tbHSMElm);

        //CertSN
        Element certSNElm = doc.createElement("CertSN");
        certSNElm.appendChild(doc.createTextNode(certSN));
        elmRoot.appendChild(certSNElm);
        
        // Thanh Pho
        Element ThanhPhoElm = doc.createElement("ThanhPho");
        ThanhPhoElm.appendChild(doc.createTextNode(thanhPho));
        elmRoot.appendChild(ThanhPhoElm);
        
        //person Ngay Thang Nam
        Element psNgayElm = doc.createElement("psNgay");
        psNgayElm.appendChild(doc.createTextNode(psNgay));
        elmRoot.appendChild(psNgayElm);
        
        Element psThangElm = doc.createElement("psThang");
        psThangElm.appendChild(doc.createTextNode(psThang));
        elmRoot.appendChild(psThangElm);
        
        Element psNamElm = doc.createElement("psNam");
        psNamElm.appendChild(doc.createTextNode(psNam));
        elmRoot.appendChild(psNamElm);
        

//        //ThoiGianDiaDiem
//        Element tgianDiaDiemElm = doc.createElement("ThoiGianDiaDiem");
//        tgianDiaDiemElm.appendChild(doc.createTextNode(tgDiaDiem));
//        elmRoot.appendChild(tgianDiaDiemElm);
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            transformer.transform(source, result);
        } catch (Exception e) {
            log.info("ERROR: {}", e.getMessage());
        }

        String xml = writer.toString();
        return xml;
    }

    public static String createXMLByConfirmation(
            String cfNgay, String cfThang, String cfNam,
            String tenKhachHang,String maSoThue, String diaChi, String soDienThoai, String hoTen, String chucVu, String certSN,
//            String tbpc, 
            String tgianSD, String subjectDN, String issuerDN
    ) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // root elements
        Document doc = docBuilder.newDocument();
        Element elmRoot = doc.createElement("Confirm");
        doc.appendChild(elmRoot);
        
        Element cfNgayElm = doc.createElement("cfNgay");
        cfNgayElm.appendChild(doc.createTextNode(cfNgay));
        elmRoot.appendChild(cfNgayElm);
        
        Element cfThangElm = doc.createElement("cfThang");
        cfThangElm.appendChild(doc.createTextNode(cfThang));
        elmRoot.appendChild(cfThangElm);
        
        Element cfNamElm = doc.createElement("cfNam");
        cfNamElm.appendChild(doc.createTextNode(cfNam));
        elmRoot.appendChild(cfNamElm);

        Element tenKhachHangElm = doc.createElement("TenKhachHang");
        tenKhachHangElm.appendChild(doc.createTextNode(tenKhachHang));
        elmRoot.appendChild(tenKhachHangElm);
        
        Element maSoThueElm = doc.createElement("MaSoThue");
        maSoThueElm.appendChild(doc.createTextNode(maSoThue));
        elmRoot.appendChild(maSoThueElm);
        
        Element diaChiElm = doc.createElement("DiaChi");
        diaChiElm.appendChild(doc.createTextNode(diaChi));
        elmRoot.appendChild(diaChiElm);
        
        Element soDienThoaiElm = doc.createElement("SoDienThoai");
        soDienThoaiElm.appendChild(doc.createTextNode(soDienThoai));
        elmRoot.appendChild(soDienThoaiElm);
        
        Element hoTenElm = doc.createElement("HoTen");
        hoTenElm.appendChild(doc.createTextNode(hoTen));
        elmRoot.appendChild(hoTenElm);
        
        Element chucVuElm = doc.createElement("ChucVu");
        chucVuElm.appendChild(doc.createTextNode(chucVu));
        elmRoot.appendChild(chucVuElm);

        //SoSerialSN
        Element certSNElm = doc.createElement("SeriesCTS");
        certSNElm.appendChild(doc.createTextNode(certSN));
        elmRoot.appendChild(certSNElm);
        
//        Element tbpcElm = doc.createElement("tbpc");
//        tbpcElm.appendChild(doc.createTextNode(tbpc));
//        elmRoot.appendChild(tbpcElm);
        
        Element tgianSDElm = doc.createElement("ThoiHanSD");
        tgianSDElm.appendChild(doc.createTextNode(tgianSD));
        elmRoot.appendChild(tgianSDElm);
        
        Element subjectDNElm = doc.createElement("SubjectDN");
        subjectDNElm.appendChild(doc.createTextNode(subjectDN));
        elmRoot.appendChild(subjectDNElm);
        
        Element issuerDNElm = doc.createElement("IssuerDN");
        issuerDNElm.appendChild(doc.createTextNode(issuerDN));
        elmRoot.appendChild(issuerDNElm);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        transformer.transform(source, result);
        String xml = result.getWriter().toString();
        return xml;
    }

    public static String createXMLByCertificate(
            String hoten, String mst, String cmndhc, String certSN,
            String tenKHCu, String tenKHMoi, String cmndhcCu, String cmndhcMoi, String diachiCu, String diachiMoi, String khacCu, String khacMoi,
            String ttHoTen, String ttChucVu, String ttSDT, String ttEmail
    ) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // root elements
        Document doc = docBuilder.newDocument();
        Element elmRoot = doc.createElement("CCTSCN");
        doc.appendChild(elmRoot);

        //HoTen
        Element hotenElm = doc.createElement("HoTen");
        hotenElm.appendChild(doc.createTextNode(hoten));
        elmRoot.appendChild(hotenElm);

        //MST
        Element mstElm = doc.createElement("MST");
        mstElm.appendChild(doc.createTextNode(mst));
        elmRoot.appendChild(mstElm);

        //CMNDHC
        Element cmndhcElm = doc.createElement("CMNDHC");
        cmndhcElm.appendChild(doc.createTextNode(cmndhc));
        elmRoot.appendChild(cmndhcElm);

        //CertSN
        Element certSNElm = doc.createElement("CertSN");
        certSNElm.appendChild(doc.createTextNode(certSN));
        elmRoot.appendChild(certSNElm);

        //ThongTinChungThuSo
        Element thongTinChungThuSoElm = doc.createElement("ThongTinChungThuSo");
        elmRoot.appendChild(thongTinChungThuSoElm);

        //thongtinchungthuso
        //TenKHCu
        Element tenKHCuElm = doc.createElement("TenKhachHangCu");
        tenKHCuElm.appendChild(doc.createTextNode(tenKHCu));
        thongTinChungThuSoElm.appendChild(tenKHCuElm);

        //thongtinchungthuso
        //TenKhachHangMoi
        Element tenKHMoiElm = doc.createElement("TenKhachHangMoi");
        tenKHMoiElm.appendChild(doc.createTextNode(tenKHMoi));
        thongTinChungThuSoElm.appendChild(tenKHMoiElm);

        //thongtinchungthuso
        //CMNDHCCu
        Element cmndhcCuElm = doc.createElement("CMNDHCCu");
        cmndhcCuElm.appendChild(doc.createTextNode(cmndhcCu));
        thongTinChungThuSoElm.appendChild(cmndhcCuElm);

        //thongtinchungthuso
        //CMNDHCMoi
        Element cmndhcMoiElm = doc.createElement("CMNDHCMoi");
        cmndhcMoiElm.appendChild(doc.createTextNode(cmndhcMoi));
        thongTinChungThuSoElm.appendChild(cmndhcMoiElm);

        //thongtinchungthuso
        //EmailCu
        Element diachiCuElm = doc.createElement("DiachiCu");
        diachiCuElm.appendChild(doc.createTextNode(diachiCu));
        thongTinChungThuSoElm.appendChild(diachiCuElm);

        //thongtinchungthuso
        //EmailMoi
        Element diachiMoiElm = doc.createElement("DiachiMoi");
        diachiMoiElm.appendChild(doc.createTextNode(diachiMoi));
        thongTinChungThuSoElm.appendChild(diachiMoiElm);

        //thongtinchungthuso
        //SDTCu
        Element sdtCuElm = doc.createElement("KhacCu");
        sdtCuElm.appendChild(doc.createTextNode(khacCu));
        thongTinChungThuSoElm.appendChild(sdtCuElm);

        //thongtinchungthuso
        //SDTMoi
        Element sdtMoiElm = doc.createElement("KhacMoi");
        sdtMoiElm.appendChild(doc.createTextNode(khacMoi));
        thongTinChungThuSoElm.appendChild(sdtMoiElm);

        //ThongTinLienHe
        Element thongTinLienHeElm = doc.createElement("ThongTinLienHe");
        elmRoot.appendChild(thongTinLienHeElm);

        //thongtinlienhe
        //HoTen
        Element ttHoTenElm = doc.createElement("HoTen");
        ttHoTenElm.appendChild(doc.createTextNode(ttHoTen));
        thongTinLienHeElm.appendChild(ttHoTenElm);

        //thongtinlienhe
        //ChucVu
        Element ttChucVuElm = doc.createElement("ChucVu");
        ttChucVuElm.appendChild(doc.createTextNode(ttChucVu));
        thongTinLienHeElm.appendChild(ttChucVuElm);

        //thongtinlienhe
        //DienThoai
        Element ttSDTElm = doc.createElement("DienThoai");
        ttSDTElm.appendChild(doc.createTextNode(ttSDT));
        thongTinLienHeElm.appendChild(ttSDTElm);

        //thongtinlienhe
        //Email
        Element ttEmailElm = doc.createElement("Email");
        ttEmailElm.appendChild(doc.createTextNode(ttEmail));
        thongTinLienHeElm.appendChild(ttEmailElm);

        //ThoiGianDiaDiem
//        Element tgDiaDiemElm = doc.createElement("ThoiGianDiaDiem");
//        tgDiaDiemElm.appendChild(doc.createTextNode(tgDiaDiem));
//        elmRoot.appendChild(tgDiaDiemElm);
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            transformer.transform(source, result);
        } catch (Exception e) {
            log.info("ERROR: {}", e.getMessage());
        }

        String xml = writer.toString();
        return xml;
    }

    public static String createStringHtmlInString(String strXslt, String strData, byte[] img,
            boolean isImg, boolean isNeedBg, int[] intResult) {
        String response = null;
        StringWriter writer = new StringWriter();
        try {
            InputStream inputXslt = new ByteArrayInputStream(strXslt.getBytes(Charset.forName("UTF-8")));
            InputStream inputData = new ByteArrayInputStream(strData.getBytes(Charset.forName("UTF-8")));
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer(
                    new javax.xml.transform.stream.StreamSource(inputXslt));
            transformer.transform(
                    new javax.xml.transform.stream.StreamSource(inputData),
                    new javax.xml.transform.stream.StreamResult(writer));
            String html = writer.toString();
            if (isImg) {
                html = html.replaceAll("@imgBg", "data:image/jpeg;base64," + Arrays.toString(img));
            }
            if (!isNeedBg) {
                html = html.replaceAll("@display", "none");
            }
            response = html;
            intResult[0] = 0;
        } catch (TransformerException ex) {
            intResult[0] = 1;
            log.info("PrintFormFunction: " + ex.getMessage(), ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                intResult[0] = 1;
                log.info("PrintFormFunction: " + ex.getMessage(), ex);

            }

        }
        return response;
    }
}
