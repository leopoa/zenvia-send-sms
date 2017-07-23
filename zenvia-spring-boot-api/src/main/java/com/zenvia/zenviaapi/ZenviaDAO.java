package com.zenvia.zenviaapi;


import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;

@Component
public class ZenviaDAO {

    @Value("${send.sms}")
    private String uri;

    @Value("${username}")
    private String user;

    @Value("${password}")
    private String password;


    public ResponseEntity<String> sendSms(String request) throws Exception {
        HttpEntity<String> entity = new HttpEntity<>(request, createHeader());
        return new RestTemplate().exchange(uri, HttpMethod.POST, entity, String.class);
    }

    private HttpHeaders createHeader() throws UnsupportedEncodingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String auth = user + ":" + password;
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes("UTF-8"));
        String authHeader = "Basic " + new String(encodedAuth);
        headers.set("Authorization", authHeader);
        return headers;
    }
}
