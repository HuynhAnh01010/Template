package vn.mobileid.templatedkportal.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommonUtils {

    public static String convertObjectToString(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        String str = "";
        try {
            str = objectMapper.writeValueAsString(obj);
            ;
        } catch (Exception ex) {
            log.error("CommonUtil: {}", ex.getMessage());
        }
        return str;
    }
}
