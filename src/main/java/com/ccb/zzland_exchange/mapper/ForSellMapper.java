package com.ccb.zzland_exchange.mapper;

import com.ccb.zzland_exchange.domain.ForSell;
import com.ccb.zzland_exchange.domain.ForSellDataParam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForSellMapper {
    /**
     * 获取待竞拍信息每次获取10条
     * @param forSellDataParam 页码信息 其中city 为 all
     * @return
     */
    List<ForSell> selectList(ForSellDataParam forSellDataParam);

    /**
     * 获取待竞拍信息中包含那些地区（用于设置城市筛选框）
     * @return
     */
    List<String> selectCity();


    /**
     * 获取待竞拍信息中条数（用于设置页码数）
     * @return
     */
    int selectCount(String city);


    /**
     * 按照城市删除
     *
     */
    void deleteList(String city);

    /**
     * 向数据库中插入爬取到的待竞拍信息
     */
    void insertForSells(List<ForSell> lists);

    /**
     * 清空ForSell表
     */
    void truncateTable();
}
