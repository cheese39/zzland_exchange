package com.ccb.zzland_exchange.controller;

import com.ccb.zzland_exchange.domain.ForSell;
import com.ccb.zzland_exchange.service.ForSellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/ForSell")
public class ForSellController {
    @Autowired
    private ForSellService service;

    @RequestMapping("/data")
    public List<ForSell> data(@RequestParam("page")int num,@RequestParam("city") String city){
        return service.getMessages(num,city);
    }

    @GetMapping("/cities")
    public List<String> cities(){
        return service.getCity();
    }

    @RequestMapping("/count")
    public int count(@RequestParam("city") String city){
        return service.getCount(city);
    }
}
