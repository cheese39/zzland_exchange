package com.ccb.zzland_exchange.controller;

import com.ccb.zzland_exchange.service.SpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SpiderController {
    @Autowired
    private SpiderService service;

    @RequestMapping("/work")
    public boolean work() {
        boolean flag = false;
        try {
            flag = service.beginWork();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
