/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.mobileid.templatedkportal.controller;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import vn.mobileid.templatedkportal.common.CommonUtils;
import vn.mobileid.templatedkportal.entity.EnterpriseInfo;
import vn.mobileid.templatedkportal.utils.SSLUtilities;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Scanner;

@Controller
@Slf4j
public class HomeController {

    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("personal", "header-link active");
        model.addAttribute("confirmation", "header-link");
        model.addAttribute("certificate", "header-link");
        return "index";
    }

    private final String API = "https://taxcode.icorp.vn/api/v1/tax_code/";

    @GetMapping(value = "/personal")
    public String getPersonal(Model model,
            HttpServletRequest request,
            HttpServletResponse response) {
        model.addAttribute("personal", "header-link active");
        model.addAttribute("confirmation", "header-link");
        model.addAttribute("certificate", "header-link");

        return "index";
    }

    @GetMapping(value = "/confirmation")
    public String getConfirmation(Model model,
            HttpServletRequest request,
            HttpServletResponse response) {

        model.addAttribute("personal", "header-link");
        model.addAttribute("confirmation", "header-link active");
        model.addAttribute("certificate", "header-link");
        return "confirmation";
    }

    @GetMapping(value = "/revision-paper")
    public String getCertificate(Model model,
            HttpServletRequest request,
            HttpServletResponse response) {
        model.addAttribute("personal", "header-link");
        model.addAttribute("confirmation", "header-link");
        model.addAttribute("certificate", "header-link active");
        return "certificate";
    }


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
