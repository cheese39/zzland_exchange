package com.ccb.zzland_exchange.service;

import com.ccb.zzland_exchange.domain.SellResult;
import com.ccb.zzland_exchange.domain.SellResultDataParam;
import com.ccb.zzland_exchange.mapper.SellResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellResultService {
    @Autowired
    private SellResultMapper mapper;

    public List<SellResult> getMessages(int num, String city, String month){
        int pageNum = (num - 1) * 10 + 1;
        SellResultDataParam param = new SellResultDataParam(pageNum, pageNum + 9,city, month);
        return mapper.selectList(param);

    }

    public List<String> getCity(String month){
        return mapper.selectCity(month);
    }

    public int getCount(String city,String month){
        SellResultDataParam param = new SellResultDataParam(0, 0, city, month);
        return mapper.selectCount(param);
    }

    public List<String> getMonth(String city){return mapper.selectMonth(city);}

}
