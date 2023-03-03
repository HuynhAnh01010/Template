/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.mobileid.templatedkportal.controller;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import vn.mobileid.templatedkportal.common.CommonClass;
import vn.mobileid.templatedkportal.common.CommonUtils;
import vn.mobileid.templatedkportal.entity.*;

@org.springframework.web.bind.annotation.RestController
@Slf4j
public class Controller {

    private final CommonClass commonClass;

    private final String API = "https://taxcode.icorp.vn/api/v1/tax_code/";
    private final String TOKEN = "eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ";

    @Autowired
    ResourceLoader resourceLoader;

    public Controller(CommonClass commonClass) {
        this.commonClass = commonClass;
    }

    @RequestMapping(value = "/personal", method = RequestMethod.POST)
    public ResponseEntity<?> sendPersonalInfo(@Valid @RequestBody Personal personal, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.info("POST personal");
        try {
            Cookie cookie = new Cookie("taxCode", "0");
            cookie.setSecure(true);
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            response.addCookie(cookie);

            int[] intResult = new int[1];
            InputStream inputStream = new ClassPathResource("/xslt/personal.xslt").getInputStream();

            byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
            String data = new String(bdata, StandardCharsets.UTF_8);

//            log.info("getPath: {}", data);
            String pathXSLT = data;

            String pathXML = commonClass.createXMLByPersonal(
                    personal.getTochuc_TenGiaoDich(),
                    personal.getTochuc_MST(),
                    personal.getTochuc_DiaChi(),
                    personal.getTochuc_HoTen(),
                    personal.getTochuc_ChucVu(),
                    personal.getTochuc_CMND(),
                    personal.getTochuc_NgayCap(),
                    personal.getTochuc_NoiCap(),
                    personal.getTochuc_SDT(),
                    personal.getTochuc_Email(),
                    
                    personal.getCanhan_HoTen(),
                    personal.getCanhan_ChucVu(),
                    personal.getCanhan_CMND(),
                    personal.getCanhan_NgayCap(),
                    personal.getCanhan_NoiCap(),
                    personal.getCanhan_DiaChi(),
                    personal.getCanhan_SDT(),
                    personal.getCanhan_Email(),
                    
                    personal.getCanhan(),
                    personal.getTochuc(),
                    personal.getCanhanTtochuc(),
                    personal.getCapmoi(),
                    personal.getGiahan(),
                    personal.getCaplai(),
                    personal.getTamdung(),
                    personal.getKhoiphuc(),
                    personal.getThuhoi(),
                    personal.getMotnam(),
                    personal.getHainam(),
                    personal.getBanam(),
                    personal.getBonnam(),
                    personal.getKhac(),
                    personal.getKhacText(),
//                    personal.getUsbToken(),
//                    personal.getHsm(),
                    personal.getSeries_CTS(),
                    personal.getPsThanhPho(),
                    personal.getPsNgay(),
                    personal.getPsThang(),
                    personal.getPsNam()
            );

//            log.info("pathXSLT: {}", pathXSLT);
//            log.info("=======================================");
//            log.info("pathXML: {}", pathXML);
            String strView;
            if (!"".equals(pathXSLT)) {
                String base64Image = "HAaoisaoisoas....";
                pathXSLT = pathXSLT.replace("{FLOATING_LOGO}", base64Image);
                pathXSLT = pathXSLT.replace("{BACKGROUD_LOGO}", base64Image);
                pathXSLT = pathXSLT.replace("{CA_NAME}", "I-CA");

//                log.info("pathXSLT: {}", pathXML);
                String sResultHTML = commonClass.createStringHtmlInString(pathXSLT, pathXML, null, false, false, intResult);
//                log.info("sResultHTML: {}", sResultHTML);
                if (intResult[0] == 0) {
                    strView = sResultHTML;

//                    log.info("strView: {}", strView);
                    return new ResponseEntity<>(strView, HttpStatus.OK);
                } else {
                    strView = "ERROR###0";
                    return new ResponseEntity<>(strView, HttpStatus.NOT_FOUND);
                }
            } else {
                strView = "NO_DATA###0";
                return new ResponseEntity<>(strView, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping(value = "/confirmation")
    public ResponseEntity<?> sendConfirmationInfo(@Valid @RequestBody Confirmation confirmation, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
//            log.info("confirmation: {}", CommonUtils.convertObjectToString(confirmation));
            int[] intResult = new int[1];
//            Resource resource = resourceLoader.getResource("classpath:resources/xslt/confirmation.xslt");
//            InputStream inputStream = resource.getInputStream();

            InputStream inputStream = new ClassPathResource("/xslt/confirmation.xslt").getInputStream();

            byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
            String data = new String(bdata, StandardCharsets.UTF_8);

//            log.info("getPath: {}", data);
            String pathXSLT = data;

            String pathXML = commonClass.createXMLByConfirmation(
                    confirmation.getCfNgay(),
                    confirmation.getCfThang(),
                    confirmation.getCfNam(),
                    confirmation.getTenKhachHang(),
                    confirmation.getMaSoThue(),
                    confirmation.getDiaChi(),
                    confirmation.getSdt(),
                    confirmation.getHoTen(),
                    confirmation.getChucVu(),
                    confirmation.getSeries_cts(),
//                    confirmation.getTbpc(),
                    confirmation.getTgiansd(),
                    confirmation.getSubject_DN(),
                    confirmation.getIssuer_DN()
            );

//            log.info("pathXSLT: {}", pathXSLT);
//            log.info("=======================================");
//            log.info("pathXML: {}", pathXML);
            String strView;
            if (!"".equals(pathXSLT)) {
                String base64Image = "HAaoisaoisoas....";
                pathXSLT = pathXSLT.replace("{FLOATING_LOGO}", base64Image);
                pathXSLT = pathXSLT.replace("{BACKGROUD_LOGO}", base64Image);
                pathXSLT = pathXSLT.replace("{CA_NAME}", "I-CA");

//                log.info("pathXSLT: {}", pathXML);
                String sResultHTML = commonClass.createStringHtmlInString(pathXSLT, pathXML, null, false, false, intResult);
//                log.info("sResultHTML: {}", sResultHTML);
                if (intResult[0] == 0) {
                    strView = sResultHTML;

//                    log.info("strView CONFIRM: {}", strView);
                    return new ResponseEntity<>(strView, HttpStatus.OK);
                } else {
                    strView = "ERROR###0";
                    return new ResponseEntity<>(strView, HttpStatus.NOT_FOUND);
                }
            } else {
                strView = "NO_DATA###0";
                return new ResponseEntity<>(strView, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/change-certificate")
    public ResponseEntity<?> sendCertificateInfo(@Valid @RequestBody Certificate certificate, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            int[] intResult = new int[1];
//            log.info("personal: {}", CommonUtils.convertObjectToString(certificate));
//            Resource resource = resourceLoader.getResource("classpath:resources/xslt/certificate.xslt");
//            InputStream inputStream = resource.getInputStream();

            InputStream inputStream = new ClassPathResource("/xslt/certificate.xslt").getInputStream();

            byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
            String data = new String(bdata, StandardCharsets.UTF_8);

//            log.info("getPath: {}", data);
            String pathXSLT = data;

            String pathXML = commonClass.createXMLByCertificate(
                    certificate.getHoten(),
                    certificate.getMst(),
                    certificate.getCmndhc(),
                    certificate.getCertSN(),
                    certificate.getTenKHCu(),
                    certificate.getTenKHMoi(),
                    certificate.getCmndHCCu(),
                    certificate.getCmndHCMoi(),
                    certificate.getDiachiCu(),
                    certificate.getDiachiMoi(),
                    certificate.getKhacCu(),
                    certificate.getKhacMoi(),
                    certificate.getTtHoten(),
                    certificate.getTtChucvu(),
                    certificate.getTtSdt(),
                    certificate.getTtEmail()
            );

//            log.info("pathXSLT: {}", pathXSLT);
//            log.info("=======================================");
//            log.info("pathXML: {}", pathXML);
            String strView;
            if (!"".equals(pathXSLT)) {
                String base64Image = "HAaoisaoisoas....";
                pathXSLT = pathXSLT.replace("{FLOATING_LOGO}", base64Image);
                pathXSLT = pathXSLT.replace("{BACKGROUD_LOGO}", base64Image);
                pathXSLT = pathXSLT.replace("{CA_NAME}", "I-CA");

                String sResultHTML = commonClass.createStringHtmlInString(pathXSLT, pathXML, null, false, false, intResult);
                if (intResult[0] == 0) {
                    strView = sResultHTML;

//                    log.info("strView DK03: {}", strView);
                    return new ResponseEntity<>(strView, HttpStatus.OK);
                } else {
                    strView = "ERROR###0";
                    return new ResponseEntity<>(strView, HttpStatus.NOT_FOUND);
                }
            } else {
                strView = "NO_DATA###0";
                return new ResponseEntity<>(strView, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<?> getCompany(
            @RequestBody Map<String, String> mapData,
            HttpServletResponse response, HttpServletRequest request) throws Exception {
        try {

            log.info("TAX CODE: {}", mapData.get("tax_code"));
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + TOKEN);
            headers.setContentType(MediaType.APPLICATION_JSON);
            
            JSONObject jsonData = new JSONObject();
            jsonData.put("lang", "vi");

            RestTemplate restTemplate = new RestTemplate();

            String tax_code = String.valueOf(mapData.get("tax_code"));
            
            HttpEntity<String> requestData = new HttpEntity<String>(jsonData.toString(), headers);

            ResponseEntity<Map> reEntity = restTemplate.exchange(API + "?q=" + tax_code + "&lang=vi",
                    HttpMethod.GET, requestData, Map.class);

            log.info("RES ENTIRY: {}", CommonUtils.convertObjectToString(reEntity.getBody()));
            return new ResponseEntity<>(reEntity, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("ERROR: {}", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

//    @PostMapping(value = "/searchCompany")
//    public ResponseEntity<?> searchCompany(HttpServletRequest request, HttpServletResponse response, @Valid @RequestBody Search searchMST) {
//        try {
//            SSLUtilities.trustAllHttpsCertificates();
//            SSLUtilities.trustAllHostnames();
//
//            EnterpriseInfo enterpriseInfo = new EnterpriseInfo();
//            URLConnection connection = new URL("https://www.tratencongty.com/search/" + searchMST.getIdSearchMST()).openConnection();
//            connection.addRequestProperty("User-Agent",
//                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
//            Scanner scanner = new Scanner(connection.getInputStream());
//            scanner.useDelimiter("\\Z");
//            String content = scanner.next();
//            scanner.close();
//
//            enterpriseInfo = getLink(content, enterpriseInfo);
//
//            log.info("Get Link: {}", enterpriseInfo.getLink());
//            log.info("Get Name: {}", enterpriseInfo.getName());
//            log.info("Get TaxCode: {}", enterpriseInfo.getTaxCode());
//            log.info("Get Địa chỉ: {}", enterpriseInfo.getAddress());
//            log.info("Get Đại diện pháp luật: {}", enterpriseInfo.getPresentativeName());
//
//            Cookie cookieTc = new Cookie("taxCode", enterpriseInfo.getTaxCode());
//            cookieTc.setSecure(true);
//            cookieTc.setHttpOnly(true);
//            cookieTc.setPath("/");
//            response.addCookie(cookieTc);
//
//            return new ResponseEntity<>(enterpriseInfo, HttpStatus.OK);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return new ResponseEntity<>(null, HttpStatus.SERVICE_UNAVAILABLE);
//    }
    private static EnterpriseInfo getLink(String html, EnterpriseInfo enterpriseInfo) {
        Document doc = Jsoup.parse(html);
        Element links = doc.select("div.search-results").first();
        enterpriseInfo.setLink(links.select("a").attr("href"));
        enterpriseInfo.setName(links.select("a").first().text());
        enterpriseInfo.setTaxCode(links.select("p").select("a").text());
        String content1 = links.select("p").text();
        log.info("content1: {}", content1);
        String oldValue5 = "Địa chỉ:";
        String oldValue6 = "Đại diện pháp luật:";

//        System.out.println(content1);
        int position5 = content1.indexOf(oldValue5);
        int position6 = content1.indexOf(oldValue6);
        log.info("POSITION5: {}", position5);
        log.info("POSITION6: {}", position6);

        if (position6 > -1) {
//            System.out.println(position5 - position6);
            String amountString = content1.substring(position6 + oldValue6.length(), position5);
//            System.out.println(amountString);
            enterpriseInfo.setPresentativeName(amountString.replace(oldValue5, "").replace("\r", "").replace("\t", "").replace("<br/>", "").replace("<br>", "").trim());

        }
        if (position5 > -1) {
            String amountString = content1.substring(position5 + oldValue5.length(), content1.length());
            amountString = amountString.replace(oldValue5, "").replace("</p>", "").replace("</div>", "").replace("\r", "").replace("\t", "").replace("<br/>", "").replace("<br>", "").trim();

            enterpriseInfo.setAddress(amountString.lastIndexOf("Việt Nam") > -1 ? amountString : amountString + ", Việt Nam");

        }
        return enterpriseInfo;
    }
}
