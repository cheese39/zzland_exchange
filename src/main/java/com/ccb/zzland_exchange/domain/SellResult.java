package com.ccb.zzland_exchange.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SellResult {
    //土地编号
    private String Id;
    //成交价(单位为万元)
    private float value;
    //竞得人
    private String owner;
    //所属省份
    private String city;
    //时间
    private String date;
}
