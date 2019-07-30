package com.ccb.zzland_exchange.controller;

import com.ccb.zzland_exchange.domain.SellResult;
import com.ccb.zzland_exchange.service.SellResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/SellResult/{month}")
public class SellResultController {
    @Autowired
    private SellResultService sellResultService;

    @RequestMapping("/data")
    public List<SellResult> data(@RequestParam("page")int num, @RequestParam("city") String city, @PathVariable("month")String month){
        return sellResultService.getMessages(num,city,month);
    }

    @RequestMapping("/cities")
    public List<String> cities(@PathVariable("month")String month){
        return  sellResultService.getCity(month);
    }

    @RequestMapping("/count")
    public int count(@RequestParam("city") String city,@PathVariable("month")String month){
        return  sellResultService.getCount(city,month);
    }

    @RequestMapping("/month")
    public List<String> month(@RequestParam("city") String city){return  sellResultService.getMonth(city);}
}
