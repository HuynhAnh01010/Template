package vn.mobileid.templatedkportal.controller;


import lombok.extern.slf4j.Slf4j;
import vn.mobileid.templatedkportal.entity.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

@Slf4j
public class GetEnterpriseInfo {

    EnterpriseInfo enterpriseInfo;

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
