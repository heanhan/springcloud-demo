package com.example.bank2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author : zhaojh
 * @date : 2019-12-11
 * @function :
 */

@RestController
@RequestMapping(value = "/bank2")
public class ZipBank2HiApplication {

    private static final Logger LOG = Logger.getLogger(ZipBank2HiApplication.class.getName());

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String home(){
        LOG.log(Level.INFO, "hi is being called");
        return "hi i'm miya!";
    }

    @RequestMapping("/miya")
    public String info(){
        LOG.log(Level.INFO, "info is being called");
        return restTemplate.getForObject("http://SPRINGCLOUD-BANK1/bank1/info",String.class);
    }
}
