package com.ccb.zzland_exchange.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String viewIndex(){
        return "home";
    }
}
