package com.zenvia.zenviaapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

@Service
public class ZenviaService {

    @Autowired
    private ZenviaDAO dao;

    public ResponseEntity<String> sendSms(String from, Long to, String msg) throws Exception {
        return dao.sendSms(buildRequestJson(from, to, msg));
    }

    protected String buildRequestJson(String from, Long to, String msg) throws JsonProcessingException {
        Gson gson = new Gson();
        JsonElement jsonElement = gson.toJsonTree(createSms(from, to, msg));
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("sendSmsRequest", jsonElement);
        return jsonObject.toString();
    }

    protected Sms createSms(String from, Long to, String msg){
        return new Sms.Builder()
                .from(from)
                .to(to)
                .msg(msg)
                .build();
    }

}
