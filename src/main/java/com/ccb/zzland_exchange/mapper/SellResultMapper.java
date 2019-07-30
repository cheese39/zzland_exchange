package com.ccb.zzland_exchange.mapper;

import com.ccb.zzland_exchange.domain.ForSell;
import com.ccb.zzland_exchange.domain.SellResult;
import com.ccb.zzland_exchange.domain.SellResultDataParam;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface SellResultMapper {
    /**
     * 获取中标信息每次获取10条
     * @param sellResultDataParam 页码信息 其中city 为 all,month为all
     * @return
     */
    List<SellResult> selectList(SellResultDataParam sellResultDataParam);


    /**
     * 获取中标信息中包含那些地区（用于设置城市筛选框）
     * @return
     */
    List<String> selectCity(String month);


    /**
     * 获取中标信息中条数（用于设置页码数）
     * @return
     */
    int selectCount(SellResultDataParam param);

    /**
     * 获取中标信息所包含的月份（用于设置月份筛选框）
     * @return
     */
    List<String> selectMonth(String city);

    /**
     * 向数据库中插入爬取到的中标信息
     */
    void insertForSells(List<SellResult> lists);

    /**
     * 清空SellResult表
     */
    void truncateTable();
}
