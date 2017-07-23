package com.zenvia.zenviaapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class ZenviaController {

    @Autowired
    private ZenviaService service;

    @RequestMapping("/send-sms")
    @ResponseBody
    public String sendSms(@RequestParam("from") String from,
                          @RequestParam("to") Long to,
                          @RequestParam("msg") String msg) throws Exception {

        return service.sendSms(from, to, msg).getBody();
    }


    public static void main(String[] args) {
        SpringApplication.run(ZenviaController.class, args);
    }


}
