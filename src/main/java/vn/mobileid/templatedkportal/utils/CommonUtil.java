/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.mobileid.templatedkportal.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author Mobile ID 21
 */
@Slf4j
public class CommonUtil {
    public static String convertObjectToString(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        String str = "";
        try {
            str = objectMapper.writeValueAsString(obj);
            ;
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return str;
    }
}
