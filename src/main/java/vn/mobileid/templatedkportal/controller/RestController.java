package vn.mobileid.templatedkportal.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import vn.mobileid.templatedkportal.common.CommonUtils;
import vn.mobileid.templatedkportal.entity.Search;
import vn.mobileid.templatedkportal.service.CallApiICAService;

@org.springframework.web.bind.annotation.RestController
@Slf4j
public class RestController {

    private final CallApiICAService callApiICAService;

    

    public RestController(CallApiICAService callApiICAService) {
        this.callApiICAService = callApiICAService;
    }

    
}
