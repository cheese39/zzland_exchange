package com.ccb.zzland_exchange.util;

import com.ccb.zzland_exchange.domain.ForSell;
import com.ccb.zzland_exchange.domain.SellResult;
import com.ccb.zzland_exchange.mapper.ForSellMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SpiderFileUtil {
    /**
     * 处理待竞拍信息
     *
     * @param f
     * @param city
     * @return
     */
    public static List<ForSell> dealSData(File f, String city) {
        List<ForSell> lists = new ArrayList<>();
        if (f.canWrite()) {
            Path path = Paths.get(f.getPath());
            try {
                List<String> datas = Files.readAllLines(path);
                for (String data : datas) {
                    String[] items = data.split(",");
                    if (items.length == 2) {
                        ForSell fs = new ForSell(items[0], city, items[1]);
                        lists.add(fs);
                    } else {
                        System.out.println("发现错误数据:" + data);
                    }

                }
                return lists;
            } catch (IOException e) {
                System.out.println("读取文件:" + path.getFileName() + "发生错误");
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 处理中标信息
     *
     * @param f
     * @param city
     * @return
     */
    public static List<SellResult> dealRData(File f, String city) {
        List<SellResult> lists = new ArrayList<>();
        if (f.canWrite()) {
            Path path = Paths.get(f.getPath());
            try {
                List<String> datas = Files.readAllLines(path);
                for (String data : datas) {
                    String[] items = data.split(",");
                    if (items.length == 4) {
                        SellResult fs = new SellResult(items[0], Float.parseFloat(items[1]),
                                items[2], city, items[3]);
                        lists.add(fs);
                    } else {
                        System.out.println("发现错误数据:" + data);
                    }
                }
                return lists;
            } catch (IOException e) {
                System.out.println("读取文件:" + path.getFileName() + "发生错误");
                e.printStackTrace();
            }
        }
        return null;
    }
}
