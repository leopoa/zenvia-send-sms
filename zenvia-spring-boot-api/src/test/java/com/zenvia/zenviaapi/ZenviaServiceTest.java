package com.zenvia.zenviaapi;


import static org.junit.Assert.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;

public class ZenviaServiceTest {

    ZenviaService service;

    @Before
    public void setUp(){
        service = new ZenviaService();
    }

    @Test
    public void buildRequestJsonTest() throws JsonProcessingException {
        assertNotNull(service.buildRequestJson("Amarilho", 5551999999999l, "test123"));
    }

    @Test
    public void createSmsTest(){
        String from = "Amarilho";
        Long to = 5551999999999l;
        String msg = "test 123";

        Sms sms = service.createSms(from, to, msg);

        assertEquals(from , sms.getFrom());
        assertEquals(to , sms.getTo());
        assertEquals(msg , sms.getMsg());
    }
}
