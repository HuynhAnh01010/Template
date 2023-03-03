package vn.mobileid.templatedkportal.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.json.JSONObject;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import static org.slf4j.MDC.get;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import vn.mobileid.templatedkportal.utils.ApiResult;
import vn.mobileid.templatedkportal.utils.CommonUtil;
import vn.mobileid.templatedkportal.utils.SSLUtilities;

@Service
@Slf4j
public class CallApiICAService {

    private final String API = "https://taxcode.icorp.vn/api/v1";
    private final String TOKEN = "eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ";

    private final ResourceLoader resourceLoader;

    public CallApiICAService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public ApiResult getCompany(JSONObject json, HttpServletRequest rq) {
        return getApiResult(json, rq, API, HttpMethod.GET);
    }
    
    private String getCookieLanguage(HttpServletRequest request) {
        try {
            Cookie[] cookies = request.getCookies();
            for (int i = 0; i < cookies.length; i++) {
                log.info("{} - {} ", cookies[i].getName(), cookies[i].getValue());
                if ("NG_TRANSLATE_LANG_KEY".equalsIgnoreCase(cookies[i].getName())) {
                    log.info("key: {}", cookies[i].getValue());
                    if ("%22en%22".equalsIgnoreCase(cookies[i].getValue())) {
                        return "EN";
                    } else {
                        return "VN";
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
        }
        return "EN";
    }
    
    private ApiResult getApiResult(JSONObject jsonData, HttpServletRequest rq, String url, HttpMethod method){
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", "Bearer " + TOKEN);
            jsonData.put("lang", getCookieLanguage(rq));
            HttpEntity<String> reqEntity = new HttpEntity<String>(jsonData.toString(), headers);
            
            return commonRequest(reqEntity, url, method);
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResult.fail(e.getMessage());
        }
    }

    private ApiResult commonRequest(HttpEntity<String> request, String url, HttpMethod method) {
        try {
            SSLUtilities.trustAllHostnames();
            SSLUtilities.trustAllHttpsCertificates();
            RestTemplate restTemplate = new RestTemplate();
            log.info("RESTTEMPLATE: {}", restTemplate);
            log.info("URL FULL: {}", API + url);
            log.info("request  url {}: {}", url, CommonUtil.convertObjectToString(request));
            ResponseEntity<Map> response = restTemplate.exchange(API + url, method, request, Map.class);
            
            return ApiResult.success(response.getBody());
        } catch (HttpStatusCodeException e) {
            e.printStackTrace();
            log.error("httpStatus Exception: {}", e.getMessage());
            return ApiResult.fail(e.getMessage());
        } catch (RestClientException e) {
            e.printStackTrace();
            log.error("REST Client Exception: {}", e.getMessage());
            return ApiResult.fail(e.getMessage());
        }
    }

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ResponseICA {
        private String accessToken;
        private String tax_Code;
        private String message;
    }
}
