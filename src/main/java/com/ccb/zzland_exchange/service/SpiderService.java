package com.ccb.zzland_exchange.service;

import com.ccb.zzland_exchange.domain.ForSell;
import com.ccb.zzland_exchange.domain.SellResult;
import com.ccb.zzland_exchange.mapper.ForSellMapper;
import com.ccb.zzland_exchange.mapper.SellResultMapper;
import com.ccb.zzland_exchange.util.SpiderFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class SpiderService {

    @Autowired
    private ForSellMapper forSellMapper;

    @Autowired
    private SellResultMapper sellResultMapper;

    @Value("${spider.data.path}")
    private String dataPath;

    public boolean beginWork(){
        //清空待竞拍和中标信息表
        forSellMapper.truncateTable();
        sellResultMapper.truncateTable();


        FileSystemResource fsr = new FileSystemResource(dataPath);
        File root = fsr.getFile();
        File[] dataFiles = root.listFiles();
        assert dataFiles != null;
        for (File f : dataFiles)
        {
            String filename = f.getName();
            String city = filename.split("-")[0];
            String type = filename.split("-")[1];
            if (type.equals("s")) {
                List<ForSell> lists = SpiderFileUtil.dealSData(f, city);
                forSellMapper.insertForSells(lists);
            } else if (type.equals("r")) {
                List<SellResult> lists = SpiderFileUtil.dealRData(f, city);
                sellResultMapper.insertForSells(lists);
            }
            f.delete();
        }
        return true;
    }
}
