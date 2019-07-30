package com.ccb.zzland_exchange.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class SellResultDataParam {
    private int up;
    private int down;
    private String city;
    private String month;
}
