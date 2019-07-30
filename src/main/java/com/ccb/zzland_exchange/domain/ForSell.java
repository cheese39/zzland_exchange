package com.ccb.zzland_exchange.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ForSell {
    //土地编号
    private String Id;
    //所属地市
    private String city;
    //截止日期
    private String deadline;
}
