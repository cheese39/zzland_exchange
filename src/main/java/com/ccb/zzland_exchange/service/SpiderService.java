package com.ccb.zzland_exchange.service;

import com.ccb.zzland_exchange.domain.ForSell;
import com.ccb.zzland_exchange.domain.SellResult;
import com.ccb.zzland_exchange.mapper.ForSellMapper;
import com.ccb.zzland_exchange.mapper.SellResultMapper;
import com.ccb.zzland_exchange.util.SpiderFileUtil;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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


//    @Transactional
//    List<ForSell> insertForSell(){
//        SqlSession session =  SqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH,false);
//    }

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
                if (lists.size() != 0) {
                    forSellMapper.insertForSells(lists);
                }else {
                    System.out.println("发现空文件" + f.getName());
                }

            } else if (type.equals("r")) {
                List<SellResult> lists = SpiderFileUtil.dealRData(f, city);
                if (lists.size() != 0) {
                    sellResultMapper.insertForSells(lists);
                }else {
                    System.out.println("发现空文件" + f.getName());
                }
            }
            f.delete();
        }
        return true;
    }
}
