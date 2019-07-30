package com.ccb.zzland_exchange.service;

import com.ccb.zzland_exchange.domain.ForSell;
import com.ccb.zzland_exchange.domain.ForSellDataParam;
import com.ccb.zzland_exchange.mapper.ForSellMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForSellService {

    @Autowired
    private ForSellMapper mapper;


    public List<ForSell> getMessages(int num, String city) {
        int pageNum = (num - 1) * 10 + 1;
        ForSellDataParam param = new ForSellDataParam(pageNum, pageNum + 9, city);
        return mapper.selectList(param);
    }


    public List<String> getCity() {
        return mapper.selectCity();
    }

    public int getCount(String city) {
        return mapper.selectCount(city);
    }

    public void test(){
        mapper.truncateTable();
    }
}
